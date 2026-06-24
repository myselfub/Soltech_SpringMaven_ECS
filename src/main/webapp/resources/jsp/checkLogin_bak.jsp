<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kw.fw.vo.SessionVo"%>
<%@page import="kw.fw.util.ApplicationContextAwareUtil"%>
<%@page import="egovframework.rte.fdl.property.EgovPropertyService"%>
<%@page contentType="text/html; charset=utf-8" language="java" import="java.net.*,java.util.*,java.io.*,kw.fw.util.SessionUtil"%>
<%
boolean isLogin = false ;

SessionVo sessionVo = SessionUtil.getLoginSession(request) ;

if (sessionVo != null) {
	String usrId			= sessionVo.getUsrId() == null ? "" : sessionVo.getUsrId();

	if ("".equals(usrId) ) {
		isLogin = false ;
	}
	else
	{
		isLogin = true ;
	}
}
	String redirectUrl = request.getParameter("w2xPath");
	String contextRoot = request.getContextPath();


	EgovPropertyService propertiesService = (EgovPropertyService) ApplicationContextAwareUtil.getBean("propertiesService");

	String runMode = propertiesService.getString("run.mode") ;

	String domainName = System.getProperty("jeus.domain.name") ;
	String osName =  System.getProperty("os.name") ;
	String systype  = "" ;

	if ("".equals(domainName) || domainName == null ) {
		if (osName.startsWith("Windows")) {
			systype = "(LOCAL PC)" ;

		}
	}
	else {

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


	if (redirectUrl != null){
		if  ( isLogin == false) {
			//response.sendRedirect(contextRoot + "/wq/index.jsp?w2xPath=" + contextRoot + "/ui/login.xml");
			%>
			<script type="text/javascript">
			<!--
			if (parent && parent != this) {
				parent.location.href= '<%=contextRoot%>' + '/wq/index.jsp?w2xPath=' + '<%=contextRoot%>' + '/ui/login.xml';
			}
			else{
				window.location.href= '<%=contextRoot%>' + '/wq/index.jsp?w2xPath=' + '<%=contextRoot%>' + '/ui/login.xml';
			}
			//-->
			</script>
			<%
		}
	}
	else{
		if  ( isLogin ) {
			response.sendRedirect(contextRoot + "/wq/index.jsp?w2xPath=" + contextRoot + "/ui/index.xml");
		}
		else {
			if (runMode.equals("localhost")) {
				response.sendRedirect(contextRoot + "/wq/index.jsp?w2xPath=" + contextRoot + "/ui/login.xml");
			}
			else if (runMode.equals("localhost") && ( domainName.equals("imdevweb1") || domainName.equals("imdevsapap") ) ) {
				response.sendRedirect(contextRoot + "/wq/index.jsp?w2xPath=" + contextRoot + "/ui/login.xml");
			}
			else if (runMode.equals("server")) {
				// 정식 운영 전에는 운영도메인으로 접근할 수 있도록 처리함
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String ymd = sdf.format(new Date());
				if(Integer.parseInt(ymd) < 20181005) {
					response.sendRedirect(contextRoot + "/wq/index.jsp?w2xPath=" + contextRoot + "/ui/login.xml");
				} else {
					%>
				<script type="text/javascript">
					alert("비정상적인 접근 입니다. OASIS를 통해서만 접근이 가능합니다. ") ;
					window.close();
				</script>
				<%
				}
			}

		}

	}
%>
