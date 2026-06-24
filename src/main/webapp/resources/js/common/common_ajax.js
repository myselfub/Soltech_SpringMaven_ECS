/**
 * @target  서버와 통신(Ajax, Submission)을 위한 공통 함수
 * @type	ajaxLib
 * @since2017.04.03
 * @author TJ Kim
 */

var ajaxLib = {};

ajaxLib.CONTEXT_PATH = ""; // Context Path 경로
ajaxLib.SERVICE_URL = ""; // Service Url
ajaxLib.DEFAULT_OPTIONS_MODE = "asynchronous"; // 기본 통신 모드 (asynchronous / synchronous)
ajaxLib.DEFAULT_OPTIONS_MEDIATYPE = "application/json"; // 기본 미디어 타입

/**
 * 서버와 Ajax 통신을 수행한다.
 * 
 * @date 2014. 12. 9.
 * @param {Object} options
 * <br/>※ options JSON형태 객체
 * <br/>options.action	: ajax 요청주소
 * <br/>options.mode		 : asynchronous(default)/synchronous
 * <br/>options.mediatype	: mediatype
 * <br/>options.method	: get/post/put/delete
 * <br/>options.isProcessMsg : 서비스 처리중에 메시지를 보여줄지 여부 설정 (true || false)
 * <br/>options.processMsg: 서비스 처리중에 보여줄 메시지 (ex. "요청하신 서비스를 처리중입니다"), 설정하지 않는 경우 기본 메시지를 출력한다.
 * <br/>					processMsg 옵션을 설정하는 경우에는 isProcessMsg 메시지를 설정하지 않아도 서버 통신중에 메시지를 출력한다.
 * <br/>options.reqData	  : 요청 데이터 (XML Object, XML String, JSON Object, JSON String)
 * <br/>options.timeout	  : ajax요청후 timeout 시간. 이시간이 초과해도 응답이 오지 않는 경우 error callback함수를 실행
 * <br/>options.type		 : xml/json. xml인 경우 success callback함수의 인자객체의 responseBody속성에 xml객체가 설정된고, json인 경우 자바스크립트 객체가 설정된다.
 * <br/>					나머지 경우는 text형식이 설정.
 * <br/>options.beforeAjax: 요청전에 실행되는 함수로 이 함수내에서 false를 return하면 ajax요청을 하지 않는다
 * <br/>options.success	  : 요청이 성공한 경우 실행되는 callback함수
 * <br/>options.error		: 요청이 실패한 경우 실행되는 callback함수
 * <br/>options.resData	  : Response된 데이터를 세팅할 DataCollection(DataList, DataMap) 객체
 * <br/>options.isShowMeg	: callback 함수가 지정되지 않은 경우에 서버에서 전달받은 메시지를 Alert 할 것인지 여부
 * @example ajaxLib.executeAjax(options);
 * 
 */
