package com.psarnet.api.repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.psarnet.api.entities.ProductTemperory;
import com.psarnet.api.entities.util.Pagination;
import com.psarnet.api.repositories.sqlbuilder.ProductTmpSqlBuilder;

@Repository
public interface ProductTemperoryRepository {
	
	final String c_pro = "<script>"
							+ "INSERT INTO phsar_product_temperory("
							+ "		 "
							+ "		source_category_fk_id, "
							+ "		title, price, "
							+ "		image, "
							+ "		url, sub_two_fk_id) "
							+ "SELECT "
							+ "<foreach collection='products' item='product' separator=' UNION SELECT '> "
								+ " "
								+ "#{product.sourceCategory.sourcecategoryid}::integer, "
								+ "#{product.title}, "
								+ "#{product.price}, "
								+ "#{product.image},"
								+ "#{product.url},"
								+ "#{product.subTwoCategory.subtwocategoryid}::integer "
								+ "WHERE NOT EXISTS"
								+ "	("
								+ "	SELECT url FROM phsar_product_temperory WHERE url = #{product.url}"
								+ " )  "
							+ "</foreach>"
					+"</script>";

	final String r_pro = "SELECT "
							+ "p.product_pk_id, "
							+ "p.title, "
							+ "p.price, "
							+ "p.image, "
							+ "p.url, "
							+ "p.date_create, "
							+ "p.description, "
							+ "s.category_name, "
							+ "sc.source_category, "
							+ "sc.status "
						+ "FROM "
							+ "phsar_product_temperory p "
						+ "INNER JOIN "
							+ "phsar_sub_two_category s "
						+ "ON "
							+ "p.sub_two_fk_id = s.sub_two_pk_id  "
						+ "INNER JOIN "
							+ "phsar_source_category sc "
						+ "ON "
							+ "p.source_category_fk_id = sc.source_category_pk_id ";
	
	
	final String d_pro = "delete from phsar_product_temperory p WHERE p.status = #{status}";

	
	@SelectProvider(type = ProductTmpSqlBuilder.class, method = "findProductBySubCategoryId")
	@Results(value={
			
			@Result(property="productid", column="product_pk_id"),
			@Result(property="title", column="title"),
			@Result(property="price", column="price"),
			@Result(property="image", column="image"),
			@Result(property="url", column="url"),
			@Result(property="description", column="description"),
			@Result(property="datecreate", column="date_create"),
			@Result(property="subTwoCategory.subtwocategoryid", column="sub_two_fk_id"),
			@Result(property="sourceCategory.sourcecategoryid", column="source_category_fk_id"),
			@Result(property="sourceCategory.source.prefixlink", column="prefix_link"),
			@Result(property="sourceCategory.source.prefiximage", column="prefix_image"),
			@Result(property="sourceCategory.source.sourceid", column="source_pk_id")
	})
	public ArrayList<ProductTemperory> getProductsTemperoryById(int id);
	
	
	
	@Select(r_pro)
	@Results(value={
			
			@Result(property="productid", column="product_pk_id"),
			@Result(property="title", column="title"),
			@Result(property="price", column="price"),
			@Result(property="image", column="image"),
			@Result(property="url", column="url"),
			@Result(property="description", column="description"),
			@Result(property="datecreate", column="date_create"),
			@Result(property="subTwoCategory.categoryname", column="category_name"),
			@Result(property="sourceCategory.sourcecategory", column="source_category"),
			@Result(property="sourceCategory.status", column="status")
	})
	public ArrayList<ProductTemperory> getALLProductsTemperory();
	
	@Insert(c_pro)
	public int createProductTemperory(@Param("products") List<ProductTemperory> product);
	
	@Update("UPDATE phsar_product_temperory SET status = false WHERE product_pk_id =  #{productid} ")
	public int updateProductById(long sourceid);
	
	@Delete(d_pro)
	public int deleteProductsByStatus(boolean status);
	
	@Select("SELECT "
			+ "		p.product_pk_id, "
			+ "		p.title, "
			+ "		p.price, "
			+ "		p.image "
			+ "FROM "
			+ "		phsar_product_temperory p "
			+ "		INNER JOIN "
			+ "		phsar_sub_two_category s "
			+ "ON "
			+ "		p.sub_two_fk_id = s.sub_two_pk_id  "
			+ "		INNER JOIN "
			+ "		phsar_source_category sc "
			+ "ON "
			+ "		p.source_category_fk_id = sc.source_category_pk_id "
			+ "WHERE "
			+ "		p.status = #{status}")
	
		@Results(value={
			
			@Result(property="productid", column="product_pk_id"),
			@Result(property="title", column="title"),
			@Result(property="price", column="price"),
			@Result(property="image", column="image")
		})
	public ArrayList<ProductTemperory> getProductsByStatus(boolean status);
}
