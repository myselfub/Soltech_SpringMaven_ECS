/**
 * 수자원 통합 공통 JS 함수
 * @ClassName commmon_ecs.js
 * @Description commmon_ecs javascript
 * @Modification Information
 * -------------	----------------	---------------------
 * 2017.09.19		60002958 이균희		최초생성
 *
 *
 * @author K-water 업무시스템 혁신사업 :
 * @since 2017.09.19
 * Copyright ⓒ 2017 by Unlimited K-water, All right reserved.
 */

var daLib = {};
// 수자원통합 공통 라이브러리
var ecsLib = {};
ecsLib.DSTRCT_HQ_CD_MAIN = "50013977";
ecsLib.DOC_VIEWER_URL = "https://oasis.[BASE_DOMAIN]/custom/DocViewer.jsp";

/**
 * gridview의 customFormatter 함수
 *
 * 셀의 값으로 배경색을 지정한다.
 *
 * 4보다 작을경우 강조2
 * 7보다 작을경우 강조1
 *
 * @param <String> sum
 * @param <String> rowIndex
 * @param <Number> colIndex
 * @returns <String> data
 */
daLib.setRankByCellColor = function(data, fdata, rowIndex, colIndex) {
	/*
	console.log("=================");
	console.log("data:" + data);
	console.log("fdata:" + fdata);
	console.log("rowIndex:" + rowIndex);
	console.log("colIndex:" + colIndex);
	console.log("this:" + this.id);
	console.log("=================");
	*/
	if(WebSquare.util.parseInt(data) > 0) {
		if(WebSquare.util.parseInt(data) < 4) {
			this.setCellBackgroundColor(rowIndex, colIndex, "#E7E7F4");
		} else if(WebSquare.util.parseInt(data) < 7) {
			this.setCellBackgroundColor(rowIndex, colIndex, "#E9F4F3");
		}
	}
	return data;
};

daLib.setBkCellColor = function(data, fdata, rowIndex, colIndex) {
	this.setCellBackgroundColor(rowIndex, colIndex, "#E9F4F3");

	return data;
};

/**
 * GridView 동적으로 셀을 병합
 *
 * @param <Object> grid 		grdId
 * @param <Number> rowIndex 	병합 시작 지점 좌표값 (행 인덱스) (여러 셀 병합 시 왼쪽 최상단 셀의 인덱스를 입력.)
 * @param <Number> colIndex 	병합 시작 지점 좌표값 (열 인덱스)
 * @param <Number> colSpan 		병합할 컬럼의 수
 * @param <Number> rowSpan 		병합할 행의 수
 */
ecsLib.mergeGridViewCell = function(grid, rowIndex, colIndex, colSpan, rowSpan) {
	var mergeInfo = {}
	mergeInfo.rowIndex = rowIndex;
	mergeInfo.colIndex = colIndex;
	mergeInfo.colSpan = colSpan;
	mergeInfo.rowSpan = rowSpan;

	grid.mergeCell(mergeInfo);
};

/**
 * 시:분 유형의 문자열을 반환
 *
 * @param <Number> val 	분
 * @returns <String> 시:분 형태의 문자열
 */
ecsLib.getTimeStringFormat = daLib.getTimeStringFormat = function(val) {
	if (val == undefined || val == null || val == "" || val == "0") {
		return "0";
	} else {
		var t = parseInt(val / 60);
		var m = parseInt(val % 60);
		m = utilLib.fillZero(m, 2);
		return t + ":" + m;
	}
};

/**
 * 해당 dataList의 해당 column값의 합을 구한다.
 * column의 데이타는 시:분 형태의 String 일때 사용한다.
 *
 * @param <String> dataListId
 * @param <String> columnId
 * @returns <String> 해당 dataList의 해당 column값의 합을 구하여 시:분 형태로 반환.
 */
ecsLib.sumTimeString = function(dataListId, columnId) {
	var dataList = WebSquare.util.getComponentById(dataListId);
	var sumMnt = 0;
	for(var i = 0; i < dataList.getRowCount( ); i++) {
		var data;
		var h;
		var m;
		data = dataList.getCellData(i, columnId);
		if (data.indexOf(":") > 0) {
			h = parseInt(data.split(":")[0].replace(/^\s|\s$/gi,""));
			m = parseInt(data.split(":")[1].replace(/^\s|\s$/gi,""));
			sumMnt += h * 60 + m;
		}
	}
	var str = ecsLib.getTimeStringFormat(sumMnt);
	return str;
};

/**
 * 해당 dataList의 해당 column값의 평균을 구한다.
 * column의 데이타는 시:분 형태의 String 일때 사용한다.
 *
 * @param <String> dataListId
 * @param <String> columnId
 * @returns <String> 해당 dataList의 해당 column값의 평균을 구하여 시:분 형태로 반환.
 */
ecsLib.avgTimeString = function(dataListId, columnId) {
	var dataList = WebSquare.util.getComponentById(dataListId);
	var sumMnt = 0;
	for (var i = 0; i < dataList.getRowCount( ); i++) {
		var data;
		var h;
		var m;
		data = dataList.getCellData(i, columnId);
		if (data.indexOf(":") > 0) {
			h = parseInt(data.split(":")[0].replace(/^\s|\s$/gi,""));
			m = parseInt(data.split(":")[1].replace(/^\s|\s$/gi,""));
			sumMnt += h * 60 + m;
		}
	}
	// alert(sumMnt);
	// alert(dataList.getRowCount( ));
	var str = ecsLib.getTimeStringFormat(parseInt(sumMnt/dataList.getRowCount()));
	return str;
};

/**
 * 해당 dataList의 해당 column값의 최대값을 구한다.
 * column의 데이타는 시:분 형태의 String 일때 사용한다.
 *
 * @param <String> dataListId
 * @param <String> columnId
 * @returns <String> 해당 dataList의 해당 column값의 최대값을 반환.
 */
ecsLib.maxTimeString = function(dataListId, columnId) {
	var dataList = WebSquare.util.getComponentById(dataListId);
	var maxMnt = 0;
	for (var i = 0; i < dataList.getRowCount( ); i++) {
		var data;
		var h;
		var m;
		data = dataList.getCellData(i, columnId);
		if (data.indexOf(":") > 0) {
			h = parseInt(data.split(":")[0].replace(/^\s|\s$/gi,""));
			m = parseInt(data.split(":")[1].replace(/^\s|\s$/gi,""));
			if (maxMnt < h * 60 + m) {
				maxMnt = h * 60 + m;
			}
		}
	}
	var str = ecsLib.getTimeStringFormat(maxMnt);
	return str;
};

/**
 * 해당 dataList의 해당 column값의 최소값을 구한다.
 * column의 데이타는 시:분 형태의 String 일때 사용한다.
 *
 * @param <String> dataListId
 * @param <String> columnId
 * @returns <String> 해당 dataList의 해당 column값의 최소값을 반환.
 */
ecsLib.minTimeString = function(dataListId, columnId) {
	var dataList = WebSquare.util.getComponentById(dataListId);
	var minMnt = 0;
	for (var i = 0; i < dataList.getRowCount( ); i++) {
		var data;
		var h;
		var m;
		data = dataList.getCellData(i, columnId);
		if (data.indexOf(":") > 0) {
			h = parseInt(data.split(":")[0].replace(/^\s|\s$/gi,""));
			m = parseInt(data.split(":")[1].replace(/^\s|\s$/gi,""));
			if (minMnt > h * 60 + m) {
				minMnt = h * 60 + m;
			}
		}
	}
	var str = ecsLib.getTimeStringFormat(minMnt);
	return str;
}

/**
 * 시:분 유형의 문자열을 반환
 * @param val
 * @returns {String}
 */
function fnTimeChg(val){
	var t;
	var m;
	t = parseInt(val / 60);
	m = parseInt(val % 60);
	m = utilLib.fillZero(m, 2);
	return t + ":" + m;
};

/* 임시 안전정보용 팝업창 띄우기*/
function openPopup(vName) {
	var vTitle = vName;
	var vWidth = 0;
	var vHeight = 0;
	var vUrl = "";

	if (vTitle == "도면상세정보") {
		vWidth = 700;
		vHeight = 250;
		vUrl = "/ui/da/safeInfo/layingMsrinsManage/drwDtlInfo.xml";
	} else if (vTitle == "매설계기속성") {
		vWidth = 800;
		vHeight = 730;
		vUrl = "/ui/da/safeInfo/layingMsrinsManage/layingMsrinsAtrb.xml";
	} else if (vTitle == "매설계기계측현황") {
		vWidth = 800;
		vHeight = 580;
		vUrl = "/ui/da/safeInfo/layingMsrinsManage/layingMsrinsMesureSttus.xml";
	} else if (vTitle == "경시도분석") {
		vWidth = 1200;
		vHeight = 850;
		vUrl = "/ui2/da/safeInfo/layingMsrinsManage/SI0004.xml";
	}

	var options = {
		id : "test",
		type : "window", // window, wframePopup
		title : vTitle,
		width : vWidth,
		height : vHeight,
		modal : true,
		popupParam : { data : null, closeCallbackFncName : "scwin.bt2AddPopupCallBack" } // checked 데이터
	};
	comLib.openPopup($p, "layingMsrinsAtrb", vUrl, options);
};

/* 임시 안전정보용 MDI 띄우기*/
function openMdi(vTitle) {
	vUrl = "";

	if (vTitle == "매설계기통합관리") {
		vUrl = "/da/ui/da/safeInfo/layingMsrinsManage/layingMsrinsUnityMng.xml";
	} else if (vTitle == "실시간계측현황") {
		vUrl = "/da/ui/da/safeInfo/layingMsrinsManage/rltmMsrinsSttus.xml";
	} else if (vTitle == "계측정보관리") {
		vUrl = "/da/ui/da/safeInfo/layingMsrinsManage/msrinsInfoMng.xml";
	} else if (vTitle == "경시도분석") {
		vUrl = "/da/ui/da/safeInfo/layingMsrinsManage/atptAnals.xml";
	} else if (vTitle == "매설계기종합현황") {
		vUrl = "/da/ui/da/safeInfo/layingMsringGnrlzSttus/atptAnals.xml";
	} else if (vTitle == "연동현황모니터링") {
		vUrl = "";
	} else if (vTitle == "운영상태변경") {
		vUrl = "/da/ui/da/safeInfo/layingMsrinsManage/operSttusChange.xml";
	} else if (vTitle == "계측값현황") {
		vUrl = "/da/ui/da/safeInfo/layingMsrinsManage/msrinsValueSttus.xml";
	}

	if (vUrl == "") {
		return alert(vTitle + "화면의 URL이 정의되지 않았습니다.");
	}

	top.windowContainer1.createWindow(vTitle, null , vUrl);
};

/***************************************
 * rMate Chart 전역 변수 선언
 * ecsChartLayout 	- 수자원 차트 공통 레이아웃 변수
 * ecsChartData 	- 수자원 차트 공통 Data 변수
***************************************/
var ecsChartVars = null;
var ecsChartLayout = null;
var ecsChartData = null;

/**
 * 차트에 쓰인 자원 해제
 * @Param <Object> : 차트에 쓰인 변수
 * @example ecsLib.chartDestory(obj);
 */
ecsLib.chartDestory = function(obj) {
	if (obj != null) {
		obj = null;
	}
}

/**
* 차트 랜더링
* @Param <chartId> : 생성될 ChartId
* @Param <ecsChartLayout> : Chart 레이아웃
* @Param <ecsChartData> : Chart Data
* @example chartReadyHandler(chartId, ecsChartLayout, ecsChartData);
*/

ecsLib.chartCreate = function(chartId, paramChartLayout, paramChartData, divId) {
	ecsChartVars = "rMateOnLoadCallFunction=ecsLib.chartReadyHandler";
	if (paramChartLayout != null) {
		ecsChartLayout = paramChartLayout;
	}
	if (paramChartData != null) {
		ecsChartData = paramChartData;
	}
	rMateChartH5.create(chartId, divId, ecsChartVars, "100%", "100%");

	// ecsLib.chartDestory(ecsChartVars);
	// ecsLib.chartDestory(ecsChartData);
	// ecsLib.chartDestory(ecsChartLayout);
};

ecsLib.chartReadyHandler = function(chartId) {
	document.getElementById(chartId).clear();
	document.getElementById(chartId).setLayout(ecsChartLayout);
	document.getElementById(chartId).setData(ecsChartData);
};

/**
* 그리드 설정
*
* @param dataListId 데이타리스트ID
* @param gridId 그리드뷰ID
* @param gridHeaderInfo 그리드뷰 헤더컬럼 정보
* @param gridBodyInfo 그리드뷰 바디컬럼 정보
* @param gridSubTotalInfo 그리드뷰 서브토탈 정보
* @param gridFooterInfo 그리드뷰 푸터 정보
* @param dataObj 그리드뷰 데이타
* @param gridProp 그리드뷰 속성(autoFit, visibleRowNum)
* @param callback 콜백함수
*
* note) 1. 컬럼의 id를 넣지 않으면 이상동작함
*/
ecsLib.makeAsyncGrid = function($p, dataListId, gridId, gridHeaderInfo, gridBodyInfo, gridSubTotalInfo, gridFooterInfo, dataObj, gridProp, callback) {
	var gridHeader = [];
	var gridBody = "";
	var gridFooter = [];
	var gridSubTotal = [];
	for (var i = 0; i < gridBodyInfo.length; i++) {
		var k = gridBodyInfo[i];
		var textAlign;
		var displayFormat;
		var readOnly;
		var dataType;
		var inputType;
		var displayFormatter;
		var clazz;
		var defaultValue;
		var expression;
		var colMerge;
		var editModeEvent;
		var customFormatter;
		var width;
		var style;
		var displayMode;
		var checkboxLabel;
		if (!!gridBodyInfo[i].width) {
			width = gridBodyInfo[i].width;
		} else {
			width = "70";
		}
		if (!!gridBodyInfo[i].textAlign) {
			textAlign = gridBodyInfo[i].textAlign;
		} else {
			textAlign = "center";
		}
		if (!!gridBodyInfo[i].displayFormatter) {
			displayFormatter = gridBodyInfo[i].displayFormatter;
		} else {
			displayFormatter = "";
		}
		if (!!gridBodyInfo[i].displayFormat) {
			displayFormat = gridBodyInfo[i].displayFormat;
		} else {
			displayFormat = "";
		}
		if (!!gridBodyInfo[i].readOnly) {
			readOnly = gridBodyInfo[i].readOnly;
		} else {
			readOnly = "true";
		}
		if (!!gridBodyInfo[i].dataType) {
			dataType = gridBodyInfo[i].dataType;
		} else {
			dataType = "text";
		}
		if (!!gridBodyInfo[i].inputType) {
			inputType = gridBodyInfo[i].inputType;
		} else {
			inputType = "text";
		}
		if (!!gridBodyInfo[i].class) {
			clazz = gridBodyInfo[i].class;
		} else {
			clazz = "";
		}
		if (!!gridBodyInfo[i].defaultValue) {
			defaultValue = gridBodyInfo[i].defaultValue;
		} else {
			defaultValue = "";
		}
		if (!!gridBodyInfo[i].fixedRightColumn) {
			fixedRightColumn = gridBodyInfo[i].fixedRightColumn;
		} else {
			fixedRightColumn = "";
		}
		if (!!gridBodyInfo[i].colMerge) {
			colMerge = gridBodyInfo[i].colMerge;
		} else {
			colMerge = "";
		}
		if (!!gridBodyInfo[i].expression) {
			expression = gridBodyInfo[i].expression;
			inputType = "expression";
		} else {
			expression = "";
			if (!gridBodyInfo[i].inputType) {
				inputType = "text";
			}
		}
		if (!!gridBodyInfo[i].editModeEvent) {
			editModeEvent = gridBodyInfo[i].editModeEvent;
		} else {
			editModeEvent = "";
		}
		if (!!gridBodyInfo[i].customFormatter) {
			customFormatter = gridBodyInfo[i].customFormatter;
		} else {
			customFormatter = "";
		}
		if (!!gridBodyInfo[i].style) {
			style = gridBodyInfo[i].style;
		} else {
			style = "height:20px";
		}
		if (!!gridBodyInfo[i].displayMode) {
			if (gridBodyInfo[i].displayMode == "ignore"){
				displayMode = "";
			} else {
				displayMode = gridBodyInfo[i].displayMode;
			}
		} else {
			displayMode = "label";
		}
		if (!!gridBodyInfo[i].checkboxLabel) {
			checkboxLabel = gridBodyInfo[i].checkboxLabel;
		} else {
			checkboxLabel = "";
		}
		gridBody += '<w2:column blockSelect="false" id="' + k.id +
			'" style="' + style +
			'" displayMode="' + displayMode +
			'" dataType="'+ dataType +
			'" inputType="' + inputType +
			'" width="' + width +
			'" textAlign="' + textAlign +
			'" displayFormatter="' + displayFormatter +
			'" displayFormat="' + displayFormat +
			'" readOnly="' + readOnly +
			'" class="' + clazz +
			'" defaultValue="' + defaultValue +
			'" expression="' + expression +
			'" fixedRightColumn="' + fixedRightColumn +
			'" colMerge="' + colMerge +
			'" customFormatter="' + customFormatter +
			'" checkboxLabel="' + checkboxLabel +
			'" editModeEvent="' + editModeEvent +
			'"></w2:column>';
	}

	for (var i = 0; i < gridHeaderInfo.length; i++) {
		var header = gridHeaderInfo[i];
		for (var j = 0; j < header.length; j++) {
			var value;
			var colSpan;
			var rowSpan;
			var width;
			var inputType;
			var hidden;
			var checkboxLabel;
			var displayMode;
			value = header[j].value;
			if (!!header[j].colSpan) {
				colSpan = header[j].colSpan;
			} else {
				colSpan = 1;
			}
			if (!!header[j].rowSpan) {
				rowSpan = header[j].rowSpan;
			} else {
				rowSpan = 1;
			}
			if (!!header[j].width) {
				width = header[j].width;
			} else {
				width = "70";
			}
			if (!!header[j].inputType) {
				inputType = header[j].inputType;
			} else {
				inputType = "text";
			}
			if (!!header[j].hidden) {
				hidden = header[j].hidden;
			} else {
				hidden = "";
			}
			if (!!header[j].checkboxLabel) {
				checkboxLabel = header[j].checkboxLabel;
			} else {
				checkboxLabel = "";
			}
			if (!!header[j].displayMode) {
				displayMode = header[j].displayMode;
			} else {
				displayMode = "";
			}
			if (!!header[j].style) {
				style = header[j].style;
			} else {
				style = "height:20px";
			}
			// displayMode="' + displayMode + '" checkboxLabel="' + checkboxLabel + '"
			gridHeader[i] += '<w2:column blockSelect="false" id="h' + i + '' + j +
				'" displayMode="' + displayMode +
				'" checkboxLabel="' + checkboxLabel +
				'" style="' + style +
				'" inputType="' + inputType +
				'" hidden="' + hidden +
				'" width="' + width +
				'" value="' + value +
				'" colSpan="' + colSpan +
				'" rowSpan="' + rowSpan +
				'"></w2:column>';
		}
	}

	if (gridSubTotalInfo != null) {
		for (var i = 0 ; i < gridSubTotalInfo.length; i++) {
			var subTotal = gridSubTotalInfo[i];
			for (var j = 0; j < subTotal.length; j++) {
				var value;
				var textAlign;
				var displayFormat;
				var displayFormatter;
				var inputType;
				var dataType;
				var expression;
				var rowSpan;
				var colSpan;
				if (!!subTotal[j].value) {
					value = subTotal[j].value;
				} else {
					value = "";
				}
				if (!!subTotal[j].textAlign) {
					textAlign = subTotal[j].textAlign;
				} else {
					textAlign = "center";
				}
				if (!!subTotal[j].displayFormat) {
					displayFormat = subTotal[j].displayFormat;
				} else {
					displayFormat = "";
				}
				if (!!subTotal[j].displayFormatter) {
					displayFormatter = subTotal[j].displayFormatter;
				} else {
					displayFormatter = "";
				}
				if (!!subTotal[j].dataType) {
					dataType = subTotal[j].dataType;
				} else {
					dataType = "text";
				}
				if (!!subTotal[j].expression) {
					expression = subTotal[j].expression;
					inputType = "expression";
				} else {
					expression = "";
					inputType = "text";
				}
				if (!!subTotal[j].rowSpan) {
					rowSpan = subTotal[j].rowSpan;
				} else {
					rowSpan = 1;
				}
				if (!!subTotal[j].colSpan) {
					colSpan = subTotal[j].colSpan;
				} else {
					colSpan = 1;
				}
				gridSubTotal[i] += '<w2:column width="70" inputType="' + inputType +
					'" style="height:30px;" id="s_' + subTotal[j].id + (i + 1) +
					'" blockSelect="false" displayMode="label" value="' + value +
					'" textAlign="' + textAlign +
					'" displayFormat="' + displayFormat +
					'" displayFormatter="' + displayFormatter +
					'" dataType="' + dataType +
					'" colSpan="' + colSpan +
					'" rowSpan="' + rowSpan +
					'" expression="' + expression +
					'"></w2:column>';
			}
		}
	}

	if (gridFooterInfo != null) {
		for (var i = 0 ; i < gridFooterInfo.length; i++) {
			var footer = gridFooterInfo[i];
			for (var j = 0; j < footer.length; j++) {
				var value, textAlign, displayFormat, displayFormatter, inputType, dataType, expression, rowSpan, colSpan;
				if (!!footer[j].value) {
					value = footer[j].value;
				} else {
					value = "";
				}
				if (!!footer[j].textAlign) {
					textAlign = footer[j].textAlign;
				} else {
					textAlign = "center";
				}
				if (!!footer[j].displayFormat) {
					displayFormat = footer[j].displayFormat;
				} else {
					displayFormat = "";
				}
				if (!!footer[j].displayFormatter) {
					displayFormatter = footer[j].displayFormatter;
				} else {
					displayFormatter = "";
				}
				if (!!footer[j].dataType) {
					dataType = footer[j].dataType;
				} else {
					dataType = "text";
				}
				if (!!footer[j].expression) {
					expression = footer[j].expression;
					inputType = "expression";
				} else {
					expression = "";
					inputType = "text";
				}
				if (!!footer[j].rowSpan) {
					rowSpan = footer[j].rowSpan;
				} else {
					rowSpan = 1;
				}
				if (!!footer[j].colSpan) {
					colSpan = footer[j].colSpan;
				} else {
					colSpan = 1;
				}
				gridFooter[i] += '<w2:column width="70" inputType="' + inputType +
					'" style="height:30px;" id="f_' + footer[j].id + (i + 1) +
					'" blockSelect="false" displayMode="label" value="' + value +
					'" textAlign="' + textAlign +
					'" displayFormat="' + displayFormat +
					'" displayFormatter="' + displayFormatter +
					'" dataType="' + dataType +
					'" colSpan="' + colSpan +
					'" rowSpan="' + rowSpan +
					'" expression="' + expression +
					'"></w2:column>';
			}
		}
	}

	// 데이타리스트 생성
	// ecsLib.createDataList($p, dataListId, dataListInfo);

	// gridView 정보 정의
	// xml 형식을 정의 하면 <w2:gridView 에 xmlns:w2="http://www.inswave.com/websquare" xmlns:ev="http://www.w3.org/2001/xml-events" 포함 합니다.
	var autoFit;
	var visibleRowNum;
	var style;
	var fixedRightColumn;
	var oddEvenColorDisplay;
	var fixedColumn;
	var editModeEvent;
	var onafteredit;
	var focusMode;
	var clazz;
	var targetColumnID;

	if (!!gridProp) {
		if (!!gridProp.autoFit) {
			autoFit = gridProp.autoFit;
		} else {
			autoFit = "";
		}
		if (!!gridProp.visibleRowNum) {
			if (gridProp.visibleRowNum == "ignore") {
				visibleRowNum = "";
			} else {
				visibleRowNum = gridProp.visibleRowNum;
			}
		} else {
			visibleRowNum = "10";
		}
		if (!!gridProp.style) {
			style = gridProp.style;
		} else {
			style = "";
		}
		if (!!gridProp.fixedRightColumn) {
			fixedRightColumn = gridProp.fixedRightColumn;
		} else {
			fixedRightColumn = "";
		}
		if (!!gridProp.oddEvenColorDisplay) {
			oddEvenColorDisplay = gridProp.oddEvenColorDisplay;
		} else {
			oddEvenColorDisplay = "";
		}
		if (!!gridProp.fixedColumn) {
			fixedColumn = gridProp.fixedColumn;
		} else {
			fixedColumn = "";
		}
		if (!!gridProp.editModeEvent) {
			editModeEvent = gridProp.editModeEvent;
		} else {
			editModeEvent = "";
		}
		if (!!gridProp.onafteredit) {
			onafteredit = gridProp.onafteredit;
		} else {
			onafteredit = "";
		}
		if (!!gridProp.onrowindexchange) {
			onrowindexchange = gridProp.onrowindexchange;
		} else {
			onrowindexchange = "";
		}
		if (!!gridProp.focusMode) {
			focusMode = gridProp.focusMode;
		} else {
			focusMode = "row";
		}
		if (!!gridProp.class) {
			clazz = gridProp.class;
		} else {
			clazz = "";
		}
		if (!!gridProp.targetColumnID) {
			targetColumnID = gridProp.targetColumnID;
		} else {
			targetColumnID = "";
		}
	} else {
		autoFit = "";
		visibleRowNum = "10";
		focusMode = "row";
	}

	var gridStr = '<w2:gridView xmlns:w2="http://www.inswave.com/websquare" xmlns:ev="http://www.w3.org/2001/xml-events" dataList="' + dataListId +
		'" scrollByColumn="false" id="' + gridId +
		'" fixedColumnWithHidden="true" useShiftKey="false" style="' + style +
		'" autoFit="' + autoFit +
		'" fixedRightColumn="' + fixedRightColumn +
		'" oddEvenColorDisplay="' + oddEvenColorDisplay +
		'" fixedColumn="' + fixedColumn +
		'" editModeEvent="' + editModeEvent +
		'" ev:onafteredit="' + onafteredit +
		'" ev:onrowindexchange="' + onrowindexchange +
		'" tooltipDisplay="true" focusMode="' + focusMode +
		'" class="'+ clazz +'">' +
		'<w2:header id="header1" style="">';
	for (var i = 0; i < gridHeader.length; i++) {
		gridStr += '<w2:row id="h_row' + (i + 1) + '" style="">' + gridHeader[i] + "</w2:row>";
	}

	gridStr += "</w2:header>" +
		'<w2:gBody id="gBody1" style="">' +
		'<w2:row id="row' + (gridHeader.length + 1) +
		'" style="">' + gridBody +
		"</w2:row>" +
		"</w2:gBody>";

	if (gridSubTotal.length > 0) {
		gridStr += '<w2:subTotal style="" id="" targetColumnID="'+targetColumnID+'">' ;
		for (var i = 0; i < gridSubTotal.length; i++) {
			gridStr += '<w2:row style="" id="s_row' + (i + 1) + '">' + gridSubTotal[i] + "</w2:row>" ;
		}
		gridStr += "</w2:subTotal>" ;
	}
	if (gridFooter.length > 0) {
		gridStr += '<w2:footer style="" id="footer1">' ;
		for (var i = 0; i < gridFooter.length; i++) {
			gridStr += '<w2:row style="" id="f_row' + (i + 1) + '">' + gridFooter[i] + "</w2:row>" ;
		}
		gridStr += "</w2:footer>";
	}
	gridStr += "</w2:gridView>";
	var gridHeight=$p.getComponentById(gridId).getSize("height");
	$p.getComponentById(gridId).setGridStyle(WebSquare.xml.parse(gridStr , true));
	$p.getComponentById(dataListId).setJSON(dataObj);
	// if ($(".w2grid:visible").length == 1) {
	$p.getComponentById(gridId).setGridHeight(gridHeight);
	// ecsLib.setGridAutoHeight($p, $p.getComponentById(gridId));
	// }
	if (typeof callback === "function") {
		callback();
	}
};

