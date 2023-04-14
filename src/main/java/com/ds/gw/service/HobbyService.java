package com.ds.gw.service;

import java.util.List;

import com.ds.gw.dto.HobbyDto;

public interface HobbyService {
	List<HobbyDto> getHobbyList(HobbyDto dto_h);
}
