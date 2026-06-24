<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
var agent = navigator.userAgent.toLowerCase();

if (agent.indexOf("chrome") != -1) {
	window.open("./resources/jsp/checkLogin.jsp","ECS", "location=no,directories=no, resizable=yes,status=no,toolbar=no,menubar=no,width=1024,height=768,left=0,top=0,scrollbars=yes") ;
	self.close();
} else {
	window.open("./resources/jsp/checkLogin.jsp","ECS", "location=no,directories=no, resizable=yes,status=no,toolbar=no,menubar=no,width=1024,height=768,left=0,top=0,scrollbars=yes") ;
	top.window.open("about:blank", "_self").close();
	top.window.opener=self;
	top.self.close();
}
</script>