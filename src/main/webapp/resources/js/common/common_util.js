/** 
 * @target  각종 Util 공통 함수
 * @type	utilLib
 * @since   2017.04.03
 * @author TJ Kim
 */

var utilLib = {};

utilLib.INVALID_COLOR_MANDATORY 	= "rgba(247, 217, 204, 1)";		// 필수
utilLib.INVALID_COLOR_MAXLENGTH 	= "#2EC6C8";					// 최대길이
utilLib.INVALID_COLOR_MINLENGTH 	= "#2EC6C8";					// 최소길이
utilLib.INVALID_COLOR_NUMBER 		= "#2EC6C8";					// 숫자
utilLib.INVALID_COLOR_ALPHANUMBER 	= "#2EC6C8";					// 알파벳, 숫자만 허용
utilLib.INVALID_COLOR_HANGUL 		= "#2EC6C8";					// 한글만 허용

// 범례 : 숫자 - #2ec6c8, 자릿수 - #b5a1dd, 코드체크 - #5ab0ee, 내용체크 - #f4984e, 예비 - #d77a80
utilLib.INVALID_COLOR_LENGTH  	= "#B5A1DD";		// 자릿수 : 최대, 최소 ?
utilLib.INVALID_COLOR_CODE 		= "#5AB0EE";		// 코드체크
utilLib.INVALID_COLOR_CONTENT 	= "#F4984E";		// 내용체크
utilLib.INVALID_COLOR_EXTRA 	= "#D77A80";		// 예비

// skin css 기본, 그린, 보라, 회색, 청록
utilLib.SKIN_DEFAULT = "";
utilLib.SKIN_GREEN = "/resources/css/skin_green.css";
utilLib.SKIN_PURPLE = "/resources/css/skin_purple.css";
utilLib.SKIN_GRAY = "/resources/css/skin_gray.css";
utilLib.SKIN_COOLGREEN = "/resources/css/skin_coolgreen.css";

// ==========================================================================================
/**
 * 오늘 날짜(년월일시분초)를 YYYYMMDDHH24MISS 포맷의 문자열로 반환한다.
 * 
 * @date 2014. 12. 10.
 * @return <String> YYYYMMDDHH24MISS
 */
utilLib.getDate = function() {
	var today = new Date();
	var year = today.getFullYear();
	var month = (today.getMonth() + 1);
	var day = today.getDate();
	var hour = today.getHours();
	var min = today.getMinutes();
	var second = today.getSeconds();
	var millisecond = today.getMilliseconds();

	if (parseInt(month) < 10) {
		month = "0" + month;
	}
	if (parseInt(day) < 10) {
		day = "0" + day;
	}
	if (parseInt(hour) < 10) {
		hour = "0" + hour;
	}
	if (parseInt(min) < 10) {
		min = "0" + min;
	}
	if (parseInt(second) < 10) {
		second = "0" + second;
	}
	if (parseInt(millisecond) < 10) {
		millisecond = "00" + millisecond;
	} else {
		if (parseInt(millisecond) < 100) {
			millisecond = "0" + millisecond;
		}
	}

	return String(year) + String(month) + String(day) + String(hour) + String(min) + String(second);
};

/**
 * 서버의 현재 날짜를 가져옵니다.
 *
 * @param pattern: 조회할 날짜 패턴
 *	- y Year: 1996, 96
 *	- M Month: 07
 *	- d Day: 10
 *	- H Hour: (0-23) 0
 *	- m Minute: 30
 *	- s Second: 55
 *	- S Millisecond: 978
 *
 * @returns 지정한 패턴의 서버 날짜 문자열
 */
utilLib.getCurrentDate = function(pattern) {
	if (typeof pattern == "undefined" || parent == null || parent == "") {
		pattern = "yyyyMMdd"; // yyyy-MM-dd
	}
	/* 웹스퀘어 버그로 변경 추후 패치시 원래대로 처리예정 */
	var str = WebSquare.date.getCurrentServerDate("yyyyMMddHHmmssSSS");
	var yyyy = str.substring(0, 4);
	var yy = str.substring(2, 4);
	var MM = str.substring(4, 6);
	var dd = str.substring(6, 8);
	var HH = str.substring(8, 10);
	var mm = str.substring(10, 12);
	var ss = str.substring(12, 14);
	var SSS = str.substring(14, 17);
	pattern = pattern.replace(/yyyy/gi, yyyy).replace(/yy/gi,yy).replace(/MM/gi, MM).replace(/M/gi,parseInt(MM)).replace(/dd/gi, dd).replace(/d/gi, parseInt(dd));
	pattern = pattern.replace(/HH/gi, HH).replace(/H/gi,parseInt(HH)).replace(/mm/gi, mm).replace(/m/gi,parseInt(mm)).replace(/ss/gi, ss).replace(/s/gi, parseInt(ss));
	pattern = pattern.replace(/SSS/gi, SSS).replace(/S/gi,parseInt(SSS));
	return pattern;
	/* 웹스퀘어 버그로 변경 추후 패치시 원래대로 처리예정 끝 */
	return WebSquare.date.getCurrentServerDate(pattern);
};

/**
 * 해당 월의 마지막날을 return
 * 
 * @date 2018. 11. 13.
 * @return <int> dd
 */
utilLib.getEndOfMonth = function(yyyyMMdd) {
	var strDate = yyyyMMdd.replaceAll("-", "");
	var date = new Date(strDate.substr(0, 4), strDate.substr(4, 2), 0);

	return date.getDate();
};

/**
 * 날짜형 변수로 변환한다. (yyyyMMdd)
 * 
 * @date 2014. 12. 10.
 * @param <String> pdate 날짜
 * @param <String> flag 구분자(/, .)
 * @return <String> 날짜형 변수
 * @example 
 * utilLib.makeDateFormat("20120719", "/") ==> 2012/07/19
 */
utilLib.makeDateFormat = function(pdate, flag) {
	var yy = "";
	var mm = "";
	var dd = "";
	var yymmdd;
	var ar;
	if (pdate.indexOf(".") > -1) { // yyyy.mm.dd
		ar = pdate.split(".");
		yy = ar[0];
		mm = ar[1];
		dd = ar[2];
		if (mm < 10) {
			mm = "0" + mm;
		}
		if (dd < 10) {
			dd = "0" + dd;
		}
	} else if (pdate.indexOf("-") > -1) { // yyyy-mm-dd
		ar = pdate.split("-");
		yy = ar[0];
		mm = ar[1];
		dd = ar[2];
		if (mm < 10) {
			mm = "0" + mm;
		}
		if (dd < 10) {
			dd = "0" + dd;
		}
	} else if (pdate.length == 8) {
		yy = pdate.substr(0, 4);
		mm = pdate.substr(4, 2);
		dd = pdate.substr(6, 2);
	}
	var p = "/";
	if ((typeof flag != "undefined" && flag != "" && flag != null)) {
		p = flag;
	}

	yymmdd = yy + p + mm + p + dd;
	// yymmdd = new Date(yymmdd);

	return yymmdd;
};

/**
 * 특정일자에 날짜를 더한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> 년월일 (yyyyMMdd)
 * @param <Number> arg 더할 날짜
 * @return YYYYMMDD
 */
utilLib.addDay = function(pYmd, offset) {
	var yyyy = pYmd.substr(0, 4);
	var mm = eval(pYmd.substr(4, 2) + "- 1");
	var dd = pYmd.substr(6, 2);

	var dt3 = new Date(yyyy, mm, eval(dd + "+" + offset));

	yyyy = dt3.getFullYear();

	mm = (dt3.getMonth() + 1) < 10 ? "0" + (dt3.getMonth() + 1) : (dt3.getMonth() + 1);
	dd = dt3.getDate() < 10 ? "0" + dt3.getDate() : dt3.getDate();

	return "" + yyyy + "" + mm + "" + dd;
};

/**
 * 오늘 일자에 날짜를 던한다.
 * 
 * @date 2014. 12. 10.
 * @param <Number> arg 더할 날짜
 * @return YYYYMMDD
 */
utilLib.addToDay = function(arg) {
	var sz_ymd;
	if (arg == "") {
		arg = 0;
	}

	var date = new Date();
	date.setFullYear(date.getFullYear()); // y년을 더함
	date.setMonth(date.getMonth()); // m월을 더함
	date.setDate(date.getDate() + arg); // d일을 더함

	sz_ymd = "" + date.getFullYear();

	if (date.getMonth() < 9) {
		sz_ymd += "0" + (date.getMonth() + 1);
	} else {
		sz_ymd += (date.getMonth() + 1);
	}
	if (date.getDate() < 10) {
		sz_ymd += "0" + date.getDate();
	} else {
		sz_ymd += "" + date.getDate();
	}
	return sz_ymd;
};

/**
 * 일자에 월을 더해서 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> date 일자
 * @param <Number> add 추가할 개월 수
 * @return 날짜 문자열(yyyyMMdd)
 * @description
 * 1.임의의 년월일(yyyyMMdd)에 원하는 월 수만큼 가감(+/-)한 결과의 년월일에 해당하는 yyyyMMdd 문자열을 리턴한다 
 * 2.임의의 년월(yyyyMM)에 원하는 월 수만큼 가감(+/-)한 결과의 년월에 해당하는 yyyyMM 문자열을 리턴한다
 */
utilLib.addToDay = function(date, add) {
	// var add = "-1";
	var rtnGb = "1"; // 8자리

	// 6자리 입력 시 01 을 추가하여 8자리 날자로 처리한다.
	if (date.length == 6) {
		date = date + "01";
		rtnGb = "2";
	}

	var yyyy = date.substring(0, 4);
	var mm = date.substring(4, 6);
	var dd = date.substring(6, 8);

	mm = (mm * 1) + (add * 1);

	var cDate = new Date(yyyy, mm - 1, dd);
	var cYear = cDate.getFullYear();
	var cMonth = cDate.getMonth() + 1;

	if ((cMonth + "").length < 2) {
		cMonth = "0" + cMonth;
	}

	var cDay = cDate.getDate();

	if ((cDay + "").length < 2) {
		cDay = "0" + cDay;
	}

	var ynDay = "";

	if (rtnGb == "1") {
		ynDay = cYear + "" + cMonth + "" + cDay;
	} else {
		ynDay = cYear + "" + cMonth;
	}
	return ynDay;
};

/**
 * 오늘날짜에서 년/월/일을 자유롭게 더하고 뺀 결과를 문자열로 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param year 가감할년수
 * @param month 가감할월수
 * @param day 가감할일수
 * @return YYYYMMDD
 */
utilLib.calcToday = function(year, month, day) {
	var sz_ymd;
	if (year == "") {
		year = 0;
	}
	if (month == "") {
		month = 0;
	}
	if (day == "") {
		day = 0;
	}

	var date = new Date();
	date.setFullYear(date.getFullYear() + year); // y년을 더함
	date.setMonth(date.getMonth() + month); // m월을 더함
	date.setDate(date.getDate() + day); // d일을 더함

	sz_ymd = "" + date.getFullYear();

	if (date.getMonth() < 9) {
		sz_ymd += "0" + (date.getMonth() + 1);
	} else {
		sz_ymd += (date.getMonth() + 1);
	}
	if (date.getDate() < 10) {
		sz_ymd += "0" + date.getDate();
	} else {
		sz_ymd += "" + date.getDate();
	}
	return sz_ymd;
};

/**
 * 날짜를 받아서 요일로 변환한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> v_date 날짜(yyyyMMdd)
 * @return int
 */
utilLib.getDayNum = function(v_date) {
	if (v_date.length < 0) {
		return;
	}

	var v_year = v_date.substr(0, 4);
	var v_month = v_date.substr(4, 2);
	var v_day = v_date.substr(6, 2);

	var m = parseInt(v_month, 10) - 1;
	var d = parseInt(v_day, 10);

	var end = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	if ((v_year % 4 == 0 && v_year % 100 != 0) || v_year % 400 == 0) {
		end[1] = 29;
	}

	if (d < 1 || d > end[m]) {
		return;
	}

	var newDate = new Date(v_year, v_month, v_day);

	return parseInt(String(newDate.getDay()));
};

/**
 * 두 개의 날짜를 비교한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> fromDate 시작일자
 * @param <String> toDate 종료일자
 * @description fromDate 가 toDate 보다 큰지 체크
 * @example utilLib.compareDate( "20110204", "20110305" )
 * @return <String> 9 : 비교 조건부족, 0 : 오류, 1 : 정상
 */
utilLib.compareDate = function(fromDate, toDate) {
	var flag = "9";
	if (fromDate != "" && toDate != "") {
		if (fromDate > toDate) {
			flag = "0";
		} else {
			flag = "1";
		}
	}
	return flag;
};

/**
 * 두 날짜 사이의 차일을 리턴한다
 * 
 * @date 2014. 12. 10.
 * @param <String> fromdate 시작날짜
 * @param <String> todate 종료날짜
 * @return 종료날짜에서 시작날짜의 차일
 * @example utilLib.minusDates("20120102", "20121201")
 */
utilLib.minusDates = function(fromDate, toDate) {
	var tmpFromDate = new Date(parseInt(Number(fromDate.substring(0, 4))), parseInt(Number(fromDate.substring(4, 6))) - 1, parseInt(Number(fromDate.substring(6))));
	var tmpNextDate = new Date(parseInt(Number(toDate.substring(0, 4))), parseInt(Number(toDate.substring(4, 6))) - 1, parseInt(Number(toDate.substring(6))));
	var days = (tmpNextDate - tmpFromDate) / (3600 * 24 * 1000);

	return days;
};

/**
 * 두 월 사이의 차월을 리턴한다
 * 
 * @date 2023. 08. 01.
 * @param <String> frommonth 시작월
 * @param <String> tomonth 종료월
 * @return 종료월에서 시작월의 차월
 * @example utilLib.minusMonths("201201", "201212")
 */
utilLib.minusMonths = function(fromMonth, toMonth) {
	var tmpFromMonth = new Date(parseInt(Number(fromMonth.substring(0, 4))), parseInt(Number(fromMonth.substring(4, 6))) - 1, 1);
	var tmpNextMonth = new Date(parseInt(Number(toMonth.substring(0, 4))), parseInt(Number(toMonth.substring(4, 6))) - 1, 1);
	var months = (tmpNextMonth - tmpFromMonth) / (3600 * 24 * 1000 * 30);

	return months.toFixed(0);
};