ajaxLib.executeAjax = function($p, options) {
	var action = "";

	if (options.action.startsWith("/") || options.action.startsWith("http")) {
		action =  options.action;
	}
	else {
		action =  "/"+ options.action;
	}

	var mode = options.mode || ajaxLib.DEFAULT_OPTIONS_MODE;
	var mediatype = options.mediatype || ajaxLib.DEFAULT_OPTIONS_MEDIATYPE;
	var method = (options.method || "post").toLowerCase();
	var isProcessMsg = (options.isProcessMsg==undefined?true:options.isProcessMsg);
	var processMsg = options.processMsg || "";
	var requestHeader = options.requestHeader || {"client-type" : "WEBSQUARE"}; //(중요)ClientDetector를 위해 추가
	var reqData = "";
	var timeout = options.timeout || 0;

	var successCallBack = options.success || "";
	if(successCallBack) {
		if(typeof successCallBack === "string") {
			if (successCallBack.indexOf("scwin") === 0) {
				successCallBack =$p.id+successCallBack ;
			}
		}
	}
	comLib.getCheckCallBackFunc(successCallBack,"ajaxLib.executeAjax");/* 콜백함수 처리 오류 검증  테스트 이후 삭제예정*/

	var errorCallBack = options.error || "";
	if(errorCallBack) {
		if(typeof errorCallBack === "string") {
			if (errorCallBack.indexOf("scwin") === 0) {
				errorCallBack =$p.id+errorCallBack ;
			}
		}
	}
	comLib.getCheckCallBackFunc(errorCallBack,"ajaxLib.executeAjax");/* 콜백함수 처리 오류 검증  테스트 이후 삭제예정*/
	var isShowMeg = false;
	var savedToken = (options.savedToken?options.savedToken:false);

	if ((isProcessMsg === true) && (processMsg === "")) {
		//mode : synchronous 인 경우에 processMsg 사용불가.
		//synchronous 라는 모드 자체가 응답이 올 때까지 process를 잡고 있는 경우이므로 브라우저에 따라 다른 현상이 발생할 수 있어 synchronous 모드에서는 processMsg 를 지원하지 않습니다.
		processMsg = mode == "synchronous" ? "" : "해당 작업을 처리중입니다";
	}

	if (typeof options.isShowMeg !== "undefined") {
		isShowMeg = options.isShowMeg;
	}

	if ((mediatype.indexOf("xml") >= 0) && ((typeof options.reqData) === "object")) {
		reqData = WebSquare.xml.serialize(options.reqData);
	} else if ((mediatype.indexOf("json") >= 0) && ((typeof options.reqData) === "object")) {
			reqData = JSON.stringify(options.reqData);
	} else {
		reqData = options.reqData;
	}

	var savedTokenData = {};

	if(savedToken) {
		savedTokenData = JSON.parse(reqData);
//		eval("savedTokenData." + comLib.KTAG_TOKEN_FIELD + "='" + comLib.SAVED_TOKEN + "'");
//		eval("savedTokenData." + comLib.SAVED_TOKEN + "='" + comLib.getSavedToken() + "'");
		savedTokenData.ktagTokenField = comLib.SAVED_TOKEN;
//		savedTokenData.savedToken = comLib.getSavedToken();
		savedTokenData[comLib.SAVED_TOKEN] = comLib.getSavedToken();
		reqData = JSON.stringify(savedTokenData);
	}

	var resBody = null;

	// 이벤트로그에 화면ID담기 - 2017.12.20
	reqData = ajaxLib.addScrinId(reqData);

	var ajaxOptions = {
		action : action,
		mode : mode,
		mediatype : mediatype,
		method : method,
		processMsg : processMsg,
		requestData : reqData,
		requestHeader : requestHeader,
		timeout : timeout,
		frameId : $p.getFrameId(),
		beforeAjax : function(e) {
		},
		success : function(e) {
			//var $p = $w.getComponentById(this.frameId).scope.$p;
			//e.id = $p.getFrameId();

			if (mediatype === "application/xml") {
				if (typeof e.responseBody != "undefined")
					resBody = WebSquare.xml.parse(e.responseBody);
				var resData = WebSquare.xml.findNode(resBody, "data");
				if ((typeof options.resData !== "undefined" && options.resData != "") && (typeof resData !== "")) {
					options.resData.setXML(resData);
				}
			} else if (mediatype === "application/json") {
				resBody = e.responseJSON;
				if ((typeof options.resData !== "undefined" && options.resData != "") && (typeof resBody.data !== "undefined" && typeof resBody.data !== "")) {
					//Data Collection 데이터 셋팅
					if (!options.resData.getObjectType()) {
						return;
					}
					var dataType = options.resData.getObjectType().toLowerCase();
					if (dataType === "datamap") {
						if ($.isArray(resBody.data)) {
							options.resData.setJSON(resBody.data[0]);
						} else {
							options.resData.setJSON(resBody.data);
						}
					} else if (dataType === 'datalist') {
						options.resData.setJSON(resBody.data);
					}
					if(options.reqData) {
						if(options.reqData.pageSize) {
							//pageList pageCount 셋팅
							if(options.reqData.pageSize > 0 && options.reqData.pageNo == 1) {
								if(resBody.totalCount == 0) {
									resBody.pageCount = 0;
								} else {
									resBody.pageCount = parseInt(resBody.totalCount / options.reqData.pageSize) == 0 ? 1 : parseInt(resBody.totalCount / options.reqData.pageSize);
									window[options.reqData.pageList].setCount(resBody.pageCount);
								}
							}
						}
					}
				}
			} else {
				resBody = e.responseText;
			}

			if(resBody.outSavedToken != null && (typeof resBody.outSavedToken !== "undefined")) {
				try {
					comLib.setSavedToken (resBody.outSavedToken);
					//alert("outSavedToken=" + comLib.getSavedToken());
				}catch(tokenEx) {}
			}
			if (resBody.message.code === comLib.STATUS_ERROR) {
				comLib.alert($p, resBody.message.code_name, errorCallBack);
			} else {
				if(successCallBack) {
					 if (typeof successCallBack === "function") {
						 successCallBack(resBody, $p);
					} else {
						eval(successCallBack)(resBody, $p);
					}
				}
			}
		},
		error : function(e) {
			//var $p = $w.getComponentById(this.frameId).scope.$p;
			//e.id = $p.getFrameId();
			//공통에러처리
			ajaxLib.errorHandler($p, e);
			if(errorCallBack) {
				if (typeof errorCallBack === "function") {
					errorCallBack(resBody, $p);
				} else {
					eval(errorCallBack)(resBody, $p);
				}
			}
			//else {공통에러 처리에서 메세지창 띄움
				//comLib.alert($p, e.message);
			//}
		}
	};

	try {
		WebSquare.net.ajax(ajaxOptions);
		return resBody;
	} catch (e) {
		$w.log("[ajaxLib.executeAjax] Exception :: " + e.message);
	} finally {
		AjaxCallptions = null;
		resBody = null;
	}
};

