<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@page import="kw.fw.util.SessionUtil"%>
<%@page import="kw.fw.vo.SessionVo"%>
<%@page import="java.lang.reflect.Field"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="kw.fw.util.StringUtil"%>
<%@page import="kw.fw.util.ReflectUtil"%>
<%@page import="kw.fw.defaults.DefaultConsts"%>
<%@page import="net.sf.json.JSONSerializer"%>
<%@page import="net.sf.json.JSONObject"%>
<%
	// System.out.println("request.getContextPath()="+request.getContextPath()); 
	// SAP에서 OZ 호출 시 JEUS X-UA-Compatible 설정이 IE=10으로 되어있는 경우 레포트는 보이지만, 인쇄가 되지 않음
	String w2xPath = request.getParameter("w2xPath");
	if (w2xPath != null && w2xPath.endsWith("/printng/web_report_sso.xml")) {
		response.setHeader("X-UA-Compatible", "IE=Edge");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns='http://www.w3.org/1999/xhtml'
	xmlns:ev='http://www.w3.org/2001/xml-events'
	xmlns:w2='http://www.inswave.com/websquare'
	xmlns:xf='http://www.w3.org/2002/xforms'>
<head>
<script type="text/javascript">
	document.domain = "[BASE_DOMAIN]";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>K-Energy System</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/wq/javascript.wq?q=/bootloader"></script>
<!--
	<script type="text/javascript" src="javascript.wq?q=/bootloader"></script>
-->
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

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/ecs/pi/pi_biz_com.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/ecs/common_ecs.js"></script>
<!-- OZ Viewer Start -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ozhviewer8/jquery/jquery-2.0.3.min.js"></script>
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
<!--
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ozhviewer/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ozhviewer/jquery/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ozhviewer/jquery.dynatree.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ozhviewer/OZJSViewer.js"></script>
-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/exeviewer/WebContent/js/jQuery.XDomainRequest.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/exeviewer/WebContent/js/MaXHRControl.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/exeviewer/WebContent/js/json2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/exeviewer/ozexe.js"></script>
<!-- OZ Viewer End -->
<style type="text/css">
.footer .btn-group {
	position: fixed !important;
}

.wrap .content-area {
	padding-bottom: 60px !important;
}
</style>
<script type="text/javascript">
	var usrInfo = '';
	function init() {
		window.focus();

		try {
		<%
		// POST 데이터를 수신하기 위한 작업 
		for (Enumeration names = request.getParameterNames(); names.hasMoreElements();) {
			String name = (String) names.nextElement();
			String value = request.getParameter(name);

			if (StringUtil.isEmpty(value)) {
				value = "";
			}

			if (!"w2xPath".equals(name)) {
				value = value.replaceAll("\'", "\\\\'");
		%>
			WebSquare.session.setAttribute('<%=name%>', '<%=value%>');
		<%
			}
		}
		String usrId = request.getParameter("usrId");
		if (usrId == null || "".equals(usrId)) {
			String userInfo = request.getParameter("userInfo");
			if (userInfo != null && !"".equals(userInfo)) {
				try {
					//JSON 데이터 세팅
					JSONObject jsonObj = new JSONObject();
					jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(userInfo));
					usrId = (String) jsonObj.get("usrId");
				} catch (Exception eUser) {
				}
			}
		}
		/* 2017. 12. 13. 60003256 KMS. 기존에 로그인 세션을 갖고 있지 않은 경우에만 강제 로그인 처리 */
		SessionVo sessionVo = SessionUtil.getLoginSession(request);
		if (sessionVo == null || sessionVo.getUsrId() == null || "".equals(sessionVo.getUsrId())
				|| (usrId != null && !sessionVo.getUsrId().equals(usrId))) {
		// if (sessionVo == null || sessionVo.getUsrId() == null || "".equals(sessionVo.getUsrId()) || (request.getParameter("usrId") != null && !sessionVo.getUsrId().equals(request.getParameter("usrId")))) {
		%>
			// 필수 parameter
			//var usrId = WebSquare.session.getAttribute("usrId") || JSON.parse(WebSquare.session.getAttribute("userInfo")).usrId;
			var usrId = "<%=usrId%>";
			var sysDivCd = WebSquare.session.getAttribute("sysDivCd") || JSON.parse(WebSquare.session.getAttribute("userInfo")).sysDivCd;
			// var sysDivCd = comLib.SYS_DIV_CD;
			var biznDivCd = WebSquare.session.getAttribute("biznDivCd") || (WebSquare.session.getAttribute("userInfo") == null ? "" : JSON.parse(WebSquare.session.getAttribute("userInfo")).biznDivCd) || "";
			/*
			var strEnc = WebSquare.session.getAttribute("strEnc") || JSON.parse(WebSquare.session.getAttribute("userInfo")).strEnc || "";

			if (!utilLib.isNull(strEnc)) {
				// 시간계산 10 이내
				var startTime = comLib.dataDecEnc(strEnc, "D");
				var endTime = utilLib.getDate();
				if(utilLib.getDateTimeDiff(startTime, endTime) < 0 || utilLib.getDateTimeDiff(startTime, endTime) > 11){
					window.close();
				}
			}
			*/
			var requestData = {
				"dmaReqInfo" : {
					sysDivCd:sysDivCd,
					biznDivCd:biznDivCd,
					usrId:usrId
				}
			};
			var option = {
				action : "sc/login/dummyLoginIntnUser.do",
				reqData : requestData,
				resData : "", // dmaLoginUsrInfo
				// success : "scwin.dummyLoginCallback",
				// error : "scwin.dummyLoginErrCallback",
				success : "dummyLoginCallback",
				error : "dummyLoginErrCallback",
				isShowErrMeg : false,
				isShowMeg : false
			};

			ajaxLib.executeAjaxSync($p, option);
		<%
		} else {
			Field[] fields = ReflectUtil.getAllFields(sessionVo.getClass());
			for (Field field : fields) {
				Method getterMethod = ReflectUtil.getGetterMethod(sessionVo.getClass(), field.getName());
				if (getterMethod != null && !getterMethod.isAnnotationPresent(Deprecated.class)) {
					if (DefaultConsts.THREAD_LOCAL_SYS_DIV_CD.equals(field.getName())) {
		%>
			var sysDivCd = WebSquare.session.getAttribute("sysDivCd");
			if (sysDivCd == null || sysDivCd == "") {
				if (WebSquare.session.getAttribute("userInfo") != null
					&& WebSquare.session.getAttribute("userInfo") != "") {
					try {
						sysDivCd = JSON.parse(WebSquare.session.getAttribute("userInfo")).sysDivCd;
					} catch (e) {
					}
				}
			}
		}
		if (sysDivCd != null && sysDivCd != "") {
			WebSquare.session.setAttribute('<%=field.getName()%>', sysDivCd);
		} else {
			WebSquare.session.setAttribute('<%=field.getName()%>', '<%=getterMethod.invoke(sessionVo, null)%>');
		}
		<%
					} else if (DefaultConsts.THREAD_LOCAL_BIZN_DIV_CD.equals(field.getName())) {
		%>
		var biznDivCd = WebSquare.session.getAttribute("biznDivCd");
		if (biznDivCd != null && biznDivCd != "") {
			WebSquare.session.setAttribute('<%=field.getName()%>', biznDivCd);
		} else {
			WebSquare.session.setAttribute('<%=field.getName()%>', '<%=getterMethod.invoke(sessionVo, null)%>');
		}
		<%
					} else {
		%>
		WebSquare.session.setAttribute('<%=field.getName()%>', '<%=getterMethod.invoke(sessionVo, null)%>');
		<%
					}
				}
			}
		}
		%>
		} catch (e) {
			// alert(e.message);
			alert("사용하시는 브라우저의 사용가능 Memory가 부족합니다.\n\n전체 브라우저 종료 후 다시 이용 부탁드립니다.\n\n"
				+ e.message);
		}

		try {
			WebSquare.startApplication();
		} catch (e) {
			// alert(e.message);
			comLib.onWebsquareError(e.message); // 메세지 조회 후 조치가이드 화면 오픈
		}
		comLib.SYS_DIV_CD = "ECS";
		comLib.SAVED_TOKEN = comLib.SYS_DIV_CD + "_" + "savedToken";
		$(window).resize(function() {
			winresize();
		});
		setTimeout(function() {
			winresize();
		}, 200);
	};

	/**
	 * popup으로 호출시 dummy로 login callback 처리하여 화면 session을 설정한다.
	 * 
	 * @date 2017. 07. 24.
	 * @param resBody
	 * @return
	 */
	// scwin.dummyLoginCallback =  function(resBody) {
	function dummyLoginCallback(resBody) {
		comLib.setUserInfo("athrId", resBody.data.athrId);
		// comLib.setUserInfo("biznDivCd", resBody.data.biznDivCd);
		var biznDivCd = WebSquare.session.getAttribute("biznDivCd");
		if (biznDivCd != null && biznDivCd != "") {
			comLib.setUserInfo("biznDivCd", biznDivCd);
		} else {
			comLib.setUserInfo("biznDivCd", resBody.data.biznDivCd);
		}
		comLib.setUserInfo("conectIp", resBody.data.conectIp);
		// comLib.setUserInfo("sysDivCd", resBody.data.sysDivCd);
		var sysDivCd = WebSquare.session.getAttribute("sysDivCd");
		if (sysDivCd != null || sysDivCd != "") {
			if (WebSquare.session.getAttribute("userInfo") != null
					&& WebSquare.session.getAttribute("userInfo") != "") {
				try {
					sysDivCd = JSON.parse(WebSquare.session.getAttribute("userInfo")).sysDivCd;
				} catch (e) {
				}
			}
		}
		if (sysDivCd != null && sysDivCd != "") {
			comLib.setUserInfo("sysDivCd", sysDivCd);
		} else {
			comLib.setUserInfo("sysDivCd", resBody.data.sysDivCd);
		}
		comLib.setUserInfo("usrDeptCd", resBody.data.usrDeptCd);
		comLib.setUserInfo("usrDeptNm", resBody.data.usrDeptNm);
		comLib.setUserInfo("usrId", resBody.data.usrId);
		comLib.setUserInfo("usrEmpno", resBody.data.usrEmpno);
		comLib.setUserInfo("usrJgrdCd", resBody.data.usrJgrdCd);
		comLib.setUserInfo("usrJgrdNm", resBody.data.usrJgrdNm);
		comLib.setUserInfo("usrNm", resBody.data.usrNm);
		comLib.setUserInfo("usrOfcpsCd", resBody.data.usrOfcpsCd);
		comLib.setUserInfo("usrOfcpsNm", resBody.data.usrOfcpsNm);
		comLib.setUserInfo("idvinfoDealAthrYn", resBody.data.idvinfoDealAthrYn);
	};

	// scwin.dummyLoginErrCallback = function(resBody) {
	function dummyLoginErrCallback(resBody) {
		alert(resBody.message.code_name);
		window.close();
	};

	window.onload = init; // function 아래에서 호출
	// 윈도우사이즈변경 처리
	winresize = function() {
		if ($p.top().scwin) {
			if (typeof $p.top().scwin.fnResize == 'function') {
				// console.log("execute scwin.fnResize()");
				$p.top().scwin.fnResize();
			} else {
				if ($p.top().$p.$(".w2grid:visible").length == 1) {
					// 해당 페이지에 그리드가 1개인경우 자동 높이 조절 정의 */
					var gridObjCtrl = $p.top().$p.getComponentById($p.top().$p.$(".w2grid:visible").eq(0).attr("id"));
					gridObjCtrl.setAttribute("visibleRowNum", "");
					var gridObj = $p.top().$p.$(".w2grid:visible").eq(0);
					var conbox = gridObj.parents(".content-area,.float-con");
					var gridHeight = gridObj.outerHeight(true);
					var bodyobj = $("body");
					if (bodyobj.length > 0) {
						var addOffset = 0;
						addOffset = parseInt(conbox.css("paddingBottom")); // 위아래 여백 제외
						addOffset = addOffset + parseInt(conbox.css("paddingTop"));
						//console.log("addOffset : " + addOffset);
						var etcHeight = conbox.height() - gridHeight; //컨박스에서 그리드를 제외한 사이즈 
						//console.log("etcHeight : " + etcHeight);
						var bodyHeight = bodyobj.outerHeight(true);
						//console.log("conbox.offset().top : " + conbox.offset().top); //컨박스 상위
						gridHeight = bodyHeight - conbox.offset().top - etcHeight - addOffset;
						if (gridHeight < 0) {
							return;
						}
						//console.log("gridHeight : " + gridHeight);
						gridObjCtrl.setGridHeight(gridHeight);
					}
				}
			}
		}
	};
</script>
</head>
<body></body>
</html>