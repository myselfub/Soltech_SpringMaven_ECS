/**
 * @target  File 관련 공통 함수
 * @type    fileLib
 * @since   2017.04.03
 * @author TJ Kim
 */

var fileLib = {};

/**
 * 그리드뷰 엑셀다운로드
 *
 * @param	gridView					: 다운로드할 그리드뷰 object
 * @param	optionObj.fileName			: 저장할 엑셀파일명 (null이거나 빈값이면 그리드ID로 설정)
 * @param	optionObj.hiddenYn			: 히든컬럼 제외여부 (Y:제외, null이거나 빈값이면 미제외)
 * @param	optionObj.removeColIndex	: 제외할 컬럼 Index (null이거나 빈값이면 미제외, 여러개일경우 , 로 구분)
 * @param	optionObj.useSubTotal		: SubTotal 출력여부(true, false, default : false)
 * @example
			var optionObj = {};
			optionObj.fileName			= "사업부관리";		//엑셀 파일 명
			optionObj.hiddenYn			= "Y";				//히든 컬럼 제외여부 (Y,N)
			optionObj.removeColIndex	= "1,2,3";			//제외할 컬럼 index (여러개일경우 , 로 구분)
			optionObj.useSubTotal		= "true"			//SubTotal 출력여부(true, false, default : false)
			fileLib.excelDownload ( grid1, optionObj );

 */
fileLib.excelDownload = function(gridView, optionObj) {
	var options = {};
	var fileExt = ".xlsx";			//엑셀 확장자(6만건 이하일경우)

	//그리드 유무 체크
	if ( typeof gridView == "undefined" || gridView == null || gridView == "" ) {
		return;
	}
	//그리드 조회 건수 체크
	var gridCnt = gridView.getDataLength();
	if (gridCnt == 0) {
		comLib.alert($p, "엑셀다운로드 할 데이터가 없습니다.");
		return;
	}

	//엑셀 확장자 지정
	if ( gridCnt > 65000 ) {
		comLib.alert($p, "데이터 건수가 6만5천건 이상입니다. 엑셀2007버전용 xlsx 파일로 다운로드 됩니다.");
		fileExt = ".xlsx";
	}

	var curDate = utilLib.getCurrentDate("yyyyMMddHHmmss");		//현재일자시간

	var f_name = optionObj.fileName + "_"+ curDate + fileExt;

	var removeCol = "";							//제외 컬럼 index

	//optionObj 체크
	if ( typeof optionObj != "undefined" && optionObj != null && optionObj != "" ) {

		//1. 파일명 체크
    	if ( typeof optionObj.fileName != "undefined" && optionObj.fileName != null && optionObj.fileName != "" ) {
    		f_name = optionObj.fileName + "_"+ curDate + fileExt;
    	}

    	//2. 히든 제외 여부 체크
    	if ( typeof optionObj.hiddenYn != "undefined" && optionObj.hiddenYn != null && optionObj.hiddenYn != "" && optionObj.hiddenYn == "Y" ) {
    		var colCnt = gridView.getTotalCol();
    		for (var i=0; i<colCnt; i++) {
    			visible = gridView.getColumnVisible(i);		// 히든컬럼은 제외한 경우 getColumnVisible(컬럼 Index)를 이용하여
    			if (!visible) {                           		// 숨김처리가 되어있는지 확인하여 removeColumns에 숨김처리된 컬럼 목록을 지정한다.
    				removeCol = removeCol + i +",";
    			}
    		}
    		if (removeCol.length > 1)	removeCol = removeCol.substring(0, removeCol.length -1);
    	}

		//3. 제외 컬럼 index 체크
		if ( typeof optionObj.removeColIndex != "undefined" && optionObj.removeColIndex != null && optionObj.removeColIndex != "" ) {
			if (removeCol.length > 1)	removeCol = removeCol + ",";
			removeCol = removeCol + optionObj.removeColIndex;
    	}

		//4. SubTotal 출력여부 체크
		if ( typeof optionObj.useSubTotal != "undefined" && optionObj.useSubTotal != null && optionObj.useSubTotal != "" ) {
			options.useSubTotal = optionObj.useSubTotal;		//SubTotal 출력여부
    	}
	}

    options.fileName			= f_name;			//파일의 이름을 결정합니다.
	options.removeColumns		= removeCol;		//제외할 컬럼 index(여러개일 경우 , 로 구분)

    options.type				= "1"; 				//type이 1인 경우 눈에 보이는 데이터를 0인 경우 실제 데이터를 가지고 옵니다.
    options.startRowIndex		= 0;				//excel에서 gird의 데이터가 시작될 row의 index입니다.
    options.startColumnIndex	= 0;				//excel에서 gird의 데이터가 시작될 column의 index입니다.
    //options.headerColor 		= "#C9C9C9";		//그리드의 header부분의 색(#33CCCC)	=> useStyle 설정하면 적용안됨.
    //options.footerColor		= "#C9C9C9";		//그리드의 footer부분의 색(#008000)	=> useStyle 설정하면 적용안됨.

    options.useStyle			= false;			//CSS를 제외한 style을 Excel에도 적용할지 여부(배경색, 폰트)
    options.autoSizeColumn		= false;				//너비자동맞춤 설정 유무

    gridView.advancedExcelDownload(options , null);
};

