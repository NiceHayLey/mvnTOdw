package com.hankook.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.hankook.api.dao.ArenaDAO;
import com.hankook.api.service.ArenaTokenService;
import com.hankook.api.vo.ArenaTokenVO;


@Service("arenaTokenService")
public class ArenaTokenServiceImpl implements ArenaTokenService {

	@Resource(name = "Api/ArenaDAO")
	private ArenaDAO arenaDAO;
	
	@Override
	public String selectArenaToken(ArenaTokenVO vo) throws Exception {
		return arenaDAO.selectArenaToken(vo);
	}
	
	@Override
	public void createArenaToken(ArenaTokenVO vo) throws Exception {
		// TODO Auto-generated method stub
//		Map<String,Object> save_data = new HashMap<>();
//		save_data.put("token", param.get("arena_token"));
//		save_data.put("userId", param.get("user_id"));
//		save_data.put("userNm", param.get("user_nm"));
//		save_data.put("userEngNm", param.get("user_eng_nm"));
		
		arenaDAO.createArenaToken(vo);
	}

	
}