/**
 * 서버와 Ajax 동기화 통신을 수행한다.
 * 
 * @date 2014. 12. 9.
 * @param {Object} options
 * <br/>※ options JSON형태 객체
 * <br/>options.action	: ajax 요청주소
 * <br/>options.mode		 : synchronous
 * <br/>options.mediatype	: mediatype
 * <br/>options.method	: get/post/put/delete
 * <br/>options.isProcessMsg : 서비스 처리중에 메시지를 보여줄지 여부 설정 (true || false)
 * <br/>options.processMsg: 서비스 처리중에 보여줄 메시지 (ex. "요청하신 서비스를 처리중입니다"), 설정하지 않는 경우 기본 메시지를 출력한다.
 * <br/>					processMsg 옵션을 설정하는 경우에는 isProcessMsg 메시지를 설정하지 않아도 서버 통신중에 메시지를 출력한다.
 * <br/>options.reqData	  : 요청 데이터 (XML Object, XML String, JSON Object, JSON String)
 * <br/>options.timeout	  : ajax요청후 timeout 시간. 이시간이 초과해도 응답이 오지 않는 경우 error callback함수를 실행
 * <br/>options.type		 : xml/json. xml인 경우 success callback함수의 인자객체의 responseBody속성에 xml객체가 설정된고, json인 경우 자바스크립트 객체가 설정된다.
 * <br/>					나머지 경우는 text형식이 설정.
 * <br/>options.beforeAjax: 요청전에 실행되는 함수로 이 함수내에서 false를 return하면 ajax요청을 하지 않는다
 * <br/>options.success	  : 요청이 성공한 경우 실행되는 callback함수
 * <br/>options.error		: 요청이 실패한 경우 실행되는 callback함수
 * <br/>options.resData	  : Response된 데이터를 세팅할 DataCollection(DataList, DataMap) 객체
 * <br/>options.isShowMeg	: callback 함수가 지정되지 않은 경우에 서버에서 전달받은 메시지를 Alert 할 것인지 여부
 * @example ajaxLib.executeAjaxSync(options);
 */
ajaxLib.executeAjaxSync = function($p, options) {
	var action = "";

	if (options.action.startsWith("/") || options.action.startsWith("http")) {
	action =  options.action;
	}
	else {
	action =  "/"+ options.action;
	}

	var mode = "synchronous";
	var mediatype = options.mediatype || ajaxLib.DEFAULT_OPTIONS_MEDIATYPE;
	var method = (options.method || "post").toLowerCase();
	var isProcessMsg = (options.isProcessMsg==undefined?true:options.isProcessMsg);
	var processMsg = options.processMsg || "";
	var requestHeader = options.requestHeader || {"client-type" : "WEBSQUARE"}; //(중요)ClientDetector를 위해 추가
	var reqData = "";
	var timeout = options.timeout || 0;

	var successCallBack = options.success || "";
	if(successCallBack) {
		if(typeof successCallBack === "string") {
			if (successCallBack.indexOf("scwin") === 0) {
				successCallBack =$p.id+successCallBack ;
			}
		}
	}
	comLib.getCheckCallBackFunc(successCallBack,"ajaxLib.executeAjaxSync");/* 콜백함수 처리 오류 검증  테스트 이후 삭제예정*/
	var errorCallBack = options.error || "";
	if(errorCallBack) {
		if(typeof errorCallBack === "string") {
			if (errorCallBack.indexOf("scwin") === 0) {
				errorCallBack =$p.id+errorCallBack ;
			}
		}
	}
	comLib.getCheckCallBackFunc(errorCallBack,"ajaxLib.executeAjaxSync");/* 콜백함수 처리 오류 검증  테스트 이후 삭제예정*/

	var isShowMeg = false;
	var savedToken = (options.savedToken?options.savedToken:false);

	if ((isProcessMsg === true) && (processMsg === "")) {
		//mode : synchronous 인 경우에 processMsg 사용불가.
		//synchronous 라는 모드 자체가 응답이 올 때까지 process를 잡고 있는 경우이므로 브라우저에 따라 다른 현상이 발생할 수 있어 synchronous 모드에서는 processMsg 를 지원하지 않습니다.
		processMsg = mode == "synchronous" ? "" : "해당 작업을 처리중입니다";
	}

	if (typeof options.isShowMeg !== "undefined") {
		isShowMeg = options.isShowMeg;
	}

	if ((mediatype.indexOf("xml") >= 0) && ((typeof options.reqData) === "object")) {
		reqData = WebSquare.xml.serialize(options.reqData);
	} else if ((mediatype.indexOf("json") >= 0) && ((typeof options.reqData) === "object")) {
			reqData = JSON.stringify(options.reqData);
	} else {
		reqData = options.reqData;
	}

	var savedTokenData = {};

	if(savedToken) {
		savedTokenData = JSON.parse(reqData);
//		eval("savedTokenData." + comLib.KTAG_TOKEN_FIELD + "='" + comLib.SAVED_TOKEN + "'");
//		eval("savedTokenData." + comLib.SAVED_TOKEN + "='" + comLib.getSavedToken() + "'");
		savedTokenData.ktagTokenField = comLib.SAVED_TOKEN;
//		savedTokenData.savedToken = comLib.getSavedToken();
		savedTokenData[comLib.SAVED_TOKEN] = comLib.getSavedToken();
		reqData = JSON.stringify(savedTokenData);
	}

	var resBody = null;

	// 이벤트로그에 화면ID담기 - 2017.12.20
	reqData = ajaxLib.addScrinId(reqData);

	var ajaxOptions = {
		action : action,
		mode : mode,
		mediatype : mediatype,
		method : method,
		processMsg : processMsg,
		requestData : reqData,
		requestHeader : requestHeader,
		timeout : timeout,
		frameId : $p.getFrameId(),
		beforeAjax : function(e) {
		},
		success : function(e) {
			if (mediatype === "application/xml") {
				if (typeof e.responseBody != "undefined")
					resBody = WebSquare.xml.parse(e.responseBody);
				var resData = WebSquare.xml.findNode(resBody, "data");
				if ((typeof options.resData !== "undefined" && options.resData != "") && (typeof resBody.data !== "undefined")) {
					options.resData.setXML(resData);
				}
			} else if (mediatype === "application/json") {
				resBody = e.responseJSON;
				if ((typeof options.resData !== "undefined" && options.resData != "") && (typeof resBody.data !== "undefined")) {
					//Data Collection 데이터 셋팅
					var dataType = options.resData.getObjectType().toLowerCase();
					if (dataType === "datamap") {
						if ($.isArray(resBody.data)) {
							options.resData.setJSON(resBody.data[0]);
						} else {
							options.resData.setJSON(resBody.data);
						}
					} else if (dataType === 'datalist') {
						options.resData.setJSON(resBody.data);
					}
					if(options.reqData) {
						 if(options.reqData.pageSize) {
						//pageList pageCount 셋팅
							if(options.reqData.pageSize > 0 && options.reqData.pageNo == 1) {
								if(resBody.totalCount == 0) {
									resBody.pageCount = 0;
								} else {
									resBody.pageCount = parseInt(resBody.totalCount / options.reqData.pageSize) == 0 ? 1 : parseInt(resBody.totalCount / options.reqData.pageSize);
									window[options.reqData.pageList].setCount(resBody.pageCount);
								}
							}
						}
					}
				}
			} else {
				resBody = e.responseText;
			}

			if(resBody.outSavedToken != null && (typeof resBody.outSavedToken !== "undefined")) {
				try {
					comLib.setSavedToken (resBody.outSavedToken);
//					alert("outSavedToken=" + comLib.getSavedToken());
				}catch(tokenEx) {}
			}
			if (resBody.message.code === comLib.STATUS_ERROR) {
				comLib.alert($p, resBody.message.code_name, errorCallBack);
			} else {
				if(successCallBack) {
					 if (typeof successCallBack === "function") {
						 successCallBack(resBody, $p);
					} else {
						eval(successCallBack)(resBody, $p);
					}
				}
			}
		},
		error : function(e) {
			//공통에러처리
			ajaxLib.errorHandler($p, e);
			if(errorCallBack) {
				if (typeof errorCallBack === "function") {
					errorCallBack(resBody, $p);
				} else {
					eval(errorCallBack)(resBody, $p);
				}
			}
			//else { 공통에러 처리에서 메세지창 띄움
				//comLib.alert($p, e.message);
			//}
		}
	};

	try {
		WebSquare.net.ajax(ajaxOptions);
		return resBody;
	} catch (e) {
		$w.log("[ajaxLib.executeAjaxSync] Exception :: " + e.message);
	} finally {
		AjaxCallptions = null;
		resBody = null;
	}
};

