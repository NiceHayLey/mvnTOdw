package com.hankook.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hankook.web.vo.TokenVO;


//@Repository("Api/ArenaDAO")
@Repository("Web/TestDAO")
public class TestDAO extends AbstractDAO{
	
	//<mapper namespace="dao.web.webSqlMap">
	public String selectToken(TokenVO vo) throws Exception{
		return (String)selectOne("dao.web.webSqlMap.selectToken", vo);
	}
	/** 
	 * Intro 단말기 확인
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	/*public FranchiseeVo selectTerminalInfo(TerminalVo vo) throws Exception{
		return (FranchiseeVo)selectOne("dao.introSqlMap.selectTerminalInfo", vo);
	}*/
	
	/** 
	 * Intro 상품정보 리스트 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	/*@SuppressWarnings("unchecked")
	public List<ApiItemVo> selectItemList(ApiItemVo vo) throws Exception{
		return (List<ApiItemVo>)selectList("dao.introSqlMap.selectItemList", vo);
	}*/
	
	/**
	 * 단말기 이용 정보 저장
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	/*public int insertTerminalStack(ApiTerminalStackVo vo) throws Exception{
		return (int)insert("dao.introSqlMap.insertTerminalStack", vo);
	}*/
	
	
	/** 
	 * Intro 배너정보 리스트 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	/*@SuppressWarnings("unchecked")
	public List<ApiBannerVo> selectBannerList(ApiBannerVo vo) throws Exception{
		return (List<ApiBannerVo>)selectList("dao.introSqlMap.selectBannerList", vo);
	}*/
	/** 
	 * Intro 공지정보 리스트 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	/*@SuppressWarnings("unchecked")
	public List<ApiNoticeVo> selectNoticeList(ApiNoticeVo vo) throws Exception{
		return (List<ApiNoticeVo>)selectList("dao.introSqlMap.selectNoticeList", vo);
	}*/
	
	
	
}