/**
 * 숫자를 천자리 콤마와 자릿수로 round 한다.
 *
 * @param number string 입력값
 * @param prec 소숫자리
 * @param def 기본값
 */
ecsLib.number = function(number, prec, def) {
	if(number != "0" && (number == "" || number === "undefined")) {
		return def;
	}
	var nStr = ("" + number).replace(/[^0-9\+\-\.]/g, "");
	number = !isFinite(nStr) ? parseFloat(0) : parseFloat(nStr);
	var n;
	if (prec > 0) {
		var isMinus = number < 0;
		number = ecsLib.round(Math.abs(number), prec);
		var s = ("" + number).split(".");
		if (s.length == 1) {
			n = ecsLib.numberComma(s[0]) + "." + ecsLib.rpad("", prec, "0");
		} else if(s.length == 2) {
			n = ecsLib.numberComma(s[0]) + "." + ecsLib.rpad(s[1], prec, "0");
		}
	} else {
		n = ecsLib.numberComma(number);
	}
	return (isMinus ? "-" + n : n);
};

/**
 * 숫자를 해당 자릿수에서 round한다.
 *
 * @param number 입력값
 * @param prec 소숫자리
 */
ecsLib.round = function(number, prec) {
	var k = Math.pow(10, prec);
	return Math.round(number * k) / k;
};

/**
 * 숫자를 천자리마다 콤마를 찍는다.
 *
 * @param originalStr 입력값
 */
ecsLib.numberComma = function(originalStr) {
	return originalStr.toString().replace(/(\d)(?=(?:\d{3})+(?!\d))/g, "$1,");
};

/**
 * 입력문자열에 오른쪽에 length 만큼 pad문자를 채운다.
 *
 * @param originalStr 입력값
 * @param length 길이
 * @param strToPad pad할 문자
 */
ecsLib.rpad = function(originalStr, length, strToPad) {
	while (originalStr.length < length) {
		originalStr = originalStr + strToPad;
	}
	return originalStr;
};

/**
 * 입력문자열에 왼쪽에 length 만큼 pad문자를 채운다.
 *
 * @param originalStr 입력값
 * @param length 길이
 * @param strToPad pad할 문자
 */
ecsLib.lpad = function(originalStr, length, strToPad) {
	while (originalStr.length < length) {
		originalStr = strToPad + originalStr;
	}
	return originalStr;
};

/**
 * 기안 문서 호출 - comLib.runHandyGian
 * @param paramObj 		기안 파라미터 배열
 * @param attchObj 		기안 첨부파일 배열
 * @param draftDocNm 	기안 결재문서명
 * @param draftDocID 	기안 결재문서ID
 * @param filePath 		첨부파일 저장위치
 *
 */
ecsLib.callDraftDoc = function($p, paramObj, attchObj, draftDocNm, draftDocID, filePath) {
	if (attchObj == undefined || attchObj == null ) {
		attchObj = [];
	}
	ecsLib.runHandyGian($p,
		draftDocNm,			// 결재문서명
		draftDocID,			// 결재 문서 ID
		paramObj,			// 결재 정보
		attchObj,			// 첨부파일 정보
		filePath,			// 첨부파일 저장위치
	);
};

/**
 * [OASIS결재] 결재문서를 팝업화면으로 조회한다.
 * @param strApprId 	결재문서ID(SDOCID.UDOCID)
 * @return 	없음
 * @example
 * @since 2017.10.23
 * @author CMS
 */
ecsLib.gfnSanctnDocView_old = function(strApprId) {
	var strOasisUrl = "toasis.[BASE_DOMAIN]"; // OASIS Url
	if (comLib.ECS_POP_URL.indexOf("https://d") < 0) { // 운영Url
		strOasisUrl = "oasis.[BASE_DOMAIN]";
	}
	var url = "https://" + strOasisUrl + "/custom/view_external.jsp?USU=" + comLib.getUsrEmpno() + "&DOCID=" + strApprId;

	window.open(url, "결재문서보기", "width=1,height=1,status=no,center=yes,border=thin,resize=yes,statusbar=yes");
};

ecsLib.gfnSanctnDocView = function($p, strApprId) {
	ecsLib.gfnSanctnDocView_Enc($p, strApprId);
	// N오아시스 도입이전
	// ecsLib.gfnSanctnDocView_old(strApprId);
	// return;
};

ecsLib.gfnSanctnDocView_Enc= function ($p, strApprId) {
	var requestData = {};
	requestData.EmpNo = comLib.getUsrEmpno();
	requestData.StrApprId = strApprId;
	var option = {
		action : "zz/sanctn/getEncKey.do",
		reqData : requestData,
		resData : "",
		success : function(resBody) {
			ecsLib.gfnSanctnDocViewEnc(resBody);
		},
		isShowMeg : false
	};
	ajaxLib.executeAjaxSync($p, option);
};

ecsLib.gfnSanctnDocViewEnc = function(resBody) {
	var strOasisUrl = "toasis.[BASE_DOMAIN]"; // OASIS Url
	if (comLib.ECS_POP_URL.indexOf("https://d") < 0 ) { // 운영Url
		strOasisUrl = "oasis.[BASE_DOMAIN]";
	}
	var url = "https://" + strOasisUrl + "/custom/DocViewer.jsp?APPRID=" + resBody.data.strApprId + "&EMPCODE=" + resBody.data.encKey + "&crypt=1" ;

	window.open(url, "결재문서보기", "width=1,height=1,status=no,center=yes,border=thin,resize=yes,statusbar=yes");
};

//오아시스 결재문서 진행상태를 팝업으로 조회
//@param {String} apprId : 오아시스 결재문서번호
ecsLib.gfnSanctnDocPgsstsView_old = function(apprId) {
	var strOasisUrl = "toasis.[BASE_DOMAIN]"; // OASIS Url

	if ( comLib.ECS_POP_URL.indexOf("https://d") < 0 ) { // 운영Url
		strOasisUrl = "oasis.[BASE_DOMAIN]";
	}
	var url = "https://" + strOasisUrl + "/custom/info_external.jsp?USS=1&USU=" + comLib.getUsrEmpno() + "&APPLID=2020&APPRID=" + apprId
	window.open(url, "결재문서 진행상태 조회", "width=580,height=260,status=no,center=yes,border=thin,resize=yes,statusbar=yes");
};

ecsLib.gfnSanctnDocPgsstsView = function($p, apprId) {
		ecsLib.gfnSanctnDocPgsstsView_Enc($p, apprId);
	// ecsLib.gfnSanctnDocPgsstsView_old(apprId);
	// return;
};

ecsLib.gfnSanctnDocPgsstsView_Enc= function ($p, strApprId) {
	var requestData = {};
	requestData.EmpNo =comLib.getUsrEmpno();
	requestData.StrApprId =strApprId;
	var option = {
		action : "zz/sanctn/getEncKey.do",
		reqData : requestData,
		resData : "",
		success : function(resBody) {
			ecsLib.gfnSanctnDocPgsstsViewEnc(resBody);
		},
		isShowMeg : false
	};
	ajaxLib.executeAjaxSync($p, option);
};

ecsLib.gfnSanctnDocPgsstsViewEnc = function(resBody) {
	var strOasisUrl = "toasis.[BASE_DOMAIN]"; // OASIS Url

	if (comLib.ECS_POP_URL.indexOf("https://d") < 0) { // 운영Url
		strOasisUrl = "oasis.[BASE_DOMAIN]";
	}
	var url  = "https://" + strOasisUrl + "/custom/InfoWnd.jsp?APPRID=" + resBody.data.strApprId + "&EMPCODE=" + resBody.data.encKey + "&crypt=1";
	window.open(url, "결재문서 진행상태 조회", "width=580,height=260,status=no,center=yes,border=thin,resize=yes,statusbar=yes");
};

//오아시스 접수문서 검색 팝업
//@params {String} strCallback 접수문서 선택 후 수행할 opener의 함수
//@returns f("내부기안문서번호", "내부기안문서명")
ecsLib.gfnRceptDocNoSearch = function($p, strCallback) {
	if (strCallback) {
		if (typeof strCallback === "string") {
			if (strCallback.indexOf("scwin.") === 0) {
				strCallback = $p.id+strCallback;
			}
		} else {
			alert("콜백함수 처리는 문자열로만 가능합니다 .");
		}
	}
	comLib.openPopup($p, "ECSPG11230003","/ui/ecs/pg/1_wtwkplan/uswtralctnplan/wtwkplanrvw/ECSPG11230003.xml", {
		type:"window",
		title:"접수문서 불러오기",
		popupParam : {
			popupId : "ECSPG11230003",
			closeCallbackFncName : strCallback
		},
		modal: true,
		width: 1300,
		height: 550
	});
};

/***********************
 * CITRIX
 ***********************/
var citrixLib = {};

citrixLib.GetKwaterRetireEmbed = function() {
	var obj;
	try {
		obj = kwaterretireembed;
	} catch(e) {
		obj = parent.kwaterretireembed;
	}
	return obj;
};

citrixLib.GetOSVersion = function() {
	var res;
	var rsms = citrixLib.GetKwaterRetireEmbed();
	try {
		var Elevator = rsms.Elevation();
		Elevator.window = window;
		res = Elevator.GetOSVersion();
	} catch(e){
		res = rsms.GetOSVersion();
	}
};

citrixLib.SetDeleteFile = function(FilePath) {
	var res;
	var rsms = citrixLib.GetKwaterRetireEmbed();

	try {
		Elevator = rsms.Elevation();
		Elevator.window = window;
		res = Elevator.SetDeleteFile( FilePath );
	} catch(e){
		res = rsms.SetDeleteFile( FilePath );
	}
};

citrixLib.SetWriteFile = function(FilePath, FileContents) {
	var res;
	var rsms = citrixLib.GetKwaterRetireEmbed();

	try {
		Elevator = rsms.Elevation();
		Elevator.window = window;
		res = Elevator.SetWriteFile(FilePath, FileContents);
	} catch(e){
		res = rsms.SetWriteFile(FilePath, FileContents);
	}
};

citrixLib.ExecApp = function(FilePath) {
	var res;
	var rsms = citrixLib.GetKwaterRetireEmbed();

	try {
		Elevator = rsms.Elevation();
		Elevator.window = window;
		res = Elevator.ExecApp(FilePath);
	} catch(e){
		res = rsms.ExecApp(FilePath);
	}
};

/**
 * 모형프로그램 실행
 */
citrixLib.CitrixCall = function(empno) {
	var osVersion = citrixLib.GetOSVersion();
	if (osVersion == 32) {
		// var citrixFlag = File0.IsExistFile("C:/Program Files (x86)/Citrix/ICA Client/Receiver/Receiver.exe");
	} else {
		// var citrixFlag = File0.IsExistFile("C:/Program Files/Citrix/ICA Client/Receiver/Receiver.exe");
	}
	// 시트릭스 호출파일 삭제
	citrixLib.SetDeleteFile("[CLIENT_FILE_PATH].ica");
	citrixLib.SetDeleteFile("[CLIENT_FILE_PATH].bat");

	var sParm = "";
	sParm += "[Encoding]\n";
	sParm += "InputEncoding=UTF8\n";
	sParm += "\n";
	sParm += "[WFClient]\n";
	sParm += "CPMAllowed=On\n";
	sParm += "ClientName=WI_36I2waKs3wbbWJ0bX\n";
	sParm += "ProxyType=None\n";
	sParm += "RemoveICAFile=no\n";
	sParm += "TransparentKeyPassthrough=Local\n";
	sParm += "TransportReconnectEnabled=On\n";
	sParm += "VSLAllowed=On\n";
	sParm += "Version=2\n";
	sParm += "VirtualCOMPortEmulation=Off\n";
	sParm += "\n";
	sParm += "[ApplicationServers]\n";
	sParm += "DAM Sedi Luncher=\n";
	sParm += "\n";
	sParm += "[DAM Sedi Luncher]\n";
	sParm += "Address=172.20.250.72:1494\n";
	sParm += "AutologonAllowed=ON\n";
	sParm += "BrowserProtocol=HTTPonTCP\n";
	sParm += "CGPAddress=*:2598\n";
	sParm += "ClientAudio=On\n";
	sParm += "DesiredColor=8\n";
	sParm += "DesiredHRES=0\n";
	sParm += "DesiredVRES=0\n";
	sParm += "Username=[GW_USERNAME]\\n";
	sParm += "ClearPassword=[GW_PASSWORD]\\n";
	sParm += "Domain=[BASE_DOMAIN]\n";
	sParm += "DoNotUseDefaultCSL=On\n";
	sParm += "FontSmoothingType=0\n";
	sParm += "HDXoverUDP=Off\n";
	sParm += "InitialProgram=#DAM_RAS_Luncher\n";
	sParm += "Launcher=WI\n";
	// sParm += "LaunchReference=3585A99A34F954406262A652902C74\n";
	sParm += "LocHttpBrowserAddress=!\n";
	// sParm += "LogonTicket=D133895437283B7B0166198156F26B\n";
	// sParm += "LogonTicketType=CTXS1\n";
	sParm += "LongCommandLine=\n";
	sParm += "LPWD=406\n";
	sParm += "NRWD=218\n";
	sParm += "ProxyTimeout=30000\n";
	sParm += "ProxyType=Auto\n";
	// sParm += "SessionsharingKey=MqAM/ols7CJ4qUw1WAtsgpXHPownw8mQ\n";
	sParm += "SFRAllowed=Off\n";
	sParm += "SSLEnable=Off\n";
	sParm += "startSCD=1513749534100\n";
	sParm += "Title=DAM RAS Luncher\n";
	sParm += "TransportDriver=TCP/IP\n";
	sParm += "TRWD=0\n";
	sParm += "TWIMode=On\n";
	sParm += "WinStationDriver=ICA 3.0\n";
	sParm += "\n";
	sParm += "[Compress]\n";
	sParm += "DriverNameWin16=pdcompw.dll\n";
	sParm += "DriverNameWin32=pdcompn.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-0]\n";
	sParm += "DriverNameWin16=pdc0w.dll\n";
	sParm += "DriverNameWin32=pdc0n.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-128]\n";
	sParm += "DriverNameWin16=pdc128w.dll\n";
	sParm += "DriverNameWin32=pdc128n.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-40]\n";
	sParm += "DriverNameWin16=pdc40w.dll\n";
	sParm += "DriverNameWin32=pdc40n.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-56]\n";
	sParm += "DriverNameWin16=pdc56w.dll\n";
	sParm += "DriverNameWin32=pdc56n.dll\n";

	// C:\\[CLIENT_FILE_PATH] 파일생성
	citrixLib.SetWriteFile("[CLIENT_FILE_PATH].ica", sParm);

	var sParm ="";
	sParm += "@echo off\n";
	sParm +="\n";
	sParm += "CALL [CLIENT_FILE_PATH]\n";

	citrixLib.SetWriteFile("[CLIENT_FILE_PATH].bat",sParm);
	citrixLib.ExecApp("[CLIENT_FILE_PATH]");
};