/**
 * Submission 객체를 동적으로 생성한다.
 * 
 * @date 2014. 12. 9.
 * @param {Object} options
 * @example
 * ajaxLib.createSubmission(options);
 */
ajaxLib.createSubmission = function($p, options) {
	var ref = options.ref || "";
	var target = options.target || "";
	var action = ajaxLib.CONTEXT_PATH + ajaxLib.SERVICE_URL + options.action;
	var mode = options.mode || ajaxLib.DEFAULT_OPTIONS_MODE;
	var mediatype = options.mediatype || ajaxLib.DEFAULT_OPTIONS_MEDIATYPE;
	var method = (options.method || "post").toLowerCase();
	var isProcessMsg = options.isProcessMsg || true;
	var processMsg = options.processMsg || "";
	var instance = options.instance || "";
	var replace = options.replace || "instance";
	var submitHandler = options.submitHandler || "";
	var submitDoneHandler = options.submitDoneHandler || "";
	var submitErrorHandler = options.submitErrorHandler || "";
	var isShowMeg = false;
	var resBody = null;

	if ((isProcessMsg === true) && (processMsg === "")) {
		//mode : synchronous 인 경우에 processMsg 사용불가.
		//synchronous 라는 모드 자체가 응답이 올 때까지 process를 잡고 있는 경우이므로 브라우저에 따라 다른 현상이 발생할 수 있어 synchronous 모드에서는 processMsg 를 지원하지 않습니다.
		processMsg = mode == "synchronous" ? "" : "해당 작업을 처리중입니다";
	}

	if (typeof options.isShowMeg !== "undefined") {
		isShowMeg = options.isShowMeg;
	}

	var submissionObj = {
		"id" : options.id,
		"ref" : ref,
		"target" : target,
		"action" : action,
		"method" : method,
		"mediatype" : mediatype,
		"encoding" : "UTF-8",
		"instance" : instance,
		"replace" : replace,
		"mode" : mode,
		"processMsg" : processMsg,
		"submitHandler" : submitHandler,
		"submitDoneHandler" : function(e) {
			var $p = $w.getComponentById(e.id).scope.$p;

			if (mediatype === "application/xml") {
				if (typeof e.responseBody !== "undefined") {
					resBody = WebSquare.xml.parse(e.responseBody);
				}
			} else if (mediatype === "application/json") {
				if (typeof e.responseJSON !== "undefined") {
					resBody = e.responseJSON;
				}
			} else {
				if (typeof e.responseText !== "undefined") {
					resBody = e.responseText;
				}
			}
			if (submitDoneHandler !== "") {
				var func = comLib.getScwin($p)[submitDoneHandler];
				if (typeof func === "function") {
					func(resBody, e);
				} else {
					func = window[submitDoneHandler];
					if (typeof func === "function") {
						func(resBody, e);
					}
				}
			} else {
				if (resBody.message.code === comLib.STATUS_ERROR) {
					comLib.alert($p, resBody.message.code_name, errorCallBack);
				} else if ((resBody.message.code === comLib.STATUS_SUCCESS) && (isShowMeg === true)) {
					comLib.alert($p, resBody.message.code_name);
				}
			}
		},
		"submitErrorHandler" : function(e) {
			var $p = $w.getComponentById(e.id).scope.$p;
			//공통에러처리
			ajaxLib.errorHandler($p, e);

			if (submitErrorHandler !== "") {
				var func = comLib.getScwin($p)[submitErrorHandler];
				if (typeof func === "function") {
					func(e);
				} else {
					func = eval(submitErrorHandler);
					if (typeof func === "function") {
						func(e);
					}
				}
			}
		}
	};

	$p.createSubmission(submissionObj);
};

