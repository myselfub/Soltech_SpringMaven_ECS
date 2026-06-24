package kw.ecs.pb.plancnstrc.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 계획/건설 - 계획/건설 목록 VO
 * 
 * @ClassName PlanCnstrcVo.java
 * @Description 계획/건설 VO
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
public class PlanCnstrcVo extends ECSDefaultVo {
	private static final long serialVersionUID = 4607984176727279512L;

	/* ----- 계획 ----- */
	/** 계획고유ID (NOT NULL) */
	private String planEsntlId = "";
	/** ECS발전원구분코드(발전원) - ecsSetcscDivCd(SUPER) */
	/** 계획사업명 */
	private String planBsnsNm;
	/** ECS담당부서ID - ecsChrgDeptId(SUPER) */
	/** 계획담당자사원번호 */
	private String planChargerEmpno;
	/** 계획수립일 */
	private String planFoundngDe;
	/** 계획설비용량 */
	private String planEqpCpcty;
	/** 계획금액 */
	private String planAmt;
	/** 비고내용(내용) */
	private String rmCtnt;
	/** 수정사유 - updtRsn(SUPER) */

	/* ----- 건설 ----- */
	/** 건설고유ID */
	private String cnstrcEsntlId = "";
	/** 건설설비용량 */
	private String cnstrcEqpCpcty;
	/** CMS사업코드 */
	private String cmsBsnsCd;
	/** CMS프로젝트코드 */
	private String cmsPrjctCd;
	/** CMS프로젝트회차식별자 */
	private String cmsPrjctSqncIdtfr;
	/** 프로젝트명(계약명) */
	// private String ordgTit;
	/** 장단기구분명 : lnrtrDivNm */
	private String lnrtrDivNm;
	/** 사업구분명 : bsnsDivNm */
	private String bsnsDivNm;
	/** 사업주관부서명(주관부서) : bsnsMngdeptNm */
	private String bsnsMngdeptNm;
	/** 시행부서명(건설담당부서) : edptNm */
	// private String edptNm;
	/** 시행부서담당자명(건설담당자 사번) : edptChargerId */
	private String edptChargerId;
	/** 시행부서담당자명(건설담당자) : edptChargerNm */
	private String edptChargerNm;
	/** 착공일 : strwrkDe */
	private String strwrkDe;
	/** 최종준공일(준공일) : lastCompetDe */
	private String lastCompetDe;
	/** 절대공사기간정보 : absltCntrwkPdInfo */
	private String absltCntrwkPdInfo;
	/** 최종공사기간정보 : lastCntrwkPdInfo */
	private String lastCntrwkPdInfo;
	/** 계약업체명(계약업체) : cntrctEntrpsNm */
	private String cntrctEntrpsNm;
	/** 대표자명(대표자) : entrpsRprsrNm */
	private String entrpsRprsrNm;
	/** 현장소재지 : sptAddr */
	private String sptAddr;
	/** 준공금액 : competam */
	private String competam;

	/* ----- 조회조건 ----- */
	/** 조회시작날짜 - strtDt(SUPER) */
	/** 조회종료날짜 - endDt(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** 국고지원여부(예산) */
	private String ntntrsSportYn;
	/** 진행현황코드 */
	private String prgsSttusCd;
	/** 프로젝트명(계약명) */
	private String ordgTit;
	/** 시행부서명(건설담당부서) */
	private String edptNm;

	/* ----- 조회결과 ----- */
	/** 발전원명(발전원) : setcscNm */
	/** 계획담당부서명(계획담당부서) : planChrgDeptNm */
	/** 계획담당자명(계획담당자) : planChargerNm */
	/** 장단기구분명 : lnrtrDivNm */
	/** 사업구분명 : bsnsDivNm */
	/** 사업주관부서명(주관부서) : bsnsMngdeptNm */
	/** 시행부서명(건설담당부서) : edptNm */
	/** 시행부서담당자명(건설담당자) : edptChargerNm */
	/** 착공일 : strwrkDe */
	/** 최종준공일(준공일) : lastCompetDe */
	/** 절대공사기간정보 : absltCntrwkPdInfo */
	/** 최종공사기간정보 : lastCntrwkPdInfo */
	/** 계약업체명(계약업체) : cntrctEntrpsNm */
	/** 대표자명(대표자) : entrpsRprsrNm */
	/** 현장소재지 : sptAddr */
	/** 준공금액 : competam */
	/** 진행현황 : prgsSttus */