/**
 * GridView에 엑셀 파일 데이터 업로드한다.
 *
 * @param <Object> grdViewObj 엑셀 파일의 데이터를 업로드할 GridView 객체
 * @param <Object> options JSON형태로 저장된 그리드의 엑셀 업로드 옵션
 * | options.type            : [defalut: 0] 1이면 엑셀 파일이 그리드의 보이는 결과로 만들어져있을때  0이면 엑셀 파일이 그리드의 실제 데이터로 구성되어있을때
 * | options.sheetNo          : [defalut: 0] excel파일에서 그리드의 데이터가 있는 sheet번호
 * | options.startRowIndex  : [defalut: 0] excel파일에서 그리드의 데이터가 시작되는 행의 번호(헤더 포함)
 * | options.startColumnIndex : [defalut: 0] excel파일에서 그리드의 데이터가 시작되는 열의 번호
 * | options.endColumnIndex : [default: 0] excel파일에서 그리드의 데이터가 끝나는 열의 index ( 엑셀컬럼수가 그리드컬럼수 보다 작은 경우 그리드 컬러수를 설정)
 * | options.headerExist      : [defalut: 0] excel파일에서 그리드의 데이터에 header가 있는지 여부(1이면 header 존재 0이면 없음)
 * | options.footerExist      : [defalut: 1] excel파일에서 그리드의 데이터에 footer가 있는지 여부(1이면 footer 존재 0이면 없음 기본값은 1 그리드에 footer가 없으면 적용되지 않음)
 * | options.append        : [defalut: 0] excel파일에서 가져온 데이터를 그리드에 append시킬지 여부(1이면 현재 그리드에 데이터를 추가로 넣어줌 0이면 현재 그리드의 데이터를 삭제하고 넣음)
 * | options.hidden        : [defalut: 0] 읽어들이려는 엑셀파일에 hidden column이 저장되어 있는지 여부를 설정하는 int형 숫자(0이면  엑셀파일에 hidden 데이터가 없으므로 그리드 hidden column에 빈 데이터를 삽입  1 : 엑셀파일에 hidden 데이터가 있으므로 엑셀 파일로부터 hidden 데이터를 삽입 )
 * | options.fillHidden    : [defalut: 0] Grid에 hiddenColumn에 빈 값을 넣을지를 결정하기 위한 int형 숫자(1이면 hidden Column에 빈 값을 저장하지 않음,0이면 hidden column이 저장되어있지 않은 Excel File이라 간주하고 hidden Column에 빈 값을 넣어줌)(hidden이 0인 경우에는 fillhidden은 영향을 끼치지 않음)
 * | options.skipSpace      : [defalut: 0] 공백무시 여부(1이면 무시 0이면 포함)
 * | options.insertColumns  : radio, checkbox와 같은 컬럼을 엑셀에서 받아 오지 않고, 사용자 컬럼 설정 으로 업로드 ( 데이터 구조 : [ { columnIndex:1, columnValue:"1" } ] )
 * | options.popupUrl        : 업로드시에 호출할 popup의 url
 *
 * @example
 * var options = {};
 * options.headerExist ="1"; //헤더의 존재 여부 입니다.
 * options.startRowIndex = "3"; //excel파일에서 gird의 데이터가 시작되 row의 index입니다..(헤더 포함)
 * options.startColumnIndex = "0";  //excel파일에서 gird의 데이터가 시작되는 column의 index입니다.(헤더 포함)
 * options.sheetNo=0; //excel의 sheet번호입니다.
 * options.append ="0";  //append 여부입니다. 0이면 append하지 않고 새로 쓰고 1이면 그리드의 뒤쪽에 데이터를 추가로 붙여줍니다.
 * options.hidden ="1";  //1이면 그리드에서 엑셀 다운로드시에 hidden을 포함했다는 의미입니다. 즉 upload시에 그리드의 hidden Column에 값을 넣는다는 의미입니다.
 */
