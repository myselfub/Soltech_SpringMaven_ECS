package kw.ecs.ec.energyacmsltmng.re100.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 에너지전주기 - 전력에너지실적현황 RE100 VO
 * 
 * @ClassName Re100Vo.java
 * @Description RE100 VO
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
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *          </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Re100Vo extends ECSDefaultVo {
	private static final long serialVersionUID = 4753214290483277501L;

	/** RE100년도 (NOT NULL) */
	private String re100Year = "";
	/** ECS발전소구분코드(발전소) (NOT NULL) - ecsElcpwstnDivCd(SUPER) */
	/** 항목명(항목) (NOT NULL) */
	private String iemNm = "";
	/** 1월항목값(1월) */
	private String mon01IemVu;
	/** 2월항목값(2월) */
	private String mon02IemVu;
	/** 3월항목값(3월) */
	private String mon03IemVu;
	/** 4월항목값(4월) */
	private String mon04IemVu;
	/** 5월항목값(5월) */
	private String mon05IemVu;
	/** 6월항목값(6월) */
	private String mon06IemVu;
	/** 7월항목값(7월) */
	private String mon07IemVu;
	/** 8월항목값(8월) */
	private String mon08IemVu;
	/** 9월항목값(9월) */
	private String mon09IemVu;
	/** 10월항목값(10월) */
	private String mon10IemVu;
	/** 11월항목값(11월) */
	private String mon11IemVu;
	/** 12월항목값(12월) */
	private String mon12IemVu;
	/** 수정사유 - updtRsn(SUPER) */

	/* ----- 조회조건 ----- */
	/** 조회시작날짜 - strtDt(SUPER) */
	/** 조회종료날짜 - endDt(SUPER) */

	/* ----- 조회결과 ----- */
	/** 조회연도 : strtDt(SUPER) */
	/** 발전원명(발전원) : setcscNm */
	/** ECS발전소구분명(구분) - ecsElcpwstnDivNm */
	/** 항목명(항목) - iemNm */
	/** 합계 : sum */
	/** 항목구분ID(구분) - iemDivId */
	/** 총계(값) - total */

	public String getRe100Year() {
		return re100Year;
	}

	public void setRe100Year(String re100Year) {
		this.re100Year = re100Year;
	}

	public String getIemNm() {
		return iemNm;
	}

	public void setIemNm(String iemNm) {
		this.iemNm = iemNm;
	}

	public String getMon01IemVu() {
		return mon01IemVu;
	}

	public void setMon01IemVu(String mon01IemVu) {
		this.mon01IemVu = mon01IemVu;
	}

	public String getMon02IemVu() {
		return mon02IemVu;
	}

	public void setMon02IemVu(String mon02IemVu) {
		this.mon02IemVu = mon02IemVu;
	}

	public String getMon03IemVu() {
		return mon03IemVu;
	}

	public void setMon03IemVu(String mon03IemVu) {
		this.mon03IemVu = mon03IemVu;
	}

	public String getMon04IemVu() {
		return mon04IemVu;
	}

	public void setMon04IemVu(String mon04IemVu) {
		this.mon04IemVu = mon04IemVu;
	}

	public String getMon05IemVu() {
		return mon05IemVu;
	}

	public void setMon05IemVu(String mon05IemVu) {
		this.mon05IemVu = mon05IemVu;
	}

	public String getMon06IemVu() {
		return mon06IemVu;
	}

	public void setMon06IemVu(String mon06IemVu) {
		this.mon06IemVu = mon06IemVu;
	}

	public String getMon07IemVu() {
		return mon07IemVu;
	}

	public void setMon07IemVu(String mon07IemVu) {
		this.mon07IemVu = mon07IemVu;
	}

	public String getMon08IemVu() {
		return mon08IemVu;
	}

	public void setMon08IemVu(String mon08IemVu) {
		this.mon08IemVu = mon08IemVu;
	}

	public String getMon09IemVu() {
		return mon09IemVu;
	}

	public void setMon09IemVu(String mon09IemVu) {
		this.mon09IemVu = mon09IemVu;
	}

	public String getMon10IemVu() {
		return mon10IemVu;
	}

	public void setMon10IemVu(String mon10IemVu) {
		this.mon10IemVu = mon10IemVu;
	}

	public String getMon11IemVu() {
		return mon11IemVu;
	}

	public void setMon11IemVu(String mon11IemVu) {
		this.mon11IemVu = mon11IemVu;
	}

	public String getMon12IemVu() {
		return mon12IemVu;
	}

	public void setMon12IemVu(String mon12IemVu) {
		this.mon12IemVu = mon12IemVu;
	}

	@Override
	public String toString() {
		return "Re100Vo [re100Year=" + re100Year + ", iemNm=" + iemNm + ", mon01IemVu=" + mon01IemVu + ", mon02IemVu="
				+ mon02IemVu + ", mon03IemVu=" + mon03IemVu + ", mon04IemVu=" + mon04IemVu + ", mon05IemVu="
				+ mon05IemVu + ", mon06IemVu=" + mon06IemVu + ", mon07IemVu=" + mon07IemVu + ", mon08IemVu="
				+ mon08IemVu + ", mon09IemVu=" + mon09IemVu + ", mon10IemVu=" + mon10IemVu + ", mon11IemVu="
				+ mon11IemVu + ", mon12IemVu=" + mon12IemVu + "], " + super.toString();
	}
}