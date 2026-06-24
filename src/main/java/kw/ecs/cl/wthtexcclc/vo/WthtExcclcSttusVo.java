package kw.ecs.cl.wthtexcclc.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 정산 - 수열 정산현황 VO
 * 
 * @ClassName WthtExcclcSttusVo.java
 * @Description 수열 정산현황 VO
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.17		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 17
 * @version 1.0
 * 
 *          <pre>
 * Copyright (C) 2023 by Unlimited K-water; All right reserved.
 *          </pre>
 */
public class WthtExcclcSttusVo extends ECSDefaultVo {
	private static final long serialVersionUID = -2947705196334232006L;

	/* ----- 조회조건(FK) ----- */
	/** 수열공급개시일 (NOT NULL) */
	private String wthtSuplyBeginDe = "";
	/** 설비명 (NOT NULL) */
	private String eqpNm = "";

	/** 등록일(등록일자) (NOT NULL) */
	private String registDe = "";
	/** 계약명(건명) (NOT NULL) */
	private String cntrctNm = "";
	/** 계약용량(계약용량(RT)) */
	private String cntrctCpcty;
	/** 계약기간시작일 (NOT NULL) */
	private String ctrpdStrtDe = "";
	/** 계약기간종료일 (NOT NULL) */
	private String ctrpdEndDe = "";
	/** 공급가액(공급가액(원)) */
	private String splval;
	/** 부가가치세(부가세(원)) */
	private String vat;
	/** 정산금액(수익금액(원)) */
	private String excclcAmt;
	/** 사업구분명(사업구분) */
	private String bsnsDivNm;
	/** 시장구분명(시장구분) */
	private String mrktDivNm;
	/** 수정사유 - updtRsn(SUPER) */

	public String getWthtSuplyBeginDe() {
		return wthtSuplyBeginDe;
	}

	public void setWthtSuplyBeginDe(String wthtSuplyBeginDe) {
		this.wthtSuplyBeginDe = wthtSuplyBeginDe;
	}

	public String getEqpNm() {
		return eqpNm;
	}

	public void setEqpNm(String eqpNm) {
		this.eqpNm = eqpNm;
	}

	public String getRegistDe() {
		return registDe;
	}

	public void setRegistDe(String registDe) {
		this.registDe = registDe;
	}

	public String getCntrctNm() {
		return cntrctNm;
	}

	public void setCntrctNm(String cntrctNm) {
		this.cntrctNm = cntrctNm;
	}

	public String getCntrctCpcty() {
		return cntrctCpcty;
	}

	public void setCntrctCpcty(String cntrctCpcty) {
		this.cntrctCpcty = cntrctCpcty;
	}

	public String getCtrpdStrtDe() {
		return ctrpdStrtDe;
	}

	public void setCtrpdStrtDe(String ctrpdStrtDe) {
		this.ctrpdStrtDe = ctrpdStrtDe;
	}

	public String getCtrpdEndDe() {
		return ctrpdEndDe;
	}

	public void setCtrpdEndDe(String ctrpdEndDe) {
		this.ctrpdEndDe = ctrpdEndDe;
	}

	public String getSplval() {
		return splval;
	}

	public void setSplval(String splval) {
		this.splval = splval;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getExcclcAmt() {
		return excclcAmt;
	}

	public void setExcclcAmt(String excclcAmt) {
		this.excclcAmt = excclcAmt;
	}

	public String getBsnsDivNm() {
		return bsnsDivNm;
	}

	public void setBsnsDivNm(String bsnsDivNm) {
		this.bsnsDivNm = bsnsDivNm;
	}

	public String getMrktDivNm() {
		return mrktDivNm;
	}

	public void setMrktDivNm(String mrktDivNm) {
		this.mrktDivNm = mrktDivNm;
	}

	@Override
	public String toString() {
		return "WthtExcclcSttusVo [wthtSuplyBeginDe=" + wthtSuplyBeginDe + ", eqpNm=" + eqpNm + ", registDe=" + registDe
				+ ", cntrctNm=" + cntrctNm + ", cntrctCpcty=" + cntrctCpcty + ", ctrpdStrtDe=" + ctrpdStrtDe
				+ ", ctrpdEndDe=" + ctrpdEndDe + ", splval=" + splval + ", vat=" + vat + ", excclcAmt=" + excclcAmt
				+ ", bsnsDivNm=" + bsnsDivNm + ", mrktDivNm=" + mrktDivNm + "]";
	}
}