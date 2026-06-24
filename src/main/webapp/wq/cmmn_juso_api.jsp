<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%--@ page errorPage="/wq/error500.html" --%>
<%@ page import="java.net.*,java.io.*,java.util.Map,java.util.LinkedHashMap"%>
<%
/********************************************************  
* Author        : JeongPyo Lee
* Date          : 2019/03/22
* File Name     : cmmn_juso_api.jsp             
* Version       : 1.0
* Last Modified : 2019/03/29
* Remark        : 도로명주소 프록시 페이지
********************************************************/
%>
<%
	//request.setCharacterEncoding("utf-8");

	out.clear();
	//out.setContentType("");

	String strGUBUN = request.getParameter("GUBUN");
	String strENC = request.getParameter("ENC");
	if( strENC == null || "".equals(strENC) ) { strENC = "UTF-8"; } 
	String strKeyword = request.getParameter("keyword");
	String strCurrentPage =  request.getParameter("currentPage");
	if(strCurrentPage == null || "".equals(strCurrentPage)) { strCurrentPage = "1"; }  
	String strCountPerPage =  request.getParameter("countPerPage");
	if(strCountPerPage == null || "".equals(strCountPerPage)) { strCountPerPage = "10"; }
	if( strGUBUN == null ) { strGUBUN = ""; } 
	String CURRENT_IP = request.getRemoteAddr(); // IP주소
	String strTOKEN = "1";
	//String strUrl="http://[INTERNAL_IP]:[PORT]/rest/LogService?MenuID=" + strMENUID + "&EmpNo=" + strEMPNO + "&EmpName=" + strEMPNM + "&DeptName=" + strDEPTNM + "&ClientIP=" + CURRENT_IP + "&token=" + strTOKEN;
	String strUrl= "";
	if( strGUBUN.equals("") ) {
		strUrl="http://www.juso.go.kr/addrlink/addrLinkApiJsonp.do";
	} else {
		strUrl = "http://lws.[BASE_DOMAIN]/error.html"; 
	}
	
	String strConfirmKey = "U01TX0FVVEgyMDE4MDczMDE1NTc1ODEwODA0MDQ="; // 컨펌키
	/*
					,data        : {"confmKey"     : "[JUSO_API_KEY]"
				               ,"currentPage"  : "1"
				               ,"countPerPage" : "10"
				               ,"keyword"      :  keyword
				               ,"resultType"   : "json"}
	*/
	try {

		URL url = new URL(strUrl);
		
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("confmKey", strConfirmKey);
		params.put("currentPage", strCurrentPage);
		params.put("countPerPage", strCountPerPage);
		params.put("resultType", "json");
		params.put("keyword", strKeyword);
				 
		StringBuilder postData = new StringBuilder();
		for(Map.Entry<String, Object> param : params.entrySet()) {
			
			if(postData.length() != 0) { postData.append('&'); }
				
			postData.append(URLEncoder.encode(param.getKey(), strENC));
			postData.append('=');
			postData.append(URLEncoder.encode(String.valueOf(param.getValue()), strENC));
			
		} // for
		
		byte[] postDataBytes = postData.toString().getBytes(strENC);

		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("charset", strENC);
		//conn.setRequestProperty("Content-Length", postData.length);
		conn.setDoOutput(true);
		conn.setConnectTimeout(3000);
		conn.setReadTimeout(10 *1000);
		conn.getOutputStream().write(postDataBytes);
		
		BufferedReader in = null;
		String strOutput = "";
		
		try {
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String s = "";
		
			while((s=in.readLine()) != null) {
				strOutput += s; 
			}
			out.print(strOutput);
		}catch(IOException ex) {
			out.print("{\"error\":\"입출력 오류발생\"}");
			//out.print(ex.toString());
			//jeus.util.Logger.log("●로그정보시스템 오류발생:" + ex.toString(), jeus.util.Logger.INFORMATION);
		} finally {
			if( in != null )  try { in.close(); } catch(Exception ex) {}
		}
		
		//out.print("complete");

		
	} catch(Exception ex) {
		out.print("{\"error\":\"기타 오류발생\"}");
		//out.print(ex.toString());
	}
	

%>