fileLib.excelUpload = function(grdViewObj, options) {
	options.endColumnIndex = options.endColumnIndex || grdViewObj.getColumnCount();
    grdViewObj.advancedExcelUpload(options); //엑셀 업로드를 시작합니다.
};

/**
 * GridView에 텍스트 파일 데이터 업로드한다.
 *
 * @param {Object} grdViewObj
 * @param {Object} options
 * | options.type           [default: 1, 0]데이터 형태 (0이면 실 데이터 형태,1이면 display 표시 방식)
 * | options.header         [default: 1, 0]Grid header 존재 유무 (0이면 header row수를 무시하고 전부 업로드하고 1이면 header row수 만큼 skip한다.)
 * | options.delim          [default: ',']CSV 파일에서 데이터를 구분할 구분자
 * | options.escapeChar     CSV 데이터에서 제거해야 되는 문자셋 ( ex) '\'' )
 * | options.startRowIndex  [defalut: 0] csv파일에서 그리드의 데이터가 시작되는 행의 번호, startRowIndex가 설정되면, header 설정은 무시된다.
 * | options.append         [defalut: 0, 1]csv파일에서 가져온 데이터를 그리드에 append시킬지 여부(1이면 현재 그리드에 데이터를 추가로 넣어줌 0이면 현재 그리드의 데이터를 삭제하고 넣음)
 * | options.hidden         [defalut: 0, 1]hidden Column에 대한 저장 여부(0이면 저장하지않음,1이면 저장)
 * | options.fillHidden     [defalut: 0, 1]hidden Column에 빈 값을 넣을지를 결정하기 위한 int형 숫자(1이면 hidden Column에 빈 값을 저장하지 않음,0이면 hidden column이 저장되어있지 않은 csv File이라 간주하고 hidden Column에 빈 값을 넣어줌)(hidden이 0인 경우에는 fillhidden은 영향을 끼치지 않음)
 * | options.skipSpace      [defalut: 0, 1]공백무시 여부(1이면 무시 0이면 포함)
 * | options.expression     [defalut: 1, 0]expression 컬럼 데이터를 포함하고 있는지 여부, 기본값은 미포함(1이면 미포함, 0이면 포함)
 * | options.popupUrl       업로드시에 호출할 popup의 url
 * @example var options = {
 *	  			type:               "1",
 *  			delim:              ",",
 *  			escapeChar:         "'",
 *  			startRowIndex:        1,
 *  			append:             "0",
 *  			hidden:             "0",
 *  			fillHidden:         "0",
 *  			skipSpace:          "1"
 * 			};
 * 			grdViewObj.readCSV(options);
 */
fileLib.textUpload = function(grdViewObj, options) {
	grdViewObj.readCSV(options);
};

/**
 * 파일 업로드 확장자 체크
 *
 * @param 		uploadID		: 업로드 ID(String)
 * @returns 	업로드 가능(true), 업로드 불가(false)
 * @example 	var check = fileLib.uploadFileCheck( uploadID );
 */
fileLib.uploadFileCheck = function( uploadID ){
	/* 첨부파일 확장자 검사
	*	허용 확장자 : gif, jpg, doc, xls, ppt, pdf, txt, xlsx, png, pptx, xml, docx, hwp, shp, shx, dbf, 
	*                   dxf, dwg, ngi, vi, mp4, inp, 7Z, ALZ, BMP, EGG, GUL, HWX, INI, LSB, LSM, LSX, 
	*                   LZH, MHT, PEG, RAR, TIF, VSD, XLT, XPS, ZIP
	*/
	var fileName = eval(uploadID).getValue();
	if ( fileName != "" ){
		var ext = fileName.slice(fileName.lastIndexOf(".")+1).toLowerCase();
		if (ext != "gif" && ext != "jpg"  && ext != "doc" && ext != "xls" && ext != "ppt" && 
			ext != "pdf" && ext != "txt" && ext != "xlsx" && ext != "png" && ext != "pptx" &&
			ext != "xml" && ext != "docx" && ext != "hwp" && ext != "shp" && ext != "shx" && 
			ext != "dbf" && ext != "dxf" && ext != "dwg" && ext != "ngi" && ext != "vi" &&
			ext != "mp4" && ext != "inp" && ext != "7z" && ext != "alz" && ext != "bmp" &&
			ext != "egg" && ext != "gul" && ext != "hwx" && ext != "ini" && ext != "lsb" &&
			ext != "lsm" && ext != "lsx" && ext != "lzh" && ext != "mht" && ext != "peg" &&
			ext != "rar" && ext != "tif" && ext != "vsd" && ext != "xlt" && ext != "xps" && 
			ext != "zip" && ext != "rpt" && ext != "inp" && ext != "rtp" && ext != "enc" &&
			ext != "evl" && ext != "kbid" && ext != "jpeg") {
			comLib.messagBox("첨부파일이 등록 하실 수 없는 확장자 입니다.");
			eval(uploadID).reset();
			return false;
		}
	}

	return true;
};

