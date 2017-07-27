package com.psarnet.api.services;

import java.util.ArrayList;

import com.psarnet.api.entities.Farvorite;
import com.psarnet.api.entities.User;
import com.psarnet.api.entities.util.Pagination;

public interface FarvoriteService {
	
	public ArrayList<Farvorite> getFarvoriteByUserId(int userid, Pagination pagin);
	
	public int addFarvorite(Farvorite f);
	
	public int deleteFarvoriteById(int userid, int farvoriteid);
}
