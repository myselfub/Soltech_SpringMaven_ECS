package kw.ecs.me.cnvreqp.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 관리/폐기 - 비오차시험/변환장치 관리대장 VO(변환설비)
 * 
 * @ClassName CnvrEqpVo.java
 * @Description 비오차시험/변환장치 관리대장 VO(변환설비)
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
public class CnvrEqpVo extends ECSDefaultVo {
	private static final long serialVersionUID = -4127245292199254368L;

	/** ECS발전소구분코드(발전소) (NOT NULL) - ecsElcpwstnDivCd(SUPER) */
	/** 변환설비위치명(변환기 - 설치위치) (NOT NULL) */
	private String cnvrEqpLcNm = "";
	/** 변환설비명(변환기 - 설비명) (NOT NULL) */
	private String cnvrEqpNm = "";
	/** 항목코드(변환기 - 구분) (NOT NULL) */
	private String iemCd = "";
	/** 제조년도(변환기 - 제작년도) (NOT NULL) */
	private String mnfctYear = "";
	/** 설비수량값(변환기 - 수량) */
	private int eqpQtyVu;
	/** 오차시험이력년월(오차시험 (시험주기: T/D(2년), PT/CT(5년±6개월)) - 이력) */
	private String erorExamHistYm;
	/** 오차시험계획년월(오차시험 (시험주기: T/D(2년), PT/CT(5년±6개월)) - 계획) */
	private String erorExamPlanYm;
	/** 오차시험실적년월(오차시험 (시험주기: T/D(2년), PT/CT(5년±6개월)) - 실적) */
	private String erorExamAcmsltYm;
	/** 비고내용(비고) */
	private String rmCtnt;
	/** 수정사유 - updtRsn(SUPER) */

	public String getCnvrEqpLcNm() {
		return cnvrEqpLcNm;
	}

	public void setCnvrEqpLcNm(String cnvrEqpLcNm) {
		this.cnvrEqpLcNm = cnvrEqpLcNm;
	}

	public String getCnvrEqpNm() {
		return cnvrEqpNm;
	}

	public void setCnvrEqpNm(String cnvrEqpNm) {
		this.cnvrEqpNm = cnvrEqpNm;
	}

	public String getIemCd() {
		return iemCd;
	}

	public void setIemCd(String iemCd) {
		this.iemCd = iemCd;
	}

	public String getMnfctYear() {
		return mnfctYear;
	}

	public void setMnfctYear(String mnfctYear) {
		this.mnfctYear = mnfctYear;
	}

	public int getEqpQtyVu() {
		return eqpQtyVu;
	}

	public void setEqpQtyVu(int eqpQtyVu) {
		this.eqpQtyVu = eqpQtyVu;
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

	public String getErorExamAcmsltYm() {
		return erorExamAcmsltYm;
	}

	public void setErorExamAcmsltYm(String erorExamAcmsltYm) {
		this.erorExamAcmsltYm = erorExamAcmsltYm;
	}

	public String getRmCtnt() {
		return rmCtnt;
	}

	public void setRmCtnt(String rmCtnt) {
		this.rmCtnt = rmCtnt;
	}

	@Override
	public String toString() {
		return "CnvrEqpVo [cnvrEqpLcNm=" + cnvrEqpLcNm + ", cnvrEqpNm=" + cnvrEqpNm + ", iemCd=" + iemCd
				+ ", mnfctYear=" + mnfctYear + ", eqpQtyVu=" + eqpQtyVu + ", erorExamHistYm=" + erorExamHistYm
				+ ", erorExamPlanYm=" + erorExamPlanYm + ", erorExamAcmsltYm=" + erorExamAcmsltYm + ", rmCtnt=" + rmCtnt
				+ "], " + super.toString();
	}
}