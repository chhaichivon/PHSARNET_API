package com.psarnet.api.repositories.sqlbuilder;

import com.psarnet.api.entities.util.Pagination;

public class ProductTmpSqlBuilder {

	/**
	 * Search product by sub-category id
	 * @param id
	 * @return sql statement
	 */
	public static String findProductBySubCategoryId()
	{
		String select  = "SELECT "
						+ "p.product_pk_id, "
						+ "p.title, "
						+ "p.price, "
						+ "p.image, "
						+ "p.url, "
						+ "p.date_create, "
						+ "p.description, "
						+ "p.sub_two_fk_id, "
						+ "p.source_category_fk_id, "
						+ "s.category_name, "
						+ "source.prefix_link, "
						+ "source.prefix_image, "
						+ "source.source_pk_id, "
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
						+ "p.source_category_fk_id = sc.source_category_pk_id "
					+ "INNER JOIN "
						+ "phsar_source source "
					+ "ON "
						+ "source.source_pk_id = sc.source_fk_id "
					+ "WHERE "
					+ "	sc.source_category_pk_id = #{sourceCategory.sourcecategoryid} "
					+ "AND "
					+ "	p.status = true"
						
					+ " ORDER BY p.product_pk_id DESC ";
		return select;
	}

}
