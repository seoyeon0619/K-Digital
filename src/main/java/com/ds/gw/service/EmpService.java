package com.ds.gw.service;

import java.util.List;

import com.ds.gw.dto.EmpDto;

public interface EmpService {
	List<EmpDto> getList(EmpDto dto);
	EmpDto getView(EmpDto dto);
	
	void insert(EmpDto dto);
	void update(EmpDto dto);
	void delete(EmpDto dto);
}
