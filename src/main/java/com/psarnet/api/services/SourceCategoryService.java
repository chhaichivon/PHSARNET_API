package com.psarnet.api.services;

import java.util.ArrayList;

import com.psarnet.api.entities.SourceCategory;
import com.psarnet.api.entities.util.Pagination;

public interface SourceCategoryService {
	
	public ArrayList<SourceCategory> getAllSourceCategory(Pagination pagin);
	
	public ArrayList<SourceCategory> getById(int id);
	public int createSourceCategory(SourceCategory sc);
	
	public int updateSourceCategory(SourceCategory sc);
	
	public int deleteSourceCategoryById(int id);
	public ArrayList<SourceCategory> getAllUrlToScrap();
}
