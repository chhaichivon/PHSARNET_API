package com.psarnet.api.services;

import java.util.ArrayList;
import java.util.List;

import com.psarnet.api.entities.ProductTemperory;
import com.psarnet.api.entities.util.Pagination;

public interface ProductTmpService {
	
	public ArrayList<ProductTemperory> getALLProductsTemperory();
	public int createProductTemperory(List<ProductTemperory> p);
	public int deleteProductsByStatus(boolean status);
	public ArrayList<ProductTemperory> getProductsTemperoryById(int id);
	public int updateProductById(long sourceid);
	public ArrayList<ProductTemperory> getProductsByStatus(boolean status);
	
}
