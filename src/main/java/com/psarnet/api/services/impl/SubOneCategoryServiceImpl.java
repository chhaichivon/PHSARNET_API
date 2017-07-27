package com.psarnet.api.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psarnet.api.entities.SubOneCategory;
import com.psarnet.api.entities.util.Pagination;
import com.psarnet.api.repositories.SubOneCategoryRepository;
import com.psarnet.api.services.SubOneCategoryService;

@Service
public class SubOneCategoryServiceImpl implements SubOneCategoryService{

	@Autowired
	private SubOneCategoryRepository scRepository;
	
	@Override
	public int createSubCatetory(SubOneCategory sCategory) {
		return scRepository.createSubCatetory(sCategory);
	}

	@Override
	public ArrayList<SubOneCategory> getAllSubCategory(Pagination pagin) {
		try{
			pagin.setTotalCount(scRepository.countAllSubCategory());
			return scRepository.getAllSubCategory(pagin);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

/*	@Override
	public ArrayList<SubOneCategory> getById(int id) {
		return scRepository.getById(id);
	}
*/
	@Override
	public int updateSubCategory(SubOneCategory sCategory) {
		return scRepository.updateSubCategory(sCategory);
	}

	@Override
	public int deleteSubOneCategoryById(int id) {
		return scRepository.deleteSubOneCategoryById(id);
	}

}
