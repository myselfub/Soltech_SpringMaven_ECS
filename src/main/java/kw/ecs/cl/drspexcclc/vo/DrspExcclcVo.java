package kw.ecs.cl.drspexcclc.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 정산 - DR 정산 VO
 * 
 * @ClassName DrspExcclcVo.java
 * @Description DR 정산 VO
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
public class DrspExcclcVo extends ECSDefaultVo {
	private static final long serialVersionUID = 6430614942752535828L;
	/** 정산년도 (NOT NULL) */
	private String excclcYear = "";
	/** 사업장코드ID (NOT NULL) */
	private String bplcCdId = "";
	/** 항목명(기본금, 실적금) (NOT NULL) */
	private String iemNm = "";
	/** 1월항목값 */
	private String mon01IemVu;
	/** 2월항목값 */
	private String mon02IemVu;
	/** 3월항목값 */
	private String mon03IemVu;
	/** 4월항목값 */
	private String mon04IemVu;
	/** 5월항목값 */
	private String mon05IemVu;
	/** 6월항목값 */
	private String mon06IemVu;
	/** 7월항목값 */
	private String mon07IemVu;
	/** 8월항목값 */
	private String mon08IemVu;
	/** 9월항목값 */
	private String mon09IemVu;
	/** 10월항목값 */
	private String mon10IemVu;
	/** 11월항목값 */
	private String mon11IemVu;
	/** 12월항목값 */
	private String mon12IemVu;
	/** 추가정산금액(40시간 추가 정산금) */
	private String timeAddExcclcAmt;
	/** 수정사유 - updtRsn(SUPER) */

	/* ----- 조회조건 ----- */
	/** 조회연도 - strtDt(SUPER) */

	/* ----- 조회결과 ----- */
	/** 유역명(유역) - basinNm */
	/** 부서명(부서) - deptNm */
	/** 사업장명(사업장) : bplcNm */
	/** 정산금액총계(정산금총계) - excclcAmtTotal */
	/** 기본금액총계(기본금총계) - bassAmtTotal */
	/** 월별기본금액 1월(월별 기본금 - 1월) - bassAmtMon01 */
	/** 월별기본금액 2월(월별 기본금 - 2월) - bassAmtMon02 */
	/** 월별기본금액 3월(월별 기본금 - 3월) - bassAmtMon03 */
	/** 월별기본금액 4월(월별 기본금 - 4월) - bassAmtMon04 */
	/** 월별기본금액 5월(월별 기본금 - 5월) - bassAmtMon05 */
	/** 월별기본금액 6월(월별 기본금 - 6월) - bassAmtMon06 */
	/** 월별기본금액 7월(월별 기본금 - 7월) - bassAmtMon07 */
	/** 월별기본금액 8월(월별 기본금 - 8월) - bassAmtMon08 */
	/** 월별기본금액 9월(월별 기본금 - 9월) - bassAmtMon09 */
	/** 월별기본금액 10월(월별 기본금 - 10월) - bassAmtMon10 */
	/** 월별기본금액 11월(월별 기본금 - 1월) - bassAmtMon11 */
	/** 월별기본금액 12월(월별 기본금 - 12월) - bassAmtMon12 */
	/** 실적금액총계(실적금총계) - acmsltAmtTotal */
	/** 월별실적금액 1월(월별 실적금 - 1월) - acmsltAmtMon01 */
	/** 월별실적금액 2월(월별 실적금 - 2월) - acmsltAmtMon02 */
	/** 월별실적금액 3월(월별 실적금 - 3월) - acmsltAmtMon03 */
	/** 월별실적금액 4월(월별 실적금 - 4월) - acmsltAmtMon04 */
	/** 월별실적금액 5월(월별 실적금 - 5월) - acmsltAmtMon05 */
	/** 월별실적금액 6월(월별 실적금 - 6월) - acmsltAmtMon06 */
	/** 월별실적금액 7월(월별 실적금 - 7월) - acmsltAmtMon07 */
	/** 월별실적금액 8월(월별 실적금 - 8월) - acmsltAmtMon08 */
	/** 월별실적금액 9월(월별 실적금 - 9월) - acmsltAmtMon09 */
	/** 월별실적금액 10월(월별 실적금 - 10월) - acmsltAmtMon10 */
	/** 월별실적금액 11월(월별 실적금 - 11월) - acmsltAmtMon11 */
	/** 월별실적금액 12월(월별 실적금 - 12월) - acmsltAmtMon12 */

	public String getExcclcYear() {
		return excclcYear;
	}

	public void setExcclcYear(String excclcYear) {
		this.excclcYear = excclcYear;
	}

	public String getBplcCdId() {
		return bplcCdId;
	}

	public void setBplcCdId(String bplcCdId) {
		this.bplcCdId = bplcCdId;
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

	public String getTimeAddExcclcAmt() {
		return timeAddExcclcAmt;
	}

	public void setTimeAddExcclcAmt(String timeAddExcclcAmt) {
		this.timeAddExcclcAmt = timeAddExcclcAmt;
	}

	@Override
	public String toString() {
		return "DrspExcclcVo [excclcYear=" + excclcYear + ", bplcCdId=" + bplcCdId + ", iemNm=" + iemNm
				+ ", mon01IemVu=" + mon01IemVu + ", mon02IemVu=" + mon02IemVu + ", mon03IemVu=" + mon03IemVu
				+ ", mon04IemVu=" + mon04IemVu + ", mon05IemVu=" + mon05IemVu + ", mon06IemVu=" + mon06IemVu
				+ ", mon07IemVu=" + mon07IemVu + ", mon08IemVu=" + mon08IemVu + ", mon09IemVu=" + mon09IemVu
				+ ", mon10IemVu=" + mon10IemVu + ", mon11IemVu=" + mon11IemVu + ", mon12IemVu=" + mon12IemVu
				+ ", timeAddExcclcAmt=" + timeAddExcclcAmt + "], " + super.toString();
	}
}