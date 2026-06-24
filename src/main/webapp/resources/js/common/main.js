/* create by ux지원팀 이광 */
function onloadJS() {
	if (status == "SDI") {
		// alert("sdi");
		var tabObj = {closable:false, label : "메인"};
		var classObj = {src:"/ui/sample/samplel.xml"};
		tabc_layout.addTab("main", tabObj, classObj);

		scwin.tw_menu_onclick = function() {
			// treeview 클릭 시 신규 탭 추가
			if (tw_menu.isLeaf()) { // 트리뷰에 자식노드가 없으면 실행
				var tLabel = tw_menu.getSelectedLabel(); // 샌택된 노드 label값을 가져와서 변수에 담는다.
				var tValue = tw_menu.getSelectedValue(); // 선택된 노드 value값을 가져와서 변수에 담는다.

				if (tValue != "") { //받아온 value값이 비어있지않으면..
					var tabObj = { //json형태의 속성값을 tabObj 이용하여 설정
						closable : "true", //탭 닫기 기능 제공
						openAction : "exist", // exist 는 기존 탭을 갱신, new 는 항상 새로, select는 동일 id 가 존재하면 선택
						label : tLabel //label값은 tLabel변수의 값을 대입한다.
					};
					var classObj = { //json형태의 속성값을 classObj에서 설정
						contentsClass : "",
						src : tValue //탭콘테이너의 url은 treeview의 value에서 가져온다.
					};
					tabc_layout.addTab(tValue, tabObj, classObj);
					var tabindex = tabc_layout.getTabIndex(tValue);
					tabc_layout.setSelectedTabIndex(tabindex);
				}
			}

			if (tw_menu.getSelectedIndex() == 1) {
				// alert("1");
				tw_menu.spanAll(false);
			} else if (tw_menu.getSelectedIndex() == 20) {
				// alert("20");
				tw_menu.spanAll(false);
			} else if (tw_menu.getSelectedIndex() == 29) {
				// alert("29");
				tw_menu.spanAll(false);
			}
			tw_menu.expandNode(tw_menu.getSelectedIndex() , true);
		};

		scwin.tw_mymenu_onclick = function() {
			if (tw_mymenu.isLeaf()) { // 트리뷰에 자식노드가 없으면 실행
				var tLabel = tw_mymenu.getSelectedLabel(); // 샌택된 노드 label값을 가져와서 변수에 담는다.
				var tValue = tw_mymenu.getSelectedValue(); // 선택된 노드 value값을 가져와서 변수에 담는다.

				if (tValue != "") { //받아온 value값이 비어있지않으면..
					var tabObj = { //json형태의 속성값을 tabObj 이용하여 설정
						closable : "true", //탭 닫기 기능 제공
						openAction : "exist", // exist 는 기존 탭을 갱신, new 는 항상 새로, select는 동일 id 가 존재하면 선택
						label : tLabel //label값은 tLabel변수의 값을 대입한다.
					};
					var classObj = { //json형태의 속성값을 classObj에서 설정
						contentsClass : "",
						src : tValue //탭콘테이너의 url은 treeview의 value에서 가져온다.
					};

					tabc_layout.addTab(tValue, tabObj, classObj);
					var tabindex = tabc_layout.getTabIndex(tValue);
					tabc_layout.setSelectedTabIndex(tabindex);
				}
			}
		};

		scwin.closeall_onclick = function() {
			var cnt = tabc_layout.getTabCount();
			for(var i=cnt;i>=0;i--) {
				tabc_layout.deleteTab(i);
			}
		};
	} else if (status == "MDI") {
		// alert("mdi");
		scwin.tw_menu_onclick = function() {
			if (tw_menu.isLeaf()) {
				windowContainer1.createWindow(this.getSelectedLabel() , null , this.getSelectedValue());
			}
		};
		scwin.tw_mymenu_onclick = function() {
			if (tw_mymenu.isLeaf()) {
				windowContainer1.createWindow(this.getSelectedLabel() , null , this.getSelectedValue());
			}
		};
		scwin.closeAction = function(windowTitle) {
			if (windowTitle == "메인") {
				return false;
			}
			return true;
		};
	}
};

scwin.btnMenu_onclick = function() {
	var btnIDArr = this.getID().split("_");
	var s = btnIDArr[1];
	// btnMenu_01
	fn_addTab(s);
};

