package com.ds.gw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.gw.dto.DeptDto;
import com.ds.gw.repository.DeptDao;

import jakarta.annotation.Resource;

@Service("deptService")
public class DeptServiceImpl implements DeptService{
	
	@Resource(name="deptDao")
	DeptDao dao;
	
	@Override
	public List<DeptDto> getDeptList(DeptDto dto_d) {
		return dao.getDeptList(dto_d);
	}

}