/**
 * 두 년 사이의 차년을 리턴한다
 * 
 * @date 2023. 08. 01.
 * @param <String> fromyear 시작월
 * @param <String> toyear 종료월
 * @return 종료월에서 시작월의 차월
 * @example utilLib.minusYears("201201", "201212")
 */
utilLib.minusYears = function(fromYear, toYear) {
	var tmpFromYear = new Date(parseInt(Number(fromYear.substring(0, 4))), 0, 1);
	var tmpNextYear = new Date(parseInt(Number(toYear.substring(0, 4))), 0, 1);
	var years = (tmpNextYear - tmpFromYear) / (3600 * 24 * 1000 * 30 * 12);

	return years.toFixed(0);
};

/**
 * 입력받은 from월로부터 입력to월까지 개월 수를 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> fMonth 시작월
 * @param <String> tMonth 종료월
 * @return <number> 개월 수
 * @example utilLib.getMonthTerm("201102", "201303")
 */
utilLib.getMonthTerm = function(fMonth, tMonth) {
	var iMonth = 0; // 계산된 개월수
	var iYear = 0; // 계산된 년도
	var rMonth = 0; // 반환할 개월수

	if (parseInt(fMonth) <= parseInt(tMonth)) {
		iYear = parseInt(tMonth.substr(0, 4)) - parseInt(fMonth.substr(0, 4));
		iMonth = parseInt(tMonth.substr(4, 2), 10) - parseInt(fMonth.substr(4, 2), 10);
		rMonth = (12 * iYear) + iMonth + 1;
		return rMonth;
	} else {
		return 0;
	}
};

/**
 * 입력받은 fromQuarter로부터 입력toQuarter까지 Quarter수반환하기
 * 
 * @date 2014. 12. 10.
 * @param <String> fQuarter 시작 Quarter
 * @param <String> tQuerter 종료 Quarter
 * @return 총 Quarter 수
 * @example utilLib.getQuarterTerm( "20111", "20132" )
 */
utilLib.getQuarterTerm = function(fQuarter, tQuarter) {
	var iQuarter = 0; // 계산된 Quarter수
	var iYear = 0; // 계산된 년도
	var rQuarter = 0; // 반환할 Quarter수

	if (parseInt(fQuarter) <= parseInt(tQuarter)) {
		iYear = parseInt(tQuarter.substr(0, 4)) - parseInt(fQuarter.substr(0, 4));
		iQuarter = parseInt(tQuarter.substr(4, 1), 10) - parseInt(fQuarter.substr(4, 1), 10);
		rQuarter = (4 * iYear) + iQuarter + 1;
		return rQuarter;
	} else {
		return 0;
	}
};

/**
 * 날짜형식 체크한다. (yyyyMMdd)
 * 
 * @date 2014. 12. 10.
 * @param <String> str 날짜, len 체크자리수
 * @return 정상이면 true, 그외는 false
 * @example utilLib.isDate("20120719")
 * @example utilLib.isDate("20120719", 8)
 * @example utilLib.isDate("201207", 6)
 */
utilLib.isDate = function(str, len) {
	var year_data = "";
	var month_data = "";
	var date_data = "";
	var i;
	if (!len) {
		len = 8;
	} else if (len != 4 && len != 6 && len != 8) {
		return false;
	}

	str = str.replaceAll("/", "");
	str = str.replaceAll("-", "");
	str = str.replaceAll(".", "");
	if (str.length != len) {
		return false;
	}

	for (i = 0; i < len; i++) {
		var c = str.charAt(i);
		if (c < "0" || c > "9") {
			return false;
		}
		if (i < 4) {
			year_data += c;
		} else if (i >= 4 && i < 6) {
			month_data += c;
		} else if (i >= 6) {
			date_data += c;
		}
	}

	var yr = parseInt(year_data);
	if (yr < 1) {
		return false;
	}
	var mnthst = month_data;
	if (len <= 4) {
		var mnth = 1;
	} else {
		var mnth = parseInt(mnthst, 10);
	}
	if (len <= 6) {
		var dy = 1;
	} else {
		var dy = parseInt(date_data, 10);
	}

	if (mnth < 1 || mnth > 12 || dy < 1 || dy > 31) {
		return false;
	}

	if (mnth != 2) {
		if (mnth == 4 || mnth == 6 || mnth == 9 || mnth == 11) {
			if (dy > 30) {
				return false;
			}
		} else if (mnth == 1 || mnth == 3 || mnth == 5 || mnth == 7 || mnth == 8 || mnth == 10 || mnth == 12) {
			if (dy > 31) {
				return false;
			}
		} else {
			return false;
		}
	} else {
		var maxdy;
		if ((yr % 400 == 0) || ((yr % 4 == 0) && (yr % 100 != 0))) {
			maxdy = 29;
		} else {
			maxdy = 28;
		}

		if (dy > maxdy) {
			return false;
		}
	}
	return true;
};

//==========================================================================================

/**
 * @target JSON 처리 관련 공통 함수
 */

/**
 * JSON 을 정의한 NODE XML형태로 변환하여 반환한다. 
 * 
 * @date 2014. 12. 10.
 * @param <Object> jsondata JSON 문자열
 * @return <Object> JSON 을 XML로 변환하여, 변환된 XML을 반환한다.
 * @description
 * config.xml 파일의 아래의 내용을 추가한다.
 * <br/><WebSquare> <json> <json2xmlFunction value="customJSON2XML" /> </json> </WebSquare>
 */
utilLib.customJSON2XML = function(jsondata) {
	var objJson;

	if (jsondata.constructor === String) {
		objJson = eval("(" + jsondata + ")");
	} else {
		objJson = jsondata;
	}

	var resultArr = [];
	var objoptag = "<" + gParma.dataNode + ">";
	var arroptag = "<" + gParma.listNode + ">";
	var objcptag = "</" + gParma.dataNode + ">";
	var arrcptag = "</" + gParma.listNode + ">";
	var type = -1;

	if (gf_isArrayObj(objJson)) {
		type = 1;
		resultArr.push(arroptag);
	} else if (typeof objJson == "object") {
		type = 2;
		resultArr.push(objoptag);
	}

	for (var i in objJson) {
		utilLib.recursiveJSON2XML(resultArr, objJson[i], i, type);
	}

	if (gf_isArrayObj(objJson)) {
		resultArr.push(arrcptag);
	} else if (typeof objJson == "object") {
		resultArr.push(objcptag);
	}

	var xmlstr = resultArr.join("");
	var xmldoc = WebSquare.xml.parse(xmlstr);

	return xmldoc;
};

/**
 * JSON 을 정의한 NODE XML형태로 변환하여 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <Array> resultArr 결과 정보를 담는 Array
 * @param <Object> objJson JSON
 * @param <String> key 노드명
 * @param <String> type 상위 노드의 노드 타입 type (1:Array, 2:Object)
 * @return <Object> JSON 을 XML로 변환하여, 변환된 XML을 반환한다.
 */
utilLib.recursiveJSON2XML = function(resultArr, objJson, key, type) {
	var objoptag = "<" + gParma.dataNode + " id=\"" + key + "\" type=\"object\">";
	var arroptag = "<" + gParma.listNode + " id=\"" + key + "\" type=\"array\">";
	var objcptag = "</" + gParma.dataNode + ">";
	var arrcptag = "</" + gParma.listNode + ">";

	if (objJson == null) {
		if (isNaN(parseInt(key))) {
			resultArr.push("<" + key + "/>");
		} else {
			resultArr.push("<NotKey id=\"" + key + "\"/>");
		}
	} else if (typeof objJson == "string") {
		if (type == 1) { // array
			resultArr.push("<value type=\"string\">" + WebSquare.xml.encode(objJson) + "</value>");
		} else if (type == 2) {
			if (isNaN(parseInt(key))) {
				resultArr.push("<" + key + " type=\"string\">" + WebSquare.xml.encode(objJson) + "</" + key + ">");
			} else {
				resultArr.push("<value id=\"" + key + "\" type=\"string\">" + WebSquare.xml.encode(objJson) + "</value>");
			}
		}
	} else if (typeof objJson == "number") {
		if (type == 1) { // array
			resultArr.push("<value type=\"number\">" + objJson + "</value>");
		} else if (type == 2) {
			if (isNaN(parseInt(key))) {
				resultArr.push("<" + key + " type=\"number\">" + objJson + "</" + key + ">");
			} else {
				resultArr.push("<value id=\"" + key + "\" type=\"number\">" + objJson + "</value>");
			}
		}
	} else if (typeof objJson == "boolean") {
		if (type == 1) { // array
			resultArr.push("<value type=\"boolean\">" + objJson + "</value>");
		} else if (type == 2) {
			if (isNaN(parseInt(key))) {
				resultArr.push("<" + key + " type=\"boolean\">" + objJson + "</" + key + ">");
			} else {
				resultArr.push("<value id=\"" + key + "\" type=\"boolean\">" + objJson + "</value>");
			}
		}
	} else if (gf_isArrayObj(objJson)) {
		type = 1;
		resultArr.push(arroptag);

		for (var j in objJson) {
			utilLib.recursiveJSON2XML(resultArr, objJson[j], j, type);
		}

		resultArr.push(arrcptag);
	} else if (typeof objJson == "object") {
		type = 2;
		resultArr.push(objoptag);

		for (var j in objJson) {
			utilLib.recursiveJSON2XML(resultArr, objJson[j], j, type);
		}

		resultArr.push(objcptag);
	}
};

/**
 * XML정보를 JSON으로 변환한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> node JSON변환 대상 XML
 * @param <Array> jsonStr JSON 형태의 Array 데이터
 * @param <Boolean> isPair 노드명을 " 로 감싸기 위한 flag
 */

utilLib.parseXmlForJSON = function(node, jsonStr, isPair) {
	var type = node.getAttribute("type");
	var nodeid = node.getAttribute("id");

	if (!type) {
		type = utilLib.parseType(node);
	}

	if (isPair) {
		jsonStr.push("\"");
		if (nodeid != null && nodeid != "")
			jsonStr.push(nodeid);
		else
			jsonStr.push(node.nodeName);
		jsonStr.push("\" : ");
	}

	if (type === "object") {
		var isFirst = true;
		jsonStr.push("{");

		for (var i = 0; i < node.childNodes.length; i++) {
			if (node.childNodes[i].nodeType == 1) {
				if (isFirst) {
					isFirst = false;
				} else {
					jsonStr.push(", ");
				}

				jsonStr.push(utilLib.parseXmlForJSON(node.childNodes[i], jsonStr, true));
			}
		}

		jsonStr.push("}");
	} else if (type === "array") {
		var isFirst = true;
		jsonStr.push("[");

		for (var i = 0; i < node.childNodes.length; i++) {
			if (node.childNodes[i].nodeType == 1) {
				if (isFirst) {
					isFirst = false;
				} else {
					jsonStr.push(", ");
				}

				jsonStr.push(utilLib.parseXmlForJSON(node.childNodes[i], jsonStr, false));
			}
		}

		jsonStr.push("]");
	} else if (type === "number") {
		if (node.childNodes && node.childNodes[0].nodeValue) {
			jsonStr.push(node.childNodes[0].nodeValue);
		}
	} else if (type === "true") {
		jsonStr.push("true");
	} else if (type === "false") {
		jsonStr.push("false");
	} else if (type === "null") {
		jsonStr.push("null");
	} else {
		jsonStr.push("\"");

		if (node.childNodes && node.childNodes[0]) {
			jsonStr.push(WebSquare.xml.decode(node.childNodes[0].nodeValue).replaceAll("\\", "\\\\").replaceAll("\"", "\\\"").replaceAll("\n", "\\n"));
		}

		jsonStr.push("\"");
	}
};

/**
 * XML을 JSON으로 변환하여 String으로 반환한다. 
 * 
 * @date 2014. 12. 10.
 * @param <Object> JSON 변환 대상 XML
 * @return <String> string
 * @description
 * config.xml 파일에 아래의 내용을 추가한다.
 * <WebSquare> <json> <xml2jsonFunction value="customXML2JSON" /> </json> </WebSquare>
 */
utilLib.customXML2JSON = function(data) {
	var jsonStr = [];

	if (WebSquare.xml.isDocumentString(data)) {
		data = WebSquare.xml.parse(data);
	}

	if (WebSquare.xml.isDocument(data)) {
		utilLib.parseXmlForJSON(data.documentElement, jsonStr, false);
	}

	return jsonStr.join("");
};

/**
 * XML 노드를 입력 받아 Type(array, string, object, string)을 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> node JSON변환 대상 XML
 * @return <String> 노드의 Type 정보
 */
utilLib.parseType = function(node) {
	if (node && node.childNodes && node.childNodes.length > 0) {
		var tmp = {};
		var elementCnt = 0;

		for (var i = 0; i < node.childNodes.length; i++) {
			if (node.childNodes[i].nodeType == 1) {
				if (tmp[node.childNodes[i].nodeName] == true) {
					return "array";
				}

				tmp[node.childNodes[i].nodeName] = true;
				elementCnt++;
			}
		}
		if (elementCnt == 0) {
			return "string";
		} else {
			return "object";
		}
	} else {
		return "string";
	}
};

/**
 * JSON Object인지 여부를 검사한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> jsonObj JSON Object
 * @returns {Boolean}
 */
utilLib.isJSON = function(jsonObj) {
	if (typeof jsonObj !== "object")
		return false;
	try {
		JSON.stringify(jsonObj);
		return true;
	} catch (e) {
		return false;
	}
	;
};

/**
 * JSON Object로 변환해서 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <string> str 문자열
 * @returns {JSON}
 */
utilLib.parse = function(str) {
	if (typeof str !== "string")
		return null;

	try {
		return JSON.parse(str);
	} catch (e) {
		return null;
	}
};

// ==========================================================================================

/**
 * @target 숫자 처리 관련 공통 함수
 */

