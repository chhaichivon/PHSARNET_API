package com.psarnet.api.services;

import java.util.ArrayList;
import java.util.List;

import com.psarnet.api.entities.Source;

public interface SourceService {
	
	public ArrayList<Source> getAllSources();

	public int createSource(Source s);
	
	public int updateSource(Source s);
	
	public int deleteSourceById(int id);
	
	public List<Source> getAll();
	
	public List<Source> getSourceJoinOneToMany();
	
	/*public List<Source> getTotalProductsInSource();*/
	
}