/**
 * 멀티파일 업로드 확장자 체크
 *
 * @param 		object		: 배열
 * @returns 	업로드 가능(true), 업로드 불가(false)
 * @example 	var check = fileLib.multiUploadFileCheck( object );
 */
fileLib.multiUploadFileCheck = function( object ){
	/* 첨부파일 확장자 검사
	*	허용 확장자 : gif, jpg, doc, xls, ppt, pdf, txt, xlsx, png, pptx, docx, jpeg, jsp (websquare.xml 설정값 )
	*   주요변경사항 : 2017.10.10 강용식차장에 의해 zip 파일은 업로드 대상에서 제외됨 
	*                     ==> 게시판에서 업로드시는 어떻게 해야되는가?
	*/
	var fileName = "";
	fileName = object.name;
	
	if ( fileName != "" ){
		var ext = fileName.slice(fileName.lastIndexOf(".")+1).toLowerCase();
		if ( ext != "gif" && ext != "jpg"  && ext != "doc" && ext != "xls" && ext != "ppt" && 
				ext != "pdf" && ext != "txt" && ext != "xlsx" && ext != "png" && ext != "pptx" &&
				ext != "xml" && ext != "docx" && ext != "hwp" && ext != "shp" && ext != "shx" && 
				ext != "dbf" && ext != "dxf" && ext != "dwg" && ext != "ngi" && ext != "vi" &&
				ext != "mp4" && ext != "inp" && ext != "7z" && ext != "alz" && ext != "bmp" &&
				ext != "egg" && ext != "gul" && ext != "hwx" && ext != "ini" && ext != "lsb" &&
				ext != "lsm" && ext != "lsx" && ext != "lzh" && ext != "mht" && ext != "peg" &&
				ext != "rar" && ext != "tif" && ext != "vsd" && ext != "xlt" && ext != "xps" && 
				ext != "zip" && ext != "rpt" && ext != "inp" && ext != "rtp" && ext != "enc" &&
				ext != "evl" && ext != "kbid" && ext != "jpeg") {     
			//comLib.messageBox("alert","첨부파일이 등록 하실 수 없는 확장자 입니다.","","","첨부파일관리");
			alert ("등록 하실 수 없는 확장자입니다.(" + fileName + ")");
			return false;
		}
	}

	return true;
};

/**
 * 첨부파일 선택 후 실행되는 함수
 *
 * @param 	fileInfos		: 배열
 * @returns 	
 * @example 	var check = fileLib.multiUploadFileCheck( object );
 */
fileLib.selectCallback = function (mpd_File, ibx_input, dataList) {
	//dataList.removeAll();
	var fileInfos = new Array();
	var arrowFileInfo = new Array();
	var chkFile = false;
	fileInfos = mpd_File.getFileInfos();
	// 멀티업로드 컨포넌트의 첨부파일을 하나씩 선택시 계속해서 데이터 쌓이기 때문에 하나씩 삭제하고
	// 제일 마지막 값만 사용함.
	if ( fileInfos.length > 1 ) {
		mpd_File.removeFile( fileInfos[0].name );
		fileInfos =mpd_File.getFileInfos();         
	}
	
	for (var idx=0; idx < fileInfos.length; idx++) {
		chkFile = fileLib.multiUploadFileCheck(fileInfos[idx]);
		
		if (chkFile) {
			arrowFileInfo.push(fileInfos[idx]);
			dataList.setRowJSON(0, arrowFileInfo[idx] );
			ibx_input.setValue( fileInfos[idx].name );
		} else {
			mpd_File.removeFile( fileInfos[idx].name );
		}
	}
};

/**
 * 멀티 첨부파일 업로그 가능한 파일만 DataCollection에 담는 함수
 * return 멀티업로드 컨포넌트
 */
