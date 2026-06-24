package kw.ecs.me.mntmng.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 관리/폐기 - 에너지 관리 VO
 * 
 * @ClassName MntmngVo.java
 * @Description 에너지 관리 VO
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
public class MntmngVo extends ECSDefaultVo {
	private static final long serialVersionUID = -6422565343503840545L;

	/** 계약번호 (NOT NULL) */
	private String cntrctNo = "";
	/** ECS발전원구분코드 (NOT NULL) - ecsSetcscDivCd(SUPER) */
	/** 항목구분명(정산구분) */
	private String iemDivNm;
	/** 항목상세내용(내용) */
	private String iemDtlCtnt;
	/** 회계전표번호(회계전표) */
	private String accnutSlipNo;
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
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */

	/* ----- 조회결과 ----- */
	/** 유역명(유역) : basinNm */
	/** 발전원명(발전원) : setcscNm */
	/** 항목구분코드 : iemDivCd */
	/** 항목구분명(구분[수선유지비/개대체/점검정비]) : iemDivNm */
	/** 계약명 : ordgTit */
	/** 업무구분 : cntrctDivNm */

	/** 공사현장소재지정보(현장소재지) : cntrwkSptLocInfo */
	/** 착공일 : strwrkDe */
	/** 준공일 : competDe */
	/** 계약요청일유무 : cntrctRequstDeYn */
	/** 요청자부서코드(담당부서코드) : requstDeptCd */
	/** 요청자부서명(담당부서) : requstDeptNm */
	/** 요청자명(담당자) : rqstrNm */
	/** 발주부서명(발주부서) : cntrctDeptNm */
	/** 당기절대공사기간 : thstrmAbsltCntrwkPd */
	/** 도급공사비 : ctrCsct */
	/** 조달부가가치세 : prcureVat */
	/** 준공금액 : competam */
	/** 신규연차구분명(신규연차구분) : newOrdyrDivNm */
	/** 낙찰업체명(낙찰업체) : scsbidEntrpsNm */
	/** 관련문서 : reltDoc */
	/** 발주기안ID : ordgDrftId */
	/** 낙찰기안ID : scsbidDrftId */
	/** 계약기안ID : cntrctDrftId */
	/** 대점검 첨부파일명 : lrgeChckAtchflNm */
	/** 대점검 첨부파일 경로 : lrgeChckAtchFlpth */
	/** 분해점검 첨부파일명 : dcompChckAtchflNm */
	/** 분해점검 첨부파일 경로 : dcompChckAtchFlpth */

	/**
	설비위치 : eqpLc
	요청자 사원번호 : rqstrEmpno
	첨부파일명 ID : atchflId
	*/

	public String getCntrctNo() {
		return cntrctNo;
	}

	public void setCntrctNo(String cntrctNo) {
		this.cntrctNo = cntrctNo;
	}

	public String getIemDivNm() {
		return iemDivNm;
	}

	public void setIemDivNm(String iemDivNm) {
		this.iemDivNm = iemDivNm;
	}

	public String getIemDtlCtnt() {
		return iemDtlCtnt;
	}

	public void setIemDtlCtnt(String iemDtlCtnt) {
		this.iemDtlCtnt = iemDtlCtnt;
	}

	public String getAccnutSlipNo() {
		return accnutSlipNo;
	}

	public void setAccnutSlipNo(String accnutSlipNo) {
		this.accnutSlipNo = accnutSlipNo;
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
		return "MntmngVo [cntrctNo=" + cntrctNo + ", iemDivNm=" + iemDivNm + ", iemDtlCtnt=" + iemDtlCtnt
				+ ", accnutSlipNo=" + accnutSlipNo + ", lrgeChckAtchflNm=" + lrgeChckAtchflNm + ", lrgeChckAtchFlpth="
				+ lrgeChckAtchFlpth + ", dcompChckAtchflNm=" + dcompChckAtchflNm + ", dcompChckAtchFlpth="
				+ dcompChckAtchFlpth + "], " + super.toString();
	}
}