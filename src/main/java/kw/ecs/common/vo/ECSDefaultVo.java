package kw.ecs.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kw.fw.defaults.DefaultVo;

/**
 * ECS VO 공통처리
 * 
 * @ClassName ECSDefaultVo.java
 * @Description ECS 공통 VO
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.05.11		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 05. 11
 * @version 1.0
 * 
 *          <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *          </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ECSDefaultVo extends DefaultVo {
	private static final long serialVersionUID = -2001624038455513821L;

	/** 조회조건 시작일시 */
	private String strtDt;
	/** 조회조건 종료일시 */
	private String endDt;
	/** 조회일 */
	private String inqireDe;
	/** 조회조건대상 */
	private String cnd;
	/** 조회조건대상 */
	private String cnd1;
	/** 조회조건대상 */
	private String cnd2;
	/** ECS유역구분코드(유역) */
	private String ecsBasinDivCd = "";
	/** ECS발전원구분코드(발전원) */
	private String ecsSetcscDivCd = "";
	/** ECS담당부서ID(부서/지사) */
	private String ecsChrgDeptId = "";
	/** ECS발전소구분코드(발전소) */
	private String ecsElcpwstnDivCd = "";
	/** ECS소비원구분코드(소비원) */
	private String ecsCnstscDivCd = "";
	/** 최초등록일시 */
	private String frstRegistDt;
	/** 최초등록자ID */
	private String frstRgstrId;
	/** 최종수정일시 */
	private String lastUpdtDt;
	/** 최종수정자ID */
	private String lastUpdusrId;
	/** 저장사유 */
	private String updtRsn;

	/* ----- 조회결과 ----- */
	/** 항목구분ID : iemDivId */
	/** 조회항목값 : inqireIemVu */

	public String getStrtDt() {
		return strtDt;
	}

	public void setStrtDt(String strtDt) {
		this.strtDt = strtDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getInqireDe() {
		return inqireDe;
	}

	public void setInqireDe(String inqireDe) {
		this.inqireDe = inqireDe;
	}

	public String getCnd() {
		return cnd;
	}

	public void setCnd(String cnd) {
		this.cnd = cnd;
	}

	public String getCnd1() {
		return cnd1;
	}

	public void setCnd1(String cnd1) {
		this.cnd1 = cnd1;
	}

	public String getCnd2() {
		return cnd2;
	}

	public void setCnd2(String cnd2) {
		this.cnd2 = cnd2;
	}

	public String getEcsBasinDivCd() {
		return ecsBasinDivCd;
	}

	public void setEcsBasinDivCd(String ecsBasinDivCd) {
		this.ecsBasinDivCd = ecsBasinDivCd;
	}

	public String getEcsSetcscDivCd() {
		return ecsSetcscDivCd;
	}

	public void setEcsSetcscDivCd(String ecsSetcscDivCd) {
		this.ecsSetcscDivCd = ecsSetcscDivCd;
	}

	public String getEcsChrgDeptId() {
		return ecsChrgDeptId;
	}

	public void setEcsChrgDeptId(String ecsChrgDeptId) {
		this.ecsChrgDeptId = ecsChrgDeptId;
	}

	public String getEcsElcpwstnDivCd() {
		return ecsElcpwstnDivCd;
	}

	public void setEcsElcpwstnDivCd(String ecsElcpwstnDivCd) {
		this.ecsElcpwstnDivCd = ecsElcpwstnDivCd;
	}

	public String getEcsCnstscDivCd() {
		return ecsCnstscDivCd;
	}

	public void setEcsCnstscDivCd(String ecsCnstscDivCd) {
		this.ecsCnstscDivCd = ecsCnstscDivCd;
	}

	public String getFrstRegistDt() {
		return frstRegistDt;
	}

	public void setFrstRegistDt(String frstRegistDt) {
		this.frstRegistDt = frstRegistDt;
	}

	public String getFrstRgstrId() {
		return frstRgstrId;
	}

	public void setFrstRgstrId(String frstRgstrId) {
		this.frstRgstrId = frstRgstrId;
	}

	public String getLastUpdtDt() {
		return lastUpdtDt;
	}

	public void setLastUpdtDt(String lastUpdtDt) {
		this.lastUpdtDt = lastUpdtDt;
	}

	public String getLastUpdusrId() {
		return lastUpdusrId;
	}

	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}

	public String getUpdtRsn() {
		return updtRsn;
	}

	public void setUpdtRsn(String updtRsn) {
		this.updtRsn = updtRsn;
	}

	@Override
	public String toString() {
		return "ECSDefaultVo [strtDt=" + strtDt + ", endDt=" + endDt + ", inqireDe=" + inqireDe + ", cnd=" + cnd
				+ ", cnd1=" + cnd1 + ", cnd2=" + cnd2 + ", ecsBasinDivCd=" + ecsBasinDivCd + ", ecsSetcscDivCd="
				+ ecsSetcscDivCd + ", ecsChrgDeptId=" + ecsChrgDeptId + ", ecsElcpwstnDivCd=" + ecsElcpwstnDivCd
				+ ", ecsCnstscDivCd=" + ecsCnstscDivCd + ", frstRegistDt=" + frstRegistDt + ", frstRgstrId="
				+ frstRgstrId + ", lastUpdtDt=" + lastUpdtDt + ", lastUpdusrId=" + lastUpdusrId + ", updtRsn=" + updtRsn
				+ "]";
	}
}