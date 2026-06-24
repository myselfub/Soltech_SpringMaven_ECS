
var daonCommon = {};

document.domain="[BASE_DOMAIN]";
//if (top.window.location.protocol === "http:") {
//var strUrl = top.window.location + "";
//if (strUrl.indexOf("http://res.kwater") >=0) {
daonCommon.ADT_POP_URL = "https://adt.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.HRM_POP_URL = "https://hrm.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.FMS_POP_URL = "https://nfms.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.BID_POP_URL = "https://bid.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.WCB_POP_URL = "https://wcb.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.STG_POP_URL = "https://stg.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.MGT_POP_URL = "https://mgt.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.LIB_POP_URL = "https://lib.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.WRI_POP_URL = "https://wri.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.WRO_POP_URL = "https://wro.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.WFM_POP_URL = "https://wfm.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.PFM_POP_URL = "https://pfm.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.WQE_POP_URL = "https://wqe.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.LWS_POP_URL = "https://lws.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.LWP_POP_URL = "https://lwp.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.LAW_POP_URL = "https://law.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.LAO_POP_URL = "https://lao.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.CMS_POP_URL = "https://cms.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.CTS_POP_URL = "https://cts.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.WTL_POP_URL = "https://wtl.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.SCM_POP_URL = "https://scm.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.SMP_POP_URL = "https://smp.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.SRN_POP_URL = "https://srn.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;//ADD 수리안 2020.02.12
daonCommon.HMS_POP_URL = "https://hms.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;//ADD 건강관리시스템 2020.04.29
daonCommon.SCM_GET_CRTFC_URL = "https://scm.[BASE_DOMAIN]/sc/AccessCrtfcLgcGServlet" ;
daonCommon.SCM_POST_CRTFC_URL = "https://scm.[BASE_DOMAIN]/sc/AccessCrtfcLgcPServlet" ;
daonCommon.SCM_LINK_URL = "https://scm.[BASE_DOMAIN]" ;
daonCommon.ECS_POP_URL = "https://ecs.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=" ;
daonCommon.REALTIME_POP_URL = "https://realtimegios.[BASE_DOMAIN]:8917";
daonCommon.GDMS_POP_URL = "https://realtimegios.[BASE_DOMAIN]:8126";
//var console = window.console || {log:function(){}};
/**
 * Object.keys 함수는 IE9 이상에서 지원되며,
 * 호환성보기 IE7 으로 동작하는 오아시스에서의 사용이 제한되므로 별도 구현
 * - Object.keys 를 구현하기 위해 Function.prototype.bind 도 별도 구현
 */
if (!Function.prototype.bind) {  // bind function이 없을 때에만 별도 구현됨
	Function.prototype.bind = function(oThis) {
		if (typeof this !== 'function' ) {
			throw new TypeError('Function.prototype.bind - what is trying to be bound is not callable');
		}
		
		var aArgs   = Array.prototype.slice.call(arguments, 1),
		     fToBind = this,
		     fNOP    = function() {},
		     fBound  = function() {
		    	 return fToBind.apply(this instanceof fNOP
		    			  ? this
		    			  : oThis,
		    			  aArgs.concat(Array.prototype.slice.call(arguments)));
		     };
		if (this.prototype) {
			fNOP.prototype = this.prototype;
		}
		fBound.prototype = new fNOP();
		return fBound;
	}
}

if (!Object.keys) {  // Object.keys 라는 function이 없을 때에만 별도 구현됨
	var call = Function.prototype.call;
	var prototypeOfObject = Object.prototype;
	var owns = call.bind(prototypeOfObject.hasOwnProperty);
	var hasDontEnumBug = true,
		dontEnums = [
			"toString",
			"toLocaleString",
			"valueOf",
			"hasOwnProperty",
			"isPrototypeOf",
			"propertyIsEnumerable",
			"constructor"
		],
		dontEnumsLength = dontEnums.length;
	
	for (var key in {"toString": null}) {
		hasDontEnumBug = false;
	}
	
	Object.keys = function keys(object) {
		if (
			(typeof object != "object" && typeof object != "function") ||
			object === null
		) {
			throw new TypeError("Object.keys called on a non-object");
		}
		
		var keys = [];
		for (var name in object) {
			if (owns(object, name)) {
				keys.push(name);
			}
		}
		if (hasDontEnumBug) {
			for (var i = 0, ii = dontEnumsLength ; i < ii ; i++) {
				var dontEnum = dontEnums[i];
				if (owns(object, dontEnum)) {
					keys.push(dontEnum);
				}
			}
		}
		return keys;
	};
}