fileLib.checkFileDupDataList = function(mpd_File, dataList) {
	var arrowFileInfo = new Array();
	var fileNm = "";
	var saveYn = "";     //저장여부
	var checkFile = false;
	var fileInfos = mpd_File.getFileInfos();
	
	//1. Data List와 비교
	for (var i = 0; i < fileInfos.length; i++ ) {
		// 확장자 체크
		chkFile = fileLib.multiUploadFileCheck(fileInfos[i]);

		if (!chkFile) {
			mpd_File.removeFile( fileInfos[i].name );
			continue;
		} else {	
			for (var idx=0; idx < dataList.getTotalRow(); idx++) {
				fileNm = dataList.getCellData(idx, "name");
				saveYn = dataList.getCellData(idx, "saveYn");
				if (fileNm == fileInfos[i].name && saveYn == "Y") {
					alert("이미 등록된 파일입니다.[" + fileInfos[i].name + "]");
					mpd_File.removeFile(fileInfos[i].name);
					continue;
				}
			}
		}
	}
};

/**
 * 멀티첨부파일 선택 후 실행되는 함수
 *
 * @param 	fileInfos		: 배열
 * @returns 	
 * @example fileLib.multiSelectCallback( mpd_File, dataList );
 */
fileLib.multiSelectCallback = function (mpd_File, dataList) {
	
	fileLib.checkFileDupDataList(mpd_File, dataList);
	var fileInfos = mpd_File.getFileInfos();
	var inputData = new Array();
	var rowCnt = dataList.getTotalRow();
	var checkCnt = 0;
	if (dataList.getTotalRow() == 0) {
		for (var i=0; i < fileInfos.length; i++) {
			dataList.setRowJSON(i, fileInfos[i] );
		}
	} else {
		for (var i=0; i < fileInfos.length; i++) {
			for(var j=0; j<rowCnt; j++) {
				checkCnt = 0;

				if (fileInfos[i].name == dataList.getCellData(j, "name")) {
					checkCnt++;
					break;
				} 
			} 
			
			if (checkCnt == 0) {
				dataList.setRowJSON(rowCnt+i, fileInfos[i] );
			}
		}
	}

};

/**
 * 첨부파일 삭체 처리
 *
 * @param 	ibx_File (File Input Box명), mpd_File (파일컨포넌트명), dataList(데이터리스트명), dlt_File(DataCollection명) 
 * @returns 	
 * @example 	fileLib.deleteFileList( ibx_ );
 */
fileLib.deleteFileList = function(ibx_File, mpf_File, dlt_File) {
	ibx_File.setValue( "" );
	mpf_File.removeAllFiles();
//	dataList.removeRow( 0 );
	dlt_file.removeAll();
};

/**
 * 멀티 첨부파일 삭체 처리 (저장전 삭제에만 해당함)
 *
 * @param 	ibx_File (File Input Box명), mpd_File (파일컨포넌트명), dataList(데이터리스트명), dlt_File(DataCollection명) 
 * @returns 	
 * @example 	fileLib.deleteFileList( ibx_ );
 */
fileLib.multiDeleteFileList = function(grd_MultiFile, mpd_File, dlt_File) {
	var idxArr = grd_MultiFile.getCheckedJSON("chk");
	var idxArr1 = grd_MultiFile.getCheckedIndex( "chk" );
	
	for( var i=0;i<idxArr.length;i++ ) {
		var fileName = idxArr[i].name;
		mpd_File.removeFile( fileName );
	}
	dlt_File.removeRows( idxArr1 );
};

/**
 * 파일 업로드 확장자 체크
 *
 * @param 		fileName		: file명
 * @returns 	    true/false
 * @example 	var check = fileLib.uploadFileExtCheck( fileName );
 */
fileLib.uploadFileExtCheck = function( fileName ){
	/* 첨부파일 확장자 검사
	*	허용 확장자 : gif, jpg, doc, xls, ppt, pdf, txt, xlsx, png, pptx, docx, jpeg, jsp (websquare.xml 설정값 )
	*/
	if ( fileName != "" ){
		var ext = fileName.slice(fileName.lastIndexOf(".")+1).toLowerCase();
		if (ext != "gif" && ext != "jpg"  && ext != "doc" && ext != "xls" && ext != "ppt" && 
				ext != "pdf" && ext != "txt" && ext != "xlsx" && ext != "png" && ext != "pptx" &&
				ext != "xml" && ext != "docx" && ext != "hwp" && ext != "shp" && ext != "shx" && 
				ext != "dbf" && ext != "dxf" && ext != "dwg" && ext != "ngi" && ext != "vi" &&
				ext != "mp4" && ext != "inp" && ext != "7z" && ext != "alz" && ext != "bmp" &&
				ext != "egg" && ext != "gul" && ext != "hwx" && ext != "ini" && ext != "lsb" &&
				ext != "lsm" && ext != "lsx" && ext != "lzh" && ext != "mht" && ext != "peg" &&
				ext != "rar" && ext != "tif" && ext != "vsd" && ext != "xlt" && ext != "xps" && 
				ext != "zip" && ext != "rpt" && ext != "inp" && ext != "rtp" && ext != "enc" &&
				ext != "evl" && ext != "kbid" && ext != "jpeg") {
			 comLib.alert($p, "등록 하실 수 없는 확장자입니다.(" + fileName + ")");
			 return false;
		}
	}

	return true;
};