/* ************************* GNB event ******************************** */
function fn_addTab(s) {
	var num = s;
	if (status == "SDI") {
		if (num == "01") {
			tabc_layout.addTab("title", {closable:true, label : "01.title"}, {src:"/pattern/component/01.title.xml"});
		} else if (num == "02") {
			tabc_layout.addTab("button", {closable:true, label : "02.button"}, {src:"/pattern/component/02.button.xml"});
		} else if (num == "03") {
			tabc_layout.addTab("checkbox_radio", {closable:true, label : "03.checkbox_radio"}, {src:"/pattern/component/03.checkbox_radio.xml"});
		} else if (num == "04") {
			tabc_layout.addTab("table", {closable:true, label : "04.table"}, {src:"/pattern/component/04.table.xml"});
		} else if (num == "05") {
			tabc_layout.addTab("gridview", {closable:true, label : "05.gridview"}, {src:"/pattern/component/05.gridview.xml"});
		} else if (num == "06") {
			tabc_layout.addTab("searchbox", {closable:true, label : "06.searchbox"}, {src:"/pattern/component/06.searchbox.xml"});
		} else if (num == "07") {
			tabc_layout.addTab("groupbox", {closable:true, label : "07.groupbox"}, {src:"/pattern/component/07.groupbox.xml"});
		} else if (num == "08") {
			tabc_layout.addTab("icon_images", {closable:true, label : "08.icon_images"}, {src:"/pattern/component/08.icon_images.xml"});
		} else if (num == "09") {
			tabc_layout.addTab("pagelist", {closable:true, label : "09.pagelist"}, {src:"/pattern/component/09.pagelist.xml"});
		} else if (num == "10") {
			tabc_layout.addTab("tabcontrol", {closable:true, label : "10.tabcontrol"}, {src:"/pattern/component/10.tabcontrol.xml"});
		} else if (num == "11") {
			tabc_layout.addTab("inputcalendar_combobox", {closable:true, label : "11.inputcalendar_combobox"}, {src:"/pattern/component/11.inputcalendar_combo.xml"});
		} else if (num == "12") {
			tabc_layout.addTab("upload", {closable:true, label : "12.upload"}, {src:"/pattern/component/12.upload.xml"});
		} else if (num == "13") {
			tabc_layout.addTab("AutoComplete", {closable:true, label : "13.AutoComplete"}, {src:"/pattern/component/13.AutoComplete.xml"});
		} else if (num == "14") {
			tabc_layout.addTab("generator", {closable:true, label : "14.generator"}, {src:"/pattern/component/14.generator.xml"});
		} else if (num == "15") {
			tabc_layout.addTab("inputcalendar", {closable:true, label : "15.inputcalendar"}, {src:"/pattern/component/15.inputcalendar.xml"});
		} else if (num == "16") {
			tabc_layout.addTab("html5_layout", {closable:true, label : "16.html5_layout"}, {src:"/pattern/component/16.html5_layout.xml"});
		} else if (num == "17") {
			tabc_layout.addTab("html5_layout2", {closable:true, label : "17.html5_layout2"}, {src:"/pattern/component/17.html5_layout2.xml"});
		} else if (num == "18") {
			tabc_layout.addTab("treeview", {closable:true, label : "18.treeview"}, {src:"/pattern/component/18.treeview.xml"});
		} else if (num == "19") {
			tabc_layout.addTab("board_list", {closable:true, label : "19.board_list"}, {src:"/pattern/page/board_list.xml"});
		} else if (num == "20") {
			tabc_layout.addTab("board_read", {closable:true, label : "20.board_read"}, {src:"/pattern/page/board_read.xml"});
		} else if (num == "21") {
			tabc_layout.addTab("board_update", {closable:true, label : "21.board_update"}, {src:"/pattern/page/board_update.xml"});
		} else if (num == "22") {
			tabc_layout.addTab("board_write", {closable:true, label : "22.board_write"}, {src:"/pattern/page/board_write.xml"});
		} else if (num == "23") {
			tabc_layout.addTab("board_news_list", {closable:true, label : "23.board_news_list"}, {src:"/pattern/page/board_news_list.xml"});
		} else if (num == "24") {
			tabc_layout.addTab("board_photo_list", {closable:true, label : "24.board_photo_list"}, {src:"/pattern/page/board_photo_list.xml"});
		} else if (num == "25") {
			tabc_layout.addTab("layer_popup", {closable:true, label : "25.layer_popup"}, {src:"/pattern/page/layer_popup.xml"});
		} else if (num == "26") {
			tabc_layout.addTab("faq", {closable:true, label : "26.faq"}, {src:"/pattern/page/faq.xml"});
		} else if (num == "27") {
			tabc_layout.addTab("template01", {closable:true, label : "27.template01"}, {src:"/pattern/template/template01.xml"});
		} else if (num == "28") {
			tabc_layout.addTab("template02", {closable:true, label : "28.template02"}, {src:"/pattern/template/template02.xml"});
		} else if (num == "29") {
			tabc_layout.addTab("template03", {closable:true, label : "29.template03"}, {src:"/pattern/template/template03.xml"});
		} else if (num == "30") {
			tabc_layout.addTab("template04", {closable:true, label : "30.template04"}, {src:"/pattern/template/template04.xml"});
		} else if (num == "31") {
			tabc_layout.addTab("template05", {closable:true, label : "31.template05"}, {src:"/pattern/template/template05.xml"});
		} else if (num == "32") {
			tabc_layout.addTab("template06", {closable:true, label : "32.template06"}, {src:"/pattern/template/template06.xml"});
		} else if (num == "33") {
			tabc_layout.addTab("template07", {closable:true, label : "33.template07"}, {src:"/pattern/template/template07.xml"});
		} else if (num == "34") {
			tabc_layout.addTab("template08", {closable:true, label : "34.template08"}, {src:"/pattern/template/template08.xml"});
		} else if (num == "35") {
			tabc_layout.addTab("template09", {closable:true, label : "35.template09"}, {src:"/pattern/template/template09.xml"});
		} else if (num == "36") {
			tabc_layout.addTab("expand_01", {closable:true, label : "샘플(1)"}, {src:"/pattern/expand_01.xml"});
		} else if (num == "37") {
			tabc_layout.addTab("list_detail_01", {closable:true, label : "샘플(2)"}, {src:"/pattern/list_detail_01.xml"});
		}
		var idx = parseInt(tabc_layout.getTabCount())-1;
		tabc_layout.setSelectedTabIndex(idx);
	} else if (status == "MDI") {
		if (num == "01") {
			windowContainer1.createWindow("01.title", null, "/pattern/component/01.title.xml");
		} else if (num == "02") {
			windowContainer1.createWindow("02.button", null, "/pattern/component/02.button.xml");
		} else if (num == "03") {
			windowContainer1.createWindow("03.checkbox_radio", null, "/pattern/component/03.checkbox_radio.xml");
		} else if (num == "04") {
			windowContainer1.createWindow("04.table", null, "/pattern/component/04.table.xml");
		} else if (num == "05") {
			windowContainer1.createWindow("05.gridview", null, "/pattern/component/05.gridview.xml");
		} else if (num == "06") {
			windowContainer1.createWindow("06.searchbox", null, "/pattern/component/06.searchbox.xml");
		} else if (num == "07") {
			windowContainer1.createWindow("07.groupbox", null, "/pattern/component/07.groupbox.xml");
		} else if (num == "08") {
			windowContainer1.createWindow("08.icon_images", null, "/pattern/component/08.icon_images.xml");
		} else if (num == "09") {
			windowContainer1.createWindow("09.pagelist", null, "/pattern/component/09.pagelist.xml");
		} else if (num == "10") {
			windowContainer1.createWindow("10.tabcontrol", null, "/pattern/component/10.tabcontrol.xml");
		} else if (num == "11") {
			windowContainer1.createWindow("11.inputcalendar_combobox", null, "/pattern/component/11.inputcalendar_combo.xml");
		} else if (num == "12") {
			windowContainer1.createWindow("12.upload", null, "/pattern/component/12.upload.xml");
		} else if (num == "13") {
			windowContainer1.createWindow("13.AutoComplete", null, "/pattern/component/13.AutoComplete.xml");
		} else if (num == "14") {
			windowContainer1.createWindow("14.generator", null, "/pattern/component/14.generator.xml");
		} else if (num == "15") {
			windowContainer1.createWindow("15.inputcalendar", null, "/pattern/component/15.inputcalendar.xml");
		} else if (num == "16") {
			windowContainer1.createWindow("16.html5_layout", null, "/pattern/component/16.html5_layout.xml");
		} else if (num == "17") {
			windowContainer1.createWindow("17.html5_layout2", null, "/pattern/component/17.html5_layout2.xml");
		} else if (num == "18") {
			windowContainer1.createWindow("18.treeview", null, "/pattern/component/18.treeview.xml");
		} else if (num == "19") {
			windowContainer1.createWindow("19.board_list", null, "/pattern/page/board_list.xml");
		} else if (num == "20") {
			windowContainer1.createWindow("20.board_read", null, "/pattern/page/board_read.xml");
		} else if (num == "21") {
			windowContainer1.createWindow("21.board_update", null, "/pattern/page/board_update.xml");
		} else if (num == "22") {
			windowContainer1.createWindow("22.board_write", null, "/pattern/page/board_write.xml");
		} else if (num == "23") {
			windowContainer1.createWindow("23.board_news_list", null, "/pattern/page/board_news_list.xml");
		} else if (num == "24") {
			windowContainer1.createWindow("24.board_photo_list", null, "/pattern/page/board_photo_list.xml");
		} else if (num == "25") {
			windowContainer1.createWindow("25.layer_popup", null, "/pattern/page/layer_popup.xml");
		} else if (num == "26") {
			windowContainer1.createWindow("26.faq", null, "/pattern/page/faq.xml");
		} else if (num == "27") {
			windowContainer1.createWindow("27.template01", null, "/pattern/template/template01.xml");
		} else if (num == "28") {
			windowContainer1.createWindow("28.template02", null, "/pattern/template/template02.xml");
		} else if (num == "29") {
			windowContainer1.createWindow("29.template03", null, "/pattern/template/template03.xml");
		} else if (num == "30") {
			windowContainer1.createWindow("30.template04", null, "/pattern/template/template04.xml");
		} else if (num == "31") {
			windowContainer1.createWindow("31.template05", null, "/pattern/template/template05.xml");
		} else if (num == "32") {
			windowContainer1.createWindow("32.template06", null, "/pattern/template/template06.xml");
		} else if (num == "33") {
			windowContainer1.createWindow("33.template07", null, "/pattern/template/template07.xml");
		} else if (num == "34") {
			windowContainer1.createWindow("34.template08", null, "/pattern/template/template08.xml");
		} else if (num == "35") {
			windowContainer1.createWindow("35.template09", null, "/pattern/template/template09.xml");
		} else if (num == "36") {
			windowContainer1.createWindow("샘플(1)", null, "/pattern/expand_01.xml");
		} else if (num == "37") {
			windowContainer1.createWindow("샘플(2)", null, "/pattern/list_detail_01.xml");
		}
	}
	return;
};