/**
 * 오늘 날짜(년월일시분초)를 YYYYMMDDHH24MISS 포맷의 문자열로 반환한다.
 * 
 * @date 2014. 12. 10.
 * @return <String> YYYYMMDDHH24MISS
 */
daonCommon.getDate = function() {

    var today = new Date();
    var year = today.getFullYear();
    var month = (today.getMonth() + 1);
    var day = today.getDate();
    var hour = today.getHours();
    var min = today.getMinutes();
    var second = today.getSeconds();
    var millisecond = today.getMilliseconds();

    if (parseInt(month) < 10)
        month = "0" + month;
    if (parseInt(day) < 10)
        day = "0" + day;
    if (parseInt(hour) < 10)
        hour = "0" + hour;
    if (parseInt(min) < 10)
        min = "0" + min;
    if (parseInt(second) < 10)
        second = "0" + second;
    if (parseInt(millisecond) < 10) {
        millisecond = "00" + millisecond;
    } else {
        if (parseInt(millisecond) < 100)
            millisecond = "0" + millisecond;
    }

    return String(year) + String(month) + String(day) + String(hour) + String(min) + String(second);
};


/**
 * utilLib.getDate()을 암/복호화 한다. 
 * 
 * @date 2017. 07. 27.
 * @param dataStr 암/복호화 대상 문구
 * @param divCd 암/복호화 구분자
 * @return str 암/복호화된 문구 
 */	
daonCommon.dataDecEnc =  function(dataStr, divCd) {
	var str = "";
	
	if( divCd == "D" ) {
		str = dataStr.substring(0, dataStr.length -1);
	} else {
		str = dataStr + "0";
	}
	
	return str;
};


daonCommon.accessUrl = "";
daonCommon.accessOption = "";
daonCommon.accessjsonObj = "";

/**
 * 팝업 호출 임시 인증키 발급
 * 
 * @param url : 팝업 호출 URL
 * @param callerLoginYn : 부모창의 세션으로 로그인 여부 
 */
daonCommon.getAccessCrtfcKey = function(callbackFunc) {
	// form 생성
	var body = document.getElementsByTagName("body")[0];
	var script = document.createElement('script');
	
	if (callbackFunc == "daonCommon.openPostWinPopupReal") {
		script.src = daonCommon.SCM_POST_CRTFC_URL;
	} else {
		script.src = daonCommon.SCM_GET_CRTFC_URL;
	}
	body.appendChild(script);
}


/**
 * 세션 정보를 JSON 형태로 리턴 (Get/Post 방식 사용시 파라미터)
 * @param strEnc 암호화 키값
 * @param title    title
 * @return userInfo
 */
daonCommon.getUserInfo4Param = function(jsonObj ) {
	var userInfo = jsonObj.userInfo ;
	
	return userInfo;
};

/**
 * 인증키를 받아서 팝업 호출을 한다.
 */
daonCommon.openGetWinPopup = function(url, option, jsonObj) {
	daonCommon.accessUrl = url;
	daonCommon.accessOption = option;
	daonCommon.accessjsonObj = jsonObj;
	daonCommon.getAccessCrtfcKey("daonCommon.openGetWinPopupReal");
}

