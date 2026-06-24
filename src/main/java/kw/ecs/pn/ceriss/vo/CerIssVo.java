package kw.ecs.pn.ceriss.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 생산 - CER 발급량 VO
 * 
 * @ClassName CerIssVo.java
 * @Description CER 발급량 VO
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.15		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 15
 * @version 1.0
 * 
 *          <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *          </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CerIssVo extends ECSDefaultVo {
	private static final long serialVersionUID = -5562534358471732382L;

	/** ECS발전소구분코드(발전소) (NOT NULL) - ecsElcpwstnDivCd(SUPER) */
	/** CER거래구분명(구분) (NOT NULL) */
	private String cerDelngDivNm = "";
	/** CER모니터링시작년월(모니터링 시작연월) (NOT NULL) */
	private String cerMntrngStrtYm = "";
	/** CER모니터링종료년월(모니터링 종료연월) */
	private String cerMntrngEndYm;
	/** CER금액(CER 요청) */
	private String cerAmt;
	/** CER발급량(CER 발급 (2% 공제)) */
	private String cerIssQy;
	/** 비고내용(비고) */
	private String rmCtnt;
	/** 수정사유 - updtRsn(SUPER) */

	/* ----- 조회조건 ----- */
	/** 조회시작년도 - strtDt(SUPER) */
	/** 조회종료년도 - endDt(SUPER) */

	/* ----- 조회결과 ----- */
	/** 발전소명(발전소) - elcpwstnNm */
	/** 인증개월 - crtfcMons */

	public String getCerDelngDivNm() {
		return cerDelngDivNm;
	}

	public void setCerDelngDivNm(String cerDelngDivNm) {
		this.cerDelngDivNm = cerDelngDivNm;
	}

	public String getCerMntrngStrtYm() {
		return cerMntrngStrtYm;
	}

	public void setCerMntrngStrtYm(String cerMntrngStrtYm) {
		this.cerMntrngStrtYm = cerMntrngStrtYm;
	}

	public String getCerMntrngEndYm() {
		return cerMntrngEndYm;
	}

	public void setCerMntrngEndYm(String cerMntrngEndYm) {
		this.cerMntrngEndYm = cerMntrngEndYm;
	}

	public String getCerAmt() {
		return cerAmt;
	}

	public void setCerAmt(String cerAmt) {
		this.cerAmt = cerAmt;
	}

	public String getCerIssQy() {
		return cerIssQy;
	}

	public void setCerIssQy(String cerIssQy) {
		this.cerIssQy = cerIssQy;
	}

	public String getRmCtnt() {
		return rmCtnt;
	}

	public void setRmCtnt(String rmCtnt) {
		this.rmCtnt = rmCtnt;
	}

	@Override
	public String toString() {
		return "CerIssVo [cerDelngDivNm=" + cerDelngDivNm + ", cerMntrngStrtYm=" + cerMntrngStrtYm + ", cerMntrngEndYm="
				+ cerMntrngEndYm + ", cerAmt=" + cerAmt + ", cerIssQy=" + cerIssQy + ", rmCtnt=" + rmCtnt + "], "
				+ super.toString();
	}
}