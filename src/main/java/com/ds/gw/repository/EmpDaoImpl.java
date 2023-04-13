package com.ds.gw.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.gw.dto.EmpDto;

@Repository("empDao")
public class EmpDaoImpl implements EmpDao{
	
	@Autowired
	SqlSessionTemplate sm;
	
	public void insertEmp(EmpDto dto) {
		sm.insert("insertEmp", dto);
	}
}