	public String getPlanEsntlId() {
		return planEsntlId;
	}

	public void setPlanEsntlId(String planEsntlId) {
		this.planEsntlId = planEsntlId;
	}

	public String getPlanBsnsNm() {
		return planBsnsNm;
	}

	public void setPlanBsnsNm(String planBsnsNm) {
		this.planBsnsNm = planBsnsNm;
	}

	public String getPlanChargerEmpno() {
		return planChargerEmpno;
	}

	public void setPlanChargerEmpno(String planChargerEmpno) {
		this.planChargerEmpno = planChargerEmpno;
	}

	public String getPlanFoundngDe() {
		return planFoundngDe;
	}

	public void setPlanFoundngDe(String planFoundngDe) {
		this.planFoundngDe = planFoundngDe;
	}

	public String getPlanEqpCpcty() {
		return planEqpCpcty;
	}

	public void setPlanEqpCpcty(String planEqpCpcty) {
		this.planEqpCpcty = planEqpCpcty;
	}

	public String getPlanAmt() {
		return planAmt;
	}

	public void setPlanAmt(String planAmt) {
		this.planAmt = planAmt;
	}

	public String getRmCtnt() {
		return rmCtnt;
	}

	public void setRmCtnt(String rmCtnt) {
		this.rmCtnt = rmCtnt;
	}

	public String getCnstrcEsntlId() {
		return cnstrcEsntlId;
	}

	public void setCnstrcEsntlId(String cnstrcEsntlId) {
		this.cnstrcEsntlId = cnstrcEsntlId;
	}

	public String getCnstrcEqpCpcty() {
		return cnstrcEqpCpcty;
	}

	public void setCnstrcEqpCpcty(String cnstrcEqpCpcty) {
		this.cnstrcEqpCpcty = cnstrcEqpCpcty;
	}

	public String getCmsBsnsCd() {
		return cmsBsnsCd;
	}

	public void setCmsBsnsCd(String cmsBsnsCd) {
		this.cmsBsnsCd = cmsBsnsCd;
	}

	public String getCmsPrjctCd() {
		return cmsPrjctCd;
	}

	public void setCmsPrjctCd(String cmsPrjctCd) {
		this.cmsPrjctCd = cmsPrjctCd;
	}

	public String getCmsPrjctSqncIdtfr() {
		return cmsPrjctSqncIdtfr;
	}

	public void setCmsPrjctSqncIdtfr(String cmsPrjctSqncIdtfr) {
		this.cmsPrjctSqncIdtfr = cmsPrjctSqncIdtfr;
	}

	public String getLnrtrDivNm() {
		return lnrtrDivNm;
	}

	public void setLnrtrDivNm(String lnrtrDivNm) {
		this.lnrtrDivNm = lnrtrDivNm;
	}

	public String getBsnsDivNm() {
		return bsnsDivNm;
	}

	public void setBsnsDivNm(String bsnsDivNm) {
		this.bsnsDivNm = bsnsDivNm;
	}

	public String getBsnsMngdeptNm() {
		return bsnsMngdeptNm;
	}

	public void setBsnsMngdeptNm(String bsnsMngdeptNm) {
		this.bsnsMngdeptNm = bsnsMngdeptNm;
	}

	public String getEdptChargerId() {
		return edptChargerId;
	}

	public void setEdptChargerId(String edptChargerId) {
		this.edptChargerId = edptChargerId;
	}

	public String getEdptChargerNm() {
		return edptChargerNm;
	}

	public void setEdptChargerNm(String edptChargerNm) {
		this.edptChargerNm = edptChargerNm;
	}

	public String getStrwrkDe() {
		return strwrkDe;
	}