/**
 * Submission 정보를 세팅한다.
 * 
 * @date 2014. 12. 9.
 * @param {Object} options
 * @example
 * ajaxLib.setSubmission(submissionObj, options);
 */
ajaxLib.setSubmission = function($p, submissionObj, options) {
	var ref = options.ref || "";
	var target = options.target || "";
	var action = ajaxLib.CONTEXT_PATH + ajaxLib.SERVICE_URL + options.action;
	var mode = options.mode || ajaxLib.DEFAULT_OPTIONS_MODE;
	var mediatype = options.mediatype || ajaxLib.DEFAULT_OPTIONS_MEDIATYPE;
	var method = (options.method || "post").toLowerCase();
	var isProcessMsg = options.isProcessMsg || true;
	var processMsg = options.processMsg || "";

	if ((isProcessMsg === true) && (processMsg === "")) {
		//mode : synchronous 인 경우에 processMsg 사용불가.
		//synchronous 라는 모드 자체가 응답이 올 때까지 process를 잡고 있는 경우이므로 브라우저에 따라 다른 현상이 발생할 수 있어 synchronous 모드에서는 processMsg 를 지원하지 않습니다.
		processMsg = mode == "synchronous" ? "" : "해당 작업을 처리중입니다";
	}

	var instance = options.instance || "";
	var replace = options.replace || "instance";

	submissionObj.id = options.id;
	submissionObj.ref = ref;
	submissionObj.target = target;
	submissionObj.action = action;
	submissionObj.method = method;
	submissionObj.mediatype = mediatype;
	submissionObj.encoding = "UTF-8";
	submissionObj.instance = instance;
	submissionObj.replace = replace;
	submissionObj.mode = mode;
	submissionObj.processMsg = processMsg;
};

/**
 * Submission를 실행합니다.
 * 
 * @date 2014. 12. 9.
 * @param {Object} options
 * @param {Object} 요청 데이터
 * @param {Object} 전송중 disable시킬 컴퍼넌트
 * @example
 * <br/>var searchCodeGrpOption = { id : "sbm_SearchCodeGrp",
 * <br/>			action : "serviceId=CD0001&action=R",
 * <br/>			target : 'data:json,{"id":"dlt_CodeGrp","key":"data"}',
 * <br/>			submitDoneHandler : "searchCodeGrpCallback", isShowMeg : false };
 * <br/>ajaxLib.executeSubmission(searchCodeGrpOption);
 */
ajaxLib.executeSubmission = function($p, options, requestData , obj) {
	var submissionObj = $p.getSubmission(options.id);

	if (submissionObj === null) {
		ajaxLib.createSubmission($p, options);
	} else {
		ajaxLib.setSubmission($p, submissionObj, options);
	}
	$p.executeSubmission(options.id, requestData, obj);
};

/**
 * SubmissionId에 해당하는 Submission을 실행합니다.
 * 
 * @date 2014. 12. 9.
 * @param {String} submissionId Submission 아이디
 * @example
 * ajaxLib.executeSubmissionById("sbm_SearchCodeGrp");
 */
ajaxLib.executeSubmissionById = function($p, submissionId) {
	$p.executeSubmission(submissionId);
};

/**
 * 서버 통신 과정에서 에러가 발생할 경우 에러 메시지를 출력한다.
 * 
 * @date 2014. 12. 9.
 * @param {Object} options
 * @example
 * ajaxLib.errorHandler(e);
 */
ajaxLib.errorHandler = function($p, e) {
	/* 공통에러 처리 필요. */
	/*
	* 모의해킹 조치. 그 어떠한 에러정보도 띄우지 말라고 함.
	var msg = e.responseBody;
	if (msg.indexOf("text/") >= 0) {
		msg = msg.replace("text/", "");
	}
	comLib.alert($p, "서버통신 중 에러가 발생하였습니다 (" + msg + ")");
	*/
	comLib.alert($p, "서버통신 중 에러가 발생하였습니다");
	console.error(e);
};

/**
 * Process 메시지 출력 (꼭! Process 메시지 닫기 와 쌍을 이루어야 함)
 *
 * @param		msg	: 출력할 메시지 내용 (미입력 시 처리중 출력)
 */
ajaxLib.processMsgStart = function(msg) {
	var message = "처리중...";
	if (typeof msg != "undefined" && msg != null && msg != "") {
		message = msg;
	}
	WebSquare.layer.showProcessMessage(message);
};

/**
 * Process 메시지 닫기
 *
 */
ajaxLib.processMsgEnd = function() {
	WebSquare.layer.hideProcessMessage();
};

