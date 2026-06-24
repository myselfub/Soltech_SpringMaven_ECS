package kw.ecs.me.mntmng.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 관리/폐기 - 에너지 예산집행 VO
 * 
 * @ClassName BudgetExcutVo.java
 * @Description 에너지 예산집행 VO
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.13		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 13
 * @version 1.0
 * 
 *          <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *          </pre>
 */
public class BudgetExcutVo extends ECSDefaultVo {
	private static final long serialVersionUID = 87119725152840913L;

	/** 전표번호(전표번호) */
	private String slipNo;
	/** ECS발전원구분코드 (NOT NULL) - ecsSetcscDivCd(SUPER) */
	/** ECS담당부서ID (NOT NULL) - ecsChrgDeptId(SUPER) */
	/** 항목제목내용(제목) */
	private String iemTitCtnt;
	/** 공급업체명(업체명) */
	private String entrpsNm;
	/** 전표전기일(전기일) */
	private String slipPstde;
	/** 집행금액(금액) */
	private String excutAmt;
	/** 합계금액(세금포함금액) */
	private String sumAmt;
	/** 담당자ID(담당자) */
	private String chargerId;
	/** 항목상세내용(내용) */
	private String iemDtlCtnt;
	/** 대점검 첨부파일명 */
	private String lrgeChckAtchflNm;
	/** 대점검 첨부파일 경로 */
	private String lrgeChckAtchFlpth;
	/** 분해점검 첨부파일명 */
	private String dcompChckAtchflNm;
	/** 분해점검 첨부파일 경로 */
	private String dcompChckAtchFlpth;
	/** 수정사유 - updtRsn(SUPER) */

	/* ----- 조회조건 ----- */
	/** 조회연도 - strtDt(SUPER) */

	/* ----- 조회결과 ----- */
	/** 부서명 : deptNm */
	/** 담당자명 : chargerNm */

	public String getSlipNo() {
		return slipNo;
	}

	public void setSlipNo(String slipNo) {
		this.slipNo = slipNo;
	}

	public String getIemTitCtnt() {
		return iemTitCtnt;
	}

	public void setIemTitCtnt(String iemTitCtnt) {
		this.iemTitCtnt = iemTitCtnt;
	}

	public String getEntrpsNm() {
		return entrpsNm;
	}

	public void setEntrpsNm(String entrpsNm) {
		this.entrpsNm = entrpsNm;
	}

	public String getSlipPstde() {
		return slipPstde;
	}

	public void setSlipPstde(String slipPstde) {
		this.slipPstde = slipPstde;
	}

	public String getExcutAmt() {
		return excutAmt;
	}

	public void setExcutAmt(String excutAmt) {
		this.excutAmt = excutAmt;
	}

	public String getSumAmt() {
		return sumAmt;
	}

	public void setSumAmt(String sumAmt) {
		this.sumAmt = sumAmt;
	}

	public String getChargerId() {
		return chargerId;
	}

	public void setChargerId(String chargerId) {
		this.chargerId = chargerId;
	}

	public String getIemDtlCtnt() {
		return iemDtlCtnt;
	}

	public void setIemDtlCtnt(String iemDtlCtnt) {
		this.iemDtlCtnt = iemDtlCtnt;
	}

	public String getLrgeChckAtchflNm() {
		return lrgeChckAtchflNm;
	}

	public void setLrgeChckAtchflNm(String lrgeChckAtchflNm) {
		this.lrgeChckAtchflNm = lrgeChckAtchflNm;
	}

	public String getLrgeChckAtchFlpth() {
		return lrgeChckAtchFlpth;
	}

	public void setLrgeChckAtchFlpth(String lrgeChckAtchFlpth) {
		this.lrgeChckAtchFlpth = lrgeChckAtchFlpth;
	}

	public String getDcompChckAtchflNm() {
		return dcompChckAtchflNm;
	}

	public void setDcompChckAtchflNm(String dcompChckAtchflNm) {
		this.dcompChckAtchflNm = dcompChckAtchflNm;
	}

	public String getDcompChckAtchFlpth() {
		return dcompChckAtchFlpth;
	}

	public void setDcompChckAtchFlpth(String dcompChckAtchFlpth) {
		this.dcompChckAtchFlpth = dcompChckAtchFlpth;
	}

	@Override
	public String toString() {
		return "BudgetExcutVo [slipNo=" + slipNo + ", iemTitCtnt=" + iemTitCtnt + ", entrpsNm=" + entrpsNm
				+ ", slipPstde=" + slipPstde + ", excutAmt=" + excutAmt + ", sumAmt=" + sumAmt + ", chargerId="
				+ chargerId + ", iemDtlCtnt=" + iemDtlCtnt + ", lrgeChckAtchflNm=" + lrgeChckAtchflNm
				+ ", lrgeChckAtchFlpth=" + lrgeChckAtchFlpth + ", dcompChckAtchflNm=" + dcompChckAtchflNm
				+ ", dcompChckAtchFlpth=" + dcompChckAtchFlpth + "], " + super.toString();
	}
}