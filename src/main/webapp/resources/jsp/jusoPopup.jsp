<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script language="javascript">
	document.domain = "[BASE_DOMAIN]";

	function init() {
		var url = location.href;
		var confmKey = "[JUSO_API_KEY]"; // 주소 API 승인키
		var inputYn = '<c:out value="${param.inputYn}" escapeXml="true" />';
		if (inputYn != "Y") {
			document.form.confmKey.value = confmKey;
			document.form.returnUrl.value = url;
			document.form.action = "http://www.juso.go.kr/addrlink/addrLinkUrl.do";
			document.form.submit();
		} else {
			opener.jusoCallBack(
				"<c:out value="${param.roadFullAddr}" escapeXml="true" />",
				"<c:out value="${param.roadAddrPart1}" escapeXml="true" />",
				"<c:out value="${param.addrDetail}" escapeXml="true" />",
				"<c:out value="${param.roadAddrPart2}" escapeXml="true" />",
				"<c:out value="${param.engAddr}" escapeXml="true" />",
				"<c:out value="${param.jibunAddr}" escapeXml="true" />",
				"<c:out value="${param.zipNo}" escapeXml="true" />",
			"<c:out value="${param.admCd}" escapeXml="true" />");
			window.close();
		}
	}
</script>
<body onload="init2();">
	<form id="form" name="form" method="post">
		<input type="hidden" id="confmKey" name="confmKey" value="" />
		<input type="hidden" id="returnUrl" name="returnUrl" value="" />
	</form>
</body>
</html>