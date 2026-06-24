/**
 * @target 	ì—…, ¸ì…˜, µí†µ ”ì‹œ€ €µí†µ ?¨ìˆ˜
 * @type 	comLib
 * @since 	2017.04.03
 * @author 	TJ Kim
 */

var comLib = {};

comLib.SYS_DIV_CD = "ECS";
comLib.STATUS_SUCCESS = "success";
comLib.STATUS_ERROR = "error";

comLib.POPUP_UID = 1;											//POPUP UID
comLib.userDocData;												// ”ë©´„í™˜€ Œë¼¸í„°’ë“± doc¼ë¡œ ¤ì •
comLib.aprvRqustData;											// …ë¬´°ì¬”ì²­¬ìš©˜ëŠ” °ì´//CSRF €ì„ „í•œ  í° €??comLib.KTAG_TOKEN_FIELD = "ktagTokenField";						//ktag  í° „ë“œ:  ì •
comLib.SAVED_TOKEN = comLib.SYS_DIV_CD + "_" + "savedToken";	//saved  í° „ë“œ: œìŠ¤œë³„  ì •

/**
 * ”ë‰´ € ”ë‰´ ¹„Œì´navigator.xml)ì„œ ?¬ìš©.
 * ¼ìª½ ”ë‰´ „ì²´ ©ë¡
 */
comLib.arrLeftMenuAll = new Array();

/** ì—…ì²´ */
comLib.windowObjRef = null;

/** Œì¼¤ìš´œë“œ ˜ë¦¬??timer ì²´ (2019-12-27 µí†µ€ add...) */
comLib.fileDwldTimer = null;
/** Œì¼¤ìš´œë“œ ˜ë¦¬??Cookie „ë“œ(2019-12-27 µí†µ€ add...) */
comLib.FILE_DWLD_TOKEN = "fileDownloadToken";
/** Œì¼¤ìš´œë“œ ˜ë¦¬íƒœ (2019-12-27 µí†µ€ add...) */
comLib.FILE_DWLD_STATUS_COMPLETE = "COMPLETE";

comLib.ozCnt = 0; // ADD 20200908 60003867

comLib.ADT_POP_URL = "https://adt.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.HRM_POP_URL = "https://hrm.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
// comLib.HRM_POP_URL = "http://hrm.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.FMS_POP_URL = "https://nfms.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.BID_POP_URL = "https://bid.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.WCB_POP_URL = "https://wcb.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.STG_POP_URL = "https://stg.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.MGT_POP_URL = "https://mgt.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.LIB_POP_URL = "https://lib.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.WRI_POP_URL = "https://wri.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.WRO_POP_URL = "https://wro.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.WFM_POP_URL = "https://wfm.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
// comLib.WFM_POP_URL = "http://wfm.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.PFM_POP_URL = "https://pfm.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.WQE_POP_URL = "https://wqe.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.LWS_POP_URL = "https://lws.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.LWP_POP_URL = "https://lwp.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.LAW_POP_URL = "https://law.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.LAO_POP_URL = "https://lao.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.CMS_POP_URL = "https://cms.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.CTS_POP_URL = "https://cts.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.WTL_POP_URL = "https://wtl.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.SCM_POP_URL = "https://scm.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
//comLib.SCM_POP_URL = "https://pscm.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.SMP_POP_URL = "https://smp.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.WIS_POP_URL = "https://wis.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.SRN_POP_URL = "https://srn.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath="; // ADD ˜ë¦¬??2020.02.12
comLib.HMS_POP_URL = "https://hms.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath="; // ADD ´ê°•€¬ì‹œ¤í…œ 2020.04.29
comLib.GHG_POP_URL = "https://ghg.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.OZ_POP_URL = "https://rpt.[BASE_DOMAIN]";
// comLib.OZ_POP_URL = "https://rpt.[BASE_DOMAIN]";
/* 2020.11.25 ¼ì†Œ°íšŒ URL ”ê */
comLib.COMMON_POP_URL = "https://scm.[BASE_DOMAIN]";
comLib.ECS_POP_URL = "https://ecs.[BASE_DOMAIN]/wq/winPopup.jsp?w2xPath=";
comLib.REALTIME_POP_URL = "https://realtimegios.[BASE_DOMAIN]:8917";
comLib.GDMS_POP_URL = "https://realtimegios.[BASE_DOMAIN]:8126";

comLib.OASIS_CALL_POP_URL = "https://portal.[BASE_DOMAIN]:8080/portal/epmain/approval/epApprovalList.do"; // µí•©°ì¬202008

comLib.getUsrId = function() { return comLib.getUserInfo("usrId"); };				// ?¬ìš©ID
comLib.getUsrEmpno = function() { return comLib.getUserInfo("usrEmpno") };			// ?¬ìš©ì‚¬ë²ˆcomLib.getUsrNm = function() { return comLib.getUserInfo("usrNm"); };				// ?¬ìš©ëª…
comLib.getSysDivCd = function() { return comLib.getUserInfo("sysDivCd"); };			// œìŠ¤œêµ¬„ì½”comLib.getBiznDivCd = function() { return comLib.getUserInfo("biznDivCd"); };		// …ë¬´¬ë¶„”ë“œ
comLib.getAthrId = function() { return comLib.getUserInfo("athrId"); };				// Œí•œID
comLib.getUsrDeptCd = function() { return comLib.getUserInfo("usrDeptCd"); };		// ?¬ìš©ëœì½”comLib.getUsrDeptNm = function() { return comLib.getUserInfo("usrDeptNm"); };		// ?¬ìš©ëœëª…
comLib.getUsrOfcpsCd = function() { return comLib.getUserInfo("usrOfcpsCd"); };		// ?¬ìš©ì§„ì½”comLib.getUsrOfcpsNm = function() { return comLib.getUserInfo("usrOfcpsNm"); };		// ?¬ìš©ì§„ëª…
comLib.getUsrJgrdCd = function() { return comLib.getUserInfo("usrJgrdCd"); };		// ?¬ìš©ì§‰ì½”comLib.getUsrJgrdNm = function() { return comLib.getUserInfo("usrJgrdNm"); };		// ?¬ìš©ì§‰ëª…

comLib.getUsrHqCd = function() { return comLib.getUserInfo("usrHqCd"); };			// ?¬ìš©ë³¸€”ë“œ
comLib.getUsrHqNm = function() { return comLib.getUserInfo("usrHqNm"); };			// ?¬ìš©ë³¸€?comLib.getUsrSectCd = function() { return comLib.getUserInfo("usrSectCd"); };		// ?¬ìš©ë(”ë“œ
comLib.getUsrSectNm = function() { return comLib.getUserInfo("usrSectNm"); };		// ?¬ìš©ë(??comLib.getUsrTeamCd = function() { return comLib.getUserInfo("usrTeamCd"); };		// ?¬ìš©í”ë“œ
comLib.getUsrTeamNm = function() { return comLib.getUserInfo("usrTeamNm"); };		// ?¬ìš©ícomLib.getUsrJbgpCd = function() { return comLib.getUserInfo("usrJbgpCd"); };		// ?¬ìš©ì§°ì½”comLib.getUsrJbgpNm = function() { return comLib.getUserInfo("usrJbgpNm"); };		// ?¬ìš©ì§°ëª…
comLib.getUsrJblnCd = function() { return comLib.getUserInfo("usrJblnCd"); };		// ?¬ìš©ì§¬ì½”comLib.getUsrJblnNm = function() { return comLib.getUserInfo("usrJblnNm"); };		// ?¬ìš©ì§¬ëª…
comLib.getUsrDtyCd = function() { return comLib.getUserInfo("usrDtyCd"); };			// ?¬ìš©ì§´ì½”comLib.getUsrDtyNm = function() { return comLib.getUserInfo("usrDtyNm"); };			// ?¬ìš©ì§´ëª…
comLib.getCstctCd = function() { return comLib.getUserInfo("cstctCd"); };			// ”ìŠ¤¸ì„¼°ì½”comLib.getCstctNm = function() { return comLib.getUserInfo("cstctNm"); };			// ”ìŠ¤¸ì„¼°ëª…

comLib.getConectIp = function() { return comLib.getUserInfo("conectIp"); };			// ‘ì†IP
comLib.getIdvinfoDealAthrYn = function() { return comLib.getUserInfo("idvinfoDealAthrYn"); };	// œì¸•ë³´¨ê¸‰Œí•œ ´ìœ  ?¬ë ( Y : Œí•œˆìŒ, X : Œí•œ ˆìœ¼´ì•ˆœì•½‘ì„± ˆí•¨, N : Œí•œ †ìŒ )

// œë²„œëˆë¡œ œí–‰„ì¬  í°»ê¸°
comLib.getSavedToken = function() {
	return this.getGlobal(comLib.SAVED_TOKEN);
};

// œë²„œëˆë¡œ œí–‰„ì¬  í°¤ì •
comLib.setSavedToken = function(tokenId) {
	this.setGlobal(comLib.SAVED_TOKEN, tokenId);
}; // œë²„œëˆë¡œ œí–‰„ì¬  í°
/**
 * œë²„œë„ë‹¬¬ìš©ì •°ì´°ì…‹µì„ „ì—­€˜ë¡œ ¤ì •œë‹¤.
 * @param userInfo json°ì´ * @return †ìŒ
 */
comLib.setUserInfoDS = function(userInfo) {
	WebSquare.session.setAttribute("globalUserInfo", userInfo);
	// sessionStorage.setItem("globalUserInfo", userInfo);
};

/**
 * ?¬ìš©ì •´ì— ¹ì •’ì„ ¤ì •œë‹¤.
 * @param key 		€˜ëª…
 * @param value 	€˜ê°’
 * @return †ìŒ
 */
comLib.setUserInfo = function(name, value) {
	try {
		if (WebSquare.session && WebSquare.session.getAttribute) {
			if (utilLib.isNull(name)) {
				return;
			}
			// …ë¬´¬ë¶„”ë“œ˜ëŸ¼ null¤ì–´¤ëŠ” ½ìš° Type Error œìƒ.
			if (value == null) {
				value = "";
			}
			WebSquare.session.setAttribute(name, value);
		} else {
			return null;
		}
	} catch(e) {
		alert("[error at comLib.setUserInfo]" + e);
	}
};

/**
 * ?¬ìš©ì •´ì—¹ì • ’ì„ »ëŠ”
 * @param name €˜ëª…
 * @return €˜ê°’
 */
comLib.getUserInfo = function(name) {
	try {
		if (WebSquare.session && WebSquare.session.getAttribute) {
			return WebSquare.session.getAttribute(name);
		} else {
			return null;
		}
	} catch(e) {
		alert("[error at comLib.getUserInfo]" + e);
	}
};

/**
 * ¸ì…˜ •ë³´JSON •íƒœ¬í„´ (Get/Post ©ì‹ ?¬ìš©Œë¼¸í„°)
 * @param strEnc 	”í˜¸¤ê°’
 * @param title 	title
 * @return userInfo
 */
comLib.getUserInfo4Param = function(strEnc, title) {
	var userInfo = {
		usrId : comLib.getUsrId(),
		sysDivCd : comLib.getSysDivCd(),
		biznDivCd : comLib.getBiznDivCd(),
		strEnc : utilLib.safeString(strEnc),
		title : utilLib.safeString(title)
	};

	return userInfo;
};

/**
 * ¸ì…˜ •ë³´String •íƒœ¬í„´ (Get ©ì‹ ?¬ìš©Œë¼¸í„°)
 * @param <String> strEnc 	”í˜¸¤ê°’
 * @param <String> title 	title
 * @return <String> strParam
 */
comLib.getUserInfo4Str = function(strEnc, title) {
	var userInfo = comLib.getUserInfo4Param(strEnc, title);
	var strParam = "";
	var param = "";

	for(var key in userInfo) {
		if (userInfo.hasOwnProperty(key)) {
			// console.log("key=" + key);
			// console.log("type=" + typeof userInfo[key]);
			// console.log("data=" + JSON.stringify(userInfo[key]));

			param = param + "&" + key + "=" + userInfo[key];

			strParam = strParam + param;
			param = "";
		}
	}

	return strParam;
};

/**
 * „ì—­€˜ê°’¤ì •œë‹¤.
 * @param name 		€˜ëª…
 * @param value 	€˜ê°’
 * @return †ìŒ
 */
comLib.setGlobal = function(name, value) {
	WebSquare.session.setAttribute(name, value);
	// sessionStorage.setItem(name, value);
};

/**
 * „ì—­€˜ê°’»ëŠ”
 * @param name 		€˜ëª…
 * @param value 	€˜ê°’
 * @return value object
 */
comLib.getGlobal = function(name, value) {
	return WebSquare.session.getAttribute(name, value);
};

/**
 * ¸ì½”©ëœ ¸ì…˜ °ì´°ë ”ì½”œí•˜€˜ì— ¤ì •œë‹¤.
 * @param encodedValue: ¸ì½”©ëœ ¸ì…˜ °ì´ */
comLib.setDecodedValue = function(encodedValue) {
	if (utilLib.isNullString(encodedValue)) {
		return;
	}

	var decData = utilLib.trim(WebSquare.text.BASE64URLDecoder(encodedValue));
	var decDatas = decData.split("|");
	var cnt = 0;

	comLib.setUserInfo("usrId", decDatas[cnt++]);
	comLib.setUserInfo("usrEmpno", decDatas[cnt++]);
	comLib.setUserInfo("usrNm", decDatas[cnt++]);
	comLib.setUserInfo("sysDivCd", decDatas[cnt++]);
	comLib.setUserInfo("biznDivCd", decDatas[cnt++]);
	comLib.setUserInfo("athrId", decDatas[cnt++]);
	comLib.setUserInfo("usrDeptCd", decDatas[cnt++]);
	comLib.setUserInfo("usrDeptNm", decDatas[cnt++]);
	comLib.setUserInfo("usrOfcpsCd", decDatas[cnt++]);
	comLib.setUserInfo("usrOfcpsNm", decDatas[cnt++]);
	comLib.setUserInfo("usrJgrdCd", decDatas[cnt++]);
	comLib.setUserInfo("usrJgrdNm", decDatas[cnt++]);

	comLib.setUserInfo("usrHqCd", decDatas[cnt++]);
	comLib.setUserInfo("usrHqNm", decDatas[cnt++]);
	comLib.setUserInfo("usrSectCd", decDatas[cnt++]);
	comLib.setUserInfo("usrSectNm", decDatas[cnt++]);
	comLib.setUserInfo("usrTeamCd", decDatas[cnt++]);
	comLib.setUserInfo("usrTeamNm", decDatas[cnt++]);
	comLib.setUserInfo("usrJbgpCd", decDatas[cnt++]);
	comLib.setUserInfo("usrJbgpNm", decDatas[cnt++]);
	comLib.setUserInfo("usrJblnCd", decDatas[cnt++]);
	comLib.setUserInfo("usrJblnNm", decDatas[cnt++]);
	comLib.setUserInfo("usrDtyCd", decDatas[cnt++]);
	comLib.setUserInfo("usrDtyNm", decDatas[cnt++]);
	comLib.setUserInfo("cstctCd", decDatas[cnt++]);
	comLib.setUserInfo("cstctNm", decDatas[cnt++]);

	comLib.setUserInfo("conectIp", decDatas[cnt++]);
	comLib.setUserInfo("idvinfoDealAthrYn", decDatas[cnt++]);
};

/**
 * comLib.initForm : ”ë©´ ˆê¸°˜ë¦¬
 * @param formId	”ë©´ID(ScrinID)
 * @param arg		Œí•œ´í¬FLAG(1:Œí•œ´í¬, †ê±°¤ë¥¸’ì ´í¬ˆí•¨)//20191107
 */
comLib.initForm = function($p, formId, arg) {
	// ”ë©´???€Œí•œ•ë³´€ ‘ê·¼µê³„ ˜ë¦¬
	// TODO formIdë™»ì„ ˆë„œë‹¤.
	// comLib.getPgmAuthority(formId);
	// comLib.setBtnAuthProcess(formId);
	if (arg && typeof arg == "object") {
		if (Array.isArray(arg)) {
			formId += arg[1];
		} else {
			formId += (arg["scrinNumber"] || "");
		}
	}
	comLib.setBtnAuthProcess($p, formId, arg); // 20191107

	// ”ë©´ „ì²´ µí†µ ´ë²¤˜ë¦¬
	comLib.cmmnEvt($p);

	// ”ì¸ì˜js –‰ ´ë²¤˜ë¦¬(µí†µ´ë²¤¸ì‹¤
	comLib.runCmmnEvent($p);

	if ($p.$(".w2tabcontrol").length > 0) {
		// »¨¸ë¡¤ˆì„½ìš° ¬ì‚¬´ì¦ˆ 		var tabControl = $p.getComponentById($p.$(".w2tabcontrol").attr("id"));
		if (tabControl) {
			tabControl.bind("change", function(tabId, idx) {
				if ($p.isWFramePopup()) {
					try {
						if (typeof $p.getFrame().scope.scwin.fnResize== "function") {
							//console.log("execute scwin.fnResize()");
							$p.getFrame().scope.scwin.fnResize();
						} else {
							$(window).trigger("resize");
						}
					} catch(e) {
						console.error("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: "+e);
					}
				} else {
					$(window).trigger("resize");
				}
			});
		}
	}
	if (typeof ecsLib == "object" && typeof ecsLib.initScreen =="function") {
		ecsLib.initScreen($p, formId, arg);
	}
};

/**
 * comLib.getPgmAuthority : ”ë©´ Œí•œ ˜ë¦¬ („íŠ¼ œì–´ 
 * @param formId	”ë©´ID
 */
comLib.getPgmAuthority = function($p, formId) {
	/*
	var trans = new TransClass();
	trans.svcUrl = "/sample/cmmn/authority/selectPgmAuth.do";
	trans.prgId = formId;
	trans.setParamMap("dm_search", {"pgmId":formId});
	trans.sendSynch();

	if (trans.isSuccess()) {
		// TODO „ë¡œíŠ¸ê²Œ ˜ë¦¬ ”ê
	}
	*/
	var requestData = {};
	requestData.data = {"pgmId" : formId};

	var option = {
		action : "authority/selectPgmAuth.do",
		reqData : requestData
	};
	ajaxLib.executeAjax($p, option);
};

var isDirLink = false;
/**
 * comLib.setBtnAuthProcess : ”ë©´ „íŠ¼ Œí•œ ˜ë¦¬
 * °íšŒ(Q), ?€??S),  œ(D), ‘ì(E), œë ¥(P), ¹ì¸(A), ¹ì¸¨ì†Œ(R), ?¬ìš©ì •~9
 * 1. ì—…½ì˜ „íŠ¼¤ì— ?€??userData1 ??¨ë‘ •ì˜˜ì–´ ˆì–´2020.07.07
 * 2. ´ë©”í¬  ì •¤ì¸ AccessKey ¸ì´64byte  2020.07.07
 */
