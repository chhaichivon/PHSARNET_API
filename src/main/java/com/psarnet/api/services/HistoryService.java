package com.psarnet.api.services;

import java.util.ArrayList;

import com.psarnet.api.entities.History;

public interface HistoryService {
	
	public ArrayList<History> getAllHistroy(int userid);
	
	public int createHistory(History h);
	
	public int deleteHistoryById(int userid, int historyid);
}
