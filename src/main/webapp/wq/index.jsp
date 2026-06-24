<%@page import="kw.fw.util.ApplicationContextAwareUtil"%>
<%@page import="egovframework.rte.fdl.property.EgovPropertyService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="kw.fw.util.SessionUtil"%>
<%@page import="kw.fw.vo.SessionVo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns='http://www.w3.org/1999/xhtml'
	xmlns:ev='http://www.w3.org/2001/xml-events'
	xmlns:w2='http://www.inswave.com/websquare'
	xmlns:xf='http://www.w3.org/2002/xforms'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>K-Energy System</title>
<script type="text/javascript">
	document.domain = "[BASE_DOMAIN]";
</script>
<%
	boolean isLogin = SessionUtil.isLogin(request);
	String redirectUrl = "";
	String contextRoot = "";
	String autoLogin = "";
	SessionVo svo = null;
	String encData = "";

	EgovPropertyService propertiesService = (EgovPropertyService) ApplicationContextAwareUtil.getBean("propertiesService");

	String runMode = propertiesService.getString("run.mode") ;

	String domainName = System.getProperty("jeus.domain.name") ;
	String osName = System.getProperty("os.name") ;
	String systype = "" ;

	if ("".equals(domainName) || domainName == null ) {
		if (osName.startsWith("Windows")) {
			systype = "(LOCAL PC)";
		}
	} else {
		if ("imdevweb1".equals(domainName)) {
			systype = "(개발(14번))" ;
		}
		else if ("imdevsapap".equals(domainName)) {
			systype = "(개발(11번))" ;
		}
		else if ("kobwasidev".equals(domainName)) {
			systype = "(개발(대내))" ;
		}
		else if ("kobwasodev".equals(domainName)) {
			systype = "(개발(대외))" ;
		}
	}

	if (isLogin) {
		svo = SessionUtil.getLoginSession(request);

		String usrId 				= svo.getUsrId() == null ? "" : svo.getUsrId();
		String usrEmpno 			= svo.getUsrId() == null ? "" : svo.getUsrId();
		String usrNm 				= svo.getUsrNm() == null ? "" : svo.getUsrNm();
		String sysDivCd 			= svo.getSysDivCd() == null ? "" : svo.getSysDivCd();
		String biznDivCd 			= svo.getBiznDivCd() == null ? "" : svo.getBiznDivCd();
		String athrId 				= svo.getAthrId() == null ? "" : svo.getAthrId();
		String usrDeptCd 			= svo.getUsrDeptCd() == null ? "" : svo.getUsrDeptCd();
		String usrDeptNm 			= svo.getUsrDeptNm() == null ? "" : svo.getUsrDeptNm();
		String usrOfcpsCd 			= svo.getUsrOfcpsCd() == null ? "" : svo.getUsrOfcpsCd();
		String usrOfcpsNm 			= svo.getUsrOfcpsNm() == null ? "" : svo.getUsrOfcpsNm();
		String usrJgrdCd 			= svo.getUsrJgrdCd() == null ? "" : svo.getUsrJgrdCd();
		String usrJgrdNm 			= svo.getUsrJgrdNm() == null ? "" : svo.getUsrJgrdNm();

		String usrHqCd 				= svo.getUsrHqCd() == null ? "" : svo.getUsrHqCd();
		String usrHqNm 				= svo.getUsrHqNm() == null ? "" : svo.getUsrHqNm();
		String usrSectCd 			= svo.getUsrSectCd() == null ? "" : svo.getUsrSectCd();
		String usrSectNm 			= svo.getUsrSectNm() == null ? "" : svo.getUsrSectNm();
		String usrTeamCd 			= svo.getUsrTeamCd() == null ? "" : svo.getUsrTeamCd();
		String usrTeamNm 			= svo.getUsrTeamNm() == null ? "" : svo.getUsrTeamNm();
		String usrJbgpCd 			= svo.getUsrJbgpCd() == null ? "" : svo.getUsrJbgpCd();
		String usrJbgpNm 			= svo.getUsrJbgpNm() == null ? "" : svo.getUsrJbgpNm();
		String usrJblnCd 			= svo.getUsrJblnCd() == null ? "" : svo.getUsrJblnCd();
		String usrJblnNm 			= svo.getUsrJblnNm() == null ? "" : svo.getUsrJblnNm();
		String usrDtyCd 			= svo.getUsrDtyCd() == null ? "" : svo.getUsrDtyCd();
		String usrDtyNm 			= svo.getUsrDtyNm() == null ? "" : svo.getUsrDtyNm();
		String cstctCd 				= svo.getCstctCd() == null ? "" : svo.getCstctCd();
		String cstctNm 				= svo.getCstctNm() == null ? "" : svo.getCstctNm();

		String conectIp				= svo.getConectIp() == null ? "" : svo.getConectIp();
		String idvinfoDealAthrYn 	= svo.getIdvinfoDealAthrYn() == null ? "" : svo.getIdvinfoDealAthrYn();

		encData = usrId + "|" + usrEmpno + "|" + usrNm + "|" + sysDivCd + "|" + biznDivCd + "|" + athrId + "|" + usrDeptCd + "|" + usrDeptNm + "|" + usrOfcpsCd + "|" + usrOfcpsNm + "|" + usrJgrdCd + "|" + usrJgrdNm + "|"
			+ usrHqCd + "|" + usrHqNm + "|" + usrSectCd + "|" + usrSectNm + "|" + usrTeamCd + "|" + usrTeamNm + "|" + usrJbgpCd + "|" + usrJbgpNm + "|" + usrJblnCd + "|" + usrJblnNm + "|" + usrDtyCd + "|" + usrDtyNm + "|"
			+ cstctCd + "|" + cstctNm + "|" + conectIp + "|" + idvinfoDealAthrYn;

		encData = Base64.getEncoder().encodeToString(encData.getBytes("UTF-16"));
	}

	redirectUrl = request.getParameter("w2xPath");
	contextRoot = request.getContextPath();
	if (redirectUrl != null) {
		// if ( (redirectUrl.contains("login.xml") == false)  && (redirectUrl.contains("loginTmpByPass.xml") == false) && (isLogin == false)  ){
		if ((redirectUrl.contains("login.xml") == false) && (isLogin == false)) {
%>
<script type="text/javascript">
	//<!--
	if (parent && parent != this) {
		parent.location.href= '<%=contextRoot%>' + '/sessionnull.html';
	}
	else{
		window.location.href= '<%=contextRoot%>' + '/sessionnull.html';
	}
	//-->
</script>
<%
		} else {
%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/common.css" />

<!-- rMateChartH5 에서 사용하는 스타일 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/js/rMateChartH5/Assets/Css/rMateChartH5.css" />
<!-- rMateMapChartH5 에서 사용하는 스타일 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/js/rMateMapChartH5/Assets/rMateMapChartH5.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/wq/javascript.wq?q=/bootloader"></script>

<!-- commonJs Start -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/common/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/common/common_ajax.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/common/common_file.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/common/common_util.js"></script>
<!-- commonJs End -->

<!-- OZ Viewer Start -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ozhviewer8/jquery/jquery-2.0.3.min.js"></script>
<!--
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/ozhviewer/ui.dynatree.css"
	type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ozhviewer8/jquery/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/ozhviewer/jquery/jquery-ui.css"
	type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ozhviewer8/jquery.dynatree.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ozhviewer8/OZJSViewer.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ozhviewer/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ozhviewer/jquery/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ozhviewer/jquery.dynatree.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ozhviewer/OZJSViewer.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/exeviewer/WebContent/js/jQuery.XDomainRequest.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/exeviewer/WebContent/js/MaXHRControl.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/exeviewer/WebContent/js/json2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/exeviewer/ozexe.js"></script>
-->
<!--  OZ Viewer  End -->

<!-- rMateMapChartH5 Start -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/rMateMapChartH5/LicenseKey/rMateMapChartH5License.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/rMateMapChartH5/JS/rMateMapChartH5.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/rMateChartH5/LicenseKey/rMateChartH5License.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/rMateChartH5/JS/rMateChartH5.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/rMateChartH5/JS/rMateIntegrationH5.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/rMateChartH5/Assets/Theme/theme.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/wq/externalJS/underscore/underscore-min.js"></script>
<style type="text/css">
.rMateH5__MapChart svg {
	position: relative !important;
}
</style>
<!-- rMateMapChartH5 End -->

<!-- underscore -->

<!--
	<script type="text/javascript" src="${pageContext.request.contextPath}/wq/externalJS/jquery/jquery-1.10.2.min.js" charset="utf-8"></script>
-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/wq/externalJS/html2canvas/html2canvas.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/common/fusioncharts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/common/fusioncharts.charts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/common/jquery.mCustomScrollbar.concat.min.js"></script>

<!--
	<module src="${pageContext.request.contextPath}/resources/js/ecs/common_ecs.js" />
-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/ecs/common_ecs.js"></script>
<script type="text/javascript">
	//<!--
	var usrInfo = '<%=encData%>';
	var sysType = '<%=systype%>';
	comLib.setDecodedValue('<%=encData%>');

	if (comLib.getUserInfo ("servertype" ) == null ) {
		comLib.setUserInfo ("servertype", "<%=systype%>");
	}
	//-->
</script>
<%
		}
	} else {
		if (!isLogin) {
			response.sendRedirect(contextRoot + "/sessionnull.html");
		} else {
			response.sendRedirect(contextRoot + "/wq/index.jsp?w2xPath=" + contextRoot + "/ui/index.xml");
		}
	}
%>
<script type="text/javascript">
	window.onload = init;

	function init() {
		try {
			WebSquare.startApplication();

		} catch (e) {
			comLib.onWebsquareError(e.message);//조치가이드 화면 오픈
		}
	};

	window.addEventListener("message", function(e) {
		var data = e.data;

		if (data.type == "juso") {
			window[data.wf + "_scwin"].jusoCallBack(data.roadFullAddr,
				data.roadAddrPart1, data.addrDetail, data.roadAddrPart2,
				data.engAddr, data.jibunAddr, data.zipNo, data.rtAdmCd);
		}
	});
</script>
</head>
<body></body>
</html>