package com.hankook.api.controller;

/**
 * 
400	001	내부 처리 오류. 에러 코드로 상세 분류되어 있지 않은 경우                        <br/>
400	002	잘못된 파라미터. 호출 인자값이 잘못되었거나 필수 인자가 포함되지 않은 경우      <br/>
400	003	저장실패                                                                        <br/>
400	004	NOT FOUND                                                                       <br/>
400	005	                                                                                <br/>
400	101	arena_token 불 일치                                                             <br/>
400	102	                                                                                <br/>
400	103	                                                                                <br/>
400	201	doc_type 불 일치                                                                <br/>
400	202	doc_number 불 일치                                                              <br/>
400	203	보존년한 경과(expire_date)                                                      <br/>
400	204	                                                                                <br/>
400	205	                                                                                <br/>
400	206	                                                                                <br/>
400	301	                                                                                <br/>
500	999	Error                                                                           <br/>
500	998	서비스 종료                                                                     <br/>
500	997	서비스 점검중                                                                   <br/>
 * 
 * @author hanta
 *
 */
public enum ApiReturnCode {
	
	/** 성공 */
	OK			("000", "성공"),
	/** 성공 */
	MSG000		("000", "성공"),
	
	/** 내부처리 오류 */
	MSG001		("001", "내부처리 오류"),
	
	/** 잘못 된 파라미터, 호출 인자값이 잘못되었거나 필수 인자가 포함되지 않은 경우 */
	MSG002		("002", "잘못 된 파라미터, 호출 인자값이 잘못되었거나 필수 인자가 포함되지 않은 경우"),
	
	/** 저장실패 */
	MSG003		("003", "저장실패"),
	
	/** NOT FOUND */
	MSG004		("004", "NOT FOUND"),
	
	/** arena_token 불 일치 */
	MSG101		("101", "arena_token 불 일치"),
	//MSG102		("102", "arena_token 불 일치"),
	//MSG103		("103", "arena_token 불 일치"),
	
	/** doc_type 불 일치 */
	MSG201		("201", "doc_type 불 일치"),
	
	/** doc_number 불 일치 */
	MSG202		("202", "doc_number 불 일치"),
	
	/** 보존년한 경과(expire_date) */
	MSG203		("203", "보존년한 경과(expire_date)"),
	
	/** 서비스 점검 중 */
	MSG997		("997", "서비스 점검 중"),
	
	/** 서비스 종료 */
	MSG998		("998", "서비스 종료"),
	/** Error */
	MSG999		("999", "Error"),
	/** Error */
	ERROR		("999", "Error");

	private final String	rtnCode;
	private final String 	rtnMessage;

	private ApiReturnCode(String code, String message) {
		this.rtnCode	= code;
		this.rtnMessage	= message;
	}

	public String getRtnCode() {
		return rtnCode;
	}

	public String getRtnMessage() {
		return rtnMessage;
	}
	
	
	
}