citrixLib.CitrixCall3D = function(empno) {
	var osVersion = citrixLib.GetOSVersion();
	if (osVersion == 32) {
		// var citrixFlag = File0.IsExistFile("C:/Program Files (x86)/Citrix/ICA Client/Receiver/Receiver.exe");
	}else{
		// var citrixFlag = File0.IsExistFile("C:/Program Files/Citrix/ICA Client/Receiver/Receiver.exe");
	}
	// 시트릭스 호출파일 삭제
	citrixLib.SetDeleteFile("[CLIENT_FILE_PATH]3D.ica");
	citrixLib.SetDeleteFile("[CLIENT_FILE_PATH]3D.bat");

	var sParm = "";
	sParm += "[Encoding]\n";
	sParm += "InputEncoding=UTF8\n";
	sParm += "\n";
	sParm += "[WFClient]\n";
	sParm += "CPMAllowed=On\n";
	sParm += "ClientName=WI_36I2waKs3wbbWJ0bX\n";
	sParm += "ProxyType=None\n";
	sParm += "RemoveICAFile=no\n";
	sParm += "TransparentKeyPassthrough=Local\n";
	sParm += "TransportReconnectEnabled=On\n";
	sParm += "VSLAllowed=On\n";
	sParm += "Version=2\n";
	sParm += "VirtualCOMPortEmulation=Off\n";
	sParm += "\n";
	sParm += "[ApplicationServers]\n";
	sParm += "DAM Sedi Luncher=\n";
	sParm += "\n";
	sParm += "[DAM Sedi Luncher]\n";
	sParm += "Address=172.20.250.72:1494\n";
	sParm += "AutologonAllowed=ON\n";
	sParm += "BrowserProtocol=HTTPonTCP\n";
	sParm += "CGPAddress=*:2598\n";
	sParm += "ClientAudio=On\n";
	sParm += "DesiredColor=8\n";
	sParm += "DesiredHRES=0\n";
	sParm += "DesiredVRES=0\n";
	sParm += "Username=[GW_USERNAME]\\n";
	sParm += "ClearPassword=[GW_PASSWORD]\\n";
	sParm += "Domain=[BASE_DOMAIN]\n";
	sParm += "DoNotUseDefaultCSL=On\n";
	sParm += "FontSmoothingType=0\n";
	sParm += "HDXoverUDP=Off\n";
	sParm += "InitialProgram=#DAM_RAS_Luncher_1\n";
	sParm += "Launcher=WI\n";
	// sParm += "LaunchReference=3585A99A34F954406262A652902C74\n";
	sParm += "LocHttpBrowserAddress=!\n";
	// sParm += "LogonTicket=D133895437283B7B0166198156F26B\n";
	// sParm += "LogonTicketType=CTXS1\n";
	sParm += "LongCommandLine=\n";
	sParm += "LPWD=406\n";
	sParm += "NRWD=218\n";
	sParm += "ProxyTimeout=30000\n";
	sParm += "ProxyType=Auto\n";
	// sParm += "SessionsharingKey=MqAM/ols7CJ4qUw1WAtsgpXHPownw8mQ\n";
	sParm += "SFRAllowed=Off\n";
	sParm += "SSLEnable=Off\n";
	sParm += "startSCD=1513749534100\n";
	sParm += "Title=DAM Sedi Luncher\n";
	sParm += "TransportDriver=TCP/IP\n";
	sParm += "TRWD=0\n";
	sParm += "TWIMode=On\n";
	sParm += "WinStationDriver=ICA 3.0\n";
	sParm += "\n";
	sParm += "[Compress]\n";
	sParm += "DriverNameWin16=pdcompw.dll\n";
	sParm += "DriverNameWin32=pdcompn.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-0]\n";
	sParm += "DriverNameWin16=pdc0w.dll\n";
	sParm += "DriverNameWin32=pdc0n.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-128]\n";
	sParm += "DriverNameWin16=pdc128w.dll\n";
	sParm += "DriverNameWin32=pdc128n.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-40]\n";
	sParm += "DriverNameWin16=pdc40w.dll\n";
	sParm += "DriverNameWin32=pdc40n.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-56]\n";
	sParm += "DriverNameWin16=pdc56w.dll\n";
	sParm += "DriverNameWin32=pdc56n.dll\n";

	// C:\\[CLIENT_FILE_PATH] 파일생성
	citrixLib.SetWriteFile("[CLIENT_FILE_PATH]3D.ica", sParm);

	var sParm ="";
	sParm += "@echo off\n";
	sParm +="\n";
	sParm += "CALL [CLIENT_FILE_PATH]\n";

	citrixLib.SetWriteFile("[CLIENT_FILE_PATH]3D.bat", sParm);
	citrixLib.ExecApp("[CLIENT_FILE_PATH]");
};

/**
 * 3D GIS 프로그램 실행
 */
citrixLib.CitrixCallGIS = function(empno) {
	$('<object id="kwaterretireembed" classid="clsid:90AD833E-2B48-4D2D-B282-B47DDD3F25C0" codebase="/resources/js/ecs/wd/module/KwaterRSMS.ocx#version=1,0,0,0" width="0" height="0" align="center" hspace="0" vspace="0"></object>').prependTo("body");
	/*
	empno = "30011573" // 사원번호를 김기철 박사 번호로 함
	var osVersion = citrixLib.GetOSVersion();
	if (osVersion == 32) {
		// var citrixFlag = File0.IsExistFile("C:/Program Files (x86)/Citrix/ICA Client/Receiver/Receiver.exe");
	} else {
		// var citrixFlag = File0.IsExistFile("C:/Program Files/Citrix/ICA Client/Receiver/Receiver.exe");
	}
	citrixLib.SetDeleteFile("[CLIENT_FILE_PATH]GIS.ica");
	citrixLib.SetDeleteFile("[CLIENT_FILE_PATH]GIS.bat");

	var sParm = "";
	sParm += "[Encoding]\n";
	sParm += "InputEncoding=UTF8\n";
	sParm += "\n";
	sParm += "[WFClient]\n";
	sParm += "CPMAllowed=On\n";
	sParm += "ClientName=WI_36I2waKs3wbbWJ0bX\n";
	sParm += "ProxyType=None\n";
	sParm += "RemoveICAFile=no\n";
	sParm += "TransparentKeyPassthrough=Local\n";
	sParm += "TransportReconnectEnabled=On\n";
	sParm += "VSLAllowed=On\n";
	sParm += "Version=2\n";
	sParm += "VirtualCOMPortEmulation=Off\n";
	sParm += "\n";
	sParm += "[ApplicationServers]\n";
	sParm += "RSMS_Launcher=\n";
	sParm += "\n";
	sParm += "[RSMS_Launcher]\n";
	sParm += "Address=172.20.250.71:1494\n";
	sParm += "AutologonAllowed=ON\n";
	sParm += "BrowserProtocol=HTTPonTCP\n";
	sParm += "CGPAddress=*:2598\n";
	sParm += "ClientAudio=On\n";
	sParm += "DesiredColor=8\n";
	sParm += "DesiredHRES=0\n";
	sParm += "DesiredVRES=0\n";
	sParm += "Username=[GW_USERNAME]\\n";
	sParm += "ClearPassword=[GW_PASSWORD]\\n";
	sParm += "Domain=[BASE_DOMAIN]\n";
	sParm += "DoNotUseDefaultCSL=On\n";
	sParm += "FontSmoothingType=0\n";
	sParm += "HDXoverUDP=Off\n";
	sParm += "InitialProgram=#RSMS_Launcher\n";
	sParm += "Launcher=WI\n";
	sParm += "LocHttpBrowserAddress=!\n";
	sParm += "LongCommandLine=\n";
	sParm += "LPWD=468\n";
	sParm += "NRWD=234\n";
	sParm += "ProxyTimeout=30000\n";
	sParm += "ProxyType=Auto\n";
	sParm += "SessionsharingKey=B3qa6+LKx4p7d0Mv2S4O1yC/Dtkw7vO7\n";
	sParm += "SFRAllowed=Off\n";
	sParm += "SSLEnable=Off\n";
	sParm += "startSCD=1513823858287\n";
	sParm += "Title=RSMS Launcher\n";
	sParm += "TransportDriver=TCP/IP\n";
	sParm += "TRWD=0\n";
	sParm += "TWIMode=On\n";
	sParm += "WinStationDriver=ICA 3.0\n";
	sParm += "\n";
	sParm += "[Compress]\n";
	sParm += "DriverNameWin16=pdcompw.dll\n";
	sParm += "DriverNameWin32=pdcompn.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-0]\n";
	sParm += "DriverNameWin16=pdc0w.dll\n";
	sParm += "DriverNameWin32=pdc0n.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-128]\n";
	sParm += "DriverNameWin16=pdc128w.dll\n";
	sParm += "DriverNameWin32=pdc128n.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-40]\n";
	sParm += "DriverNameWin16=pdc40w.dll\n";
	sParm += "DriverNameWin32=pdc40n.dll\n";
	sParm += "\n";
	sParm += "[EncRC5-56]\n";
	sParm += "DriverNameWin16=pdc56w.dll\n";
	sParm += "DriverNameWin32=pdc56n.dll\n";

	citrixLib.SetWriteFile("[CLIENT_FILE_PATH]GIS.ica", sParm);

	var sParm ="";
	sParm += "@echo off\n";
	sParm += "\n";
	sParm += "CALL [CLIENT_FILE_PATH]\n";

	citrixLib.SetWriteFile("[CLIENT_FILE_PATH]GIS.bat", sParm);
	*/
	citrixLib.ExecApp("[CLIENT_FILE_PATH]");
};

/***************************************************************** UTIL ********************************************************************************/
// object의 사이즈(key의 갯수)를 리턴
ecsLib.objSize = function(obj) {
	if ($.type(obj) !== "object") {
		return 0;
	}
	var size = 0;

	if (Object.keys !== undefined) {
		size = Object.keys(obj).length;
	} else {
		for (var x in obj) {
			size = size + 1;
		}
	}

	return size;
};

// 배열 요소를 유일하게 리턴
ecsLib.uniqueArray = function(array) {
	if ($.type(array) !== "array") {
		throw "배열이 아닙니다";
	}

	var uniq = [];
	var i;
	var il;
	if (array.reduce) {
		uniq = array.reduce(function(a, b) {
			if (a.indexOf(b) < 0) {
				a.push(b);
			}
			return a;
		}, []);
	} else { // array.reduce 미지원 브라우저
		for (i = 0, il = array.length; i < il; i++) {
			if ($.inArray(uniq, array[i]) === -1) {
				uniq[uniq.length] = array[i];
			}
		}
	}

	return uniq;
};

// 조사 리턴
// @param {String} str
// @param {String} pp1 	조사: 은 / 이
// @param {String} pp2 	조사: 는 / 가
// @returns {String} "은" 혹은 "는"
ecsLib.getPostPosition = function(str, pp1, pp2) {
	pp1 = pp1 == null || pp1 === "" ? "은" : pp1;
	pp2 = pp2 == null || pp2 === "" ? "는" : pp2;

	var pp12 = pp1 + "(" + pp2 + ")";

	if ( str == null || str === "" ) {
		return pp12;
	}

	str = (str + "").replace(/[\(\[].*[\)|\]]/, ""); // [], ()로 감싸인 문자 제거

	var l = str.length;
	var ascii;
	var chr = str.slice(l - 1, l); // 마지막 글자

	var result = (escape(chr).replace("%u", "0x") - 0xAC00) % 28;

	return isNaN(result) ? pp12 : result === 0 ? pp2 : pp1;
};

// 소수점 이하 자리수가 몇자리인지 리턴
// value 파라미터의 타입이 숫자인 경우, 소수부 15자리까지만 정밀도를 보장
// @param {?} value
// @returns {Number} .이하 자리수
ecsLib.getDecimalPoint =  function(value) {
	// 자리수만 체크하는 util이므로 빈 값이나 숫자가 아닌 경우에도 0 리턴
	if (value == null || value === "" || isNaN(value + "") === true) {
		return 0;
	}

	value = value + "";

	var pos = value.lastIndexOf(".");

	return pos === -1 ? 0 :
		(value.substr(pos).length - 1 === 0 ? 0 : value.substr(pos).length - 1);
};

// 비교값이 기간에 속하는지 확인
// 기간을 비교시 ecsLib.isPeriod(시작일, 종료일, 비교시작일) && ecsLib.isPeriod(시작일, 종료일, 비교종료일)
// @param {?} sdate : 시작일
// @param {?} edate : 종료일
// @param {?} cdate : 비교일
// @returns {Boolean} true/false
ecsLib.isPeriod = function(sdate, edate, cdate) {
	var s = parseInt(sdate, 10);
	var e = parseInt(edate, 10);
	var c = parseInt(cdate, 10);

	if (isNaN(sdate) || isNaN(edate) || isNaN(cdate)) {
		comLib.alert($p, "비교값들이 숫자 타입이 아닙니다.");
		throw "비교값들이 숫자 타입이 아닙니다.";
	}

	if (c >= s && c <= e) {
		return true;
	}

	return false;
};

// 숫자 세자리마다 콤마
// 기존 ecsLib.numberComma가 소수점에도 ,처리를 해서 신규 생성
// @param {?} value : 값
// @returns {String} ex) 1,212,312.123123
ecsLib.setThousandsSeparator = function(value) {
	if (value == null || value === "") {
		return "";
	}

	// trim 처리
	value = (value + "").replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, "");

	var pref = value; // 정수부
	var suf = ""; // 소수부
	var array;

	// 소수점 이하 있을 경우
	if (value.indexOf(".") !== -1) {
		array = value.split(".");
		pref = array[0]; // 정수부
		suf = "." + array[1]; // 소수부
	}

	// 정수부에 대해서만 ,처리
	return pref.replace(/\B(?=(\d{3})+(?!\d))/g, ",") + suf;
};

// 날짜 파싱
// @param {Date || String || Number} obj
ecsLib.parseDate = function(obj) {
	var type = $.type(obj);
	var date;

	if (type !== "date" && type !== "string" && type !== "number") {
		return null;
	}

	if (type === "number") {
		// console.log("숫자 타입의 날짜인 경우 00010101 = > 4161로 인식. 되도록 문자 타입으로!");
		obj = obj + "";
	}

	if (type === "date") {
		date = obj;
	} else { // type === "string"
		obj = obj.replace(/[^\d]/g, "");
		if (obj.length !== 8) {
			return null;
		}
		date = new Date(obj.slice(0, 4), parseInt(obj.slice(4, 6), 10) - 1, obj.slice(6, 8));
	}

	if (date.toString() === "Invalid Date") {
		return null;
	}

	return date;
};

// Date 타입의 날짜를 포맷에 따라 리턴
// @param {Date} date
// @param {String} format
ecsLib.formatDate = function(date, format) {
	format = format == null || format === "" ? "yyyy-MM-dd" : format;

	if ($.type(date) !== "date" || date.toString() === "Invalid Date") {
		return "";
	}

	var opts = {
		year : format.indexOf("yy") > -1, // 년도 요청 true/false
		fullYear : format.indexOf("yyyy") > -1, // FullYear 요청 true/false
		month : format.indexOf("MM") > -1 , // 월 true/false
		date : format.indexOf("dd") > -1, // 날짜 true/false
		delimiter : format.replace(/[yy|MM|dd]/g, "").split("")[0] || "" // 구분자(구분자는 동일하다고 판단하여 [0]을 기준으로 생성)
	};

	var y = ("0000" + date.getFullYear()).slice(-4);
	var m = ("00" + (date.getMonth() + 1)).slice(-2);
	var d = ("00" + date.getDate()).slice(-2);

	var dt = "";

	dt = opts.fullYear === true ? y : opts.year === true ? y.slice(-2) : "";
	dt = (opts.year === true || opts.fullYear === true) && opts.month === true ? dt + opts.delimiter : dt;
	dt = opts.month === true ? dt + m : dt;
	dt = opts.month === true && opts.date === true ? dt + opts.delimiter : dt;
	dt = opts.date === true ? dt + d : dt;

	return dt;
};

// 로컬 여부 확인
ecsLib.isLocal = function() {
	var host = window.location.host;
	// 운영서버 혹은 개발서버인 경우 false 리턴
	if (host.startsWith("ecs.[BASE_DOMAIN]") === true
		|| host.startsWith("decs.[BASE_DOMAIN]") === true) {
		return false;
	}

	return true;
};

// 광역수도운영 시스템관리자 여부 확인
ecsLib.isSysOper = function() {
	// 로컬인 경우 시스템관리자로 취급
	/*
	if (ecsLib.isLocal() === true) {
		return true;
	}
	*/
	var athrId = comLib.getAthrId();
	if (athrId == null || athrId === "") {
		return false;
	}

	var result = athrId.match("ECSPG010");
	if (result === null) {
		return false;
	}

	return true;
};

/****************************************************************** 첨부파일 ********************************************************************************/
// 첨부파일 목록 셋팅
// @param {String} atchflId : 첨부파일 ID
// @param {?} dataList : 첨부파일 dataList
// @param {Function} callback : callback 필요시 리턴
// @returns void
ecsLib.setFileList = function($p, atchflId, dataList, callback) {
	var dl = $.type(dataList) === "string" ? window[dataList] : dataList;

	dl.reset();

	if (atchflId == null || atchflId === "") {
		if ($.type(callback) === "function") {
			callback([]);
		}
		return;
	}

	ajaxLib.executeAjax($p, {
		action: "sc/file/fileList.do",
		reqData: {
			dmaFileBasic: {
				atchflId: atchflId
			}
		},
		resData : dl,
		isShowMeg : false,
		success : function(resBody) {
			if ($.type(callback) === "function") {
				callback(resBody.data);
			}
		}
	});
};

/****************************************************************** 공통 코드성 *****************************************************************************/
// 사용자 접속정보의 관리부서코드를 기준으로, 권역/플랜트 번호를 리턴
// 현 접속자의 권역과 시설 부서를 셋팅하기 위함
// @param	{Function}	callback : callback 함수
// @returns	{Function}	callback			 : {dstrctHqCd: "XX", dstrctHqNm: "XX", mnggrpNm: "XX", plntNo: "XX"}
// 사용예시 ecsLib.getUsrDstrctHqInfo(function(info) {
// // 변환된 plntNo로 권역 및 부서 선택 후 조회 진행
// });
ecsLib.getUsrDstrctHqInfo = function($p, callback) {
	ajaxLib.executeAjax($p, {
		action: "pg/cmmn/selectUsrDstrctHqInfo.do",
		reqData: {
			searchVo: {
				objid: comLib.getUsrDeptCd()
			}
		},
		isShowMeg: false,
		success: function(resBody) {
			var data = resBody.data;
			if (data.dstrctHqCd != "10990028" && data.dstrctHqCd != "20060557" && data.dstrctHqCd != "20060674" && data.dstrctHqCd != "50043037") {
				data.dstrctHqNm = "본사";
				data.dstrctHqCd = "50013977";
			}

			//console.log(comLib.getUsrDeptCd() + " => " + JSON.stringify(data));

			if ( $.type(callback) === "function" ) {
				callback(data);
			}
		}
	});
};

ecsLib.UserInfo={};

/**
 * 사용자정보에서 특정 값을 얻는다.
 * @param name 변수명
 * @return 변수값
 */
ecsLib.getUserInfo = function($p, name) {
	try {
		var tmpobj=ecsLib.UserInfo[name];
		if (tmpobj) {
			return tmpobj;
		}
		if (name=="dstrctHqCd" ||name=="mnggrpCd" || name=="plntNo" || name=="plntNo2" || name=="hqCd" || name=="mngDeptCd") {
			ecsLib.setUsrPlntNo($p);
		}
		var tmpobj2 = ecsLib.UserInfo[name];
		return tmpobj2;
	} catch(e) {
		alert("[error at comLib.getUserInfo]" + e);
	}
};

/**
 * setUsrDstrctHqCdInfo : 로그인사용자의 권역, 관리부서 조회
 */
ecsLib.setUsrPlntNo = function($p, callback) {
	var requestData = {};
	requestData.searchVo = {
		empno : comLib.getUsrEmpno()
	};
	var option = {
		action : "pg/cmmn/selectUsrPlntNo.do",
		reqData : requestData,
		resData : "",
		success : function(resBody) {
			var dstrctHqCd = "50013977";
			var plntNo = "1000";
			var mnggrpCd = "50013977";
			var plntNo2 = "";
			var hqCd = "";
			var mngDeptCd="";
			if (resBody.data != null) {
				dstrctHqCd = resBody.data.dstrctHqCd;
				plntNo = resBody.data.plntNo;
				mnggrpCd = resBody.data.mnggrpCd;
				plntNo2 = resBody.data.plntNo2;
				hqCd = resBody.data.hqCd;
				mngDeptCd = resBody.data.mngDeptCd;
			}
			/*
			if (dstrctHqCd != "10990028" && dstrctHqCd != "20060557" && dstrctHqCd != "20060674" && dstrctHqCd != "50043037") {
			// if(dstrctHqCd != "10990028" && dstrctHqCd != "20060557" && dstrctHqCd != "20060674" && dstrctHqCd != "50043037") {
				// 본사(권역본부가 한강,금,영섬,낙동강이 아닐경우 본사로)
				dstrctHqCd="50013977";
				mnggrpCd="50013977";
				plntNo="1000";
			}
			if (!(plntNo)) {
				if (dstrctHqCd != "10990028") {
					// 권역본부 한강
					plntNo="2000";
				} else if (dstrctHqCd != "20060557") {
					// 권역본부 금강
					plntNo = "3000";
				} else if (dstrctHqCd != "20060674") {
					// 권역본부 낙동강
					plntNo = "4000";
				} else if (dstrctHqCd != "50043037") {
					// 권역본부 영섬
					plntNo = "3002";
				}
			}
			*/
			ecsLib.UserInfo["dstrctHqCd"] = dstrctHqCd;
			ecsLib.UserInfo["mnggrpCd"] = mnggrpCd;
			ecsLib.UserInfo["plntNo"] = plntNo;
			ecsLib.UserInfo["plntNo2"] = plntNo2;
			ecsLib.UserInfo["hqCd"] = hqCd;
			ecsLib.UserInfo["mngDeptCd"] = mngDeptCd;
			if ($.type(callback) === "function") {
				callback();
			}
		},
		isShowMeg : false
	};
	ajaxLib.executeAjaxSync($p, option);
};

