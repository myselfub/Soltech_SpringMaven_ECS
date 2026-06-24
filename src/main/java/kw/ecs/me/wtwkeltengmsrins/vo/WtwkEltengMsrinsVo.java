package kw.ecs.me.wtwkeltengmsrins.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 관리/폐기 - 수전 전력량계 관리 VO
 * 
 * @ClassName WtwkEltengMsrinsVo.java
 * @Description 수전 전력량계 관리 VO
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
public class WtwkEltengMsrinsVo extends ECSDefaultVo {
	private static final long serialVersionUID = -8085522151727966002L;

	/** ECS담당부서ID(부서) (NOT NULL) - ecsChrgDeptId(SUPER) */
	/** 자체시설명 (NOT NULL) */
	private String itslfFcltyNm = "";
	/** 제조년월 */
	private String mnfctrYm;
	/** 계량기점검이력년월(정도검사(7년) - 이력) */
	private String mrnrChckHistYm;
	/** 계량기점검계획년월(정도검사(7년) - 계획) */
	private String mrnrChckPlanYm;
	/** 전력량계측기고유번호(측정기기 고유번호) */
	private String eltengMsrinsIdnum = "";
	/** 계량기교체필요년도(교체필요 대상년월) */
	private String mrnrChgNeedYm;
	/** 비고내용(비고) */
	private String rmCtnt;
	/** 수정사유 - updtRsn(SUPER) */

	/* ----- 조회결과 ----- */
	/** 부서명 : deptNm */

	public String getItslfFcltyNm() {
		return itslfFcltyNm;
	}

	public void setItslfFcltyNm(String itslfFcltyNm) {
		this.itslfFcltyNm = itslfFcltyNm;
	}

	public String getMnfctrYm() {
		return mnfctrYm;
	}

	public void setMnfctrYm(String mnfctrYm) {
		this.mnfctrYm = mnfctrYm;
	}

	public String getMrnrChckHistYm() {
		return mrnrChckHistYm;
	}

	public void setMrnrChckHistYm(String mrnrChckHistYm) {
		this.mrnrChckHistYm = mrnrChckHistYm;
	}

	public String getMrnrChckPlanYm() {
		return mrnrChckPlanYm;
	}

	public void setMrnrChckPlanYm(String mrnrChckPlanYm) {
		this.mrnrChckPlanYm = mrnrChckPlanYm;
	}

	public String getEltengMsrinsIdnum() {
		return eltengMsrinsIdnum;
	}

	public void setEltengMsrinsIdnum(String eltengMsrinsIdnum) {
		this.eltengMsrinsIdnum = eltengMsrinsIdnum;
	}

	public String getMrnrChgNeedYm() {
		return mrnrChgNeedYm;
	}

	public void setMrnrChgNeedYm(String mrnrChgNeedYm) {
		this.mrnrChgNeedYm = mrnrChgNeedYm;
	}

	public String getRmCtnt() {
		return rmCtnt;
	}

	public void setRmCtnt(String rmCtnt) {
		this.rmCtnt = rmCtnt;
	}

	@Override
	public String toString() {
		return "WtwkEltengMsrinsVo [itslfFcltyNm=" + itslfFcltyNm + ", mnfctrYm=" + mnfctrYm + ", mrnrChckHistYm="
				+ mrnrChckHistYm + ", mrnrChckPlanYm=" + mrnrChckPlanYm + ", eltengMsrinsIdnum=" + eltengMsrinsIdnum
				+ ", mrnrChgNeedYm=" + mrnrChgNeedYm + ", rmCtnt=" + rmCtnt + "], " + super.toString();
	}
}