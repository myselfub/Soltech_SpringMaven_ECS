package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * CtgryVo VO 클래스
 * 
 * @ClassName CtgryVo.java
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
public class CtgryVo extends DefaultVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 범주ID */
	private String ctgryId = "";
	/** 범주명 */
	private String ctgryNm = "";
	/** 범주사용여부 */
	private String ctgryUseYn = "";
	/** 지자체코드 */
	private String locgovCd = "";
	/** 범주구분코드 */
	private String ctgryDivCd = "";
	/** 상위범주ID */
	private String upperCtgryId = "";
	/** 레벨 */
	private String lv = "";

	public String getCtgryId() {
		return this.ctgryId;
	}

	public void setCtgryId(String ctgryId) {
		this.ctgryId = ctgryId;
	}

	public String getCtgryNm() {
		return this.ctgryNm;
	}

	public void setCtgryNm(String ctgryNm) {
		this.ctgryNm = ctgryNm;
	}

	public String getCtgryUseYn() {
		return this.ctgryUseYn;
	}

	public void setCtgryUseYn(String ctgryUseYn) {
		this.ctgryUseYn = ctgryUseYn;
	}

	public String getLocgovCd() {
		return this.locgovCd;
	}

	public void setLocgovCd(String locgovCd) {
		this.locgovCd = locgovCd;
	}

	public String getCtgryDivCd() {
		return this.ctgryDivCd;
	}

	public void setCtgryDivCd(String ctgryDivCd) {
		this.ctgryDivCd = ctgryDivCd;
	}

	public String getUpperCtgryId() {
		return this.upperCtgryId;
	}

	public void setUpperCtgryId(String upperCtgryId) {
		this.upperCtgryId = upperCtgryId;
	}

	public String getLv() {
		return lv;
	}

	public void setLv(String lv) {
		this.lv = lv;
	}

	public String toString() {
		return "ctgryId=" + this.ctgryId + "ctgryNm=" + this.ctgryNm + "ctgryUseYn=" + this.ctgryUseYn + "locgovCd="
				+ this.locgovCd + "ctgryDivCd=" + this.ctgryDivCd + "upperCtgryId=" + this.upperCtgryId;
	}
}