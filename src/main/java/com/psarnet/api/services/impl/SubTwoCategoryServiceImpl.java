package com.psarnet.api.services.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psarnet.api.entities.SubTwoCategory;
import com.psarnet.api.entities.util.Pagination;
import com.psarnet.api.repositories.SubTwoCategoryRepository;
import com.psarnet.api.services.SubTwoCategoryService;

@Service
public class SubTwoCategoryServiceImpl implements SubTwoCategoryService {

	@Autowired
	private SubTwoCategoryRepository ms;

	@Override
	public ArrayList<SubTwoCategory> getAllSubTwoCategory(Pagination pagin){
		try{
			pagin.setTotalCount(ms.countAllSubTwoCategory());
			return ms.getAllSubTwoCategory(pagin);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createCategory(SubTwoCategory s) {
		return ms.createCategory(s);
	}

	@Override
	public int updateCategory(SubTwoCategory s) {
		return ms.updateCategory(s);
	}

	@Override
	public int deleteCategoryById(int id) {
		return ms.deleteCategoryById(id);
		
	}

	@Override
	public ArrayList<SubTwoCategory> getSubTwoCategoryByMainId(int mainid) {
		return ms.getSubTwoCategoryByMainId(mainid);
	}
	
	
}
