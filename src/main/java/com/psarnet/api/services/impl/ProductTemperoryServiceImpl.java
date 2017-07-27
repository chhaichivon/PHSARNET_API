package com.psarnet.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psarnet.api.entities.ProductTemperory;
import com.psarnet.api.entities.util.Pagination;
import com.psarnet.api.repositories.ProductTemperoryRepository;
import com.psarnet.api.services.ProductTmpService;

@Service
public class ProductTemperoryServiceImpl implements ProductTmpService{

	@Autowired
	private ProductTemperoryRepository ps;
	@Override
	public ArrayList<ProductTemperory> getALLProductsTemperory() {
		return ps.getALLProductsTemperory();
	}

	@Override
	public int createProductTemperory(List<ProductTemperory> products) {
		
		return ps.createProductTemperory(products);
	}

	@Override
	public int deleteProductsByStatus(boolean status) {
		return ps.deleteProductsByStatus(status);
	}
	
	@Override
	public ArrayList<ProductTemperory> getProductsTemperoryById(int id) {
		try{
			return ps.getProductsTemperoryById(id);
			
		}catch(Exception e){	
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@Override
	public int updateProductById(long sourceid) {
		return ps.updateProductById(sourceid);
	}
	
	@Override
	public ArrayList<ProductTemperory> getProductsByStatus(boolean status) {
		return ps.getProductsByStatus(status);
	}
}	
