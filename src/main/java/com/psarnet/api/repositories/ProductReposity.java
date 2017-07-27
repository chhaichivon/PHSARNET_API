package com.psarnet.api.repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.psarnet.api.entities.Product;
import com.psarnet.api.entities.input.ProductLists;
import com.psarnet.api.entities.util.Pagination;
import com.psarnet.api.entities.util.ProductFilter;
import com.psarnet.api.repositories.sqlbuilder.ProductSqlBuilder;

/*import pagination.repository.UserRepository.SQL;
import pagination.util.UserFilter;*/

@Repository
public interface ProductReposity {
	
	String add_products = "<script>"
								+ "INSERT INTO phsar_product("
								+ "		sub_two_fk_id, "
								+ "		source_category_fk_id, "
								+ "		title, price, "
								+ "		image, "
								+ "		url) "
								+ "SELECT "
								+ "<foreach collection='products' item='product' separator=' UNION SELECT '> "
									+ "#{product.subtwoCategory.subtwocategoryid}::integer, "
									+ "#{product.sourceCategory.sourcecategoryid}::integer, "
									+ "#{product.title}, "
									+ "#{product.price}, "
									+" (SELECT DISTINCT s.prefix_image || #{product.image} FROM phsar_source s left join phsar_source_category sc ON s.source_pk_id = sc.source_fk_id WHERE s.source_pk_id = #{product.sourceCategory.source.sourceid}), "
									+ "(SELECT DISTINCT s.prefix_link || #{product.url} FROM phsar_source s LEFT JOIN phsar_source_category sc ON s.source_pk_id = sc.source_fk_id WHERE s.source_pk_id = #{product.sourceCategory.source.sourceid})"
									+ " WHERE NOT EXISTS"
									+ "	("
									+ "	 SELECT url FROM phsar_product WHERE url = (SELECT DISTINCT s.prefix_link || #{product.url} FROM phsar_source s LEFT JOIN phsar_source_category sc ON s.source_pk_id = sc.source_fk_id WHERE s.source_pk_id = #{product.sourceCategory.source.sourceid})"
									+ " )  "
								+ "</foreach>"
						+"</script>";
	@Results(value={
			@Result(property="productid", column="product_pk_id"),
			@Result(property="title", column="title"),
			@Result(property="price", column="price"),
			@Result(property="image", column="image"),
			@Result(property="url", column="url"),
			@Result(property="description", column="description"),
			@Result(property="datecreate", column="date_create"),
			@Result(property="userId", column="user_fk_id"),
			@Result(property="subtwoCategory.categoryname", column="category_name"),
			@Result(property="sourceCategory.source.logo", column="logo"),
			@Result(property="sourceCategory.source.domain", column="domain")
	})
	@SelectProvider(type = ProductSqlBuilder.class, method = "getALLProducts")
	public ArrayList<Product> getALLProducts(@Param("userId") int userid, @Param("pagin") Pagination pagin);
	
	@SelectProvider(type = ProductSqlBuilder.class, method = "countALLProducts")
	public long countALLProducts();
	
	@Results(value={
			@Result(property="title", column="title"),
			@Result(property="price", column="price"),
			@Result(property="image", column="image"),
			@Result(property="sourceCategory.source.logo", column="logo")
	})
	@SelectProvider(type = ProductSqlBuilder.class, method = "getProductsByCurrentDate")
	public ArrayList<Product> getProductsByCurrentDate(String current_date);
	
	@Results(value={
			@Result(property="title", column="title"),
			@Result(property="price", column="price"),
			@Result(property="image", column="image"),
			@Result(property="url", column="url"),
			@Result(property="userId", column="user_fk_id"),
			@Result(property="description", column="description"),
			@Result(property="datecreate", column="date_create"),
			@Result(property="subtwoCategory.categoryname", column="category_name")
	})
	
	@SelectProvider(type = ProductSqlBuilder.class, method = "findProductsByTitle")
	public ArrayList<Product> findProductsByTitle(@Param("userId")int userid, int category_id, String title, @Param("pagin") Pagination pagin);
	
	@SelectProvider(type = ProductSqlBuilder.class, method = "countProductsByTitle")
	public long countProductsByTitle(int category_id, String title);