/**
 * 공통코드 처리를 위한 서버와 Ajax 통신을 비동기화(asynchronous) 수행한다.
 *
 * @param {Object} options
 * <br/>※ options JSON형태 객체
 * <br/>options.action	: ajax 요청주소
 * <br/>options.mode		 : asynchronous
 * <br/>options.mediatype	: mediatype
 * <br/>options.method	: get/post/put/delete
 * <br/>options.isProcessMsg : 서비스 처리중에 메시지를 보여줄지 여부 설정 (true || false)
 * <br/>options.processMsg: 서비스 처리중에 보여줄 메시지 (ex. "요청하신 서비스를 처리중입니다"), 설정하지 않는 경우 기본 메시지를 출력한다.
 * <br/>					processMsg 옵션을 설정하는 경우에는 isProcessMsg 메시지를 설정하지 않아도 서버 통신중에 메시지를 출력한다.
 * <br/>options.reqData	  : 요청 데이터 (XML Object, XML String, JSON Object, JSON String)
 * <br/>options.timeout	  : ajax요청후 timeout 시간. 이시간이 초과해도 응답이 오지 않는 경우 error callback함수를 실행
 * <br/>options.type		 : xml/json. xml인 경우 success callback함수의 인자객체의 responseBody속성에 xml객체가 설정된고, json인 경우 자바스크립트 객체가 설정된다.
 * <br/>					나머지 경우는 text형식이 설정.
 * <br/>options.beforeAjax: 요청전에 실행되는 함수로 이 함수내에서 false를 return하면 ajax요청을 하지 않는다
 * <br/>options.success	  : 요청이 성공한 경우 실행되는 callback함수
 * <br/>options.error		: 요청이 실패한 경우 실행되는 callback함수
 * <br/>options.resData	  : Response된 데이터를 세팅할 DataCollection(DataList, DataMap) 객체
 * <br/>options.isShowMeg	: callback 함수가 지정되지 않은 경우에 서버에서 전달받은 메시지를 Alert 할 것인지 여부
 * @example ajaxLib.requestAjaxAsyncCode(options);
 */
ajaxLib.requestAjaxAsyncCode = function($p, options) {
	var action = "";

	if (options.action.startsWith("/") || options.action.startsWith("http")) {
		action =  options.action;
	} else {
	action =  "/"+ options.action;
	}

	var mode = "asynchronous";
	var mediatype = options.mediatype || ajaxLib.DEFAULT_OPTIONS_MEDIATYPE;
	var method = (options.method || "post").toLowerCase();
	var isProcessMsg = (options.isProcessMsg==undefined?true:options.isProcessMsg);
	var processMsg = options.processMsg || "";
	var requestHeader = options.requestHeader || {};
	var reqData = "";
	var timeout = options.timeout || 0;

	var successCallBack = options.success || "";
	if(successCallBack) {
		if(typeof successCallBack === "string") {
			if (successCallBack.indexOf("scwin") === 0) {
				successCallBack =$p.id+successCallBack ;
			}
		}
	}
	comLib.getCheckCallBackFunc(successCallBack,"ajaxLib.requestAjaxAsyncCode");/* 콜백함수 처리 오류 검증  테스트 이후 삭제예정*/

	var errorCallBack = options.error || "";
	if(errorCallBack) {
		if(typeof errorCallBack === "string") {
			if (errorCallBack.indexOf("scwin") === 0) {
				errorCallBack =$p.id+errorCallBack ;
			}
		}
	}
	comLib.getCheckCallBackFunc(errorCallBack,"ajaxLib.requestAjaxAsyncCode");/* 콜백함수 처리 오류 검증  테스트 이후 삭제예정*/

	var isShowMeg = false;

	if ((isProcessMsg === true) && (processMsg === "")) {
		//mode : synchronous 인 경우에 processMsg 사용불가.
		//synchronous 라는 모드 자체가 응답이 올 때까지 process를 잡고 있는 경우이므로 브라우저에 따라 다른 현상이 발생할 수 있어 synchronous 모드에서는 processMsg 를 지원하지 않습니다.
		processMsg = mode == "synchronous" ? "" : "해당 작업을 처리중입니다";
	}

	if (typeof options.isShowMeg !== "undefined") {
		isShowMeg = options.isShowMeg;
	}

	if ((mediatype.indexOf("xml") >= 0) && ((typeof options.reqData) === "object")) {
		reqData = WebSquare.xml.serialize(options.reqData);
	} else if ((mediatype.indexOf("json") >= 0) && ((typeof options.reqData) === "object")) {
		reqData = JSON.stringify(options.reqData);
	} else {
		reqData = options.reqData;
	}
	var resBody = null;

	// 이벤트로그에 화면ID담기 - 2017.12.20
	reqData = ajaxLib.addScrinId(reqData);

	var ajaxOptions = {
		action : action,
		mode : mode,
		mediatype : mediatype,
		method : method,
		processMsg : processMsg,
		requestData : reqData,
		requestHeader : requestHeader,
		timeout : timeout,
		frameId : $p.getFrameId(),
		beforeAjax : function(e) {
		},
		success : function(e) {
			//var $p = $w.getComponentById(this.frameId).scope.$p;
			//e.id = $p.getFrameId();

			if (mediatype === "application/xml") {
				if (typeof e.responseBody != "undefined")
					resBody = WebSquare.xml.parse(e.responseBody);
				var resData = WebSquare.xml.findNode(resBody, "data");
				if ((typeof options.resData !== "undefined" && options.resData != "") && (typeof resBody.data !== "undefined")) {
					options.resData.setXML(resData);
				}
			} else if (mediatype === "application/json") {
				resBody = e.responseJSON;
				if ((typeof options.resData !== "undefined" && options.resData != "") && (typeof resBody.data !== "undefined")) {
					//Data Collection 데이터 셋팅
					var dataType = options.resData.getObjectType().toLowerCase();
					if (dataType === "datamap") {
						if ($.isArray(resBody.data)) {
							options.resData.setJSON(resBody.data[0]);
						} else {
							options.resData.setJSON(resBody.data);
						}
					} else if (dataType === 'datalist') {
						options.resData.setJSON(resBody.data);
					}
					if(options.reqData) {
						if(options.reqData.pageSize) {
							//pageList pageCount 셋팅
							if(options.reqData.pageSize > 0 && options.reqData.pageNo == 1) {
								if(resBody.totalCount == 0) {
									resBody.pageCount = 0;
								} else {
									resBody.pageCount = parseInt(resBody.totalCount / options.reqData.pageSize) == 0 ? 1 : parseInt(resBody.totalCount / options.reqData.pageSize);
									window[options.reqData.pageList].setCount(resBody.pageCount);
								}
							}
						}
					}
				}
			} else {
				resBody = e.responseText;
			}
			if (resBody.message.code === comLib.STATUS_ERROR) {
				//공통코드 요청시에는 alert 하지 않음
				comLib.alert($p, resBody.message.code_name, errorCallBack);
			} else {
				if(successCallBack) {
					 if (typeof successCallBack === "function") {
						 successCallBack(options.reqData, resBody, $p);
					} else {
						eval(successCallBack)(options.reqData, resBody, $p);
					}
				}
			}
		},
		error : function(e) {
			//공통에러처리
			ajaxLib.errorHandler($p, e);
			if(errorCallBack) {
				if (typeof errorCallBack === "function") {
					errorCallBack(resBody, $p);
				} else {
					eval(errorCallBack)(resBody, $p);
				}
			}
			//else {공통에러 처리에서 메세지창 띄움
				//comLib.alert($p, e.message);
			//}
		}
	};

	try {
		WebSquare.net.ajax(ajaxOptions);
		return resBody;
	} catch (e) {
		$w.log("[ajaxLib.requestAjaxAsyncCode] Exception :: " + e.message);
	} finally {
		AjaxCallptions = null;
		resBody = null;
	}
};