/**
 * 파일 업로드 파일명 중복 체크
 *
 * @param 		genCompID	: generator 컴포넌트 ID
 * @param 		idx		: generator child index
 * @param 		fileName		: file명
 * @returns 	    true(정상)/false(중복)
 * @example 	var check = fileLib.uploadFileNmDupCheck( genCompID, idx, fileName );
 */
fileLib.uploadFileNmDupCheck = function( gen_uploadFile, idx, fileName ){
	
	for (var i=0; i<gen_uploadFile.getLength(); i++) {	// 파일명 중복 체크
		var objMpd = gen_uploadFile.getChild(i, "mpd_File");
		if (objMpd.id.indexOf(idx) >= 0) continue;
		if (objMpd.getFileCount() == 0) continue;
		
		if ( fileName != "" && fileName == objMpd.getFileInfos()[0].name ) {
			return false;
			break;
		}
	}
	
	return true;
};

/**
 * selectCallback 함수 만들기
 * @param idx : generator insertChild 리턴 값
 * @param cnt : generator getLength() - 1
 * @return Array : funcName, String
 */
fileLib.makeSelectCallback = function(idx, cnt) {
	var funcName = "selectCallback" + cnt;
	var arrRtn = [];
	var str = "";
	
	str += 'var ' + funcName + ' = function() { ';
	str += 'var arrFileInfo = gen_uploadFile_' + idx + '_mpd_File.getFileInfos(); ';
	str += 'if (!utilLib.isNull(arrFileInfo)) { ';
	str += '    if (gen_uploadFile_' + idx + '_mpd_File.getFileInfos().length > gen_uploadFile_' + idx + '_mpd_File.count) { ';	//selectCallback 2번째 파일 선택시
	str += '        gen_uploadFile_' + idx + '_mpd_File.removeFile( gen_uploadFile_' + idx + '_mpd_File.getFileInfos()[0].name ); ';
	str += '        gen_uploadFile_' + idx + '_txb_FileName.setValue( arrFileInfo[1].name ); ';
	str += '    } else { ';	//selectCallback 1번째 파일 선택시
	str += '        gen_uploadFile_' + idx + '_txb_FileName.setValue( arrFileInfo[0].name ); ';
	str += '    } ';
	str += '    var rtn = fileLib.uploadFileExtCheck( gen_uploadFile_' + idx + '_txb_FileName.getValue() ); '; //확장자 체크
	str += '    if (rtn == false) { ';
	str += '        gen_uploadFile_' + idx + '_mpd_File.removeFile( gen_uploadFile_' + idx + '_mpd_File.getFileInfos()[0].name ); ';
	str += '        gen_uploadFile_' + idx + '_txb_FileName.setValue( "" ); ';
	str += '    } ';
	str += '    rtn = fileLib.uploadFileNmDupCheck( gen_uploadFile, ' + idx + ', gen_uploadFile_' + idx + '_txb_FileName.getValue() ); '; //파일명 중복 체크
	str += '    if (rtn == false) { ';
	str += '    	 comLib.alert($p, "중복된 파일이 존재합니다. "); ';
	str += '        gen_uploadFile_' + idx + '_mpd_File.removeFile( gen_uploadFile_' + idx + '_mpd_File.getFileInfos()[0].name ); ';
	str += '        gen_uploadFile_' + idx + '_txb_FileName.setValue( "" ); ';
	str += '    } ';
	str += '} ';
	str += '};';
	
	arrRtn.push( funcName );
	arrRtn.push( str );
	
	return arrRtn;
};

/**
 * makeEvDone 함수 만들기
 * @param idx : generator insertChild 리턴 값
 * @param cnt : generator getLength() - 1
 * @return Array : funcName, String
 */
