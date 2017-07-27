package com.psarnet.api.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.psarnet.api.entities.Product;
import com.psarnet.api.entities.input.ProductLists;
import com.psarnet.api.entities.util.Pagination;

public interface ProductService {

public ArrayList<Product> getALLProducts(int userid, Pagination pagin);
	
	public int deleteProductById(int id);
	
	public ArrayList<Product> findProductsByTitle(int userid, int category_id, String title, Pagination pagin);
	
	public ArrayList<Product> findProductBySubCategory(int userid, int id, Pagination pagin);
		
	public ArrayList<Product> findProductByWebSite(int userid, int id,int subid, Pagination pagin);
	
	public int addProducts(List<Product> products);
	
	public ArrayList<Product> getProductsByCurrentDate(String current_date);
	
	public ArrayList<Product> findProductByFilter(int userid, int mainid, String title, int subid,int sourceid, double start_price, double price, Pagination pagin);
	
	public ArrayList<Product> getProductByHistory(int userid, Pagination pagin);
}
