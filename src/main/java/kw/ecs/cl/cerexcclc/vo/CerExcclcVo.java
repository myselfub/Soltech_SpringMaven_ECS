package kw.ecs.cl.cerexcclc.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 정산 - CER 정산 VO
 * 
 * @ClassName CerExcclcVo.java
 * @Description CER 정산 VO
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
public class CerExcclcVo extends ECSDefaultVo {
	private static final long serialVersionUID = 7654753490622855396L;
	/** CER거래일(거래일자) (NOT NULL) */
	private String cerDelngDe = "";
	/** ECS발전소구분코드(발전소) (NOT NULL) - ecsElcpwstnDivCd(SUPER) */
	/** CER거래구분명(거래구분) (NOT NULL) */
	private String cerDelngDivNm = "";
	/** 종목명 (NOT NULL) */
	private String itemNm = "";
	/** CER거래단가(단가(원)) (NOT NULL) */
	private String cerDelngUpc = "";
	/** CER거래량(거래수량) (NOT NULL) */
	private String cerDelngQy = "";
	/** CER금액(거래금액(원)) */
	private String cerAmt;
	/** 시장구분명(시장구분) */
	private String mrktDivNm;
	/** 비고내용(비고(거래소)) */
	private String rmCtnt;
	/** 수정사유 - updtRsn(SUPER) */

	/* ----- 조회조건 ----- */
	/** 조회연도 - strtDt(SUPER) */

	/* ----- 조회결과 ----- */
	/** 발전소명 : elcpwstnNm */

	public String getCerDelngDe() {
		return cerDelngDe;
	}

	public void setCerDelngDe(String cerDelngDe) {
		this.cerDelngDe = cerDelngDe;
	}

	public String getCerDelngDivNm() {
		return cerDelngDivNm;
	}

	public void setCerDelngDivNm(String cerDelngDivNm) {
		this.cerDelngDivNm = cerDelngDivNm;
	}

	public String getItemNm() {
		return itemNm;
	}

	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}

	public String getCerDelngUpc() {
		return cerDelngUpc;
	}

	public void setCerDelngUpc(String cerDelngUpc) {
		this.cerDelngUpc = cerDelngUpc;
	}

	public String getCerDelngQy() {
		return cerDelngQy;
	}

	public void setCerDelngQy(String cerDelngQy) {
		this.cerDelngQy = cerDelngQy;
	}

	public String getCerAmt() {
		return cerAmt;
	}

	public void setCerAmt(String cerAmt) {
		this.cerAmt = cerAmt;
	}

	public String getMrktDivNm() {
		return mrktDivNm;
	}

	public void setMrktDivNm(String mrktDivNm) {
		this.mrktDivNm = mrktDivNm;
	}

	public String getRmCtnt() {
		return rmCtnt;
	}

	public void setRmCtnt(String rmCtnt) {
		this.rmCtnt = rmCtnt;
	}

	@Override
	public String toString() {
		return "CerExcclcVo [cerDelngDe=" + cerDelngDe + ", cerDelngDivNm=" + cerDelngDivNm + ", itemNm=" + itemNm
				+ ", cerDelngUpc=" + cerDelngUpc + ", cerDelngQy=" + cerDelngQy + ", cerAmt=" + cerAmt + ", mrktDivNm="
				+ mrktDivNm + ", rmCtnt=" + rmCtnt + "], " + super.toString();
	}
}