/**
 * 소수점 자리 수를 체크한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> obj Component id
 * @param <Number> decLen 소수 이하 자리수
 * @return 컴포넌트에 데이터 값 리턴
 * @example utilLib.chkeckDecimalFormat( in_Num, 2 ) <- 소수 2째 자리
 */
utilLib.chkeckDecimalFormat = function($p, obj, decLen) {
	var data = obj.getValue();

	if (data.length < 1) {
		return;
	}

	var decIdx = data.indexOf(".");

	if (decIdx > -1) {
		var dataIdx = data.length - 1;
		var len = dataIdx - decIdx;

		if (len > decLen) {
			comLib.alert($p,"소수 " + decLen + "자리까지 입력 가능합니다.");
			obj.setValue(data.substring(0, dataIdx));
			obj.focus();
		}
	}
};

/**
 * 입력받은 문자열이 숫자이면 true 아니면 false를 리턴한다.
 * 
 * @date 2014. 12. 10.
 * @param word : 문자열
 * @return 숫자이면 true, 그외는 false
 * @example utilLib.isNumberOld("123456");
 */
utilLib.isNumberOld = function(word) {
	var c;
	for (var i = 0; i < word.length; i++) {
		c = word.charAt(i);
		if ((c < "0" || c > "9" || c == "") && (c != "," && c != "." && c != "-")) {
			return false;
		}
	}
	return true;
};

/**
 * 
 * 특정일자 기준 만 나이 계산한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> idx : 구분( 1:기준일자+6개월, 2:기준일자)
 * @param <String> sJumin : 주민번호
 * @param <String> cDate : 기준일자(미 입력 시 현재일자)
 * @return 계산된 만 나이
 * @example utilLib.getAge("1", "[SSN]") utilLib.getAge("1", "[SSN]", "20121231")
 */
utilLib.getAge = function(idx, sJumin, cDate) {
	if ((typeof arguments[0] == "undefined" || arguments[0] == "")) {
		return 0;
	}
	if ((typeof arguments[1] == "undefined" || arguments[1] == "")) {
		return 0;
	}

	var CurrDt;
	var currentDate = utilLib.getCurrentDate("yyyyMMdd"); // 서버 현재 시간

	// 기준일자 + 6개월
	if (idx == "1") {
		if (typeof arguments[2] == "undefined" || arguments[2] == "") {
			CurrDt = utilLib.addToDay(currentDate, "6"); // 현재일자 + 6개월
		} else {
			CurrDt = utilLib.addToDay(cDate, "6"); // 기준일자 + 6개월
		}

	// 기준일자
	} else if (idx == "2") {
		if (typeof arguments[2] == "undefined" || arguments[2] == "") {
			CurrDt = currentDate; // 현재일자
		} else {
			CurrDt = cDate; // 기준일자
		}

	} else {
		return 0;
	}

	var curr_yy = CurrDt.substring(0, 4);
	var curr_mm = CurrDt.substring(4, 6);
	var curr_dd = CurrDt.substring(6, 8);

	var birth_yy = sJumin.substring(0, 2);
	var birth_mm = sJumin.substring(2, 4);
	var birth_dd = sJumin.substring(4, 6);

	var birth_gbn = sJumin.substring(6, 7);
	if (birth_gbn == "3" || birth_gbn == "4") {
		birth_yy = "20" + birth_yy;
	} else {
		birth_yy = "19" + birth_yy;
	}

	var age = Number(curr_yy) - Number(birth_yy);
	if (Number(curr_mm) == Number(birth_mm)) {
		if (Number(curr_dd) < Number(birth_dd)) {
			age = Number(age) - Number(1);
		}
	} else if (Number(curr_mm) < Number(birth_mm)) {
		age = Number(age) - Number(1);

	}

	return age;
};

/**
 * 문자열 왼쪽에 일정길이(maxLen) 만큼 '0'으로 채우기
 * 
 * @date 2014. 12. 10.
 * @param <String> str 문자열
 * @param <Number> maxLen 0 으로 채울 최대 길이
 * @example utilLib.fillZero("24", 4) => 0024
 */
utilLib.fillZero = function(str, maxLen) {
	var len = str;
	var zero = "";

	if (typeof str == "number") {
		len = "" + str;
	}

	if (len.length < maxLen) {
		for (var i = len.length; i<maxLen; i++) {
			zero += "0";
		}
	}
	return (zero + "" + str);
}

// ==========================================================================================

/**
 * @target 문자열 처리 관련 공통 함수
 */

/**
 * Null 및 공란이면 True 아니면 False 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> str_val 문자열
 * @return true/false
 */
utilLib.isEmpty = function(str_val) {
	str_val = utilLib.trim(str_val);

	if (str_val == null || str_val.length == 0) {
		return true;
	} else {
		return false;
	}
};

/**
 * 입력받은 str 의 왼쪽을 num만큼 chr로 채운다.
 * 
 * @date 2014. 12. 10.
 * @param <String> str 원본 문자열
 * @param <Number> num 채울 자리수
 * @param <String> chr 채울 문자
 * @example utilLib.lpad("1", 3, "0")
 * @return
 */
utilLib.lpad = function(str, num, chr) {
	if (!str || !chr || str.length >= num) {
		return str;
	}

	var max = num - str.length;
	for (var i = 0; i < max; i++) {
		str = chr + str;
	}

	return str;
};

/**
 * 문자열 중간 잘라서 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> source 원본 문자열
 * @param <Number> start 자를 문자열 시작 위치
 * @param <Number> length 자를 문자열 길이
 * @return <String> 잘라낸 문자열
 */
utilLib.mid = function(source, start, length) {
	if (start < 0 || length < 0) {
		return "";
	}

	var endLength = -1;
	var sourceLength = source.toString().length;
	if (start + length > sourceLength) {
		endLength = sourceLength;
	} else {
		endLength = start + length;
	}
	return source.toString().substring(start, endLength);
};

/**
 * 문자열의 앞 뒤 공백을 제거한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> 문자열
 * @return <String>
 */
utilLib.trim = function(str) {
	str = str.toString();
	return str.replace(/^\s\s*/, "").replace(/\s\s*$/, "");
};

/**
 * 문자열의 앞 공백을 제거한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> 문자열
 * @return <String>
 */
utilLib.ltrim = function(str) {
	str = str.toString();
	return str.replace(/^\s+/, "");
};

/**
 * 문자열의 뒤 공백을 제거한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> 문자열
 * @return <String>
 */
utilLib.rtrim = function(str) {
	return str.replace(/\s+$/, "");
};

/**
 * locIndex 뒤의 문자열을 특정 문자로 마스킹 처리한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> value 원본 문자열
 * @param <Number> locIndex locIndex 뒤의 문자열을 마스킹 처리
 * @param <String> maskingChar 마스킹 문자 (*)
 * @return <String> 마스킹 처리된 문자열
 * @example utilLib.maskRStr("082-123456-02-123", 6, "*");
 */
utilLib.maskRStr = function(value, locIndex, maskingChar) {
	var retValue = "";
	var idx = 0;
	for (var i = 0; i < value.length; i++) {
		var oneChar = value.charAt(i);
		if (oneChar == "-") {
			retValue += oneChar;
		} else {
			idx++;
			retValue = (idx > locIndex) ? retValue + maskingChar : retValue + oneChar;
		}
	}
	return retValue;
};

/**
 * 우편번호의 "-"가 없는 경우 "-"를 추가하여 표시한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> value 우편번호
 * @return <String> Masked 문자열
 * @example utilLib.maskPostFormat("123456"); // 123-456
 */
utilLib.maskPostFormat = function(value) {
	if (typeof value == "number") {
		value = value + "";
	}
	var pos = -1;

	// 1. test pos value
	pos = value.indexOf("-");
	if (pos > -1 && (pos != 3 || value.length <= 4)) {
		value = value.slice(0, pos) + value.slice(pos + 1, value.length);
	}
	// 2. add "-"
	pos = value.indexOf("-");
	if (pos == -1 && value.length >= 4) {
		value = value.slice(0, 3) + "-" + value.slice(3, value.length);
	}
	// 3. check max length
	if (value.length > 7) {
		value = value.slice(0, 7);
	}
	return value;
};

/**
 * 주민등록번호에 "-"가 없는 경우 "-"를 추가한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> value 주민등록번호
 * @return <String> Masked 문자열
 * @example utilLib.maskSSNFormat("[SSN]");  // 990101-2123456
 */
utilLib.maskSSNFormat = function(value) {
	if (typeof value == "number") {
		value = value + "";
	}
	var pos = -1;

	// 1. test pos value
	pos = value.indexOf("-");
	if (pos > -1 && (pos != 6 || value.length <= 7)) {
		value = value.slice(0, pos) + value.slice(pos + 1, value.length);
	}
	// 2. add "-"
	pos = value.indexOf("-");
	if (pos == -1 && value.length >= 7) {
		value = value.slice(0, 6) + "-" + value.slice(6, value.length);
	}
	// 3. check max length
	if (value.length > 14) {
		value = value.slice(0, 14);
	}
	return value;
};

/**
 * 주민등록번호에 "-"가 없는 경우 "-"를 추가하며 뒤에 6자리를 *로 처리한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> value 주민등록번호
 * @return <String> Masked 문자열
 * @example utilLib.maskSSNFormat2("[SSN]");  // 990101-2******
 */
utilLib.maskSSNFormat2 = function(value) {
	if (typeof value == "number") {
		value = value + "";
	}
	if (value.indexOf("-") >= 0) {
		var pos = value.indexOf("-");
		retValue = value.substring(0, pos) + value.substring(pos + 1);
	} else {
		retValue = value;
	}
	if (retValue.length > 7) {
		retValue = retValue.substring(0, 6) + "-" + retValue.substring(6, 7) + "*******".substring(0, retValue.length - 7);
	} else if (retValue.length > 6) {
		retValue = retValue.substring(0, 6) + "-" + retValue.substring(6);
	}
	return retValue;
};

/**
 * 사업자번호의 포맷 유효성을 검사한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> value 사업자번호
 * @return <Boolean> 
 * @example utilLib.checkCorpFormat("1234567890"); 
 */
utilLib.checkCorpFormat = function(value) {
	var sum = 0;
	var aBizID = new Array(10);
	var checkID = new Array("1", "3", "7", "1", "3", "7", "1", "3", "5");

	for (var i = 0; i < 10; i++) {
		aBizID[i] = value.substring(i, i + 1);
	}
	for (var i = 0; i < 9; i++) {
		sum += aBizID[i] * checkID[i];
	}
	sum = sum + parseInt((aBizID[8] * 5) / 10);
	temp = sum % 10;
	temp1 = 0;

	if (temp != 0) {
		temp1 = 10 - temp;
	} else {
		temp1 = 0;
	}
	if (temp1 != aBizID[9]) {
		return false;
	}
	return true;
};

/**
 * 주민번호, 사업자번호 체크하여 포맷에 맞게 "-" 추가한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> value 주민번호 또는 사업자번호
 * @return <String> Masked 문자열
 * @example utilLib.maskSSNCorpFormat("1234567890"); // 123-45-67890(사업자번호), 123456-1234567(주민등록번호)
 */
utilLib.maskSSNCorpFormat = function(value) {
	if (typeof value == "number") {
		value = value + "";
	}

	// 1. test pos value
	var pos = value.indexOf("-");
	var lastPos = value.lastIndexOf("-");
	if (lastPos == 6 && value.length <= 7) {
		value = value.slice(0, lastPos) + value.slice(lastPos + 1, value.length);
	}
	if (lastPos == 3 && value.length <= 4) {
		value = value.slice(0, lastPos) + value.slice(lastPos + 1, value.length);
	}
	// 2. add "-"
	pos = value.indexOf("-");
	if (pos == -1 && value.length >= 4) {
		value = value.slice(0, 3) + "-" + value.slice(3, value.length);
	}
	pos = value.indexOf("-");
	var lastPos = value.lastIndexOf("-");
	if (pos == 3 && value.length >= 7 && lastPos == pos) {
		value = value.slice(0, 6) + "-" + value.slice(6, value.length);
	}

	var sregExp = /-/g;

	// 3. check max length
	if (value.length > 12) {
		value = value.replace(sregExp, "");
		value = value.slice(0, 6) + "-" + value.slice(6, value.length);
	}
	if (value.length > 14) {
		value = value.slice(0, 14);
	}
	return value;
};

/**
 * 전화번호의 "-"가 없는 경우 "-"를 추가하여 표시한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> value 전화번호
 * @return <String> Masked 문자열
 * @example utilLib.maskTelFormat("0226631234");  // 02-2663-1234
 */
utilLib.maskTelFormat = function(value) {
	if (typeof value == "number") {
		value = value + "";
	}

	var delimeter1 = "-";
	var delimeter2 = "-";

	var firstDelimeterPos = 3;
	var maxLength = 11 + delimeter1.length + delimeter2.length;

	if (value.indexOf("02") == 0) {
		firstDelimeterPos -= 1;
		maxLength -= 1;
	}

	// limit max length
	if (value.length > maxLength) {
		value = value.substr(0, maxLength);
	}

	// remove delimeter
	var regExp = new RegExp("[0-9]*", "g");
	var result = (value + "").match(regExp);
	value = result.join("");

	// 1st delimeter
	if (value.length > firstDelimeterPos) {
		value = value.substr(0, firstDelimeterPos) + delimeter1 + value.substr(firstDelimeterPos, value.length);
	}
	// 2nd delimeter
	if (value.length > firstDelimeterPos + delimeter1.length + 4) {
		value = value.substr(0, value.length - 4) + delimeter2 + value.substr(value.length - 4, value.length);
	}
	return value;
};

/**
 * 문자열의 Byte를 계산한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> content 텍스트
 * @param <Object> outObj 총 Byte가 표시될 Object (생략가능)
 * @example 
 * utilLib.getByteLength(obj.getValue()); 
 * utilLib.getByteLength(obj.getValue(), obj1);
 */
