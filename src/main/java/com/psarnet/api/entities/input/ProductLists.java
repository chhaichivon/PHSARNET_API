package com.psarnet.api.entities.input;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.psarnet.api.entities.Product;

public class ProductLists {
	
	@JsonProperty("PRODUCT_LIST")
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
