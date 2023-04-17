package com.ds.gw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.gw.dto.HobbyDto;
import com.ds.gw.repository.HobbyDao;

import jakarta.annotation.Resource;

@Service("hobbyService")
public class HobbyServiceImpl implements HobbyService{

	@Resource(name="hobbyDao")
	HobbyDao dao;
	
	@Override
	public List<HobbyDto> getHobbyList(HobbyDto dto_h) {
		return dao.getHobbyList(dto_h);
	}


}