	public void setStrwrkDe(String strwrkDe) {
		this.strwrkDe = strwrkDe;
	}

	public String getLastCompetDe() {
		return lastCompetDe;
	}

	public void setLastCompetDe(String lastCompetDe) {
		this.lastCompetDe = lastCompetDe;
	}

	public String getAbsltCntrwkPdInfo() {
		return absltCntrwkPdInfo;
	}

	public void setAbsltCntrwkPdInfo(String absltCntrwkPdInfo) {
		this.absltCntrwkPdInfo = absltCntrwkPdInfo;
	}

	public String getLastCntrwkPdInfo() {
		return lastCntrwkPdInfo;
	}

	public void setLastCntrwkPdInfo(String lastCntrwkPdInfo) {
		this.lastCntrwkPdInfo = lastCntrwkPdInfo;
	}

	public String getCntrctEntrpsNm() {
		return cntrctEntrpsNm;
	}

	public void setCntrctEntrpsNm(String cntrctEntrpsNm) {
		this.cntrctEntrpsNm = cntrctEntrpsNm;
	}

	public String getEntrpsRprsrNm() {
		return entrpsRprsrNm;
	}

	public void setEntrpsRprsrNm(String entrpsRprsrNm) {
		this.entrpsRprsrNm = entrpsRprsrNm;
	}

	public String getSptAddr() {
		return sptAddr;
	}

	public void setSptAddr(String sptAddr) {
		this.sptAddr = sptAddr;
	}

	public String getCompetam() {
		return competam;
	}

	public void setCompetam(String competam) {
		this.competam = competam;
	}

	public String getNtntrsSportYn() {
		return ntntrsSportYn;
	}

	public void setNtntrsSportYn(String ntntrsSportYn) {
		this.ntntrsSportYn = ntntrsSportYn;
	}

	public String getPrgsSttusCd() {
		return prgsSttusCd;
	}

	public void setPrgsSttusCd(String prgsSttusCd) {
		this.prgsSttusCd = prgsSttusCd;
	}

	public String getOrdgTit() {
		return ordgTit;
	}

	public void setOrdgTit(String ordgTit) {
		this.ordgTit = ordgTit;
	}

	public String getEdptNm() {
		return edptNm;
	}

	public void setEdptNm(String edptNm) {
		this.edptNm = edptNm;
	}

	@Override
	public String toString() {
		return "PlanCnstrcVo [planEsntlId=" + planEsntlId + ", planBsnsNm=" + planBsnsNm + ", planChargerEmpno="
				+ planChargerEmpno + ", planFoundngDe=" + planFoundngDe + ", planEqpCpcty=" + planEqpCpcty
				+ ", planAmt=" + planAmt + ", rmCtnt=" + rmCtnt + ", cnstrcEsntlId=" + cnstrcEsntlId
				+ ", cnstrcEqpCpcty=" + cnstrcEqpCpcty + ", cmsBsnsCd=" + cmsBsnsCd + ", cmsPrjctCd=" + cmsPrjctCd
				+ ", cmsPrjctSqncIdtfr=" + cmsPrjctSqncIdtfr + ", lnrtrDivNm=" + lnrtrDivNm + ", bsnsDivNm=" + bsnsDivNm
				+ ", bsnsMngdeptNm=" + bsnsMngdeptNm + ", edptChargerId=" + edptChargerId + ", edptChargerNm="
				+ edptChargerNm + ", strwrkDe=" + strwrkDe + ", lastCompetDe=" + lastCompetDe + ", absltCntrwkPdInfo="
				+ absltCntrwkPdInfo + ", lastCntrwkPdInfo=" + lastCntrwkPdInfo + ", cntrctEntrpsNm=" + cntrctEntrpsNm
				+ ", entrpsRprsrNm=" + entrpsRprsrNm + ", sptAddr=" + sptAddr + ", competam=" + competam
				+ ", ntntrsSportYn=" + ntntrsSportYn + ", prgsSttusCd=" + prgsSttusCd + ", ordgTit=" + ordgTit + ", edptNm="
				+ edptNm + "], " + super.toString();
	}
}