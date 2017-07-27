package com.psarnet.api.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.psarnet.api.entities.Product;
import com.psarnet.api.entities.input.ProductLists;
import com.psarnet.api.entities.util.Pagination;
import com.psarnet.api.repositories.ProductReposity;
import com.psarnet.api.repositories.ProductTemperoryRepository;
import com.psarnet.api.services.ProductService;
import com.psarnet.api.services.ProductTmpService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductReposity ps;
	
	@Autowired
	private ProductTemperoryRepository ptr;
	
	@Override
	public ArrayList<Product> getALLProducts(int userid, Pagination pagin) {
		try{
			pagin.setTotalCount(ps.countALLProducts());
			return ps.getALLProducts(userid, pagin);
			
		}catch(Exception e){	
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public int deleteProductById(int id) {
		return ps.deleteProductById(id);
	}
	
	@Override
	public ArrayList<Product> findProductsByTitle(int userid, int category_id, String title, Pagination pagin) {
		try{
			pagin.setTotalCount(ps.countProductsByTitle(category_id, title));
			return ps.findProductsByTitle(userid, category_id, title, pagin);
			
		}catch(Exception e){	
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ArrayList<Product> findProductBySubCategory(int userid, int id, Pagination pagin) {

		try{
			pagin.setTotalCount(ps.countProductBySubCategory(id));
			return ps.findProductBySubCategory(userid, id, pagin);
			
		}catch(Exception e){	
			e.printStackTrace();
		}
		return null;
	}
	
	/*@Override
	public ArrayList<Product> findProductBySetPrice(int subid, String start_price, String price, Pagination pagin) {
		try{
			pagin.setTotalCount(ps.countProductBySetPrice(subid, start_price,price));
			return ps.findProductBySetPrice(subid, start_price,price , pagin);
			
		}catch(Exception e){	
			e.printStackTrace();
		}
		return null;
		
	}*/
	
	
	
	@Override
	public int addProducts(List<Product> products) {
		try{
			
			for(Product product : products)
			{
				ptr.updateProductById(product.getProductid());
			}
			
			return ps.addProducts(products);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public ArrayList<Product> getProductsByCurrentDate(String current_date) {
		return ps.getProductsByCurrentDate(current_date);
	}

	@Override
	public ArrayList<Product> findProductByWebSite(int userid, int id,int subid, Pagination pagin) {
		try{
			pagin.setTotalCount(ps.countProductByFindWebSite(id, subid));
			return ps.findProductByWebSite(userid, id, subid, pagin);
			
		}catch(Exception e){	
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ArrayList<Product> findProductByFilter(int userid, int mainid, String title, int subid, int sourceid, double start_price, double price,
			Pagination pagin) {
	
		try{
			pagin.setTotalCount(ps.countProductByFilter(mainid, title, subid, sourceid, start_price, price));
			return ps.findProductByFilter(userid, mainid, title,subid, sourceid, start_price, price, pagin);
			
		}catch(Exception e){	
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ArrayList<Product> getProductByHistory(int userId, Pagination pagin) {
		try{
			pagin.setTotalCount(ps.countProductByHistory());
			return ps.getProductByHistory(userId, pagin);
			
		}catch(Exception e){	
			e.printStackTrace();
		}
		return null;
	}
	
}
