package com.ds.gw.service;

import java.util.List;

import com.ds.gw.dto.DeptDto;
import com.ds.gw.dto.EmpHobbyDto;

public interface DeptService {
	List<DeptDto> getDeptList(DeptDto dto_d);
	DeptDto getDeptView(DeptDto dto_d);
}