	@Results(value={
			@Result(property="title", column="title"),
			@Result(property="price", column="price"),
			@Result(property="image", column="image"),
			@Result(property="url", column="url"),
			@Result(property="datecreate", column="date_create"),
			@Result(property="userId", column="user_fk_id"),
			@Result(property="subtwoCategory.categoryname", column="category_name"),
			@Result(property="sourceCategory.source.domain", column="domain"),
			@Result(property="sourceCategory.source.logo", column="logo")
	}) 
	@SelectProvider(type = ProductSqlBuilder.class, method = "findProductBySubCategory")
	public ArrayList<Product> findProductBySubCategory(@Param("userId") int userid, int id, @Param("pagin") Pagination pagin);
	
	@SelectProvider(type = ProductSqlBuilder.class, method = "countProductBySubCategory")
	public long countProductBySubCategory(int id);
	
	@SelectProvider(type = ProductSqlBuilder.class, method = "findProductByFilter")
	@Results(value={
			@Result(property="productid", column="product_pk_id"),
			@Result(property="title", column="title"),
			@Result(property="price", column="price"),
			@Result(property="image", column="image"),
			@Result(property="url", column="url"),
			@Result(property="datecreate", column="date_create"),
			@Result(property="userId", column="user_fk_id"),
			@Result(property="subtwoCategory.categoryname", column="category_name"),
			@Result(property="sourceCategory.source.logo", column="logo"),
			@Result(property="sourceCategory.source.domain", column="domain")
	})
	public ArrayList<Product> findProductByFilter(@Param("userId") int userid, int mainid, String title, int subid,int sourceid, double start_price, double price, @Param("pagin") Pagination pagin);
	
	@SelectProvider(type = ProductSqlBuilder.class, method = "countProductByFilter")
	public long countProductByFilter(int mainid, String title, int subid,int sourceid, double start_price, double price);
	
	
	/**
	 * Search product by website
	 * @param id
	 * @param pagin
	 * @return Product LIST
	 */
	@Results(value={
			@Result(property="productid", column="product_pk_id"),
			@Result(property="title", column="title"),
			@Result(property="price", column="price"),
			@Result(property="image", column="image"),
			@Result(property="url", column="url"),
			@Result(property="datecreate", column="date_create"),
			@Result(property="userId", column="user_fk_id"),
			@Result(property="subtwoCategory.categoryname", column="category_name"),
			@Result(property="sourceCategory.source.domain", column="domain"),
			@Result(property="sourceCategory.source.logo", column="logo")
	})
	@SelectProvider(type = ProductSqlBuilder.class, method = "findProductByWebSite")
	public ArrayList<Product> findProductByWebSite(@Param("userId") int userid, @Param("sourceid") int sourceid,@Param("subcategoryid") int subcategoryid, @Param("pagin") Pagination pagin);
	
	/**
	 * Count product that search by website
	 * @param id
	 * @return total product found...
	 */
	@SelectProvider(type = ProductSqlBuilder.class, method = "countProductByFindWebSite")
	public long countProductByFindWebSite(@Param("sourceid") int sourceid, @Param("subcategoryid") int subcategoryid);

	
	/**
	 * Create multiple product 
	 * @param products
	 * @return number of row have been created
	 */
	@Insert(add_products)
	public int addProducts(@Param("products") List<Product> products);
	
	/**
	 * Delete product
	 * @param id
	 * @return @return number of row have been deleted
	 */
	@DeleteProvider(type = ProductSqlBuilder.class, method = "deleteProductById")
	public int deleteProductById(int id);
	
	

	@Results(value={
			@Result(property="productid", column="product_pk_id"),
			@Result(property="title", column="title"),
			@Result(property="price", column="price"),
			@Result(property="image", column="image"),
			@Result(property="url", column="url"),
			@Result(property="description", column="description"),
			@Result(property="datecreate", column="date_create"),
			@Result(property="userId", column="user_fk_id"),
			@Result(property="subtwoCategory.categoryname", column="category_name"),
			@Result(property="sourceCategory.source.logo", column="logo"),
			@Result(property="sourceCategory.source.domain", column="domain")
	})
	@SelectProvider(type = ProductSqlBuilder.class, method = "getProductByHistory")
	public ArrayList<Product> getProductByHistory(@Param("userId") int userid, @Param("pagin") Pagination pagin);
	
	@SelectProvider(type = ProductSqlBuilder.class, method = "countProductByHistory")
	public long countProductByHistory();
	
	
}