fileLib.makeEvDone = function(idx, cnt) {
	//denied => [{"deniedCode":"101","deniedFile":"개발.sql","file":null,"key":null,"localFile":null,"maxUploadSize":"200000000","size":null,"subSize":null}]
	//success => done=[{"deniedCode":"","deniedFile":"","file":"개발 - 복사본_2017-06-27(13 35 27).txt","key":null,"localFile":"개발 - 복사본.txt","maxUploadSize":"200000000","size":"231","subSize":null}]
	var funcName = "mpd_" + cnt +"_ondone";
	var arrRtn = [];
	var str = "";
	
	str += 'var ' + funcName + ' = function(data) { ';
//	str += 'console.log( " done=" + JSON.stringify(data) ); ';
	str += 'if (data[0].deniedCode == "101") { ';
	str += '    comLib.alert($p, "허용하지 않은 확장자입니다."); ';
	str += '} else if (data[0].deniedCode == "102") { ';
	str += '    comLib.alert($p, "최대 용량을 초과하였습니다."); ';
	str += '} else if (data[0].deniedCode == "999") { ';
	str += '    comLib.alert($p, "서버 에러입니다."); ';
	str += '} else { ';
	str += 'for (var i=gen_uploadFile.getLength()-1; i>=0; i--) { ';
	str += '	if (data[0].localFile == gen_uploadFile.getChild(i, "txb_FileName").getValue()) { ';
	str += '		var rowIndex = dlt_GenMpdFileInfos.insertRow(); ';
	str += '		dlt_GenMpdFileInfos.setCellData( rowIndex , "originlFileNm" , data[0].localFile ); ';
	str += '		dlt_GenMpdFileInfos.setCellData( rowIndex , "fileTempPath" , data[0].file ); ';
	str += '		eval("funcCallback" + (i+1) + "= undefined"); ';
	str += '		gen_uploadFile.removeChild( i ); ';
	str += '	} ';
	str += '} ';
	str += '} ';
	str += '}; ';
	
	arrRtn.push( funcName );
	arrRtn.push( str );
	
	return arrRtn;
};

/**
 * makeEvError 함수 만들기
 * @param idx : generator insertChild 리턴 값
 * @param cnt : generator getLength() - 1
 * @return Array : funcName, String
 */
fileLib.makeEvError = function(idx, cnt) {
	var funcName = "mpd_" + cnt +"_onerror";
	var arrRtn = [];
	var str = "";
	
	str += 'var ' + funcName + ' = function(data) { ';
	str += 'console.error( " error=" + data ); ';
	str += '}; ';
	
	arrRtn.push( funcName );
	arrRtn.push( str );
	
	return arrRtn;
};

/**
 * DataCollection 값 셋팅
 * @param dlt_File (저장할 DataCollection명)
 * @param tmpFileInfo (임시저장된 파일 정보)
 */
fileLib.dataListSetting = function(dlt_File, tmpFileInfo) {
	// 첨부파일 업로드 시, 파일 순번 뒤바뀌는 오류 해결 (2020-02-28, 공통팀 수정) [START]
	var data = fileLib.dataListSetting_syncTmpFileInfo(dlt_File, tmpFileInfo);
	// 첨부파일 업로드 시, 파일 순번 뒤바뀌는 오류 해결 (2020-02-28, 공통팀 수정) [END]

	var index = 0;
	var rowCnt = dlt_File.getTotalRow() - data.length; 
	for (var i = 0 ; i < data.length; i++) {
		if ( data[i].deniedCode == "" ) {
			/*
			if (dlt_File.getTotalRow() > 0) { 
				index = rowCnt+i;        
			} else {
				index = dlt_File.insertRow( );
			}
			*/
			for (var j=0; j < dlt_File.getTotalRow(); j++) {
				if (data[i].localFile == dlt_File.getCellData(j, "name")) {
					dlt_File.setCellData( j ,  "orginlFileNm" , data[i].localFile );  //원본파일명
					dlt_File.setCellData( j, "fileTmprPath", data[i].file);         //임시저장폴더에 저장된 파일명
				}
			}
		} else {
			if (data[i].deniedCode == "101") {
				alert ( data[i].deniedFile +"은/는 허용하지 않는 확장자입니다.");
			} else if (data[i].deniedCode == "102" ) {
				alert ( data[i].deniedFile + "은/는 파일사이즈를 초과입니다.");
			} else if (data[i].deniedCode == "999") {
				alert ( data[i].deniedFile + "은/는 기타 서버 오류가 발생하였습니다.");
			}              
			/*if (dlt_File.getTotalRow() > 0) {
				index = rowCnt+i;         // dataList에 이미 파일정보가 들어가 있기 때문에 -1을 함.
			} else {
				index = dlt_File.insertRow( );
			}*/
			dlt_File.removeRow(i);         //grid에 보였다 사라지는 단점이 있음. 
			return false;
		}
	}
	return true;
};

