package com.psarnet.api.services;

import java.util.ArrayList;

import com.psarnet.api.entities.SubOneCategory;
import com.psarnet.api.entities.util.Pagination;

public interface SubOneCategoryService {
	
	public int createSubCatetory(SubOneCategory sCategory);
	public ArrayList<SubOneCategory> getAllSubCategory(Pagination pagin);
	//public ArrayList<SubOneCategory> getById(int id);
	public int updateSubCategory(SubOneCategory sCategory);
	public int deleteSubOneCategoryById(int id);
	
}