comLib.setBtnAuthProcess = function($p, formId, arg) {
	var chkAuth = "";
	if (arg == null || arg == "undefined" || arg == "" || arg != "1") {
		chkAuth = "";
	} else {
		if (typeof arg == "object") {
			if (Array.isArray(arg)) {
				chkAuth = arg[0];
			} else {
				chkAuth = arg["chkAuth"];
			}
		} else {
			chkAuth = arg;
		}
	}

	var accKey = WebSquare.session.getAttribute("accessCrtfcKey");
	var strScrNm = top.window.location + "";
	isDirLink = false;
	if (strScrNm.indexOf("winPopup", 0) > -1 && accKey.length > 33) {
		// alert(strScrNm + "\r\n\r\n" + accKey.length);
		isDirLink = true;
	}
	// ì—…€ top.dmaScrinBtnAthr †ìŒ. Œí•œ ìš©˜ë ¤left.xml ˆëŠ” dmaScrinBtnAthr ???£ìœ¼  œ ˜ë¦¬˜ê³  œë°±ì„œ resBody˜ë¦¬
	// if (top.dmaScrinBtnAthr == null) {
	var requestData = { "pgmId" : formId };
	var option = {
		action : "zz/authmng/selectPgmAuth.do",
		reqData : requestData,
		resData : "",
		success : "comLib.setBtnAuthProcessCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

// ?¬ìš©”ë‰´, „íŠ¼ Œí•œ °íšŒ œë°±
comLib.setBtnAuthProcessCallback = function(resBody, $p) {
	var btnID;
	var userData;
	var arrData = new Array();
	var btnAthr = "";
	if (resBody.data) {
		btnAthr = resBody.data.btnAthrList;
	} else {
		isDirLink = false; // 2020.11.03
		return;
	}
	if (!isDirLink) {
		btnAthr += "9,"; //Navigator.xml •ì˜„íŠ¼ ì°ì´€	}
	// anchor‘ì— Œí•œ ¬ë¶„ê ˆëŠ” ¨íŠ¸¤ë§Œ ˜ë¦¬
	for (var i = 0; i < $p.$(".w2anchor2").children().prevObject.length; i++) {
		btnID = $p.$(".w2anchor2").children().prevObject[i].id;
		var obj = $p.getComponentById(btnID);
		if (obj) {
			userData = obj.getUserData("userData1");
			if (userData) {
				var jsonData = {};
				jsonData.BTN_ID = btnID;
				jsonData.USER_DATA = "," + userData + ",";
				arrData.push(jsonData);
			}
		}
	}
	for (var i = 0; i < arrData.length; i++) {
		if (btnAthr.indexOf(arrData[i].USER_DATA) != -1) {
			$p.getComponentById(arrData[i].BTN_ID).removeClass("hide");
		} else {
			$p.getComponentById(arrData[i].BTN_ID).addClass("hide"); // 2020.11.03
		}
	}
};

/**
 * comLib.selectSavedToken : SavedToken °íšŒ
 * ?€ëŠ” Œí•œ °íšŒ€ „ìš”†ëŠ” ”ë©´ì„œ Token ’ì„ °íšŒ ë•Œ ?¬ìš©
 */
comLib.selectSavedToken = function($p) {
	var requestData = {};
	var option = {
		action : "/sc/authmng/selectSavedToken.do",
		reqData : requestData,
		resData : "",
		success : "",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

/**
 * Context Path €¸ì˜¤ */
comLib.getContextPath = function() {
	return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 0));
};

/**
 * ”ì„¸€ ì—…¸ì¶œœë‹¤.
 * 
 * @date 2014. 12. 9.
 * @param {String} messageTyp 			ì—…€??(alert || confirm)
 * @param {String} message 				”ì‹œ€
 * @param {String} closeCallbackFncName œë°± ?¨ìˆ˜ * @param {Boolean} isReturnValue 		Confirm ½ì¸ ½ìš°  íƒ °ê³¼(boolean)˜í™˜ ì ?¬ë
 * @param {String} title 				ì—…€´í
 * @example
 	comLib.messageBox("alert", message, closeCallbackFncName, isReturnValue, title);
 */
comLib.messageBox = function($p, messageType, message, closeCallbackFncName, isReturnValue, title) {
	var message = message || "";
	var messageType = messageType || "alert";
	var defaultTitle = null;
	var msgClsNm = "";

	if (messageType === "alert") {
		defaultTitle = "Alert";
		msgClsNm = "header-notice";
	} else {
		defaultTitle = "Confirm";
		msgClsNm = "header-confirm";
	}

	var closeCallbackFncName = closeCallbackFncName || "";
	if (closeCallbackFncName) {
		if (typeof closeCallbackFncName !== "string" ) {
			alert("œë°±¨ìˆ˜ ˜ë¦¬¸ì´ë¡œ€?¥í•©ˆë‹¤ .");
			return;
		} else {
			if (closeCallbackFncName.indexOf("scwin.") === 0) {
				closeCallbackFncName=$p.id + closeCallbackFncName;
			}
		}
	}
	comLib.getCheckCallBackFunc(closeCallbackFncName, "comLib.messageBox"); /* œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ €ŒìŠ¤´í›„  œˆì •*/
	if (typeof isReturnValue === "undefined") {
		isReturnValue = false;
	}
	var messageBrCnt = 1;
	var width = 450;
	if (typeof message == "object" && message.length > 0) {
		// messageBrCnt = message[0].match(/<br(\s)?[/]?(\s)?[>]/gi) != null  message[0].match(/<br(\s)?[/]?(\s)?[>]/gi).length + 1 : 1;
		messageBrCnt = message[0].match(/\\n/gi) != null  message[0].match(/\\n/gi).length + 1 : 1;
		if (message[0].length > 100) {
			messageBrCnt += Math.ceil(message[0].length / 52);
			width = 750;
		}
		message[0] = message[0].replace(/\\n/gi, "<br>");
		message[0] = message[0].replace(/\n/gi, "<br>");
		message[0] = message[0].replace(/<BR>/gi, "<br>");
		messageBrCnt = comLib.messageLineCount(message[0]);
		if (messageType === "alert") {
			if (message[1] == "ERROR") {
				msgClsNm = "header-error";
			} else if (message[1] == "WARN") {
				msgClsNm = "header-warning";
			}
		}
	} else {
		// messageBrCnt = message.match(/<br(\s)?[/]?(\s)?[>]/gi) != null  message.match(/<br(\s)?[/]?(\s)?[>]/gi).length + 1 : 1;
		messageBrCnt = message.match(/\\n/gi) != null  message.match(/\\n/gi).length + 1 : 1;
		if (message.length > 100) {
			messageBrCnt += Math.ceil(message.length / 52);
			width = 750;
		}
		message = message.replace(/\\n/gi,"<br>");
		message = message.replace(/\n/gi,"<br>");
		message = message.replace(/<BR>/gi,"<br>");
		messageBrCnt = comLib.messageLineCount(message);
	}
	var options = {
		title : title || defaultTitle,
		popupParam : {
			"message" : message,
			"closeCallbackFncName" : closeCallbackFncName,
			"isReturnValue" : isReturnValue
		},
		modal : true,
		width : width, // 450,
		// height : 185 + (messageBrCnt * 19),
		height : 185 + (messageBrCnt * 25),
		className : msgClsNm
	};
	options.popupParam.closeCallbackFncName = closeCallbackFncName;
	comLib.openPopup($p, messageType, "/ui/common/message_box.xml", options);
};

comLib.messageLineCount = function(message) {
	// var str=message.replace(/\\\\n/gi, "<br>");
	// str=str.replace(/\\n/gi, "<br>");
	// str=str.replace(/<BR>/gi, "<br>");
	var lineArr = message.split("<br>");
	var lineCnt = 0;
	for (var i = 0; i < lineArr.length; i++) {
		// utilLib.getByteLength(message);
		lineCnt += Math.ceil(utilLib.getByteLength(lineArr[i]) / 60);
	}
	return lineCnt;
};

/**
 * Confirm ”ì‹œ€ ½ì„ ¸ì¶œœë‹¤.
 * 
 * @date 2014. 12. 9.
 * @param {String} message 				”ì‹œ€
 * @param {String} closeCallbackFncName œë°± ?¨ìˆ˜ * @param {String} isReturnValue 		Confirm ½ì¸ ½ìš°  íƒ °ê³¼(boolean)˜í™˜ ì ?¬ë
 * @param {String} title 				ì—…€´í
 * @example
 	comLib.confirm($p, "€½ëœ ”ë“œ ¸ë£¹ •ë³´€?¥í•˜œê² µë‹ˆ", "saveCodeGrpConfirmCallback");
 	comLib.confirm($p, "˜ìœ„ˆë¡œ°ì§”ê˜ì‹œ ìŠµˆê¹Œ", "insertConfirmCallBack", true);
 */
comLib.confirm = function($p, message, closeCallbackFncName, isReturnValue, title) {
	// comLib.messageBox($p, "confirm", message, closeCallbackFncName, isReturnValue, title);
	if (closeCallbackFncName) {
		if (typeof closeCallbackFncName === "string") {
			if (closeCallbackFncName.indexOf("scwin.") === -1) {
				try {
					var callBackFncObj = eval($p.id + "scwin." + closeCallbackFncName);
					if (typeof callBackFncObj == "function") {
						closeCallbackFncName = "scwin." + closeCallbackFncName;
					}
				} catch(e) {}
			}
		}
	}
	if ((typeof $p !== "undefined") || (typeof $p.getFrameId === "function")) {
		comLib.messageBox($p, "confirm", message, closeCallbackFncName, isReturnValue, title);
	} else {
		comLib.messageBox(window.$p.top().$p, "confirm", message, closeCallbackFncName, isReturnValue, title);
	}
};

/**
 * Alert ”ì‹œ€ ½ì„ ¸ì¶œœë‹¤.
 * 
 * @date 2014. 12. 9.
 * @param {String} message 				”ì‹œ€
 * @param {String} closeCallbackFncName œë°± ?¨ìˆ˜ * @param {String} isReturnValue 		Confirm ½ì¸ ½ìš°  íƒ °ê³¼(boolean)˜í™˜ ì ?¬ë
 * @param {String} title 				ì—…€´í
 * @example
 	comLib.confirm($p, "°í¸ˆí˜¸ íƒ˜ì‹œ”ëˆë‹¤.");
 	comLib.confirm($p, "°í¸ˆí˜¸ íƒ˜ì‹œ”ëˆë‹¤.", "alertCallBack", true);
 */
comLib.alert = function($p, message, closeCallbackFncName, isReturnValue, title) {
	if (closeCallbackFncName) {
		if (typeof closeCallbackFncName === "string") {
			if (closeCallbackFncName.indexOf("scwin.") === -1) {
				try {
					var callBackFncObj = eval($p.id + "scwin." + closeCallbackFncName);
					if (typeof callBackFncObj == "function") {
						closeCallbackFncName = "scwin." + closeCallbackFncName;
					}
				} catch(e) {}
			}
		}
	}
	if ((typeof $p !== "undefined") || (typeof $p.getFrameId === "function")) {
		comLib.messageBox($p, "alert", message, closeCallbackFncName, isReturnValue, title);
	} else {
		comLib.messageBox(window.$p.top().$p, "alert", message, closeCallbackFncName, isReturnValue, title);
	}
};

/**
 * ì—… ¸ì¶œ „ì‹œ ¸ì¦œê¸‰
 * 
 * @param url : ì—… ¸ì¶œ URL
 * @param callerLoginYn : €¨ì°½¸ì…˜¼ë¡œ œê·¸¬ë
 */
comLib.getAccessCrtfcKey = function($p, url, callerLoginYn) {
	var daonPopupUrls = new Array();
	for (var key in comLib) {
		// POP_URL •ì˜ª©?€ DAON ì—…¼ë¡œ ´ì
		if (key.indexOf("POP_URL") >= 0) {
			daonPopupUrls.push(comLib[key]);
		}
	}

	var requestData = {};
	requestData.popupUrl = url;
	requestData.daonPopupUrls = daonPopupUrls;
	// €¨ì°½œìŠ¤œìœ¼œê·¸˜ë¦¬ƒì¸ €???€Œë˜	if (callerLoginYn != undefined && callerLoginYn == "N") {
		requestData.callerLoginYn = "N";
	} else {
		requestData.callerLoginYn = "Y";
	}

	var option = {
		action : "/sc/accessCrtfc/createNewKey.do",
		reqData : requestData,
		mode : "synchronous",
		isShowMeg : false
	};

	var accessCrtfcData = ajaxLib.executeAjax($p, option);

	return accessCrtfcData.data.accessCrtfcKey;
};

/**
 * ì—…½ì„ ?«ëŠ”
 * 
 * @date 2014. 12. 9.
 * @param {String} popupId 		”ë©´???«ì„ ì—… ˆë„„ì´ * @param {String} callBackFnc 	œë°± ?¨ìˆ˜ ´ë¦„
 * @param {Object} rtnObj 		˜í™˜ì²´ (JSON or XML)
 * @example
 	comLib.closePopup(WebSquare.net.getParameter( "popupID" ), "setData", jsonObj);
 */
comLib.closePopup = function($p, popupId, callBackFnc, rtnObj) {
	if (callBackFnc) {
		if (typeof callBackFnc === "string") {
			if (callBackFnc.indexOf("scwin.") === 0) {
				callBackFnc = $p.id + callBackFnc;
			}
			comLib.getCheckCallBackFunc(callBackFnc, "comLib.closePopup"); // TODO œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ €ŒìŠ¤´í›„  œˆì •
			eval(callBackFnc)(rtnObj);
		} else if (typeof callBackFnc === "function") {
			callBackFnc(rtnObj);
		}
	}
	if ($p.top().wfm_left) {
		if ($p.top().wfm_left.getWindow().trvMenu) {
			$p.top().wfm_left.getWindow().trvMenu.removeClass("disableWin");
		}
	}
	$p.closePopup(popupId);
};

/**
 * ì—…½ì„ °ë‹¤.
 * 
 * @date 2014. 12. 9.
 * @param {String} id 		Popup?id
 * @param {String} url 		”ë©´½ë¡œ
 * @param {Object} options 	PopupŒë¼¸í„° Object
 * @example
 	comLib.openPopup($p, "alert", "/template/common/xml/zzAlertPop.xml", options);
 	comLib.openPopup($p, "SCMSC30000011", "/openOthrSysScrn.do?targetSystem=dscm&screenId=/scm/sc/athrmng/SCMSC30000011.xml", options); ADD 2020.02.10 60003867
 */
comLib.openPopup = function($p, id, url, options) {
	var width = options.width || "400";
	var height = options.height || "400";
	var left = options.left || -1;
	var top = options.top || -1;

	if (options.type =="window") {
		left = Math.floor((window.innerWidth - width) / 2);
		top = Math.floor((window.innerHeight - height) / 2);
	} else {
		if (left > 0) {
			left = left + (window.pageXOffset);
			// left = left + (self.screenLeft || window.screenX);
		} else {
			left = Math.floor((document.body.clientWidth - width) / 2);
			// left = Math.floor((document.body.clientWidth - width) / 2);
		}
		if (top > 0) {
			top = top + (window.pageYOffset);
			// top = top + (self.screenTop || window.screenY);
		} else {
			if (id == "alert" || id == "confirm"){
				if (pageYOffset == 0){
					top = Math.floor((innerHeight - height) / 2);
				}else{
					top = Math.floor((innerHeight - height) / 2 + pageYOffset);
				}
			} else {
				if (pageYOffset == 0) {
					top = Math.floor((innerHeight - height) / 2);
				} else {
					top = Math.floor((innerHeight - height) / 2 + pageYOffset);
				}
				// top = Math.floor((pageYOffset - screenTop));
				var trvMenu = parent.document.querySelector("#trvMenu");
				if (trvMenu != null) {
					// trvMenu.classList.add("disableWin");
				}
			}
		}
	}
	if (options.popupParam) {
		var closeCallbackFncName = options.popupParam.closeCallbackFncName || "";
		if (closeCallbackFncName) {
			if (typeof closeCallbackFncName === "string") {
				if (closeCallbackFncName.indexOf("scwin") === 0) {
					options.popupParam.closeCallbackFncName = $p.id + closeCallbackFncName;
				}
			}
		}
	}
	var className = options.className || "";

	if (!utilLib.isNull(className)) {
		id = id + comLib.POPUP_UID++;
	}

	if (url.indexOf("http://") >= 0 || url.indexOf("https://") >= 0) {
		var accessCrtfcKey = comLib.getAccessCrtfcKey($p, url, options.callerLoginYn);
		if (url.indexOf("?") >= 0) {
			url += "&accessCrtfcKey=" + accessCrtfcKey;
		} else {
			url += "?accessCrtfcKey=" + accessCrtfcKey;
		}

		options.popupUrl = url;
	}

	requires("uiplugin.popup");

	// 20200210 ADD …ë¬´œìŠ¤œì—´ì•ˆœì•½”ë©´í¬€¸ë‹¤ °ê¸° „í•´jumpSso.jsp °ëŠ¥¬ìš© 60003867
	// var popupUrl = "";
	if (url.indexOf("openOthrSysScrn.do") > 0) {
		options.popupUrl = url;
	}

	var options = {
		id : id,
		type : options.type || "wframePopup", // window, wframePopup
		width : width, // + "px",
		height : height, // + "px",
		top : top, // useIframe??true½ìš° Œë¼°ì ¸°ì false½ìš° ¨ë‹ˆ°ë °ì¼ë¡œ œë‹¤.
		left : left,
		popupName : options.title || "", // useIframe : true??popup ì²´´ë¦„¼ë¡œ popup „ë ˆ„ì˜ œì‹œ„ì— ˜í©ë‹ˆ
		modal : options.modal || false, // modal´ìš©´ì„œ °ê²½™ì‘˜ì Šë„Œë“¤„í•œ ¸ì …ë‹ˆ false´ë©´ ¤ìª½´í¼ŒíŠ¸€ ?¬ìš© €?¥í•©ˆë‹¤.
		useIFrame : options.useIFrame || false,// true : IFrame ???¬ìš©˜ëŠ” WebSquare popup / false: window.open ???¬ìš©˜ëŠ” popup
		className : className, // userIFrame: true ¤ì •ì—…”ì¸ì„ €½í•˜„í•œ class.
		closeAction : options.closeAction || "", // useIFrame:true ¤ì •«ê¸° „íŠ¼´ë¦­ ½ìš° ì—…«ê¸°¸ì¶œ¬ìš©•ì˜ funcion ´ë¦„. ?¬ìš©ì •¨ìˆ˜ ì„œ return true;ì—…«ëŠ”
		style : "", // popup??¼ì„ €•í•©ˆë‹¤. ’ì´ ˆìœ¼left top width heightìš©˜ì ŠìŠµˆë‹¤.
		resizable : options.resizable || false,
		status : false,
		menubar : false,
		scrollbars : options.scrollbars || false,
		title : options.title || false,
		useControl : options.useControl || false, // ?¬ìš©•ì˜ „íŠ¼ œì–´
		useMaximize : options.useMaximize || false, // true ½ìš° title ”ë¸”´ë¦­œë		controls : options.controls || {}, // { minimize : true, maximize : false, close : true }, // useControl : true ½ìš° œì†Œ œë ?«ê¸° „íŠ¼ ´ì´		foldSize : options.foldSize || {}, //
		foldOnMinimized : options.foldOnMinimized || false, // useControl : true ½ìš° œì†Œ„íŠ¼ ´ë¦­”ë©´ ”ë”” ì—­ ‘ê¸°/¼ì¹˜		xml : utilLib.serialize(options.popupParam) || "", // popup˜ê¸¸ xmlDocument??string popup½ì—WebSquare.uiplugin.popup.getPopupParam() api??¬ìš©˜ì—¬ €¸ì˜¬ˆìŠµˆë‹¤.
		popupUrl : options.popupUrl || "", //
		// alwaysOnTop : options.alwaysOnTop || false, //
		alwaysOnTop : options.alwaysOnTop || true, // °ë³¸’ì´true ´ê³  ƒ œìƒ„ì— ì—…´ë ¤ëŠ”false?€½í•œ€ ´í•´€ Šë¨ œã…œ €½í•¨
		// popupUrl : popupUrl, 	//20200210 ADD …ë¬´œìŠ¤œì—´ì•ˆœì•½”ë©´í¬€¸ë‹¤ °ê¸° „í•´jumpSso.jsp °ëŠ¥¬ìš© 60003867
		// popupUrl : "winPopup.jsp" + "?w2xPath=" + url,
		srcData : "", // popup ì²´type ??window ????Parent ì„œ ˜ê¸¸ xpath
		destData : "" // popup ì²´type ??window ????popup  •xpath
	};
	try {
		if (utilLib.isNull(options.popupUrl)) {
			$p.openPopup(ajaxLib.CONTEXT_PATH + url, options);
		} else {
			$p.openPopup("", options);
		}
	} catch(e) {
		$p.log("[comLib.openPopup] Exception :: " + e.message);
	} finally {
		options = null;
	}
};

/**
 * window.open ì—…½ì„ Get ©ì‹¼ë¡œ ¸ì¶œœë‹¤.
 * 
 * @date 2014. 12. 9.
 * @param {String} url 		”ë©´½ë¡œ
 * @param {Object} option 	PopupŒë¼¸í„° Object
 * @param {String} param1 	[ íƒ] µí†µ ì—…ì„œ ?¬ìš©˜ëŠ” Œë¼¸í„° •ì˜
 * @example
 	var option = {
 		popupID : "popupSearchHelp",
 		width : 800,
 		height : 600,
 		title : "test"
 	};
 	var jsonObj = {
 		userInfo : comLib.getUserInfo4Param(strEnc, "Search Help");
 		, rfcNm : iptRfcNm.getValue()
 		, ivF4Case : iptIvF4Case.getValue()
 		, isFieldNm1 : "CARRID"
 		, isFieldVal1 : "AF"
 		, isFieldNm2 : "CARRNAME"
 		, isFieldVal2 : "Air*"
 	};
 	openGetWinPopup("/template/common/xml/zzAlertPop.xml", option, jsonObj);
 */
comLib.openGetWinPopup = function($p, url, option, jsonObj) {
	var strOption = "";
	var strUserInfo = "";
	var strParam2 = "";

	// option.popupID „ìˆ˜
	if (utilLib.safeString(option.popupID) == "") {
		alert("popupID „ìˆ˜ ’ì…ˆë‹¤.");
		return;
	}

	// option to ampersand format string
	for (var obj in option) {
		strOption = strOption + obj + "=" + option[obj] + ",";
	}

	var strEnc = "";
	strUserInfo = comLib.getUserInfo4Str(strEnc, option.title);
	// console.log("strUserInfo="+strUserInfo);

	var strParam = "";
	// for (var i = 2; i <= Object.keys(jsonObj).length; i++) {
		var param = "";

		// DAON ¼ë¡œì—…¸ì¦¤ë ›ì•„Œë¼¸í„°¬í•¨.
		jsonObj.accessCrtfcKey = comLib.getAccessCrtfcKey($p, url, option.callerLoginYn);
		if (jsonObj.closeCallbackFncName) {
			if (typeof jsonObj.closeCallbackFncName === "string") {
				if (jsonObj.closeCallbackFncName.indexOf("scwin.") === 0) {
					jsonObj.closeCallbackFncName = $p.id + jsonObj.closeCallbackFncName;
				}
			} else {
				alert("œë°±¨ìˆ˜ ˜ë¦¬¸ì´ë¡œ€?¥í•©ˆë‹¤.");
			}
		}
		for (var key in jsonObj) {
			if (jsonObj.hasOwnProperty(key)) {
				// console.log("key=" + key);
				// console.log("type=" + typeof jsonObj[key]);
				// console.log("data=" + JSON.stringify(jsonObj[key]));
				if (typeof jsonObj[key] == "object"){
				// if (key == "userInfo") {
					for (var key2 in jsonObj[key]) {
						// console.log("key2=" + key2);
						// console.log("data2=" + JSON.stringify(jsonObj[key][key2]));
						param = param + "&" + key2 + "=" + jsonObj[key][key2];
					}
				} else {
					// param = param + "&" + option.popupID + "_" + key + "=" + jsonObj[key];
					param = param + "&" + key + "=" + jsonObj[key];
				}

				strParam = strParam + param;
				param = "";
			}
		}
	// }
	// alert("strParam="+strParam);
	var popupID = option.popupID || "popupID01";
	var setTop = option.setTop;
	var setLeft = option.setLeft;
	var width = option.width || 800;
	var height = option.height || 600;
	// ì—… °ë³¸ Œí‘œ, ¸ì”ë©´ ?¬ê¸° ë ¤˜ì—¬ °ë³¸„ì‚°
	var top  = !setTop  screen.availHeight / 2 - (height / 2) - 20 : setTop;
	var left = !setLeft  screen.availWidth / 2 - (width  / 2) : setLeft;

	if (comLib.windowObjRef == null || comLib.windowObjRef.closed || comLib.windowObjRef.popupId != popupID) {
		// var encData = encodeURI(url+strUserInfo+strParam);
		var encData = encodeURI(url + strParam);
		comLib.windowObjRef = window.open(encData, popupID, "location=no,width=" + width + ",height=" + height + ",scrollbars=yes,top=" + top + ",left=" + left + ",resizable=no");
	}
	comLib.windowObjRef.focus();
	comLib.windowObjRef.opener = self;
};

/**
 * window.open ì—…½ì„ POST ©ì‹¼ë¡œ ¸ì¶œœë‹¤.
 * 
 * @date 2014. 12. 9.
 * @param {String} url 		”ë©´½ë¡œ
 * @param {Object} option 	PopupŒë¼¸í„° Object
 * @param {Object} jsonObj 	PopupŒë¼¸í„° Object
 * @example
 	var option = {
 		popupID : "popupSearchHelp",
 		width : 800,
 		height : 600,
 		title : "test"
 	};
 	var jsonObj = {
 		userInfo : comLib.getUserInfo4Param(strEnc, "Search Help");,
 		rfcNm : iptRfcNm.getValue(),
 		ivF4Case : iptIvF4Case.getValue(),
 		isFieldNm1 : "CARRID",
 		isFieldVal1 : "AF",
 		isFieldNm2 : "CARRNAME",
 		isFieldVal2 : "Air*"
 	};
 	openPostWinPopup("/template/common/xml/zzAlertPop.xml", option, jsonObj);
 */
comLib.openPostWinPopup = function($p, url, option, jsonObj) {
	var strOption = "";
	var strParam1 = "";
	var strParam2 = "";

	// option jsonObj to ampersand format string
	for (var obj in option) {
		strOption = strOption + obj + "=" + option[obj] + ",";
	}

	var popupID = option.popupID || "popupID01";
	var setTop = option.setTop;
	var setLeft = option.setLeft;
	var width = option.width || 800;
	var height = option.height || 600;
	// ì—… °ë³¸ Œí‘œ, ¸ì”ë©´ ?¬ê¸° ë ¤˜ì—¬ °ë³¸„ì‚°
	var top  = !setTop  screen.availHeight / 2 - (height / 2) - 20 : setTop;
	var left = !setLeft  screen.availWidth / 2 - (width  / 2) : setLeft;

	// DAON ¼ë¡œì—…¸ì¦¤ë ›ì•„Œë¼¸í„°¬í•¨.
	jsonObj.accessCrtfcKey = comLib.getAccessCrtfcKey($p, url, option.callerLoginYn);
	if (jsonObj.closeCallbackFncName) {
		if (typeof jsonObj.closeCallbackFncName === "string") {
			if (jsonObj.closeCallbackFncName.indexOf("scwin.") === 0) {
				jsonObj.closeCallbackFncName =$p.id+jsonObj.closeCallbackFncName;
			}
		} else {
			alert("œë°±¨ìˆ˜ ˜ë¦¬¸ì´ë¡œ€?¥í•©ˆë‹¤ .");
		}
	}
	// ì—… ¸ì¶œ
	if (comLib.windowObjRef == null || comLib.windowObjRef.closed || comLib.windowObjRef.popupId != popupID) {
		comLib.windowObjRef = window.open("", popupID, "location=no,width=" + width + ",height=" + height + ",modal=yes,scrollbars=yes,top=" + top + ",left=" + left + ",resizable=no");
	}
	comLib.windowObjRef.focus();
	comLib.windowObjRef.opener = self;

	comLib.submitJSON(url, jsonObj, popupID);

	return false;
};

comLib.setWindowTitle = function(windowObjRef) {
	if (windowObjRef.document) {
		windowObjRef.document.title = "abcd";
	} else {
		setTimeout(comLib.setWindowTitle, 200);
	}
};

/**
 * WindowContainer íƒœ ”ì‹œ€
 * 
 * @date 2017. 07. 31.
 * @param <String> msg íƒœ ”ì‹œ€
 * @example
 */
comLib.setWindowStatusMsg = function(msg) {
	if (utilLib.isNull(top.wdcMain)) {
		return;
	}
	top.wdcMain.setWindowStatusMsg(msg);
};

/**
 * POST ©ì‹¼ë¡œ JSON °ì´°ë ˆë¡œ˜ì´€?submit
 * 
 * @date 2017. 07. 31.
 * @param <String>  path 		ˆë¡œ˜ì´€„í•œ URL ½ë¡œ
 * @param <Object> jsonObj 		JSON Data
 * @param <String> targetObj 	form„ë‹¬target
 * @example
 */
comLib.submitJSON = function(path, jsonObj, targetObj) {
	// form ì„±
	var form = document.createElement("form");
	form.setAttribute("id", "__form");
	form.setAttribute("method", "post");
	form.setAttribute("action", path);
	form.setAttribute("target", targetObj);

	// JSON???¬í•¨˜ëŠ” hidden input ì„± ??form ”ê
	for (var key in jsonObj) {
		var hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", key);
		hiddenField.setAttribute("value", jsonObj[key]);
		form.appendChild(hiddenField);
	}

	// body ”ê ?submit
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);
	comLib.windowObjRef.focus();
};

/**
 * „ì¬ ”ë©´ì—…¸ì „ë‹Œ€ ?¬ë ë‹¨œë‹¤.
 * 
 * @date 2014. 12. 9.
 * @example
 	var isPopup = comLib.isPopup();
 */
comLib.isPopup = function() {
	try {
		if (typeof window.opener == "undefined") {
			return false;
		} else if (window.opener.closed) {
			return false;
		} else {
			return true;
		}
	} catch (e) {
		$w.log("[comLib.isPopup] Exception :: " + e.message);
		return  false;
	}
};

/**
 * Array Object •ì¸œë‹¤.
 * 
 * @date 2014. 12. 9.
 * @param <Object> Object Array Object
 * @returns {Boolean}
 * @example
 	var isArray = comLib.isArrayObj(arrObj);
 */
comLib.isArrayObj = function(targetObj) {
	if (typeof targetObj != "undefined" && typeof targetObj == "object") {
		if (targetObj.constructor.name && targetObj.constructor.name.toLowerCase() == "array") {
			return true;
		}
		if (targetObj.constructor && targetObj.constructor === Array) {
			return true;
		}
	}
	return false;
};

/**
 *  í‚¤ ’ì„ ‹íŒ…œë‹¤.
 * 
 * @date 2014. 12. 10.
 * @param <String> name  í‚¤  * @param <String> value  í‚¤  * @param <Number> ?€?¥í•  °ê°„ (
 * @example
 	comLib.setCookie("userid", "done", 7)
 */
comLib.setCookie = function(name, value, expiredays) {
	var today = new Date();
	today.setDate(today.getDate() + expiredays);
	document.cookie = name + "=" + escape(value) + "; path=/; expires=" + today.toGMTString() + ";";
};

/**
 * ‹íŒ… í‚¤ ’ì„ €¸ì˜¨
 * 
 * @date 2014. 12. 10.
 * @param <String> name 	 í‚¤  * @param <String> value 	 í‚¤  * @return <String>  í‚¤ …ì— ´ë‹¹˜ëŠ”  í‚¤ ?€¸ì˜¨
 * @example
 	var ret = comLib.getCookie("userid");
 */
comLib.getCookie = function(name) {
	var cook = document.cookie + ";";
	var idx = cook.indexOf(name, 0);
	var val = "";
	if (idx != -1) {
		cook = cook.substring(idx, cook.length);
		begin = cook.indexOf("=", 0) + 1;
		end = cook.indexOf(";", begin);
		val = unescape(cook.substring(begin, end));
	}
	return val;
};

/**
 * ˆì°½„ìš¸´ìƒ„ì— ì¶° œë¬ê¸°½ì˜ ?¬ê¸°°ì •œë‹¤.
 * 
 * @date 2014. 12. 10.
 * @example
 	comLib.setPageFull()
 */
comLib.setPageFull = function() {
	top.window.moveTo(0, 0);
	if (document.all) {
		top.window.resizeTo(screen.availWidth, screen.availHeight);
	} else if (document.layer || document.getElementById) {
		if (top.window.outerHeight < screen.availHieght || top.window.outerWidth < screen.availWidth) {
			top.window.outerHeight = screen.availHieght;
			top.window.outerWidth = screen.availWidth;
		}
	}
};

/**
 * ˆì°½„ìš¸´ìƒ„ì— ì¶° œë¬ê¸°½ì˜ ?¬ê¸°°ì •œë‹¤. (°ì : 1280*1024)
 * 
 * @date 2014. 12. 10.
 * @example
 	comLib.setPageFull2()
 */
comLib.setPageFull2 = function() {
	// 1280*1024 °ì¼ë¡œ „ìš°	var sWidth = screen.availWidth;
	var sHeight = screen.availHeight;
	if (sWidth > 1280) {
		sWidth = 1280;
	}
	if (sHeight > 1024) {
		sHeight = 1024;
	}
	top.window.moveTo(0, 0);
	if (document.all) {
		top.window.resizeTo(sWidth, sHeight);
	} else if (document.layer || document.getElementById) {
		if (top.window.outerHeight < sHeight || top.window.outerWidth < sWidth) {
			top.window.outerHeight = sHeight;
			top.window.outerWidth = sWidth;
		}
	}
};

/**
 * ì²´´ë¦¬´í•œ
 * 
 * @date 2014. 12. 10.
 * @param <Object> ´ë¦¬???€??¸ŒíŠ¸
 * @example
 	comLib.setPageFull2()
 */
comLib.clearObject = function(object) {
	for (var key in object) {
		object[key] = null;
	}
	object = null;
};

/**
 * ì²´onclick, onkeyup ´ë²¤œìƒ  –‰¨ìˆ˜”ì¸©í•œ
 * 
 * @date 2014. 12. 10.
 * @param <String> eventName 	´ë²¤´ë¦„ (onclick, onkeyup)
 * @param <String> objPrefix 	objArr™ëŠ” object prefix
 * @param <Object> btnArr 		„íŠ¼ ì²´ °ì—´ ("´ë²¤, ["„íŠ¼ „ì´", "„íŠ¼ „ì´"])
 * @param <Object> objFunc 		?¨ìˆ˜ ì²´ ëŠ” °ì—´
 * @example
 	comLib.bindEventForObject("onclick", "btn_", ["InsertCode", "DeleteCode", "SaveCode", "CancelCode", "ExcelCode"]);
 	comLib.bindEventForObject("onkeyup", "grd_", ["CodeGrp"], ["changeGridView"]);

 	// 1. „íŠ¼ ë™ ”ì¸©ì„ „í•´œëŠ” „íŠ¼¼ë¡œ ?¬ìš©´í¬ŒíŠ¸ ID?"btn_" + "„íŠ¼ „ì´•ì˜´ì•¼ œë‹¤.
 	// btn_InsertCodeGrp, btn_DeleteCodeGrp
 	// 2. „íŠ¼onClick ´ë²¤¸ì— ”ì¸©í•  ?¨ìˆ˜ ´ë¦„"scwin." + "„íŠ¼ „ì´•ì˜´ì•¼ œë‹¤.
 	// scwin.insertCode, scwin.deleteCode
 */
comLib.bindEventForObject = function($p, eventName, objPrefix, objArr, objFunc) {
	for (var i = 0; i < objArr.length; i++) {
		try {
			var comObject = null;
			if (typeof objArr[i] === "string") {
				comObject = $p.getComponentById(objPrefix + utilLib.firstUpperCase(objArr[i]));
				if (typeof comObject === "undefined") {
					$w.log("[comLib.bindEventForObject] ”ì¸©í• " + objArr[i] + " ì²´¾ì„ †ìŠµˆë‹¤.");
					continue;
				}
			}

			if (typeof comObject !== "undefined") {
				var funcName = null;
				if (typeof objFunc === "undefined") {
					funcName = utilLib.firstLowerCase(objArr[i]);
				} else {
					if (typeof objFunc === "string") {
						funcName = utilLib.firstLowerCase(objFunc);
					} else {
						funcName = utilLib.firstLowerCase(objFunc[i]);
					}
				}

				if (typeof comLib.getScwin($p)[funcName] === "function") {
					comObject.setUserData(eventName + "Func", funcName);
					comObject.bind(eventName, function(e) {
						var eventFuncName = this.getUserData(eventName + "Func");
						var eventfunc = comLib.getScwin($p)[eventFuncName];
						if (typeof eventfunc === "function") {
							eventfunc(e);
						} else {
							$w.log("[comLib.bindEventForObject] " + eventFuncName + " ?¨ìˆ˜¾ì„ †ìŠµˆë‹¤.");
						}
					});
				} else {
					$w.log("[comLib.bindEventForObject] ”ì¸©í•  " + funcName + " ?¨ìˆ˜¾ì„ †ìŠµˆë‹¤.");
				}
			}
		} catch(e) {
			$w.log("[comLib.bindEventForObject] Exception :: " + e.message);
		} finally {
			comObject = null;
		}
	}
};

/**
 * ¸ë£¹ ˆì— ì²´onclick, onkeyup ´ë²¤œìƒ  –‰¨ìˆ˜”ì¸©í•œ
 * 
 * @date 2014. 12. 10.
 * @param <String> eventName 	´ë²¤´ë¦„ (onclick, onkeyup)
 * @param <Object> grpObj 		¸ë£¹ ì²´
 * @param <Object> objFunc 		?¨ìˆ˜ ì²´ ëŠ” °ì—´
 * @example
 	comLib.bindEventForGroup($p, "onkeyup", grp_AuthorityDetail, "changeGrpAuthority");
 */
comLib.bindEventForGroup = function(eventName, grpObj, objFunc) {
	var $p = grpObj.getScopeWindow().$p;

	var objArr = WebSquare.util.getChildren(grpObj, {
		excludePlugin : "group trigger textbox output calendar image span",
		recursive : true
	});
	comLib.bindEventForObject($p, eventName, "", objArr, objFunc);
};

/**
 * ´ë‹¹ ¸ë£¹ ˆì˜ ´í¬ŒíŠ¸ì„œ ”í„°¤ê œìƒ˜ë©´ ´ë‹¹ ´í¬ŒíŠ¸’ì„ DataColletion???€?¥í•˜objFunc ?¨ìˆ˜¤í–‰œë‹¤.
 * 
 * @date 2014. 12. 10.
 * @param <Object> grpObj 		¸ë£¹ ì²´
 * @param <Object> objFunc 		?¨ìˆ˜ ì²´
 * @param <Number> rowIndex 	DataList½ìš° „ì¬ ?¬ì»¤¤ëœ DataList??focusedRowIndex (ex. gridView1.getFocusedRowIndex())
 *	DataMap½ìš°ëŠ” rowIndexëµ˜ë©´  * @example
 	comLib.setEnterKeyEvent(grp_AuthorityDetail, scwin.search);
 	comLib.setEnterKeyEvent(grp_AuthorityDetail, scwin.search, gridView1.getFocusedRowIndex());
 */
comLib.setEnterKeyEvent = function(grpObj, objFunc, rowIndex) {
	var $p = grpObj.getScopeWindow().$p;

	var objArr = WebSquare.util.getChildren(grpObj, {
		excludePlugin : "group trigger textbox output calendar image span",
		recursive : true
	});

	try {
		for (var i = 0; i < objArr.length; i++) {
			try {
				if (typeof objFunc === "function") {
					objArr[i].bind("onkeyup", function(e) {
						if (e.keyCode === 13) {
							if (typeof this.getRef === "function") {
								var ref = this.getRef();
								var refArray = ref.substring(5).split(".");
								if ((typeof refArray !== "undefined") && (refArray.length === 2)) {
									var dataCollectionName = refArray[0];
									var columnId = refArray[1];
									var dataCollection = $p.getComponentById(dataCollectionName);
									var dataType = dataCollection.getObjectType().toLowerCase();
									if (dataType === "datamap") {
										dataCollection.set(columnId, this.getValue());
									} else if ((dataType === "datalist") && (typeof rowIndex !== "undefined")) {
										dataCollection.setCellData(rowIndex, columnId, this.getValue());
									}
								}
								objFunc();
							}
						}
					});
				}
			} catch(e) {
				$w.log("[comLib.setEnterKeyEvent] Exception :: " + e.message);
			} finally {
				dataCollection = null;
			}
		}
	} catch(e) {
		$w.log("[comLib.setEnterKeyEvent] Exception :: " + e.message);
	} finally {
		objArr = null;
	}
};

/**
 * ¸ì…˜•ë³´°íšŒœë‹¤.
 * 
 * @date 2014. 12. 10.
 * @example
 	var sessionInfo = comLib.getSessionInfo();
 */
comLib.getSessionInfo = function() {
	var $p = $p.top().$p;

	var option = {
		action : "serviceId=CM0001&action=IN",
		mode : "synchronous"
	};
	var result = ajaxLib.executeAjax($p, option);

	var obj = JSON.parse(result);
	return obj;
};

/**
 * ¨ëŒì¼ ¤ìš´œë“œ
 * (kw_framework-1.1.1-181010.jar ´ìƒ, scm-1.1.1-181010.jar ´ìƒ)
 * 
 * @param <String> url 				¤ìš´œë“œ .do URL
 * @param <String/Object> xmlValue 	¤ìš´œë“œ Œë¼¸í„° JsonString ëŠ” JsonObject
 * @param <String> method 			get ëŠ” post
 * @param <String> processMsg 		¤ìš´œë“œ”ì‹œ€
 * @param <String> callback 		¤ìš´œë“œ €„ë£Œcallback function
 * @example
 	$w.download ?comLib.downloadAtchfl”ê¿”¬ìš©. Œë¼¸í„°¸ë */
comLib.downloadAtchfl = function(url, xmlValue, method, processMsg, callback) {
	// œë°± function Name ¸íŒ…
	var callbackFunc = "top.WebSquare.layer.hideProcessMessage()";
	if (callback != undefined && callback != null && callback != "") {
		callbackFunc = callback;
	}

	// JsonObject •ë¦¬ : °ì¡´ëŠ” xmlValue?string¼ë¡œ ?€´ì„œ ˜ê²¼€ Object¸ëƒ¥ ˜ê²¨¬ê¸°˜ë¦¬ €	var atchObj;
	if (typeof xmlValue == "object") {
		atchObj = xmlValue;
	} else {
		if (xmlValue != null && xmlValue != "") {
			atchObj = JSON.parse(xmlValue);
		} else {
			atchObj = {};
		}
	}

	// JsonObjectœë°± function ¸íŒ…
	if (atchObj.length) {
		for (var i = 0 ; i < atchObj.length ; i++) {
			atchObj[i].onReadyCallbackFunc = callbackFunc;
		}
	} else {
		atchObj.onReadyCallbackFunc = callbackFunc;
	}

	// Œì¼ ¤ìš´œë“œ œì‘
	var atchStr = JSON.stringify(atchObj);
	$w.download(url, atchStr, method);

	// ”ì‹œ€ œë ¥
	if (xmlValue != null && xmlValue != "") {
		if (processMsg != undefined && processMsg != null && processMsg != "") {
			try {
				top.WebSquare.layer.showProcessMessage(processMsg);
			} catch (e) {
			}
		} else {
			try {
				top.WebSquare.layer.showProcessMessage("Œì¼ ¤ìš´œë“œ €„ì¤‘…ë‹ˆ");
			} catch (e) {
			}
		}
	}

	// Œì¼¤ìš´œë“œ ˜ë¦¬€ „ë£ŒŒê¹Œ€ ?€??€´ë¨¸:1˜ë©´ œë²„½ì—ì„± í‚¤ •ë³´´í¬ (2019-12-27 µí†µ€ add...)
	comLib.fileDwldTimer = setInterval(function() {
		var fileDownloadToken = comLib.getCookie(comLib.FILE_DWLD_TOKEN);
		// œë²„½ì—ì„± í‚¤ •ë³´€ ½í€ ¤ìš´œë“œ”ì‹œ€?OFFœë‹¤. (2019-12-27 µí†µ€ add...)
		if (fileDownloadToken == comLib.FILE_DWLD_STATUS_COMPLETE) {
			comLib.fileDwldProcMsgOff();
		}
	}, 1000);
};

/**
 * GridView°ì´°ë ‘ì Œì¼¤ìš´œë“œœë‹¤.
 * 
 * @date 2014. 12. 10.
 * @param <Object> grdViewObj 		‘ì Œì¼¤ìš´œë“œ ›ì„ GridView ì²´
 * @param <Object> options 			JSON•íƒœ€?¥ëœ ¸ë¦¬œì˜ ‘ì ¤ìš´œë“œ µì…˜
 * | options.fileName 				: [defalut: excel.xls] ¤ìš´œë“œ˜ë ¤Œì¼´ë¦„
 * | options.sheetName 				: [defalut: sheet] excel??sheet´ë¦„
 * | options.type 					: [defalut: 0] type??0½ìš° ¤ì œ °ì´1½ìš° ˆì— ´ì´°ì´°ë  2´ë©´ ¤ì–´€ ˆëŠ” data ¸ëfilter´ì‹œ expression ?€…ì˜ ?€?€ ˜ì˜¤€ ŠìŒ)
 * | options.removeColumns 			: [defalut: †ìŒ] ¤ìš´œë“œexcelì„œ  œ˜ë ¤´ì˜ ˆí˜¸(?¬ëŸ¬ œì¼ ½ìš° ,?¬ë¶„)
 * | options.removeHeaderRows 		: [defalut: †ìŒ] ¤ìš´œë“œexcelì„œ  œ˜ë ¤Header??row index(?¬ëŸ¬ œì¼ ½ìš° ,?¬ë¶„)
 * | options.foldColumns 			: [defalut: †ìŒ] ¤ìš´œë“œexcelì„œ fold˜ë ¤´ì˜ ˆí˜¸(?¬ëŸ¬ œì¼ ½ìš° ,?¬ë¶„)
 * | options.startRowIndex 			: [defalut: 0] excelŒì¼ì„œ ¸ë¦¬œì˜ °ì´°ê œì‘˜ëŠ” ‰ì˜ ˆí˜¸(” ?¬í•¨)
 * | options.startColumnIndex 		: [defalut: 0] excelŒì¼ì„œ ¸ë¦¬œì˜ °ì´°ê œì‘˜ëŠ” ´ì˜ ˆí˜¸(” ?¬í•¨)
 * | options.headerColor 			: [defalut: #33CCCC] excelŒì¼ì„œ ¸ë¦¬œì˜ header€„ì˜  * | options.bodyColor 				: [defalut: #FFFFFF] excelŒì¼ì„œ ¸ë¦¬œì˜ body€„ì˜  * | options.subTotalColor 			: [defalut: #CCFFCC] excelŒì¼ì„œ ¸ë¦¬œì˜ subtotal€„ì˜  * | options.footerColor 			: [defalut: #008000] excelŒì¼ì„œ ¸ë¦¬œì˜ footer€„ì˜  * | options.showProcess 			: [defalut: true] ¤ìš´œë“œ „ë¡œ¸ìŠ¤ ½ì„ ´ì—¬„ì ?¬ë
 * | options.massStorage 			: [defalut: true] ?€?©ëŸ‰ ¤ìš´œë“œ ?¬ë (default??true µì…˜true˜ê³  showConfirm??false½ìš°IEì„œ  ë¢° ë§Œ¬ì´¸ë ´í¬˜ëŠ” µì…˜¬ë‹¤.)
 * | options.showConfirm 			: [defalut: false] ¤ìš´œë“œ •ì¸½ì„ „ìš¸€ ?¬ë?(µì…˜½ìš° advancedExcelDownload¸ì¶œ¬ìš©ê window„íŠ¼œë²ˆ´ë¦­´ì•¼ œë‹¤. massStorageë™¼ë¡œ true€ œë‹¤)
 * | options.dataProvider 			: [defalut: †ìŒ] ?€‰ë°´í„° ˜ë¦¬ ??¬ìš©°ì´°ë €µí•  ˆëŠ” Provider Package
 * | options.providerRequestXml 	: [defalut: †ìŒ] Provider ´ëì„œ ?¬ìš©XML ¸ì * | options.userDataXml 			: [defalut: †ìŒ] ?¬ìš©ê œë²„¨ë“ˆ œë°œ „ìš”°ì´°ë „ì†¡ ˆëŠ” € * | options.bodyWordwrap 			: [defalut: false] ¤ìš´œë“œ”ë”””ê¿ˆ °ëŠ¥
 * | options.useEuroLocale 			: [defalut: false] ¤ìš´œë“œ ë¡œ˜ë¦¬ °ëŠ¥(,?€ .˜ë½ìš°˜ë¦¬)
 * | options.useHeader 				: [defalut: true] ¤ìš´œë“œHeaderœë ¥  ì ?¬ë?( "true"¸ê²½œë ¥, "false"¸ê²½¸ì¶œ
 * | options.useSubTotal 			: [defalut: false] ¤ìš´œë“œSubTotalœë ¥  ì ?¬ë?( "true"¸ê²½œë ¥, "false"¸ê²½¸ì¶œ
 * | options.useFooter 				: [defalut: true] ¤ìš´œë“œFooterœë ¥  ì ?¬ë?( "true"¸ê²½œë ¥, "false"¸ê²½¸ì¶œ
 * | options.separator 				: [defalut: ,] ¤ìš´œë“œœë²„°ì´„ì†¡ ë•Œ, °ì´°ë ¬ë¶„“ëŠ” ¬ë¶„ default??comma(,)
 * | options.subTotalScale 			: [defalut: -1] ¤ìš´œë“œsubTotal ‰ê· „ì‚°Œìˆ˜ë¦¬˜ë € * | options.subTotalRoundingMode 	: [defalut: †ìŒ] ¤ìš´œë“œsubTotal ‰ê· „ì‚°Round?€œë‹¤. ("CEILING","FLOOR","HALF_UP")
 * | options.useStyle 				: [defalut: false] ¤ìš´œë“œcssœì™¸ style??excelë„ ìš©€ ?¬ë (°ê²½°íŠ¸)
 * | options.printSet 				: JSON•íƒœ€?¥ëœ Excel Print€ •
 * | options.printSet.fitToPage 	: [defalut: false] ‘ì „ë¦°œë ¥½ë§¬ìš©  ë¬´
 * | options.printSet.landScape 	: [defalut: false] ‘ì „ë¦°œë ¥€?©í–¥ œë ¥  ë¬´
 * | options.printSet.fitWidth 		: [defalut: 1] ‘ì „ë¦°œë ¥©ìˆë¹„
 * | options.printSet.fitHeigth 	: [defalut: 1] ‘ì „ë¦°œë ¥©ì’ì´
 * | options.printSet.scale 		: [defalut: 100] ‘ì „ë¦°œë ¥•ë/•ì†Œ °ìœ¨, scale???¬ìš©½ìš° fitToPage??false¤ì • ´ì•¼ œë‹¤.
 * 
 * @param <Object> infoArr ¸ë¦¬œì— ?€´ìš©”ê¤ë¥¸ ?€œí˜„˜ëŠ” ½ìš° ?¬ìš©˜ëŠ” °ì—´
 * | infoArr.rowIndex 		: ´ìš©œì‹œ‰ë²ˆ * | infoArr.colIndex 		: ´ìš©œì‹œ´ë²ˆ * | infoArr.rowSpan 		: ‘í•©‰ì˜  * | infoArr.colSpan 		: ‘í•©´ì˜  * | infoArr.text 			: œì‹œ´ìš©
 * | infoArr.textAlign 		: œì‹œ´ìš©•ë ¬ ©ë²• (left, center, right)
 * | infoArr.fontSize 		: font size ¤ì • ( ex) "20px" )
 * | infoArr.color 			: font color ¤ì • ( ex) "red" )
 * | infoArr.fontWeight 	: font weight ¤ì • ( ex) "bold" )
 * | infoArr.drawBorder 	: cell??border €??( ex) true )
 * 
 * @example
 * var options = {
 	fileName 			: "user.xls",
 	type 				: "1",
 	removeColumns 		: "",
 	foldColumns 		: "",
 	startRowIndex 		: 3,
 	startColumnIndex 	: 0,
 	headerColor 		: "#DBEEF3",
 	footerColor 		: "#92CDDC",
 	showProcess 		: true,
 	dataProvider 		: "",
 	useStyle 			: true
 };
 	var infoArr = [];
 	var infoObj = {
 	rowIndex 	: 1,
 	colIndex 	: 0,
 	rowSpan 	: 1,
 	colSpan 	: 3,
 	text 		: "¸ë¦¬š´œë“œ ˜í”Œ",
 	textAlign 	: "left"
 };
 infoArr.push(infoObj);
 */
comLib.downloadExcel = function(grdViewObj, options, infoArr) {
	if (grdViewObj.getTotalRow() > 0) {
		options = $.extend({
			startRowIndex : 1,
			startColumnIndex : 0,
			type : "1",
			autoSizeColumn :true,
			useStyle : false,
			useHeader : true,
			useDataFormat : false,
			headerColor:"#E2F1FE"
			}, options);
		grdViewObj.advancedExcelDownload(options, infoArr);
	} else {
		comLib.alert($p, "´ë ¤›ì„ °ì´°ê ´ì¬˜ì ŠìŠµˆë‹¤.");
	}
};

/**
 * GridView‘ì Œì¼ °ì´…ë¡œœí•œ
 * 
 * @date 2014. 12. 10.
 * @param <Object> grdViewObj ‘ì Œì¼°ì´°ë …ë¡œœí•  GridView ì²´
 * @param <Object> options JSON•íƒœ€?¥ëœ ¸ë¦¬œì˜ ‘ì …ë¡œµì…˜
 * | options.type 				: [defalut: 0] 1´ë©´ ‘ì Œì¼¸ë¦¬œì˜ ´ì´°ê³¼Œë“¤´ì ¸ˆì„ 0´ë©´ ‘ì Œì¼¸ë¦¬œì˜ ¤ì œ °ì´°ë¡œ ¬ì„±˜ì–´ˆì„ * | options.sheetNo 			: [defalut: 0] excelŒì¼ì„œ ¸ë¦¬œì˜ °ì´°ê ˆëŠ” sheetˆí˜¸
 * | options.startRowIndex 		: [defalut: 0] excelŒì¼ì„œ ¸ë¦¬œì˜ °ì´°ê œì‘˜ëŠ” ‰ì˜ ˆí˜¸(” ?¬í•¨)
 * | options.startColumnIndex 	: [defalut: 0] excelŒì¼ì„œ ¸ë¦¬œì˜ °ì´°ê œì‘˜ëŠ” ´ì˜ ˆí˜¸
 * | options.endColumnIndex 	: [default: 0] excelŒì¼ì„œ ¸ë¦¬œì˜ °ì´°ê ë‚˜´ì˜ index ( ‘ì¬ëŸ¼˜ê ¸ë¦¬œì»¬¼ìˆ˜ ´ë‹¤ ‘ì ½ìš° ¸ë¦¬??¬ëŸ¬˜ë ¤ì •)
 * | options.headerExist 		: [defalut: 0] excelŒì¼ì„œ ¸ë¦¬œì˜ °ì´°ì— header€ ˆëŠ”€ ?¬ë?(1´ë©´ header ´ì¬ 0´ë©´ †ìŒ)
 * | options.footerExist 		: [defalut: 1] excelŒì¼ì„œ ¸ë¦¬œì˜ °ì´°ì— footer€ ˆëŠ”€ ?¬ë?(1´ë©´ footer ´ì¬ 0´ë©´ †ìŒ °ë³¸’ì 1 ¸ë¦¬œì— footer€ †ìœ¼ìš©˜ì ŠìŒ)
 * | options.append 			: [defalut: 0] excelŒì¼ì„œ €¸ì˜¨ °ì´°ë ¸ë¦¬œì— appendœí‚¬€ ?¬ë?(1´ë©´ „ì¬ ¸ë¦¬œì— °ì´°ë ”ê£ì–´0´ë©´ „ì¬ ¸ë¦¬œì˜ °ì´°ë  œ˜ê³  ?£ìŒ)
 * | options.hidden 			: [defalut: 0] ½ì–´¤ì´¤ëŠ” ‘ìŒì¼hidden column???€?¥ë˜ˆëŠ”€ ?¬ë •˜ëŠ” int???«ì(0´ë©´  ‘ìŒì¼hidden °ì´°ê †ìœ¼€¸ë¦¬??hidden column°ì´°ë ½ì…  1 : ‘ìŒì¼hidden °ì´°ê ˆìœ¼€‘ì Œì¼œëhidden °ì´°ë ½ì… )
 * | options.fillHidden 		: [defalut: 0] Grid??hiddenColumn’ì„ ?£ì„€°ì •˜ê¸° „í•œ int???«ì(1´ë©´ hidden Column’ì„ ?€?¥í•˜€ ŠìŒ,0´ë©´ hidden column???€?¥ë˜´ìˆ€ Šì Excel File´ë¼ „ì£¼˜ê³  hidden Column’ì„ ?£ì–´(hidden??0½ìš°ëŠ” fillhidden?€ í–¥¼ì¹˜€ ŠìŒ)
 * | options.skipSpace 			: [defalut: 0] µë°±´ì‹œ ?¬ë?(1´ë©´ ´ì‹œ 0´ë©´ ?¬í•¨)
 * | options.insertColumns 		: radio, checkbox?€ ™ì ¬ëŸ¼‘ìì„œ ›ì•„ ¤ì Šê³ , ?¬ìš©¬ëŸ¼ ¤ì • ¼ë¡œ …ë¡œ( °ì´¬ì¡° : [ { columnIndex:1, columnValue:"1" } ] )
 * | options.popupUrl 			: …ë¡œœì‹œ¸ì¶œpopup??url
 * 
 * @example
 * var options = {};
 * options.headerExist ="1"; 		//”´ì¬ ?¬ë …ë‹ˆ
 * options.startRowIndex = "3"; 	//excelŒì¼ì„œ gird°ì´°ê œì‘row??index…ë‹ˆ.(” ?¬í•¨)
 * options.startColumnIndex = "0"; 	//excelŒì¼ì„œ gird°ì´°ê œì‘˜ëŠ” column??index…ë‹ˆ(” ?¬í•¨)
 * options.sheetNo=0; 				//excel??sheetˆí˜¸…ë‹ˆ
 * options.append ="0"; 			//append ?¬ë…ë‹ˆ 0´ë©´ append˜ì Šê³  ˆë¡œ °ê³  1´ë©´ ¸ë¦¬œì˜ ¤ìª½°ì´°ë ”ê™ì—¬ë‹ˆ
 * options.hidden ="1"; 			//1´ë©´ ¸ë¦¬œì—‘ì ¤ìš´œë“œœì— hidden???¬í•¨ˆë‹¤˜ë…ë‹ˆ ?uploadœì— ¸ë¦¬œì˜ hidden Column’ì„ ?£ëŠ”¤ëŠ” ˜ë…ë‹ˆ
 */
comLib.uploadExcel = function(grdViewObj, options) {
	options.endColumnIndex = options.endColumnIndex || grdViewObj.getColumnCount();
	grdViewObj.advancedExcelUpload(options); // ‘ì …ë¡œœë œì‘©ë‹ˆ
};

/**
 * GridView?€ ”ì¸©ëœ DataList ì²´˜í™˜œë‹¤.
 * 
 * @date 2014. 12. 10.
 * @param <Object> gridViewObj
 * @returns {Boolean}
 */
comLib.getGridViewDataList = function(gridViewObj) {
	var dataListId = gridViewObj.getDataList();

	if (dataListId !== "") {
		var dataList = WebSquare.util.getComponentById(dataListId);
		if ((typeof dataList === "undefined") || (dataList === null)) {
			$w.log("DataList(" + dataListId + ")¾ì„ †ìŠµˆë‹¤.");
			return null;
		} else {
			return dataList;
		}
	} else {
		$w.log(grd_Code.getID() + "??DataList€ ¸íŒ…˜ì–´ ˆì ŠìŠµˆë‹¤.");
		return null;
	}
};

/**
 * DataList?€ DataMap??€½ëœ °ì´°ë ˜í™˜œë‹¤.
 * 
 * @date 2014. 12. 10.
 * @param <Object> dcObj 		°ì´¬ë ‰´í¬ŒíŠ¸ (DataList or DataMap)
 * @param <String> rowStatus 	rowStatus ¬ëŸ¼†ëŠ” ½ìš° Default Row íƒœ ("C" : Create, "U" : Update, "D" : Delete)
 * @param <String> key JSON °ì´°ì˜  * @example
 	var modifiedData = comLib.getModifiedData(dlt_CodeGrp);
 */
comLib.getModifiedData = function(dcObj, rowStatus, keyData) {
	if (typeof dcObj !== "undefined") {
		var dataType = dcObj.getObjectType().toLowerCase();

		var key = "data";
		if ((typeof keyData !== "undefined") && (keyData !== "")) {
			key = keyData;
		}

		if (dataType === "datamap") {
			var modifiedData = $w.data.get("JSON", [{"id" : dcObj.getID(), "key" : key, action : "modified"}]);
			if (typeof rowStatus === "undefined") {
				modifiedData.data.rowStatus = "U";
			} else {
				modifiedData.rowStatus = rowStatus;
			}
			return modifiedData;
		} else if (dataType === "datalist") {
			return $w.data.get("JSON", [{"id" : dcObj.getID(), "key" : key, action : "modified"}]);
		}
	}
};

/**
 * GridView …ë°´íŠ¸ ´ì „ íƒœRollBackœë‹¤.
 * 
 * @date 2014. 12. 10.
 * @param <Object> gridViewObj 		GridView ì²´
 * @param <Number> rowIndex 		RollBack „ì— ?¬ì»¤¤ë ´ë™Row Index
 * @param <String> rowCol 			RollBack „ì— ?¬ì»¤¤ë ´ë™Column Index or Column Id
 * @param <String> chkHeaderId 		RollBack „ì— GridView Header??Uncheck??CheckBox Id
 * @example
 	comLib.rollbackGridView(grd_Code);
 	comLib.rollbackGridView(grd_Code, 0, "GRP_CD", "chkHeader");
 */
comLib.rollbackGridView = function(gridViewObj, rowIndex, column, chkHeaderId) {
	try {
		if ((typeof gridViewObj === "object") && (typeof gridViewObj.getPluginName === "function") && (gridViewObj.getPluginName() === "gridView")) {
			var dltObj = comLib.getGridViewDataList(gridViewObj);
			if (dltObj === null) {
				return;
			}

			dltObj.removeRows(dltObj.getInsertedIndex());
			dltObj.removeRows(dltObj.getRowIndexByStatus("V"));
			dltObj.undoAll();

			if ((typeof rowIndex !== "undefined") && (typeof column !== "undefined")) {
				gridViewObj.setFocusedCell(rowIndex, column);
			}

			if (typeof chkHeaderId !== "undefined") {
				chkHeaderId = "chkHeader";
			}

			if (typeof  gridViewObj.getHeaderIndex(chkHeaderId) !== "undefined") {
				gridViewObj.setHeaderValue(chkHeaderId, "0");
			}
		}
	} catch(e) {
		$w.log("[comLib.rollbackGridView] Exception :: " + e.message);
	} finally {
		dltObj = null;
	}
};

/**
 * GridView‰ì„  œœë‹¤. (dataList.removeRow() ?¬ìš©)
 * 
 * @date 2014. 12. 10.
 * @param <Object> gridViewObj
 * @example
 	// GridView œ„í•œ checkBox ¬ëŸ¼„ì´”ë "chk"˜ê³  ’ì 1: checked, 0: unchecked¤ì •´ì•¼ œë‹¤.
 	comLib.removeGridView(grd_CodeGrp);
 */
comLib.removeGridView = function(gridViewObj) {
	try {
		if ((typeof gridViewObj === "object") && (typeof gridViewObj.getPluginName === "function") && (gridViewObj.getPluginName() === "gridView")) {
			var dltObj = comLib.getGridViewDataList(gridViewObj);
			if (dltObj === null) {
				return;
			}

			var checkedIdxArr = dltObj.getMatchedIndex("chk", "1", true, 0, dltObj.getRowCount());
			if (checkedIdxArr.length > 0) {
				for (var i = checkedIdxArr.length - 1; i >= 0; i--) {
					dltObj.removeRow(checkedIdxArr[i]);
				}
			} else {
				dltObj.removeRow(gridViewObj.getFocusedRowIndex());
			}
		}
	} catch(e) {
		$w.log("[comLib.removeGridView] Exception :: " + e.message);
	} finally {
		dltObj = null;
	}
};

/**
 * GridView‰ì„  œœë‹¤. (dataList.deleteRow() ?¬ìš© rowStatus œì‹œ)
 * 
 * @date 2014. 12. 10.
 * @param <Object> gridViewObj
 * @example
 	// GridView œ„í•œ checkBox ¬ëŸ¼„ì´”ë "chk"˜ê³  ’ì 1: checked, 0: unchecked¤ì •´ì•¼ œë‹¤.
 	comLib.deleteGridView(grd_CodeGrp);
 */
comLib.deleteGridView = function(gridViewObj) {
	try {
		if ((typeof gridViewObj === "object") && (typeof gridViewObj.getPluginName === "function") && (gridViewObj.getPluginName() === "gridView")) {
			var dltObj = comLib.getGridViewDataList(gridViewObj);
			if (dltObj === null) {
				return;
			}

			var checkedIdxArr = dltObj.getMatchedIndex("chk", "1", true, 0, dltObj.getRowCount());
			if (checkedIdxArr.length > 0) {
				for (var i = checkedIdxArr.length; i >= 0; i--) {
					dltObj.deleteRow(checkedIdxArr[i]);
				}
			} else {
				dltObj.deleteRow(gridViewObj.getFocusedRowIndex());
			}
		}
	} catch(e) {
		$w.log("[comLib.deleteGridView] Exception :: " + e.message);
	} finally {
		dltObj = null;
	}
};

/**
 * µí†µ ”ë“œ ¸ë£¹ID???€µí†µ ”ë“œ °ì´°ë ™ê¸°”ì²­œë‹¤.
 * - ™ì  Data List ì„± : Data List ID (ldt_code_ + ”ë“œ¸ë£¹ID)
 * - selectBox ´í¬ŒíŠ¸dataList ìš©
 * - gridView selectBox ìš©
 * - filter ìš©
 *
 * @param options
 * @param callBackFn
 */
comLib.setCommonCode = function($p, options, callBackFn) {
	comLib.setCommonCodeSync($p, options, callBackFn);
};

/**
 * µí†µ ”ë“œ ¸ë£¹ID???€µí†µ ”ë“œ °ì´°ë „ë™°ë¡œ ”ì²­œë‹¤.
 * - ™ì  Data List ì„± : Data List ID (ldt_code_ + ”ë“œ¸ë£¹ID)
 * - selectBox ´í¬ŒíŠ¸dataList ìš©
 * - gridView selectBox ìš©
 * - filter ìš©
 *
 * @param options
 * @param callBackFn
 * @example
 	var options = [
 		{ clsCd : "CMS_0002", object : ["sel_code"] },
 		{ clsCd : "CMS_0003", object : ["sel_code2"] }
 	];
 	comLib.setCommonCode(options);

 	// gridView selectBox ìš©
 	// NodeSet : data:ldt_code_CMS_0002
 	// Label : cmmnCdNm
 	// Value : cmmnCd
 	var options2 = [ { clsCd : "CMS_0002" } ];
 	comLib.setCommonCode(options2);

 	var codeOption3 = [
 		{ clsCd : "CRWDVCD", suffixNm : "", object : ["sel_code"] },
 		{ clsCd : "CRWDVCD", suffixNm : "_F1", object : ["sel_code2"], filter : " && usrDfnEtc1 == 'A1'" }
 	];
 	comLib.setCommonCode(codeOption3);
 */
comLib.setCommonCodeAsync = function($p, options, callBackFn) {
	if (options == undefined || options == null) {
		return;
	}

	var requestData = {};

	var arrClsCd = [];
	for (var i=0; i<options.length; i++) {
		arrClsCd.push(options[i].clsCd);
	}

	requestData.useYn 		= options.useYn		|| "Y";
	requestData.usrDfnVu1	= options.usrDfnVu1 || "";
	requestData.usrDfnVu2	= options.usrDfnVu2 || "";
	requestData.usrDfnVu3	= options.usrDfnVu3 || "";
	requestData.usrDfnVu4	= options.usrDfnVu4 || "";
	requestData.usrDfnVu5	= options.usrDfnVu5 || "";
	requestData.usrDfnVu6	= options.usrDfnVu6 || "";
	requestData.usrDfnVu7	= options.usrDfnVu7 || "";
	requestData.usrDfnVu8	= options.usrDfnVu8 || "";
	requestData.clsCdList	= arrClsCd || [];

	requestData.options		= options;
	requestData.callBackFn	= callBackFn || "";
	if (callBackFn) {
		if (typeof callBackFn === "string") {
			if (callBackFn.indexOf("scwin.") === 0) {
				requestData.callBackFn = $p.id + callBackFn;
			}
		}
	}
	comLib.getCheckCallBackFunc(requestData.callBackFn,"comLib.setCommonCodeAsync");/* œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ €ŒìŠ¤´í›„  œˆì •*/

	var option = {
		action : "/sc/cmmncd/retrieveClsCdCmmnCd.do",
		reqData : requestData,
		success : "comLib.setCommonCodeCallback",
		isShowMeg : false
	};
	ajaxLib.requestAjaxAsyncCode($p, option);
};

/**
 * µí†µ ”ë“œ ¸ë£¹ID???€µí†µ ”ë“œ °ì´°ë ™ê¸°”ì²­œë‹¤.
 * - ™ì  Data List ì„± : Data List ID (ldt_code_ + ”ë“œ¸ë£¹ID)
 * - selectBox ´í¬ŒíŠ¸dataList ìš©
 * - gridView selectBox ìš©
 * - filter ìš©
 *
 * @param options
 * @param callBackFn
 * @example
 	var options = [
 		{ clsCd : "CMS_0002", suffixNm : "", object : ["sel_code"] },
 		{ clsCd : "CMS_0003", suffixNm : "", object : ["sel_code2"] }
 	];
 	comLib.setCommonCode(options);

 	// gridView selectBox ìš©
 	// NodeSet	: data:ldt_code_CMS_0002
 	// Label	: cmmnCdNm
 	// Value	: cmmnCd
 	var options2 = [ { clsCd : "CMS_0002", suffixNm : "" } ];
 	comLib.setCommonCode(options2);

 	var codeOption3 = [
 		{ clsCd : "CMS_0002", suffixNm : "", object : ["sel_code"] },
 		{ clsCd : "CMS_0003", suffixNm : "_F1", object : ["sel_code2"], filter : " && usrDfnEtc1 == 'A1'" }
 	];
 	comLib.setCommonCode(codeOption3);
 */
comLib.setCommonCodeSync = function($p, options, callBackFn) {
	if (options == undefined || options == null) {
		return;
	}

	var requestData = {};

	var arrClsCd = [];
	for (var i = 0; i < options.length; i++) {
		arrClsCd.push(options[i].clsCd);
	}

	requestData.useYn		= options.useYn || "Y";
	requestData.usrDfnVu1	= options.usrDfnVu1 || "";
	requestData.usrDfnVu2	= options.usrDfnVu2 || "";
	requestData.usrDfnVu3	= options.usrDfnVu3 || "";
	requestData.usrDfnVu4	= options.usrDfnVu4 || "";
	requestData.usrDfnVu5	= options.usrDfnVu5 || "";
	requestData.usrDfnVu6	= options.usrDfnVu6 || "";
	requestData.usrDfnVu7	= options.usrDfnVu7 || "";
	requestData.usrDfnVu8	= options.usrDfnVu8 || "";
	requestData.clsCdList	= arrClsCd || [];

	requestData.options		= options;
	requestData.callBackFn	= callBackFn || "";
	if (callBackFn) {
		if (typeof callBackFn === "string") {
			if (callBackFn.indexOf("scwin.") === 0) {
				requestData.callBackFn = $p.id + callBackFn;
			}
		}
	}
	comLib.getCheckCallBackFunc(requestData.callBackFn, "comLib.setCommonCodeSync"); /* œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ € ŒìŠ¤´í›„  œˆì •*/
	requestData.frameId = $p.getFrameId();

	var option = {
		action : "/sc/cmmncd/retrieveClsCdCmmnCd.do",
		reqData : requestData,
		success : "comLib.setCommonCodeCallback",
		isShowMeg : false
	};
	ajaxLib.requestAjaxSyncCode($p, option);
};

/**
 * µí†µ ”ë“œ ¸ë£¹ °ì´”ì²­€œë°± ?¨ìˆ˜„ì—­ µê°„”ë“œ °ì´°ë ?€?¥í•œ
 *
 * @param reqData
 * @param resBody
 */
comLib.setCommonCodeCallback = function(reqData, resBody, $p) {
	// var $p = $w.getComponentById(e.id).scope.$p;

	WebSquare.session.setAttribute("code", utilLib.serialize(resBody.data));
	comLib.setCodeObject($p, reqData.options);
	if (reqData.callBackFn) {
		if (typeof reqData.callBackFn === "function") {
			reqData.callBackFn();
		} else {
			eval(reqData.callBackFn)();
		}
	}
};

/**
 * „ì²´ µí†µ ”ë“œ °ì´”ì²­€œë°± ?¨ìˆ˜„ì—­ µê°„”ë“œ °ì´°ë ?€?¥í•œ
 * 
 * @date 2014. 12. 10.
 * @param <Object> resBody
 * @param <Object> e
 */
comLib.setAllCodeCallback = function(resBody, e) {
	WebSquare.session.setAttribute("code", utilLib.serialize(resBody.data));
};

/**
 * µí†µ ”ë“œ DataListì„±œë‹¤.
 * 
 * @date 2014. 12. 10.
 */
comLib.createCodeDataList = function($p) {
	var option = {
		"id" :"_dlt_Code" ,
		"type" : "dataList" ,
		"option":{
			"baseNode": "list",
			"repeatNode": "map"
		},
		"columnInfo":[
			{"id":"clsCd", "name":"„ë¥˜”ë“œ", "dataType":"text"},
			{"id":"cmmnCd", "name":"µí†µ”ë“œ", "dataType":"text"},
			{"id":"cmmnCdNm", "name":"µí†µ”ë“œ, "dataType":"text"},
			{"id":"cmmnCdDc", "name":"µí†µ”ë“œ¤ëª…", "dataType":"text"},
			{"id":"upperClsCd", "name":"ìœ„„ë¥˜”ë“œ", "dataType":"text"},
			{"id":"upperCmmnCd", "name":"ìœ„µí†µ”ë“œ", "dataType":"text"},
			{"id":"useYn", "name":"?¬ìš©¬ë?", "dataType":"text"},
			{"id":"sortOrdr", "name":"•ë ¬œì„œ", "dataType":"text"},
			{"id":"sapLnkYn", "name":"SAP°ê³„¬ë?", "dataType":"text"},
			{"id":"usrDfnVu1", "name":"?¬ìš©ì •˜ê¸°€1", "dataType":"text"},
			{"id":"usrDfnVu2", "name":"?¬ìš©ì •˜ê¸°€2", "dataType":"text"},
			{"id":"usrDfnVu3", "name":"?¬ìš©ì •˜ê¸°€3", "dataType":"text"},
			{"id":"usrDfnVu4", "name":"?¬ìš©ì •˜ê¸°€4", "dataType":"text"},
			{"id":"usrDfnVu5", "name":"?¬ìš©ì •˜ê¸°€5", "dataType":"text"},
			{"id":"usrDfnVu6", "name":"?¬ìš©ì •˜ê¸°€6", "dataType":"text"},
			{"id":"usrDfnVu7", "name":"?¬ìš©ì •˜ê¸°€7", "dataType":"text"},
			{"id":"usrDfnVu8", "name":"?¬ìš©ì •˜ê¸°€8", "dataType":"text"}
		]
	};

	comLib.createData($p, option);

	var codeJsonStr = WebSquare.session.getAttribute("code");
	var _dlt_Code = $p.getComponentById("_dlt_Code");
	_dlt_Code.setJSON(utilLib.parse(codeJsonStr));
};

/**
 * µí†µ”ë“œ LinkedDataListì„±œë‹¤.
 * 
 * @date 2014. 12. 10.
 */
comLib.createCodeLinkedDataList = function($p, filterCond) {
	for (var i = 0 ; i < filterCond.length ; i++) {
		var clCd = filterCond[i].substring(9);
		var option = {
			"id" :filterCond[i] ,
			"type" : "linkedDataList" ,
			"option" : {
				"valueAttribute" : "",
				"bind" : "_dlt_Code",
				"filterCondition" : "clCd == '" + clCd + "'",
				"sortCondition" : ""
			}
		};
		comLib.createData($p, option);
	}
};

/**
 * µí†µ ”ë“œì„±œë‹¤. [?¬ìš©˜ì ŠëŠ”™ìŒ]
 * 
 * @date 2014. 12. 10.
 * @param <Object> filterCond
 * @example
 	comLib.setCode(["ldt_Code_20", "ldt_Code_19", "ldt_Code_18"]);
 */
comLib.setCode = function($p, fiterCond) {
	comLib.createCodeDataList($p);
	comLib.createCodeLinkedDataList($p, fiterCond);
};

/**
 * µí†µ ”ë“œì„±˜ê³ , µí†µ ”ë“œ¬ìš©˜ëŠ” ì²´¤ì •œë‹¤.
 * 
 * @date 2014. 12. 10.
 * @param <Object> options
 * @example
 	var codeOption1 = [{clsCd : "20", object : [sbxOrgClassCd] }];
 	comLib.setCodeObject(codeOption1);

 	var codeOption2 = [
 		{clsCd : "01", object : [sbx_Duty1, sbxDuty2] },
 		{clsCd : "02", object : [sbxPostion1, sbxPostion2] },
 		{clsCd : "04", object : [sbxReligion] }
 	];
 	comLib.setCodeObject(codeOption2);
 */
comLib.setCodeObject = function($p, options) {
	// var $p = window[frameId].scope.$p;
	comLib.createCodeDataList($p);

	for (var key in options) {
		if (options.hasOwnProperty(key)) {
			var clsCd = options[key].clsCd;
			var suffixNm = (options[key].suffixNm == undefined)  "" : options[key].suffixNm;
			var filterCondition = "clsCd == '" + clsCd + "'";
			var filter = options[key].filter;
			if (filter != undefined && filter != "") {
				filterCondition = filterCondition + filter;
			}
			var option = {
				"id" : "ldt_Code_" + clsCd + suffixNm,
				"type" : "linkedDataList" ,
				"option" : { "valueAttribute" : "",
					"bind" : "_dlt_Code",
					"filterCondition" : filterCondition,
					"sortCondition": ""
				}
			};
			comLib.createData($p, option);
			var objects = options[key].object;
			if (objects) {
				for (var objKey in objects) {
					try {
						if (objects.hasOwnProperty(objKey)) {
							if (objects[objKey]!="") {
								if ($p.getComponentById(objects[objKey])) {
									$p.getComponentById(objects[objKey]).setNodeSet("data:ldt_Code_" + clsCd + suffixNm, "cmmnCdNm", "cmmnCd");
								} else {
									if (objects[objKey]) {
										/* ¨íŠ¸”ì¸˜ë¦¬ ¥˜ €œì‘ */
										console.error("´ë‹¹ „ë ˆp:" + $p.id + "]ì„œ ´ë‹¹ ¨íŠ¸id:" + objects[objKey] + "¾ì„†ìŠµˆë‹¤.");
										alert("´ë‹¹ „ë ˆp:" + $p.id + "]ì„œ ´ë‹¹ ¨íŠ¸id:" + objects[objKey] + "¾ì„†ìŠµˆë‹¤.");
										/* ¨íŠ¸”ì¸˜ë¦¬ ¥˜ €???*/
									}
								}
							}
						}
					} catch(e) {
						console.log("´ë‹¹ „ë ˆp:" + $p.id + "]ì„œ ´ë‹¹ ¨íŠ¸id:" + objKey + "¾ì„†ìŠµˆë‹¤.");
						alert("´ë‹¹ „ë ˆp:" + $p.id + "]ì„œ ´ë‹¹ ¨íŠ¸id:" + objKey + "¾ì„†ìŠµˆë‹¤.");
					}
				}
			}
		}
	}
};

/**
 * µ­€ì„ ˜ë¦¬ œë¹„¤ë ¸ì¶œœë‹¤.
 * 
 * @date 2015. 03. 03.
 */
comLib.getI18NUrl = function() {
	var locale = WebSquare.cookie.getCookie("locale");
	if (locale == null || locale == "") {
		return ajaxLib.CONTEXT_PATH + "/wq/engine/servlet/I18N.jsp?w2xPath=";
	} else {
		return ajaxLib.CONTEXT_PATH + "/wq/engine/servlet/I18N.jsp?locale=" + unescape(locale) + "&w2xPath=";
	}
};

/**
 * SAP µí™” ?¨ìœ„°ë¥¸ ’ì„ €¸ì˜¤ * 
 * @date 2015. 03. 03.
 * @param unit µí™”¨ìœ„ KRW
 * @return ZSHIFT
 */
comLib.getCurrShift = function(unit) {
	var jsonObj = top.dltCurrShift.getMatchedJSON("WAERS", unit, true)[0];

	if (utilLib.isNull(jsonObj)) {
		return "";
	} else {
		return jsonObj.ZSHIFT;
	}
};

/**
 * ?¬ìš©°ì´€ * 
 * @date 2017. 06. 29.
 * @param doc
 *	”ë©´(ì—…)ì„œ ¥¸ ”ë©´(”ì¸)¼ë¡œ „ë‹¬˜ê³ ˜ëŠ” •ë³´ ?€ * @return
 */
comLib.setUserDocData = function(doc) {
	userDocData = doc;
};

/**
 * ?¬ìš©°ì´˜í™˜
 * 
 * @date 2017. 06. 29.
 * @param
 * @return ?€?¥ëœ •ë³´doc¼ë¡œ € */
comLib.getUserDocData = function() {
	var doc = userDocData;

	userDocData = null;

	return doc;
};

/**
 * ¹ì¸”ì²­°ì´SET
 * 
 * @date 2017. 07. 14.
 * @param aprvRqustData : ¹ì¸”ì²­°ì´ * @return
 */
comLib.setAprvRqustData = function(aprvRqustData) {
	comLib.aprvRqustData = aprvRqustData;
};

/**
 * ¹ì¸”ì²­°ì´GET
 * 
 * @date 2017. 07. 14.
 * @param 
 * @return aprvRqustData : ¹ì¸”ì²­°ì´ */
comLib.getAprvRqustData = function() {
	var aprvRqustData = comLib.aprvRqustData;
	comLib.aprvRqustData = null;
	return  aprvRqustData;
};

/**
 * ¹ì¸”ì²­ ´ì—­´ì¬ ?¬ë´í¬œë‹¤.
 * 
 * @date 2017. 07. 14.
 * @param dlt_AprvRqust : ¹ì¸´ì—­
 * @return
 */
/*
comLib.selectAprvRqustInfo = function(aprvRqustData) {
	var requestData = {};
	requestData.data = aprvRqustData;
	comLib.setAprvRqustData(aprvRqustData);

	var option = {
		action : "/sc/sanctn/jobsanctn/selectAprvRqustInfo.do",
		reqData : requestData,
		resData : "",
		success : "comLib.selectAprvRqustInfoCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};
*/

/**
 * ¹ì¸”ì²­ ´ì—­´ì¬ ?¬ë´í¬ œë°±¨ìˆ˜¸ì¶œœë‹¤.
 * 
 * @date 2017. 07. 14.
 * @param
 * @return
 */
/*
comLib.selectAprvRqustInfoCallback = function(resbody) {
	var progrsCnt = resbody.data.progrsCnt;
	var returnCnt = resbody.data.returnCnt;
	var comptCnt = resbody.data.comptCnt;

	var docInfo =comLib.getAprvRqustData();

	if (comptCnt>0) {
		if (returnCnt>0) {
			if (docInfo.length == 1) {
				// comLib.confirm(utilLib.getMessage("SCM.INFO.00323"), "comLib.aprvRqustCallback");
				if (confirm("°ê²°¬ìµê³¼˜ì‹œ ìŠµˆê¹Œ")) {
					comLib.aprvRqustCallback("1", docInfo);
				} else {
					comLib.aprvRqustCallback("2", docInfo);
				}
			} else{
				comLib.alert($p, utilLib.getMessage("SCM.INFO.00176", "°ì¬¹ì¸´ì—­"));
			}
		} else{
			comLib.alert($p, utilLib.getMessage("SCM.INFO.00176", "°ì¬¹ì¸´ì—­"));
		}
	} else{
		comLib.aprvRqustCallback("0", docInfo);
	}
};
*/

/**
 * ¨ë“  ”ì‹œ€ °ì´°ë °íšŒœë‹¤.
 * 
 * @date 2017. 07. 19.
 * @param
 * @return
 */
comLib.retrieveAllMsg =  function($p) {
	var requestData = {};

	var option = {
		action : "/sc/msgmng/retrieveAllMsg.do",
		reqData : requestData,
		resData : $p.top().wfm_left.getWindow().dltMsgMng,
		success : "",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

/**
 * µí†µ¼ë¡œ œê³µ˜ëŠ” ?¨ë… ì—…½ì— ?€”ì‹œ€ °ì´°ë °íšŒœë‹¤.
 * 
 * @date 2017. 07. 19.
 * @param msgId []:°íšŒmsgId °ì—´ * @return
 */
comLib.retrievePopupMsg =  function($p, msgId) {
	var requestData = {};
	requestData.data = msgId;
	var dltMsgMngObj;

	if (typeof dltMsgMng !== "undefined" && dltMsgMng !== "") {
		dltMsgMngObj = $p.top().wfm_left.getWindow().dltMsgMng;
	} else {
		dltMsgMngObj = $p.top().dltMsgMng;
	}

	var option = {
		action : "/sc/msgmng/retrievePopupMsg.do",
		reqData : requestData,
		resData : dltMsgMngObj,
		success : "",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

/**
 * ”ë©´ì„œ ?€ œìŠ¤œì˜ ”ë©´??http:// œì‘˜ëŠ” Full URL?Window popup˜ëŠ” ?¨ìˆ˜
 * 
 * @date 2017. 07. 23.
 * @param jobSeCd 			…ë¬´¬ë¶„”ë“œ ì * @param sec_cd 			´ë–¤ œìŠ¤œì—ì—…¸ì¶œˆëŠ”€ •ì¸˜ëŠ” ´ì•ˆ”ë“œ
 * @param targetHost 		ì—…”ë©´ˆëŠ” Host ( œìŠ¤œë³„ ìˆ˜•ì˜˜ì–´ ˆìŒ. (comLib.ADT_POP_URL ?€ ™ì´.)
 * @param targetPage 		ì—… ˜ëŠ” ¤ì œ ”ë©´ URL
 * @param popWidth 			ì—… ?¬ì´ )
 * @param popHeight 		ì—… ?¬ì´ ’ì´)
 * @param callbackFunction 	°ê³¼›ì„ callback ?¨ìˆ˜ * @return
 */
comLib.openWindowPopup = function(obj , sec_cd, targetHost, targetPage , popWidth, popHeight, callbackFunction) {
	// XDM ??JSon???¬ìš©ˆë„ ì–¸
	easyXDM.DomHelper.requiresJSON(comLib.getContextPath() + "/resources/js/xdm/json2.js");
	var proxy;
	var popWin; // XDM ???¬ìš©˜ëŠ” Proxy ì²´€ popupì²´
	// alert("/resources/jsp/popInterface.jsp?popPage=" + targetPage + "&width=" + popWidth + "&height=" + popHeight + "&usrId=" + comLib.getUsrId() + "&sysDivCd="+comLib.getSysDivCd() + "&biznDivCd="+comLib.getBiznDivCd() + "&sec_cd="+sec_cd );

	proxy = new easyXDM.Rpc(/** The configuration */{
		/**
		 * Register the url to name.html, this must be an absolute path
		 * or a path relative to the root.
		 * @field
		 */
		local: comLib.getContextPath() + "/resources/js/xdm/name.html",
		/**
		 * Register the url to the remote interface
		 * @field
		 */
		remote: targetHost + "/resources/jsp/popInterface.jsp?popPage=" + targetPage + "&width=" + popWidth + "&height=" + popHeight + "&usrId=" + comLib.getUsrId() + "&sysDivCd=" + comLib.getSysDivCd() + "&biznDivCd=" + comLib.getBiznDivCd() + "&sec_cd=" + sec_cd + "&obj=" + obj ,
		remoteHelper: targetHost + "/resources/js/xdm/name.html"
	}, {
		remote: {
			open: {},
			postMessage:{}
		},
		local: {
			/**
			 * Register the method that should handle incoming data
			 * @param {Object} data
			 * @param {String} origin
			 */
			postMessage: callbackFunction
		}
	});

	// lets tell the proxy to open up the window as soon as possible
	proxy.open("mainapp");
	proxy.postMessage(obj);
};

/**
 * ì—…½ì„ €?€¨ì°½ˆëŠ”€???¬ë ë‹¨ ?€¨ì°½ì²´ ¬í„´
 * 
 * @date 2017. 07. 19.
 * @param location  ì—…½ì˜ location •ë³´
 * @param window  ì—…ì²´
 * @return
 */
comLib.getHostforPopup = function(location, window) {
	var target = location.hash.substring(1);
	var host ={};
	try {
		host =window.opener.frames[target];
	}
	catch (e) {
	}
	if (window.opener) {
		try {
			// test if we have access to the document
				if (window.opener.document.title) {
					host = window.opener;
			}
		}
		catch (xDomainError) {
			// we have an opener, but it's not on our domain,
			host = window.opener.frames[target];
		}

		if (host) {
			try {
				host.setApp(window);
			}
			catch (browserHostError) {
				alert("was unable to gain a reference to the iframe");
			}
		}
	}

	return host;
};

/**
 * utilLib.getDate() + SYS_DIV_CD(3) + 0000??¼”í˜¸¨ìˆ˜¸ì¶œœë‹¤.
 * 
 * @date 2017. 07. 26.
 * @param
 * @return
 */
// comLib.selectDataEnc = function(dataDec) {
// var requestData = {"dataDec" : dataDec};
//
// var option = {
	// action : "/sc/cmmncd/selectDataEnc.do",
	// reqData : requestData,
	// resData : "",
	// success : "comLib.selectDataEncCallback",
	// isShowMeg : true
// };
//
// ajaxLib.executeAjax(option);
//};

/**
 * utilLib.getDate() + SYS_DIV_CD(3) + 0000??¼”í˜¸”í•œ ’ìœ¼¬í„´›ëŠ”
 * 
 * @date 2017. 07. 19.
 * @param
 * @return
 */
//comLib.selectDataEncCallback =  function(resBody) {
//	return resBody.data.dataEnc;
//};

/**
 * utilLib.getDate()µí˜¸œë‹¤.
 * 
 * @date 2017. 07. 27.
 * @param dataStr 	µí˜¸€¸êµ¬
 * @param divCd 	µí˜¸¬ë¶„ * @return str 		µí˜¸”ëœ ¸êµ¬
 */
comLib.dataDecEnc = function(dataStr, divCd) {
	var str = "";

	if (divCd == "D") {
		str = dataStr.substring(0, dataStr.length -1);
	} else {
		str = dataStr + "0";
	}

	return str;
};

/**
 * comLib.restdeYn() ´ì¼¬ë´í¬œë‹¤.
 * 
 * @date 2017. 07. 31.
 * @param dataStr  íƒ  ì§œ
 * @return str ´ì¼¬ë?(Y/N)
 */
comLib.restdeYn = function($p, dateStr) {
	var requestData = {};
	var returnData = "";

	// json€	var restdeData = {"mngStdrDe" : dateStr.replaceAll("-", "")};
	// requestData.restdeData = JSON.stringify(restdeData); // 2017. 11. 01. KMS. ¥˜ ˜ì •
	requestData.restdeData = restdeData;

	var option = {
		action : "/sc/restdemng/retrieveRestdeYn.do",
		reqData : requestData,
		success : function(resBody) {
			// console.log(resBody);
			returnData = resBody.data.restdeYn;
		},
		isShowMeg : false
	};

	ajaxLib.executeAjaxSync($p, option);

	return returnData;
};

/**
 * ´ì¼˜ë °íšŒœë‹¤.
 * 
 * @date 2017. 11. 02.
 * @param strtDe 	œì‘ * @param endDe 	…ë£Œ * @return ´ì¼ */
comLib.selectRestdeCo =  function($p, strtDe, endDe) {
	var requestData = {};
	var returnData = "";

	// json€	var restdeData = {};
	restdeData.strtDe = strtDe.replaceAll("-", "");
	restdeData.endDe = endDe.replaceAll("-", "");

	requestData.restdeData = restdeData;

	var option = {
		action : "/sc/restdemng/selectRestdeCo.do",
		reqData : requestData,
		success : function(resBody) {
			returnData = resBody.data.restdeCo;
		},
		isShowMeg : false
	};1

	ajaxLib.executeAjaxSync($p, option);

	return returnData;
};

/**
 * ì—…¼ìˆ˜°íšŒœë‹¤.
 * 
 * @date 2017. 11. 02.
 * @param strtDe 	œì‘ * @param endDe 	…ë£Œ * @return ì—…¼ìˆ˜
 */
comLib.selectBunsDcnt =  function($p, strtDe, endDe) {
	var requestData = {};
	var returnData = "";

	// json€	var restdeData = {};
	restdeData.strtDe = strtDe.replaceAll("-", "");
	restdeData.endDe = endDe.replaceAll("-", "");

	requestData.restdeData = restdeData;

	var option = {
		action : "/sc/restdemng/selectBunsDcnt.do",
		reqData : requestData,
		success : function(resBody) {
			returnData = resBody.data.bunsDcnt;
		},
		isShowMeg : false
	};

	ajaxLib.executeAjaxSync($p, option);

	return returnData;
};

/**
 * µí†µ ´ë²¤˜ë¦¬
 * - Help Box click ´ë²¤ * 
 * @date 2017. 08.10
 */
comLib.cmmnEvt = function($p) {
	// Help Box  ê ˜ë¦¬ click ´ë²¤	var helpBoxJq = $p.$(".help-box");
	setTimeout(function() {
		if (helpBoxJq.length > 0) {
			helpBoxJq.removeClass("on");
			helpBoxJq.addClass("off");
		}
	}, 2000);

	$p.$(".close").click(function() {
		if (helpBoxJq.length > 0) {
			helpBoxJq.removeClass("on");
			helpBoxJq.addClass("off");
		}
	});

	$p.$(".help-btn").click(function() {
		if (helpBoxJq.length > 0) {
			helpBoxJq.addClass("on");
			helpBoxJq.removeClass("off");
		}
	});

	var btnJq = $p.$(".toggle-box >button");
	if (btnJq.length > 0) {
		btnJq.click();
	}
};

comLib.insertMenuLog = function($p, menuInfo) {
	// {"menuId" : jsonObj.menuId, "menuNm" : jsonObj.menuNm , "scrinId" :  jsonObj.scrinId ,"usrId" : comLib.getUsrId() , "sysDivCd" : comLib.getSysDivCd(), "conectIp" : comLib.getConectIp()} ;

	// ”ë‰´ID”ë©´URL –´½ìš° Œì¼…ì„ ˜ë¼¸ë‹¤.
	if (menuInfo.menuId == null) {
		return;
	} else if (menuInfo.menuId.length > 20) {
		var menuId = menuInfo.menuId;
		menuInfo.menuId = menuId.substring(menuId.lastIndexOf("/") + 1, menuId.lastIndexOf("."));
	}

	var option = {
		action : "/sc/menumng/createMenuConectLog.do",
		reqData : menuInfo,
		resData : "",
		success : "comLib.insertMenuLogCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

comLib.insertCtznMenuLog  = function($p, menuInfo) {
	//  menuInfo : { menuId, menuNm, sysDivCd, conctrId(usrId), conctrNm(usrNm), conectParmCtnt, conctrIp, intnYn(N(or null):?€ Y:?€ }
	var option = {
		action : "/sc/menulog/insertUnifMenuConectLog.do",
		reqData : menuInfo,
		resData : "",
		success : "comLib.insertMenuLogCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

comLib.insertMenuLogCallback  = function($p, resData) {
	// console.log ("*****insertMenuLogCallback ****" ,resData );
};

/**
 * GIS ì—­ open toggle
comLib.openGisAreaToggle = function() {
	top.$(".btn_m_icon_gis").addClass("gis-in");
	// GIS½ì´ ì—…½ìš°.
	if (comLib.isGisPop()) {
		top.$(".btn_m_icon_gis").removeClass("gis-in");
		comLib.getGisScwin().scwin.gisPopFocus();
		return;
	}

	top.$(".gis-area").toggleClass("gis-on");
	$p.top().wrap.toggleClass("gis-on");

	if (top.$(".gis-area").attr("class").indexOf("gis-on") >= 0) {
		top.$(".btn_m_icon_gis").removeClass("gis-in");
	} else {
		top.$(".btn_m_icon_gis").addClass("gis-in");
	}
};
 */

/**
 * GIS ì—­ open full (MIS:GIS=0:100)
 * @param openType (G,B)
comLib.openGisArea = function(openType) {
	if (utilLib.isNull(openType)) {
		if (openType == "F") {
			comLib.openGisAreaFull();
		} else if (openType == "H") {
			comLib.openGisAreaHalf();
		}
	}
};
 */

/**
 * GIS ì—­ open full (MIS:GIS=0:100)
comLib.openGisAreaFull = function() {
	// GIS½ì´ ì—…½ìš°.
	if (comLib.isGisPop()) {
		return;
	}

	// gis½ì— ´ë ¤ˆëŠ” ì—…„ì¹˜´ë™œë‹¤.
	gisUtil.moveAllPopup("F");

	var gisWin = comLib.getGisWindow();
	var gisScwin = comLib.getGisScwin();
	gisScwin.btn_gis_toggle.removeClass("btn_gis_full");
	gisScwin.btn_gis_toggle.addClass("btn_gis_half");

	// top.$(".gis-area").attr("class", "w2group gis-area gis-full gis-on");
	var gisAreaClass = top.$(".gis-area");

	var addClass = "";

	if (gisAreaClass.hasClass("header_hide")) {
		addClass = "header_hide";
	}

	gisAreaClass.attr("class", "w2group gis-area " + addClass + " gis-full gis-on");

	// „ì²´´ê²½”ëœì„±œë‹¤
	gisWin.$(".gis_content_tool").toggleClass("open");
	// gisWin.$(this).toggleClass("open");
	gisWin.$(".gis_content_tool_toggle_btn").toggleClass("open");

	gisWin.$(".btn_group_01").toggleClass("open");
	gisWin.$(".btn_group_02").toggleClass("open");
	gisWin.$(".btn_group_15").toggleClass("open");
	gisWin.$(".btn_group_popup").toggleClass("open");
	gisWin.$(".cdnt_info").toggleClass("open");
};
*/

/**
 * GIS ì—­ open Half (MIS:GIS=50:50)
comLib.openGisAreaHalf = function() {
	// GIS½ì´ ì—…½ìš°.
	if (comLib.isGisPop()) {
		return;
	}

	// gis½ì— ´ë ¤ˆëŠ” ì—…„ì¹˜´ë™œë‹¤.
	gisUtil.moveAllPopup("H");
	var gisWin = comLib.getGisWindow();
	var gisScwin = comLib.getGisScwin();
	gisScwin.btn_gis_toggle.removeClass("btn_gis_half");
	gisScwin.btn_gis_toggle.addClass("btn_gis_full");
	gisWin.$p.parent().$p.$("#wrap").attr("class", "w2group gis-on");
	gisWin.$p.parent().$p.$(".gis-area").attr("class", "w2group gis-area gis-on");
};
*/

/**
 * €¨ì°½ object €¸ì˜¤ */
comLib.getParent = function() {
	try {
		if (opener && opener.WebSquare) {
			return opener;
		} else {
			return parent;
		}
	} catch(e) {
		return parent;
	}
};

/**
 * GIS ì—…ˆëŠ”€ ´í¬
 * @param  popId
 * @return popup window object or undefined
comLib.isGisPop4Ecs = function(popId) {
	popId = popId || "ECSPG91000001";
	// ˆë„ID´ì¡°?mf€ ™ìŒ
	popId = "mf_" + popId;
	var parentObj = comLib.getParent();
	if (parentObj.$p.isPopup()) {
		parentObj = parentObj.comLib.getParent();
	}

	try {
		if (parentObj.top==undefined ) {
			return undefined;
		}
		if (parentObj.$p.top().ifmGis == undefined ) {
			return undefined;
		}
		var gisWin = parentObj.$p.top().ifmGis.getWindow();
		if (gisWin.$p.getPopupWindow(popId) != undefined) {
			return gisWin.$p.getPopupWindow(popId);
		} else {
			return undefined;
		}
	} catch(e) {
		return undefined;
	}
};
*/

//”ì€˜ì •(navigator.xml script ì—­´ê-œì‘)
comLib.heightSam = function($p) {
	var heights = $p.$(".height-sam").map(function() {
		return $(this).height();
	}).get();
	var maxHeight = Math.max.apply(null , heights);
	$p.$(".height-sam").height(maxHeight);
};

comLib.toggleBtn = function($p) {
	$p.$(".toggle-btn").click(function() {
		$(this).parent(this).toggleClass("toggle-on");
		if ($(this).parents(".search-box").length > 0) {
			if (typeof $p.top().scwin.winresize == "function") {
				setTimeout(function() {
					$p.top().scwin.winresize();
				}, 200);
				// $p.top().scwin.winresize();
			}
			if (typeof winresize == "function") {
				winresize();
			}
		}
		if ($(this).parents(".view-box").length > 0) {
			if (typeof $p.top().scwin.winresize == "function") {
				setTimeout(function() {
					$p.top().scwin.winresize();
				}, 200);
				// $p.top().scwin.winresize();
			}
			if (typeof winresize == "function") {
				winresize();
			}
		}
	});
};

comLib.toggleBtn2 = function($p) {
	$p.$(".toggle-btn2").click(function() {
		$(this).parent(this).toggleClass("toggle-on2");
		if ($(this).parents(".search-box").length > 0) {
			if (typeof $p.top().scwin.winresize == "function") {
				setTimeout(function() {
					$p.top().scwin.winresize();
				}, 200);
				// $p.top().scwin.winresize();
			}
			if (typeof winresize == "function") {
				winresize();
			}
		}
	});
};

comLib.toggledetailBtn = function($p) {
	$p.$(".toggle-detail-btn").click(function() {
		$(".search-box.toggle-box.search-detail .list").toggleClass("toggle-detail-on");
	});
};

comLib.slideBtn = function($p) {
	$p.$(".slide-toggle-btn").click(function() {
		$(this).parent(this).toggleClass("slide-on");
	});
};

comLib.slideBtn2 = function($p) {
	$p.$(".slide-toggle-btn2").click(function() {
		$(this).parent(this).toggleClass("slide-on2");
	});
};

comLib.fn_hideAndShow = function($p, strBtn, GroupBox) {
	var objBtn = $p.getComponentById(strBtn);
	var objGroupBox = $p.getComponentById(GroupBox);
	var sTxt = objBtn.getValue();
	if (sTxt == "‘ê¸°") {
		objGroupBox.hide();
		objBtn.setValue("´ê¸°");
		objBtn.addClass("close");
	} else if (sTxt == "´ê¸°") {
		objGroupBox.show();
		objBtn.setValue("‘ê¸°");
		objBtn.removeClass("close");
	}
};

comLib.radioBtn = function($p) {
	$p.$(".first").on("on1", function() {
		$p.$(".first > ul").addClass("radio-on");
	});
	$p.$(".first").trigger("on1");
	$p.$(".radio-btn-group > a").click(function() {1
		$(this).parent().siblings().find("ul.depth2").hide(100);
		$(this).parent().siblings().find("a.on").removeClass("on");
		$(this).addClass("on");
		return false;
	});
};

comLib.starBtn = function() {
	$p.$(".star-point > dl > dd > div a:nth-child(1)").click(function() {
		$(this).parent().parent().parent().parent().removeClass("star2");
		$(this).parent().parent().parent().parent().removeClass("star3");
		$(this).parent().parent().parent().parent().removeClass("star4");
		$(this).parent().parent().parent().parent().removeClass("star5");
		$(this).parent().parent().parent().parent().addClass("star1");
		return false;
	});
	$p.$(".star-point > dl > dd > div a:nth-child(2)").click(function() {
		$(this).parent().parent().parent().parent().removeClass("star1");
		$(this).parent().parent().parent().parent().removeClass("star3");
		$(this).parent().parent().parent().parent().removeClass("star4");
		$(this).parent().parent().parent().parent().removeClass("star5");
		$(this).parent().parent().parent().parent().addClass("star2");
		return false;
	});
	$p.$(".star-point > dl > dd > div a:nth-child(3)").click(function() {
		$(this).parent().parent().parent().parent().removeClass("star2");
		$(this).parent().parent().parent().parent().removeClass("star1");
		$(this).parent().parent().parent().parent().removeClass("star4");
		$(this).parent().parent().parent().parent().removeClass("star5");
		$(this).parent().parent().parent().parent().addClass("star3");
		return false;
	});
	$p.$(".star-point > dl > dd > div a:nth-child(4)").click(function() {
		$(this).parent().parent().parent().parent().removeClass("star2");
		$(this).parent().parent().parent().parent().removeClass("star3");
		$(this).parent().parent().parent().parent().removeClass("star1");
		$(this).parent().parent().parent().parent().removeClass("star5");
		$(this).parent().parent().parent().parent().addClass("star4");
		return false;
	});
	$p.$(".star-point > dl > dd > div a:nth-child(5)").click(function() {
		$(this).parent().parent().parent().parent().removeClass("star2");
		$(this).parent().parent().parent().parent().removeClass("star3");
		$(this).parent().parent().parent().parent().removeClass("star4");
		$(this).parent().parent().parent().parent().removeClass("star1");
		$(this).parent().parent().parent().parent().addClass("star5");
		return false;
	});
};

comLib.anchorBtn = function($p) {
	$p.$(".anchor-box > ul > li:nth-child(1) > .w2anchor2").click(function() {
		$(".anchor-box > ul > li:nth-child(1)").addClass("chk");
		$(".anchor-box > ul > li:nth-child(2)").removeClass("chk");
		$(".anchor-box > ul > li:nth-child(3)").removeClass("chk");
		$(".anchor-box > ul > li:nth-child(4)").removeClass("chk");
	});
	$p.$(".anchor-box > ul > li:nth-child(2) > .w2anchor2").click(function() {
		$(".anchor-box > ul > li:nth-child(2)").addClass("chk");
		$(".anchor-box > ul > li:nth-child(1)").removeClass("chk");
		$(".anchor-box > ul > li:nth-child(3)").removeClass("chk");
		$(".anchor-box > ul > li:nth-child(4)").removeClass("chk");
	});
	$p.$(".anchor-box > ul > li:nth-child(3) > .w2anchor2").click(function() {
		$(".anchor-box > ul > li:nth-child(3)").addClass("chk");
		$(".anchor-box > ul > li:nth-child(1)").removeClass("chk");
		$(".anchor-box > ul > li:nth-child(2)").removeClass("chk");
		$(".anchor-box > ul > li:nth-child(4)").removeClass("chk");
	});
	$p.$(".anchor-box > ul > li:nth-child(4) > .w2anchor2").click(function() {
		$(".anchor-box > ul > li:nth-child(4)").addClass("chk");
		$(".anchor-box > ul > li:nth-child(1)").removeClass("chk");
		$(".anchor-box > ul > li:nth-child(2)").removeClass("chk");
		$(".anchor-box > ul > li:nth-child(3)").removeClass("chk");
	});
};

// TODO: 04 ”ê˜ì •
comLib.gisBtnResize = function() {
	$(window).resize(function() {
		$(".wrap .content-area").css("padding-bottom", $(".footer .btn-group").height() + 10);
	});
};

// –‰¤í¬½íŠ¸ comLib.runCmmnEvent´ê(help œì™¸)
// scwin.heightSam();
// scwin.toggleBtn();
// scwin.toggledetailBtn();
// scwin.slideBtn();
// scwin.toggleBtn2();
// scwin.slideBtn2();
// scwin.radioBtn();
// scwin.starBtn();
// scwin.anchorBtn();

comLib.runCmmnEvent = function($p) {
	comLib.heightSam($p);
	comLib.toggleBtn($p);
	comLib.toggledetailBtn($p);
	comLib.slideBtn($p);
	comLib.toggleBtn2($p);
	comLib.slideBtn2($p);
	comLib.radioBtn($p);
	comLib.starBtn($p);
	comLib.anchorBtn($p);
};

// ”ì€˜ì •(navigator.xml script ì—­´ê - 

comLib.runHandyGian = function(infofileName, approvalNum, gianParam, atchFile, targetFolder) {
	var fold;
	var fc;
	var nf;

	var handyGwBaseDir 		= "[HANDYSOFT_BIN_PATH]";
	var handybasicfolder 	= "[HANDYSOFT_HOME]";

	var approvalFolder 		= handybasicfolder + targetFolder + "\\" ;
	var f_infofileName 		=  infofileName + ".txt" ;

	var appInfoFileName 	= handyGwBaseDir + f_infofileName;
	var attfileName 	= approvalFolder + infofileName + "Attach.ini";

	var fso = new ActiveXObject("Scripting.FileSystemObject");

	if (!fso.FolderExists(approvalFolder)) {
		fold 	= fso.GetFolder(handybasicfolder);
		fc 		= fold.SubFolders;
		nf 		= fc.Add(targetFolder);
	}

	if (!fso.FileExists(appInfoFileName)) {
		fso.CreateTextFile(appInfoFileName, true);
	} else {
		fso.DeleteFile(appInfoFileName, true);
		fso.CreateTextFile(appInfoFileName, true);
	}

	var objbName = Object.getOwnPropertyNames(gianParam);

	var f = fso.OpenTextFile(appInfoFileName, 2, true);
	f.WriteLine("");

	for (var key in gianParam) {
		//console.log(key, gianParam[key]);
		f.WriteLine(gianParam[key]) ;
	}

	f.close();
	if (atchFile.length > 0) {
		//console.log("¨ëŒì¼ ˆìŒ");
		if (!fso.FileExists(attfileName)) {
			fso.CreateTextFile(attfileName, true);
		}
		var att = fso.OpenTextFile(attfileName, 2, true);
		att.WriteLine("");
		att.WriteLine("[attach]");
		att.WriteLine("attach.cnt=" + atchFile.length);

		for (var i =0; i < atchFile.length; i++) {
			var atchfId 		= atchFile[i].atchfId || atchFile[i].atchflId;
			var fileSeq 		= atchFile[i].fileSeq;
			var orgFileName 	= atchFile[i].orgFileName || atchFile[i].orginlFileNm;
			orgFileName 		= orgFileName.replace(/\s+/g,'_');
			var file_protocol 	= window.location.protocol;
			var file_hostNmae 	= window.location.hostname;

			var file_localDownLoadUril = "\"" + file_protocol + "//" + file_hostNmae + "/eai/downLoadToLocal.do?atchfId=" + atchfId + "&fileSeq=" + fileSeq + "\""; // œìŠ¤œë§ˆì´

			var WshShell2 = new ActiveXObject("WScript.Shell");
			WshShell2.Run("[HANDYSOFT_EXEC_PATH] " + file_localDownLoadUril + " " + targetFolder + " " + orgFileName, 0, true);

			att.WriteLine("attach." + i + "="+ approvalFolder + orgFileName);
		}
		att.close();
		//console.log("¨ëŒì¼ ini Œì¼ ì„±");
		var WshShell = new ActiveXObject("WScript.Shell");
		WshShell.Run(handyGwBaseDir + "HDSubD32 M " + approvalNum + " " + appInfoFileName + " /Attach:" + attfileName, 0, true);
	} else {
		var WshShell = new ActiveXObject("WScript.Shell");
		WshShell.Run(handyGwBaseDir + "HDSubD32 M " + approvalNum + " " + appInfoFileName);
	}
};

/**
 * „ì²´”ë‰´ ?€ ?¬ìš©¬ë ´í¬
 */
comLib.initAllMenu = function() {
	if (comLib.arrLeftMenuAll.length == 0) {
		// ¨ë“  ”ë‰´ ?€		comLib.arrLeftMenuAll = $p.top().wfm_left.getWindow().dltLeftMenuList.getAllJSON();
		// ?¬ìš©¬ë "Y" ´ì´„ë¡ ìš©.
		$p.top().wfm_left.getWindow().dltLeftMenuList.setColumnFilter( { type : "row" , colIndex : "useYn" , key : "Y" , condition : "and" , exactMatch : true } );
	}
};

/**
 * ”ë‰´ ¹„Œì´€ */
comLib.getMenuNavi = function(scrinId) {
	// ”ë©´ID, ”ë‰´ID„í„°í•œ
	var menuList = comLib.arrLeftMenuAll.filter(comLib.menuNaviFilter, scrinId);

	if (menuList.length > 0) {
		// °ê³¼€ ˆìœ¼«ë²ˆ”ë‰´¬ìš©œë‹¤.
		if (menuList[0].menuLvl > 1) {
			// œìƒ”ë‰´€ „ë‹ˆìœ„ ”ë‰´°íšŒ˜ì—¬ „ì¬ ”ë‰´ ì— ™ì¸
			return comLib.getMenuNavi(menuList[0].upperMenuId) + " &gt; " + menuList[0].menuNm;
		} else {
			// œìƒ”ë‰´”ë‰´…ë§Œ ›ëŠ”
			return menuList[0].menuNm;
		}
	} else {
		// €‰ê²°¼ê †ìœ¼’ì„ ´ë‚¸
		return "";
	}
};

/**
* ”ë‰´ ¹„Œì´€„í„°
*/
comLib.menuNaviFilter = function(menu) {
	if (menu == null) {
		return false;
	}
	// €‰í•  „ë“œ€ †ìœ¼€œì™¸
	if (menu.menuId == null || menu.scrinId == null) {
		return false;
	}

	var id = this.toString();

	if (id == "") {
		return false;
	}

	// ”ë‰´ID, ”ë©´ID, ”ë‰´…ìœ¼€	if (menu.menuId == id || menu.scrinId == id || menu.menuNm == id) {
		return true;
	} else {
		return false;
	}
};

/**
* ¼ìª½”ë‰´ €??*/
comLib.searchMenu = function() {
	var searchWord = $p.top().wfm_left.getWindow().ibxMenuSearch.getValue();

	comLib.initAllMenu();

	if (searchWord == null || searchWord == "") {
		// ìƒœë¡œ µêµ¬
		$p.top().wfm_left.getWindow().dltLeftMenuList.setJSON(comLib.arrLeftMenuAll);
		// ?¬ìš©¬ë "Y" ´ì„
		$p.top().wfm_left.getWindow().dltLeftMenuList.setColumnFilter( { type : "row" , colIndex : "useYn" , key : "Y" , condition : "and" , exactMatch : true } );
	} else {
		// €‰í•  ©ë¡€¸ì˜¨ (Arrayì„œ Arrayµì‚¬˜ë©´ ì²´€ °ê²°˜ì–´ ”ë‰´€ ™ì´ ˜ì •˜ëDeep µì‚¬œë‹¤.)
		var searchList = $.extend(true, [], comLib.arrLeftMenuAll);

		// ”ë‰´ €		searchList = searchList.filter(comLib.searchMenuFilter, searchWord);

		// œìƒ€???€´í
		searchList.unshift({
			menuId : "SEARCHRESULT",
			menuNm : "€‰ê²°,
			menuLvl : 1,
			menuOrdr : 0,
			menuSysDivCd : comLib.getSysDivCd()
		});

		$p.top().wfm_left.getWindow().dltLeftMenuList.setJSON(searchList);
		$p.top().wfm_left.getWindow().trvMenu.spanAll(true);
	}
};

/**
* ¼ìª½”ë‰´ €„í„°
*/
comLib.searchMenuFilter = function(menu) {
	if (menu == null) {
		return false;
	}
	// ”ë©´ ½ë¡œ€ †ìœ¼€œì™¸
	if (menu.scrinUrl == null || menu.scrinUrl == "") {
		return false;
	}

	var searchWord = this.toString();

	if (searchWord == "") {
		return false;
	}
	// ?¬ìš©¬ë?€ „ë‹ˆ€œì™¸
	if (menu.useYn == "N") {
		return false;
	}
	// €‰í•  „ë“œ€ †ìœ¼€œì™¸
	if (menu.menuId == null || menu.menuNm == null || menu.menuDc == null || menu.menuExecutYn == null) {
		return false;
	}
	// ”ë©´†ìœ¼€œì™¸
	if (menu.menuExecutYn == "N") {
		return false;
	}
	// ”ë‰´ID, ”ë‰´ ”ë‰´¤ëª…¼ë¡œ €	if (menu.menuId.indexOf(searchWord) != -1 || menu.menuNm.indexOf(searchWord) != -1 || menu.menuDc.indexOf(searchWord) != -1) {
		menu.menuLvl = 2;
		return true;
	} else {
		return false;
	}
};

// left”ë‰´ëµí†µ
// …ë¬´”ë‰´ì„œ ì ‘¸ì¶œŒì‹œì„ …ë¥˜¬ë¶„Œì‹œì¡°??comLib.PAGE_SIZE = 8;
comLib.PAGE_QNA_SIZE = 5;
comLib.NTT_ID = "";
comLib.NTT_NO = "";
comLib.USR_FRST_REGIST_YN = "";

comLib.initBoard = function($p, callParm) {
	var callParmArr = callParm.split(",");
	if (callParmArr.length > 2) {
		var type = callParmArr[1];
		comLib.NTT_ID = callParmArr[2];
		if (callParmArr.length == 4) {
			comLib.NTT_NO = callParmArr[3];
		}
		if (type == "03") {
			wframeLeft.setSrc("/ui/common/content_qna.xml");
			$(".nav-board.qna").addClass("board-on");
			comLib.initQan($p);
		} else {
			wframeLeft.setSrc("/ui/common/content_ntt.xml");
			$(".nav-board.faq").addClass("board-on");
			comLib.initNtt($p, type);
		}
	}
};

// left”ë‰´ëµí†µ
// •ë¦¬¼ì„”ê
comLib.initNtt = function($p, type) {
	var wframeLeft = $p.top().wframeLeft.getWindow();

	comLib.initForm($p, "content_ntt");
	if (type == "04") {
		wframeLeft.nttType.setLabel( "FAQ" );
	} else if (type == "03") {
		wframeLeft.nttType.setLabel( "QnA" );
	} else if (type == "01") {
		wframeLeft.nttType.setLabel( "µì¬í•­" );
	} else if (type == "02") {
		wframeLeft.nttType.setLabel( "ë£Œ );
	}
	$("table.creat").removeClass("table-on");
	$("table.view").removeClass("table-on");
	wframeLeft.nttList.render.innerHTML = "";
	utilLib.clearDcObj(wframeLeft.dmaNttMt);
	utilLib.clearDcObj(wframeLeft.dltNttList);
	utilLib.clearDcObj(wframeLeft.dltBbsClsCd);
	utilLib.clearDcObj(wframeLeft.dltNttMng);
	wframeLeft.dmaNttMng.set("sysDivCd" , comLib.getSysDivCd());
	//wframeLeft.dmaNttMng.set("sysDivCd" , "WRO");
	wframeLeft.dmaNttMng.set("bbsAtrbCd" , type);
	comLib.retrieveNttMngList($p);
};

//Œì‹œ©ë¡
comLib.retrieveNttMngList = function($p) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	var requestData = {};
	requestData.dmaBbsMngBasic = wframeLeft.dmaNttMng.getJSON();

	var option = {
		action : "/sc/bbsMng/getBbsList.do",
		reqData : requestData,
		resData : wframeLeft.dltNttMng,
		success : "comLib.retrieveNttMngListCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

// Œì‹œ©ë¡Callback
comLib.retrieveNttMngListCallback = function() {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	wframeLeft.$p.$("#grpNavId").mCustomScrollbar({
		axis : "yx",
		theme : "minimal",
		setHeight : parseInt($(".nav-board").css("height").replace("px", "")) - 80
	});
	wframeLeft.$p.$("#grpNavId").mCustomScrollbar().css("height", parseInt($(".nav-board").css("height").replace("px", "")) - 80);
	wframeLeft.dltNttMng.setColumnFilter( { type : "row" , colIndex : "useYn" , key : "Y" , condition : "and" , exactMatch : true } );
	var str = [];
	str.push("<ul class=\"w2group\">");
	for(var i=0; i < wframeLeft.dltNttMng.getRowCount(); i++) {
		str.push("<li id=\"listLi_" + wframeLeft.dltNttMng.getCellData(i, "bbsId" ) + "\"  class=\"w2group child-none\">");
		str.push("<a class=\"w2anchor2 d1\" href=\"javascript:comLib.selectNttMng('" + wframeLeft.dltNttMng.getCellData(i, "bbsId" ) + "','0','" + wframeLeft.dltNttMng.getCellData(i, "usrFrstRegistYn") + "');\">");
		str.push(wframeLeft.dltNttMng.getCellData(i, "bbsNm"));
		str.push("</a>");
		str.push("</li>");
	}
	str.push("</ul>");
	wframeLeft.navId.render.innerHTML = str.join("");
	if (wframeLeft.dltNttMng.getRowCount() > 0) {
		if (comLib.NTT_ID != "") {
			comLib.selectNttMng(comLib.NTT_ID ,0,"N");
		} else {
			comLib.selectNttMng(wframeLeft.dltNttMng.getCellData(0, "bbsId"), 0, wframeLeft.dltNttMng.getCellData(0, "usrFrstRegistYn"));
		}
	}
};

//Œì‹œ©ë¡
comLib.selectNttMng = function(bbsId, cnt, usrFrstRegistYn) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	wframeLeft.txtNttNo.setValue(bbsId);
	comLib.NTT_ID = bbsId;
	comLib.USR_FRST_REGIST_YN = usrFrstRegistYn;
	if (cnt == "0") {
		utilLib.clearDcObj(wframeLeft.dltNttList);
	}
	$(".w2group").removeClass("active");
	eval("listLi_" + bbsId).classList.add("active");
	// $("#listLi_" + bbsId).classList.add("active");
	$("table.creat").removeClass("table-on");
	$("table.view").removeClass("table-on");
	wframeLeft.$p.$("#grpNttList").mCustomScrollbar({
		axis : "yx",
		theme : "minimal",
		setHeight : parseInt($(".nav-board").css("height").replace("px", "")) - 80
	});
	wframeLeft.$p.$("#grpNttList").mCustomScrollbar().css("height",parseInt($(".nav-board").css("height").replace("px", "")) - 80);
	wframeLeft.$p.$("#grpNttCnt").mCustomScrollbar({
		axis : "yx",
		theme : "minimal",
		setHeight : parseInt($(".nav-board").css("height").replace("px", "")) - 200
	});
	wframeLeft.$p.$("#grpNttCnt").mCustomScrollbar().css("height", parseInt($(".nav-board").css("height").replace("px", "")) - 200);

	wframeLeft.grpNttCnt.parentControl.childControlList["0"].childControlList["0"].setStyle("width", "100%");

	var dltNttMngJson =  wframeLeft.dltNttMng.getMatchedJSON("bbsId", bbsId, true, 0, wframeLeft.dltNttMng.getRowCount());

	if (dltNttMngJson.length > 0) {
		var nttTit = "";
		var korname = "";

		if (wframeLeft.sbxSearchTyCd.getValue() == "01") {
			nttTit = wframeLeft.inputNttSearch.getValue();
		}
		if (wframeLeft.sbxSearchTyCd.getValue() == "02") {
			korname = wframeLeft.inputNttSearch.getValue();
		}

		if (dltNttMngJson[0].bbsStatCd == "01") {
			wframeLeft.ntfDe.show();
		} else {
			wframeLeft.ntfDe.hide();
		}

		// comLib.NTT_ID = dltNttMngJson[0].bbsId;
		wframeLeft.dmaNttMt.set("bbsId", dltNttMngJson[0].bbsId);
		wframeLeft.dmaNttMt.set("sysDivCd", dltNttMngJson[0].sysDivCd);

		var requestData = {};
		requestData.data = {
			bbsId : dltNttMngJson[0].bbsId,
			"nttTit" : nttTit,
			"korname" : korname,
			rnum : cnt,
			totalCount : cnt,
			pageSize : comLib.PAGE_SIZE
		};
		var option = {
			action : "/sc/ntt/retrieveNtt.do",
			reqData : requestData,
			resData : "",
			success : "comLib.selectNttMngCallback",
			isShowMeg : false
		};
		ajaxLib.executeAjax(wframeLeft.$p, option);
	}
};

/**
 * Œì‹œ°íšŒœë°± œì§˜í–‰œë‹¤.
 */
comLib.selectNttMngCallback = function(resBody) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	if (resBody.message.code == "success") {
		wframeLeft.dltNttList.setJSON(resBody.data , true); // append data
		if (wframeLeft.dltNttList.getRowCount() > 0) {
			wframeLeft.txtCnt.setValue(wframeLeft.dltNttList.getRowCount());
			var str = [];
			if (wframeLeft.dltNttList.getRowCount() < resBody.dltNttListCount) {
				wframeLeft.btnAddList.show();
			} else {
				wframeLeft.btnAddList.hide();
			}
			str.push("<ul id=\"nttUl\" class=\"w2group \">");
			for (var i = 0; i < wframeLeft.dltNttList.getRowCount(); i++) {
				// pined,file,active
				var liClass = '<li id=\"nttLi_' + wframeLeft.dltNttList.getCellData(i, "nttNo") + '\" class="\w2group nttlist';
				if (wframeLeft.dltNttList.getCellData(i, "priorNttYn") == "Y") {
					liClass += " pined";
				}
				if (wframeLeft.dltNttList.getCellData(i, "atchflId") != "") {
					liClass += " file";
				}
				str.push(liClass + '\">');
				str.push("<div class='w2anchor '>");
				str.push("<a href=\"javascript:" + comLib.getFrameId(wframeLeft.$p) + "scwin.selectNtt('" + wframeLeft.dltNttList.getCellData(i, "nttNo") + "');\">");
				if (wframeLeft.dltNttList.getCellData(i, "nttClsNm1") != "") {
					str.push("["+wframeLeft.dltNttList.getCellData(i, "nttClsNm1")+"]   ");
				}
				str.push(wframeLeft.dltNttList.getCellData(i, "nttTit"));
				str.push("</a>");
				str.push("</div>");
				str.push("<span class='w2span name'>" + wframeLeft.dltNttList.getCellData(i, "korname") + " ??" + wframeLeft.dltNttList.getCellData(i, "dept") + " ??"
					+ wframeLeft.dltNttList.getCellData(i, "frstRegistDt") + "°íšŒ" + wframeLeft.dltNttList.getCellData(i, "nttRdcnt") + "</span>");
				str.push("<span class='w2span num'>" + wframeLeft.dltNttList.getCellData(i, "nttOdrd") + "</span>");
				str.push("</li>");
			}
			str.push("</ul>");
			wframeLeft.nttList.render.innerHTML = str.join("");
		} else {
			wframeLeft.txtCnt.setValue(0);
			wframeLeft.nttList.render.innerHTML = "";
			wframeLeft.btnAddList.hide();
		}

		if (comLib.NTT_ID != ""){
			comLib.selectNttCdList(comLib.NTT_ID);
			comLib.selectAdminBtn(comLib.NTT_ID);
			// comLib.NTT_ID = "";
		}
		if (comLib.NTT_NO !="") {
			wframeLeft.scwin.selectNtt(comLib.NTT_NO);
		} else {
			if (wframeLeft.dltNttList.getRowCount() > 0) {
				wframeLeft.scwin.selectNtt(wframeLeft.dltNttList.getCellData(0, "nttNo"));
			}
		}
		comLib.NTT_ID = "";
		comLib.NTT_NO = "";
	}
};

comLib.selectNttCdList = function(bbsId) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	var requestData = {};
	var dltNttMngJson =  wframeLeft.dltNttMng.getMatchedJSON("bbsId", bbsId, true, 0, wframeLeft.dltNttMng.getRowCount());
	var clsCd = "";
	if (dltNttMngJson.length > 0) {
		clsCd = dltNttMngJson[0].bbsClsCd1;
		if (clsCd != "") {
			requestData.data = {
				"sysDivCd" : comLib.getSysDivCd(),
				"clsCd":clsCd
			};
			wframeLeft.sbxNttClsCd1.show();
			var option = {
				action : "/sc/ntt/selectNttCdList.do",
				reqData : requestData,
				resData : wframeLeft.dltBbsClsCd,
				success : "",
				isShowMeg : false
			};
			ajaxLib.executeAjax(wframeLeft.$p, option);
		} else {
			wframeLeft.sbxNttClsCd1.hide();
		}
	}
};

// Œì‹œ©ë¡
comLib.selectAdminBtn = function(row) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	var requestData = {};
	var option = {
		action : "/sc/admin/retrieveNttAdminList.do",
		reqData : requestData,
		resData : "",
		success : "comLib.selectAdminBtnCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax(wframeLeft.$p, option);
};

// Œì‹œ©ë¡
comLib.selectAdminBtnCallback = function(resBody) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	if (resBody.message.code == "success") {
		if (resBody.data.length > 0 && comLib.USR_FRST_REGIST_YN =="Y") {
			wframeLeft.btn_nttCreate.show("");
			// nttViewGroup.show("");
		} else if (resBody.data.length > 0) {
			// btn_nttCreate.show();
			// nttViewGroup.show();
		} else if (comLib.USR_FRST_REGIST_YN =="Y") {
			wframeLeft.btn_nttCreate.show("");
			// nttViewGroup.show("");
		} else {
			// ¼ë°˜¬ìš©€ ±ë¡ ìˆ˜ †ìœ¼±ë¡ „íŠ¼ ?¨ê
			if (comLib.USR_FRST_REGIST_YN == "N") {
				wframeLeft.btn_nttCreate.hide();
				wframeLeft.nttViewGroup.hide();
			}
		}
	}
};

comLib.selectAdminQna = function(bbsId) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	var requestData = {};
	// requestData.data = {"bbsId":bbsId};

	var option = {
		action : "/sc/admin/retrieveNttAdminList.do",
		reqData : requestData,
		resData : "",
		success : "comLib.selectAdminQnaCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax(wframeLeft.$p, option);
};

// Œì‹œ©ë¡
comLib.selectAdminQnaCallback = function(resBody) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	if (resBody.message.code == "success") {
		if (resBody.data.length > 0) {
			wframeLeft.groRepal.show("table-row");
		} else {
			wframeLeft.groRepal.hide();
		}
	}
};

comLib.initQan = function($p) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	comLib.initForm($p, "content_qna");
	$("table.creat").removeClass("table-on");
	$("table.view").removeClass("table-on");

	utilLib.clearDcObj(wframeLeft.dltQnaMng);
	utilLib.clearDcObj(wframeLeft.dltQnaList);
	utilLib.clearDcObj(wframeLeft.dltQnaReplaList);
	utilLib.clearDcObj(wframeLeft.dltQnaBbsClsCd);
	wframeLeft.dmaQnaMng.set("sysDivCd", comLib.getSysDivCd());
	wframeLeft.dmaQnaMng.set("bbsAtrbCd", "03" );
	comLib.retrieveQnaList($p);
};

comLib.retrieveQnaList = function($p) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	var requestData = {};
	requestData.dmaBbsMngBasic = wframeLeft.dmaQnaMng.getJSON();

	var option = {
		action : "/sc/bbsMng/getBbsList.do",
		reqData : requestData,
		resData : wframeLeft.dltQnaMng,
		success : "comLib.retrieveQnaListCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

comLib.retrieveQnaListCallback = function() {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	wframeLeft.dltQnaMng.setColumnFilter( { type : "row" , colIndex : "useYn" , key : "Y" , condition : "and" , exactMatch : true } );
	var str = [];
	str.push("<ul class=\"w2group\">");
	for (var i=0; i < wframeLeft.dltQnaMng.getRowCount(); i++) {
		str.push("<li id=\"listQnaLi_" + wframeLeft.dltQnaMng.getCellData(i, "bbsId" ) + "\"  class=\"w2group child-none\">");
		str.push("<a class=\"w2anchor2 d1\" href=\"javascript:comLib.choiseQna('" + wframeLeft.dltQnaMng.getCellData(i, "bbsId" ) + "' , 0);\">");
		str.push(wframeLeft.dltQnaMng.getCellData( i , "bbsNm" ));
		str.push("</a>");
		str.push("</li>");
	}
	str.push("</ul>");
	wframeLeft.qnaList.render.innerHTML = str.join("");

	if (wframeLeft.dltQnaMng.getRowCount() > 0) {
		if (comLib.NTT_ID != "") {
			comLib.choiseQna(comLib.NTT_ID, 0);
		} else {
			comLib.choiseQna(wframeLeft.dltQnaMng.getCellData(0, "bbsId" ), 0);
		}
	}
};

comLib.choiseQna = function(bbsId, cnt) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	comLib.NTT_ID = bbsId;
	wframeLeft.txtQnaNo.setValue(bbsId);
	if (cnt == "0") {
		utilLib.clearDcObj(wframeLeft.dltQnaList);
		utilLib.clearDcObj(wframeLeft.dltQnaReplaList);
	}
	$(".w2group").removeClass("active");
	eval("listQnaLi_" + bbsId).classList.add("active");
	$("table.creat").removeClass("table-on");
	$("table.view").removeClass("table-on");
	utilLib.clearDcObj(wframeLeft.dmaQnaMt);

	wframeLeft.$p.$("#grpNttQnAList").mCustomScrollbar({
		axis : "yx",
		theme : "minimal",
		setHeight : parseInt($(".nav-board").css("height").replace("px", "")) - 80
	});
	wframeLeft.$p.$("#grpNttQnAList").mCustomScrollbar().css("height", parseInt($(".nav-board").css("height").replace("px", "")) - 80);
	wframeLeft.$p.$("#grpNttQnaCnt").mCustomScrollbar({
		axis : "yx",
		theme : "minimal",
		setHeight : parseInt($(".nav-board").css("height").replace("px", "")) - 400
	});
	wframeLeft.$p.$("#grpNttQnaCnt").mCustomScrollbar().css("height", parseInt($(".nav-board").css("height").replace("px", "")) - 400);

	wframeLeft.grpNttQnaCnt.parentControl.childControlList["0"].childControlList["0"].setStyle("width", "100%");

	wframeLeft.$p.$("#grpNttQnaRepla").mCustomScrollbar({
		axis : "yx",
		theme : "minimal",
		setHeight : parseInt($(".nav-board").css("height").replace("px", "")) - 700
	});
	wframeLeft.$p.$("#grpNttQnaRepla").mCustomScrollbar().css("height",parseInt($(".nav-board").css("height").replace("px", "")) - 700);

	wframeLeft.grpNttQnaRepla.parentControl.childControlList["0"].childControlList["0"].setStyle("width", "100%");

	var dltQnaMngJson = wframeLeft.dltQnaMng.getMatchedJSON("bbsId", bbsId, true, 0, wframeLeft.dltQnaMng.getRowCount());

	if (dltQnaMngJson.length > 0) {
		var nttTit = "";
		var korname = "";

		if (wframeLeft.sbxSearchTyCd.getValue() == "01") {
			nttTit = wframeLeft.inputNttSearch.getValue();
		}
		if (wframeLeft.sbxSearchTyCd.getValue() == "02") {
			korname = wframeLeft.inputNttSearch.getValue();
		}

		wframeLeft.dmaQnaMt.set("bbsId", dltQnaMngJson[0].bbsId);
		wframeLeft.dmaQnaMt.set("sysDivCd", dltQnaMngJson[0].sysDivCd);
		var requestData = {};
		requestData.data = {
			bbsId : dltQnaMngJson[0].bbsId,
			"nttTit" : nttTit,
			"korname" : korname,
			rnum : cnt,
			totalCount : cnt,
			pageSize : comLib.PAGE_QNA_SIZE
		};

		var option = {
			action : "/sc/ntt/retrieveQnaNtt.do",
			reqData : requestData,
			resData : "",
			success : "comLib.choiseQnaCallback",
			isShowMeg : false
		};
		ajaxLib.executeAjax(wframeLeft.$p, option);
	}
};

/**
 * Œì‹œ°íšŒœë°± œì§˜í–‰œë‹¤.
 */
comLib.choiseQnaCallback = function(resBody) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	if (resBody.message.code == "success") {
		wframeLeft.dltQnaList.setJSON(resBody.dltQnaList, true); // append data
		wframeLeft.dltQnaReplaList.setJSON(resBody.dltQnaReplaList, true); // append data

		var dltQnaMngJson = wframeLeft.dltQnaMng.getMatchedJSON("bbsId", comLib.NTT_ID, true, 0, wframeLeft.dltQnaMng.getRowCount());

		if (dltQnaMngJson.length > 0) {
			if (dltQnaMngJson[0].prcsStatUseYn =="L") {
				wframeLeft.btn_qnaCreate.hide();
			} else {
				wframeLeft.btn_qnaCreate.show("inline-block");
			}
		}
		if (wframeLeft.dltQnaList.getRowCount() > 0) {
			wframeLeft.txtCnt.setValue(wframeLeft.dltQnaList.getRowCount());
			if (wframeLeft.dltQnaList.getRowCount() < resBody.dltQnaListCount) {
				wframeLeft.btnQnaAddList.show();
			} else {
				wframeLeft.btnQnaAddList.hide();
			}
			var str = [];
			for (var i = 0; i < wframeLeft.dltQnaList.getRowCount(); i++) {
				str.push("<div class=\"w2group text-group\">");
				str.push("<ul class=\"w2group \">");
				str.push("<li class=\"w2group \">");
				str.push("<div class=\"w2group talk\">");
				str.push("<a href=\"javascript:" + comLib.getFrameId(wframeLeft.$p) + "scwin.selectQna('" + wframeLeft.dltQnaList.getCellData(i, "nttNo") + "');\" class=\"w2anchor2 \">");
				if (wframeLeft.dltQnaList.getCellData(i, "nttClsNm1") != "") {
					str.push("["+wframeLeft.dltQnaList.getCellData(i, "nttClsNm1")+"]   ");
				}
				str.push(wframeLeft.dltQnaList.getCellData(i, "nttTit"));
				str.push("</a>");
				str.push("<div class=\"w2group user\">");
				str.push("<img src=\"/resources/images/common/pic-c-qa.png\" class=\"w2image \">");
				str.push("<span class=\"w2span name\">" + wframeLeft.dltQnaList.getCellData(i, "korname") + " ??" + wframeLeft.dltQnaList.getCellData(i, "dept") + " ??" + wframeLeft.dltQnaList.getCellData(i, "posit") + "</span>");
				str.push("<span class=\"w2span day\">" + wframeLeft.dltQnaList.getCellData(i, "frstRegistDt") + "</span>");
				str.push("</div>");
				str.push("</div>");
				str.push("</il>");
				var dltQnaJson = wframeLeft.dltQnaReplaList.getMatchedJSON("parntsNttNo", wframeLeft.dltQnaList.getCellData(i, "nttNo"), true, 0, wframeLeft.dltQnaReplaList.getRowCount());
				if (wframeLeft.dltQnaReplaList.getMatchedJSON("parntsNttNo", wframeLeft.dltQnaList.getCellData(i, "nttNo"), true, 0, wframeLeft.dltQnaReplaList .getRowCount()) == "") {
					str.push("<li class=\"w2group de\">");
					str.push("<div class=\"w2group \">");
					str.push("<span class=\"w2span \">µë ?€°ì¤‘…ë‹ˆ</span>");
					str.push("<a class=\"w2anchor2 \" href=\"javascript:" + comLib.getFrameId(wframeLeft.$p) + "scwin.selectQna('" + wframeLeft.dltQnaList.getCellData(i, "nttNo") + "');\">µë˜ê¸°</a>");
					str.push("</div>");
					str.push("</il>");
				} else {
					str.push("<li class=\"w2group re\">");
					for (var y = 0; y < dltQnaJson.length; y++) {
						str.push("<div class=\"w2group \">");
						str.push("<a class=\"w2anchor2 \" href=\"javascript:" + comLib.getFrameId(wframeLeft.$p) + "scwin.selectQna('" + wframeLeft.dltQnaList.getCellData(i, "nttNo") + "');\" class=\"w2anchor2 \">");
						str.push(dltQnaJson[y].nttCtnt);
						str.push("</a>");
						str.push("<div class=\"w2group user\">");
						str.push("<span class=\"w2span name\">" + dltQnaJson[y].korname + " ??" + dltQnaJson[y].dept + " ??" + dltQnaJson[y].posit + "</span>");
						str.push("<span class=\"w2span day\">" + dltQnaJson[y].frstRegistDt + "</span>");
						str.push("</div>");
						str.push("</div>");
					}
					str.push("</li>");
				}
				str.push("</ui>");
				str.push("</div>");
			}
			wframeLeft.qnaDetail.render.innerHTML = str.join("");

			if (comLib.NTT_NO != "") {
				wframeLeft.scwin.selectQna(comLib.NTT_NO);
			} else {
				if (wframeLeft.dltQnaList.getRowCount() > 0) {
					wframeLeft.scwin.selectQna(wframeLeft.dltQnaList.getCellData(0, "nttNo"));
				}
			}
		} else {
			wframeLeft.txtCnt.setValue(0);
			wframeLeft.qnaDetail.render.innerHTML = "";
			wframeLeft.btnQnaAddList.hide();
		}
		if (comLib.NTT_ID != "") {
			comLib.selectQanCdList(comLib.NTT_ID);
			comLib.selectAdminQna(comLib.NTT_ID);
			// comLib.NTT_ID="";
		}
		comLib.NTT_ID = "";
		comLib.NTT_NO = "";
	} else {
		alert("fail");
	}
};

comLib.selectQanCdList = function(bbsId) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	var requestData = {};
	var dltQnaMngJson = wframeLeft.dltQnaMng.getMatchedJSON("bbsId", bbsId, true, 0, wframeLeft.dltQnaMng.getRowCount());
	var clsCd = "";
	if (dltQnaMngJson.length > 0) {
		clsCd = dltQnaMngJson[0].bbsClsCd1;
		if (clsCd != "") {
			requestData.data = {
				"sysDivCd":comLib.getSysDivCd(),
				"clsCd":clsCd
			};
			wframeLeft.sbxQnaClsCd1.show();
			var option = {
				action : "/sc/ntt/selectNttCdList.do",
				reqData : requestData,
				resData : wframeLeft.dltQnaBbsClsCd,
				success : "",
				isShowMeg : false
			};
			ajaxLib.executeAjax(wframeLeft.$p, option);
		} else {
			wframeLeft.sbxQnaClsCd1.hide();
		}
	}
};

comLib.initAdmin = function($p) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	$("table.creat").removeClass("table-on");
	utilLib.clearDcObj(wframeLeft.dltSysAthr);
	wframeLeft.dmaSysAthr.set("sysDivCd", comLib.getSysDivCd());
	comLib.retrieveAdminList($p);
};

comLib.retrieveAdminList = function($p) {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	var requestData = {};
	requestData.dmaBbsMngBasic = {};

	var option = {
		action : "/sc/admin/retrieveAdminList.do",
		reqData : requestData,
		resData : wframeLeft.dltSysAthr,
		success : "comLib.retrieveAdminListCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

comLib.retrieveAdminListCallback = function() {
	var wframeLeft = $p.top().wframeLeft.getWindow();
	wframeLeft.$p.$("#adminListGrp").mCustomScrollbar({
		axis : "yx",
		theme : "minimal",
		setHeight : parseInt($(".nav-board").css("height").replace("px", "")) - 100
	});
	wframeLeft.$p.$("#adminListGrp").mCustomScrollbar().css("height",parseInt($(".nav-board").css("height").replace("px", "")) - 100);
	// adminListGrp.parentControl.childControlList["0"].childControlList["0"].setStyle("width","100%");

	var str = [];
	str.push("<ul class=\"w2group \">");
	for (var i = 0; i < wframeLeft.dltSysAthr.getRowCount(); i++) {
		str.push("<li id=\"liId_"+wframeLeft.dltSysAthr.getCellData(i, "usrId" ) + "\" class=\"w2group adminLi\">");
		// str.push("<img src=\"/resources/images/common/pic-c-39.png\" class=\"w2image \">");
		str.push("<span class=\"w2span name\">" + wframeLeft.dltSysAthr.getCellData(i, "korname" ) + " / " + wframeLeft.dltSysAthr.getCellData(i, "posit" ) + " / -</span>");
		str.push("<span class=\"w2span comp\">" + wframeLeft.dltSysAthr.getCellData(i, "dtyNm" ) + "</span>");
		str.push("<div class=\"w2group num-group\">");
		str.push("<span class=\"w2span system\">" + wframeLeft.dltSysAthr.getCellData(i, "adminDivNm" ) + "</span>");
		str.push("<span class=\"w2span num\">" + wframeLeft.dltSysAthr.getCellData(i, "dphno" ) + "</span>");
		str.push("<div class=\"w2anchor mail\">");
		str.push("<a href=\"javascript:" + comLib.getFrameId(wframeLeft.$p) + "scwin.selectAdmin('" + wframeLeft.dltSysAthr.getCellData(i, "usrId") + "');\"></a>");
		str.push("</div>");
		str.push("</div>");
		str.push("</li>");
	}
	str.push("</ul>");
	wframeLeft.adminList.render.innerHTML = str.join("");
	if (wframeLeft.dltSysAthr.getRowCount() > 0) {
		wframeLeft.scwin.selectAdmin(wframeLeft.dltSysAthr.getCellData( 0 , "usrId" ));
	}
};

comLib.removeSrc = function() {
	var wframeLeft = $p.top().wframeLeft;
	wframeLeft.setSrc("/ui/common/content_board.xml");
};

comLib.ozParam = "";
comLib.paramFileName = "";

comLib.checkFileInfo_1 = [ "2.5.0.28"		, 0x0026, "TWFFUFNCcm9rZXIuZXhl"		, "MDeJJ9yA9U1n9SV3tXQzSXI=" ];
comLib.checkFileInfo_2 = [ "2.5.0.2"		, 0x0029, "fBIdC5Z3WvNGN/E9NjwwAi5kbGw=", "" ];
comLib.checkFileInfo_3 = [ "70.2017.921.100", 0x0026, "b3pjcmVwb3J0LmRsbA=="		, "M2UlG92rp08YdDMSVE/PlGRhb25cb3p2aWV3ZXI=" ];

var chkFileArray = new Array(comLib.checkFileInfo_1, comLib.checkFileInfo_2, comLib.checkFileInfo_3);

comLib.programComment_1 = [ "MaEPSBroker"	, "XP, Vista, 7, 8, 8.1, 10", "¤ì¹˜´í¬ „ë¡œ¸ë¨…ë‹ˆ ´ë‹¹ „ë¡œ¸ë¨¸ì„¤„ë˜„ë¡œ¸ë¨€¹˜´í¬†ìŠµˆë‹¤.", "./bin/MAWS_KWaterOz_Setup.exe" ];
comLib.programComment_2 = [ "ePageSafer"	, "XP, Vista, 7, 8, 8.1, 10", "œë ¥„ë©ì „ë¡œ¸ë¨…ë‹ˆ"	, "./bin/MAWS_KWaterOz_Setup.exe" ];
comLib.programComment_3 = [ "OZ Report"		, "XP, Vista, 7, 8, 8.1, 10", "´ê³ ¸ë¦¬´ê¸° „ë¡œ¸ë¨…ë‹ˆ"		, "./bin/Setup OZ Viewer.exe" ];
var programCommentArray = new Array(comLib.programComment_1, comLib.programComment_2, comLib.programComment_3);

comLib.ozData = null;
comLib.exeCall  = function(data) {
	comLib.ozData = data;
	maBrokerInit(comLib.maEPS_InstallCheck1, "getVersion", false);
};

comLib.maEPS_InstallCheck1  = function($p) {
	// MDBG("maOnlyInstallFlag", maOnlyInstallFlag);
	// MDBG("maResJsonData", maResJsonData);
	var result = false;
	if (typeof (maResJsonData) != "string") {
		for (var chkFile_i = 0; chkFile_i < maResJsonData.length; chkFile_i++) {
			var installFlag = maResJsonData[chkFile_i].installFlag;
			var fileDownloadLink = "";
			if (installFlag == false) {
				comLib.alert($p, "¤ì¹˜„ë¡œ¸ë¨„ìš”©ë‹ˆ");
				window.open(comLib.OZ_POP_URL+"/exeviewer/WebContent/installCheck.jsp");
			} else {
				// window.open("/oz70/exeviewer/WebContent/index.html");
			}
		}
		if (maOnlyInstallFlag == true) {
			comLib.exeExeCall($p, comLib.ozData);
		}
	}
	// comLib.exeExeCall(comLib.ozData);
};

comLib.exeExeCall = function($p, data) {
	var addr = comLib.OZ_POP_URL;
	var paramSep = "#OZ#";		 // °ì–´¨ëŸ¬¸í„° ¬ë¶„1
	var paramSep2 = "!OZ!";		 // °ì–´¨ëŸ¬¸í„° ¬ë¶„2
	var exeURL = addr + "/exeviewer/ozExe.jsp";
	var barcodeURL = addr + "/markany";

	comLib.ozParam = "";
	if (data != undefined && data.length != undefined && data.length > 0) {
		for (var i = 0 ; i < data.length ; i++) {
			if (i == 0) {
				comLib.ozParam += comLib.setOzParam($p, data[i], "");
				if (data.length > 1) {
					comLib.ozParam += "viewer.childcount=" + (data.length-1) + paramSep;
				}
			} else {
				comLib.ozParam += comLib.setOzParam($p, data[i], "child" + i + ".");
			}
		}
	} else {
		comLib.ozParam += comLib.setOzParam($p, data, "");
	}

	//console.log(comLib.ozParam);
	// ozExe.jsp?flag€ setParam½ìš° œë²„paramŒì¼ ì„±
	// ozExe.jsp?flag€ getParam½ìš° ì„±paramŒì¼¸ì¶œ
	var result = comLib.aJaxCall(comLib.ozParam, exeURL + "?flag=setParam");
	if (result) {
		var totalParamURL = exeURL + "?flag=getParam&paramFileName=" + comLib.paramFileName;
		var param = "viewer.totalparam_url=" + totalParamURL + paramSep2
			+ "viewer.totalparam_separator=" + paramSep + paramSep2
			+ "viewer.allowmultiframe=true" + paramSep2;
		OZUtil.OZEXEViewerRun("daon", param, paramSep2);
	} else {
		alert("result :" + result);
	}
}

comLib.setOzParam = function($p, data, prefix) {
	var addr = comLib.OZ_POP_URL;
	var paramSep = "#OZ#";	 // °ì–´¨ëŸ¬¸í„° ¬ë¶„1
	var paramSep2 = "!OZ!";	 // °ì–´¨ëŸ¬¸í„° ¬ë¶„2
	var ozServerURL = addr + "/server";
	var barcodeURL = addr + "/markany"; // ¤ì¦ˆœë²„-”ì½”œURL (2020-05-19, µí†µ€ ”ê)

	var ozrFile = data.ozrFile;
	var odiFileName = data.odiFileName;
	var args = data.args;
	var jsondata = data.jsondata;
	// œì¸•ë³´ ´ìš© ©ì  ("01":œì¸•ë³´ °íšŒ (Œì¼ ¤ìš´œë“œ ˆê, ¸ì‡„ €, "02":œì¸•ë³´ ¤ìš´œë“œ (Œì¼ ¤ìš´œë“œ € ?¬ìœ  …ë ¥ „ìˆ˜)) : 2020-05-07, µí†µ€ ”ê
	var idvInfoUtlzPurps = data.idvInfoUtlzPurps;

	comLib.ozParam += prefix + "connection.servlet=" + ozServerURL + paramSep;
	comLib.ozParam += prefix + "information.debug=error" + paramSep;
	comLib.ozParam += prefix + "connection.reportname=" + ozrFile + paramSep;

	// œì¸•ë³´€ ?¬í•¨¤ì¦ˆˆí¬¸ì¶œ¼ë ¨ˆí˜¸ „ë²ˆ ?¬ì„±
	var docOutptData = comLib.logDocOutptHist($p, data);
	if (odiFileName != "") {
		// ˆí¬Footer„ë‹¬ª©ˆëŠ” ½ìš° ë˜ Œë¼¸í„°9€€ ??ª©”êœë‹¤.
		if (docOutptData != undefined && docOutptData.length != undefined && docOutptData.length > 0) {
			comLib.ozParam += prefix + "connection.footerreportname=/ozr/scm/sc/cmmn/SCMSC_CMMN_FOOTER.ozr" + paramSep;
			comLib.ozParam += prefix + "connection.pcount=" + (args.length + 9) + paramSep;
		} else {
			comLib.ozParam += prefix + "connection.pcount=" + args.length + paramSep;
		}

		for (var i = 0; i < args.length; i++) {
			comLib.ozParam += prefix + "connection.args" + (i + 1) + "=" + args[i] + paramSep;
		}
		comLib.ozParam += prefix + "odi." + odiFileName + ".pcount=" + args.length + paramSep;
		for (var i = 0; i < args.length; i++) {
			comLib.ozParam += prefix + "odi." + odiFileName + ".args" + (i + 1) + "=" + args[i] + paramSep;
		}

		// ˆí¬Footer„ë‹¬ª©ˆëŠ” ½ìš° ë˜ Œë¼¸í„°9€€ ??ª©”êœë‹¤.
		if (docOutptData != undefined && docOutptData.length != undefined && docOutptData.length > 0) {
			comLib.ozParam += prefix + "connection.args" + (args.length+1) + "=sysDivCd=" + docOutptData[0].sysDivCd + paramSep;
			comLib.ozParam += prefix + "connection.args" + (args.length+2) + "=docCd=" + docOutptData[0].docCd + paramSep;
			comLib.ozParam += prefix + "connection.args" + (args.length+3) + "=docNm=" + docOutptData[0].docNm + paramSep;
			comLib.ozParam += prefix + "connection.args" + (args.length+4) + "=outptDe=" + docOutptData[0].outptDe + paramSep;
			comLib.ozParam += prefix + "connection.args" + (args.length+5) + "=outptNo=" + docOutptData[0].outptNo + paramSep;
			comLib.ozParam += prefix + "connection.args" + (args.length+6) + "=usrId=" + docOutptData[0].usrId + paramSep;
			comLib.ozParam += prefix + "connection.args" + (args.length+7) + "=usrNm=" + docOutptData[0].usrNm + paramSep;
			comLib.ozParam += prefix + "connection.args" + (args.length+8) + "=usrDeptNm=" + docOutptData[0].usrDeptNm + paramSep;
			comLib.ozParam += prefix + "connection.args" + (args.length+9) + "=outptDt=" + docOutptData[0].outptDt + paramSep;
		}
	} else {
		// ˆí¬Footer„ë‹¬ª©ˆëŠ” ½ìš° ë˜ Œë¼¸í„°9€€ ??ª©”êœë‹¤.
		if (docOutptData != undefined && docOutptData.length != undefined && docOutptData.length > 0) {
			comLib.ozParam += prefix + "connection.footerreportname=/ozr/scm/sc/cmmn/SCMSC_CMMN_FOOTER.ozr" + paramSep;
			comLib.ozParam += prefix + "connection.pcount=" + (jsondata.length + 9) + paramSep;
		} else {
			comLib.ozParam += prefix + "connection.pcount=" + jsondata.length + paramSep;
		}

		for (var i = 0; i < jsondata.length; i++) {
			comLib.ozParam += prefix + "connection.args" + (i + 1) + "=jsondata=" + JSON.stringify(jsondata[i]) + paramSep;
		}

		// ˆí¬Footer„ë‹¬ª©ˆëŠ” ½ìš° ë˜ Œë¼¸í„°9€€ ??ª©”êœë‹¤.
		if (docOutptData != undefined && docOutptData.length != undefined && docOutptData.length > 0) {
			comLib.ozParam += prefix + "connection.args" + (jsondata.length + 1) + "=sysDivCd=" + docOutptData[0].sysDivCd + paramSep;
			comLib.ozParam += prefix + "connection.args" + (jsondata.length + 2) + "=docCd=" + docOutptData[0].docCd + paramSep;
			comLib.ozParam += prefix + "connection.args" + (jsondata.length + 3) + "=docNm=" + docOutptData[0].docNm + paramSep;
			comLib.ozParam += prefix + "connection.args" + (jsondata.length + 4) + "=outptDe=" + docOutptData[0].outptDe + paramSep;
			comLib.ozParam += prefix + "connection.args" + (jsondata.length + 5) + "=outptNo=" + docOutptData[0].outptNo + paramSep;
			comLib.ozParam += prefix + "connection.args" + (jsondata.length + 6) + "=usrId=" + docOutptData[0].usrId + paramSep;
			comLib.ozParam += prefix + "connection.args" + (jsondata.length + 7) + "=usrNm=" + docOutptData[0].usrNm + paramSep;
			comLib.ozParam += prefix + "connection.args" + (jsondata.length + 8) + "=usrDeptNm=" + docOutptData[0].usrDeptNm + paramSep;
			comLib.ozParam += prefix + "connection.args" + (jsondata.length + 9) + "=outptDt=" + docOutptData[0].outptDt + paramSep;
		}
	}
	comLib.ozParam += prefix + "viewer.smartframesize=true" + paramSep;
	comLib.ozParam += prefix + "viewer.showerrormessage=false" + paramSep;
	if (data.mode == undefined || data.mode == "") {
		comLib.ozParam += prefix + "viewer.mode=preview" + paramSep;
	} else {
		comLib.ozParam += prefix + "viewer.mode=" + data.mode + paramSep;
	}

	if (data.useprogressbar != undefined && data.useprogressbar !="") {
		comLib.ozParam += prefix + "viewer.useprogressbar=" + data.useprogressbar + paramSep;
	}
	if (data.emode != undefined && data.emode !="") {
		comLib.ozParam += prefix + "export.mode=" + data.emode + paramSep;
	}
	if (data.filename != undefined && data.filename !="") {
		comLib.ozParam += prefix + "export.filename=" + data.filename + paramSep;
	}
	if (data.format != undefined && data.format !="") {
		comLib.ozParam += prefix + "export.format=" + data.format + paramSep;
	}
	if (data.applyformat != undefined && data.applyformat !="") {
		comLib.ozParam += prefix + "export.applyformat=" + data.applyformat + paramSep;
	}
	if (data.path != undefined && data.path !="") {
		comLib.ozParam += prefix + "export.path=" + data.path + paramSep;
	}
	if (data.confirmsave != undefined && data.confirmsave !="") {
		comLib.ozParam += prefix + "export.confirmsave=" + data.confirmsave + paramSep;
	}
	if (data.exportcommand != undefined && data.exportcommand !="") {
		comLib.ozParam += prefix + "viewer.exportcommand=" + data.exportcommand + paramSep;
	}
	if (data.ozcommandurl != undefined && data.ozcommandurl !="") {
		comLib.ozParam += prefix + "viewer.ozcommandurl=" + data.ozcommandurl + paramSep;
	}
	if (data.matchmode != undefined && data.matchmode !="") {
		comLib.ozParam += prefix + "excel.matchmode=" + data.matchmode + paramSep;
	}

	// comLib.ozParam += "export.applyformat=jpg" + paramSep;
	if (data.barcode != "no") {
		comLib.ozParam += prefix + "connection.2dbarcodeurl=" + barcodeURL + paramSep;
		comLib.ozParam += prefix + "connection.extraparam=ShowCustomPrintUI=true,MaxCopies=1,Copies=1,SupportPrinter=3,DatFileName=MaPrintInfo_KWaterOz.dat" + paramSep;
		comLib.ozParam += prefix + "print.externalmoduleEx=OZPrintBarcodeEx_MarkAny.dll" + paramSep;
	}

	// œì¸•ë³´ ´ìš© ©ì  ’ì´ "01":œì¸•ë³´ °íšŒ (Œì¼ ¤ìš´œë“œ ˆê, ¸ì‡„ € ´ë©´ Œì¼€„ì´„í™œ±í™”.
	if (idvInfoUtlzPurps == "01") {
		comLib.ozParam += prefix + "toolbar.print=true" + paramSep;			// ¸ì‡„ „ì´		comLib.ozParam += prefix + "toolbar.save=disable" + paramSep;		// Œì¼€„ì´(disable)
		comLib.ozParam += prefix + "toolbar.savedm=false" + paramSep;		// °ì´°ë¡œ€„ì´		comLib.ozParam += prefix + "toolbar.pdf=false" + paramSep;			// pdf ?€„ì´		comLib.ozParam += prefix + "toolbar.xlsx=false" + paramSep;			// xlsx ?€„ì´		comLib.ozParam += prefix + "toolbar.hml=false" + paramSep;			// œê ?€„ì´œì‹ 
		comLib.ozParam += prefix + "toolbar.doc=false" + paramSep;			// doc ?€„ì´		comLib.ozParam += prefix + "toolbar.ppt=false" + paramSep;			// ppt ?€„ì´		// comLib.ozParam += prefix + "viewer.usemenubar=false" + paramSep;	// ¤ì¦ˆ °ì–´ ë‹¨ ”ë‰´(Œì¼/´ê¸°/„êµ¬/„ì ?¨ê

		// œì¸•ë³´ ´ìš© ©ì  ’ì´ "02":œì¸•ë³´ ¤ìš´œë“œ (Œì¼ ¤ìš´œë“œ € ?¬ìœ  …ë ¥ „ìˆ˜) ´ë©´ Œì¼€„ì´œì„±
	} else {
		comLib.ozParam += prefix + "toolbar.print=true" + paramSep;		// ¸ì‡„ „ì´
		comLib.ozParam += prefix + "toolbar.save=true" + paramSep;		// Œì¼€„ì´		comLib.ozParam += prefix + "toolbar.savedm=true" + paramSep;	// °ì´°ë¡œ€„ì´		comLib.ozParam += prefix + "toolbar.pdf=true" + paramSep;		// pdf ?€„ì´		comLib.ozParam += prefix + "toolbar.xlsx=true" + paramSep;		// xlsx ?€„ì´		comLib.ozParam += prefix + "toolbar.hml=true" + paramSep;		// œê ?€„ì´œì‹ 
		comLib.ozParam += prefix + "toolbar.doc=true" + paramSep;		// doc ?€„ì´		comLib.ozParam += prefix + "toolbar.ppt=true" + paramSep;		// ppt ?€„ì´
		comLib.ozParam += prefix + "export.format=pdf" + paramSep;		// ”í´€•ì‹(PDF)
		comLib.ozParam += prefix + "hml.saveasxml=false" + paramSep;	// hwp ?€?¥ì‹œ xml •ì‹¼ë¡œ ?€??X)
	}
/*
	[org source]
	comLib.ozParam += prefix + "toolbar.pdf=true" + paramSep;		// pdf ?€„ì´	comLib.ozParam += prefix + "toolbar.xlsx=true" + paramSep;		// xlsx ?€„ì´	comLib.ozParam += prefix + "toolbar.hml=true" + paramSep;		// œê ?€„ì´œì‹ 
	comLib.ozParam += prefix + "hml.saveasxml=false" + paramSep;	// hwp ?€?¥ì‹œ xml •ì‹¼ë¡œ ?€??X)
	// comLib.ozParam += "toolbar.han97=true" + paramSep;			// œê ?€„ì´97„ì „)
*/
	return comLib.ozParam;
}

comLib.aJaxCall = function(ozParam, pageURL) {
	var result = false;
	var form_data = {
		"ozParam" : ozParam
	};
	if (ozParam.length > 100) {
		$.ajax({
			url : pageURL,
			data : form_data,
			dataType : "json",
			type : "POST",
			async : false,
			success : function(data) {
				if (data != null) {
					comLib.paramFileName = data.paramFileName;
				}
				if (comLib.paramFileName != "" || comLib.paramFileName != undefined || comLib.paramFileName != "undefined") {
					result = true;
				}
			},
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			error : function(request, status, error) {
				if (request.status != "0") {
					alert("code : " + request.status + "\r\nmessage : " + request.reponseText + "\r\nerror : " + error);
				}
			}
		});
	} else {
		alert("Check ozParam : " + comLib.ozParam);
	}
	return result;
}

comLib.exeMarkanyCall  = function(data) {
	//console.log(data);
	var ozMarkanyParam ="";
	var ozrFile = data.ozrFile;
	var odiFileName = data.odiFileName;
	var args = data.args;
	var addr = comLib.OZ_POP_URL;
	// var jsondata = data.jsondata;

	var ozMarkanyParam = "";
	var ozServerURL = addr + "/exeviewer/second_oz_markany_serverbind.jsp?serverUrl=" + addr + "/server";
	var vDate = new Date();
	var m = (vDate.getMonth() + 1);
	if (m < 10) {
		m = "0" + "" + m;
	}
	var d = vDate.getDate();
	if (d < 10) {
		d = "0" + "" + d;
	}
	var markanyTime = vDate.getFullYear() + "" + m + "" + d + "" + vDate.getHours() + "" + vDate.getMinutes() + "" + vDate.getSeconds() + "" + vDate.getMilliseconds();
	// ozMarkanyParam += ozServerURL + "&filePath=" + "/sol/oz70/exeviewer/markany/fn/";	//œë°œœë²„
	// ozMarkanyParam += ozServerURL + "&filePath=" + "/daonwas1/MarkanyMeta/";				//´ì˜œë²„
	ozMarkanyParam += ozServerURL + "&filePath=" + "D://rpt/exeviewer/markany/fn/";			//´ì˜œë²„ ( ˜ìì„œ¬ì¶• ´ì˜ / œë°œœë²„ ½ë¡œ ¨ë‘ D:/rptµì¼
	ozMarkanyParam += "&fileName=markanyTime_"+markanyTime;
	ozMarkanyParam += "&ozrName=" + ozrFile;
	ozMarkanyParam += "&odiName=" + odiFileName;

	for (var i = 0; i < args.length; i++) {
		ozMarkanyParam += "&odiParamVal=" + args[i];
	}
	ozMarkanyParam += "&viewer.showerrormessage=false";
	window.open(ozMarkanyParam, "exeviewer", "width=800px,height=600px");
};

comLib.selectUsrBkMkList = function() {
	var wfmLeFt = $p.top().wfm_left.getWindow();
	var requestData = {};
	var option = {
		action : "/sc/usrBkMk/selectUsrBkMk.do",
		reqData : requestData,
		resData : wfmLeFt.dltUsrBkMk,
		success : "comLib.selectUsrBkMkListCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax(wfmLeFt.$p,option);
};

comLib.selectUsrBkMkListCallback = function() {
	var wfmLeFt = $p.top().wfm_left.getWindow();
	wfmLeFt.$p.$("#bkMk").mCustomScrollbar({
		axis : "yx",
		theme : "minimal",
		setHeight : parseInt($(".usermenu").css("height").replace("px", "")) - 152,
		setWidth : "210px"
	});

	wfmLeFt.$p.$("#bkMk").mCustomScrollbar().css("height", parseInt($(".usermenu").css("height").replace("px", "")) - 152);
	wfmLeFt.$p.$("#bkMk").mCustomScrollbar().css("width", "210px");
	var str = [];
	str.push("<ul class=\"w2group \">");
	for(var i=0; i < wfmLeFt.dltUsrBkMk.getRowCount(); i++) {
		str.push("<li id=\"usrBkMk_" + wfmLeFt.dltUsrBkMk.getCellData(i, "bkmkMenuId" ) + "\" class=\"w2group \">");
		str.push("<a class=\"w2anchor2 \" href=\"javascript:comLib.usrBkMkWindow('" + wfmLeFt.dltUsrBkMk.getCellData(i, "menuNm" ) + "','" + wfmLeFt.dltUsrBkMk.getCellData(i, "scrinUrl" ) + "');\">" + wfmLeFt.dltUsrBkMk.getCellData(i, "menuNm" ) + "</a>");
		str.push("<span class=\"w2span location\">" + wfmLeFt.dltUsrBkMk.getCellData(i, "menuLvlNm" )+"</span>");
		str.push("<div class=\"w2group \">");
		str.push("<input type=\"button\" class=\"w2trigger f-del-btn\" onclick=\"javascript:comLib.usrBkMkDelete('" + wfmLeFt.dltUsrBkMk.getCellData(i, "bkmkMenuId") + "');\">");
		str.push("<input type=\"button\" class=\"w2trigger f-up\" onclick=\"comLib.usrBkMkUp(this)\">");
		str.push("<input type=\"button\" class=\"w2trigger f-down\" onclick=\"comLib.usrBkMkDown(this)\">");
		str.push("</div>");
		str.push("</li>");
	}
	str.push("</ul>");
	wfmLeFt.usrCnt.setValue((wfmLeFt.dltUsrBkMk.getRowCount())+"œì˜");
	wfmLeFt.usrBkMkList.render.innerHTML = str.join("");
};

comLib.usrBkMkDelete  = function(bkmkMenuId) {
	var wfmLeFt = $p.top().wfm_left.getWindow();
	var requestData = {};
	requestData.data = {
		"bkmkMenuId" : bkmkMenuId
	};
	var option = {
		action : "/sc/usrBkMk/deleteUsrBkMk.do",
		reqData : requestData,
		success : "comLib.selectUsrBkMkList",
		isShowMeg : false
	};
	ajaxLib.executeAjax(wfmLeFt.$p, option);
};

comLib.usrBkMkUp = function(bkmkObj) {
	var wfmLeFt = $p.top().wfm_left.getWindow();
	var li = $(bkmkObj).parent().parent();
	var menuId = li.attr("id");
	var lis = li.parent().children();
	var menuIdArr = menuId.split("_");

	wfmLeFt.dltUsrBkMk.rowMoveUp(wfmLeFt.dltUsrBkMk.getMatchedIndex("bkmkMenuId", menuIdArr[1], true, 0, wfmLeFt.dltUsrBkMk.getRowCount()));

	var requestData = {};
	requestData.data = wfmLeFt.dltUsrBkMk.getAllJSON();

	var option = {
		action : "/sc/usrBkMk/updateUsrBkMk.do",
		reqData : requestData,
		success : "comLib.selectUsrBkMkList",
		// savedToken : true,
		isShowMeg : false
	};
	ajaxLib.executeAjax(wfmLeFt.$p, option);
	/*
	for (var i = 0; i < lis.length; i++) {
		var lisMenuId = lis.eq(i).attr("id");
		if (lisMenuId == menuId) {
			if (i == 0) {
				return;
			}
			li.detach();
			lis.eq(i - 1).before(li);
			return;
		}
	}
	*/
};

comLib.usrBkMkDown = function(bkmkObj) {
	var wfmLeFt = $p.top().wfm_left.getWindow();
	var li = $(bkmkObj).parent().parent();
	var menuId = li.attr("id");
	var lis = li.parent().children();
	var menuIdArr = menuId.split("_");

	wfmLeFt.dltUsrBkMk.rowMoveDown( wfmLeFt.dltUsrBkMk.getMatchedIndex("bkmkMenuId", menuIdArr[1], true, 0, wfmLeFt.dltUsrBkMk.getRowCount()));

	var requestData = {};
		requestData.data = wfmLeFt.dltUsrBkMk.getAllJSON();

		var option = {
			action : "/sc/usrBkMk/updateUsrBkMk.do",
			reqData : requestData,
			success : "comLib.selectUsrBkMkList",
			//savedToken : true,
			isShowMeg : false
		};
		ajaxLib.executeAjax(wfmLeFt.$p, option);

/*
	for (var i = 0; i < lis.length; i++) {
		var lisMenuId = lis.eq(i).attr("id");
		if (lisMenuId == menuId) {
			if (i == lis.length - 1) {
				return;
			}
			li.detach();
			lis.eq(i + 1).after(li);
			return;
		}
	}
*/
};

comLib.usrBkMkWindow  = function(title,scrinUrl) {
	var scrinUrlArr = scrinUrl.split(",");
	var wdcMain = $p.top().wdcMain;
	if (wdcMain.getWindowByWindowId(scrinUrlArr[1]) != null) {
		wdcMain.getWindowByWindowId(scrinUrlArr[1], true);
	} else {
		$p.top().wfm_left.getWindow().scwin.createWindow(title, "", scrinUrlArr[0], "", scrinUrlArr[1]);
	}
};

/**
 * SAP SSO (EXE) ¸ì¶œœë‹¤.
 * @param 
 * @return 
 */ 
comLib.btnCallSSO_onclick = function($p) {
	// SSO ¸ì¶œ ˜í”Œ
	if (/msie|trident/i.test(navigator.userAgent) == false) {
		comLib.alert($p, utilLib.getMessage("SCM.INFO.00341"));
		return false;
	}

	var requestData = {
		"RFC_NAME" : "ZKCC_SUSR_SSO_CALL",
		"IS_IMPORT" : {
			"KSYS_ID" : comLib.getSysDivCd(),
			"IF_EMP_ID":comLib.getUsrId()
		},
		"IV_UNAME" : comLib.getUsrId(),
		"IV_MODE" : "",
		"EXPORT_RESULT" : ["ES_EXPORT", "EV_SHORTCUT_01", "EV_SHORTCUT_02", "EV_URL"]
	};

	var option = {
		action : "/sc/sap/getSearchSapInfo.do",
		reqData : requestData,
		success : "comLib.inqireCallback",
		isShowMeg : false
	};

	ajaxLib.executeAjax($p, option);
};

/**
 * SAP SSO ¸ì¶œ callBackœí–‰œë‹¤.
 * @param <Object> resBody
 * @return 
 */ 
comLib.inqireCallback = function(resBody, e) {
	var returnType;
	var exeRoot;
	returnType = resBody.data.ES_EXPORT.TYPE;

	if ( returnType != "S" ) {
		comLib.alert($p, utilLib.getMessage("SCM.SYS.00001"));
	} else {
		// alert(window.navigator.userAgent);
		// alert("Wow64 : " + window.navigator.userAgent.indexOf("WOW64") +  "  Win64 : " + window.navigator.userAgent.indexOf("Win64") + "  x64 : " + window.navigator.userAgent.indexOf("x64"));
		// alert(window.navigator.platform + "/ "+ window.navigator.cpuClss);
		if ((window.navigator.userAgent.indexOf("WOW64") != -1) || (window.navigator.userAgent.indexOf("Win64") != -1) || (window.navigator.userAgent.indexOf("x64") != -1)) {
			// ˆë„64„íŠ¸
			// alert("win64");
			exeRoot = resBody.data.EV_SHORTCUT_02;
		} else {
			// ˆë„32„íŠ¸
			// alert("win32");
			exeRoot = resBody.data.EV_SHORTCUT_01;
		}
		// console.log(exeRoot);
		var shell = new ActiveXObject("WScript.Shell");
		comLib.alert($p, "SAPGUI –‰‘ì…ˆë‹¤.");
		shell.Exec(exeRoot);
		// console.log(shell.Exec(exeRoot));
	}
};

// Œì‹œ©ë¡
comLib.retrieveNttMngListLWS = function($p) {
	var requestData = {};
	requestData.dmaBbsMngBasic = dmaNttMng.getJSON();

	var option = {
		action : "/sc/bbsMng/getBbsList.do",
		reqData : requestData,
		resData : dltNttMng,
		success : "scwin.retrieveNttMngListCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

// Gis ì—…  ê „íŠ¼ ”ê ¬½íŠ¸
/*
comLib.gisT = function() {
	$(".w2window_header_control").append("<a href='' class='toggle-pop'> ê</a>");
	$(".toggle-pop").click(function() {
		$(this).parent().parent().parent().toggleClass("op");
		return false
	});
};
*/

/* ******************************************************* *
/* „ë˜¬ì›/€°íšŒ¨ë“ˆ
 * ******************************************************* */

/**
 * …ë ¥¬ì›…ì— ´ë‹¹˜ëŠ” ?¬ì›°íšŒ
 * 1…ì´ °íšŒ½ìš° : callback?¨ìˆ˜ ¸ì¶œ
 * ¸ì˜ ½ìš° : ì—…¸ì¶œ
 * 
 * @param searchUsrNm : €‰í•  ?¬ì› * @param options : Ajax ì—… µì…˜
 * @param jsonObj :
 */
comLib.selectEmpWithoutOrgcht = function($p, searchUsrNm, option, jsonObj) {
	jsonObj.searchUsrNm = searchUsrNm;
	jsonObj.dmaInqireParam = {
		"searchUsrNm" : searchUsrNm
	};

	// ±ëª… …ë ¥½ì˜ €ìˆ˜ •ì¸
	if (searchUsrNm.length >= 2) {
		// …ë ¥›ì ±ëª…2€´ìƒ´ë©´ Ajax ¸ì¶œ
		var url = utilLib.getDomainFromUrl(comLib.HRM_POP_URL)
			+ "/hr/empDept/retrieveUsrInqire.do"
			+ "?option=" + JSON.stringify(option)
			+ "&jsonObj=" + JSON.stringify(jsonObj);

		$.ajax({
			url : encodeURI(url),
			type : "GET",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "jsonp",
			jsonp : "jsonpCallbackFunc",
			success : comLib.selectEmpWithoutOrgchtCallback
		});
	} else {
		// ì—… ¸ì¶œ(°íšŒ°ê±´€€ì—…)
		comLib.openPostWinPopup($p, comLib.HRM_POP_URL + "/ui/hrm/zz/searchmng/HRMZZ20000001.xml", option, jsonObj);
	}
};

/**
 * Ajax ¸ì¶œ˜ì—¬ ?¬ìš©•ë³´°íšŒ „ë£Œ ??Callback
 * 1…ë§Œ °íšŒ˜ì—ˆ½ìš° callback ?¨ìˆ˜˜í–‰˜ê³ 
 * ¸ì˜ ½ìš°ëŠ” ì—…½ì„ ¸ì¶œœë‹¤.
 * (??functionì ‘ ?¬ìš©¼ì †ìŒ)
 */
comLib.selectEmpWithoutOrgchtCallback = function(resBody, resAll) {
	if (resBody.message.code == comLib.STATUS_SUCCESS) {
		var option = null;
		var jsonObj = null;
		if (resBody.reqData != undefined) {
			option = resBody.reqData.option;
			jsonObj = resBody.reqData.jsonObj;
		}

		if (resBody.data != undefined && resBody.data != null && resBody.data.length == 1) {
			// °íšŒ „ë£Œ œë°±¨ìˆ˜ ¸ì¶œ(ì—…ì„œ ¬í„´›ëŠ” ??ª©™ì¼˜ê²Œ ˜ë¦¬)
			var callbackFunc = eval(jsonObj.closeCallbackFncName);
			callbackFunc(resBody.data[0]);
		} else {
			// ì—… ¸ì¶œ(°íšŒ°ê±´€€ì—…)
			comLib.openPostWinPopup($p, comLib.HRM_POP_URL + "/ui/hrm/zz/searchmng/HRMZZ20000001.xml", option, jsonObj);
		}
	}
};

/**
 * …ë ¥¬ì›…ì— ´ë‹¹˜ëŠ” ?¬ì›°íšŒ (°ì§œìš©)
 * 1…ì´ °íšŒ½ìš° : callback?¨ìˆ˜ ¸ì¶œ
 * ¸ì˜ ½ìš° : ì—…¸ì¶œ
 * 
 * @param searchUsrNm : €‰í•  ?¬ì› * @param options : Ajax ì—… µì…˜
 * @param jsonObj :
 */
comLib.selectEmpWithOrgcht = function(searchUsrNm, option, jsonObj) {
	jsonObj.searchUsrNm = searchUsrNm;
	jsonObj.dmaSearchParam = {
		"searchUsrNm" : jsonObj.searchUsrNm
	};

	// ±ëª… …ë ¥½ì˜ €ìˆ˜ •ì¸
	if (searchUsrNm.length >= 2) {
		// …ë ¥›ì ±ëª…2€´ìƒ´ë©´ Ajax ¸ì¶œ
		var url = utilLib.getDomainFromUrl(comLib.HRM_POP_URL)
			+ "/hr/empDept/retrieveUsrList.do"
			+ "?option=" + JSON.stringify(option)
			+ "&jsonObj=" + JSON.stringify(jsonObj);

		$.ajax({
			url : encodeURI(url),
			type : "GET",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "jsonp",
			jsonp : "jsonpCallbackFunc",
			success : comLib.selectEmpWithOrgchtCallback
		});
	} else {
		// ì—… ¸ì¶œ(°íšŒ°ê±´€€ì—…)
		comLib.openPostWinPopup($p, comLib.HRM_POP_URL + "/ui/hrm/zz/searchmng/HRMZZ20000007.xml", option, jsonObj);
	}
};

/**
 * Ajax ¸ì¶œ˜ì—¬ ?¬ìš©•ë³´°íšŒ „ë£Œ ??Callback (°ì§œìš©)
 * 1…ë§Œ °íšŒ˜ì—ˆ½ìš° callback ?¨ìˆ˜˜í–‰˜ê³ 
 * ¸ì˜ ½ìš°ëŠ” ì—…½ì„ ¸ì¶œœë‹¤.
 * (??functionì ‘ ?¬ìš©¼ì †ìŒ)
 */
comLib.selectEmpWithOrgchtCallback = function(resBody) {
	if (resBody.message.code == comLib.STATUS_SUCCESS) {
		var option = null;
		var jsonObj = null;
		if (resBody.reqData != undefined) {
			option = resBody.reqData.option;
			jsonObj = resBody.reqData.jsonObj;
		}

		if (resBody.data != undefined && resBody.data != null && resBody.data.length == 1) {
			// °íšŒ „ë£Œ œë°±¨ìˆ˜ ¸ì¶œ(ì—…ì„œ ¬í„´›ëŠ” ??ª©™ì¼˜ê²Œ ˜ë¦¬)
			var callbackFunc = eval(jsonObj.closeCallbackFncName);
			callbackFunc(resBody.data);
		} else {
			// ì—… ¸ì¶œ(°íšŒ°ê±´€€ì—…)
			comLib.openPostWinPopup($p, comLib.HRM_POP_URL + "/ui/hrm/zz/searchmng/HRMZZ20000007.xml", option, jsonObj);
		}
	}
};

/**
 * …ë ¥€œëª…´ë‹¹˜ëŠ” €œë °íšŒ (°ì§œìš©)
 * 1…ì´ °íšŒ½ìš° : callback?¨ìˆ˜ ¸ì¶œ
 * ¸ì˜ ½ìš° : ì—…¸ì¶œ
 * 
 * @param searchDeptNm : €‰í•  €œëª…
 * @param options : Ajax ì—… µì…˜
 * @param jsonObj :
 */
comLib.selectDeptWithOrgcht = function(searchDeptNm, option, jsonObj) {
	jsonObj.searchDeptNm = searchDeptNm;

	// €…ë ¥½ì˜ €ìˆ˜ •ì¸
	if (searchDeptNm.length >= 2) {
		// …ë ¥›ì €œê 2€´ìƒ´ë©´ Ajax ¸ì¶œ
		var url = utilLib.getDomainFromUrl(comLib.HRM_POP_URL)
			+ "/hr/empDept/retrieveDeptList.do"
			+ "?option=" + JSON.stringify(option)
			+ "&jsonObj=" + JSON.stringify(jsonObj);

		$.ajax({
			url : encodeURI(url),
			type : "GET",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "jsonp",
			jsonp : "jsonpCallbackFunc",
			success : comLib.selectDeptWithOrgchtCallback
		});
	} else {
		// ì—… ¸ì¶œ(°íšŒ°ê±´€€ì—…)
		comLib.openPostWinPopup($p, comLib.HRM_POP_URL + "/ui/hrm/zz/searchmng/HRMZZ20000008.xml", option, jsonObj);
	}
};

/**
 * Ajax ¸ì¶œ˜ì—¬ €•ë³´°íšŒ „ë£Œ ??Callback (°ì§œìš©)
 * 1œë§Œ °íšŒ˜ì—ˆ½ìš° callback ?¨ìˆ˜˜í–‰˜ê³ 
 * ¸ì˜ ½ìš°ëŠ” ì—…½ì„ ¸ì¶œœë‹¤.
 * (??functionì ‘ ?¬ìš©¼ì †ìŒ)
 */
comLib.selectDeptWithOrgchtCallback = function(resBody) {
	if (resBody.message.code == comLib.STATUS_SUCCESS) {
		var option = null;
		var jsonObj = null;
		if (resBody.reqData != undefined) {
			option = resBody.reqData.option;
			jsonObj = resBody.reqData.jsonObj;
		}

		if (resBody.data != undefined && resBody.data != null && resBody.data.length == 1) {
			// °íšŒ „ë£Œ œë°±¨ìˆ˜ ¸ì¶œ(ì—…ì„œ ¬í„´›ëŠ” ??ª©™ì¼˜ê²Œ ˜ë¦¬)
			var callbackFunc = eval(jsonObj.closeCallbackFncName);
			callbackFunc(resBody.data);
		} else {
			// ì—… ¸ì¶œ(°íšŒ°ê±´€€ì—…)
			comLib.openPostWinPopup($p, comLib.HRM_POP_URL + "/ui/hrm/zz/searchmng/HRMZZ20000008.xml", option, jsonObj);
		}
	}
};

comLib.selectMenu = function(scrinId) {
	var dltLeftMenuJson = top.dltLeftMenuList.getMatchedJSON("scrinId", scrinId, true, 0, top.dltLeftMenuList.getRowCount());
	if (dltLeftMenuJson.length > 0) {
		top.trvMenu.spanAll(false);
		top.trvMenu.findNodeByValue(dltLeftMenuJson[0].menuId, true);
	}
};

/**
 * Daon °ì¬„ë£Œ¤ì•„œìŠ¤ ëŠ” …ë¬´”ë©´½ì˜ Callback ?¨ìˆ˜¸ì¶œœë‹¤.
 */
comLib.sanctnCallback = function(){
	try{
		if (window.opener.top.Start_ep != undefined && window.opener.top.Start_ep != null) {
			window.opener.top.Start_ep.location.href= comLib.OASIS_CALL_POP_URL;
		} else {
			if (opener.scwin != undefined && opener.scwin != null) {
				var func = opener.eval("scwin.researchCallback");
				if (typeof func === "function") {
					func();
				}
			}
		}
	} catch(e) {}
};

/**
 * setUsrDstrctHqCdInfo : œê·¸¸ì‚¬©ìŒì—­, €¬ë°íšŒ
 */
comLib.setUsrDstrctHqCdInfo = function($p, dataMap, callback) {
	var requestData = {};
	requestData.searchVo =  {objid : comLib.getUserInfo("usrDeptCd")};

	var option = {
		action : "pg/cmmn/selectUsrDstrctHqInfo.do",
		reqData : requestData,
		resData : "",
		success : function(resBody) {
			var dstrctHqCd = resBody.data.dstrctHqCd;
			var dstrctHqNm = resBody.data.dstrctHqNm;
			var plntNo = resBody.data.plntNo;
			var mnggrpNm = resBody.data.mnggrpNm;

			if (dstrctHqCd != "10990028" && dstrctHqCd != "20060557" && dstrctHqCd != "50043037" && dstrctHqCd != "20060674") {
				dataMap.set("dstrctHqNm", "¸ì‚¬");
				dataMap.set("dstrctHqCd", "50013977");

				dataMap.set("plntNo", "1000");
				dataMap.set("mnggrpNm", "¸ì‚¬");
			} else {
				dataMap.set("dstrctHqNm", dstrctHqNm);
				dataMap.set("dstrctHqCd", dstrctHqCd);

				dataMap.set("plntNo", plntNo);
				dataMap.set("mnggrpNm", mnggrpNm);
			}

			if ($.type(callback) === "function") {
				callback();
			}
		},
		isShowMeg : false
	};
	ajaxLib.executeAjaxSync($p, option);
};

/**
 * œì¸•ë³´€ ?¬í•¨¤ì¦ˆˆí¬¸ì¶œ¼ë ¨ˆí˜¸ „ë²ˆ ?¬ì„±
 * 
 * @param data : ¤ì¦ˆˆí¬¸ì¶œ Œë¼¸í„° (±´˜ë¦¬ ?¬í•¨)
 * @return object
 */
comLib.logDocOutptHist = function($p, data) {
	// „ì‹œ DataList ™ì ¼ë¡œ ì„±œë‹¤.
	var option = {
		"id" : "dltCmmnDocOutptHist",
		"type" : "dataList",
		"option" : { "baseNode" : "list", "repeatNode" : "map" },
		"columnInfo" : [
			{"id" : "sysDivCd", "name" : "œìŠ¤œêµ¬„ì½”, "dataType" : "text" },
			{"id" : "docCd", "name" : "¸ì„œ”ë“œ", "dataType" : "text" },
			{"id" : "docNm", "name" : "¸ì„œ, "dataType" : "text" },
			{"id" : "outptDe", "name" : "œë ¥, "dataType" : "text" },
			{"id" : "outptNo", "name" : "œë ¥ˆí˜¸", "dataType" : "text" },
			{"id" : "usrId", "name" : "?¬ìš©ID", "dataType" : "text" },
			{"id" : "usrNm", "name" : "?¬ìš©ëª…", "dataType" : "text" },
			{"id" : "usrDeptNm", "name" : "?¬ìš©ëœëª…", "dataType" : "text" },
			{"id" : "outptDt", "name" : "œë ¥¼ì‹œ", "dataType" : "text" },
			{"id" : "callParmCtnt", "name" : "¸ì¶œŒë¼¸í„°´ìš©", "dataType" : "text" }
	]};
	comLib.createData($p, option);

	// exeCall data array  ë ¤
	if (data != undefined && data.length != undefined && data.length > 0) {
		for (var i = 0 ; i < data.length ; i++) {
			comLib.logDocOutptHistAjax($p, data[i]);
		}
	} else {
		// html5 data array  ë ¤
		if (data.child != undefined && data.child.length != undefined) {
			comLib.logDocOutptHistAjax($p, data);
			for (var i = 0 ; i < data.child.length; i++) {
				comLib.logDocOutptHistAjax($p, data.child[i]);
			}
		// ¼ë°˜ì¸ €´ìŠ¤
		} else {
			comLib.logDocOutptHistAjax($p, data);
		}
	}
	return dltCmmnDocOutptHist.getAllJSON();
};

/**
 * œì¸•ë³´€ ?¬í•¨¤ì¦ˆˆí¬¸ì¶œ¼ë ¨ˆí˜¸ „ë²ˆ ?¬ì„±
 * ??function?€ ì ‘ ?¬ìš©˜ì Šê³  „ì˜ comLib.logDocOutptHist ¸ì¶œ˜ì—¬ ?¬ìš©œë‹¤.
 * 
 * @param data : ¤ì¦ˆˆí¬¸ì¶œ Œë¼¸í„° (?¨ê±´)
 * @return object
 */
comLib.logDocOutptHistAjax = function($p, data) {
	if (data.customFooterInfo != undefined) {
		var requestData = {} ;
		requestData.dmaInqireParam = {
			"sysDivCd" : comLib.getSysDivCd(),
			"usrId" : comLib.getUsrId(),
			"docCd" : data.customFooterInfo.docCd,
			"docNm" : data.customFooterInfo.docNm
		};
		var tmpCallParmCtnt = {};
		tmpCallParmCtnt.odiFileName = data.odiFileName;
		tmpCallParmCtnt.args = data.args;
		requestData.dmaInqireParam.callParmCtnt = JSON.stringify(tmpCallParmCtnt);

		var option = {
			action : "/sc/logmng/logDocOutptHist.do",
			reqData : requestData,
			success : "comLib.logDocOutptHistCallback",
			isShowMeg : false
		};
		ajaxLib.executeAjaxSync($p, option);
	}
}

/**
 * œì¸•ë³´€ ?¬í•¨¤ì¦ˆˆí¬¸ì¶œ¼ë ¨ˆí˜¸ „ë²ˆ ?¬ì„± Callback
 */
comLib.logDocOutptHistCallback = function(resBody, $p) {
	if (resBody.message.code == "success") {
		var tempArr = [];
		tempArr[0] = resBody.data;
		if ($p.getComponentById("dltCmmnDocOutptHist")) {
			$p.getComponentById("dltCmmnDocOutptHist").setJSON(tempArr, true);
		}
	} else {
		alert("fail");
	}
};

/**
 * „ì¬ ”ë©´??URLì„œ Location Search Url •ë³´˜í™˜œë‹¤.
 * 
 * @example var param = comLib.getLocSearch();
 */
comLib.getLocSearch = function() {
	var href = window.location.href;
	return href.substring(href.indexOf("?"));
};

/**
 * „ì¬ ”ë©´??URLì„œ Location Search Url •ë³´˜í™˜œë‹¤.
 * 
 * @example var param = comLib.getLocSearch();
 */
comLib.getParameter = function(key) {
	var returnValue = "";
	var parentObj =  parent;
	try {
		if (opener) {
			if (opener.location.host) {
				parentObj = opener;
			}
		}
	} catch(e) {}
	var wpopupParam;
	var pparam;
	if ($W.parentObj != undefined) {
		wpopupParam = WebSquare.util.getPopupParam();
		if (wpopupParam != undefined && wpopupParam != null) {
			pparam = JSON.parse(WebSquare.util.getPopupParam());
		}
	}

	var param = comLib.getLocSearch();
	var arrData = [];

	// WEBSQUARE ì—… Œë¼¸í„° „ë‹¬ ›ëŠ” ½ìš°
	if (!utilLib.isNull(pparam)) {
		returnValue = WebSquare.net.getParameter(key);
	} else if (param.indexOf("&") >= 0) {
		// window.open GET ©ì‹½ìš°
		arrData = param.substr(param.indexOf("&") + 1, param.length).split("&");
		for (var i = 0; i < arrData.length; i++) {
			if (arrData[i].split("=")[0] == key) {
				returnValue = arrData[i].split("=")[1];
			}
		}
	} else {
		// window.open POST ©ì‹½ìš°
		returnValue = WebSquare.session.getAttribute(key);
	}

	return returnValue;
};

/***
 *  œìŠ¤€¬ì ip Œí•œ ´í¬
 */
comLib.sysAdminChkIp = function($p) {
	var option = {
		action : "/sc/authmng/getRetrieveUsrSysAdminIpchk.do",
		reqData : "",
		success : "comLib.sysAdminChkIpCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjaxSync($p, option);
};

/**
 *  œìŠ¤€¬ì ip Œí•œ ´í¬ collBack
 */
comLib.sysAdminChkIpCallback = function(resBody) {
	if (resBody.message.code_name == "N") {
		// œìŠ¤œê¬ì‘ê·¼€?¥í•©ˆë‹¤.
		comLib.alert($p, utilLib.getMessage("SCM.INFO.30037"), "utilLib.winContainerClose");
		return false;
	}
};

/**
 * ¤ìš´œë“œ¬ìœ  •ë³´ ?€˜ë¦¬.
 * @param param_dwldCd 				¤ìš´œë“œ”ë“œ ("ED":‘ì¤ìš´œë“œ, "OZ":¬í¬
 * @param param_dwldScrinId 		¤ìš´œë“œ”ë©´ID
 * @param param_dwldSqlId 			¤ìš´œë“œ¼ë¦¬ID
 * @param param_dwldSearchCndCtnt 	¤ìš´œë“œ€‰ì¡°´ë‚´ * @param param_dwldRsn 			¤ìš´œë“œ¬ìœ 
 * @param param_dwldRsnDivCd 		¤ìš´œë“œ¬ìœ ¬ë¶„”ë“œ
 * @param param_callBackFunc 		œë°±¨ìˆ˜ * @return
 */
comLib.saveIntnIdvinfoDown = function($p, param_dwldCd, param_dwldScrinId, param_dwldSqlId, param_dwldSearchCndCtnt, param_dwldRsn, param_dwldRsnDivCd, param_callBackFunc) {
	var requestData = {};
	requestData.dmaSaveIntnIdvinfoDown = {
		dwldUsrId : comLib.getUsrId(), 					// ¤ìš´œë“œ¬ìš©ID
		// dwldDt : "", 								// ¤ìš´œë“œ¼ì‹œ (»ì„œ„ë‹¨ì„œ ¤ì •)
		dwldCd : param_dwldCd, 							// ¤ìš´œë“œ”ë“œ ("ED":‘ì¤ìš´œë“œ, "OZ":¬í¬
		dwldSysDivCd : comLib.getSysDivCd(), 			// ¤ìš´œë“œœìŠ¤œêµ¬„ì½”		// dwldUsrIp : "", 								// ¤ìš´œë“œ¬ìš©IP (»ì„œ„ë‹¨ì„œ ¤ì •)
		dwldScrinId : param_dwldScrinId, 				// ¤ìš´œë“œ”ë©´ID
		dwldSqlId : param_dwldSqlId, 					// ¤ìš´œë“œ¼ë¦¬ID
		dwldSearchCndCtnt : param_dwldSearchCndCtnt, 	// ¤ìš´œë“œ€‰ì¡°´ë‚´		dwldRsn : param_dwldRsn, 						// ¤ìš´œë“œ¬ìœ 
		dwldRsnDivCd : param_dwldRsnDivCd 				// ¤ìš´œë“œ¬ìœ ¬ë¶„”ë“œ (2020-03-19, µí†µ€ ”ê)
	};

	var option = {
		action : "/sc/idvinfo/saveIntnIdvinfoDown.do",
		reqData : requestData,
		success : param_callBackFunc,
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

/**
 * [µí†µ] ¤ìš´œë“œ¬ìœ …ë ¥ ì—… ¸ì¶œ.
 * @param param_dwldCd 				¤ìš´œë“œ”ë“œ ("ED":‘ì¤ìš´œë“œ, "OZ":¬í¬
 * @param param_dwldScrinId 		¤ìš´œë“œ”ë©´ID
 * @param param_dwldSqlId 			¤ìš´œë“œ¼ë¦¬ID
 * @param param_dwldSearchCndCtnt 	¤ìš´œë“œ€‰ì¡°´ë‚´ * @param param_callBackFunc 		œë°±¨ìˆ˜ * @return
 */
comLib.openDwldRsnSavePopup = function($p, param_dwldCd, param_dwldScrinId, param_dwldSqlId, param_dwldSearchCndCtnt, param_callBackFunc) {
	var url = comLib.SCM_POP_URL + "/ui/scm/sc/idvinfomng/SCMSC90000001.xml";
	// ì—…µì…˜
	var option = {
		popupID : "SCMSC90000001",
		width : 850,
		height : 350,
		title : "¤ìš´œë“œ ?¬ìœ  …ë ¥"
	};

	var strEnc = comLib.dataDecEnc(utilLib.getDate(), "E"); // ”í˜¸
	var usrInfo; // ¸ì…˜•ë³´ ˆë„€´í
	usrInfo = JSON.stringify(comLib.getUserInfo4Param(strEnc, encodeURI(option.title)));

	var jsonObj = {
		userInfo : usrInfo,
		closeCallbackFncName : param_callBackFunc, 		// œë°±¨ìˆ˜		popupId : option.popupID,
		dwldCd : param_dwldCd, 							// ¤ìš´œë“œ”ë“œ ("ED":‘ì¤ìš´œë“œ, "OZ":¬í¬ (2020.03.19 ¨ë™”ê)
		dwldScrinId : param_dwldScrinId, 				// ¤ìš´œë“œ”ë©´ID
		dwldSqlId : param_dwldSqlId, 					// ¤ìš´œë“œ¼ë¦¬ID
		dwldSearchCndCtnt : param_dwldSearchCndCtnt 	// ¤ìš´œë“œ€‰ì¡°´ë‚´	};

	comLib.openPostWinPopup($p, url, option, jsonObj);
};

/**
 * ¨ëŒì¼ ¤ìš´œë“œ  œë²„½ì—ì„± í‚¤ •ë³´ œœë‹¤.
 * (kw_framework-1.3.8-191227.jar ìš© „ìš”)
 * 
 * @param <String> name  í‚¤ ´ë¦„
 */
comLib.fileDwldDeleteCookie = function(name) {
	var today = new Date();
	today.setDate(today.getDate() - 1);
	document.cookie = name + "=" + escape(name) + "; path=/; expires=" + today.toGMTString() + ";";
};

/**
 * ¨ëŒì¼ ¤ìš´œë“œ  ¤ìš´œë“œ”ì‹œ€?OFFœë‹¤.
 * (kw_framework-1.3.8-191227.jar ìš© „ìš”)
 */
comLib.fileDwldProcMsgOff = function() {
	comLib.fileDwldDeleteCookie(comLib.FILE_DWLD_TOKEN);
	top.WebSquare.layer.hideProcessMessage();
	clearInterval(comLib.fileDwldTimer);
	comLib.fileDwldTimer = null;
};
/**
 * ¹ìŠ¤˜ì–´ ¥˜€°ì¹˜ €´ë“œ ì—… * @return €˜ê°’
 * @2020.03.04  ê·œ ì„±.
 */
comLib.onWebsquareError = function(strMsg) {
	if (confirm("?¬ìš©˜ì‹œŒë¼°ì¬ìš©€??Memory€ €±í•©ˆë‹¤.\n\n„ì²´ Œë¼°ì …ë£Œ ‹œ ´ìš© €ë“œ½ë‹ˆ\n\n€´ë“œ ˜ì´€´ë™˜ì‹œ¤ë©´ •ì¸ íƒ¼ì„¸\n\n[ "+ strMsg + "]")) {
		window.open(comLib.SCM_POP_URL + "/hpcm/SCM9001.html", "WebsquareErrorGuide", "width=1400px,height=940px,left=10px,top=10px;"); // °ì¹˜€´ë“œ ”ë©´ ”ˆ
		// window.open("/hpcm/SCM9001.html", "WebsquareErrorGuide", "width=1400px,height=940px,left=10px,top=10px;"); // °ì¹˜€´ë“œ ”ë©´ ”ˆ
	}
};

/**
 * [µí†µ] OZ-¤ìš´œë“œ¬ìœ …ë ¥ ì—… ¸ì¶œ.
 * @param param_dwldCd 				¤ìš´œë“œ”ë“œ ("ED":‘ì¤ìš´œë“œ, "OZ":¬í¬
 * @param param_dwldScrinId 		¤ìš´œë“œ”ë©´ID
 * @param param_dwldSqlId 			¤ìš´œë“œ¼ë¦¬ID
 * @param param_dwldSearchCndCtnt 	¤ìš´œë“œ€‰ì¡°´ë‚´ * @param param_callBackFunc 		œë°±¨ìˆ˜ * @return
 */
comLib.openOzDwldRsnSavePopup = function($p, param_dwldCd, param_dwldScrinId, param_dwldSqlId, param_dwldSearchCndCtnt, param_callBackFunc) {
	var url = comLib.SCM_POP_URL + "/ui/scm/sc/idvinfomng/SCMSC90000002.xml";

	// ì—…µì…˜
	var option = {
		popupID : "SCMSC90000002",
		width : 850,
		height : 550,
		title : "œì¸•ë³´ ´ìš© €ˆë‚´"
	};

	var strEnc = comLib.dataDecEnc(utilLib.getDate(), "E"); // ”í˜¸
	var usrInfo; // ¸ì…˜•ë³´ ˆë„€´í
	usrInfo = JSON.stringify(comLib.getUserInfo4Param(strEnc, encodeURI(option.title)));

	var jsonObj = {
		userInfo : usrInfo,
		closeCallbackFncName : param_callBackFunc, 		// œë°±¨ìˆ˜		popupId : option.popupID,
		dwldCd : param_dwldCd, 							// ¤ìš´œë“œ”ë“œ ("ED":‘ì¤ìš´œë“œ, "OZ":¬í¬ (2020.03.19 µí†µ€ ”ê)
		dwldScrinId : param_dwldScrinId, 				// ¤ìš´œë“œ”ë©´ID
		dwldSqlId : param_dwldSqlId, 					// ¤ìš´œë“œ¼ë¦¬ID
		dwldSearchCndCtnt : param_dwldSearchCndCtnt 	// ¤ìš´œë“œ€‰ì¡°´ë‚´	};

	comLib.openPostWinPopup($p, url, option, jsonObj);
};

// ================================================
// WebSquare5 SP4 SPA °ëŠ¥ ìš©„í•œ ”ê µí†µ ?¨ìˆ˜
// ================================================

comLib.getFrameId = function($p) {
	return $p.getFrameId($p) + "_";
};

comLib.getScwin = function($p) {
	return $p.getFrame().scope.scwin;
};

/**
 * ¤ì¦ˆ°ì–´ì„±
 * 
 * @param $p 		„ì¬”ë©´??$p
 * @param option 	¤ì¦ˆ ´ê³ ì„±„í•œ µì…˜ †ì„ ½ìš° ˆí™”ì„±
 		var option = {
 		id :, 				// °ì–´ì„±¨íŠ¸ID
 		successCallBack :, 	// °ì–´ ì„±œë°±
 		ozoption :, 		//¤ì¦ˆ°ì–´ ¤ì • µì…˜ †ì„½ìš° comLib.ozDefaultOption •µì…˜¤ì • 		width :, 			// °ì–´ ?¬ê¸°
 		height :, 			// °ì–´ ?¬ê¸°
 		ozViewerId :, 		// ´ë ì„±˜ì—ˆ„ê²½ °ì–´ID
 		servletUrl :, 		//°ì–´œë²„¼ì†Œ
 		ozrFile :, 			// °ì–´ ¤ì¦ˆŒì¼(„ì²´½ë¡œ)
 		odiFileName :, 		//°ì–´ ODI Œì¼
 		args :, 			// °ì–´ ¤ê°œ€”ì¸{key1:value,key2:value} •íƒœ˜ê¸°¸ìš”
 		child :, 			// ˜ìœ„´ê³ € 		divisor :, 			// Œë¼”í„° ¬ë¶„[°ë³¸#OZ#]
 	}
 */
comLib.printOzViewer = function($p, option){
	var scwin = $p.getFrame().getWindow().scwin;
	if (typeof scwin.ozViewerList === "undefined") {
		scwin.ozViewerList = [];
	}
	var ozrOption={};
	if (option) {
		ozrOption=option;
	}
	/* ¤ì¦ˆ ˆí¬µì…˜ ˜ë¦¬ œì‘*/
	var options = {
		id : ozrOption.id ||"OZVIWER",
		successCallBack : ozrOption.successCallBack || "",
		width : ozrOption.width || "98%",
		height : ozrOption.height || "98%"
	};

	comLib.ozCnt++;
	if (options.successCallBack) {
		if (typeof options.successCallBack === "string") {
			if (options.successCallBack.indexOf("scwin") === 0) {
				options.successCallBack = $p.id + options.successCallBack ;
			}
		}
	}
	$p.$("#" + options.id).append('<div id="OZViewer' + comLib.ozCnt + '" class="viewerCntClass" style="width:' + options.width + ';height:' + options.height + '"></div>');
	var ozparamArr = comLib.ozCreateReportEx(ozrOption);
	var str = "";
	str += " SetOZParamters_OZViewer" + comLib.ozCnt + " = function(){ ";
	str += "	var oz; ";
	str += '	oz = document.getElementById("OZViewer'+comLib.ozCnt+'");  ';
	for (var i = 0; i < ozparamArr.length; i++) {
		if (ozparamArr[i].indexOf("=") > -1) {
			str += '	oz.sendToActionScript("' + ozparamArr[i].substring(0, ozparamArr[i].indexOf("=")) + '" , "' + ozparamArr[i].substring(ozparamArr[i].indexOf("=") + 1) + '");';
		}
	}
	if (!(ozrOption.ozrFile)) {
		str += '	oz.sendToActionScript("viewer.emptyframe", "true");'; // ˆí™”œë ¥
	}
	if (options.successCallBack) {
		str += ' eval("' + options.successCallBack + '")("OZViewer' + comLib.ozCnt + '");';
	}
	str += "} ";
	// console.log(str);
	eval(str);

	// START_OZJS€ œì‘˜ë©´ SetOZParamters_OZViewer ??€°ì–´ ?¨ëŸ¬¸í„°Setœë‹¤.
	var opt = [];
	opt["use_request_header"] = false; // CORS ¤ì •€½ë˜HTTP Request ©ì‹OPTIONSì„œ POST©ì‹¼ë¡œ €½í•´

	var urlozH = comLib.OZ_POP_URL + "/ozhviewer8/";
	start_ozjs("OZViewer" + comLib.ozCnt, urlozH, opt);

	scwin.ozViewerList.push("OZViewer" + comLib.ozCnt);

	return "OZViewer" + comLib.ozCnt;
};

comLib.destoryOZViewer = function($p) {
	var scwin = $p.getFrame().getWindow().scwin;

	if ((typeof scwin.ozViewerList === "undefined") || (scwin.ozViewerList.length === 0)) {
		return;
	}

	for (var i = 0; i < scwin.ozViewerList.length; i++) {
		var ozViewerId = scwin.ozViewerList[i];
		if ((typeof ozViewerId !== "undefined") && (ozViewerId !== null) && (ozViewerId !== "")) {
			document.getElementById(ozViewerId).Dispose();
		}
	}
};

comLib.createRMateChart = function($p, chartId) {
	var scwin = $p.getFrame().getWindow().scwin;
	if (typeof scwin.rMateChartList === "undefined") {
		scwin.rMateChartList = [];
	}

	var frameChartId = comLib.getFrameId($p) + chartId;
	scwin.rMateChartList.push(frameChartId);

	return frameChartId;
};

comLib.destoryRMateChart = function($p) {
	var scwin = $p.getFrame().getWindow().scwin;

	if ((typeof scwin.rMateChartList === "undefined") || (scwin.rMateChartList.length === 0)) {
		return;
	}

	for (var i = 0; i < scwin.rMateChartList.length; i++) {
		var frameChartId = scwin.rMateChartList[i];
		if ((typeof frameChartId !== "undefined") && (frameChartId !== null) && (frameChartId !== "")) {
			var element = document.getElementById(frameChartId);
			element.parentNode.removeChild(element);

			if (typeof rMateMapChartH5.instances[frameChartId] !== "undefined") {
				delete rMateMapChartH5.instances[frameChartId];
			} else if (typeof rMateChartH5.instances[frameChartId] !== "undefined") {
				delete rMateChartH5.instances[frameChartId];
			}
		}
	}
};

/*
comLib.isGisPop = function(popId) {
	popId = popId || "ECSPG91000001";
	// ˆë„ID´ì¡°?mf€ ™ìŒ
	// popId="mf_"+popId;

	try {
		if (window.$p.top().ifmGis) {
			if (window.$p.top().ifmGis.getWindow().$p.main().$p.getPopupWindow(popId)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (opener) {
				var openhost="";
				try {
					openhost=opener.location.host;
				} catch(e) {}
				if (window.location.host !==openhost) {
					if (window.name==popId) {
						return true;
					} else {
						console.error("comLib.isGisPop =>´ë‹¹½ì´ì—… ”ì²­ ½ì´ „ë‹™ˆë‹¤.");
						return false;
					}
				} else {
					if (opener.$p.top().ifmGis) {
						if (opener.$p.top().ifmGis.getWindow().$p.main().$p.getPopupWindow(popId)) {
							return true;
						} else {
							return false;
						}
					}
				}
			}
		}
		console.error("comLib.isGisPop =>”ì¸½ê°´ë €¸ì˜¬†ìŠµˆë‹¤");
		return false;
		//var parentObj = comLib.getParent();
		//if (parentObj.$p.isPopup()) {
		//	parentObj = parentObj.comLib.getParent();
		//}
		//if (parentObj.$p.top().ifmGis===undefined) {
		//	return false;
		//}
		//var gisWin = parentObj.$p.top().ifmGis.getWindow();

		//if (gisWin.$p.main().$p.getPopupWindow(popId) !== undefined) {
		//	return true;
		//} else {
		//	return false;
		//}
	} catch(e) {
		console.error("comLib.isGisPop =>”ì¸½ê°´ë €¸ì˜¬†ìŠµˆë‹¤");
		console.error(e);
		return false;
	}
};
*/

/**
 * [µí†µ] GIS½ì˜ scwin’ì„ °íšŒ (—…¬í•¨)
 * @return GIS½ì˜ scwin
comLib.getGisWindow = function(popId) {
	popId = popId || "ECSPG91000001";
	// ˆë„ID´ì¡°?mf€ ™ìŒ
	// var popId="ECSPG91000001";
	try {
		if (window.$p.top().ifmGis) {
			if (window.$p.top().ifmGis.getWindow().$p.main().$p.getPopupWindow(popId)) {
				return window.$p.top().ifmGis.getWindow().$p.main().$p.getPopupWindow(popId);
			} else {
				return window.$p.top().ifmGis.getWindow();
			}
		} else {
			if (opener) {
				var openhost="";
				try {
					openhost=opener.location.host;
				} catch(e){}
				if (window.location.host !==openhost) {
					//?€œìŠ¤œì—½ì„ ´ì—ˆ½ìš° ´ë‹¹ °ëŠ¥¼ë¡œ ¸ì‹
					return top.window;
				} else {
					if (opener.$p.top().ifmGis) {
						if (opener.$p.top().ifmGis.getWindow().$p.main().$p.getPopupWindow(popId)) {
							return opener.$p.top().ifmGis.getWindow().$p.main().$p.getPopupWindow(popId);
						} else {
							return opener.$p.top().ifmGis.getWindow();
						}
					}
				}
			}
		}
		console.error("comLib.getGisWindow =>”ì¸½ê°´ë €¸ì˜¬†ìŠµˆë‹¤");
		return undefined;
	} catch(e) {
		console.error("comLib.getGisWindow =>”ì¸½ê°´ë €¸ì˜¬†ìŠµˆë‹¤");
		console.error(e);
		return undefined;
	}
};
*/

/**
 * [µí†µ] GIS½ì˜ scwin’ì„ °íšŒ (—…¬í•¨)
 * @return GIS½ì˜ scwin
comLib.getGisScwin = function(popId) {
	popId = popId || "ECSPG91000001";
	// ˆë„ID´ì¡°?mf€ ™ìŒ
	// var popId="mf_"+ "ECSPG91000001";
	// var popId = "ECSPG91000001";
	try {
		if (window.$p.top().ifmGis) {
			if (window.$p.top().ifmGis.getWindow().$p.main().$p.getPopupWindow(popId)) {
				return window.$p.top().ifmGis.getWindow().$p.main().$p.getPopupWindow(popId).$p.main();
			} else {
				return window.$p.top().ifmGis.getWindow().$p.main();
			}
		} else {
			if (opener) {
				var openhost="";
				try{
					openhost=opener.location.host;
				} catch(e){}
				if (window.location.host !==openhost) {
					return $p.main();
				} else {
					if (opener.$p.top().ifmGis) {
						if (opener.$p.top().ifmGis.getWindow().$p.main().$p.getPopupWindow(popId)) {
							return opener.$p.top().ifmGis.getWindow().$p.main().$p.getPopupWindow(popId).$p.main();
						} else {
							return opener.$p.top().ifmGis.getWindow().$p.main();
						}
					}
				}
			}
		}
		console.error("comLib.getGisScwin =>”ì¸½ê°´ë €¸ì˜¬†ìŠµˆë‹¤");
		return undefined;
	} catch(e) {
		console.error("comLib.getGisScwin =>”ì¸½ê°´ë €¸ì˜¬†ìŠµˆë‹¤");
		console.error(e);
		return undefined;
	}
};
*/

/**
 * [µí†µ] wfram parameter ¤ì •„í•œ ì²´ì„±
 * @return wfram parameter
 */
comLib.getSrcParamObj = function(paramJson) {
	var paramobj={
		dataObject: {
			type : "json", 
			name : "wframeParam",
			data : paramJson
		}
	};
	return paramobj;
};

/**
 * [µí†µ] callBack?¨ìˆ˜€ •ìƒ¸ì ´í¬´ì„œ ¥˜ œì¶œ œê·¸
 * @return wfram parameter
 */
comLib.getCheckCallBackFunc = function(callBack,funcName) {
	if (callBack) {
		if (typeof callBack=== "function") {
			return;
		}
		/* œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ € ŒìŠ¤´í›„  œˆì •*/
		try {
			var callBackFncObj = eval(callBack);
			if (typeof callBackFncObj!== "function") {
				if (funcName) {
					console.error("´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ˜ë¦¬??" + funcName + " /?¨ìˆ˜: " + callBack);
					alert("´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ˜ë¦¬??" + funcName + " /?¨ìˆ˜: " + callBack);
				} else {
					console.error("´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + callBack);
					alert("´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + callBack);
				}
			}
		} catch(e) {
			if (funcName) {
				console.error("´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ˜ë¦¬??" + funcName + " /?¨ìˆ˜: " + callBack);
				alert("´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ˜ë¦¬??" + funcName + " /?¨ìˆ˜: " + callBack);
			} else {
				console.error("´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + callBack);
				alert("´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + callBack);
			}
		}
		/* œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ €???*/
	}
};

/**
 * „ì¬ ”ë©´ì—…Œë¼”í„°€¸ì˜¨
 * 
 * @param $p 			„ì¬”ë©´??$p
 * @param paramlist 	„ì¬”ë©´ì„œ ?¬ìš©Œë¼”íkey List [œì™¸: popupId, closeCallbackFncName]
 * @return ì—…½ì˜ getPopupParam jsonì²´˜í™˜
 */
comLib.getPopupParam = function($p, paramlist) {
	var pparam ;
	// $p.openPopup ¼ë¡œ ´ë¦° ½ì¼½ìš° $p.getParameter("popupID") € ˜ë“œ´ì¬ [iframePopup, wframePopup, browserPopup] ¨ë“ €´ì¬
	if ($p.getParameter("popupID")) {
		if ($p.isWFramePopup()) {
			if ($p.getPopupParam()) {
				pparam= JSON.parse($p.getPopupParam());
			} else {
				// ˜ê²¨€ Œë¼”í„° ì²´€ †ëŠ”½ìš°€ ´ì¬				pparam = {};
			}
			pparam.openType="wframePopup";
		} else {
			// iframePopup ?€ ?¬ìš©Ší•˜€?wframePopup „ë‹½ìš° browserPopup¼ë¡œ ë‹¨
			if ($p.getPopupParam()) {
				pparam = JSON.parse($p.getPopupParam());
				// console.log("$p.getPopupParam()========================");
				// console.info(pparam);
			} else if ($w.getPopupParam()) {
				// ë˜ $p.getPopupParam ¼ë¡œ ˜ê²¨›ì•„˜ëŠ ¹ìŠ¤˜ì–´ ¥˜¸ì $wœë§Œ €?¥í•œ ½ìš°€ ˆìŒ
				pparam = JSON.parse($w.getPopupParam());
				// console.log("$w.getPopupParam()========================");
				// console.info(pparam);
			} else {
				// ˜ê²¨€ Œë¼”í„° ì²´€ †ëŠ”½ìš°€ ´ì¬				pparam = {};
			}
			pparam.openType="browserPopup";
		}
		pparam.popupID=$p.getParameter("popupID");
		//console.log("pparam========================");
		//console.info(pparam);
	} else if (window.location.search.indexOf("&") >= 0) {
		// window.open GET ©ì‹½ìš°
		pparam = {};
		var arrData = window.location.search.substr(window.location.search.indexOf("&") + 1, window.location.search.length).split("&");
		for (var i = 0; i < arrData.length; i++) {
			if (arrData[i].split("=")[0] == "title") {
				document.title = decodeURI(unescape(arrData[i].split("=")[1]));
			}
			if (arrData[i].split("=")[0] == "closeCallbackFncName") {
				pparam.closeCallbackFncName = arrData[i].split("=")[1];
				// callBack = arrData[i].split("=")[1];
			}
			if (arrData[i].split("=")[0] == "popupId") {
				pparam.popupID = arrData[i].split("=")[1];
				// popupId = arrData[i].split("=")[1];
			}
			if (paramlist) {
				for (var j = 0; j < paramlist.length; j++) {
					if (arrData[i].split("=")[0] == paramlist[j]) {
						pparam[paramlist[j]] = arrData[i].split("=")[1];
						break;
					}
				}
			}
		}
		pparam.openType="window";
		pparam.methodsType="GET";
	} else {
		if (!(WebSquare.session.getAttribute("popupId"))) {
			return {};
		}
		// window.open POST ©ì‹½ìš°
		userInfo = JSON.parse(WebSquare.session.getAttribute("userInfo"));
		document.title = decodeURI(userInfo.title);
		pparam = {};
		if (paramlist) {
			for (var j = 0; j < paramlist.length; j++) {
				pparam[paramlist[j]] = WebSquare.session.getAttribute(paramlist[j]);
			}
		}
		pparam.openType = "window";
		pparam.popupID = WebSquare.session.getAttribute("popupId");
		pparam.closeCallbackFncName = WebSquare.session.getAttribute("closeCallbackFncName");
		pparam.methodsType = "POST";
	}
	//console.log("window open Parameter========================");
	//console.info(pparam);
	return pparam;
};

/**
 * „ì¬ ”ë©´œë°±˜ë¦¬ ½ë‹«¸ì¶œ
 * 
 * @param $p 			„ì¬”ë©´??$p
 * @param popupParam 	„ì¬”ë©´ë„˜´ì˜¨ Œë¼”í„°
 * @param confirmTF 	•ì¸¬ë trueœë°±¸ì¶œ˜ë¦¬ * @param rtnObj 		˜ê²¨ì²´
 */
comLib.closePopupCall = function($p, popupParam, confirmTF, rtnObj) {
	var mode = popupParam.openType || "window";
	// wframePopupœì™¸½ìš°opener€ ˆê³  °ê¸°ì„œ eval˜ë¦¬ ??window.close ˜ì—¬	if (mode=="window" || mode=="browserPopup") {
		if (confirmTF == true) {
			if (opener) {
				if (popupParam.closeCallbackFncName) {
					/* œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ € ŒìŠ¤´í›„  œˆì •*/
					try {
						var callBackFncObj = opener.eval(popupParam.closeCallbackFncName);
						if (typeof callBackFncObj!== "function") {
							console.error("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
							// alert("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
						}
					} catch(e) {
						console.error("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
						// alert("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
					}
					/* œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ €???*/
					opener.eval(popupParam.closeCallbackFncName)(rtnObj);
				} else {
					console.error("€¨ì°½ì„œ œë°±¨ìˆ˜ ¤ì •˜ì Šì•˜µë‹ˆ options.popupParam.closeCallbackFncName");
				}
			} else {
				console.error("€¨ì°½´ë ?«í˜”°ë‚˜ ¾ì„†ì–´ ˜ë¦¬€ ˆê©ë‹ˆ  ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
				// alert("€¨ì°½´ë ?«í˜”°ë‚˜ ¾ì„†ì–´ ˜ë¦¬€ ˆê©ë‹ˆ  ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
			}
		}
		window.close();
	} else {
		if (confirmTF == true) {
			comLib.closePopup($p.parent().$p, popupParam.popupID, popupParam.closeCallbackFncName, rtnObj);
		} else {
			comLib.closePopup($p.parent().$p, popupParam.popupID);
		}
	}
};

/**
 * „ì¬ ”ë©´œë°±˜ë¦¬
 * 
 * @param $p „ì¬”ë©´??$p
 * @param popupParam „ì¬”ë©´ë„˜´ì˜¨ Œë¼”í„°
 * @param rtnObj ˜ê²¨ì²´
 */
comLib.openPopupCallBack = function($p, popupParam, rtnObj) {
	if (!(popupParam.closeCallbackFncName)) {
		return;
	}
	var mode = popupParam.openType|| "window";
	// wframePopupœì™¸½ìš°opener€ ˆê³  °ê¸°ì„œ eval˜ë¦¬ ??window.close ˜ì—¬	if (mode=="window" || mode=="browserPopup") {
		if (opener) {
			/* œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ € ŒìŠ¤´í›„  œˆì •*/
			try {
				var callBackFncObj = opener.eval(popupParam.closeCallbackFncName);
				if (typeof callBackFncObj!== "function") {
					console.error("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
					// alert("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
				}
			} catch(e) {
				console.error("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
				// alert("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
			}
			/* œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ €???*/
			opener.eval(popupParam.closeCallbackFncName)(rtnObj);
		} else {
			console.error("€¨ì°½´ë ?«í˜”°ë‚˜ ¾ì„†ì–´ ˜ë¦¬€ ˆê©ë‹ˆ  ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
			// alert("€¨ì°½´ë ?«í˜”°ë‚˜ ¾ì„†ì–´ ˜ë¦¬€ ˆê©ë‹ˆ  ?¨ìˆ˜: " + popupParam.closeCallbackFncName);
		}
	} else {
		var callBackFnc = popupParam.closeCallbackFncName;
		if (callBackFnc.indexOf("scwin.") === 0) {
			callBackFnc = $p.parent().$p.id + callBackFnc;
		}
		/* œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ € ŒìŠ¤´í›„  œˆì •*/
		try {
			var callBackFncObj = eval(callBackFnc);
			if (typeof callBackFncObj!== "function") {
				console.error("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + callBackFnc);
				alert("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + callBackFnc);
			}
		} catch(e) {
			console.error("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + callBackFnc);
			alert("€¨ì°½ì„œ ´ë‹¹ ?¨ìˆ˜¾ì„†ìŠµˆë‹¤. ?¨ìˆ˜: " + callBackFnc);
		}
		/* œë°±¨ìˆ˜ ˜ë¦¬ ¥˜ €???*/
		eval(callBackFnc)(rtnObj);
	}
};

/**
 * DATAì„±
 * 
 * @param $p „ì¬”ë©´??$p
 * @param popupParam „ì¬”ë©´ë„˜´ì˜¨ Œë¼”í„°
 * @param rtnObj ˜ê²¨ì²´
 */
comLib.createData = function($p, option) {
	if ($p.getComponentById(option.id)) {
		$p.data.remove(option.id);
	}
	$p.data.create(option);
};

/**
 * ¤ì¦ˆ¬í¬°ë³¸ µì…˜[?¬ê¸°”ê¾¸¤ì • †ëŠ” ’ì °ë³¸ìœ¼”ë€
 * 
 * @param $p „ì¬”ë©´??$p
 * @param popupParam „ì¬”ë©´ë„˜´ì˜¨ Œë¼”í„°
 * @param rtnObj ˜ê²¨ì²´
 */
comLib.ozDefaultOption = function() {
	var option = {
		"viewer" : {
			"usetoolbar" : "true", // ´ë°”œì‹œ
			"progresscommand" : "true", //´ë²¤¸ì‚¬©ì—¬€
			"pagedisplay" : "singlepagecontinuous", //˜ì´€ œì‹œ µì…˜ [œí˜´ì°ì†´ê¸°]
		},
		"connection" : {
			"pcount" : "1" //’ì„ ¤ì •¨ëŸ¬¸í„°œìˆ˜
		},
		"toolbar" : {
			"pdf" : "true", //´ë°” pdf,‘ì,html
			"xlsx" : "true",
			"hml" : "true"
		},
		"hml" : {
			"saveasxml" : "false"
		},
		"export" : {
			"fomat" : "xls",
			"largebundle" : "true" // œí˜´ì€		},
		"excel" : {
			"numberformat" : "default", //?«ììŠ¤€œì‹ default œ
			"savenumbertype" : "true", //œì‹œ•ì‹«ì¼ë²¨ìš©µì…˜ ´í¬
			"largebundle" : "true"
		},
		"xlsx" : {
			"numberformat" : "default",
			"savenumbertype" : "true",
			"largebundle" : "true"
		}
	}
	return option;
};

/**
 * ¤ì¦ˆ°ì–´´ê³ ”ì¸ * 
 * @param option ¤ì¦ˆ ´ê³ ì„±„í•œ µì…˜ †ì„ ½ìš° ˆí™”ì„±
 	var option = {
 		id :, 					// °ì–´ì„±¨íŠ¸ID [ˆí•„ ì„±œë§Œ ?¬ìš©]
 		successCallBack :, 		// °ì–´ ì„±œë°± [ˆí•„ ì„±œë§Œ ?¬ìš©]
 		ozoption :, 			// ¤ì¦ˆ°ì–´ ¤ì • µì…˜ †ì„½ìš° comLib.ozDefaultOption •µì…˜¤ì • 		width :, 				// °ì–´ ?¬ê¸° [ˆí•„ ì„±œë§Œ ?¬ìš©]
 		height :, 				// °ì–´ ?¬ê¸° [ˆí•„ ì„±œë§Œ ?¬ìš©]
 		ozViewerId :, 			// ´ë ì„±˜ì—ˆ„ê²½°ì–´ID [„ìˆ˜…ë ¥]
 		servletUrl :, 			// °ì–´œë²„¼ì†Œ
 		ozrFile :, 				// °ì–´ ¤ì¦ˆŒì¼(„ì²´½ë¡œ)
 		odiFileName :, 			// °ì–´ ODI Œì¼
 		args :, 				// °ì–´ ¤ê°œ€”ì¸{key1: value, key2: value} •íƒœ˜ê¸°¸ìš”
 		child :, 				// ˜ìœ„´ê³ € 		divisor :, 				// Œë¼”í„° ¬ë¶„[°ë³¸ #OZ#]
 	}
 */
comLib.ozCreateReportEx = function(option) {
	var ozoption = comLib.ozDefaultOption();
	if (option.ozoption) {
		var keys1 = Object.getOwnPropertyNames(option.ozoption);
		for (var i = 0; i < keys1.length; i++) {
			var keys2 = Object.getOwnPropertyNames(option.ozoption[keys1[i]]);
			for(var j = 0; j < keys2.length; j++) {
				ozoption[keys1[i]][keys2[j]] = option.ozoption[keys1[i]][keys2[j]];
			}
		}
	}
	var argmentArray = [];
	var keys_1 = Object.getOwnPropertyNames(ozoption);
	for(var i = 0; i < keys_1.length; i++) {
		var keys_2 = Object.getOwnPropertyNames(ozoption[keys_1[i]]);
		for(var j=0; j < keys_2.length; j++) {
			argmentArray.push(keys_1[i] + "." + keys_2[j] + "=" + ozoption[keys_1[i]][keys_2[j]]);
		}
	}
	if (!(option.ozrFile)) {
		return argmentArray;
	}
	if (!(option.servletUrl)) {
		var servletUrl = comLib.OZ_POP_URL + "/server";
		// œì¸•ë³´ ?¬ìš©¬ë œê·¸ „ì „í•œ ”ê ”ë“œ
		servletUrl += "?usrId=" + comLib.getUsrId() + "&sysDivCd=" + comLib.getSysDivCd();
		option.servletUrl = servletUrl;
	}
	if (!(option.divisor)) {
		option.divisor="#OZ#";
	}
	argmentArray.push("connection.servlet=" + option.servletUrl);
	argmentArray.push("connection.reportname=" + option.ozrFile);
	argmentArray.push("odi.odinames=" + option.odiFileName);
	if (option.args) {
		var keys_args = Object.getOwnPropertyNames(option.args);
		argmentArray.push("odi." + option.odiFileName + ".pcount=" + keys_args.length);
		for (var i = 0; i < keys_args.length; i++) {
			argmentArray.push("odi." + option.odiFileName + ".args" + (i + 1) + "=" + keys_args[i] + "=" + (option.args[keys_args[i]]  option.args[keys_args[i]] : ""));
		}
	} else {
		argmentArray.push("odi." + option.odiFileName + ".pcount=0");
	}
	if (option.child) {
		for (var i = 0; i < option.child.length; i++) {
			argmentArray.push("child" + (i + 1) + ".viewer.isframe=true");
			if (option.child[i].servletUrl) {
				argmentArray.push("child" + (i + 1) + ".connection.servlet=" + option.child[i].servletUrl);
			} else {
				argmentArray.push("child" + (i + 1) + ".connection.servlet=" + option.servletUrl);
			}
			argmentArray.push("child" + (i + 1) + ".connection.reportname=" + option.child[i].ozrFile);
			if (option.args) {
				var childkeys_args = Object.getOwnPropertyNames(option.args);
				argmentArray.push("odi." + option.child[i].odiFileName + ".pcount=" + childkeys_args.length);
				for (var j = 0; j < childkeys_args.length; j++) {
					argmentArray.push("odi." + option.child[i].odiFileName + ".args" + (j + 1) + "=" + childkeys_args[j] + "=" + (option.child[i].args[childkeys_args[j]]  option.child[i].args[childkeys_args[j]] : ""));
				}
			} else {
				argmentArray.push("child" + (i + 1) + ".odi." + option.child[i].odiFileName + ".pcount=0");
			}
		}
		if (option.child.length > 0) {
			argmentArray.push("viewer.showtree=true");
			argmentArray.push("viewer.childcount=" + option.child.length);
			argmentArray.push("global.inheritparameter=true");
			argmentArray.push("global.concatpage=true");
		}
	}
	if (option.ozViewerId) {
		var ozParamStr = argmentArray.join(option.divisor);
		//console.log("ozParamStr: " + ozParamStr);
		window[option.ozViewerId].CreateReportEx(ozParamStr + option.divisor, option.divisor);
	} else {
		// ¤ì¦ˆ°ì–´ ì„±¸ì¶œ ê²½°ì—´¬í„° ´ì£¼ˆê¸°”ì—ë™ ”ì¸©ë˜„ë¡ ˜ë¦¬		return argmentArray;
	}
};
/*
 * [µí†µ] SCM_Tì„œ 404 ¥˜ œìƒ ˜ë¦¬.
 * @ param http ‘ë‹µ http Response
 * ‘ì„±: €€ 2021.05.03
 */
comLib.processError = function(http) {
	var url;
	var strArray;
	var vartmpValue;
	var idx;

	// xmlHttpRequest??responseURLì„œ ˆë„°ID Œì‹±
	url = http.responseURL;
	strArray = url.split("/");
	tmpValue = strArray[strArray.length - 1];
	idx = tmpValue.indexOf(".");

	var windowId = tmpValue.substring(0, idx);
	//console.log(windowId);
	$p.top().wdcMain.closeWindow(windowId);

	comLib.alert($p, "”ì²­˜ì‹  ˜ì´€€ ´ì¬˜ì ŠìŠµˆë‹¤.");
};

comLib.createWindow = function(title, iconUrl, src, windowTitle, windowId, openAction, closeAction, windowTooltip, windowHeaderHTML, options, frameMode, dataObj) {
	// œê°„€¼ê³  –‰´ì•¼ ?¬ì»¤•ìƒ´ë™	var m_frameMode = frameMode || "wframe";
	setTimeout(function() {
		$p.top().wfm_left.getWindow().scwin.createWindow(title , iconUrl , comLib.getContextPath() + src, windowTitle, windowId, openAction, closeAction, windowTooltip, windowHeaderHTML, options, m_frameMode || "wframe", dataObj);
	}, 200);
};