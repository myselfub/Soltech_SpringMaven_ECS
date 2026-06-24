package kw.ecs.zz.cmmn.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * ECS_전자문서 연계 VO
 * 
 * @ClassName CmmnEctccVo.java
 * @Description ECS_전자문서 연계
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.08.22		Soltech 정기석			최초생성
 *                           </pre>
 * 
 * @author Soltech 정기석
 * @since 2023. 08. 22
 * @version 1.0
 * 
 *          <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *          </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CmmnEctccVo extends ECSDefaultVo {
	private static final long serialVersionUID = 8233372740490159832L;

	/* ----- 조회 조건 ----- */
	/** 계획고유ID */
	private String planEsntlId;
	/** 건설고유ID */
	private String cnstrcEsntlId;
	/** 폐기고유ID */
	private String dsuseEsntlId;

	/* ----- 저장 데이터 ----- */
	/** 연계고유ID : 계획고유ID, 건설고유ID 등등. */
	private String lnkEsntlId;
	/** ECS사업진행구분코드 */
	private String ecsBsnsPrgsDivCd;
	/** 전자문서ID */
	private String ectccId;
	/** 전자문서제목 */
	private String ectccTit;
	/** 관련문서번호 */
	private String reltDocNo;
	/** 전자문서순번 */
	private String ectccSeq;
	/** 기안자 담당부서 코드 */
	private String drftDeptCd;
	/** 계획담당자사원번호 */
	private String drafterEmpno;
	/** 계획수립일 */
	private String drftDe;

	public String getPlanEsntlId() {
		return planEsntlId;
	}

	public void setPlanEsntlId(String planEsntlId) {
		this.planEsntlId = planEsntlId;
	}

	public String getCnstrcEsntlId() {
		return cnstrcEsntlId;
	}

	public void setCnstrcEsntlId(String cnstrcEsntlId) {
		this.cnstrcEsntlId = cnstrcEsntlId;
	}

	public String getDsuseEsntlId() {
		return dsuseEsntlId;
	}

	public void setDsuseEsntlId(String dsuseEsntlId) {
		this.dsuseEsntlId = dsuseEsntlId;
	}

	public String getLnkEsntlId() {
		return lnkEsntlId;
	}

	public void setLnkEsntlId(String lnkEsntlId) {
		this.lnkEsntlId = lnkEsntlId;
	}

	public String getEcsBsnsPrgsDivCd() {
		return ecsBsnsPrgsDivCd;
	}

	public void setEcsBsnsPrgsDivCd(String ecsBsnsPrgsDivCd) {
		this.ecsBsnsPrgsDivCd = ecsBsnsPrgsDivCd;
	}

	public String getEctccId() {
		return ectccId;
	}

	public void setEctccId(String ectccId) {
		this.ectccId = ectccId;
	}

	public String getEctccTit() {
		return ectccTit;
	}

	public void setEctccTit(String ectccTit) {
		this.ectccTit = ectccTit;
	}

	public String getReltDocNo() {
		return reltDocNo;
	}

	public void setReltDocNo(String reltDocNo) {
		this.reltDocNo = reltDocNo;
	}

	public String getEctccSeq() {
		return ectccSeq;
	}

	public void setEctccSeq(String ectccSeq) {
		this.ectccSeq = ectccSeq;
	}

	public String getDrftDeptCd() {
		return drftDeptCd;
	}

	public void setDrftDeptCd(String drftDeptCd) {
		this.drftDeptCd = drftDeptCd;
	}

	public String getDrafterEmpno() {
		return drafterEmpno;
	}

	public void setDrafterEmpno(String drafterEmpno) {
		this.drafterEmpno = drafterEmpno;
	}

	public String getDrftDe() {
		return drftDe;
	}

	public void setDrftDe(String drftDe) {
		this.drftDe = drftDe;
	}

	@Override
	public String toString() {
		return "CmmnEctccVo [planEsntlId=" + planEsntlId + ", cnstrcEsntlId=" + cnstrcEsntlId + ", dsuseEsntlId="
				+ dsuseEsntlId + ", lnkEsntlId=" + lnkEsntlId + ", ecsBsnsPrgsDivCd=" + ecsBsnsPrgsDivCd + ", ectccId="
				+ ectccId + ", ectccTit=" + ectccTit + ", reltDocNo=" + reltDocNo + ", ectccSeq=" + ectccSeq
				+ ", drftDeptCd=" + drftDeptCd + ", drafterEmpno=" + drafterEmpno + ", drftDe=" + drftDe + "], "
				+ super.toString();
	}
}
