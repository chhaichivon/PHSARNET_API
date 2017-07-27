package com.psarnet.api.services;

import java.util.ArrayList;
import java.util.List;

import com.psarnet.api.entities.MainCategory;

public interface MainCategoryService {
	
	public int addMainCatetory(MainCategory mCategory);

	public ArrayList<MainCategory> getAllMainCategory();

	public ArrayList<MainCategory> getMainCategoryById(int id);

	public int updateMainCategory(MainCategory mCategory);
	
	public int deleteMainCategoryById(int id);
	
	public List<MainCategory> getSubCategoryAsLists();
}