scwin.aside_toggle_onclick = function() {
	container.toggleClass('sd_slide');
};

/* side menu tab */
scwin.as_menu_onclick = function() {
	as_tab.removeClass('mymn');
	sw_lnbbox.setSelectedIndex(0);
};

scwin.as_mymenu_onclick = function() {
	as_tab.addClass('mymn');
	sw_lnbbox.setSelectedIndex(1);
};

/* side change layout */
scwin.change_layout_onchange = function() {
	if (this.getValue() == "tabc") {
		$w.url("/ui/index_tabControl.xml");
	} else if (this.getValue() == "winc") {
		$w.url("/ui/index_windowContainer.xml");
	}
};

function initContents() {
	//******************************
	//상세조회 조회조건 showhide 토글
	//******************************
	var $srcArea = $(".tbl_search .w2tb");

	$srcArea.each(function(index) {
		var $tblTr = $srcArea.eq(index).children("tbody").children("tr");
		//화면구성이 2단구성 이상일 경우
		if ($srcArea.eq(index).parents().hasClass("lybox")) {
			//tr의 갯수를 세서 4줄 이상이면 초과하는 row를 hide 시킨다.
			$tblTr.each(function(index) {
				if (index >3) {
					$tblTr.eq(index).addClass("hide");
				}
			});
		} else { //화면이 1단 구성일 경우(wide일 경우)
			$tblTr.each(function(index) {
				if (index >1) {
					$tblTr.eq(index).addClass("hide");
				}
			});
		}

	});

	//상세조회 버튼을 클릭하면 버튼 클리스를 토글 & 조회조건 hide 토글
	$(".tbl_search .w2tb .btn_cm").click(function() {
		//alert("trr");
		$(this).toggleClass("close");
		$(this).parents(".tbl_search").find(".hide").toggleClass("table_cell");
	});
};