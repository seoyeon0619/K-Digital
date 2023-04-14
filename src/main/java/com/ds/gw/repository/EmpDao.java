package com.ds.gw.repository;

import java.util.List;

import com.ds.gw.dto.EmpDto;

public interface EmpDao {
	List<EmpDto> getEmpList(EmpDto dto);
	EmpDto getView(EmpDto dto);
	
	void insert(EmpDto dto);
	void update(EmpDto dto);
	void delete(EmpDto dto);
}