/**
 * setUsrDstrctHqCdInfo : 로그인사용자의 권역, 관리부서 조회
 */
ecsLib.setUsrDstrctHqCd = function($p, dataMap) {
	dataMap.set("dstrctHqCd",ecsLib.getUserInfo($p, "dstrctHqCd"));
	if (dataMap.getKey("mnggrpCd") != null) {
		dataMap.set("mnggrpCd", ecsLib.getUserInfo($p, "mnggrpCd"));
	}
	if (dataMap.getKey("plntNo") != null) {
		dataMap.set("plntNo", ecsLib.getUserInfo($p, "plntNo"));
	}
};

// 인사부서 목록 리턴
// dstrctHqCd : onviewchange 이벤트로 제어하는 경우 권역 코드 보내서 하위만 리턴 받도록 ! linkedList사용시 보낼 필요는 x
ecsLib.selectMngDeptCd = function($p, dstrctHqCd, callback) {
	ajaxLib.executeAjax($p, {
		action: "pg/cmmn/selectMngDeptCd.do",
		reqData: {
			searchVo: {
				dstrctHqCd: dstrctHqCd
			}
		},
		isShowMeg: false,
		success: function(resBody) {
			if ($.type(callback) === "function") {
				callback(resBody.data);
			}
		}
	});
};

// PM 권역본부 목록 조회
ecsLib.selectDstrctHqCdList = function($p, callback) {
	ajaxLib.executeAjax($p, {
		action: "pg/cmmn/selectDstrctHqCd.do",
		reqData: {},
		isShowMeg: false,
		success: function(resBody) {
			if ($.type(callback) === "function") {
				callback(resBody.data);
			}
		}
	});
};

// PM 부서 목록
// wtrscUseYn 수자원 사용여부 부서 호출 여부
ecsLib.selectPlntNoList = function($p, dstrctHqCd, callback, wtrscUseYn) {
	var sobj = {
		dstrctHqCd: dstrctHqCd,
		wtrscUseYn: wtrscUseYn == true ? "Y" : "N"
	};
	ajaxLib.executeAjax($p, {
		action: "pg/cmmn/selectMnggrpCd.do",
		reqData: {
			searchVo: sobj
		},
		isShowMeg : false,
		success: function(resBody) {
			if ($.type(callback) === "function") {
				callback(resBody.data);
			}
		}
	});
};

// PM 사업단계 목록
ecsLib.selectPmBsnsStepCdList = function($p, plntNo, callback, dstrctHqCd) {
	ajaxLib.executeAjaxSync($p, {
		action: "pg/selectPmBsnsStepCdList.do",
		reqData: {
			searchVo: {
				plntNo: plntNo,
				dstrctHqCd: dstrctHqCd
			}
		},
		isShowMeg: false,
		success: function(resBody) {
			var data = resBody.data;
			if ($.type(callback) === "function") {
				callback(data);
			}
		}
	});
};

// PM 계통 목록
ecsLib.selectPmSystCdList = function($p, bsnsStepCd, callback) {
	ajaxLib.executeAjaxSync($p, {
		action: "pg/selectPmSystCdList.do",
		reqData: {
			searchVo: {
				bsnsStepCd: bsnsStepCd
			}
		},
		isShowMeg: false,
		success: function(resBody) {
			var data = resBody.data;
			if ($.type(callback) === "function") {
				callback(data);
			}
		}
	});
};

// PM 구간 목록
ecsLib.selectPmSctnCdList = function($p, systCd, callback) {
	ajaxLib.executeAjaxSync($p, {
		action: "pg/selectPmSctnCdList.do",
		reqData: {
			searchVo: {
				systCd: systCd
			}
		},
		isShowMeg: false,
		success: function(resBody) {
			var data = resBody.data;
			if ($.type(callback) === "function") {
				callback(data);
			}
		}
	});
};

// PM 부서, 사업단계, 계통, 구간 리턴
// linkedDataList형을 사용할 경우에 사용
// ecsLib.selectPlntNoBsnsStepSystSctnList(function(ret) {
// 	ret ==> {plntNoList: [...], bsnsStepCdList: [...], systCdList: [...], sctnCdList: [...]}
// }
// @param callback : return fn
// @param uriIndex : 호출 시작 인덱스 [ 0 : 관리부서, 1: 사업단계, 2: 계통, 3: 구간]
// @param breakIndex : 중단할 index  -> 1 : 사업단계까지만 검색하고 중단
ecsLib.selectPlntNoBsnsStepSystSctnList = function($p, callback, uriIndex, breakUriIndex, obj) {
	comLib.alert($p, "UX업그레이드로 인한 함수 변경 필요 ecsLib.selectBsnsStepSystSctnList 로 변경하세요!!! PL에게 문의");
	return;
	uriIndex = (uriIndex || "").length === 0 ? 0 : uriIndex;
	obj = obj || {};

	if ($.type(uriIndex) !== "number") {
		comLib.alert($p, "uriIndex는 숫자타입이어야 합니다.");
		throw "uriIndex는 숫자타입이어야 합니다.";
	}

	if (uriIndex > 10) {
		throw "혹시 있을 무한 루프 방지";
	}

	var uris = ["pg/cmmn/selectMnggrpCd.do", "pg/selectPmBsnsStepCdList.do", "pg/selectPmSystCdList.do", "pg/selectPmSctnCdList.do"];
	var callname = ["plntNoList", "bsnsStepCdList", "systCdList", "sctnCdList"];

	ajaxLib.executeAjax($p, {
		action : uris[uriIndex],
		reqData : {
			searchVo : {}
		},
		isShowMeg : false,
		success : function(resBody) {
			obj[callname[uriIndex]] = resBody.data;

			if ((uriIndex === 3 || breakUriIndex === uriIndex) && $.type(callback) === "function") {
				callback(obj);
			} else {
				ecsLib.selectPlntNoBsnsStepSystSctnList(callback, uriIndex + 1, breakUriIndex, obj);
			}
		}
	});
};

// 사업단계, 계통, 구간 리턴
// linkedDataList형을 사용할 경우에 사용
// @param callback : return fn
// @param uriIndex : 호출 시작 인덱스 [ 0 : 관리부서, 1: 사업단계, 2: 계통, 3: 구간]
// @param breakIndex : 중단할 index  -> 1 : 사업단계까지만 검색하고 중단
ecsLib.selectBsnsStepSystSctnList = function($p, plntNo) {
	var codeList = "";
	if ($p.getComponentById("dltBsnsStepList")) {
		codeList += "bsnsStepCd,";
	}
	if ($p.getComponentById("dltSystList")) {
		codeList += "systCd,";
	}
	if ($p.getComponentById("dltSctnList")) {
		codeList += "sctnCd,";
	}
	if (codeList=="") {
		return;
	}
	var requestData = {};
	requestData.cdList = codeList;
	if (plntNo) {
		requestData.plntNo = plntNo;
	}
	// 권역 목록 
	var option = {
		action : "pg/cmmn/selectBsnsStepSystSctnList.do",
		reqData : requestData,
		// resData : ecsLib.dltDstrctHqCdList,
		success : "ecsLib.selectBsnsStepSystSctnListCallBack",
		isShowMeg : false
	};
	ajaxLib.executeAjaxSync($p, option);
};

/**
 * 운영통합[수도운영] 사업단계, 계통, 구간 조회 콜백 
 */
ecsLib.selectBsnsStepSystSctnListCallBack = function(resBody, $p) {
	if (resBody.data.bsnsStepCdList) {
		var dltctl = $p.getComponentById("dltBsnsStepList");
		dltctl.setJSON(resBody.data.bsnsStepCdList);
	}
	if (resBody.data.systCdList) {
		var dltctl2 = $p.getComponentById("dltSystList");
		dltctl2.setJSON(resBody.data.systCdList);
	}
	if (resBody.data.sctnCdList) {
		var dltctl3 = $p.getComponentById("dltSctnList");
		dltctl3.setJSON(resBody.data.sctnCdList);
	}
};

// 시설계선 > 안정화사업 : 추가 부서
// 물인프라사업처 각 권역별 추가
ecsLib.stbznAddedDept = function(array) {
	array = array || [];

	var added = [
		{cmmnCd:"20040018", cmmnCdNm: "물인프라사업처", dstrctHqNm: "한강권역", mngDeptNm:"물인프라사업처", upperCmmnCd:"10990028", dstrctHqCd: "10990028"},
		{cmmnCd:"20040018", cmmnCdNm: "물인프라사업처", dstrctHqNm: "금·영·섬권역", mngDeptNm:"물인프라사업처", upperCmmnCd:"20060557", dstrctHqCd: "20060557"},
		{cmmnCd:"20040018", cmmnCdNm: "물인프라사업처", dstrctHqNm: "낙동강권역", mngDeptNm:"물인프라사업처", upperCmmnCd:"20060674", dstrctHqCd: "20060674"}
	];

	return array.concat(added);
};

// e수도연보 전체 데이터 작성권한자: 특정사용자에게 연보 데이터 수정할 권한 부여
ecsLib.isEManager = function() {
	var allowUsers = ["20151365", "20120551"];
	// 권상열,최용성
	if ($.inArray(comLib.getUsrEmpno(), allowUsers) !== -1) {
		return true;
	}
	if (ecsLib.isSysOper()) {
		return true;
	}
	return false;
};

// 맑은물운영처만 전체 조회 가능하도록 변경[2019.06.07]
ecsLib.isWaterManager = function() {
	var allowBuses = ["10980037", "50043071"];
	// 맑은물운영처,맑은물관리처
	if ($.inArray(comLib.getUsrDeptCd(), allowBuses) !== -1) {
		return true;
	}

	return false;
};

/******************************************************************* 엑셀 업로드 그리드 서포트 *************************************************************************/

// 엑셀 업로드시 미러 그리드 자동 생성(미러 그리드는 내용은 없더라도 그리드는 생성이 되어있어야함)
// @param	<String>	원본 그리드 ID
// @param	<String>	미러 그리드의 ID
// @param	<String>	미러 그리드의  동적 생성할 데이터리스트의 ID
// @param	<Boolean>	보임 여부(default: false)..테스트시 보이도록 true 설정해서 테스트
// @returns	void
ecsLib.createMirrorGrid = function($p, gridID, mirrorGridID, dataListID, callback, isShow) {
	var getID = function() {
		if (window.ECS_UNIQUE_INDEX === undefined) {
			window.ECS_UNIQUE_INDEX = 19420;
		}

		return "column_u_" + (window.ECS_UNIQUE_INDEX++);
	};
	// var grid = window[gridID],

	var grid = $p.getComponentById(gridID);
	var columnCnt = grid.getColumnCount();
	var i;
	var il;
	var cid;
	var columns = []; // 동적 생성할 데이터 리스트에 제공
	var gh = []; // 그리드 헤더
	var gb = []; // 그리드 바디

	for (i = 0, il = columnCnt; i < il; i++) {
		cid = grid.getColumnID(i);

		gh[gh.length] = '<w2:column width="70" inputType="text" style="height:20px;" id="' + getID() +
			'" value="' + i +
			'" blockSelect="false" displayMode="label"></w2:column>';

		gb[gb.length] = '<w2:column blockSelect="false" displayMode="label" id="' + cid +
			'" inputType="text" textAlign="left" style="height:20px;"></w2:column>';

		columns[columns.length] = {
			id: cid,
			dataType: "text"
		};
	}

	// 동적 그리드 생성
	ecsLib.createDataList($p, dataListID, columns);

	// xml 형식을 정의 하면 <w2:gridView 에 xmlns:w2="http://www.inswave.com/websquare" xmlns:ev="http://www.w3.org/2001/xml-events" 포함 합니다.
	var gridStr = '<w2:gridView  xmlns:w2="http://www.inswave.com/websquare" xmlns:ev="http://www.w3.org/2001/xml-events" dataList="' + dataListID + '" '
		+ 'editModeEvent="onclick" id="' + mirrorGridID
		+ '" ev:onviewchange="scwin.' + mirrorGridID + '_onviewchange" '
		+ 'ignoreCellClick="false" ignoreToggleOnDisabled="false" readOnly="false" rowNumHeaderValue="No" rowNumVisible="true" scrollByColumn="false" '
		+ 'scrollByColumnAdaptive="false" '
		+ 'style="height:300px; display:' + (isShow === true ? '' : 'none')  + ';" summaryAuto="false" tooltipDisplay="true" useShiftKey="true" visibleRowNum="all">'
		+ '<w2:header id="header1" style="">'
		+ '<w2:row id="row1" style="">'
		+ gh.join('')
		+ '</w2:row>'
		+ '</w2:header>'
		+ '<w2:gBody id="gBody1" style="">'
		+ '<w2:row id="row2" style="">'
		+  gb.join('')
		+ '</w2:row>'
		+ '</w2:gBody>'
		+ '</w2:gridView>' ;

	var mirrorGrid = $p.getComponentById(mirrorGridID);

	mirrorGrid.setGridStyle(WebSquare.xml.parse(gridStr, true));

	if ($.type(callback) === "function") {
		callback(gridID, mirrorGridID, dataListID);
	}
};

// 데이터리스트를 동적으로 생성
// @param <String> id : 동적으로 생성할 데이터리스트의 ID
// @param [{}] obj : 동적으로 생성할 데이터리트스의 컬럼정보. ex) [{id:'', dataType:'text'}]
ecsLib.createDataList = function($p, id, obj) {
	comLib.createData($p, {
		"id": id,
		"type": "dataList",
		"option": {
			"useData": false
		},
		"columnInfo":obj
	});
};

/**
 * @target date formatter
 * @type daLib
 * @since 2018.06.08
 * @author 60003021
 */
function dateFormatter(pdate) {
	if (!pdate) {
		return "";
	}
	var yy = "";
	var mm = "";
	var dd = "";
	var yymmdd;
	pdate = pdate.replace(/[-/]/gi, "");
	yy = pdate.substr(0, 4);
	mm = pdate.substr(4, 2);
	dd = pdate.substr(6, 2);
	var p = ".";

	yymmdd = yy + (mm ? p + mm : "") +(dd ? p + dd : "")
	return yymmdd;
};

/**
 * @target date formatter
 * @type daLib
 * @since 2018.06.08
 * @author 60003021
 */
function dateTimeFormatter(pdate) {
	if (!pdate) {
		return "";
	}
	var yy = "";
	var mm = "";
	var dd = "";
	var yymmdd;
	var ar;
	pdate = pdate.replace(/[-/. :]/gi, "");

	yy = pdate.substr(0, 4);
	mm = pdate.substr(4, 2);
	dd = pdate.substr(6, 2);
	hh = pdate.substr(8, 2) || "12";
	mi = pdate.substr(10, 2) || "00";

	var p = ".";
	if ((typeof flag != "undefined" && flag != "" && flag != null)) {
		p = flag;
	}

	yymmdd = yy + p + mm + p + dd + " " +  hh + ":" +  mi;
	return yymmdd;
};

/* - 표시 */
function dashFormatter(val) {
	if (!val) {
		return "-";
	}
	return val;
};

/* 숫자포맷팅 포함 null일경우 - 표시 */
function numberDashFormatter(val) {
	return WebSquare.util.setNumber(val) || "-";
};

/* 그리드 자동높이 조절 */
ecsLib.setGridAutoHeight = function($p, gridObj, offset) {
	if (!gridObj || typeof gridObj.getID != "function") {
		return;
	}
	var $grid = $("#" + gridObj.getID());
	if (!$grid.is(":visible")) {
		return;
	}

	gridObj.setAttribute("visibleRowNum","");

	$grid.off("gridResize").on("gridResize", function() {
		// console.log("gridResize $grid[0].id:" + $grid[0].id);
		// if (!($p.top().$p.getComponentById($grid[0].id))) {
			// console.log("gridResize off");
		// }
		if (!$grid.is(":visible")) {
			return;
		}
		try {
			// console.log("gridResize $grid[0].id:" + $grid[0].id);

			var conbox = $grid.parents(".content-area,.float-con");
			var gridHeight = $grid.outerHeight(true);
			var addOffset = 0;
			if (!offset) {
				addOffset = parseInt(conbox.css("paddingBottom"));
				var inFooterCont = $grid.parents(".w2tabcontrol_contents, .content-area").first();
				if ($p.$(".footer .btn-group", inFooterCont).is("div")) {
					addOffset = $p.$(".footer .btn-group").outerHeight(true);
				}
				addOffset += 10;
			}
			// $p에 [_wframe_]가 무조건 붙어서 나옴  
			// var bodyid = $p.id.substring(0, $p.id.length - 8);
			var bodyobj = {};
			if ($p.id.length < 8) {
				bodyobj = $("body");
			} else {
				bodyobj = $("#"+$p.id.substring(0, $p.id.length - 8) + "_body");
			}
			if (bodyobj.length > 0) {
				var addHeight = bodyobj.outerHeight(true) - conbox.height() - conbox.offset().top - addOffset;
				gridHeight = gridHeight + addHeight;
				gridObj.setGridHeight(gridHeight);
				var bodyAddHeight = bodyobj.prop("scrollHeight") - bodyobj.outerHeight(true);
				if (bodyAddHeight > 0) {
					gridObj.setGridHeight(gridHeight - bodyAddHeight);
				}
			}
		} catch(e) {}
	});
	$(window).resize(function() {
		// console.log("$(window).resize $grid[0].id:" + $grid[0].id);
		if ($grid.length < 1) {
			$(window).off("resize", arguments.callee);
			return;
		}
		if (!($p.top().$p.getComponentById($grid[0].id))) {
			// console.log("$(window).resize Off $grid[0].id:" + $grid[0].id);
			$(window).off("resize", arguments.callee);
			return;
		}
		$grid.trigger("gridResize");
	});
	$grid.trigger("gridResize");
};

/**
 * [WFM 설비내역 팝업] 설비번호, 기능위치번호로 WFM상세내역을 조회한다.
 */
ecsLib.wfmDetailView = function($p, t_pmEqpNo,t_fnctLcNo) {
	if (t_pmEqpNo != null && t_pmEqpNo != "") {
		var url = comLib.WFM_POP_URL +"/ui/wfm/pm/popup/WFMPMD5000002.xml&EQUNR=" + t_pmEqpNo + "&DIVISIONCD=03&popupID=WFMPM12100001&w2xHome=/ui/&w2xDocumentRoot=";

		// 팝업창 옵션
		var option = {
			popupID : "WFMPMD5000002",
			width : 1300,
			height : 750,
			title : "시설 설비 상세내역"
		};
	} else { // t_fnctLcNo
		var url = comLib.WFM_POP_URL + "/ui/wfm/pm/popup/WFMPMD5000001.xml&TPLNR=" + t_fnctLcNo + "&DIVISIONCD=03&popupID=WFMPM11100001&w2xHome=/ui/&w2xDocumentRoot=";
	}
	// 팝업창 옵션
	var option = {
		popupID : "WFMPMD5000001",
		width : 1300,
		height : 750,
		title : "시설 기능위치 상세내역"
	};
	var strEnc = comLib.dataDecEnc(utilLib.getDate(), "E"); // 암호화 키값
	var usrInfo = JSON.stringify(comLib.getUserInfo4Param(strEnc, encodeURI(option.title))); // 세션정보 및 윈도우 타이틀

	var jsonObj = {
		// 필수값
		userInfo : usrInfo,
		closeCallbackFncName : "",
		popupId : option.popupID
	};

	comLib.openPostWinPopup($p, url, option, jsonObj);
};

/* 페이지 로딩 시작 이벤트 */
ecsLib.initDltAutoConditionObj = {};
ecsLib.initScreen = function($p, formId, arg) {
	/*
	var tabControl = $p.getComponentById($p.$(".w2tabcontrol").attr("id"));
	tabControl.bind("change", function(tabId, idx) {
		if ($p.top().wdcMain) {
			$p.top().scwin.winresize();
		}
	});
	*/
	/* // iframe에서 div로 변경으로  window resize 이벤트가 다중등록및 원할 하지 않아 index.xml로 이관 (팝업일경우 winpopup.jsp,popup.html에서 처리) 
	if ($p.$(".w2grid:visible").length == 1) {
		// 해당 페이지에 그리드가 1개인경우 자동 높이 조절 정의 
		if ($p.$(".w2tabcontrol").is("div")) {
			var grids = $p.$(".w2tabcontrol_container>.w2tabcontrol_contents").eq(0).find(".w2grid:visible");
			if (grids.length == 1) {
				var gridObj = $p.getComponentById($p.$(".w2tabcontrol_container>.w2tabcontrol_contents").eq(0).find(".w2grid").eq(0).attr("id"));
				ecsLib.setGridAutoHeight($p, gridObj);
			}
			var tabControl = $p.getComponentById($p.$(".w2tabcontrol").attr("id"));
			tabControl.bind("change", function(tabId, idx) {
				if ($p.$(".w2tabcontrol_container>.w2tabcontrol_contents").eq(idx).find(".w2grid:visible").length == 1) {
					var gridObj =  $p.getComponentById($p.$(".w2tabcontrol_container>.w2tabcontrol_contents").eq(idx).find(".w2grid").eq(0).attr("id"));
					ecsLib.setGridAutoHeight($p, gridObj);
				}
			});
		} else if ($p.$(".w2grid:visible").length == 1) {
			var gridObj = $p.getComponentById($p.$(".w2grid").eq(0).attr("id"));
			ecsLib.setGridAutoHeight($p, gridObj);
		}
	}
	//토글버튼 클릭시 그리드 리사이즈
	$p.$(".toggle-box .toggle-btn").on("click", function() {
		$p.$(".w2grid:visible").trigger("gridResize");
	});
	*/

	// 20230214 김유빈
	utilLib.scrinChangeSkin(window);
	// 화면 조건 데이터 처리
	if (arg && arg["initScreenCallback"]) {
		var windowId = ($p.main().wdcMain.windows.find(obj => obj.id == $p.getFrame().getID().replaceAll("_wframe", "")) || 0).windowId || formId;
		ecsLib.initDltAutoConditionObj[windowId] = {};
		ecsLib.initDltAutoConditionObj[windowId]["callBack"] = arg["initScreenCallback"];
	}
	ecsLib.setScrinConditionProcess($p, formId, arg);
	setTimeout(() => {
		var frameId = $p.getFrameId().split("_");
		frameId.splice(-1);
		$p.getComponentById(frameId.join("_")).setTitle("");
	}, 200);
};


