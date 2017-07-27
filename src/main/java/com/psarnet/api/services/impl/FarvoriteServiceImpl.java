package com.psarnet.api.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psarnet.api.entities.Farvorite;
import com.psarnet.api.entities.User;
import com.psarnet.api.entities.util.Pagination;
import com.psarnet.api.repositories.FarvoriteRepository;
import com.psarnet.api.services.FarvoriteService;


@Service
public class FarvoriteServiceImpl implements FarvoriteService{

	@Autowired
	private FarvoriteRepository fr;
	
	@Override
	public ArrayList<Farvorite> getFarvoriteByUserId(int userid, Pagination pagin) {
		try{
			pagin.setTotalCount(fr.countFarvoriteByUserId(userid));
			return fr.getFarvoriteByUserId(userid, pagin);
		}catch(Exception e){	
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addFarvorite(Farvorite f) {
		return fr.addFarvorite(f);
	}

	@Override
	public int deleteFarvoriteById(int userid, int farvoriteid) {
		return fr.deleteFarvoriteById(userid, farvoriteid);
	}

}