/**
 * 공통코드 처리를 위한 서버와 Ajax 동기화(synchronous) 통신을 수행한다.
 *
 * @param {Object} options
 * <br/>※ options JSON형태 객체
 * <br/>options.action	: ajax 요청주소
 * <br/>options.mode		 : synchronous
 * <br/>options.mediatype	: mediatype
 * <br/>options.method	: get/post/put/delete
 * <br/>options.isProcessMsg : 서비스 처리중에 메시지를 보여줄지 여부 설정 (true || false)
 * <br/>options.processMsg: 서비스 처리중에 보여줄 메시지 (ex. "요청하신 서비스를 처리중입니다"), 설정하지 않는 경우 기본 메시지를 출력한다.
 * <br/>					processMsg 옵션을 설정하는 경우에는 isProcessMsg 메시지를 설정하지 않아도 서버 통신중에 메시지를 출력한다.
 * <br/>options.reqData	  : 요청 데이터 (XML Object, XML String, JSON Object, JSON String)
 * <br/>options.timeout	  : ajax요청후 timeout 시간. 이시간이 초과해도 응답이 오지 않는 경우 error callback함수를 실행
 * <br/>options.type		 : xml/json. xml인 경우 success callback함수의 인자객체의 responseBody속성에 xml객체가 설정된고, json인 경우 자바스크립트 객체가 설정된다.
 * <br/>					나머지 경우는 text형식이 설정.
 * <br/>options.beforeAjax: 요청전에 실행되는 함수로 이 함수내에서 false를 return하면 ajax요청을 하지 않는다
 * <br/>options.success	  : 요청이 성공한 경우 실행되는 callback함수
 * <br/>options.error		: 요청이 실패한 경우 실행되는 callback함수
 * <br/>options.resData	  : Response된 데이터를 세팅할 DataCollection(DataList, DataMap) 객체
 * <br/>options.isShowMeg	: callback 함수가 지정되지 않은 경우에 서버에서 전달받은 메시지를 Alert 할 것인지 여부
 * @example ajaxLib.requestAjaxSyncCode(options);
 */