/**
 * ecsLib.setScrinConditionProcess : 화면 조건 데이터 처리
 */
ecsLib.setScrinConditionProcess = function($p, scrinId, arg) {
	var requestData = {
		"scrinId" : scrinId
	};
	var option = {
		action : "zz/authmng/selectScrinConditionInfo.do",
		reqData : requestData,
		resData : "",
		success : "ecsLib.setScrinConditionProcessCallback",
		//isProcessMsg : false,
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

/**
 * 화면 조건 데이터 처리 콜백
 * @param : resBody : 콜백 데이터
 */
ecsLib.setScrinConditionProcessCallback = function(resBody, $p) {
	var windowId = ($p.main().wdcMain.windows.find(obj => obj.id == $p.getFrame().getID().replaceAll("_wframe", "")) || 0).windowId;
	if (!windowId && $p.isPopup()) {
		windowId = $p.getFrame().getID().replaceAll("_wframe", "").split("_").slice(-1)[0];
	}
	var initDltAutoConditionObj = ecsLib.initDltAutoConditionObj[windowId];
	if (resBody.data && resBody.data.parmVu && resBody.data.parmVu.trim().length > 0) {
		var cdClsList = resBody.data.parmVu.split(",");
		if (initDltAutoConditionObj) {
			initDltAutoConditionObj["callBackCnt"] = cdClsList.length;
		}
		for (var idx = 0; idx < cdClsList.length; idx++) {
			if (cdClsList[idx].startsWith("ECS_")) {
				var requestData = {
					"dmaInqireParam" : {
						"useYn" : "Y",
						"clsCd" : cdClsList[idx]
					}
				};
				var option = {
					action : "zz/cmmncd/retrieveCmmnCd.do",
					reqData : requestData,
					resData : $p.getComponentById("dltAutoCondition" + (idx + 1)),
					success : "ecsLib.initDltAutoConditionCallback",
					//isProcessMsg : false,
					isShowMeg : false
				};
			} else {
				var option = {
					action : cdClsList[idx],
					method : "get",
					resData : $p.getComponentById("dltAutoCondition" + (idx + 1)),
					success : "ecsLib.initDltAutoConditionCallback",
					//isProcessMsg : false,
					isShowMeg : false
				};
			}
			if (cdClsList[idx]) {
				ajaxLib.executeAjax($p, option);
			}
		}
	} else {
		if (initDltAutoConditionObj) {
			initDltAutoConditionObj["callBack"]();
			delete ecsLib.initDltAutoConditionObj[windowId];
		}
	}
};

ecsLib.initDltAutoConditionCallback = function(res, $p) {
	var windowId = ($p.main().wdcMain.windows.find(obj => obj.id == $p.getFrame().getID().replaceAll("_wframe", "")) || 0).windowId;
	if (!windowId && $p.isPopup()) {
		windowId = $p.getFrame().getID().replaceAll("_wframe", "").split("_").slice(-1)[0];
	}
	var initDltAutoConditionObj = ecsLib.initDltAutoConditionObj[windowId];
	if (initDltAutoConditionObj) {
		if (!--initDltAutoConditionObj["callBackCnt"]) {
			initDltAutoConditionObj["callBack"]();
			delete ecsLib.initDltAutoConditionObj[windowId];
		}
	}
};

/**
 * comLib.setBtnAuthProcess : 화면 버튼 권한 처리[팝업]
 * 조회(Q), 저장(S), 삭제(D), 엑셀(E), 출력(P), 승인(A), 승인취소(R), 사용자정의1~9
 */
ecsLib.setPopupBtnAuthProcess = function($p, formId) {
	var requestData = {
		"pgmId" : formId
	};
	var option = {
		action : "zz/authmng/selectPgmAuth.do",
		reqData : requestData,
		resData :"",
		success : "ecsLib.setPopupBtnAuthProcessCallback",
		isShowMeg : false
	};
	ajaxLib.executeAjax($p, option);
};

//사용자 메뉴, 버튼 권한 조회 콜백
ecsLib.setPopupBtnAuthProcessCallback = function(resBody) {
	var btnID;
	var userData;
	var arrData = new Array();
	var btnAthr = resBody.data.btnAthrList;

	if (btnAthr == null) {
		btnAthr = "";
	}

	// 팝업창은 top.wdcMain 이 없음.
	var winObj = this;
	for (var i=0; i< winObj.$(".w2anchor2").children().prevObject.length; i++) {
		btnID = winObj.$(".w2anchor2").children().prevObject[i].id;
			userData = eval("winObj."+btnID).getUserData("userData1");
			if (!utilLib.isNull(userData)) {
				var jsonData = {};
				jsonData.BTN_ID = btnID;
				jsonData.USER_DATA = "," + userData + ",";
				arrData.push(jsonData);
			}
	}

	for (var i = 0; i < arrData.length; i++) {
		if (btnAthr.indexOf(arrData[i].USER_DATA) != -1) {
			// console.log("show btn id = " + arrData[i].BTN_ID);
			winObj.$("#" + arrData[i].BTN_ID).removeClass("hide");
			// console.log ("show" + arrData[i].BTN_ID );
		} else {
			// console.log("hide btn id = " + arrData[i].BTN_ID);
			winObj.$("#" + arrData[i].BTN_ID).addClass("hide");
			// console.log ("hide" + arrData[i].BTN_ID );
		}
	}
};

/**
 * 오아시스 기안처리를 위한 임시변수
 */
ecsLib.GW_approvalNum="";
ecsLib.GW_gianParam={};
ecsLib.GW_atchFile={};
ecsLib.GW_userId="";
ecsLib.GW_Key="";
ecsLib.GW_hostInfo ="";

/**
 * 오아시스 기안처리
 */
ecsLib.runHandyGian = function($p, infofileName ,  approvalNum,  gianParam, atchFile, targetFolder) {
	ecsLib.GW_approvalNum = approvalNum;
	ecsLib.GW_gianParam = gianParam;
	ecsLib.GW_atchFile = atchFile;
	if (atchFile.length > 0) {
		for (var i = 0; i < atchFile.length; i++ ) {
			if (atchFile[i].orgFileName != null) {
				ecsLib.GW_atchFile[i].orginlFileNm = atchFile[i].orgFileName;
			}
			if (atchFile[i].atchfId != null) {
				ecsLib.GW_atchFile[i].atchflId = atchFile[i].atchfId;
			}
		}
	}
	ecsLib.GW_getUserInfo($p, comLib.getUsrEmpno());
};

/**
 * 오아시스 기안처리_사용자정보조회
 */
ecsLib.GW_getUserInfo= function($p, usrId) {
	var strOasisUrl = "toasis.[BASE_DOMAIN]"; // OASIS Url

	if (comLib.ECS_POP_URL.indexOf("https://d") < 0) { // 운영Url ECS_POP_URL=https임
		strOasisUrl = "oasis.[BASE_DOMAIN]";
	}

	$.ajax({
		url : "https://" + strOasisUrl + "/custom/org/session/check_user_session.jsp",
		data : {"empcode" :usrId}, /* 사용자의 사번 */
		dataType : "jsonp",
		jsonpCallback : "callback",
		success : function(data) {
			if (data.USERID) {
				ecsLib.GW_callGianInit($p, data);
			} else {
				comLib.alert($p, "오아시스 로그인정보를 가져오지 못했습니다. 오아시스 로그인상태인지 확인바랍니다..");
			}
		},
		error : function() {alert("error");}
	});	
};

/**
 * 오아시스 기안처리_기안초기화
 */
ecsLib.GW_callGianInit = function($p, data) {
	ecsLib.GW_userId = data.USERID;
	ecsLib.GW_Key = data.KEY;
	ecsLib.GW_hostInfo = data.IPADDR + ":" + data.GPPORT;

	var tmpParam = new Array();
	for (var key in ecsLib.GW_gianParam) {
		tmpParam.push(ecsLib.GW_gianParam[key]) ;
	}
	var requestData = {};
	requestData.GW_gianParam = tmpParam;
	requestData.GW_atchFile = ecsLib.GW_atchFile;
	requestData.file_protocol = window.location.protocol;
	requestData.file_hostName = window.location.host;
	requestData.empNo = comLib.getUsrEmpno();
	var option = {
		action : "zz/sanctn/callGianInit.do",
		reqData : requestData,
		resData : "",
		success : function(resBody) {
			ecsLib.GW_execGian(resBody);
		},
		isShowMeg : false
	};
	ajaxLib.executeAjaxSync($p, option);
};

/**
 * 오아시스 기안처리_기안실행
 */
ecsLib.GW_execGian= function(resBody) {
	var cmdParam = "M " + ecsLib.GW_approvalNum + " " + resBody.data.bodyFileURL
		+ " /UID:" + ecsLib.GW_userId 
		+ " /HOST:" + ecsLib.GW_hostInfo 
		+ " /K:" + ecsLib.GW_Key 
		+ " /ATTACH:" + resBody.data.attFileURL;
	var callParam = ecsLib.MakeCallParam("14", cmdParam, "3");
	document.location.href = "xsclient8://" + callParam; /* 기안기 Custom Protocol */
};

/**
 * 2019.10.10 SJB 추가
 * [전자문서] 결재연동시 사용 - base64 인코딩
 */
ecsLib.MakeCallParam = function(mode, cmdParam, wordType) {
	return "mode:" + Base64.encode(String(mode)) + 
		"&cmdParam:" + Base64.encode(String(cmdParam)) + 
		"&wordType:" + Base64.encode(String(wordType));
};
ecsLib.jsonDstrctHqCdList;
ecsLib.jsonMnggrpCdList;
ecsLib.jsonMngDeptCdList;

/*
팝업창이 많아서 세션으로 변경
ecsLib.jsonDstrctHqCdList;
ecsLib.jsonMnggrpCdList;
ecsLib.jsonMngDeptCdList;
WebSquare.session.setAttribute("dstrctHqCd",dstrctHqCd);
WebSquare.session.setAttribute("mnggrpCd",mnggrpCd);
WebSquare.session.setAttribute("plntNo",plntNo);
*/	
/**
 * 운영통합[수도운영] 기본코드 조회 (권역부서,관리부서 등) 
 * 
 * @param $p 컨트롤 초기화할 화면
 */
ecsLib.Init_dltCdList = function($p) {
	var codeList = "";
	if ($p.getComponentById("dltDstrctHqCdList_s")) {
		if (!(ecsLib.jsonDstrctHqCdList)) {
			codeList += "dstrctHqCd,";
		}
	}
	if ($p.getComponentById("dltMnggrpCdListAll_s")) {
		if (!(ecsLib.jsonMnggrpCdList)) {
			codeList += "mnggrpCd,";
		}
	}
	if ($p.getComponentById("dltMngDeptAll")) {
		if (!(ecsLib.jsonMngDeptCdList)) {
			codeList += "mngDeptCd,";
		}
	}
	if (codeList=="") {
		return;
	}
	var requestData = {};
	requestData.cdList = codeList;
	// 권역 목록 
	var option = {
		action : "pg/cmmn/selectInitCd.do",
		reqData : requestData,
		//resData : ecsLib.dltDstrctHqCdList,
		success : "ecsLib.Init_dltCdListCallBack",
		isShowMeg : false
	};
	ajaxLib.executeAjaxSync($p, option);
};
/**
 * 운영통합[수도운영] 권역부서 코드 조회 콜백 
 */
ecsLib.Init_dltCdListCallBack = function(resBody, $p) {
	if (resBody.data.dstrctHqCdList) {
		ecsLib.jsonDstrctHqCdList = resBody.data.dstrctHqCdList;
	}
	if (resBody.data.mnggrpCdList) {
		ecsLib.jsonMnggrpCdList = resBody.data.mnggrpCdList;
	}
	if (resBody.data.mngDeptCdList) {
		ecsLib.jsonMngDeptCdList = resBody.data.mngDeptCdList;
	}
};
/**
 * 운영통합[수도운영] e수도연보 조회화면 컨트로 초기화  [공통 선택상자등을 초기화 한다(권역,지사,사업장등..] 
 * 
 * @param $p 컨트롤 초기화할 화면
 */
ecsLib.Init_AnlrptView = function($p) {
	ecsLib.Init_dltCdList($p);
	var dltctl = $p.getComponentById("dltDstrctHqCdList_s");
	if (dltctl) {
		dltctl.setJSON(ecsLib.jsonDstrctHqCdList);
	}
	var dltctl2 = $p.getComponentById("dltMnggrpCdListAll_s");
	if (dltctl2) {
		dltctl2.setJSON(ecsLib.jsonMnggrpCdList);
	}
	var dltctl3 = $p.getComponentById("dltMngDeptAll");
	if (dltctl3) {
		dltctl3.setJSON(ecsLib.jsonMngDeptCdList);
	}
	/* 관리부서 코드 리스트 셋팅 끝 */
	var dmaSearch = $p.getComponentById("dmaSearch");
	if (dmaSearch) {
		if (dmaSearch.getKey("dstrctHqCd") != null) {
			dmaSearch.set("dstrctHqCd", ecsLib.getUserInfo($p, "dstrctHqCd")); // 권역
		}
		if (dmaSearch.getKey("plntNo") != null) {
			// 수자원 부서가 있을경우 수자원 부서
			if (ecsLib.getUserInfo($p, "plntNo2")) {
				dmaSearch.set("plntNo", ecsLib.getUserInfo($p, "plntNo2"));
			} else {
				dmaSearch.set("plntNo", ecsLib.getUserInfo($p, "plntNo"));
			}
		}
		if (dmaSearch.getKey("mngDeptCd") != null) {
			dmaSearch.set("mngDeptCd", ecsLib.getUserInfo($p, "mngDeptCd")); // 관리부서
		}
		if (dmaSearch.getKey("stdyy") != null) {
			var tmpdate = new Date();
			var stdyy = tmpdate.getFullYear() - 1;
			dmaSearch.set("stdyy", stdyy); // 기준년
		}
	}
};

/**
 * 운영통합[수도운영] e수도연보 상세화면 컨트로 초기화  및 파라메터 셋팅 [공통 선택상자등을 초기화 한다(권역,지사,사업장등..] 
 * 
 * @param $p 컨트롤 초기화할 화면
 */
ecsLib.Init_AnlrptPopup= function($p) {
	var popscwin = $p.getFrame().getWindow().scwin;
	popscwin.popupParam = comLib.getPopupParam($p, ["athrInfo", "stdyy", "dstrctHqCd", "hqCd", "plntNo", "mngDeptCd",
		"stdrMngYm", "menuId", "menuNm", "menuMngSeq", "menuMngDeptCd", "menuPlntNo", "menuDstrctHqCd", "menuHqCd"
	]);
	if (!(popscwin.popupParam.athrInfo)) {
		popscwin.popupParam.athrInfo = "N";
	}
	var openerTF = false;
	if (opener) {
		try {
			if (opener.ecsLib) {
				openerTF = true;
			}
		} catch(e) {}
	}
	var dltctl = $p.getComponentById("dltDstrctHqCdList_s");
	var dltctl2 = $p.getComponentById("dltMnggrpCdListAll_s");
	var dltctl3 = $p.getComponentById("dltMngDeptAll");
	if (openerTF) {
		// 팝업일경우 팝업별 초기화를 피하기 위해 부모창에 ecsLib를 사용
		opener.ecsLib.Init_dltCdList($p);
		if (dltctl) {
			dltctl.setJSON(opener.ecsLib.jsonDstrctHqCdList);
		}
		if (dltctl2) {
			dltctl2.setJSON(opener.ecsLib.jsonMnggrpCdList);
		}
		if (dltctl3) {
			dltctl3.setJSON(opener.ecsLib.jsonMngDeptCdList);
		}
	} else {
		ecsLib.Init_dltCdList($p);
		if (dltctl) {
			dltctl.setJSON(ecsLib.jsonDstrctHqCdList);
		}
		if (dltctl2) {
			dltctl2.setJSON(ecsLib.jsonMnggrpCdList);
		}
		if (dltctl3) {
			dltctl3.setJSON(ecsLib.jsonMngDeptCdList);
		}
	}
	// ecsLib.Init_dltCdList($p);
	/* 관리부서 코드 리스트 셋팅 끝*/
	var dmaSearch = $p.getComponentById("dmaSearch");
	if (dmaSearch) {
		if (dmaSearch.getKey("dstrctHqCd") != null) {
			dmaSearch.set("dstrctHqCd", popscwin.popupParam.dstrctHqCd); // 1권역
		}
		if (dmaSearch.getKey("plntNo") != null) {
			dmaSearch.set("plntNo", popscwin.popupParam.plntNo); // 관리부서	
		}
		if (dmaSearch.getKey("mngDeptCd") != null) {
			dmaSearch.set("mngDeptCd", popscwin.popupParam.mngDeptCd); // 관리부서
		}
		if (dmaSearch.getKey("stdyy") != null) {
			dmaSearch.set("stdyy", popscwin.popupParam.stdyy); // 기준년
		}
	}
	/* scwin.chrgDeptNmSet 이관 */
	var labelCtrl = $p.getComponentById("chrgDeptNm");
	if (labelCtrl) {
		var dstrctHqNm = "";
		if (dltctl) {
			for (var i = 0; i < dltctl.getRowCount(); i++) {
				if (popscwin.popupParam.dstrctHqCd == dltctl.getCellData(i, "objid")) {
					dstrctHqNm = dltctl.getCellData(i, "stext");
					break;
				}
			}
		}
		if (dltctl2) {
			if (popscwin.popupParam.plntNo == "1000" || popscwin.popupParam.plntNo == "2000" || popscwin.popupParam.plntNo == "3000" || popscwin.popupParam.plntNo == "3002" || popscwin.popupParam.plntNo == "4000") {
				labelCtrl.setValue("(" + dstrctHqNm + ")");
			} else {
				var mngDeptNm = "";
				for(var i = 0; i < dltctl2.getRowCount(); i++) {
					if (popscwin.popupParam.plntNo == dltctl2.getCellData(i, "plant")) {
						mngDeptNm = dltctl2.getCellData(i, "stext");
						break;
					}
				}
				labelCtrl.setValue("(" + dstrctHqNm + " - " + mngDeptNm+")");
			}
		} else if (dltctl3) {
			var mngDeptNm = "";
			for (var i = 0; i < dltctl3.getRowCount(); i++) {
				if (popscwin.popupParam.mngDeptCd == dltctl3.getCellData(i, "objid")) {
					mngDeptNm = dltctl3.getCellData(i , "stext");
					break;
				}
			}
			labelCtrl.setValue("(" + dstrctHqNm + " - " + mngDeptNm + ")");
		} else {
			labelCtrl.setValue("(" + dstrctHqNm + ")");
		}
	}
	// chrgDeptNm
};

/**
 * 운영통합[수도운영] e수도연보 상세화면 조회후 그리드 편집상태 변경  
 * 
 * @param $p 컨트롤 초기화할 화면
 */
ecsLib.AnlrptPopup_searchCallback = function($p) {
	var popscwin = $p.getFrame().getWindow().scwin;
	var dltctl = $p.getComponentById("dataList1");
	var gridctl = $p.getComponentById("gridList1");

	// isEManager 등록된 사용자에 한하여 권한체크 해제
	if (ecsLib.isEManager() === true) {
		for (var i = 0; i < dltctl.getRowCount(); i++) {
			gridctl.setRowBackgroundColor(i, "#FAE0D4");
		}
		return;
	}
	/**
	* 등록 및 수정 권한 체크 
	*/
	var dstrctHqCd = popscwin.popupParam.dstrctHqCd;
	var plntNo = popscwin.popupParam.plntNo;
	if (popscwin.popupParam.athrInfo == "N") {
		if (popscwin.authYn == "Y") {
			if (!(plntNo == "1000" || plntNo == "2000" || plntNo == "3000" || plntNo == "3002" || plntNo == "4000") && (dltctl.getColumnIndex("plntNo") > -1 || dltctl.getColumnIndex("plntCdList") > -1)) {
				if (dltctl.getColumnIndex("plntNo") > -1) {
					for (var i = 0; i < dltctl.getRowCount(); i++) {
						if (dltctl.getCellData(i, "plntNo").indexOf(plntNo) > -1) {
							gridctl.setRowBackgroundColor(i, "#FAE0D4");
						} else {
							gridctl.setRowReadOnly(i, true);
							dltctl.setCellData(i, "chk", "N");
						}
					}
					return;
				}
				if (dltctl.getColumnIndex("plntCdList") > -1) {
					for (var i = 0; i < dltctl.getRowCount(); i++) {
						if (dataList1.getCellData(i, "plntCdList").indexOf(plntNo) > -1) {
							gridctl.setRowBackgroundColor(i, "#FAE0D4");
						} else {
							gridctl.setRowReadOnly(i, true);
							dltctl.setCellData(i, "chk", "N");
						}
					}
					return;
				}
			} else {
				if (dstrctHqCd) {
					for (var i = 0; i < dltctl.getRowCount(); i++) {
						if (dltctl.getCellData(i, "dstrctHqCd") == dstrctHqCd) {
							gridctl.setRowBackgroundColor(i, "#FAE0D4");
						} else {
							gridctl.setRowReadOnly(i, true);
							dltctl.setCellData(i, "chk", "N");
						}
					}
					return;
				}
			}
		}
	}
	for (var i=0; i < dltctl.getRowCount(); i++) {
		gridctl.setRowReadOnly(i , true);
		dltctl.setCellData(i, "chk", "N");
	}
};

/**
 * 운영통합[수도운영] 화면 컨트로 초기화  [공통 선택상자등을 초기화 한다(권역,지사,사업장등..] 
 * 
 * @param $p 컨트롤 초기화할 화면
 */
ecsLib.Init_Common= function($p) {
	var openerTF = false;
	if (opener) {
		try {
			if (opener.ecsLib) {
				openerTF = true;
			}
		} catch(e) {}
	}
	var dltctl = $p.getComponentById("dltDstrctHqCdList_s");
	var dltctl2 = $p.getComponentById("dltMnggrpCdListAll_s");
	var dltctl3 = $p.getComponentById("dltMngDeptAll");
	if (openerTF) {
		// 팝업일경우 팝업별 초기화를 피하기 위해 부모창에 ecsLib를 사용
		opener.ecsLib.Init_dltCdList($p);
		if (dltctl) {
			dltctl.setJSON(opener.ecsLib.jsonDstrctHqCdList);
		}
		if (dltctl2) {
			dltctl2.setJSON(opener.ecsLib.jsonMnggrpCdList);
		}
		if (dltctl3) {
			dltctl3.setJSON(opener.ecsLib.jsonMngDeptCdList);
		}
		// ecsLib.Init_dltCdList($p);
		/* 관리부서 코드 리스트 셋팅 끝*/
		var dmaSearch = $p.getComponentById("dmaSearch");
		if (dmaSearch) {
			if (dmaSearch.getKey("dstrctHqCd") != null) {
				dmaSearch.set("dstrctHqCd", opener.ecsLib.getUserInfo($p, "dstrctHqCd")); // 권역
			}
			if (dmaSearch.getKey("plntNo") != null) {
				// 수자원 부서가 있을경우 수자원 부서
				if (opener.ecsLib.getUserInfo($p, "plntNo2")) {
					dmaSearch.set("plntNo", opener.ecsLib.getUserInfo($p, "plntNo2"));
				} else {
					dmaSearch.set("plntNo", opener.ecsLib.getUserInfo($p, "plntNo"));
				}
			}
			if (dmaSearch.getKey("mngDeptCd") != null) {
				dmaSearch.set("mngDeptCd", opener.ecsLib.getUserInfo($p, "mngDeptCd")); // 관리부서
			}
			if (dmaSearch.getKey("mnggrpCd") != null) {
				dmaSearch.set("mnggrpCd", opener.ecsLib.getUserInfo($p, "mnggrpCd")); // 관리부서
			}
		}
	} else {
		ecsLib.Init_dltCdList($p);
		if (dltctl) {
			dltctl.setJSON(ecsLib.jsonDstrctHqCdList);
		}
		if (dltctl2) {
			dltctl2.setJSON(ecsLib.jsonMnggrpCdList);
		}
		if (dltctl3) {
			dltctl3.setJSON(ecsLib.jsonMngDeptCdList);
		}
		// ecsLib.Init_dltCdList($p);
		/* 관리부서 코드 리스트 셋팅 끝*/
		var dmaSearch = $p.getComponentById("dmaSearch");
		if (dmaSearch) {
			if (dmaSearch.getKey("dstrctHqCd") != null) {
				dmaSearch.set("dstrctHqCd", ecsLib.getUserInfo($p, "dstrctHqCd")); // 권역
			}
			if (dmaSearch.getKey("plntNo") != null) {
				// 수자원 부서가 있을경우 수자원 부서
				if (ecsLib.getUserInfo($p, "plntNo2")) {
					dmaSearch.set("plntNo",ecsLib.getUserInfo($p, "plntNo2"));
				} else {
					dmaSearch.set("plntNo",ecsLib.getUserInfo($p, "plntNo"));
				}
			}
			if (dmaSearch.getKey("mngDeptCd") != null) {
				dmaSearch.set("mngDeptCd", ecsLib.getUserInfo($p, "mngDeptCd")); // 관리부서
			}
			if (dmaSearch.getKey("mnggrpCd") != null) {
				dmaSearch.set("mnggrpCd", ecsLib.getUserInfo($p, "mnggrpCd")); // 관리부서
			}
		}
	}
};

/**
*
*  Base64 encode / decode
*  http://www.webtoolkit.info/
*
**/
var Base64 = {
	// private property
	_keyStr : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
	// public method for encoding
	encode : function (input) {
		var output = "";
		var chr1;
		var chr2;
		var chr3;
		var enc1;
		var enc2;
		var enc3;
		var enc4;
		var i = 0;

		input = Base64._utf8_encode(input);
		while (i < input.length) {
			chr1 = input.charCodeAt(i++);
			chr2 = input.charCodeAt(i++);
			chr3 = input.charCodeAt(i++);

			enc1 = chr1 >> 2;
			enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
			enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
			enc4 = chr3 & 63;

			if (isNaN(chr2)) {
				enc3 = enc4 = 64;
			} else if (isNaN(chr3)) {
				enc4 = 64;
			}

			output = output +
				this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) +
				this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);
		}

		return output;
	},
	// public method for decoding
	decode : function (input) {
		var output = "";
		var chr1;
		var chr2;
		var chr3;
		var enc1;
		var enc2;
		var enc3;
		var enc4;
		var i = 0;
		input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

		while (i < input.length) {
			enc1 = this._keyStr.indexOf(input.charAt(i++));
			enc2 = this._keyStr.indexOf(input.charAt(i++));
			enc3 = this._keyStr.indexOf(input.charAt(i++));
			enc4 = this._keyStr.indexOf(input.charAt(i++));

			chr1 = (enc1 << 2) | (enc2 >> 4);
			chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
			chr3 = ((enc3 & 3) << 6) | enc4;

			output = output + String.fromCharCode(chr1);

			if (enc3 != 64) {
				output = output + String.fromCharCode(chr2);
			}
			if (enc4 != 64) {
				output = output + String.fromCharCode(chr3);
			}
		}
		output = Base64._utf8_decode(output);

		return output;
	},
	// private method for UTF-8 encoding
	_utf8_encode : function (string) {
		string = string.replace(/\r\n/g,"\n");
		var utftext = "";

		for (var n = 0; n < string.length; n++) {
			var c = string.charCodeAt(n);
			if (c < 128) {
				utftext += String.fromCharCode(c);
			} else if((c > 127) && (c < 2048)) {
				utftext += String.fromCharCode((c >> 6) | 192);
				utftext += String.fromCharCode((c & 63) | 128);
			} else {
				utftext += String.fromCharCode((c >> 12) | 224);
				utftext += String.fromCharCode(((c >> 6) & 63) | 128);
				utftext += String.fromCharCode((c & 63) | 128);
			}
		}

		return utftext;
	},
	// private method for UTF-8 decoding
	_utf8_decode : function (utftext) {
		var string = "";
		var i = 0;
		var c = c1 = c2 = 0;

		while (i < utftext.length) {
			c = utftext.charCodeAt(i);
			if (c < 128) {
				string += String.fromCharCode(c);
				i++;
			} else if((c > 191) && (c < 224)) {
				c2 = utftext.charCodeAt(i+1);
				string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
				i += 2;
			} else {
				c2 = utftext.charCodeAt(i + 1);
				c3 = utftext.charCodeAt(i + 2);
				string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
				i += 3;
			}
		}

		return string;
	}
};

