<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/tags/jstl.jsp"%>
<!DOCTYPE html>

<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>ATLASBX GMES System</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="/arena/images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="/arena/css/style.css" type="text/css">
	<script type="text/javascript" src="/arena/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/arena/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="/arena/js/common.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			openSocket();
			
			$("#sendButton").click(function() {
				sendButtonClick();
		 	});
			
			$("#selectButton").click(function() {
				selectTokenButton();
		 	});
			$("#idUserId").keydown(function(key) {
				if (key.keyCode == 13) {
					//selectTokenButton();		//OK
					$("#selectButton").click();
				}
			});

		});
		
		var webSocket;
		var messages = document.getElementById("messages");
		
		function openSocket() {
		    // Ensures only one connection is open at a time
		    if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
		        writeResponse("WebSocket is already opened.");
		        return;
		    }
		    
		    // Create a new instance of the websocket
		    //webSocket = new WebSocket("ws://localhost/  *ProjectName*  /echo");
		    webSocket = new WebSocket("ws://localhost:8080/echo");
		
		    /**
		     * Binds functions to the listeners for the websocket.
		     */
		    webSocket.onopen = function(event) {
		        // For reasons I can't determine, onopen gets called twice
		        // and the first time event.data is undefined.
		        // Leave a comment if you know the answer.
		        if (event.data === undefined)
		            return;
		
		        writeResponse(event.data);
		    };
		
		    webSocket.onmessage = function(event) {
		        writeResponse(event.data);
		    };
		
		    webSocket.onclose = function(event) {
		        writeResponse("Connection closed");
		    };
		}
		
		/**
		 * Sends the value of the text input to the server
		 */
		function send() {
		    var text = document.getElementById("messageinput").value;
		    webSocket.send(text);
		}
		
		function closeSocket() {
		    webSocket.close();
		}
		
		function writeResponse(text) {
		    //messages.innerHTML += "<br/>" + text;
			$("#messages").val(text);
		}

		
		
		//----- sancho
		function sendButtonClick(){
		    webSocket.send($("#sendMessages").val());
		}
		
		
		// ----- new 
		function searchRentCnt() {
			//alert("select click");
			var params = {			
					//rentCd 			: rentCd
					userId : "em180319"
			}
			$.ajax({
				type	: "post",
				url		: "/web/selectToken.do",
				data	: params, 
				success	: function(data) {
					alert(data.result);
				},
				error	: function(xhr, status, error) {
					
				}
			});
		}
		
		
		function selectTokenButton() {
			var uid = $("#idUserId").val();
			var params = {			
					userId : uid
			}
			$.ajax({
				type	: "post",
				url		: "/web/selectToken.do",
				data	: params, 
				success	: function(data) {
					var rt = data.result;
					if(rt == null || rt == ""){
						rt = "None";
					}
					$("#selectedToken").val(rt);
				},
				error	: function(xhr, status, error) {
					
				}
			});
		}

	</script>
	
</head>
<body>
	
	<div class="sfa-tb">
	
		<div class="level-area">
		
			
			<table class="tb-1">
				<colgroup>
					<col width="170px" />
					<col width="*" />
					<col width="170px" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>대리점</th>
						<td class="agent">
							<input type="text" />
							<input type="text" class="small-input"/>
							<span class="agent-code">
								<span class="tit">CODE:</span>
								<input type="text" />
							</span>
						</td>
						<th class="dwp-title">대표자</th>
						<td class="dwp-value">
							<input type="text" />
						</td>
					</tr>
				</tbody>
			</table>
			
			<table class="tb-1">
				<colgroup>
					<col width="170px" />
					<col width="*" />
				</colgroup>
				<colgroup>
					<col width="170px" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>담보현황</th>
						<td>
							<div class="btn-area">
								<a href="#none" class="bt-s1">어음내역</a>
							</div>
							<table class="tb-1">
								<colgroup>
									<col width="25%" />
									<col width="25%" />
									<col width="25%" />
									<col width="25%" />
								</colgroup>
								<thead>
									<tr>
										<th>From Server</th>
										<th>To Server</th>
										<th>여신한도</th>
										<th>월중 최고 여신액</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>
											<input type="text" value="196,000"  readonly="readonly" id="messages" />
										</td>
										<td>
											<div class="btn-area">
												<input type="text" value="" id="sendMessages" />
												<a href="javascript:void(0);" class="bt-s1" id="sendButton">Send</a>
											</div>
										</td>
										<td>
											<input type="text" id="messageinput" /><br/>
											<button type="button" onclick="openSocket();">Open</button>
											<button type="button" onclick="send();">Send</button>
											<button type="button" onclick="closeSocket();">Close</button>
										</td>
										<td>0</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
		
			<div>
			    
			</div>
			<div>
			    
			</div>
			
			
			<table class="tb-1">
				<colgroup>
					<col width="170px" />
					<col width="*" />
				</colgroup>
				<colgroup>
					<col width="170px" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>조회</th>
						<td>
							<table class="tb-1">
								<colgroup>
									<col width="25%" />
									<col width="25%" />
									<col width="25%" />
									<col width="25%" />
								</colgroup>
								<thead>
									<tr>
										<th>From Server</th>
										<th>To Server</th>
										<th>여신한도</th>
										<th>월중 최고 여신액</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>
											<div class="btn-area">
												<input type="text" value="" id="idUserId" />
												<a href="javascript:void(0);" class="bt-s1" id="selectButton">Select</a>
												<!-- 비밀번호 :  type="password" name="pw" onKeyDown="javascript:if(event.keyCode==13){idpwLogin();}" -->
											</div>
										</td>
										<td>
											<input type="text" value=""  readonly="readonly" id="selectedToken" />
										</td>
										<td>0</td>
										<td>0</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
			<div>
			    <button type="button" onclick="searchRentCnt();">select</button>
			</div>
			
			
			
			
			<!-- Server responses get written here -->
			<!-- <div id="messages"></div> -->
			
			
		</div>
	
	</div>
</body>
</html>