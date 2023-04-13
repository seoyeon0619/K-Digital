package com.ds.gw.service;

import org.springframework.stereotype.Service;

import com.ds.gw.dto.EmpDto;
import com.ds.gw.repository.EmpDao;

import jakarta.annotation.Resource;

@Service("empService")
public class EmpServiceImpl implements EmpService{
	

	@Resource(name="empDao")
	EmpDao dao;
	
	@Override
	public void insertEmp(EmpDto dto) {
		dao.insertEmp(dto);
	}
}