/**
 * 차트 리사이즈 옵저버 등록
 * @param : scwin : 화면의 this
 */
ecsLib.setChartResizeObserver = function(scwin) {
	/*
	var resizeObserve = new ResizeObserver(e => {
		if ((typeof scwin.initData == "undefined") || (scwin.initData == null)) {
			scwin.initData = {};
			if ((typeof scwin.initData.observeEvent == "undefined") || (scwin.initData.observeEvent == null)) {
				scwin.initData.observeEvent = false;
			}
		}
		if (!scwin.initData.observeEvent) {
			for (var entry of e) {
				scwin.initData.observeEvent = true;
				//mf_wdcMain_subWindow0
				var selectedTab = document.querySelector(`.w2windowContainer_windowToolbar_top[id$="_toolbar"] div[class$="_selectedNameLayer"][refid=${entry.target.id}]:not([class$="close"])`);
				if (selectedTab) {
					setTimeout(() => {
						entry.target.querySelectorAll(".rMateH5__Root").forEach(emt => {
							emt.resize();
						});
						setTimeout(() => {
							scwin.initData.observeEvent = false;
						}, 750);
					}, 150);
				}
			}
		}
	});
	resizeObserve.observe(document.getElementById(scwin.$w.getFrameId().replace("_wframe", "")));
	*/
	var resizeObserve = new MutationObserver(function(mutations) {
		if ($(mutations[0].target).hasClass("w2window_selected_header")) {
			if ((typeof scwin.initData == "undefined") || (scwin.initData == null)) {
				scwin.initData = {};
				if ((typeof scwin.initData.observeEvent == "undefined") || (scwin.initData.observeEvent == null)) {
					scwin.initData.observeEvent = false;
				}
			}
			ecsLib.chartResizeFunc(scwin);
		}
	});
	resizeObserve.observe(document.getElementById(scwin.$w.getFrameId().replace("_wframe", "_header")), {
		attributes : true,
		attributeFilter : ["class"]
	});
};

ecsLib.chartResizeFunc = function(scwin) {
	if (!scwin.initData.observeEvent) {
		scwin.initData.observeEvent = true;
		var target = document.getElementById(scwin.$w.getFrameId().replace("_wframe", ""));
		var selectedTab = document.querySelector(`.w2windowContainer_windowToolbar_top[id$="_toolbar"] div[class$="_selectedNameLayer"][refid=${target.id}]:not([class$="close"])`);
		if (selectedTab) {
			setTimeout(() => {
				target.querySelectorAll(".rMateH5__Root").forEach(emt => {
					emt.resize();
				});
				setTimeout(() => {
					scwin.initData.observeEvent = false;
				}, 750);
			}, 150);
		}
	}
};

/**
 * 클릭시 메뉴 이동 이벤트
 * @param : {
 * 	targetSelector : 이벤트를 등록할 요소들의 선택자,
 * 	classStartsWith : 이벤트가 등록된 요소들중 해당 변수 값으로 시작하는 클랙스명을 가진 요소들,
 * 	targetParentMenuIdObj : 메뉴ID를 키로 가지고 메뉴 목록을 오픈할 최상위 메뉴ID를 값으로 가지는 오브젝트(타입이 스트링이면 단일),
 * 	targetMenuIdObj : 이동할 대상 클래스명의 끝을 키로 가지고 이동할 메뉴ID를 값으로 가지는 오브젝트
 *  param : 이동할 화면에 전달할 파라미터 값
 *  exceptionSelector : 이벤트를 제외할 요소들의 선택자의 집합
 *  onOffFunc : 이동 on/off 함수(true, false 리턴)
 * }
 */
ecsLib.setMenuClickEvent = function(targetSelector, classStartsWith, targetParentMenuIdObj, targetMenuIdObj, sendParam, exceptionSelector, onOffFunc) {
	document.querySelectorAll(targetSelector).forEach(emt => {
		var clickFn = function(e) {
			if (onOffFunc != "" && onOffFunc != null && typeof onOffFunc != "undefined" && typeof onOffFunc == "function") {
				if(!onOffFunc()) {
					return;
				}
			}
			var target = e.target;
			if (exceptionSelector) {
				for (exception of exceptionSelector) {
					var exceptionEmt = [...document.querySelectorAll(exception)].find(emt => emt == e.target);
					if (exceptionEmt) {
						return;
					}
				}
			}
			while (!target.classList.toString().includes(classStartsWith) && target.tagName != "BODY") {
				target = target.parentElement;
			}
			target.classList.forEach(className => {
				if (className.startsWith(classStartsWith)) {
					var targetMenuId = "";
					for (var key of Object.keys(targetMenuIdObj)) {
						if (className.endsWith(key)) {
							targetMenuId = targetMenuIdObj[key];
							sendParam["targetKey"] = key;
							break;
						}
					}
					if (targetMenuId) {
						// 메뉴항목 open
						var trvMenuComp = $p.getComponentById("wfm_left").getWindow().trvMenu;
						trvMenuComp.spanAll(false);
						var openMenuDepth = function(targetParentMenuIdObjParam, targetMenuIdParam, isSpanAll) {
							if (typeof targetParentMenuIdObjParam == "string") {
								var rootMenu = document.querySelector(`.tw_menu table[treenodevalue="${targetParentMenuIdObjParam}"]`);
								var value = targetParentMenuIdObjParam;
							} else {
								var rootMenu = document.querySelector(".tw_menu table[treenodevalue='" + targetParentMenuIdObjParam[targetMenuIdParam] + "']");
								var value = targetParentMenuIdObjParam[targetMenuIdParam];
							}
							if (rootMenu && rootMenu.classList.contains("w2treeview_close_child")) {
								var trvMenuXml = trvMenuComp.getAllXML();
								var nodeElement = [...trvMenuXml.querySelectorAll("map menuId")].find(emt => emt.textContent == value).parentElement;
								var index = String(Number(nodeElement.getAttribute("index")) + 1);
								if (isSpanAll) { 
									trvMenuComp.spanAll(false);
								}
								trvMenuComp.spanNode(index, true, false);
								/*
								setTimeout(() => {
									$p.getComponentById("wfm_left").getWindow().scwin.trvMenu_onclick(value, nodeElement, index);
									rootMenu.querySelector(".w2treeview_row_depth1 .w2treeview_label").click();
								}, 200);
								*/
							}
							var child;
							if (typeof targetParentMenuIdObjParam == "string") {
								child = document.querySelector(`.tw_menu table[treenodevalue="${targetParentMenuIdObjParam}"] div.w2treeview_child`)
							} else {
								child = document.querySelector(`.tw_menu table[treenodevalue="${targetParentMenuIdObjParam[targetMenuIdParam]}"] div.w2treeview_child`)
							}
							if (!child) {
								return;
							}
							for (var i = 0; i < child.childElementCount; i++) {
								var label = child.querySelector(`div[index="${i}"] .w2treeview_label`);
								if (label) {
									label.classList.add("none-childlo");
								}
							}
							$(".w2treeview_label").removeClass("w2treeview_select_node");
						};
						var targetMenuCheck = function() {
							return [...document.querySelectorAll(".tw_menu table[treenodevalue]")].find(emt => emt.attributes.treenodevalue.value == targetMenuId);
						};
						openMenuDepth(targetParentMenuIdObj, targetMenuId, true);
						// 하위 메뉴항목 확인
						var targetMenu = document.querySelector(`.tw_menu table[treenodevalue="${targetMenuId}"] .w2treeview_label`);
						if (!targetMenu || targetMenuCheck()) {
							var targetMenuIdPrefix = targetMenuId.substr(0, 5);
							var targetMenuIdSuffix = targetMenuId.substr(5);
							var menuIdLength = targetMenuIdSuffix.length;
							for (var idx = 1; idx < menuIdLength; idx++) {
								var suffixArr = [...targetMenuIdSuffix];
								suffixArr[idx] = "0";
								openMenuDepth(targetMenuIdPrefix + suffixArr.join(""), targetMenuId);
								targetMenu = document.querySelector(`.tw_menu table[treenodevalue="${targetMenuId}"] .w2treeview_label`);
								if (targetMenu) {
									break;
								}
							}
						}
						targetMenu.classList.add("w2treeview_select_node");
						var directory = "/ui/ecs/" + targetMenuId.substr(3, 2).toLowerCase() + "/";

						var dataObj = {
							"type" : "json",
							"name" : "param",
							"data" : sendParam
						};

						var existWindow = false;
						for (var i = 0; i < $p.top().wdcMain.currentWindowNum; i++) {
							if ($p.top().wdcMain.getWindowByWindowId(targetMenuId + "0") != null) {
								existWindow = true;
								break;
							}
						}
						// 메뉴이동
						if (existWindow) {
							//$p.top().wdcMain.getWindowByWindowId(targetMenuId + "0", true);
							comLib.createWindow(targetMenu.innerText, null, directory + targetMenuId + "0.xml", targetMenu.innerText, targetMenuId + "0", "existWindow", null, null, null, null, "wframe", dataObj);
						} else {
							comLib.createWindow(targetMenu.innerText, null, directory + targetMenuId + "0.xml", targetMenu.innerText, targetMenuId + "0", "existWindow", null, null, null, null, "wframe", dataObj);
						}
						/*
						var targetTab = document.querySelector(`.w2windowContainer_nameLayer[windowtitle="${targetMenu.innerText}"]`);
						if (targetTab) {
							setTimeout(() => {
								targetMenu.click();
							}, 100);
						} else {
							targetMenu.click();
						}
						*/
						return;
					}
				}
			});
		};
		emt.removeEventListener("click", ecsLib.setMenuClickEventObj[emt.classList.toString()]);
		emt.addEventListener("click", clickFn);
		ecsLib.setMenuClickEventObj[emt.classList.toString()] = clickFn;
	});
};
ecsLib.setMenuClickEventObj = {};

/**
 * 차트 메뉴(아이템) 클릭시 메뉴 이동 이벤트
 * @param : {
 * 	targetParentMenuId : 메뉴 목록을 오픈할 최상위 메뉴ID를 값으로 가지는 스트링
 * 	targetMenuId : 이동할 메뉴ID를 값으로 가지는 스트링
 *  param : 이동할 화면에 전달할 파라미터 값
 * }
 */
ecsLib.chartMenuClickEvent = function(targetParentMenuId, targetMenuId, param) {
	if (targetMenuId) {
		// 메뉴항목 open
		var trvMenuComp = $p.getComponentById("wfm_left").getWindow().trvMenu;
		trvMenuComp.spanAll(false);
		var openMenuDepth = function(targetParentMenuId, targetMenuIdParam, isSpanAll) {
			if (typeof targetParentMenuId == "string") {
				var rootMenu = document.querySelector(`.tw_menu table[treenodevalue="${targetParentMenuId}"]`);
				var value = targetParentMenuId;
			}
			if (rootMenu && rootMenu.classList.contains("w2treeview_close_child")) {
				var trvMenuXml = trvMenuComp.getAllXML();
				var nodeElement = [...trvMenuXml.querySelectorAll("map menuId")].find(emt => emt.textContent == value).parentElement;
				var index = String(Number(nodeElement.getAttribute("index")) + 1);
				if (isSpanAll) { 
					trvMenuComp.spanAll(false);
				}
				trvMenuComp.spanNode(index, true, false);
			}
			var child;
			if (typeof targetParentMenuId == "string") {
				child = document.querySelector(`.tw_menu table[treenodevalue="${targetParentMenuId}"] div.w2treeview_child`)
			} else {
				child = document.querySelector(`.tw_menu table[treenodevalue="${targetParentMenuId[targetMenuId]}"] div.w2treeview_child`)
			}
			if (!child) {
				return;
			}
			for (var i = 0; i < child.childElementCount; i++) {
				var label = child.querySelector(`div[index="${i}"] .w2treeview_label`);
				if (label) {
					label.classList.add("none-childlo");
				}
			}
			$(".w2treeview_label").removeClass("w2treeview_select_node");
		};
		var targetMenuCheck = function() {
			return [...document.querySelectorAll(".tw_menu table[treenodevalue]")].find(emt => emt.attributes.treenodevalue.value == targetMenuId);
		};
		openMenuDepth(targetParentMenuId, targetMenuId, true);
		// 하위 메뉴항목 확인
		var targetMenu = document.querySelector(`.tw_menu table[treenodevalue="${targetMenuId}"] .w2treeview_label`);
		if (!targetMenu || targetMenuCheck()) {
			var targetMenuIdPrefix = targetMenuId.substr(0, 5);
			var targetMenuIdSuffix = targetMenuId.substr(5);
			var menuIdLength = targetMenuIdSuffix.length;
			for (var idx = 1; idx < menuIdLength; idx++) {
				var suffixArr = [...targetMenuIdSuffix];
				suffixArr[idx] = "0";
				openMenuDepth(targetMenuIdPrefix + suffixArr.join(""), targetMenuId);
				targetMenu = document.querySelector(`.tw_menu table[treenodevalue="${targetMenuId}"] .w2treeview_label`);
				if (targetMenu) {
					break;
				}
			}
		}
		targetMenu.classList.add("w2treeview_select_node");
		var directory = "/ui/ecs/" + targetMenuId.substr(3, 2).toLowerCase() + "/";

		var dataObj = {
			"type" : "json",
			"name" : "param",
			"data" : param
		};

		var existWindow = false;
		for (var i = 0; i < $p.top().wdcMain.currentWindowNum; i++) {
			if ($p.top().wdcMain.getWindowByWindowId(targetMenuId + "0") != null) {
				existWindow = true;
				break;
			}
		}
		// 메뉴이동
		if (existWindow) {
			//$p.top().wdcMain.getWindowByWindowId(targetMenuId + "0", true);
			comLib.createWindow(targetMenu.innerText, null, directory + targetMenuId + "0.xml", targetMenu.innerText, targetMenuId + "0", "existWindow", null, null, null, null, "wframe", dataObj);
		} else {
			comLib.createWindow(targetMenu.innerText, null, directory + targetMenuId + "0.xml", targetMenu.innerText, targetMenuId + "0", "existWindow", null, null, null, null, "wframe", dataObj);
		}
		/*
		var targetTab = document.querySelector(`.w2windowContainer_nameLayer[windowtitle="${targetMenu.innerText}"]`);
		if (targetTab) {
			setTimeout(() => {
				targetMenu.click();
			}, 100);
		} else {
			targetMenu.click();
		}
		*/
		return;
	}
};

