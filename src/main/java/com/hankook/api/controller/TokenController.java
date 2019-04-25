package com.hankook.api.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hankook.api.entity.ResultEntity;
import com.hankook.api.entity.TokenEntity;
import com.hankook.api.service.ArenaTokenService;
import com.hankook.api.vo.ArenaTokenVO;
import com.hankook.web.controller.TestWebSocket;


/**
 * FMS Project Repair Controller
 */

@RestController
@RequestMapping("/api")
public class TokenController extends ApiBaseController{

	private static final Logger logger = LoggerFactory.getLogger(TokenController.class);
	
	@Resource(name = "arenaTokenService")
	private ArenaTokenService arenaTokenService;
	
	/**
	 * TOKEN 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/testRtn.arena")
	public @ResponseBody ResponseEntity<ResultEntity> testRtn(@RequestBody TokenEntity tkn) throws Exception {

		ResultEntity ent = new ResultEntity();
		
		//param 찍어보기
		logger.info(tkn.toString());
				
		//1.무결성 체크
		String checkId = tkn.getUser_id();
		logger.debug("---> 무결성 체크 / checkId:" + checkId);
		if(checkId == null || checkId.length() != checkId.trim().length()){
			return returnEntitySet(ent, ApiReturnCode.MSG002);
		}
		
		String checkToken = tkn.getArena_token();
		logger.debug("---> 무결성 체크 / checkToken:" + checkToken);
		if(checkToken == null || checkToken.length() != checkToken.trim().length()){
			return returnEntitySet(ent, ApiReturnCode.MSG004);
		}
		
		ent.setResult_data(checkId + "/" + checkToken);
		
		//3.완료 전달
		return returnEntitySet(ent, ApiReturnCode.OK);
	}

	/**
	 * TOKEN 생성
	 *  - 전달 받은 token을 저장 한다.
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/createArenaToken.arena")
	public @ResponseBody ResponseEntity<ResultEntity> createArenaToken(@RequestBody TokenEntity tkn) throws Exception {

		ResultEntity ent = new ResultEntity();
		
		//param 찍어보기
		//viewParam(param);
		logger.info(tkn.toString());
		
		//1.무결성 체크
//		String checkTK = (String)param.get("arena_token");
//		String checkID = (String)param.get("user_id");
//		
		
		String checkTK = tkn.getArena_token();	//(String)param.get("arena_token");
		String checkID = tkn.getUser_id();		//(String)param.get("user_id");
		logger.debug("In createArenaToken.arena ---> 무결성 체크 / checkTK:" + checkTK);
		logger.debug("In createArenaToken.arena ---> 무결성 체크 / checkID:" + checkID);
		
		if(checkTK == null || checkTK.length() != checkTK.trim().length()
			|| checkID == null || checkID.length() != checkID.trim().length()
				){
			return returnEntitySet(ent, ApiReturnCode.MSG002);
		}
		
		//개발 확인용 - All WebSocket session 에게 Message 보내기 
		try {
			for( Session session : TestWebSocket.sessions ){
				session.getBasicRemote().sendText("All : " + checkTK);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//2.create token
		ArenaTokenVO vo = new ArenaTokenVO();
		vo.setToken(checkTK);
		vo.setUserId(checkID);
		vo.setUserNm(tkn.getUser_nm());
		vo.setUserEngNm(tkn.getUser_eng_nm());
		try{
			arenaTokenService.createArenaToken(vo);
		}catch (Exception e) {
			e.printStackTrace();
			return returnEntitySet(ent, ApiReturnCode.MSG001);
		}
		
		//3.완료 전달
		return returnEntitySet(ent, ApiReturnCode.OK);
	}

	/**
	 * TOKEN 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/readArenaToken.arena")
	public @ResponseBody ResponseEntity<ResultEntity> readArenaToken(@RequestBody TokenEntity tkn) throws Exception {

		ResultEntity ent = new ResultEntity();
		
		//param 찍어보기
		//viewParam(param);
		logger.info(tkn.toString());
				
		//1.무결성 체크
//		String checkId = (String)param.get("user_id");
		String checkId = tkn.getUser_id();
		logger.debug("---> 무결성 체크 / checkId:" + checkId);
		if(checkId == null || checkId.length() != checkId.trim().length()){
			return returnEntitySet(ent, ApiReturnCode.MSG002);
		}
		
		//2.조회
		ArenaTokenVO vo = new ArenaTokenVO();
		vo.setToken(tkn.getArena_token());
		vo.setUserId(tkn.getUser_id());
		vo.setUserNm(tkn.getUser_nm());
		vo.setUserEngNm(tkn.getUser_eng_nm());
		try{
			String result = arenaTokenService.selectArenaToken(vo);
			if(result == null || "".equals(result)){
				return returnEntitySet(ent, ApiReturnCode.MSG004);
			}
			ent.setResult_data(result);
		}catch (Exception e) {
			e.printStackTrace();
			return returnEntitySet(ent, ApiReturnCode.ERROR);
		}
		
		//3.완료 전달
		return returnEntitySet(ent, ApiReturnCode.OK);
	}
	
	

	
}