package kw.ecs.cl.wthtexcclc.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 정산 - 수열 설비현황 VO
 * 
 * @ClassName WthtEqpSttusVo.java
 * @Description 수열 설비현황 VO
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
public class WthtEqpSttusVo extends ECSDefaultVo {
	private static final long serialVersionUID = -2947705196334232006L;

	/** ECS담당부서ID(부서) (NOT NULL) - ecsChrgDeptId(SUPER) */
	/** 항목구분명(구분) */
	private String iemDivNm;
	/** 수열공급개시일(공급개시) (NOT NULL) */
	private String wthtSuplyBeginDe = "";
	/** 설비명(건명) (NOT NULL) */
	private String eqpNm = "";
	/** 설비용량(설비용량(RT)) */
	private String eqpCpcty;
	/** 투자비용(투자비) */
	private String invtCst;
	/** 수열가용년수(내용년수) */
	private String wthtUsefulYycnt;
	/** 비고내용(비고) */
	private String rmCtnt;
	/** 수정사유 - updtRsn(SUPER) */

	/* ----- 조회조건 ----- */
	/** 조회시작날짜 - strtDt(SUPER) */
	/** 조회종료날짜 - endDt(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */

	/* ----- 조회결과 ----- */
	/** 수열경과년수(경과년수) : wthtElapseYycnt */

	public String getIemDivNm() {
		return iemDivNm;
	}

	public void setIemDivNm(String iemDivNm) {
		this.iemDivNm = iemDivNm;
	}

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

	public String getEqpCpcty() {
		return eqpCpcty;
	}

	public void setEqpCpcty(String eqpCpcty) {
		this.eqpCpcty = eqpCpcty;
	}

	public String getInvtCst() {
		return invtCst;
	}

	public void setInvtCst(String invtCst) {
		this.invtCst = invtCst;
	}

	public String getWthtUsefulYycnt() {
		return wthtUsefulYycnt;
	}

	public void setWthtUsefulYycnt(String wthtUsefulYycnt) {
		this.wthtUsefulYycnt = wthtUsefulYycnt;
	}

	public String getRmCtnt() {
		return rmCtnt;
	}

	public void setRmCtnt(String rmCtnt) {
		this.rmCtnt = rmCtnt;
	}

	@Override
	public String toString() {
		return "WthtEqpSttusVo [iemDivNm=" + iemDivNm + ", wthtSuplyBeginDe=" + wthtSuplyBeginDe + ", eqpNm=" + eqpNm
				+ ", eqpCpcty=" + eqpCpcty + ", invtCst=" + invtCst + ", wthtUsefulYycnt=" + wthtUsefulYycnt
				+ ", rmCtnt=" + rmCtnt + "], " + super.toString();
	}
}