/**
 * 문자열의 Byte를 계산한다.(한글3Byte)
 * 
 * @date 2023. 08. 01.
 * @param <String> str 텍스트
 * @example 
 * ecsLib.get3ByteLength("테스트1");
 */
ecsLib.get3ByteLength = function(str) {
	/*
	var strLength = 0;
	for (var idx = 0; idx < str.length; idx++) {
		if (escape(str.charAt(idx)).length >= 4) {
			strLength += 3;
		} else if (escape(str.charAt(idx)) == "%A7") {
			strLength += 3;
		} else {
			if (escape(str.charAt(idx)) != "%0D") {
				strLength++;
			}
		}
	}
	return strLength;
	*/
	if (typeof str != "string") {
		str = String(str);
	}
	var byte;
	var idx;
	var char;
	for (byte = idx = 0; char = str.charCodeAt(idx++); byte += char >> 11 ? 3 : char >> 7 ? 2 : 1);
	return byte;
};

/**
 * 날짜 파싱(String => Date)
 * @param date : 날짜
 * @param format : 날짜 포맷
 * @return 날짜 포맷
 */
ecsLib.parseDate = function(date, format) {
	if (!date || date == "" || date == null || typeof date == "undefined") {
		date = new Date();
	} else if (typeof date == "string") {
		if (date.indexOf("-") < 0 && date.indexOf(".") < 0) {
			var dateFormat = "";
			var yLength = format.split("y").length - 1;
			var MLength = format.split("M").length - 1;
			var dLength = format.split("d").length - 1;
			var HLength = format.split("H").length - 1;
			var hLength = format.split("h").length - 1;
			var mLength = format.split("m").length - 1;
			var sLength = format.split("s").length - 1;

			if (yLength > 0) {
				dateFormat += date.substr(format.indexOf("y"), yLength);
			} else {
				dateFormat += new Date().getFullYear();
			}
			if (MLength > 0 && date.length >= yLength) {
				dateFormat += "-" + date.substr(format.indexOf("M"), MLength);
			} else {
				dateFormat += "-" + (new Date().getMonth() + 1);
			}
			if (dLength > 0 && date.length >= MLength) {
				dateFormat += "-" + date.substr(format.indexOf("d"), dLength);
			} else {
				dateFormat += "-" + new Date().getDate();
			}
			date_ = new Date(dateFormat);

			if (HLength > 0 || hLength > 0) {
				date_.setHours(HLength > 0 ? date.substr(format.indexOf("H"), HLength) : date.substr(format.indexOf("h"), hLength));
			}
			if (mLength > 0) {
				date_.setMinutes(date.substr(format.indexOf("m"), mLength));
			}
			if (sLength > 0) {
				date_.setSeconds(date.substr(format.indexOf("s"), sLength));
			}
			date = date_;
		} else {
			var reg = /["가-힣"]/;
			if (reg.test(date)) {
				date = date.replace("시", ":").replace("분", ":").replace("초", ":");
				date.substr(0, date.lastIndex(":"));
			}
			date = new Date(date);
		}
	} else if (typeof date == "number") {
		date = new Date(date);
	} else if (typeof date == "object") {
		return date;
	} else {
		return null;
	}
	return date;
};

/**
 * 날짜 포맷 파싱(Date => String)
 * @param date : 날짜
 * @param format : 날짜 포맷
 * @param option : 옵션(0:String, 그외:Object)
 * @return 날짜 포맷
 */
ecsLib.parseDateFormat = function(date, format, option) {
	date = this.parseDate(date, format);
	if (!date) {
		return null;
	}
	if (!format) {
		return null;
	}
	if (!option) {
		option = 0;
	}

	var result;
	if (option == 0) {
		result = format;
	} else {
		result = {};
	}
	if (format.includes("yyyy")) {
		var year = date.getFullYear();
		if (option == 0) {
			result = result.replace("yyyy", year);
		} else {
			result.year = year;
		}
	} else if (format.includes("yy")) {
		var year = String(date.getFullYear()).substr(-2);
		if (option == 0) {
			result = result.replace("yyyy", year);
		} else {
			result.year = year;
		}
	}

	if (format.includes("MM")) {
		var month = date.getMonth() + 1;
		month = (month >= 10 ? month : "0" + month);
		if (option == 0) {
			result = result.replace("MM", month);
		} else {
			result.month = month;
		}
	} else if (format.includes("M")) {
		var month = (date.getMonth() + 1);
		if (option == 0) {
			result = result.replace("M", month);
		} else {
			result.month = month;
		}
	}

	if (format.includes("day")) {
		var weekday = date.getDay();
		if (option == 0) {
			result = result.replace("day", commonSettings["weekDay"][weekday]) + "요일";
		} else {
			result.weekday = commonSettings["weekDay"][weekday] + "요일";
		}
	} else if (format.includes("dy")) {
		var weekday = date.getDay();
		if (option == 0) {
			result = result.replace("dy", commonSettings["weekDay"][weekday]);
		} else {
			result.weekday = commonSettings["weekDay"][weekday];
		}
	}

	if (format.includes("dd")) {
		var day = date.getDate();
		day = (day >= 10 ? day : "0" + day);
		if (option == 0) {
			result = result.replace("dd", day);
		} else {
			result.day = day;
		}
	} else if (format.includes("d")) {
		var day = date.getDate();
		if (option == 0) {
			result = result.replace("d", day);
		} else {
			result.day = day;
		}
	}

	if (format.includes("HH")) {
		var hour = date.getHours();
		hour = hour >= 10 ? hour : "0" + hour;
		if (option == 0) {
			result = result.replace("HH", hour);
		} else {
			result.hour = hour;
		}
	} else if (format.includes("H")) {
		var hour = date.getHours();
		if (option == 0) {
			result = result.replace("H", hour);
		} else {
			result.hour = hour;
		}
	} else if (format.includes("hh")) {
		var hour = date.getHours();
		var ampm = hour >= 12 ? "P.M " : "A.M ";
		hour = hour % 12;
		hour = hour ? hour : 12;
		hour = hour >= 10 ? hour : "0" + hour;
		if (option == 0) {
			result = result.replace("hh", ampm + hour);
		} else {
			result.ampm = ampm;
			result.hour = hour;
		}
	} else if (format.includes("h")) {
		var hour = date.getHours();
		var ampm = hour >= 12 ? "P.M " : "A.M ";
		hour = hour % 12;
		hour = hour ? hour : 12;
		if (option == 0) {
			result = result.replace("h", ampm + hour);
		} else {
			result.ampm = ampm;
			result.hour = hour;
		}
	}

	if (format.includes("mm")) {
		var minute = date.getMinutes();
		minute = minute >= 10 ? minute : "0" + minute;
		if (option == 0) {
			result = result.replace("mm", minute);
		} else {
			result.minute = minute;
		}
	} else if (format.includes("m")) {
		var month = (date.getMonth() + 1);
		if (option == 0) {
			result = result.replace("m", minute);
		} else {
			result.minute = minute;
		}
	}

	if (format.includes("ss")) {
		var second = date.getSeconds();
		second = second >= 10 ? second : "0" + second;
		if (option == 0) {
			result = result.replace("ss", second);
		} else {
			result.second = second;
		}
	} else if (format.includes("s")) {
		var second = date.getSeconds();
		if (option == 0) {
			result = result.replace("s", second);
		} else {
			result.second = second;
		}
	}

	return result;
};

ecsLib.setDefaultDate = function(diff) {
	var defaultDate = ecsLib.parseDate($p.getCurrentServerDate("yyyyMMdd"), "yyyyMMdd");
	if (diff) {
		defaultDate.setDate(defaultDate.getDate() + diff);
		return ecsLib.parseDateFormat(defaultDate, "yyyyMMdd");
	} else {
		return ecsLib.parseDateFormat(defaultDate, "yyyyMMdd");
	}
};
/**
 * 천단위 컴마 추가
 * @param value : 값
 * @return 변경된 값
 */
ecsLib.numCommaFrmt = function(num, digits) {
	return new Intl.NumberFormat("ko-kr", {
			"minimumFractionDigits" : digits != 0 && !digits ? 0 : digits
		}).format(num || 0);
};

/**
 * 소수점 버림
 * @param value : 값
 * @return 변경된 값
 */
ecsLib.numPointFrmt = function(num, digits) {
	if (digits == 0) {
		var result = Number(Math.round(num) || 0).toFixed(digits != 0 && !digits ? 2 : digits);
	} else {
		var result = Number(num || 0).toFixed(digits != 0 && !digits ? 2 : digits);
	}
	return result;
};

/**
 * 화면 표시 포맷(0을 -로 표시) => 합계 때문에 0으로 표시 필요
 * @param num : 값
 * @return 변경된 값
 */
ecsLib.dsplFrmt = function(num, digits) {
	if (typeof num == "string") {
		var tmpNum = num;
		var numReg = /[0-9]/g;
		var notNumReg = /[^0-9|^\.|^,]/g;
		var lastStr = num.split(numReg).slice(-1);
		var isNegative = num.charAt(0) == "-" ? true : false;
		num = Number(num.replaceAll(notNumReg, ""));
		if (!num) {
			num = Number(tmpNum.replaceAll(",", ""));
		}
		if (isNegative) {
			num *= -1;
		}
	}

	if (!num || num === 0) {
		return "-";
	} else if (!Number(num)) {
		return "-";
	} else if (num < 1 && num > -1) {
		return lastStr ? ecsLib.numPointFrmt(num, digits != 0 && !digits ? 2 : digits) + lastStr
			: ecsLib.numPointFrmt(num, digits != 0 && !digits ? 2 : digits);
	} else {
		if (digits == 0 || digits) {
			return lastStr ? ecsLib.numCommaFrmt(ecsLib.numPointFrmt(num, digits != 0 && !digits ? 2 : digits), digits != 0 && !digits ? 2 : digits) + lastStr
				: ecsLib.numCommaFrmt(ecsLib.numPointFrmt(num, digits != 0 && !digits ? 2 : digits), digits != 0 && !digits ? 2 : digits);
		} else {
			return lastStr ? ecsLib.numCommaFrmt(num) + lastStr
				: ecsLib.numCommaFrmt(num);
		}
	}
};

/**
 * 화면 표시 0 포맷(0을 0로 표시)
 * @param num : 값
 * @return 변경된 값
 */
ecsLib.dsplZeroFrmt = function(num, digits) {
	if (typeof num == "string") {
		var tmpNum = num;
		var numReg = /[0-9]/g;
		var notNumReg = /[^0-9|^\.|^,]/g;
		var lastStr = num.split(numReg).slice(-1);
		var isNegative = num.charAt(0) == "-" ? true : false;
		num = Number(num.replaceAll(notNumReg, ""));
		if (num != 0 && !num) {
			num = Number(tmpNum.replaceAll(",", ""));
		}
		if (isNegative) {
			num *= -1;
		}
	}

	if (!num && num != 0) {
		return "-";
	} else if (!num && num === "") {
		return "";
	} else if (!Number(num) && Number(num) != 0) {
		return "-";
	} else if (num < 1 && num > -1) {
		return lastStr ? ecsLib.numPointFrmt(num, digits != 0 && !digits ? 0 : digits) + lastStr
			: ecsLib.numPointFrmt(num, digits != 0 && !digits ? 0 : digits);
	} else {
		if (digits == 0 || digits) {
			return lastStr ? ecsLib.numCommaFrmt(ecsLib.numPointFrmt(num, digits != 0 && !digits ? 0 : digits), digits != 0 && !digits ? 0 : digits) + lastStr
				: ecsLib.numCommaFrmt(ecsLib.numPointFrmt(num, digits != 0 && !digits ? 0 : digits), digits != 0 && !digits ? 0 : digits);
		} else {
			return lastStr ? ecsLib.numCommaFrmt(num) + lastStr
				: ecsLib.numCommaFrmt(num);
		}
	}
};

/**
 * input 데이터 Validation
 * - input 데이터 Validation 후 comLib.alert 창으로 maxMessage 크기 만큼 출력하고
 * - input color 가 red로 바뀌고 backgroundColor 가 범례에 따라 바뀜
 *
 * @param inputGroup
 * @param valInfo : mandatory, maxLength, minLength, number, alpha, alphanumber, isHangul,
 * @param isInit : 배경, 폰트 색상 초기화만 할 건지 여부
 * @return true(valid), false(invalid)
 * @example var valInfo = [
	{id : "col1", mandatory : true, maxLength : 5, minLength : 3, isHangul : false},
	{id : "col2", mandatory : true, maxLength : 5, isHangul : false},
	{id : "col3", number : true},
	{id : "col4", code : "ldt_code_ACOCLCD"}
	];
	utilLib.validateInput(inputGroup, valInfo, true);
 */
ecsLib.validateInput = function(inputGroup, valInfo, isInit, isShowMsg) {
	var maxMessage = 50;
	var arrData = [];
	var groupId = inputGroup.getID();
	var frame = inputGroup.getScopeWindow();
	var textColor = "red";
	isShowMsg = (isShowMsg == undefined || isShowMsg == null) ? true : false;

	for (var valInfoObj of valInfo) {
		var inputEmt = document.querySelector(`#${groupId} [id$="${valInfoObj.id}"]`);
		if (!inputEmt) {
			var valInfoObjId = valInfoObj.id;
			valInfoObjId = valInfoObjId.charAt(0).toUpperCase() + valInfoObjId.slice(1);
			inputEmt = document.querySelector(`#${groupId} [id$="${valInfoObjId}"]`);
			if (!inputEmt) {
				continue;
			}
		}
		var inputComp = frame.$p.getComponentById(inputEmt.id);
		// 색상 초기화
		inputComp.setStyle("color", "");
		inputComp.setStyle("background-color", "");
		if (isInit) {
			continue;
		}
		// 값
		var value = inputComp.getValue();
		// 타이틀
		var target = "";

		var parent = inputComp.parentControl;
		if (parent) {
			target = parent.getAttributeNode("data-title");
		} else {
			var childCompIdList = Object.keys(frame);
			var dltIdList = childCompIdList.filter(id => id.startsWith("dlt"));
		}
		if (!target) {
			target = valInfoObj.name;
		}
		// 필수
		if ((typeof valInfoObj.mandatory != "undefined") && (valInfoObj.mandatory == true) && (value.length == 0)) {
			inputComp.setStyle("color", textColor);
			inputComp.setStyle("background-color", utilLib.INVALID_COLOR_MANDATORY);
			if (arrData.length < maxMessage) {
				arrData.push(utilLib.getMessage("SCM.INFO.00004", target)[0]);
			} else {
				continue;
			}
		// 최대길이
		} else if ((typeof valInfoObj.maxLength != "undefined") && (typeof valInfoObj.maxLength == "number") && (value.length > valInfoObj.maxLength)) {
			inputComp.setStyle("color", textColor);
			inputComp.setStyle("background-color", utilLib.INVALID_COLOR_MAXLENGTH);
			if (arrData.length < maxMessage) {
				arrData.push(utilLib.getMessage("SCM.INFO.00006", target, valInfoObj.maxLength)[0]);
			} else {
				continue;
			}
		// 최대길이
		} else if ((typeof valInfoObj.maxByteLength != "undefined") && (typeof valInfoObj.maxByteLength == "number") && (ecsLib.get3ByteLength(value) > valInfoObj.maxByteLength)) {
			inputComp.setStyle("color", textColor);
			inputComp.setStyle("background-color", utilLib.INVALID_COLOR_MAXLENGTH);
			if (arrData.length < maxMessage) {
				arrData.push(utilLib.getMessage("SCM.INFO.00006", target, valInfoObj.maxByteLength + "Byte 글")[0]);
			} else {
				continue;
			}
		// 최소길이
		} else if ((typeof valInfoObj.minLength != "undefined") && (typeof valInfoObj.minLength == "number") && (value.length < valInfoObj.minLength)) {
			inputComp.setStyle("color", textColor);
			inputComp.setStyle("background-color", utilLib.INVALID_COLOR_MINLENGTH);
			if (arrData.length < maxMessage) {
				arrData.push(utilLib.getMessage("SCM.INFO.00005", target, valInfoObj.minLength)[0]);
			} else {
				continue;
			}
		// 숫자만 허용
		} else if ((typeof valInfoObj.number != "undefined") && valInfoObj.number == true && !utilLib.isNumberOld(value)) {
			inputComp.setStyle("color", textColor);
			inputComp.setStyle("background-color", utilLib.INVALID_COLOR_NUMBER);
			if (arrData.length < maxMessage) {
				arrData.push(utilLib.getMessage("SCM.INFO.00010", target)[0]);
			} else {
				continue;
			}
		// 알파벳만 허용
		} else if ((typeof valInfoObj.alpha != "undefined") && valInfoObj.alpha == true && !utilLib.isAlpha(value)) {
			inputComp.setStyle("color", textColor);
			inputComp.setStyle("background-color", utilLib.INVALID_COLOR_ALPHANUMBER);
			if (arrData.length <= maxMessage) {
				arrData.push(utilLib.getMessage("SCM.INFO.00337")[0]);
			} else {
				continue;
			}
		// 알파벳, 숫자만 허용
		} else if ((typeof valInfoObj.alphanumber != "undefined") && valInfoObj.alphanumber == true && (!utilLib.isAlphaNumber(value))) {
			inputComp.setStyle("color", textColor);
			inputComp.setStyle("background-color", utilLib.INVALID_COLOR_ALPHANUMBER);
			if (arrData.length <= maxMessage) {
				arrData.push(utilLib.getMessage("SCM.INFO.00338", target)[0]);
			} else {
				continue;
			}
		// 한글만 허용
		} else if ((typeof valInfoObj.isHangul != "undefined") && valInfoObj.isHangul == true && (!utilLib.isKoreanWord(value))) {
			inputComp.setStyle("color", textColor);
			inputComp.setStyle("background-color", utilLib.INVALID_COLOR_HANGUL);
			if (arrData.length <= maxMessage) {
				arrData.push(utilLib.getMessage("SCM.INFO.00019", target)[0]);
			} else {
				continue;
			}
		// 공통코드 체크
		} else if ((typeof valInfoObj.code != "undefined" && eval(valInfoObj.code).getMatchedData("cdDvsId",value).length == 0)) {
			inputComp.setStyle("color", textColor);
			inputComp.setStyle("background-color", utilLib.INVALID_COLOR_CODE);
			if (arrData.length <= maxMessage) {
				arrData.push(utilLib.getMessage("WCOM0070", target)[0]);
			} else {
				continue;
			}
		}
	}

	if (!utilLib.isNull(arrData)) {
		if (isShowMsg) {
			var message = "";
			for (var i = 0; i < arrData.length; i++) {
				message += arrData[i] + "<br/>";
			}
			comLib.messageBox(frame.$p, "alert", message, "", false, "Data Validation");
		}
		return false;
	}

	return true;
};

/**
 * 모달창이 열려있는지 확인한다.
 * 
 * @returns boolean
 */
ecsLib.isOpenPopup = function() {
	var popupEmt = document.querySelector("div.w2window.w2popup_window[id^='alert']");
	if (popupEmt) {
		return true;
	} else {
		return false;
	}
};

/**
 * 사용자 정의 년 유효성 검사(validator)를 수행하고 실패시 값을 초기화하고 메시지를 출력한다.
 * 
 * @returns 값
 */
ecsLib.validatorYear = function(val, inputBoxId, isPopup) {
	isPopup = isPopup == undefined || isPopup == null || isPopup == "Y" ? true : false;
	if (!ecsLib.isOpenPopup() && !ecsLib.isOpenedPopup) {
		ecsLib.isOpenedPopup = true;
		if (!val) {
			val = "";
		} else if (!utilLib.isDate(val, 4)) {
			val = "";
			var msg = "날짜를 년도(4글자) 형식으로 입력해야 합니다.";
			if (isPopup) {
				comLib.alert($p, msg);
			} else {
				val = msg;
			}
		} else {
			if (!isPopup) {
				val = "";
			}
		}
	}
	ecsLib.isOpenedPopup = false;
	return val;
};

/**
 * 사용자 정의 년월 유효성 검사(validator)를 수행하고 실패시 값을 초기화하고 메시지를 출력한다.
 * 
 * @returns 값
 */
ecsLib.validatorYearMonth = function(val, inputBoxId, isPopup) {
	isPopup = isPopup == undefined || isPopup == null || isPopup == "Y" ? true : false;
	if (!ecsLib.isOpenPopup() && !ecsLib.isOpenedPopup) {
		ecsLib.isOpenedPopup = true;
		if (!val) {
			val = "";
		} else if (!utilLib.isDate(val, 6)) {
			val = "";
			var msg = "날짜를 년월(6글자) 형식으로 입력해야 합니다.";
			if (isPopup) {
				comLib.alert($p, msg);
			} else {
				val = msg;
			}
		} else {
			if (!isPopup) {
				val = "";
			}
		}
	}
	ecsLib.isOpenedPopup = false;
	return val;
};

/**
 * 사용자 정의 년월일 유효성 검사(validator)를 수행하고 실패시 값을 초기화하고 메시지를 출력한다.
 * 
 * @returns 값
 */
