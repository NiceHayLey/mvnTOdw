package com.hankook.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hankook.api.vo.ArenaTokenVO;


public interface ArenaTokenService {
	
	/**
	 * TokenService
	 */
	String selectArenaToken(ArenaTokenVO vo) throws Exception;
	
	void createArenaToken(ArenaTokenVO vo) throws Exception;
}
