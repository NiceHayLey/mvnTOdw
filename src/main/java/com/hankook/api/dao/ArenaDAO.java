package com.hankook.api.dao;

import org.springframework.stereotype.Repository;

import com.hankook.api.vo.ArenaTokenVO;


@Repository("Api/ArenaDAO")
public class ArenaDAO extends AbstractDAO{
	
	public String selectArenaToken(ArenaTokenVO vo) throws Exception{
		return (String)selectOne("dao.api.tokenSqlMap.selectArenaToken", vo);
	}
	
	public void createArenaToken(ArenaTokenVO vo) throws Exception{
		update("dao.api.tokenSqlMap.createArenaToken", vo);
	}
}