utilLib.getByteLength = function(content, outObj) {
	var tmpStr;
	var temp = 0;
	var onechar;
	var tcount = 0;
	var obj = outObj;
	tmpStr = new String(content);
	temp = tmpStr.toString().length;
	for ( var k = 0; k < temp; k++) {
		onechar = tmpStr.toString().charAt(k);
		if (escape(onechar) == "%0D") {
		} else if (escape(onechar).length > 4) {
			tcount += 2;
		} else {
			tcount++;
		}
	}
	if (typeof outObj != "undefined" && outObj != null) {
		obj.setValue(tcount);
	}
	return tcount;
};

/**
 * 스트링의 replace 작업을 처리한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> str 원문
 * @param <String> orgStr 검색할 문자
 * @param <String> repStr 치환할 문자
 * @return <String> 치환된 문자열
 * @example utilLib.replaceAll(obj.getValue(), "/", "");
 */
utilLib.replaceAll = function(str, orgStr, repStr) {
	return str.split(orgStr).join(repStr);
};

/**
 * 문자열 영단어 여부 체크
 * 
 * @date 2014. 12. 10.
 * @param word : 문자열
 * @return 영단어이면 true, 아니면 false
 * @description 입력받은 문자열이 모두 영단어이면 true, 아니면 false를 리턴한다
 * @example utilLib.isEnglish("abcdefg");
 */
utilLib.isEnglish = function(word) {
	var c;
	if (utilLib.trim(word).length == 0) {
		return false;
	}

	for (var i = 0; i < word.length; i++) {
		c = word.toLowerCase().charAt(i);
		if (c < "a" || c > "z") {
			if ((c == " ") || (c == ".") || (c == "-")) {
				continue;
			}

			return false;
		}
	}
	return true;
};

/**
 * 입력받은 문자열이 모두 영문 또는 숫자로 되어 있으면 true, 아니면 false를 리턴한다.
 * 
 * @date 2014. 12. 10.
 * @param word : 문자열
 * @return 영문or숫자이면 true, 아니면 false
 * @example utilLib.hasNumOrLetter("abc123de4fg");
 */
utilLib.hasNumOrLetter = function(word) {
	var c;
	for (var i = 0; i < word.length; i++) {
		c = word.toLowerCase().charAt(i);

		if ((c < "a" || c > "z") && (c < "0" || c > "9")) {
			return false;
		}

	}
	return true;
};

/**
 * 입력받은 문자열에 한글이 포함되어 있으면 true, 아니면 false를 리턴한다.
 * 
 * @date 2014. 12. 10.
 * @param word : 문자열
 * @return 한글이면 true, 아니면 false
 * @example utilLib.isKoreanWord("abcd무궁화");
 */
utilLib.isKoreanWord = function(word) {
	var c;
	for (var i = 0; i < word.length; i++) {
		c = word.charAt(i);
		if (utilLib.isKorean(c)) {
			return true;
		}
	}
	return false;
};

/**
 * 입력받은 문자열이 한글이면 true, 아니면 false를 리턴한다.
 * 
 * @date 2014. 12. 10.
 * @param str : 문자열
 * @return 한글이 포함되어 있으면 true, 아니면 false
 * @example utilLib.isKorean("무궁화꽃이");
 */
utilLib.isKorean = function(str) {
	if (str != null && str.length > 0) {
		var locale = 0;
		for ( var i = 0; i < str.length; i++) {
			locale = utilLib.getLocale(str.charAt(i));
		}
		if ((locale & ~0x3) == 0) {
			return true;
		}
	}
	return false;
};

/**
 * 문자(char)의 유형을 리턴한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> str 문자(char)
 * @return <Number> 한글음절(1), 한글자모(2), 숫자(4), 특수문자(8), 영문대(16), 영문소(32), 기타(48)
 * @example utilLib.getLocale(str);
 */
utilLib.getLocale = function(str) {
	var locale = 0;
	if (str.length > 0) {
		var charCode = str.charCodeAt(0);

		if (charCode >= 0XAC00 && charCode <= 0XD7A3) { // 한글음절.[ 44032 ~ 55203 ]
			locale = 0X1; // 1
		} else if ((charCode >= 0X1100 && charCode <= 0X11F9) || (charCode >= 0X3131 && charCode <= 0X318E)) { // 한글자모.[ 4352 ~ 4601 ]
			locale = 0X2; // 2
		} else if (charCode >= 0X30 && charCode <= 0X39) { // 숫자.[ 48 ~ 57 ]
			locale = 0X4; // 4
		} else if ((charCode >= 0X20 && charCode <= 0X2F) || (charCode >= 0X3A && charCode <= 0X40) || (charCode >= 0X5B && charCode <= 0X60)
				|| (charCode >= 0X7B && charCode <= 0X7E)) { // 특수문자
			locale = 0X8; // 8
		} else if (charCode >= 0X41 && charCode <= 0X5A) { // 영문 대.[ 65 ~ 90 ]
			locale = 0X10; // 16
		} else if (charCode >= 0X61 && charCode <= 0X7A) { // 영문 소.[ 97 ~ 122 ]
			locale = 0X20; // 32
		} else { // 기타
			locale = 0X30; // 48
		}
	}
	return locale;
};

/**
 * 특수 문자가 포함된 경우 true 아니면 false를 리턴한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> word 문자열
 * @return <Boolean> 특수 문자가 포함된 경우 true 아니면 false
 * @example utilLib.checkChar("abcd##무궁화");
 */
