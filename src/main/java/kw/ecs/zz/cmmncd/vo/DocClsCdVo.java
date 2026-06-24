package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * DocClsCdVo VO 클래스
 * 
 * @ClassName DocClsCdVo.java
 * @Description 승인선정보상세에 사용하는 VO 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.06.26		60002841(권영훈)			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 권영훈
 * @since 2017. 06. 26.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
public class DocClsCdVo extends DefaultVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 레벨 */
	private String lv = "";
	/** 문서분류코드 */
	private String docClsCd = "";
	/** 문서분류명 */
	private String docClsNm = "";
	/** 상위분류코드 */
	private String upperDocClsCd = "";
	/** 시스템구분코드 */
	private String sysDivCd = "";
	/** 파일메인경로 */
	private String fileMainPath = "";
	/** 메뉴ID */
	private String menuId = "";

	public String getLv() {
		return lv;
	}

	public void setLv(String lv) {
		this.lv = lv;
	}

	public String getDocClsCd() {
		return docClsCd;
	}

	public void setDocClsCd(String docClsCd) {
		this.docClsCd = docClsCd;
	}

	public String getDocClsNm() {
		return docClsNm;
	}

	public void setDocClsNm(String docClsNm) {
		this.docClsNm = docClsNm;
	}

	public String getUpperDocClsCd() {
		return upperDocClsCd;
	}

	public void setUpperDocClsCd(String upperDocClsCd) {
		this.upperDocClsCd = upperDocClsCd;
	}

	public String getSysDivCd() {
		return sysDivCd;
	}

	public void setSysDivCd(String sysDivCd) {
		this.sysDivCd = sysDivCd;
	}

	public String getFileMainPath() {
		return fileMainPath;
	}

	public void setFileMainPath(String fileMainPath) {
		this.fileMainPath = fileMainPath;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
}