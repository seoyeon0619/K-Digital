package com.ds.gw.service;

import java.util.List;

import com.ds.gw.dto.DeptDto;

public interface DeptService {
	List<DeptDto> getDeptList(DeptDto dto_d);
}
