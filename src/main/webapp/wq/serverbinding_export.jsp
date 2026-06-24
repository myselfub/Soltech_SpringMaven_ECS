<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<form name="form1" method="get" action="./export.jsp" accept-charset="ks_c_5601-1987">
  <input type="hidden" name="ozserverexport" value="true">
  <input type="hidden" name="download" value="true">
  <input type="hidden" name="filename" value="sample.pdf">
  <input type="hidden" name="exportview" value="true">
  <input type="hidden" name="connection.reportname" value="sample.ozr">
  <!--input type="hidden" name="odi.odinames" value="emp"-->
  <input type="submit" name="submit" value="조회">
</form>
</body>
</html>