<%@page import="java.io.OutputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String ozrName = request.getParameter("ozrName");
	// String[] ozrParamVal = request.getParameterValues("ozrParamVal");

	String odiName = request.getParameter("odiName");
	String[] odiParamVal = request.getParameterValues("odiParamVal");

	String fileFormat = request.getParameter("fileFormat");
	// String filePath = request.getParameter("filePath");
	String fileName = request.getParameter("fileName");

	fileName = fileName + "." + fileFormat;

	Hashtable param = new Hashtable();

	param.put("export.format", fileFormat);
	// param.put("export.path", filePath);
	param.put("export.filename", fileName);

	param.put("connection.reportname", ozrName);
	/*
	if (ozrParamVal != null) {
		param.put("connection.pcount", Integer.toString(ozrParamVal.length));
	}
	for (int i = 0; i < ozrParamVal.length; i++) {
		if (ozrParamVal[i].indexOf("=") > -1) {
			param.put("connection.args" + (i + 1), ozrParamVal[i]);
		}
	}
	*/

	if (odiParamVal != null) {
		param.put("odi.odinames", odiName);
		param.put("odi." + odiName + ".pcount", Integer.toString(odiParamVal.length));
	}

	if (odiParamVal != null) {
		for (int i = 0; i < odiParamVal.length; i++) {
			if (odiParamVal[i].indexOf("=") > -1) {
				param.put("odi." + odiName + ".args" + (i + 1), odiParamVal[i]);
			}
		}
	}

	request.setAttribute("OZViewerExportParam", param);
	RequestDispatcher dispatcher = application.getRequestDispatcher("/server");
	System.out.println(dispatcher.INCLUDE_SERVLET_PATH);
	dispatcher.include(request, response);

	Boolean result = false;
	Object o = request.getAttribute("OZViewerExportResult");

	if (o == null) {
		Throwable t = (Throwable) request.getAttribute("OZViewerExportError");
		t.printStackTrace();
	} else {
		response.setContentType("application/octet-stream; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"".replaceAll("\r", "").replaceAll("\n", ""));
		response.setHeader("Content-Description", "JSP Generated Data");
		response.setHeader("Content-Transfer-Encoding", "binary");
		// 파일의 길이(용량) 지정
		// response.setHeader("Content-Length", "" + donwloadFile.length());
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		Hashtable t = (Hashtable) o;
		Enumeration enu = t.keys();
		OutputStream os = null;
		while (enu.hasMoreElements()) {
			try {
				os = response.getOutputStream();
				String pathAndName = (String) enu.nextElement();
				byte[] b = (byte[]) t.get(pathAndName);
				os.write(b);
			} finally {
				os.flush();
				os.close();
			}
		}
	}
%>