/**
 * DataCollection 값 셋팅 : 첨부파일 업로드 시, 파일 순번 뒤바뀌는 오류 해결 (2020-02-28, 공통팀 추가)
 * (화면에서 참조하고 있는 첨부파일 정보 (DataCollection) 의 순서에 맞게끔, 서버에 임시저장(업로드) 된 개별 파일 정보를 매핑 처리함)
 * @param dlt_File (저장할 DataCollection명)
 * @param tmpFileInfo (임시저장된 파일 정보)
 * @returns 순번 정렬된 임시저장 파일 정보 
 */
fileLib.dataListSetting_syncTmpFileInfo = function(dlt_File, tmpFileInfo) {
	var syncFileInfo = [];

	var dltRowCnt = dlt_File.getRowCount();
	var fileInfoCnt = tmpFileInfo.length;

	for (var i = 0; i < dltRowCnt; i++) {
		var fileNm = dlt_File.getCellData(i, "name");

		for (var j = 0; j < fileInfoCnt; j++) {
			if ( fileNm == tmpFileInfo[j].localFile ) {
				syncFileInfo.push(tmpFileInfo[j]);
			}
		}
	}

	return syncFileInfo;
};

/**
 * 멀티첨부파일 선택 후 실행되는 함수
 *
 * @param 	fileInfos		: 배열
 * @returns 	
 * @example fileLib.multiSelectCallback( mpd_File, dataList );
 */
fileLib.gridMultiSelectCallback = function (mpd_File, tempDataList, dataList, rowIdx) {
	
	fileLib.checkFileDupDataList(mpd_File, dataList);
	var fileInfos = mpd_File.getFileInfos();
	var inputData = new Array();
	var rowCnt = dataList.getTotalRow();
	var checkCnt = 0;
	if (dataList.getTotalRow() == 0) {
		for (var i=0; i < fileInfos.length; i++) {
			dataList.setRowJSON(i, fileInfos[i] );
			dataList.setCellData(i, "grdRowIdx", rowIdx); //화면 그리드의 focus가 있는 RowIndex
		}
	} else {
		for (var i=0; i < fileInfos.length; i++) {
			for(var j=0; j<rowCnt; j++) {
				checkCnt = 0;

				if (fileInfos[i].name == dataList.getCellData(j, "name")) {
					checkCnt++;
					break;
				} 
			} 
			
			if (checkCnt == 0) {
				rowCnt = dataList.getTotalRow();
				dataList.setRowJSON(rowCnt, fileInfos[i] );
				dataList.setCellData(rowCnt, "grdRowIdx", rowIdx);  //화면 그리드의 focus가 있는 RowIndex
			}
		}
	}
	// tempDataList에 선택된 rowIdx에 해당하는 데이터만 셋팅 (화면에 보여주기 위해)
	var tempRowIdx = 0;
	for (var i=0; i < dataList.getTotalRow(); i++) {
		if (rowIdx == dataList.getCellData(i, "grdRowIdx")) {
			tempDataList.setRowJSON(tempRowIdx, dataList.getRowJSON(i));
			tempRowIdx++;
		}
	}
};

/**
 * 총 업로드 용량 체크 (200MB 제한)
 *
 * @param mpdFiles: 배열
 * @returns 
 * @example fileSizeCheck( mpd_File);
 */
fileLib.fileSizeCheck = function(mpdFiles) {
   var totalSize = 0;
   var infos = mpdFiles.getFileInfos();
   for (var i = 0; i < infos.length; i++) {
       totalSize += Number(infos[i].size);
   }

   if (totalSize > 209715200) {
       alert ( "업로드 할 수 있는 총 용량은 200MB를 초과 할 수 없습니다." );
       var returnArr = mpdFiles.getFileNames();
       
       return false;
    } else {
       return true;
    }
};

/**
 * 컨포넌트 에러 발생시 dataCollection 초기화 시키기
 *
 * @param mpdFiles: 배열
 * @returns 
 * @example fileSizeCheck( mpd_File);
 */
fileLib.clearFileData = function(dltFile) {
	var dataCnt = dltFile.getTotalRow();

	for ( var i = dataCnt; i > 0; i--) {
		if (dltFile.getCellData( i-1 , "saveYn" ) != "Y" ) {
			dltFile.removeRow(i-1);
		}
	}
};
