package kw.ecs.me.elyrseltengmsrins.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 관리/폐기 - 발전 전력량계 관리 VO
 * 
 * @ClassName ElyrsEltengMsrinsVo.java
 * @Description 발전 전력량계 관리 VO
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElyrsEltengMsrinsVo extends ECSDefaultVo {
	private static final long serialVersionUID = 9157412155316343451L;

	/** ECS발전소구분코드(발전소) (NOT NULL) - ecsElcpwstnDivCd(SUPER) */
	/** 계량기명(계량기) (NOT NULL) */
	private String mrnrNm = "";
	/** 설비용량(설비용량(kW)) */
	private String eqpCpcty;
	/** 설비구분정보(주/비교) */
	private String eqpDivInfo;
	/** 제조년월 */
	private String mnfctrYm;
	/** 오차시험이력년월(오차시험 (3년6개월±6개월) - 이력) */
	private String erorExamHistYm;
	/** 오차시험계획년월(오차시험 (3년6개월±6개월) - 계획) */
	private String erorExamPlanYm;
	/** 국가검정이력년월(국가검정(7년) - 이력) */
	private String nationAthrzHistYm;
	/** 국가검정계획년월(국가검정(7년) - 계획) */
	private String nationAthrzPlanYm;
	/** CDM시험주기기간(CDM) */
	private String cdmExamCyclePd;
	/** CDM그룹ID(CDM그룹) */
	private String cdmGrpId;
	/** 비고내용(비고) */
	private String rmCtnt;
	/** 수정사유 - updtRsn(SUPER) */

	/* ----- 조회조건 ----- */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */
	/** ECS발전소구분코드(발전소) - ecsElcpwstnDivCd(SUPER) */

	/* ----- 조회결과 ----- */
	/** 발전원명(발전원) : setcscNm */
	/** 부서명(부서) : deptNm */
	/** 발전소명(발전소) : elcpwstnNm */

	public String getMrnrNm() {
		return mrnrNm;
	}

	public void setMrnrNm(String mrnrNm) {
		this.mrnrNm = mrnrNm;
	}

	public String getEqpCpcty() {
		return eqpCpcty;
	}

	public void setEqpCpcty(String eqpCpcty) {
		this.eqpCpcty = eqpCpcty;
	}

	public String getEqpDivInfo() {
		return eqpDivInfo;
	}

	public void setEqpDivInfo(String eqpDivInfo) {
		this.eqpDivInfo = eqpDivInfo;
	}

	public String getMnfctrYm() {
		return mnfctrYm;
	}

	public void setMnfctrYm(String mnfctrYm) {
		this.mnfctrYm = mnfctrYm;
	}

	public String getErorExamHistYm() {
		return erorExamHistYm;
	}

	public void setErorExamHistYm(String erorExamHistYm) {
		this.erorExamHistYm = erorExamHistYm;
	}

	public String getErorExamPlanYm() {
		return erorExamPlanYm;
	}

	public void setErorExamPlanYm(String erorExamPlanYm) {
		this.erorExamPlanYm = erorExamPlanYm;
	}

	public String getNationAthrzHistYm() {
		return nationAthrzHistYm;
	}

	public void setNationAthrzHistYm(String nationAthrzHistYm) {
		this.nationAthrzHistYm = nationAthrzHistYm;
	}

	public String getNationAthrzPlanYm() {
		return nationAthrzPlanYm;
	}

	public void setNationAthrzPlanYm(String nationAthrzPlanYm) {
		this.nationAthrzPlanYm = nationAthrzPlanYm;
	}

	public String getCdmExamCyclePd() {
		return cdmExamCyclePd;
	}

	public void setCdmExamCyclePd(String cdmExamCyclePd) {
		this.cdmExamCyclePd = cdmExamCyclePd;
	}

	public String getCdmGrpId() {
		return cdmGrpId;
	}

	public void setCdmGrpId(String cdmGrpId) {
		this.cdmGrpId = cdmGrpId;
	}

	public String getRmCtnt() {
		return rmCtnt;
	}

	public void setRmCtnt(String rmCtnt) {
		this.rmCtnt = rmCtnt;
	}

	@Override
	public String toString() {
		return "ElyrsEltengMsrinsVo [mrnrNm=" + mrnrNm + ", eqpCpcty=" + eqpCpcty + ", eqpDivInfo=" + eqpDivInfo
				+ ", mnfctrYm=" + mnfctrYm + ", erorExamHistYm=" + erorExamHistYm + ", erorExamPlanYm=" + erorExamPlanYm
				+ ", nationAthrzHistYm=" + nationAthrzHistYm + ", nationAthrzPlanYm=" + nationAthrzPlanYm
				+ ", cdmExamCyclePd=" + cdmExamCyclePd + ", cdmGrpId=" + cdmGrpId + ", rmCtnt=" + rmCtnt + "], "
				+ super.toString();
	}
}