utilLib.checkChar = function(str) {
	var m_Sp = /[$\\@\\\#%\^\&\*\(\)\[\]\+\_\{\}\`\~\=\|]/;
	var m_char;

	for (var i = 1; i <= str.length; i++) {
		m_char = str.charAt((i) - 1);

		if (m_char.search(m_Sp) != -1) {
			return true;
		}
	}
	return false;
};

/**
 * 문자열을 입력 byte 만큼만 출력하고 말줄임 한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> str 문자열
 * @param <Number> limit 가져올 byte길이
 * @return <String> limit 길이 만큼만의 문자열에 말줄임 처리
 * @example var strResult = utilLib.cutByteStr("abcdefghijklmn", 5);
 */
utilLib.cutByteStr = function(str, limit) {
	var tmpStr = str;
	var byte_count = 0;
	var len = str.length;
	var dot = "";

	for (var i = 0; i < len; i++) {
		byte_count += utilLib.getByteCount(str.charAt(i));
		if (byte_count == limit - 1) {
			if (utilLib.getByteCount(str.charAt(i + 1)) == 2) {
				tmpStr = str.substring(0, i + 1);
				dot = "...";
			} else {
				if (i + 2 != len) {
					dot = "...";
				}
				tmpStr = str.substring(0, i + 2);
			}
			break;
		} else if (byte_count == limit) {
			if (i + 1 != len)
				dot = "...";
			tmpStr = str.substring(0, i + 1);
			break;
		}
	}
	return tmpStr + dot;
};

/**
 * 바이트 수를 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> chr 문자
 * @returns <Number> 바이트수
 */
utilLib.getByteCount = function(chr) {
	if (escape(chr).length > 4) {
		return 2;
	} else {
		return 1;
	}
};

/**
 * 첫번째 문자를 대문자로 변환해서 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> str 문자열
 * @returns <String> 치환된 문자열
 */
utilLib.firstUpperCase = function(str) {
	return str.substring(0, 1).toUpperCase() + str.substring(1);
};

/**
 * 첫번째 문자를 소문자로 변환해서 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> str 문자열
 * @returns <String> 치환된 문자열
 * @returns
 */
utilLib.firstLowerCase = function(str) {
	return str.substring(0, 1).toLowerCase() + str.substring(1);
};

/**
 * XML, JSON Object 를 serialize/stringify 한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> Object
 * @returns <String> serialize/stringify String
 */
utilLib.serialize = function(object) {
	if (typeof object == "string") {
		return object;
	} else if (utilLib.isJSON(object)){
		return JSON.stringify(object);
	} else if (utilLib.isXmlCoc(object)) {
		return WebSquare.xml.serialize(object);
	} else {
		return object;
	}
};

/**
 * 단어 뒤에 '은'이나 '는'을 붙여서 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> msg
 * @returns <String> 변환된 문자열
 */
utilLib.attachPostposition = function(msg) {
	if (utilLib.isFinalConsonant(msg)) {
		msg = msg + "은 ";
	} else {
		msg = msg + "는 ";
	}
	return msg;
};

/**
 * 종성이 존재하는지 여부를 검사한다. 
 * 
 * @date 2014. 12. 10.
 * @param <String> str 문자열
 * @return <Boolean> true : 종성이 존재, false 그외
 */
utilLib.isFinalConsonant = function(str) {
	var code = str.charCodeAt(str.length - 1);
	if ((code < 44032) || (code > 55197)) {
		return false;
	}
	if((code -16)%28 == 0) {
		return false;
	}
	return true;
};

// ==========================================================================================

/**
 * @target 유효성 검사를 위한 공통 함수
 */
utilLib.status = {
	isValid : true,
	objectName : "",
	columnId : "",
	rowIndex : 0,
	message : ""
}; // 유효성 검사 상태

/**
 * 유효성 검사 정보를 초기화한다.
 * 
 * @date 2014. 12. 10.
 */
utilLib.initValStatus = function() {
	utilLib.status.isValid = true;
	utilLib.status.objectName = "";
	utilLib.status.columnId = "";
	utilLib.status.rowIndex = 0;
	utilLib.status.message = "";
};

/**
 * 그룹안에 포함된 컴포넌트의 입력 값에 대한 유효성을 검사한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> grpObj 그룹 컴포넌트 객체
 * @param <Object> dcObj 데이터 컬렉션 객체 (DataList or DataMap)
 * @returns <Boolean> 유효성 검사 결과
 * @example 
 * if (utilLib.validateGroup(grp_LoginInfo, dlt_Code) === false) { 
 * <br/>   return; (utilLib.status.isValid === false)
 * <br/>}
 * @description
 * <※ 필수 입력, 입력 허용 문자, 입력 허용 불가 문자, 최대, 최소 입력 문자수 설정은 컴포넌트의 속성에서 설정한다. 
 * <br/>- mandatory : 필수 입력 항목 여부 
 * <br/>- allowChar : 입력 허용 문자 
 * <br/>- ignoreChar : 입력 허용 불가 문자 
 * <br/>- maxLength : 최대 입력 문자수 
 * <br/>- maxByteLength : 최대 입력 바이트수 
 * <br/>- minLength : 최소 입력 문자수 
 * <br/>- minByteLength : 최소 입력 바이트수
 */
utilLib.validateGroup = function(grpObj, dcObj) {
	if (utilLib.checkModified(dcObj) === false) {
		return false;
	}

	utilLib.initValStatus();

	var objArr = WebSquare.util.getChildren(grpObj, {
		excludePlugin : "group trigger textbox output calendar image span anchor multiupload gridView wframe body input_Search",
		recursive : true
	});

	var i = 0;
	var $p = grpObj.getScopeWindow().$p;
	try {
		for (i = 0; i < objArr.length; i++) {
			objArr[i].validate();
			if (utilLib.status.isValid === true) {
				utilLib.extendValidation($p, objArr[i]);
				if (utilLib.status.isValid === false) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	} catch(e) { 
		$w.log("[utilLib.validateGroup] Exception - ID : " + objArr[i].getID() + ", Plugin : " + objArr[i].getPluginName() + ", message : " + e.message);
	} finally {
		objArr = null;
	}
};

/**
 * 유효성 검사 실패시 출력할 메시지를 반환한다.
 * 
 * @date 2014. 12. 10.
 * @returns {String} 메시지
 */
utilLib.validateMsg = function() {
	var msg = "";
	var invalidType = this.getType(); // invalid 타입
	var invalidValue = this.getValue(); // invalid 타입별 설정값
	var callerObj = this.getCaller(); // validator를 호출한 컴포넌트
	var columnName = utilLib.getColumnName(callerObj);

	switch (invalidType) {
	case "mandatory":
		msg = utilLib.attachPostposition(columnName) + "필수 입력 항목 입니다.";
		break;
	case "minLength":
		msg = utilLib.attachPostposition(columnName) + "최소 길이 " + invalidValue + "자리 이상으로 입력해야 합니다.";
		break;
	case "minByteLength":
		msg = utilLib.attachPostposition(columnName) + "최소 길이 " + invalidValue + "바이트 이상으로 입력해야 합니다.";
		break;
	default:
		msg = utilLib.attachPostposition(columnName) + "은 잘못 입력했습니다.";
	break;
	}

	if (msg !== "") {
		utilLib.status.isValid = false;
	}

	utilLib.status.objectName = callerObj.getID();
	var $p = callerObj.getScopeWindow().$p;
	comLib.alert($p, msg, "utilLib.groupValidationCallback");
};

/**
 * 추가적으로 확장한 사용자 정의 유효성 검사를 수행한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> comObj 유효성 검증 대상 컴포넌트 객체
 * @description
 * 1. isHangul
 * <br/>   - 한글 포함 여부 검사한다. 
 * <br/>   - false : 한글이 포함되면 안됨 
 * <br/>   - 컴포넌트 태그에 'isHangul'이라는 사용자 정의 속성을 추가한다.
 * <br/>   - ex. <xf:input id="ibx_AuthorityCd" mandatory="true" maxlength="5" minlength="5" isHangul="false"></xf:input> 
 * <br/>2. isEmail
 * <br/>   - 이메일 유효성을 검사한다.
 * <br/>   - true : 입력받은 이메일 주소에 대한 검사를 수행한다.
 * <br/>   - 컴포넌트 태그에 'isEmail'이라는 사용자 정의 속성을 추가한다.
 * <br/>   - ex. <xf:input id="ibx_AuthorityCd" mandatory="true" maxlength="5" minlength="5" isEmail="true"></xf:input> 
 */
utilLib.extendValidation = function($p, comObj) {
	var isHangul = comObj.getUserData("isHangul");
	var isEmail = comObj.getUserData("isEmail");

	if ((typeof isHangul !== "undefined") && (isHangul === "false")) {
		if (utilLib.isKoreanWord(comObj.getValue()) === true) {
			utilLib.status.isValid = false;
			utilLib.status.objectName = comObj.getID();
			var columnName = utilLib.getColumnName(comObj);
			comLib.alert($p, columnName + "은(는) 한글을 입력해서는 안됩니다.");
			return;
		}
	} else if ((typeof isEmail !== "undefined") && (isEmail === "true")) {
		if (utilLib.isEmail(comObj.getValue()) === false) {
			utilLib.status.isValid = false;
			utilLib.status.objectName = comObj.getID();
			var columnName = utilLib.getColumnName(comObj);
			comLib.alert($p, columnName + "은(는) 이메일 주소 형식이 올바르지 않습니다.", "utilLib.groupValidationCallback");
			return;
		}
	}
};

/**
 * 유효성 검사 실패에 대한 Alert 메시지 창이 닫힌 후에 수행되는 콜백 함수이다.
 * 
 * @date 2014. 12. 10.
 * @returns
 */
utilLib.groupValidationCallback = function() {
	if (utilLib.status.objectName !== "") {
		var obj = WebSquare.util.getComponentById(utilLib.status.objectName);
		obj.focus();
	}
};

/**
 * 특정 컴포넌트에 바인된 DataList나 DataMap의 컬럼 이름을 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> callerObj 컴포넌트
 * @return <String> 컬럼명
 */
utilLib.getColumnName = function(comObj) {
	var $p = comObj.getScopeWindow().$p;
	try {
		if ((typeof comObj.getRef) === "function") {
			var ref = comObj.getRef();
			var refArray = ref.substring(5).split(".");
			var dataCollectionName = refArray[0];
			var columnId = refArray[1];

			if ((typeof refArray !== "undefined") && (refArray.length === 2)) {
				// var dataCollection = WebSquare.util.getComponentById(dataCollectionName);
				var dataCollection = $p.getComponentById(dataCollectionName);
				var dataType = dataCollection.getObjectType().toLowerCase();
				if (dataType === "datamap") {
					return dataCollection.getName(columnId);
				} else if (dataType === "datalist") {
					return dataCollection.getColumnName(columnId);
				}
			} else {
				return "";
			}
		}
	} catch(e) { 
		$w.log("[utilLib.getColumnName] Exception :: " + e.message);
	} finally {
		dataCollection = null;
	}
};

/**
 * GridView를 통해서 입력된 데이터에 대해서 유효성을 검증한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> gridViewObj GridView 객체
 * @param <Object> valInfo 데이터 유효성 검증 옵션 JSON 객체 
 * <br/>([{id : [columnId], mandatory : [boolean], minlength = [number], isHangul : [boolean], isEmail = [boolean], valFunc : [userFunc]}])
 * @return <Boolean> 유효성검사 결과
 * @example 
 * var valInfo = [ {id : "grp_cd", mandatory : true, minlength : 5, isHangul : false}, {id : "grp_nm", mandatory : true, isHangul : true} ];
 * <br/>if (utilLib.validateGridView(grd_MenuAuthority, valInfo)) {
 * <br/>	comLib.confirm("변경된 메뉴별 등록 사원 정보를 저장하시겠습니까?", "saveMenuAuthorityConfirmCallback");
 * <br/>}
 * @description
 * 입력 허용 문자, 입력 허용 불가 문자, 최대 입력 문자수 설정은 GridView의 Column의 속성에서 설정한다. 
 * <br/>- allowChar : 입력 허용 문자 
 * <br/>- ignoreChar : 입력 허용 불가 문자 
 * <br/>- maxLength : 최대 입력 문자수
 */
/*
utilLib.validateGridView = function(gridViewObj, valInfo) {
	var dataList = comLib.getGridViewDataList(gridViewObj);
	if (dataList === null) {
		return;
	}
	
	utilLib.initValStatus();

	try {
		var modifiedIdx = dataList.getModifiedIndex();

		if (modifiedIdx.length === 0) {
			dataList.undoAll();
			dataList.removeRows(dataList.getInsertedIndex());
			comLib.alert("저장할 데이터가 없습니다.");
			return false;
		}
		var modifiedData = dataList.getModifiedJSON();
	
		for ( var dataIdx = 0; dataIdx < modifiedData.length; dataIdx++) {
			if ((utilLib.status.isValid === false) || (modifiedData[dataIdx].rowStatus === "D")) {
				break;
			}
			for ( var valIdx = 0; valIdx < valInfo.length; valIdx++) {
				if (utilLib.status.isValid === false) {
					break;
				}
				if ((typeof valInfo[valIdx].id !== "undefined") && (typeof modifiedData[dataIdx][valInfo[valIdx].id] !== "undefined")) {
	
					var value = modifiedData[dataIdx][valInfo[valIdx].id];
					
					if ((typeof valInfo[valIdx].mandatory !== "undefined") && (valInfo[valIdx].mandatory === true) && (value.length === 0)) {
						setResult(valInfo[valIdx].id, modifiedIdx[dataIdx], dataList, gridViewObj, "필수 입력 항목 입니다.");
					} else if ((typeof valInfo[valIdx].minlength !== "undefined") && (valInfo[valIdx].minlength > 0) && (value.length < valInfo[valIdx].minlength)) {
						setResult(valInfo[valIdx].id, modifiedIdx[dataIdx], dataList, gridViewObj, "최소 길이 " + valInfo[valIdx].minlength + "자리 이상으로 입력해야 합니다.");
					} else if ((typeof valInfo[valIdx].isHangul !== "undefined") && (valInfo[valIdx].isHangul === false) && (utilLib.isKoreanWord(value) === true)) {
						setResult(valInfo[valIdx].id, modifiedIdx[dataIdx], dataList, gridViewObj, "한글을 입력해서는 안됩니다.");
					} else if ((typeof valInfo[valIdx].isEmail !== "undefined") && (valInfo[valIdx].isEmail === true) && (utilLib.isEmail(value) === false)) {
						setResult(valInfo[valIdx].id, modifiedIdx[dataIdx], dataList, gridViewObj, "이메일 주소 형식이 올바르지 않습니다.");
					} else if (typeof valInfo[valIdx].valFunc === "function") {
						var resultMsg = valInfo[valIdx].valFunc(value);
						if (resultMsg !== "") {
							setResult(valInfo[valIdx].id, modifiedIdx[dataIdx], dataList, gridViewObj, resultMsg);
						}
					}
				}
			}
		}
		return utilLib.status.isValid;
	
		function setResult(columnId, rowIndex, dataList, gridViewObj, message) {
				utilLib.status.isValid = false;
				utilLib.status.objectName = gridViewObj.getID();
				utilLib.status.columnId = columnId;
				utilLib.status.rowIndex = rowIndex;
				utilLib.status.message = utilLib.attachPostposition(dataList.getColumnName(columnId)) + message;
				comLib.alert(utilLib.status.message, "utilLib.validateGridViewCallback");
		}
	} catch(e) { 
		$w.log("[utilLib.validateGridView] Exception :: " + e.message);
	} finally {
		modifiedData = null;
		modifiedIdx = null;
		dataList = null;
		gridViewObj = null;
	}
};
*/

/**
 * 유효성 검사 실패에 대한 Alert 메시지 창이 닫힌 후에 수행되는 콜백 함수이다.
 * 
 * @date 2014. 12. 10.
 */
utilLib.validateGridViewCallback = function() {
	if (utilLib.status.objectName !== "") {
		var obj = WebSquare.util.getComponentById(utilLib.status.objectName);
		obj.setFocusedCell(utilLib.status.rowIndex, utilLib.status.columnId, true);
		utilLib.initValStatus();
	}
};

/**
 * DataCollection 객체의 변경된 데이터가 있는지 검사한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> dcObj
 * @returns <Boolean> 검사결과
 */
utilLib.checkModified = function(dcObj) {
	if (typeof dcObj !== "undefined") {
		var modifiedIndex = dcObj.getModifiedIndex();
		if (modifiedIndex.length === 0) {
			comLib.alert($p, "변경된 데이터가 없습니다.");
			return false;
		} else {
			return true;
		}
	} else {
		return true;
	}
};

/**
 * 사업자번호 유효성을 검사한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> str 문자열
 * @return <Boolean> 올바른 번호가 아닌경우 false
 * @example utilLib.checkBizID("1102112345");
 */
utilLib.checkBizID = function(str) {
	var sum = 0;
	var aBizID = new Array(10);
	var checkID = new Array("1", "3", "7", "1", "3", "7", "1", "3", "5");

	for ( var i = 0; i < 10; i++) {
		aBizID[i] = str.substring(i, i + 1);
	}
	for ( var i = 0; i < 9; i++) {
		sum += aBizID[i] * checkID[i];
	}
	sum = sum + parseInt((aBizID[8] * 5) / 10);
	temp = sum % 10;
	temp1 = 0;

	if (temp != 0) {
		temp1 = 10 - temp;
	} else {
		temp1 = 0;
	}
	if (temp1 != aBizID[9]) {
		return false;
	}
	return true;
};

/**
 * 법인등록번호 유효성을 검사한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> str 문자열
 * @return <Boolean> 올바른 번호가 아닌경우 false
 * @example utilLib.checkCorpID("110211234567");
 */
utilLib.checkCorpID = function(str) {
	var checkID = new Array(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2);
	var sCorpNo = str;
	var lV1 = 0;
	var nV2 = 0;
	var nV3 = 0;

	for (var i = 0; i < 12; i++) {
		lV1 = parseInt(sCorpNo.substring(i, i + 1)) * checkID[i];

		if (lV1 >= 10) {
			nV2 += lV1 % 10;
		} else {
			nV2 += lV1;
		}
	}
	nV3 = nV2 % 10;

	if (nV3 > 0) {
		nV3 = 10 - nV3;
	} else {
		nV3 = 0;
	}
	if (sCorpNo.substring(12, 13) != nV3) {
		return false;
	}
	return true;
};

/**
 * 내외국인 주민등록번호 유효성을 검사한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> str 문자열
 * @return <Boolean> 올바른 번호가 아닌경우 false
 * @example utilLib.checkPersonID("[SSN]");
 */
utilLib.checkPersonID = function(str) {
	var checkID = new Array(2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5);
	var i = 0;
	var sum = 0;
	var temp = 0;
	var yy = "";

	if (str.length != 13) {
		return false;
	}
	for (i = 0; i < 13; i++) {
		if (str.charAt(i) < "0" || str.charAt(i) > "9") {
			return false;
		}
	}

	// foreigner PersonID Pass
	if (str.substring(6, 13) == "5000000" || str.substring(6, 13) == "6000000" || str.substring(6, 13) == "7000000" || str.substring(6, 13) == "8000000") {
		return true;
	}
	for (i = 0; i < 12; i++) {
		sum += str.charAt(i) * checkID[i];
	}
	temp = sum - Math.floor(sum / 11) * 11;
	temp = 11 - temp;
	temp = temp - Math.floor(temp / 10) * 10;

	// 나이 (-) 체크
	if (str.charAt(6) == "1" || str.charAt(6) == "2" || str.charAt(6) == "5" || str.charAt(6) == "6") {
		yy = "19";
	} else {
		yy = "20";
	}
	if (parseInt(utilLib.getCurrentDate("yyyy")) - parseInt(yy + str.substring(0, 2)) < 0) {
		return false;
	}

	// 외국인 주민번호 체크로직 추가
	if (str.charAt(6) != "5" && str.charAt(6) != "6" && str.charAt(6) != "7" && str.charAt(6) != "8") {
		if (temp == eval(str.charAt(12))) {
			return true;
		} else {
			return false;
		}
	} else {
		if ((temp + 2) % 10 == eval(str.charAt(12))) {
			return true;
		} else {
			return false;
		}
	}
	return false;
};

/**
 * 메일주소 체크한다.
 * 
 * @date 2014. 12. 10.
 * @param <String> str 메일주소
 * @return <Boolean> 정상이면 공백("")을 반환, 그외는 에러 메시지 반환
 * @example utilLib.isEmail("[EMAIL]")
 */
utilLib.isEmail = function(str) {
	if (typeof str != "undefined" && str != "") {
		var format = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

		if (format.test(str)) {
			return true;
		} else {
			return false;
		}
	}
	return  true;
};

// ==========================================================================================

/**
 * @target XML 데이터 처리 관련 함수
 */

/**
 * XML Document 객체인지 여부를 검사한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> Object XML Document Object
 * @return
 */
utilLib.isXmlCoc = function(data) {
	if (typeof data != "object") {
		return false;
	}
	if ((typeof data.documentElement != "undefined" && data.nodeType == 9) || (typeof data.documentElement == "undefined" && data.nodeType == 1)) {
		return true;
	}
	return false;
};

/**
 * XML 객체를 문자열로 변환해서 반환한다.
 * 
 * @date 2014. 12. 10.
 * @param <Object> paramXml XML Object
 * @param <String> node Xpath 경로
 * @return <String> XML 문자열
 * @example utilLib.getString(paramXml,"P_ENGG_NO")
 */
utilLib.getString = function(paramXml, node) {
	var retValue = "";
	try {
		retValue = WebSquare.xml.getString(paramXml, node);
	} catch (e) {
		WebSquare.exception.printStackTrace(e);
	}
	return retValue;
};

// ==========================================================================================

/**
 * 지정한 개체의 null 여부를 반환합니다.
 *
 * @param object : 점검할 개체
 * @returns true, false
 */
utilLib.isNull = function(object) {
	if (typeof object == "boolean"){
		return false;
	} else if (typeof object == "object") {
		if (object == null || object.length == 0) {
			return true;
		} else {
			return false;
		}
	} else {
		return (object == null || typeof object == "undefined" || object === "");
	}
};

/**
 * 지정한 문자열의 null 여부를 반환합니다.
 *
 * @param source : 원본 문자열
 * @param checkEmpty : 빈 문자열도 null 로 간주할지 여부, 기본값은 true.
 * @returns true, false
 */
utilLib.isNullString = function(source, checkEmpty) {
	if (checkEmpty == null) {
		checkEmpty = true;
	}

	if (utilLib.isNull(source)) {
		return true;
	}

	return (checkEmpty && source.toString().replace(/(^\s*)|(\s*$)/gi, "").length == 0);
};

/**
 * 지정한 문자열이 null 이면 안전한 빈 문자열을 반환합니다.
 * 반환되는 모든 문자열은 Trim 처리가 적용됩니다.
 *
 * @param source : 원본 문자열
 * @returns null 이 아니고 Trim 처리가 적용된 문자열
 */
utilLib.safeString = function(source) {
	if (utilLib.isNullString(source)) {
		return "";
	}

	return utilLib.trim(source);
};

/**
 * 엔터키 입력 시 함수 콜
 *
 * @param e : e
 * @param fName : 호출할 함수 명
 * @example utilLib.inputEnter(e, "scwin.searchData()");
 */
utilLib.inputEnter = function(e, fName) {
	if (e.keyCode == 13 ) {
		if (typeof fName == "function" ) {
			fName(e);
		} else {
			eval(fName);
		}
	}
};

/**
 * 오늘 날짜(년월일시분초)를 YYYYMMDDHH24MISS 포맷의 문자열로 반환한다.
 *
 * @return <String> YYYYMMDDHH24MI
 */
utilLib.getDateTime = function() {
	var today = new Date();
	var year = today.getFullYear();
	var month = (today.getMonth() + 1);
	var day = today.getDate();
	var hour = today.getHours();
	var min = today.getMinutes();
	var second = today.getSeconds();
	var millisecond = today.getMilliseconds();

	if (parseInt(month) < 10) {
		month = "0" + month;
	}
	if (parseInt(day) < 10) {
		day = "0" + day;
	}
	if (parseInt(hour) < 10) {
		hour = "0" + hour;
	}
	if (parseInt(min) < 10) {
		min = "0" + min;
	}
	if (parseInt(second) < 10) {
		second = "0" + second;
	}
	if (parseInt(millisecond) < 10) {
		millisecond = "00" + millisecond;
	} else {
		if (parseInt(millisecond) < 100) {
			millisecond = "0" + millisecond;
		}
	}

	return String(year) + String(month) + String(day) + String(hour) + String(min);
};

/**
 * 오늘 날짜(년월일시분초)를 YYYYMMDDHH24MISS 포맷의 문자열로 반환한다.
 *
 * @return <String> YYYYMMDDHH24MISS
 * @example utilLib.getDateTodayFomatter("-", ":"); // 2016-10-12 17:47:10
 */
utilLib.getDateTodayFomatter = function(val1, val2) {
	var today = new Date();
	var year = today.getFullYear();
	var month = (today.getMonth() + 1);
	var day = today.getDate();
	var hour = today.getHours();
	var min = today.getMinutes();
	var second = today.getSeconds();
	var millisecond = today.getMilliseconds();

	if (parseInt(month) < 10) {
		month = "0" + month;
	}
	if (parseInt(day) < 10) {
		day = "0" + day;
	}
	if (parseInt(hour) < 10) {
		hour = "0" + hour;
	}
	if (parseInt(min) < 10) {
		min = "0" + min;
	}
	if (parseInt(second) < 10) {
		second = "0" + second;
	}
	if (parseInt(millisecond) < 10) {
		millisecond = "00" + millisecond;
	} else {
		if (parseInt(millisecond) < 100) {
			millisecond = "0" + millisecond;
		}
	}

	return String(year) + val1 + String(month) + val1 + String(day) + " " + String(hour) + val2 + String(min) + val2 + String(second);
};

/**
 * 문자열 날짜(년월일시분초)를 YYYYMMDDHH24MISS 포맷의 문자열로 반환한다.
 *
 * @return <String> YYYYMMDDHH24MISS
 * @example utilLib.getDateStrFomatter("20161020174710", "-", ":"); // 2016-10-20 17:47:10
 */
utilLib.getDateStrFomatter = function(str, val1, val2) {
	var year = str.substr(0, 4);
	var month = str.substr(4, 2);
	var day = str.substr(6, 2);
	var hour = str.substr(8, 2);
	var min = str.substr(10, 2);
	var second = str.substr(12, 2);

	return String(year) + val1 + String(month) + val1 + String(day) + " " + String(hour) + val2 + String(min) + val2 + String(second) + ".0";
};

/**
 * 정규식을 이용하여 천단위마다 콤마 추가
 *
 * @param amt
 * @returns
 */
utilLib.displayCurrency = function(amt) {
	amt = amt.replace(/,/gi, "");
	return amt.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, "$1,");
};

/**
 * 개행 문자를 <br> 태크로 치환
 *
 * @param value
 * @returns
 */
utilLib.displayTextArea = function(value) {
	return value.replaceAll("\\n", "<br/>");
};

/**
 * Number Text 를 float 로 변환
 *
 * @param value
 * @returns
 */
utilLib.displayNumberText = function(value) {
	return parseFloat(value);
};

/**
 * 시:분 표현(00:00)
 *
 * @param value
 * @returns
 */
utilLib.displayTimeText = function(value) {
	if ( value == null || value.trim() == "" ) {
		return;
	}

	if (value.replace(":", "").length >= 4 ) {
		return value.substring(0, 2) + ":" + value.substring(2, 4);
	} else {
		return value;
	}
};

/**
 * Number Text 를 float 로 변환(0이면 ""으로 리턴)
 *
 * @param value
 * @returns
 */
utilLib.displayNumberText2Empty = function(value) {
	if (parseFloat(value) == 0) {
		return "";
	}

	return parseFloat(value);
};

/**
 * 날짜형식 체크
 * 각 형식별로 날짜형식에 맞으면 "OK" return
 * 맞지 않으면 해당하는 에러메시지 return
 */
utilLib.checkDate = function(sDate) {
	var maxDays = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	var maxDay = 0;

	if (isNaN(sDate)) {
		return "숫자만 입력하세요";
	} else if(sDate.length == 4) {
		return "OK";
	} else if(sDate.length == 6 || sDate.length == 8) {
		if (sDate.length == 6) {
			sDate = sDate + "01";
		}
		var iYear = Math.floor(sDate / 10000);
		var iMonth = Math.floor(sDate / 100 - iYear * 100);
		var iDay = sDate % 100;
		if (iMonth < 1 || iMonth > 12) {
			return "월은 1 ~ 12월 까지입니다";
		} else if(sDate.length == 6) {
			return "OK";
		}

		if (sDate.length == 8) {
			if((iMonth == 2) && (iYear % 4 == 0 && iYear % 100 != 0 || iYear % 400 == 0)) {
				maxDay = 29;
			} else {
				maxDay = maxDays[iMonth - 1];
			}

			if (iDay < 1 || iDay > maxDay) {
				return iMonth + "월은 " + "1 ~ " + maxDay + " 일까지입니다";
			} else {
				return "OK";
			}
		}
	} else {
		return "날짜의 자릿수가 맞지 않습니다.";
	}
};

/**
 * 윈도우 컨테이너 새창 열기
 *
 * @param	url		: 화면 URL
 * @param	title	: 메뉴 Depth
 * @param	id		: 화면 id [메뉴등록 프로그램의 경우 : CSCI(3) + A(1) + 일련번호(2) + file명(n)], [메뉴미등록 프로그램의 경우 : 임의ID 지정]
 * @example	utilLib.winContainerOpen("/ui/css/per/CSSAMdcEqpPrstsMgtM.xml", "의무장비현황관리", "CSSAMdcEqpPrstsMgtM");
 */
utilLib.winContainerOpen = function(url, title, id) {
	var node = $p.top().wfm_left.getWindow().trvMenu.findNodeByValue(id);
	var nm;

	if (node != null) {
		nm = node.label;
	} else {
		nm = title;
	}

	$p.top().wfm_left.getWindow().scwin.createWindow(nm, null, "/wq/index.jsp?w2xPath=" + url, null, id); // 2020.11.10
};

/**
 * 윈도우 컨테이너 현재 창 닫기
 */
utilLib.winContainerClose = function() {
	$(".w2modal").hide();
	var openerOpenTF=false;
	try {
		if (opener) {
			if (opener.location.host == window.location.host) {
				openerOpenTF=true;
			}
		}
	} catch(e) {}
	if (openerOpenTF) {
		try {
			opener.$p.top().wdcMain.closeWindow();
		} catch(e) {
			$p.top().wdcMain.closeWindow($p.top().wdcMain.getSelectedWindowId());
		}
	} else {
		$p.top().wdcMain.closeWindow($p.top().wdcMain.getSelectedWindowId());
	}
};

/**
 * 윈도우 컨테이너 선택된 윈도우 ID 반환
 *
 * @returns
 * @example
 */
utilLib.getProgramId = function() {
	return $p.top().wdcMain.getSelectedWindowId();
};

/**
 * 윈도우 컨테이너 선택된 윈도우 타이틀 반환
 *
 * @returns 윈도우 타이틀
 * @example
 */
utilLib.getProgramTitle = function() {
	return $p.top().wdcMain.getWindowLabel(comLib.getProgramId(), "toolbar")
};

/**
 * MDI창에서 팝업창으로 전환
 *
 * @param   loc 	: window.location.href
 * @param	options : 팝업 옵션
 * @example utilLib.openMDI2Popup(window.location.href);
 */
utilLib.openMDI2Popup = function(loc, options) {
	var url = "";
	var width = 1488;
	var height = 862;

	// 팝업 옵션 : default
	if (options == undefined) {
		options = {
			type : "window",
			width : width,
			height : height,
			top  : screen.availHeight / 2 - (height / 2) - 20,
			left : screen.availWidth  / 2 - (width  / 2),
			useIFrame : false,
			resizable : false,
			title : ""
		};
	}

	// xml 파일경로 뽑기
	for (var i = 0; i < loc.split("w2xPath=").length; i++) {
		if (loc.split("w2xPath=")[i].indexOf(".xml") > 0) {
			url = loc.split("w2xPath=")[i].split(".xml")[0] + ".xml";
			break;
		}
	}

	// 메뉴 경로 가져오기
	if (url != undefined && url != null && url != ""){
		id = top.dlt_totalMenuList.getMatchedJSON("path", url)[0].cd;
		options.title = top.dlt_totalMenuList.getMatchedJSON("path", url)[0].nm;

		var node = top.menuList.findNodeByValue(id);
		if (node != null) {
			options.title = top.scwin.getTitle(node);
		}
	}

	comLib.openPopup($p, id, url, options);
};

/**
 * data list 객체에서 checked(chk) 된 데이터 배열로 반환
 * check column id : chk
 *
 * @param  dltObj : data list
 * @return array
 */
utilLib.getCheckedData = function(dltObj) {
	var arrData = [];
	for (var i = 0; i < dltObj.getRowCount(); i++) {
		if (dltObj.getCellData(i, "chk") == 1) {
			arrData.push(dltObj.getRowJSON(i));
		}
	}

	return arrData;
};

/**
 * 팝업에 전달할 XML 개체를 생성합니다.
 *
 * @param info: XML 개체의 세부 정보
 */
utilLib.makeXmlDocForPopup = function(info) {
	return WebSquare.json.JSON2XML(info);
};

/**
 * 그리드뷰 필수입력항목 체크(값 입력여부)
 *
 * @param	paramArray : 필수입력 체크할 항목
 * @example var param = new Array();
 *			param[0] = new Array("grid1", "dataList1", "field1|field2|field3");	-- 첫번째 그리드( "그리드뷰ID", "데이타리스트ID", "체크필드ID | 체크필드ID | ..." )
 *			param[1] = new Array("grid2", "dataList2", "field1|field2");		-- 두번째 그리드 ...
 *			...
 *			utilLib.chkRequiredGridView( param );
 *
 *			그리드 헤더컬럼ID 값은 "HD_"+바디컬럼ID 로 구성... 헤더컬럼 Value 값이 없을 경우 바디컬럼 ID 값 출력
 *			ex) COL ==> HD_COL
 */
utilLib.chkRequiredGridView = function(paramArray) {
	if (typeof paramArray != "undefined" && paramArray == null) {
		comLib.alert($p, "체크할 정보가 없습니다");
		return false;
	} else {
		var tmpArr = null;
		var grdObj = null;
		var dataObj = null;
		var fieldArr = null;
		var displayVal = "";

		for (var ii = 0; ii < paramArray.length; ii++ ) {
			tmpArr = paramArray[ii];
			grdObj = eval(tmpArr[0]);
			dataObj = eval(tmpArr[1]);
			fieldArr = tmpArr[2].split("|");
			// getDataLength() 함수를 반복 호출하는 것은 성능상 좋지 않기 때문에 한번만 참조하도록 변수를 선언했습니다.
			var dataLength = dataObj.getRowCount();
			for (var i = 0; i < dataLength; i++ ) {
				if (dataObj.getRowStatus(i) == "C" || dataObj.getRowStatus(i) == "U" ) {
					for (var k = 0; k < fieldArr.length; k++ ) {
						var cellValue = dataObj.getCellData(i, fieldArr[k]);
						if (cellValue == null || cellValue == "" ) {
							displayVal = grdObj.getHeaderValue("HD_" + fieldArr[k]);
							comLib.alert($p, "[ " + displayVal + " ] 항목은 필수 입력 항목 입니다.");
							grdObj.setFocusedCell(i, fieldArr[k], true);
							return false;
						}
					}
 				} //end if ( dataObj.getRowStatus(i) == "C" || dataObj.getRowStatus(i) == "U" )
			} // end for ( var i=0; i<grdObj.getDataLength(); i++ )
		} // end for ( var ii=0; ii< paramArray.length; ii++ )

		return true;
	}
};

/**
 * 지정한 날짜(yyyyMMdd)에 지정한 날을 추가합니다.
 *
 * @param   source : 기준 날짜입니다. 구분자를 제외하고 8자리 숫자여야 합니다.
 * @param   addDay : 추가할 날의 수 입니다. (- 값을 지정할 수 있습니다.)
 * @returns yyyyMMdd 형태의 결과 날짜
 * @example utilLib.dateAdd(WebSquare.date.getCurrentServerDate(), 2);
 */
utilLib.dateAdd = function(source, addDay) {
	source = source.replace(/\D/ig, "");
	if (isNaN(source) || source.length < 8) {
		return "";
	}

	return WebSquare.date.dateAdd(source.substr(0, 8), addDay);
};

/**
 * 두 날짜 사이의 차이나는 날짜 수를 반환합니다.
 *
 * @param   fromDate : 기준일자 (구분자를 제외하고 8자리 이상의 숫자여야 합니다.)
 * @param   toDate   : 비교대상 일자 (구분자를 제외하고 8자리 이상의 숫자여야 합니다.)
 * @returns 기준일자와 비교대상 일자 간의 날짜 수
 * @example utilLib.getDateDiff("20161005", "20161007");
 */
utilLib.getDateDiff = function(fromDate, toDate) {
	fromDate = fromDate.replace(/\D/ig, "");
	if (isNaN(fromDate) || fromDate.length < 8) {
		comLib.alert($p, "구분자를 제외하고 최소 8자 이상의 숫자값을 입력하여 주십시오.");
		return "";
	}

	toDate = toDate.replace(/\D/ig, "");
	if (isNaN(toDate) || toDate.length < 8) {
		comLib.alert($p, "구분자를 제외하고 최소 8자 이상의 숫자값을 입력하여 주십시오.");
		return "";
	}

	return WebSquare.date.dateDiff(fromDate.substr(0, 8), toDate.substr(0, 8));
};

/**
 * 시스템 공통 메시지를 가져옵니다.
 *
 * @param   key: 가져올 공통 메시지 키
 * @param   value: 메시지 내부에서 치환할 값. %s의 형태와 {n}의 형태를 모두 치환할 수 있습니다.
 *
 * @returns  {array} [값이 치환된 메시지, 메시지코드(I:정보, W:경고, E:오류, Q:질의)]
 * @example utilLib.getMessage("ICOM0001");
 * 				 utilLib.getMessage("ICOM0027", "금액");
 * 				 utilLib.getMessage("ICOM0026", "금액", "3,000");
 */
utilLib.getMessage = function(key, value) {
	var messages = null;
	var openerOpenTF = false;
	try {
		if (opener) {
			if (opener.location.host == window.location.host) {
				openerOpenTF = true;
			}
		}
	} catch(e) {}

	if (typeof $p.top().dltMsgMng !== "undefined") {
		messages = $p.top().dltMsgMng;
	} else if (typeof $p.top().wfm_left !== "undefined") {
		messages = $p.top().wfm_left.getWindow().dltMsgMng;
	} else if (openerOpenTF) {
		if (opener.$p) {
			if (typeof opener.$p.top().dltMsgMng !== "undefined") {
				messages = opener.$p.top().dltMsgMng;
			} else if (typeof opener.$p.top().wfm_left !== "undefined") {
				messages = opener.$p.top().wfm_left.getWindow().dltMsgMng;
			}
		}
		if (messages == null) {
			var openerOpenTF2 = false;
			try {
				if (opener) {
					if (opener.opener.location.host == window.location.host) {
						openerOpenTF2 = true;
					}
				}
			} catch(e){}

			if (openerOpenTF2) {
				if (opener.opener.$p) {
					if (typeof opener.opener.$p.top().dltMsgMng !== "undefined") {
						messages = opener.opener.$p.top().dltMsgMng;
					} else if (typeof opener.opener.$p.top().wfm_left !== "undefined") {
						messages = opener.opener.$p.top().wfm_left.getWindow().dltMsgMng;
					}
				}
			}
		}
	}
		
	if (messages == null) {
		var parentCnt = 0;
		var win = window;
		try {
			while (messages == null && win != null && parentCnt < 10) {
				// 팝업에서 사용 시
				if (typeof win.opener != "undefined" && win.opener != null && win.opener != "") {
					messages = win.opener.$p.top().wfm_left.getWindow().dltMsgMng;
					win = win.opener;
				// 팝업에서 wframePopup 사용 시
				} else if (typeof win.top.opener != "undefined" && win.top.opener != null && win.top.opener != "") {
					messages = win.top.opener.$p.top().wfm_left.getWindow().dltMsgMng;
					win = win.top.opener;
				} else {
					messages = win.$p.top().wfm_left.getWindow().dltMsgMng;
					win = null;
				}
			}
			if (messages == null) {
				return "";
			}
		} catch (ex) {
			return "";
		}
	}

	var message = "";

	if (messages.getMatchedData("msgId", key, true).length > 0) {
		message = utilLib.trim(messages.getMatchedData("msgId", key, true)[0][4]);

		if (utilLib.isNull(message)) {
			return "";
		}

		var argLength = arguments.length;
		if (argLength == 2) {
			// 치환할 값이 1개 존재하는 경우.
			message = message.replace(/%s/ig, utilLib.safeString(value)).replace(/\{0\}/img, utilLib.safeString(value));
		} else if (argLength > 2) {
			// 치환할 값이 1개 이상 존재하는 경우.
			for (var i = 1; i < argLength; i++) {
				var regEx = new RegExp("\\{" + (i - 1).toString() + "\\}", "img");
				message = message.replace(regEx, utilLib.safeString(arguments[i]));
			}
			message = message.replace(/\{\d{1,3}\}?/img, "");
		}
		message = message.replace(/\n/g, "<br/>");

		return [message, key.split(".")[1]];
	} else {
		return [key];
	}
};

/**
 * 행추가
 *
 * @param   gridView
 * @param   last	 : true(default last), false(first)
 * @example utilLib.addRow(gridView);
 * 		 utilLib.addRow(gridView, false);
 */
utilLib.addRow = function(gridView, last) {
	// var dataList = eval(gridView.getDataList());
	var dataList = $p.getComponentById(gridView.getDataList());
	var rowIndex = (last == undefined || last == true) ? dataList.getRowCount() : 0;
	var insertedIndex = dataList.insertRow(rowIndex);
	gridView.setFocusedCell(insertedIndex, 0);

	return insertedIndex;
};

/**
 * 행삭제 (dataList.removeRow() 사용)
 *
 * @param gridView
 * @example utilLib.removeRow(gridView);
 */
utilLib.removeRow = function(gridView) {
	comLib.removeGridView(gridView);
};

/**
 * 행삭제 (dataList.deleteRow() 사용)
 *
 * @param gridView
 * @example utilLib.deleteRow(gridView);
 */
utilLib.deleteRow = function(gridView) {
	comLib.deleteGridView(gridView);
};

/**
 * 행복사
 *
 * @param gridView
 * @param last : true(default last), false(first)
 * @example utilLib.copyRow(gridView);
 * 		 utilLib.copyRow(gridView, false);
 */
utilLib.copyRow = function(gridView, last) {
	// var dataList = eval(gridView.getDataList());
	var dataList = $p.getComponentById(gridView.getDataList());

	if (gridView.getFocusedRowIndex() < 0) {
		comLib.alert($p, utilLib.getMessage("WCOM0069", "복사"));
	} else {
		var rowIndex = (last == undefined || last == true) ? dataList.getRowCount() : 0;
		dataList.insertData(rowIndex, dataList.getRowData(gridView.getFocusedRowIndex()));
	}
};

/**
 * gridView 데이터 Validation
 * - gridView 데이터 Validation 후 comLib.alert 창으로 maxMessage 크기 만큼 출력하고
 * - gridView cell color 가 red로 바뀌고 backgroundColor 가 범례에 따라 바뀜
 *
 * @param gridView
 * @param valInfo : mandatory, maxLength, minLength, number, alpha, alphanumber, isHangul,
 * @param setDefaultBackground : 배경, 폰트 색상 초기화 여부
 * @return true(valid), false(invalid)
 * @example var valInfo = [
	{id : "col1", mandatory : true, maxLength : 5, minLength : 3, isHangul : false},
	{id : "col2", mandatory : true, maxLength : 5, isHangul : false},
	{id : "col3", number : true},
	{id : "col4", code : "ldt_code_ACOCLCD"}
	];
	utilLib.validateGridView(grd_view, valInfo, true);
 */
utilLib.validateGridView = function(gridView, valInfo, setDefaultBackground, option) {
	var maxMessage = 30;
	var arrData = [];
	// var dataList = eval(gridView.getDataList());
	var dataList = $p.getComponentById(gridView.getDataList());

	for (var i = 0; i < dataList.getRowCount(); i++) {
		for (var valIdx = 0; valIdx < valInfo.length; valIdx++) {
			// 그리드 색상 초기화
			if (setDefaultBackground) {
				gridView.setCellColor(i, valInfo[valIdx].id, "rgba(0, 0, 0, 1)");
				gridView.setCellBackgroundColor(i , valInfo[valIdx].id, i % 2 == 1 ? "rgba(244, 244, 244, 1)":"rgba(254, 254, 254, 1)");
			} else {
				gridView.setCellColor(i, valInfo[valIdx].id, "");
				gridView.setCellBackgroundColor(i , valInfo[valIdx].id, "");
			}
			// 값
			var value = dataList.getCellData(i, valInfo[valIdx].id);
			if ((option && option.type == "modify") && dataList.getRowStatus(i) == "R") {
				continue;
			}
			// 필수
			if ((typeof valInfo[valIdx].mandatory != "undefined") && (valInfo[valIdx].mandatory == true) && (value.length == 0)) {
				gridView.setCellColor(i, valInfo[valIdx].id, "red");
				gridView.setCellBackgroundColor(i, valInfo[valIdx].id, utilLib.INVALID_COLOR_MANDATORY);
				if (arrData.length < maxMessage) {
					arrData.push((i + 1) + " line. " + utilLib.getMessage("SCM.INFO.00004", dataList.getColumnName(valInfo[valIdx].id))[0]);
				} else {
					continue;
				}
			// 최대길이
			} else if ((typeof valInfo[valIdx].maxLength != "undefined") && (typeof valInfo[valIdx].maxLength == "number") && (value.length > valInfo[valIdx].maxLength)) {
				gridView.setCellColor(i, valInfo[valIdx].id, "red");
				gridView.setCellBackgroundColor(i, valInfo[valIdx].id, utilLib.INVALID_COLOR_MAXLENGTH);
				if (arrData.length < maxMessage) {
					arrData.push((i + 1) + " line. " + utilLib.getMessage("SCM.INFO.00006", dataList.getColumnName(valInfo[valIdx].id), valInfo[valIdx].maxLength)[0]);
				} else {
					continue;
				}
			// 최대Byte길이
			} else if ((typeof valInfo[valIdx].maxByteLength != "undefined") && (typeof valInfo[valIdx].maxByteLength == "number") && (ecsLib.get3ByteLength(value) > valInfo[valIdx].maxByteLength)) {
				gridView.setCellColor(i, valInfo[valIdx].id, "red");
				gridView.setCellBackgroundColor(i, valInfo[valIdx].id, utilLib.INVALID_COLOR_MAXLENGTH);
				if (arrData.length < maxMessage) {
					arrData.push((i + 1) + " line. " + utilLib.getMessage("SCM.INFO.00006", dataList.getColumnName(valInfo[valIdx].id), valInfo[valIdx].maxByteLength + "Byte 글")[0]);
				} else {
					continue;
				}
			// 최소길이
			} else if ((typeof valInfo[valIdx].minLength != "undefined") && (typeof valInfo[valIdx].minLength == "number") && (value.length < valInfo[valIdx].minLength)) {
				gridView.setCellColor(i, valInfo[valIdx].id, "red");
				gridView.setCellBackgroundColor(i, valInfo[valIdx].id, utilLib.INVALID_COLOR_MINLENGTH);
				if (arrData.length < maxMessage) {
					arrData.push((i + 1) + " line. " + utilLib.getMessage("SCM.INFO.00005", dataList.getColumnName(valInfo[valIdx].id), valInfo[valIdx].minLength)[0]);
				} else {
					continue;
				}
			// 숫자만 허용
			} else if ((typeof valInfo[valIdx].number != "undefined") && valInfo[valIdx].number == true && !utilLib.isNumberOld(value)) {
				gridView.setCellColor(i, valInfo[valIdx].id, "red");
				gridView.setCellBackgroundColor(i, valInfo[valIdx].id, utilLib.INVALID_COLOR_NUMBER);
				if (arrData.length < maxMessage) {
					arrData.push((i + 1) + " line. " + utilLib.getMessage("SCM.INFO.00010", dataList.getColumnName(valInfo[valIdx].id))[0]);
				} else {
					continue;
				}
			// 알파벳만 허용
			} else if ((typeof valInfo[valIdx].alpha != "undefined") && valInfo[valIdx].alpha == true && !utilLib.isAlpha(value)) {
				gridView.setCellColor(i, valInfo[valIdx].id, "red");
				gridView.setCellBackgroundColor(i, valInfo[valIdx].id, utilLib.INVALID_COLOR_ALPHANUMBER);
				if (arrData.length <= maxMessage) {
					arrData.push((i + 1) + " line. " + utilLib.getMessage("SCM.INFO.00337")[0]);
				} else {
					continue;
				}
			// 알파벳, 숫자만 허용
			} else if ((typeof valInfo[valIdx].alphanumber != "undefined") && valInfo[valIdx].alphanumber == true && (!utilLib.isAlphaNumber(value))) {
				gridView.setCellColor(i, valInfo[valIdx].id, "red");
				gridView.setCellBackgroundColor(i, valInfo[valIdx].id, utilLib.INVALID_COLOR_ALPHANUMBER);
				if (arrData.length <= maxMessage) {
					arrData.push((i+1) + " line. " + utilLib.getMessage("SCM.INFO.00338", dataList.getColumnName(valInfo[valIdx].id))[0]);
				} else {
					continue;
				}
			// 한글만 허용
			} else if ((typeof valInfo[valIdx].isHangul != "undefined") && valInfo[valIdx].isHangul == true && (!utilLib.isKoreanWord(value))) {
				gridView.setCellColor(i, valInfo[valIdx].id, "red");
				gridView.setCellBackgroundColor(i, valInfo[valIdx].id, utilLib.INVALID_COLOR_HANGUL);
				if (arrData.length <= maxMessage) {
					arrData.push((i + 1) + " line. " + utilLib.getMessage("SCM.INFO.00019", dataList.getColumnName(valInfo[valIdx].id))[0]);
				} else {
					continue;
				}
			// 공통코드 체크
			} else if ((typeof valInfo[valIdx].code != "undefined" && eval(valInfo[valIdx].code).getMatchedData("cdDvsId",value).length == 0)) {
				gridView.setCellColor(i, valInfo[valIdx].id, "red");
				gridView.setCellBackgroundColor(i, valInfo[valIdx].id, utilLib.INVALID_COLOR_CODE);
				if (arrData.length <= maxMessage) {
					arrData.push((i + 1) + " line. " + utilLib.getMessage("WCOM0070", dataList.getColumnName(valInfo[valIdx].id))[0]);
				} else {
					continue;
				}
			// ECS DateType Validate Function
			} else if ((typeof valInfo[valIdx].dateFunc != "undefined") && (typeof valInfo[valIdx].dateFunc == "function")) {
				var msg = valInfo[valIdx].dateFunc(value, null, false);
				if (msg) {
					gridView.setCellColor(i, valInfo[valIdx].id, "red");
					gridView.setCellBackgroundColor(i, valInfo[valIdx].id, utilLib.INVALID_COLOR_NUMBER);
					if (arrData.length <= maxMessage) {
						arrData.push((i + 1) + " line. " + dataList.getColumnName(valInfo[valIdx].id) + "은(는) " + msg);
					} else {
						continue;
					}
				}
			}
		}
	}

	if (!utilLib.isNull(arrData)) {
		var message = "";
		for (var i = 0; i < arrData.length; i++) {
			message += arrData[i] + "<br/>";
		}
/*
		var height = arrData.length * 13;
		if (height > 415) {
			height = height * 2 / 3;
		}

		var options = {
			title : "Data Validation",
			popupParam : {
				"message" : message,
				"messageType" : "W",
				"closeCallbackFncName" : "",
				"isReturnValue" : false
			},
			modal : true,
			width : 1000,
			height : 185 + height,
			className : "header-none"
		};
		comLib.openPopup("alert", "/ui/common/message_box.xml", options);
*/
		comLib.messageBox(gridView.getScopeWindow().$p, "alert", message, "", false, "Data Validation");
		return false;
	}

	return true;
};

/**
 * 숫자인지 여부 확인
 *
 * @param s
 * @return 숫자이면 true
 */
utilLib.isNumber = function(s) {
	s += ""; // 문자열로 변환
	s = s.replace(/^\s*|\s*$/g, ""); // 좌우 공백 제거
	if (s == "" || isNaN(s)) {
		return false;
	}
	return true;
};

/**
 * 알파벳인지 여부 확인
 *
 * @param   s
 * @return  알파벳이면 true
 */
utilLib.isAlpha = function(s) {
	s += ""; // 문자열로 변환
	s = s.replace(/^\s*|\s*$/g, ""); // 좌우 공백 제거
	if (s == "" || s.match(/^[a-zA-Z]+$/) == null) return false;
	return true;
};

/**
 * 알파벳, 숫자인지 여부 확인
 *
 * @param s
 * @return 알파벳, 숫자이면 true
 */
utilLib.isAlphaNumber = function(s) {
	s += ""; // 문자열로 변환
	s = s.replace(/^\s*|\s*$/g, ""); // 좌우 공백 제거
	if (s == "" || s.match(/^[a-z0-9A-Z]+$/) == null) {
		return false;
	}
	return true;
};

/**
 * 데이터 컬렉션 객체 초기화
 *
 * @param dcObj : map/list object
 */
utilLib.clearDcObj = function(dcObj) {
	if (typeof dcObj.getObjectType == "function") {
		if (dcObj.getObjectType() == "dataMap") {
			var tmpJSONData = new Object();
			for (var i = 0; i < dcObj.getCount(); i++) {
				eval("tmpJSONData." + dcObj.getKey(i) + " = ''");
			}
			dcObj.setJSON(tmpJSONData);
		} else {
			dcObj.setJSON({});
		}
	}
};

/**
 * 데이터 컬렉션 객체 데이터가 비어 있는지 판단
 *
 * @param dcObj
 * @return true(empty), false(not empty)
 */
utilLib.isEmptyDcObj = function(dcObj) {
	if (dcObj.getObjectType() == "dataMap") {
		for (var i = 0; i < dcObj.getCount(); i++) {
			if (!utilLib.isNull(dcObj.get(dcObj.getKey(i)))) {
				return false;
			}
		}
	} else {
		return dcObj.getRowCount() == 0;
	}

	return true;
};

/**
 * 부모 객체를 반환
 *
 * @return
 */
utilLib.getParentPage = function() {
	var openerobj=parent;
	try {
		if (opener) {
			if (opener.location.host == window.location.host) {
				openerobj = opener;
			}
		}
	} catch(e) {}

	return openerobj;
};

/**
 * stylesheet 추가
 * 
 * @param window
 * @param file : css 파일
 * @example utilLib.appendStyleSheet("/resources/css/theme-blue.css");
 */
utilLib.appendStyleSheet = function(winObj, file) {
	var link = winObj.document.createElement("link");
	link.rel = "stylesheet";
	link.type = "text/css";
	link.href = file;
	winObj.document.head.appendChild(link);
};

/**
 * stylesheet skin 설정
 * 
 * @param	idx
 * @example utilLib.setSkin();
 */
utilLib.setSkin = function(idx) {
	try {
		switch (idx) {
			case 1 : localStorage.setItem("DAON_SKIN", "" ); break;
			case 2 : localStorage.setItem("DAON_SKIN", utilLib.SKIN_GREEN ); break;
			case 3 : localStorage.setItem("DAON_SKIN", utilLib.SKIN_PURPLE ); break;
			case 4 : localStorage.setItem("DAON_SKIN", utilLib.SKIN_GRAY ); break;
			case 5 : localStorage.setItem("DAON_SKIN", utilLib.SKIN_COOLGREEN ); break;
		}
	} catch (e) {
		console.error(e);
		switch (idx) {
			case 1 : comLib.setCookie("DAON_SKIN", "", 9999 ); break;
			case 2 : comLib.setCookie("DAON_SKIN", utilLib.SKIN_GREEN, 9999 ); break;
			case 3 : comLib.setCookie("DAON_SKIN", utilLib.SKIN_PURPLE, 9999 ); break;
			case 4 : comLib.setCookie("DAON_SKIN", utilLib.SKIN_GRAY, 9999 ); break;
			case 5 : comLib.setCookie("DAON_SKIN", utilLib.SKIN_COOLGREEN, 9999 ); break;
		}
	}
};

/**
 * stylesheet skin 변경
 * 
 * @example utilLib.changeSkin();
 */
utilLib.changeSkin = function(winObj) {
	// skin 삭제
	for (var i = 0; i < winObj.$("link[rel=stylesheet]").length; i++) {
		if (winObj.$("link[rel=stylesheet]")[i].href.indexOf("/resources/css/skin_") > -1) {
			winObj.$('link[rel=stylesheet][href="'+utilLib.SKIN_GREEN+'"').remove();
			winObj.$('link[rel=stylesheet][href="'+utilLib.SKIN_PURPLE+'"').remove();
			winObj.$('link[rel=stylesheet][href="'+utilLib.SKIN_GRAY+'"').remove();
			winObj.$('link[rel=stylesheet][href="'+utilLib.SKIN_COOLGREEN+'"').remove();
		}
	}

	try {
		// skin 추가
		if (!utilLib.isNull(localStorage.getItem("DAON_SKIN"))) {
			utilLib.appendStyleSheet(winObj, localStorage.getItem("DAON_SKIN"));
		}
	} catch (e) {
		console.error(e);
		//skin 추가
		if (!utilLib.isNull(comLib.getCookie("DAON_SKIN"))) {
			utilLib.appendStyleSheet(winObj, comLib.getCookie("DAON_SKIN"));
		}
	}
};

/**
 * stylesheet 변경
 * 
 * @param srcCss source css 파일
 * @param destCss dest css 파일
 * @example utilLib.changeStyleSheet("content.css", "common1.css");
 */
utilLib.changeStyleSheet = function(srcCss, destCss) {
	var exists = false;

	for (var i = 0; i < $("link[rel=stylesheet]").length; i++) {
		var link = $("link[rel=stylesheet]")[i].href;
		var css = link.substring(link.lastIndexOf("/") + 1, link.length);

		if (css == srcCss) {
			$('link[href="' + css + '"]').attr("href", link.substring(0, link.lastIndexOf("/") + 1) + destFile);
			exists = true;
			break;
		}
	}

	if (exists == false) {
		utilLib.appendStyleSheet(destCss);
	}
};

/**
 * 입력 영문(띄어쓰기)만 : onkeyup 이벤트에 적용
 * @param compID  컴포넌트 ID
 * @param space	띄어쓰기 (default : false)
 */
utilLib.inputOnlyAlpha = function(compID, space) {
	space = space || false;
	var val = compID.getValue();
	var regexp;

	if (space) {
		regexp = /[^a-zA-Z\s]/gi; // 영문,띄어쓰기만
	} else {
		regexp = /[^a-zA-Z]/gi; // 영문만(띄어쓰기 제외)
	}

	compID.setValue(val.replace(regexp, ""));
};

/**
 * 입력 숫자(띄어쓰기)만 : onkeyup 이벤트에 적용
 * @param compID  컴포넌트 ID
 * @param space	띄어쓰기 (default : false)
 */
utilLib.inputOnlyNum = function(compID, space) {
	space = space || false;
	var val = compID.getValue();
	var regexp;

	if (space) {
		regexp = /[^0-9\s]/gi; // 숫자,띄어쓰기만
	} else {
		regexp = /[^0-9]/gi; // 숫자만(띄어쓰기 제외)
	}

	compID.setValue(val.replace(regexp, ""));
};

/**
 * 입력 숫자,하이픈(띄어쓰기)만 : onkeyup 이벤트에 적용
 * @param compID  컴포넌트 ID
 * @param space	띄어쓰기 (default : false)
 */
utilLib.inputOnlyNumHyphen = function(compID, space) {
	space = space || false;
	var val = compID.getValue();
	var regexp;

	if (space) {
		regexp = /[^0-9\-\s]/gi; // 숫자,하이픈,띄어쓰기만
	} else {
		regexp = /[^0-9\-]/gi; // 숫자,하이픈만(띄어쓰기 제외)
	}

	compID.setValue( val.replace(regexp, "") );
};

/**
 * 입력 영문,숫자(띄어쓰기)만 : onkeyup 이벤트에 적용
 * @param compID  컴포넌트 ID
 * @param space	띄어쓰기 (default : false)
 */
utilLib.inputOnlyAlphaNum = function(compID, space) {
	space = space || false;
	var val = compID.getValue();
	var regexp;

	if (space) {
		regexp = /[^a-zA-Z0-9\s]/gi; // 영문,숫자,띄어쓰기만
	} else {
		regexp = /[^a-zA-Z0-9]/gi; // 영문,숫자만(띄어쓰기 제외)
	}

	compID.setValue( val.replace(regexp, "") );
};

/**
 * 입력 한글만(띄어쓰기)만 : onkeyup 이벤트에 적용
 * @param compID  컴포넌트 ID
 * @param space	띄어쓰기 (default : false)
 */
utilLib.inputOnlyKorean = function(compID, space) {
	space = space || false;
	var val = compID.getValue();
	var regexp;

	if (space) {
		regexp = /[a-z0-9]|[\[\]{}()<>?|'~!@#$%-_+=,.;:\"'\\]/g; // 한글,띄어쓰기만
	} else {
		regexp = /[a-z0-9]|[ \[\]{}()<>?|'~!@#$%-_+=,.;:\"'\\]/g; // 한글만(띄어쓰기 제외)
	}

	compID.setValue( val.replace(regexp, "") );
};

/**
 * 전달받은 두 일시간의 차이 계산 
 * 
 * @date 2017. 07. 27.
 * @param startTime 시작일시(yyyymmddHH24miss)
 * @param endTime 종료일시(yyyymmddHH24miss)
 * @return diffSec  경과초
 */	
utilLib.getDateTimeDiff = function(startTime, endTime) {
	var startDate = new Date(parseInt(startTime.substring(0, 4), 10),
		parseInt(startTime.substring(4, 6), 10) - 1,
		parseInt(startTime.substring(6, 8), 10),
		parseInt(startTime.substring(8, 10), 10),
		parseInt(startTime.substring(10, 12), 10),
		parseInt(startTime.substring(12, 14), 10)
	);
	
	var endDate = new Date(parseInt(endTime.substring(0, 4), 10),
		parseInt(endTime.substring(4, 6), 10) - 1,
		parseInt(endTime.substring(6, 8), 10),
		parseInt(endTime.substring(8, 10), 10),
		parseInt(endTime.substring(10, 12), 10),
		parseInt(endTime.substring(12, 14), 10)
	);
	return (parseInt(endDate.getTime()) - parseInt(startDate.getTime())) / 1000;
};

/**
 * 전체 URL로 Domain 알아내기
 */
utilLib.getDomainFromUrl = function(url) {
	var schema = "";
	var hostname = "";

	if (url.indexOf("://") > -1) {
		schema = url.split("/")[0] + "//";
		hostname = url.split("/")[2];
	} else {
		hostname = url.split("/")[0];
	}
	hostname = hostname.split("?")[0];
	
	return schema + hostname;
};

/**
 * 달이 추가된 날짜를 (년월일시 또는 년월)를 YYYYMMDD or YYYYMM 포맷의 문자열로 반환한다.
 * 2020.04.13 60003867 
 * @return <String> YYYYMMDD OR YYYYMM
 */
utilLib.addMonth = function(date, add) {
	var rDate = date.replace(/-/g, "");
	var year;
	var month;
	var day;
	if (rDate.length < 8) {
		year = rDate.substring(0, 4);
		month = rDate.substring(4, 6);
		day = "01";
	} else {
		year = rDate.substring(0, 4);
		month = rDate.substring(4, 6);
		day = rDate.substring(6, 8);
	}
	var cDate = new Date(year, month - 1, day);
	cDate.setMonth(cDate.getMonth() + add);
	var cYear = cDate.getFullYear();
	var cMonth = (cDate.getMonth() + 1);
	var cDay = cDate.getDate();

	if (parseInt(cMonth) < 10) {
		cMonth = "0" + cMonth;
	}
	if (parseInt(cDay) < 10) {
		cDay = "0" + cDay;
	}

	var rtn;
	if (rDate.length < 8) {
		rtn = String(cYear) + String(cMonth);
	} else {
		rtn = String(cYear) + String(cMonth) + String(cDay);
	}
	return rtn;
};