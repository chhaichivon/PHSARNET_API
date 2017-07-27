package com.psarnet.api.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubTwoCategory {
	
	@JsonProperty("ID")
	private int subtwocategoryid;
	
	@JsonProperty("SUB_CATEGORY")
	private String categoryname;
	
	@JsonProperty("DATE")
	private String datecreate;
	
	@JsonProperty("MAIN_CATEGORY")
	private SubOneCategory suboneCategory;

	
	public int getSubtwocategoryid() {
		return subtwocategoryid;
	}

	public void setSubtwocategoryid(int subtwocategoryid) {
		this.subtwocategoryid = subtwocategoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}

	public SubOneCategory getSuboneCategory() {
		return suboneCategory;
	}

	public void setSuboneCategory(SubOneCategory suboneCategory) {
		this.suboneCategory = suboneCategory;
	}


	
	
	
}
