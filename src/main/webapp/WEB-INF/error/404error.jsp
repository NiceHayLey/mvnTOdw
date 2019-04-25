<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/tags/jstl.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
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
		
		
	});
	
	function historyBack(){
		window.history.back();
	}
	
	
	</script>
</head>
<body>
	
	<div class="error_cont">
		<span class="ec_img">
			<p class="ec_mesagge">이용에 불편을 드려 대단히 죄송합니다.<br />요청하신 페이지를 찾을 수 없습니다.</p>
			<p class="ec_notice">페이지의 주소가 변경 또는 삭제되어 요청하신 페이지를 찾을 수 없습니다.<br /> 입력하신 주소가 정확한지 다시 확인 부탁 드립니다. <br />궁금한 점이 있으시면 언제든 고객센터를 통해 문의해 주시기 바랍니다. 감사합니다.</p>
			<div class="btn_wrap type_none_border">
				<a href="javascript:void(0)" class="btn btn_b type_w168" onclick="historyBack()">이전 페이지</a>
				<a href="${ctx}/web/test.do" class="btn btn_b type_w168">홈으로</a>
			</div>
	</div>
	
</body>
</html>


