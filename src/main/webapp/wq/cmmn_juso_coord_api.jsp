<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%--@ page errorPage="/wq/error500.html" --%>
<%@ page import="java.net.*,java.io.*,java.util.Map,java.util.LinkedHashMap"%>
<%
/********************************************************  
* Author        : JeongPyo Lee
* Date          : 2019/03/29
* File Name     : cmmn_juso_coord_api.jsp             
* Version       : 1.0
* Last Modified : 2019/03/29
* Remark        : 도로명주소 좌표조회 프록시 페이지
********************************************************/
%>
<%
	request.setCharacterEncoding("utf-8");

	out.clear();
	//out.setContentType("");

	String strGUBUN = request.getParameter("GUBUN");
	String strAdmCd = request.getParameter("admCd");
	String strRnMgtSn = request.getParameter("rnMgtSn");
	String strUdrtYn = request.getParameter("udrtYn");
	String strBuldMnnm = request.getParameter("buldMnnm");
	String strBuldSlno = request.getParameter("buldSlno");
	
	if( strGUBUN == null ) { strGUBUN = ""; } 
	String CURRENT_IP = request.getRemoteAddr(); // IP주소
	String strTOKEN = "1";
	//String strUrl="http://[INTERNAL_IP]:[PORT]/rest/LogService?MenuID=" + strMENUID + "&EmpNo=" + strEMPNO + "&EmpName=" + strEMPNM + "&DeptName=" + strDEPTNM + "&ClientIP=" + CURRENT_IP + "&token=" + strTOKEN;
	String strUrl= "";
	if( strGUBUN.equals("") ) {
		strUrl="http://www.juso.go.kr/addrlink/addrCoordApiJsonp.do";
	} else {
		strUrl = "http://lws.[BASE_DOMAIN]/error.html"; 
	}
	
	String strConfirmKey = "U01TX0FVVEgyMDE4MDczMDE2MDA0MDEwODA0MDY="; // 컨펌키
	
	/*
					"confmKey"   : "U01TX0FVVEgyMDE4MDczMDE2MDA0MDEwODA0MDY="
				               ,"admCd"      : item.admCd
				               ,"rnMgtSn"    : item.rnMgtSn
				               ,"udrtYn"     : item.udrtYn
				               ,"buldMnnm"   : item.buldMnnm
				               ,"buldSlno"   : item.buldSlno
				               ,"resultType" : "json"}
	*/
	
	try {

		URL url = new URL(strUrl);
		
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("confmKey", strConfirmKey);
		params.put("admCd", strAdmCd);
		params.put("rnMgtSn", strRnMgtSn);
		params.put("udrtYn", strUdrtYn);
		params.put("buldMnnm", strBuldMnnm);
		params.put("buldSlno", strBuldSlno);
		params.put("resultType", "json");
				 
		StringBuilder postData = new StringBuilder();
		for(Map.Entry<String, Object> param : params.entrySet()) {
			
			if(postData.length() != 0) { postData.append('&'); }
				
			postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			
		} // for
		
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");

		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("charset", "utf-8");
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