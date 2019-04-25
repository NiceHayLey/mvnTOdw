package com.hankook.api.entity;

import javax.persistence.*;

@Entity
public class ResultEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private String result_messege;                         	/* http status 외 코드 정의 */
	private String result_code;                         	/* http status 외 코드 정의 */
	private String result_data;

	public ResultEntity() {}
	
	public ResultEntity(  final String result_messege
						, final String result_code
						, final String result_data
						) {
		this.result_messege		= result_messege;
		this.result_code 		= result_code;
		this.result_data 		= result_data;
	}
	
	
	public String getResult_messege() {
		return result_messege;
	}

	public void setResult_messege(String result_messege) {
		this.result_messege = result_messege;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getResult_data() {
		return result_data;
	}

	public void setResult_data(String result_data) {
		this.result_data = result_data;
	}

	@Override
	public String toString() {
		//Override 않 할 경우 헤더 정보만 보임.
		return ""	//"\n"
				+ "ResultEntity [" 						//+ "\n"
				+ "result_messege=" + result_messege 	//+ "\n"
				+ ",result_code=" + result_code 		//+ "\n"
				+ ",result_data=" + result_data 		//+ "\n"
				+ "]"									//+ "\n"
				;
	}
	
	
}