ecsLib.validatorYearMonthDate = function(val, inputBoxId, isPopup) {
	isPopup = isPopup == undefined || isPopup == null || isPopup == "Y" ? true : false;
	if (!ecsLib.isOpenPopup() && !ecsLib.isOpenedPopup) {
		ecsLib.isOpenedPopup = true;
		if (!val) {
			val = "";
		} else if (!utilLib.isDate(val)) {
			val = "";
			var msg = "날짜를 년월일(8글자) 형식으로 입력해야 합니다.";
			if (isPopup) {
				comLib.alert($p, msg);
			} else {
				val = msg;
			}
		} else {
			if (!isPopup) {
				val = "";
			}
		}
	}
	ecsLib.isOpenedPopup = false;
	return val;
};

/**
 * 저장사유 메세지 팝업을 호출한다.
 * 
 * @date 2014. 12. 9.
 * @param {String} messageTyp 			팝업창 타입 (alert || confirm)
 * @param {String} message 				메시지
 * @param {String} closeCallbackFncName 콜백 함수명
 * @param {Boolean} isReturnValue 		Confirm 창인 경우 선택 결과(boolean)을 반환할지 여부
 * @param {String} title 				팝업창 타이틀
 * @example
 	comLib.messageBox($p, "alert", message, closeCallbackFncName, isReturnValue, title);
 */
ecsLib.saveRsn = function($p, dataCltId, message, closeCallbackFncName, isReturnValue, title) {
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
	if ((typeof $p == "undefined") || (typeof $p.getFrameId !== "function")) {
		$p = window.$p.top().$p;
	}

	var message = message || "";
	var messageType = "confirm";
	var defaultTitle = null;
	var msgClsNm = "";

	defaultTitle = "Confirm";
	msgClsNm = "header-confirm";

	var closeCallbackFncName = closeCallbackFncName || "";
	if (closeCallbackFncName) {
		if (typeof closeCallbackFncName !== "string" ) {
			alert("콜백함수 처리는 문자열로만 가능합니다 .");
			return;
		} else {
			if (closeCallbackFncName.indexOf("scwin.") === 0) {
				closeCallbackFncName=$p.id + closeCallbackFncName;
			}
		}
	}
	comLib.getCheckCallBackFunc(closeCallbackFncName, "comLib.messageBox"); /* 콜백함수 처리 오류 검증 테스트 이후 삭제예정*/
	if (typeof isReturnValue === "undefined") {
		isReturnValue = false;
	}
	var messageBrCnt = 1;
	var width = 450;
	if (typeof message == "object" && message.length > 0) {
		messageBrCnt = message[0].match(/\\n/gi) != null ? message[0].match(/\\n/gi).length + 1 : 1;
		if (message[0].length > 100) {
			messageBrCnt += Math.ceil(message[0].length / 52);
			width = 750;
		}
		message[0] = message[0].replace(/\\n/gi, "<br>");
		message[0] = message[0].replace(/\n/gi, "<br>");
		message[0] = message[0].replace(/<BR>/gi, "<br>");
		messageBrCnt = comLib.messageLineCount(message[0]);
	} else {
		messageBrCnt = message.match(/\\n/gi) != null ? message.match(/\\n/gi).length + 1 : 1;
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
			"isReturnValue" : isReturnValue,
		},
		modal : true,
		width : width,
		height : 260 + (messageBrCnt * 25),
		className : msgClsNm
	};
	if (dataCltId) {
		options.popupParam.dataCltId = dataCltId;
	}
	options.popupParam.closeCallbackFncName = closeCallbackFncName;
	comLib.openPopup($p, messageType, "/ui/common/message_box.xml", options);
};

/**
 * 수기입력 저장시 출력되는 확인 메시지창(confirm)에 추가적으로 표시할 메세지를 반환한다.
 * 
 * @returns 메시지
 */
ecsLib.extendCustomSaveMsg = function(addCount, modifyCount, deleteCount) {
	var msg = "\n(";
	var isLastMsg = ", ";
	if (addCount) {
		msg += `추가 : ${addCount}건, `;
	}
	if (modifyCount) {
		msg += `수정 : ${modifyCount}건, `;
	}
	if (deleteCount) {
		msg += `삭제 : ${deleteCount}건`;
	}
	if (msg.substr(-2) == isLastMsg) {
		msg = msg.substr(0, msg.length - isLastMsg.length);
	}
	msg += ")";
	return msg;
};

/**
 * 수기입력 저장시 PK 데이터의 중복을 체크하고 중복이 있을 시 메시지를 출력한다.
 * 
 * @param
 * grdComp : GridView Component
 * dltComp : GridView와 연결된 Datacolection Component
 * pkList : PK(중복 확인)의 컬럼명 List
 * @return <Boolean> 중복 여부
 */
ecsLib.gridViewPkDuplicationCheck = function(grdComp, dltComp, pkColumnList) {
	var checked = false;
	var originList = dltComp.getAllJSON();
	var modifyList = dltComp.getModifiedJSON().filter(obj => obj.rowStatus == "C" || obj.rowStatus == "U");
	var pkColumnStrFunc = function(obj) {
		var cehckStr = "";
		pkColumnList.forEach(column => {
			cehckStr += (obj[column] || obj[column.id]);
		});
		return cehckStr;
	};

	var modifyCheckList = [];
	modifyList.forEach(obj => {
		var modifyCheckStr = pkColumnStrFunc(obj);
		modifyCheckList.push(modifyCheckStr);
	});

	var duplicationStrList = [];
	originList.forEach(obj => {
		if (obj.rowStatus == "R") {
			var originCheckStr = pkColumnStrFunc(obj);
			if (modifyCheckList.includes(originCheckStr)) {
				duplicationStrList.push(originCheckStr);
			}
		}
	});

	originList.forEach((obj, idx) => {
		if (obj.rowStatus == "C" || obj.rowStatus == "U") {
			var modifyCheckStr = pkColumnStrFunc(obj);
			if (duplicationStrList.includes(modifyCheckStr)) {
				if (!checked) {
					checked = true;
				}
				pkColumnList.forEach(column => {
					grdComp.setCellBackgroundColor(idx, column, utilLib.INVALID_COLOR_MANDATORY);
				});
			}
		}
	});
	if (checked) {
		comLib.alert($p, "중복 데이터가 있습니다.");
		ecsLib.isOpenedPopup = false;
	}
	return checked;
};

/**
 * 수기입력의 AutoComplate 항목을 검증하고 상위코드의 이름을 미리 보여준다.
 * 
 * @param
 * grdComp : GridView Component
 * acbDltComp : GridView와 연결된 AutoComplate의 Datacolection Component
 * acbMappingCdObj : GridView의 컬럼명과 AutoComplate의 컬럼명 맵핑 Object
 * acbMappingNmObj : GridView의 컬럼명과 AutoComplate의 컬럼명 맵핑 Object
 * @return <Boolean> 검증 실패 여부
 */
ecsLib.validateGridViewAcb = function(grdComp, acbDltComp, acbMappingCdObj, acbMappingNmObj) {
	var maxMessage = 50;
	var arrData = [];
	var checked = false;
	var dltComp = $p.getComponentById(grdComp.getDataList());

	grdComp.getAllJSON().forEach((grdObj, grdIdx) => {
		if (grdObj.rowStatus != "R") {
			// 기본
			if (grdObj.rowStatus == "E" || grdObj.rowStatus == "D") {
				// 삭제
			} else {
				// 추가/수정
				Object.keys(acbMappingCdObj).forEach(cdColNm => {
					var userInputData = grdObj[cdColNm];
					var findAcbObj = acbDltComp.getAllJSON().find(acbObj =>
						acbObj.cmmnCd == userInputData || acbObj.cmmnCdNm == userInputData);
					var tempObj = {};
					var dltIdx = dltComp.getAllJSON().findIndex(objDlt => ecsLib.isObjEqual(objDlt, grdObj));
					if (!findAcbObj) {
						checked = true;
						grdComp.setCellColor(grdIdx, cdColNm, "#EE2222");
						grdComp.setCellBackgroundColor(grdIdx, cdColNm, utilLib.INVALID_COLOR_CODE);
						Object.keys(acbMappingNmObj).forEach(nmColNm => {
							tempObj[nmColNm] = "";
						});
						if (arrData.length <= maxMessage) {
							arrData.push((grdIdx + 1) + " line. " + utilLib.getMessage("SCM.INFO.00316", dltComp.getColumnName(cdColNm))[0]);
						}
					} else {
						if (findAcbObj.cmmnCd != userInputData) {
							tempObj[cdColNm] = findAcbObj[acbMappingCdObj[cdColNm]];
							dltComp.setRowJSON(dltIdx, tempObj, true);
						}
						tempObj = {};
						Object.keys(acbMappingNmObj).forEach(nmColNm => {
							tempObj[nmColNm] = findAcbObj[acbMappingNmObj[nmColNm]];
						});
					}
					dltComp.setRowJSON(dltIdx, tempObj, true);
				});
			}
		}
	});

	if (!utilLib.isNull(arrData)) {
		var message = "";
		for (var idx = 0; idx < arrData.length; idx++) {
			message += arrData[idx] + "<br/>";
		}
		message += "관리자에게 문의하세요."
		comLib.messageBox(grdComp.getScopeWindow().$p, "alert", message, "", false, "Data Validation");
	}
	return checked;
};

/**
 * 수기입력의 GridView Component의 수정 항목을 확인하고 변경 시 폰트 색상을 변경한다. feat.(ev : _onafteredit)
 * 
 * @param
 * grdComp : GridView Component
 * row : row Idx
 * col : col Idx
 * color : font color
 * @return
 */
ecsLib.updateGridViewFontColor = function(grdComp, row, col, color) {
	color = color || "blue";
	if (grdComp.getAllJSON()[row].rowStatus == "U") {
		grdComp.setCellColor(row, col, color);
	}
};

/**
 * 차트데이터의 총량을 반환한다.
 * 
 * @param
 * chartList : 차트 데이터 리스트
 * keysList : 조회할 key 리스트 or 문자
 * @return 총량
 */
ecsLib.chartDataTotalAmt = function(chartList, keys) {
	var max = 0;
	var min = 0;

	if (typeof(keys)== "object") {
		for (key of keys) {
			var maxData = chartList.reduce((max, obj) => Math.max(max, obj[key]), 0);
			if (maxData > max) {
				max = maxData;
			}
			var minData = chartList.reduce((min, obj) => Math.min(min, obj[key]), 0);
			if (minData < min) {
				min = minData;
				console.log(min);
			}
		}
	} else if (typeof(keys)== "string") {
		max = chartList.reduce((max, obj) => Math.max(max, obj[keys]), 0);
		min = chartList.reduce((min, obj) => Math.min(min, obj[keys]), 0);
	}

	if (min < 0) {
		max = max + Math.abs(min);
	}

	return max;
};

/**
 * 두 Object를 비교한다.
 * 
 * @date 2023.08.31
 * @param
 * @return
 */
ecsLib.isObjEqual = function(obj1, obj2) {
	var obj1Sort = Object.keys(obj1).sort().reduce((obj, key) => {
		obj[key] = obj1[key];
		return obj;
	}, {});
	var obj2Sort = Object.keys(obj2).sort().reduce((obj, key) => {
		obj[key] = obj2[key];
		return obj;
	}, {});

	return Object.entries(obj1Sort).toString() == Object.entries(obj2Sort).toString();
};

/**
 * ibx에서 엔터를 누르면 조회 이벤트
 * 
 * @date 2023.10.01
 * @param
 * @return
 */
ecsLib.ibxEnterEvent = function(e) {
	if (e.keyCode == "13") {
		var frameCmp = $p.getComponentById(e.target.id);
		if (frameCmp) {
			var btn = document.querySelector("#" + frameCmp.scope_id + " .search-box a[id$='btnInqire']");
			if (btn) {
				$p.getComponentById(btn.id).focus();
				$p.getComponentById(btn.id).click();
			}
		}
	}
};

/**
 * 차트 재로딩
 * 
 * @date 2024.02.01
 * @param
 * @return
 */
ecsLib.chartReload = function(chartId, time) {
	setTimeout(() => {
		if (parseInt(document.getElementById(chartId).style.height) < 100) {
			document.getElementById(chartId).resize();
		}
	}, time | 500);
};

/**
 * 타시스템 팝업창을 연다.
 * 
 * @date 2024.02.01
 * @param
 * @return
 */
ecsLib.queryStringToJSON = function(queryStr) {
	var resultObj = {};
	if (queryStr && queryStr.length > 0) {
		if (queryStr.indexOf("?") == 0) {
			queryStr = queryStr.slice(1);
		}
		var queryStrSplit = queryStr.split("&");
		for (var param of queryStrSplit) {
			var paramSplit = param.split("=");
			var key = paramSplit[0];
			var value = paramSplit[1];
			if (key) {
				resultObj[key] = value || "";
			}
		}
	}

	return resultObj;
};

/**
 * 스킨Src에 따른 스킨명을 얻는다.
 * 
 * @date 2024.02.01
 * @param
 * @return
 */
ecsLib.getSkinName = function() {
	var skinList = Object.keys(utilLib).filter(item => item.startsWith("SKIN"));
	if (utilLib.isNull(localStorage.getItem("DAON_SKIN"))) {
		var skinSrc = comLib.getCookie("DAON_SKIN");
	} else {
		var skinSrc = localStorage.getItem("DAON_SKIN");
	}
	var skinKey = skinList.find(keyNm => utilLib[keyNm] == skinSrc);

	return skinKey;
};

/**
 * 스킨에 따른 차트 색상을 얻는다.
 * 
 * @date 2024.02.01
 * @param
 * @return
 */
ecsLib.getSkinColors = function() {
	var skinNm = ecsLib.getSkinName().replaceAll("SKIN_", "");
	var result = {};

	switch (skinNm) {
		case "GREEN":
			result.chartSolidColor1 = "#41E667";
			result.chartSolidColor2 = "#34F360";
			result.chartSolidColor3 = "#44A85B";
			break;
		case "PURPLE":
			result.chartSolidColor1 = "#8A41E6";
			result.chartSolidColor2 = "#8934F3";
			result.chartSolidColor3 = "#7044A8";
			break;
		case "GRAY":
			result.chartSolidColor1 = "#818F97";
			result.chartSolidColor2 = "#73848C";
			result.chartSolidColor3 = "#8F9CA3";
			break;
		case "COOLGREEN":
			result.chartSolidColor1 = "#41CDE6";
			result.chartSolidColor2 = "#34D6F3";
			result.chartSolidColor3 = "#4499A8";
			break;
		case "DEFAULT":
		default:
			result.chartSolidColor1 = "#41B2E6";
			result.chartSolidColor2 = "#34A2F3";
			result.chartSolidColor3 = "#4453A8";
			break;
	}

	return result;
};

/**
 * 스킨변경시 css를 변경한다.
 * 
 * @date 2024.02.01
 * @param
 * @return
 */
utilLib.scrinChangeSkin = function(winObj) {
	var skinNm = ecsLib.getSkinName();
	var skinSrc = utilLib[skinNm];

	try {
		// skin 추가
		if (!utilLib.isNull(localStorage.getItem("DAON_SKIN"))) {
			utilLib.appendStyleSheet(winObj, skinSrc);
			document.querySelector(`link[rel="stylesheet"][href="${utilLib[skinNm]}"]`).remove();
		}
	} catch (e) {
		console.error(e);
		//skin 추가
		if (!utilLib.isNull(comLib.getCookie("DAON_SKIN"))) {
			utilLib.appendStyleSheet(winObj, skinSrc);
			document.querySelector(`link[rel="stylesheet"][href="${utilLib[skinNm]}"]`).remove();
		}
	}
};

/**
 * 타시스템 팝업창을 연다.
 * 
 * @date 2024.02.01
 * @param
 * @return
 */
ecsLib.openOtherSysPopup = function(sysDivCd, fileUrl) {
	if (!sysDivCd) {
		return;
	}
	var sysDivCdLower = sysDivCd.toLowerCase();
	var sysDivCdUpper = sysDivCd.toUpperCase();
	var url = "/openOthrSysMnu.do?targetSystem=" + sysDivCdLower;
	window.open(url, sysDivCdUpper, "location=no, width=1300, height=830, scrollbars=yes, top=10, left=10, resizable=yes");
	/*
	if (!sysDivCd) {
		return;
	}
	var sysPOPURL = comLib[`${sysDivCd.toUpperCase()}_POP_URL`];
	fileUrl = fileUrl || `/ui/index.xml`;
	var url = sysPOPURL + fileUrl;

	//팝업창 옵션
	var option = {
		popupID : sysDivCd,
		width : 1600,
		height : 900,
		title : sysDivCd
	};

	var strEnc = comLib.dataDecEnc(utilLib.getDate(), "E"); //암호화 키값
	var usrInfo; //세션정보 및 윈도우 타이틀

	usrInfo = JSON.stringify(comLib.getUserInfo4Param(strEnc, encodeURI(option.title)));

	var jsonObj = {
		userInfo : usrInfo,
		closeCallbackFncName : "",
		popupId : option.popupID,
	};

	comLib.openPostWinPopup($p, url, option, jsonObj);
	*/
};

/**
 * 메인화면 디테일 지도를 동적으로 생성한다.
 * 
 * @date 2024.03.01
 * @param
 * @return
 */
ecsLib.createDetailMapBasinInfo = function(comp, basin, datas, callbackFunc) {
	if (!basin) {
		return;
	}
	if (!datas || datas.length == 0) {
		return;
	}
	var defaultAttr = {
		"stroke-width" : "0.5",
		"text" : {
			"tag" : "text",
			"fill" : "black",
			"xml:space" : "preserve",
			"style" : "white-space: pre",
			"font-size" : "10.5",
			"letter-spacing" : "0em"
		}
	};
	var rootMap = document.querySelector(`#${comp.getID()} > g > g[id*="map${basin.toUpperCase()}"] `);
	if (rootMap.style && rootMap.style.transform) {
		defaultAttr["text"]["font-size"] = "8.5";
	}

	var initEmts = document.querySelectorAll(`#${comp.getID()} .detail-map-init`);
	initEmts.forEach(emt => {
		emt.innerHTML = "";
	});

	/*
	var upperDataTmp = {};
	datas.forEach(obj => {
		if (!upperDataTmp[obj.upperCmmnCd]) {
			upperDataTmp[obj.upperCmmnCd] = {};
			upperDataTmp[obj.upperCmmnCd]["cmmnCd"] = obj.upperCmmnCd;
			upperDataTmp[obj.upperCmmnCd]["cmmnCdNm"] = obj.upperCmmnCdNm;
			upperDataTmp[obj.upperCmmnCd]["usrDfnVu1"] = obj.upperUsrDfnVu1;
			upperDataTmp[obj.upperCmmnCd]["usrDfnVu2"] = JSON.parse(obj.upperUsrDfnVu2);
			upperDataTmp[obj.upperCmmnCd]["usrDfnVu3"] = JSON.parse(obj.upperUsrDfnVu3);
		}
	});
	var upperData = [];
	Object.keys(upperDataTmp).forEach(key => upperData.push(upperDataTmp[key]));
	*/

	var rootEmtId = `marker${basin.toUpperCase()}`;
	var infoRootEmt = document.querySelector(`#${comp.getID()} #${rootEmtId}.detail-map-marker-${basin.toLowerCase()}`);
	var createEmtAndSetAttrFunc = function(dataObj) {
		var emt = document.createElementNS("http://www.w3.org/2000/svg", `${dataObj["tag"]}`);
		Object.keys(dataObj).forEach(key => {
			if (key != "tag") {
				emt.setAttribute(key, dataObj[key]);
			}
		});

		return emt;
	};

	datas.forEach(obj => {
		var gEmt = document.createElementNS("http://www.w3.org/2000/svg", "g");
		gEmt.id = `${rootEmtId}_${obj.cmmnCd}`;
		gEmt.classList.add(`main-detail-${obj.upperCmmnCd}`);

		if (obj.usrDfnVu2) {
			var shapeData = JSON.parse(obj.usrDfnVu2);
			var shapeEmt = createEmtAndSetAttrFunc(shapeData);
			var upperData = JSON.parse(obj.upperUsrDfnVu2);
			shapeEmt.setAttribute("stroke-width", defaultAttr["stroke-width"]);
			shapeEmt.setAttribute("fill", upperData["fill"]);
			shapeEmt.setAttribute("stroke", upperData["stroke"]);

			gEmt.append(shapeEmt);

			if (obj.upperCmmnCd == "hq") {
				var defaultNum = 2;
				var shapeEmtClone = shapeEmt.cloneNode();
				shapeEmtClone.setAttribute("x", Number(shapeEmtClone.getAttribute("x")) + defaultNum);
				shapeEmtClone.setAttribute("y", Number(shapeEmtClone.getAttribute("y")) + defaultNum);
				shapeEmtClone.setAttribute("width", Number(shapeEmtClone.getAttribute("width")) - (defaultNum * 2));
				shapeEmtClone.setAttribute("height", Number(shapeEmtClone.getAttribute("height")) - (defaultNum * 2));
				shapeEmtClone.setAttribute("fill", "#FFFFFF");
				gEmt.append(shapeEmtClone);
			}
		}

		if (obj.usrDfnVu3) {
			var textEmt = createEmtAndSetAttrFunc(defaultAttr.text);

			var textData = JSON.parse(obj.usrDfnVu3);
			var textEmtChildEmt = createEmtAndSetAttrFunc(textData);
			textEmtChildEmt.textContent = obj.cmmnCdNm;

			textEmt.append(textEmtChildEmt);
			gEmt.append(textEmt);
		}

		if (obj.usrDfnVu4) {
			var ectShapeData = JSON.parse(obj.usrDfnVu4);
			var ectShapeEmt = createEmtAndSetAttrFunc(ectShapeData);
			if (!ectShapeEmt.getAttribute("stroke-width")) {
				ectShapeEmt.setAttribute("stroke-width", defaultAttr["stroke-width"]);
			}

			gEmt.append(ectShapeEmt);
		}

		infoRootEmt.append(gEmt);
	});

	callbackFunc();
};