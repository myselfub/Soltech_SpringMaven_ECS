<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String encKey = request.getAttribute("encKey") != null ? (String) request.getAttribute("encKey") : "";
	String targetSystem = request.getAttribute("targetSystem") != null ? (String) request.getAttribute("targetSystem") : "";
	String menuId = request.getAttribute("menuId") != null ? (String) request.getAttribute("menuId") : "";
	/* 2019-10-11 차동환 (안영헌 과장님 요청 : openOthrSysScrn.do 추가에 따른 화면ID 프로퍼티 추가) */
	String screenId = request.getAttribute("screenId") != null ? (String) request.getAttribute("screenId") : "";
	String aprvRequstNo = request.getAttribute("aprvRequstNo") != null ? (String) request.getAttribute("aprvRequstNo") : "";
	String docCd = request.getAttribute("docCd") != null ? (String) request.getAttribute("docCd") : "";
	String docTit = request.getAttribute("docTit") != null ? (String) request.getAttribute("docTit") : "";
	String docNo = request.getAttribute("docNo") != null ? (String) request.getAttribute("docNo") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>KES</title>
<script type="text/javascript">
function init() {
	document.systemSSOform.action = "https://" + "<%=targetSystem%>" + ".[BASE_DOMAIN]/processSso.do";
	document.systemSSOform.encKey.value = "<%=encKey%>";
	document.systemSSOform.menuId.value = "<%=menuId%>";
	/* 2019-10-11 차동환 (안영헌 과장님 요청 : openOthrSysScrn.do 추가에 따른 화면ID 프로퍼티 추가) */
	document.systemSSOform.screenId.value = "<%=screenId%>";
	document.systemSSOform.aprvRequstNo.value = "<%=aprvRequstNo%>";
	document.systemSSOform.docCd.value = "<%=docCd%>";
	document.systemSSOform.docTit.value = "<%=docTit%>";
	document.systemSSOform.docNo.value = "<%=docNo%>";
	document.systemSSOform.submit();
};
</script>
</head>
<body onload="init();">
	<form action="" name="systemSSOform" id="systemSSOform" method="post">
		<input name="encKey" type="hidden"> <input name="menuId" type="hidden">
		<%-- 2019-10-11 차동환 (안영헌 과장님 요청 : openOthrSysScrn.do 추가에 따른 화면ID 프로퍼티 추가) --%>
		<input name="screenId" type="hidden">
		<input name="aprvRequstNo" type="hidden">
		<input name="docCd" type="hidden">
		<input name="docTit" type="hidden">
		<input name="docNo" type="hidden">
	</form>
</body>
</html>