/**
 * 
 * window.open 팝업창을 Get 방식으로 호출한다.
 * 
 * @date 2014. 12. 9.
 * @param {String} url 화면경로
 * @param {Object} option Popup창 파라미터 Object
 * @param {String} param1 [선택] 각 공통 팝업에서 사용되는 파라미터 정의
 * @example
 * 			var option = {    popupID : "popupSearchHelp"
								, width : 800
								, height : 600
								, title : "test"
							};
			var jsonObj = {   userInfo : comLib.getUserInfo4Param(strEnc, "Search Help");
								, rfcNm : iptRfcNm.getValue()
								, ivF4Case : iptIvF4Case.getValue()
								, isFieldNm1 : "CARRID"
								, isFieldVal1 : "AF"
								, isFieldNm2 : "CARRNAME"
								, isFieldVal2 : "Air*"
							};
 * openGetWinPopup("/template/common/xml/zzAlertPop.xml", option, jsonObj);
 */
daonCommon.openGetWinPopupReal = function(accessCrtfcKey) {
	
	var url = daonCommon.accessUrl;
	var option =daonCommon.accessOption;
	var jsonObj = daonCommon.accessjsonObj;
	
	var strOption = "";
	var strUserInfo = "";
	var strParam2 = "";
	
	//option.popupID 값 필수
	if (option.popupID == "") {
		alert("popupID 는 필수 값입니다.");
		return;
	}
	
	//option to ampersand format string
	for(var obj in option) {
		strOption = strOption + obj + "=" + option[obj] + ",";
	}
	
	var strEnc = "";
	strUserInfo = daonCommon.getUserInfo4Str(jsonObj);
	
	var strParam = "";
	var param = "";
	
	// DAON 으로의 팝업일 시 인증키를 받아서 파라미터에 포함.
	jsonObj.accessCrtfcKey = accessCrtfcKey;
	
	for(var key in jsonObj) {
		if(jsonObj.hasOwnProperty(key)) {
			if (typeof jsonObj[key] == "object"){
				for(var key2 in jsonObj[key]) {
					if (url.indexOf("?") < 0 && strParam.indexOf("?") < 0 && param.indexOf("?") < 0) {
						param = param + "?" + key2 + "=" + jsonObj[key][key2];
					} else {
						param = param + "&" + key2 + "=" + jsonObj[key][key2];
					}
				}
			} else {
				if (url.indexOf("?") < 0 && strParam.indexOf("?") < 0 && param.indexOf("?") < 0) {
					param = param + "?" + key + "=" + jsonObj[key];
				} else {
					param = param + "&" + key + "=" + jsonObj[key];
				}
			}
			
			strParam = strParam + param;
			param = "";
		}
	}
	
	var popupID      = option.popupID || "popupID01";
	var setTop       = option.setTop;
	var setLeft      = option.setLeft;
	//Oasis 요청으로 창크기조절 옵션을 추가 함. 2020.10.21
	var setResizable = "";
	if(typeof option.setResizable === "undefined" || option.setResizable === null || option.setResizable === ""){
		setResizable = "no";
	}else{
		setResizable = option.setResizable;
	}
	var width = option.width || 800;
	var height = option.height || 600;
	// 팝업 기본 좌표, 미지정 시 화면 크기를 고려하여 기본값 계산
	var top  = !setTop  ? screen.availHeight / 2 - (height / 2) - 20 : setTop;
	var left = !setLeft ? screen.availWidth  / 2 - (width  / 2) : setLeft;
	
	var windowObjRef = null;
	
	if(windowObjRef == null || windowObjRef.closed) {
		var encData = encodeURI( url+strParam );
		windowObjRef = window.open(encData, popupID, "location=no,width="+width+",height="+height+",scrollbars=yes,top="+top+",left="+left+",resizable="+setResizable);
	} else {
		windowObjRef.focus();
	}
	try { windowObjRef.opener = self; } catch (e) { }
};

/**
 * 인증키를 받아서 팝업 호출을 한다.
 */
daonCommon.openPostWinPopup = function(url, option, jsonObj) {
	daonCommon.accessUrl = url;
	daonCommon.accessOption = option;
	daonCommon.accessjsonObj = jsonObj;
	daonCommon.getAccessCrtfcKey("daonCommon.openPostWinPopupReal");
}

