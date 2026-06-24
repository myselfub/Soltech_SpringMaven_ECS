package kw.ecs.me.dsuse.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 관리/폐기 - 폐기 목록 VO
 * 
 * @ClassName DsuseVo.java
 * @Description 폐기 목록 VO
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
public class DsuseVo extends ECSDefaultVo {
	private static final long serialVersionUID = 444267448692731725L;

	/** 폐기고유ID (NOT NULL) */
	private String dsuseEsntlId = "";
	/** ECS발전원구분코드 - ecsSetcscDivCd(SUPER) */
	/** 폐기상세내용(폐기내용) */
	private String dsuseDtlCtnt;
	/** 설비용량 */
	private String eqpCpcty;
	/** CMS사업코드 */
	private String cmsBsnsCd;
	/** CMS프로젝트코드 */
	private String cmsPrjctCd;
	/** CMS프로젝트회차식별자 */
	private String cmsPrjctSqncIdtfr;
	/** 유역명(유역) */
	private String basinNm;
	/** 프로젝트명(폐기계약명) */
	private String ordgTit;
	/** 장단기구분명 */
	private String lnrtrDivNm;
	/** 사업구분명 */
	private String bsnsDivNm;
	/** 사업주관부서명(주관부서) */
	private String bsnsMngdeptNm;
	/** 시행부서명(담당부서) */
	private String edptNm;
	/** 시행부서담당자명(담당자 사원번호) */
	private String edptChargerId;
	/** 시행부서담당자명(담당자) */
	private String edptChargerNm;
	/** 착공일 */
	private String strwrkDe;
	/** 최종준공일(준공일) */
	private String lastCompetDe;
	/** 절대공사기간정보 */
	private String absltCntrwkPdInfo;
	/** 최종공사기간정보 */
	private String lastCntrwkPdInfo;
	/** 계약업체명(계약업체) */
	private String cntrctEntrpsNm;
	/** 대표자명(대표자) */
	private String entrpsRprsrNm;
	/** 현장소재지 */
	private String sptAddr;
	/** 준공금액 */
	private String competam;
	/** 프로젝트구분명 */
	private String prjctDivNm;
	/** 진행현황코드 */
	private String prgsSttusCd;
	/** 수정사유 - updtRsn(SUPER) */

	/* ----- 조회조건 ----- */
	/** 조회시작년도 - strtDt(SUPER) */
	/** 조회종료년도 - endDt(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */

	/* ----- 조회결과 ----- */
	/** 유역명(유역) : basinNm */
	/** 발전원명(발전원) : setcscNm */
	/** 프로젝트명(폐기계약명) : prjctNm */
	/** 장단기구분명 : lnrtrDivNm */
	/** 사업구분명 : bsnsDivNm */
	/** 사업주관부서명(주관부서) : bsnsMngdeptNm */
	/** 시행부서명(담당부서) : edptNm */
	/** 시행부서담당자명(담당자) : edptChargetNm */
	/** 착공일 : strwrkDe */
	/** 최종준공일(준공일) : lastCompetDe */
	/** 절대공사기간정보 : absltCntrwkPdInfo */
	/** 최종공사기간정보 : lastCntrwkPdInfo */
	/** 계약업체명(계약업체) : cntrctEntrpsNm */
	/** 대표자명(대표자) : entrpsRprsrNm */
	/** 현장소재지 : sptAddr */
	/** 준공금액 : competam */
	/** 프로젝트구분명 : prjctDivNm */
	/** 진행현황 : prgsSttus */

	public String getDsuseEsntlId() {
		return dsuseEsntlId;
	}

	public void setDsuseEsntlId(String dsuseEsntlId) {
		this.dsuseEsntlId = dsuseEsntlId;
	}

	public String getDsuseDtlCtnt() {
		return dsuseDtlCtnt;
	}

	public void setDsuseDtlCtnt(String dsuseDtlCtnt) {
		this.dsuseDtlCtnt = dsuseDtlCtnt;
	}

	public String getEqpCpcty() {
		return eqpCpcty;
	}

	public void setEqpCpcty(String eqpCpcty) {
		this.eqpCpcty = eqpCpcty;
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

	public String getBasinNm() {
		return basinNm;
	}

	public void setBasinNm(String basinNm) {
		this.basinNm = basinNm;
	}

	public String getOrdgTit() {
		return ordgTit;
	}

	public void setOrdgTit(String ordgTit) {
		this.ordgTit = ordgTit;
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

	public String getEdptNm() {
		return edptNm;
	}

	public void setEdptNm(String edptNm) {
		this.edptNm = edptNm;
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

	public String getPrjctDivNm() {
		return prjctDivNm;
	}

	public void setPrjctDivNm(String prjctDivNm) {
		this.prjctDivNm = prjctDivNm;
	}

	public String getPrgsSttusCd() {
		return prgsSttusCd;
	}

	public void setPrgsSttusCd(String prgsSttusCd) {
		this.prgsSttusCd = prgsSttusCd;
	}

	@Override
	public String toString() {
		return "DsuseVo [dsuseEsntlId=" + dsuseEsntlId + ", dsuseDtlCtnt=" + dsuseDtlCtnt + ", eqpCpcty=" + eqpCpcty
				+ ", cmsBsnsCd=" + cmsBsnsCd + ", cmsPrjctCd=" + cmsPrjctCd + ", cmsPrjctSqncIdtfr=" + cmsPrjctSqncIdtfr
				+ ", basinNm=" + basinNm + ", ordgTit=" + ordgTit + ", lnrtrDivNm=" + lnrtrDivNm + ", bsnsDivNm="
				+ bsnsDivNm + ", bsnsMngdeptNm=" + bsnsMngdeptNm + ", edptNm=" + edptNm + ", edptChargerId="
				+ edptChargerId + ", edptChargerNm=" + edptChargerNm + ", strwrkDe=" + strwrkDe + ", lastCompetDe="
				+ lastCompetDe + ", absltCntrwkPdInfo=" + absltCntrwkPdInfo + ", lastCntrwkPdInfo=" + lastCntrwkPdInfo
				+ ", cntrctEntrpsNm=" + cntrctEntrpsNm + ", entrpsRprsrNm=" + entrpsRprsrNm + ", sptAddr=" + sptAddr
				+ ", competam=" + competam + ", prjctDivNm=" + prjctDivNm + ", prgsSttusCd=" + prgsSttusCd + "], " + super.toString();
	}
}