ajaxLib.requestAjaxSyncCode = function($p, options) {
	var action = "";

	if (options.action.startsWith("/") || options.action.startsWith("http")) {
		action =  options.action;
	} else {
		action =  "/"+ options.action;
	}

	var mode = "synchronous";
	var mediatype = options.mediatype || ajaxLib.DEFAULT_OPTIONS_MEDIATYPE;
	var method = (options.method || "post").toLowerCase();
	var isProcessMsg = (options.isProcessMsg==undefined?true:options.isProcessMsg);
	var processMsg = options.processMsg || "";
	var requestHeader = options.requestHeader || {};
	var reqData = "";
	var timeout = options.timeout || 0;

	var successCallBack = options.success || "";
	if(successCallBack) {
		if(typeof successCallBack === "string") {
			if (successCallBack.indexOf("scwin") === 0) {
				successCallBack =$p.id+successCallBack ;
			}
		}
	}
	comLib.getCheckCallBackFunc(successCallBack,"ajaxLib.requestAjaxSyncCode");/* 콜백함수 처리 오류 검증  테스트 이후 삭제예정*/
	var errorCallBack = options.error || "";
	if(errorCallBack) {
		if(typeof errorCallBack === "string") {
			if (errorCallBack.indexOf("scwin") === 0) {
				errorCallBack =$p.id+errorCallBack ;
			}
		}
	}
	comLib.getCheckCallBackFunc(errorCallBack,"ajaxLib.requestAjaxSyncCode");/* 콜백함수 처리 오류 검증  테스트 이후 삭제예정*/
	var isShowMeg = false;

	if ((isProcessMsg === true) && (processMsg === "")) {
		//mode : synchronous 인 경우에 processMsg 사용불가.
		//synchronous 라는 모드 자체가 응답이 올 때까지 process를 잡고 있는 경우이므로 브라우저에 따라 다른 현상이 발생할 수 있어 synchronous 모드에서는 processMsg 를 지원하지 않습니다.
		processMsg = mode == "synchronous" ? "" : "해당 작업을 처리중입니다";
	}

	if (typeof options.isShowMeg !== "undefined") {
		isShowMeg = options.isShowMeg;
	}

	if ((mediatype.indexOf("xml") >= 0) && ((typeof options.reqData) === "object")) {
		reqData = WebSquare.xml.serialize(options.reqData);
	} else if ((mediatype.indexOf("json") >= 0) && ((typeof options.reqData) === "object")) {
		reqData = JSON.stringify(options.reqData);
	} else {
		reqData = options.reqData;
	}
	var resBody = null;

	// 이벤트로그에 화면ID담기 - 2017.12.20
	reqData = ajaxLib.addScrinId(reqData);

	var ajaxOptions = {
		action : action,
		mode : mode,
		mediatype : mediatype,
		method : method,
		requestData : reqData,
		requestHeader : requestHeader,
		timeout : timeout,
		frameId : $p.getFrameId(),
		beforeAjax : function(e) {
		},
		success : function(e) {
			if (mediatype === "application/xml") {
				if (typeof e.responseBody != "undefined")
					resBody = WebSquare.xml.parse(e.responseBody);
				var resData = WebSquare.xml.findNode(resBody, "data");
				if ((typeof options.resData !== "undefined" && options.resData != "") && (typeof resBody.data !== "undefined")) {
					options.resData.setXML(resData);
				}
			} else if (mediatype === "application/json") {
				resBody = e.responseJSON;
				if ((typeof options.resData !== "undefined" && options.resData != "") && (typeof resBody.data !== "undefined")) {
					//Data Collection 데이터 셋팅
					var dataType = options.resData.getObjectType().toLowerCase();
					if (dataType === "datamap") {
						if ($.isArray(resBody.data)) {
							options.resData.setJSON(resBody.data[0]);
						} else {
							options.resData.setJSON(resBody.data);
						}
					} else if (dataType === 'datalist') {
						options.resData.setJSON(resBody.data);
					}
					if(options.reqData) {
						if(options.reqData.pageSize) {
						//pageList pageCount 셋팅
							if(options.reqData.pageSize > 0 && options.reqData.pageNo == 1) {
								if(resBody.totalCount == 0) {
									resBody.pageCount = 0;
								} else {
									resBody.pageCount = parseInt(resBody.totalCount / options.reqData.pageSize) == 0 ? 1 : parseInt(resBody.totalCount / options.reqData.pageSize);
									window[options.reqData.pageList].setCount(resBody.pageCount);
								}
							}
						}
					}
				}
			} else {
				resBody = e.responseText;
			}
			if (resBody.message.code === comLib.STATUS_ERROR) {
				//공통코드 요청시에는 alert 하지 않음
				comLib.alert($p, resBody.message.code_name, errorCallBack);
			} else {
				if(successCallBack) {
					 if (typeof successCallBack === "function") {
						 successCallBack(options.reqData, resBody, $p);
					} else {
						eval(successCallBack)(options.reqData, resBody, $p);
					}
				}
			}
		},
		error : function(e) {
			//공통에러처리
			ajaxLib.errorHandler($p, e);

			if(errorCallBack) {
				if (typeof errorCallBack === "function") {
					errorCallBack(resBody, $p);
				} else {
					eval(errorCallBack)(resBody, $p);
				}
			}
			//else {공통에러 처리에서 메세지창 띄움
				//comLib.alert($p, e.message);
			//}
		}
	};

	try {
		WebSquare.net.ajax(ajaxOptions);
		return resBody;
	} catch (e) {
		$w.log("[ajaxLib.requestAjaxSyncCode] Exception :: " + e.message);
	} finally {
		AjaxCallptions = null;
		resBody = null;
	}
};

/**
 * LWS 이벤트로그에 화면ID를 추가하기 위해 화면ID를 파라메터에 추가
 * @since 2017.12.20
 * @param reqData JSON 파라메터(문자형식)
 */
ajaxLib.addScrinId = function(reqData) {
	try {
		var scrinId = top.comLib.getUserInfo("lwsScrinId");

		if (scrinId != null && scrinId != "") {
			var newReqData = JSON.parse(reqData);

			newReqData.scrinId = scrinId;
			return JSON.stringify(newReqData);
		}
	} catch (e) {
		console.error(e.message);
	}

	return reqData;
};