/**
 * 
 * window.open 팝업창을 POST 방식으로 호출한다.
 * 
 * @date 2014. 12. 9.
 * @param {String} url 화면경로
 * @param {Object} option Popup창 파라미터 Object
 * @param {Object} jsonObj Popup창 파라미터 Object
 * @example
 * 			var option = {    popupID : "popupSearchHelp"
								, width : 800
								, height : 600
								, title : "test"
							};
			var jsonObj = {   userInfo : comLib.getUserInfo4Param(strEnc, "Search Help");
								, rfcNm : iptRfcNm.getValue()
								, ivF4Case : iptIvF4Case.getValue()
								, isFieldNm1 : "CARRID"
								, isFieldVal1 : "AF"
								, isFieldNm2 : "CARRNAME"
								, isFieldVal2 : "Air*"
							};
 * openPostWinPopup("/template/common/xml/zzAlertPop.xml", option, jsonObj);
 */
daonCommon.openPostWinPopupReal = function(accessCrtfcKey) {
	
	var url = daonCommon.accessUrl;
	var option =daonCommon.accessOption;
	var jsonObj = daonCommon.accessjsonObj;
	
	var strOption = "";
	var strParam1 = "";
	var strParam2 = "";
	
	//option jsonObj to ampersand format string
	for(var obj in option) {
		strOption = strOption + obj + "=" + option[obj] + ",";
	}
	
	var popupID = option.popupID || "popupID01";
	var setTop = option.setTop;
	var setLeft = option.setLeft;
	var width = option.width || 800;
	var height = option.height || 600;
	// 팝업 기본 좌표, 미지정 시 화면 크기를 고려하여 기본값 계산
	var top  = !setTop  ? screen.availHeight / 2 - (height / 2) - 20 : setTop;
	var left = !setLeft ? screen.availWidth  / 2 - (width  / 2) : setLeft;
	
	var windowObjRef = null;
	
	// DAON 으로의 팝업일 시 인증키를 받아서 파라미터에 포함.
	jsonObj.accessCrtfcKey = accessCrtfcKey;
	
	// 팝업 호출
	if(windowObjRef == null || windowObjRef.closed || windowObjRef.opener.location.href != url) {
		windowObjRef = window.open("", popupID, "location=no,width="+width+",height="+height+",modal=yes,scrollbars=yes,top="+top+",left="+left+",resizable=no");
		windowObjRef.focus();
	} else {
		windowObjRef.focus();
	}
	try { windowObjRef.opener = self; } catch (e) { }
	
	daonCommon.submitJSON(url, jsonObj, popupID);
};



/**
 * 
 * POST 방식으로 JSON 데이터를 새로운 페이지로 submit
 * 
 * @date 2017. 07. 31.
 * @param <String>  path 새로운 페이지를 위한 URL 경로
 * @param <Object> jsonObj JSON Data
 * @param <String> targetObj form에 전달할 target
 * @example
 * 
 */
daonCommon.submitJSON = function(path, jsonObj, targetObj) {
	
	//form 생성
	var form = document.createElement('form');
	form.setAttribute('id', '__form');
	form.setAttribute('method', 'post');
	form.setAttribute('action', path);
	form.setAttribute('target', targetObj);
	
	//console.log(jsonObj["userInfo"]); 2019.08.12 안현태 과장의 요청으로 주석처리 함
	
	//JSON을 포함하는 hidden input 생성 후 form 에 추가
	for(var key in jsonObj) {
		var hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", key);
		hiddenField.setAttribute("value", jsonObj[key]);
		form.appendChild(hiddenField);
	}
	
	//body 에 추가 및 submit
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);
};


/**
 * 세션 정보를 String 형태로 리턴 (Get 방식 사용시 파라미터)
 * @param <String> strEnc 암호화 키값
 * @param <String> title    title
 * @return <String> strParam
 */
daonCommon.getUserInfo4Str = function(jsonObj ) {
	var userInfo = jsonObj.userInfo ;
	var strParam = "";
	var param = "";
	
	for(var key in userInfo) {
		if(userInfo.hasOwnProperty(key)) {
			
			param = param + "&" + key + "=" + userInfo[key];
			
			strParam = strParam + param;
			param = "";
		}
	}
	
	return strParam;
};





