package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 사용자별 시스템권한관리 에 사용하는 Vo 클래스
 * @ClassName UsrAthrRqstVo.java
 * @Description  UsrAthrRqstVo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 08. 10.     60003048      최초생성
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창 
 * @since  2017. 08. 10.
 * @version 1.0
 * @see  
 *  <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */

public class UsrAthrRqstVo extends DefaultVo implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 신청순번 */
	private Integer rqstSeq;
	/** 사용자ID */
	private String usrId;
	/** 사용자명 */
	private String usrNm;
	/** 시스템구분코드 */
	private String intnSysDivCd;
	/** 권한 ID*/
	private String athrId;
	/** 권한명*/
	private String athrNm;
	/** 진행상태 */
	private String prgstsCd;
	/** 적용시작일 */
	private String applcStrtDe;
	/** 적용종료일 */
	private String applcEndDe;
	/** 통합신청순번ID */
	private String unifRqstSeq;
	/** 신청일*/
	private String rqstDt;
	/** 승인자ID */
	private String apprvrId;
	/** 승인자명 */
	private String apprvrNm;
	/** 승인일 */
	private String aprvDt;
	/** 취소일시 */
	private String canclDt;
	/** 시작일시 */
	private String strtDt;
	/** 종료일시 */
	private String endDt;
	
	/**업무구분코드**/
	private String intnBiznDivCd;

	/**
	 * @return the rqstSeq
	 */
	public Integer getRqstSeq() {
		return rqstSeq;
	}
	/**
	 * @param rqstSeq the rqstSeq to set
	 */
	public void setRqstSeq(Integer rqstSeq) {
		this.rqstSeq = rqstSeq;
	}
	/**
	 * @return the usrId
	 */
	public String getUsrId() {
		return usrId;
	}
	/**
	 * @param usrId the usrId to set
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * @return the usrNm
	 */
	public String getUsrNm() {
		return usrNm;
	}
	/**
	 * @param usrNm the usrNm to set
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	/**
	 * @return the intnSysDivCd
	 */
	public String getIntnSysDivCd() {
		return intnSysDivCd;
	}
	/**
	 * @param intnSysDivCd the intnSysDivCd to set
	 */
	public void setIntnSysDivCd(String intnSysDivCd) {
		this.intnSysDivCd = intnSysDivCd;
	}
	/**
	 * @return the athrId
	 */
	public String getAthrId() {
		return athrId;
	}
	/**
	 * @param athrId the athrId to set
	 */
	public void setAthrId(String athrId) {
		this.athrId = athrId;
	}
	/**
	 * @return the athrNm
	 */
	public String getAthrNm() {
		return athrNm;
	}
	/**
	 * @param athrNm the athrNm to set
	 */
	public void setAthrNm(String athrNm) {
		this.athrNm = athrNm;
	}
	/**
	 * @return the prgstsCd
	 */
	public String getPrgstsCd() {
		return prgstsCd;
	}
	/**
	 * @param prgstsCd the prgstsCd to set
	 */
	public void setPrgstsCd(String prgstsCd) {
		this.prgstsCd = prgstsCd;
	}
	/**
	 * @return the applcStrtDe
	 */
	public String getApplcStrtDe() {
		return applcStrtDe;
	}
	/**
	 * @param applcStrtDe the applcStrtDe to set
	 */
	public void setApplcStrtDe(String applcStrtDe) {
		this.applcStrtDe = applcStrtDe;
	}
	/**
	 * @return the applcEndDe
	 */
	public String getApplcEndDe() {
		return applcEndDe;
	}
	/**
	 * @param applcEndDe the applcEndDe to set
	 */
	public void setApplcEndDe(String applcEndDe) {
		this.applcEndDe = applcEndDe;
	}
	/**
	 * @return the unifRqstSeq
	 */
	public String getUnifRqstSeq() {
		return unifRqstSeq;
	}
	/**
	 * @param unifRqstSeq the unifRqstSeq to set
	 */
	public void setUnifRqstSeq(String unifRqstSeq) {
		this.unifRqstSeq = unifRqstSeq;
	}
	/**
	 * @return the rqstDt
	 */
	public String getRqstDt() {
		return rqstDt;
	}
	/**
	 * @param rqstDt the rqstDt to set
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	/**
	 * @return the apprvrId
	 */
	public String getApprvrId() {
		return apprvrId;
	}
	/**
	 * @param apprvrId the apprvrId to set
	 */
	public void setApprvrId(String apprvrId) {
		this.apprvrId = apprvrId;
	}
	/**
	 * @return the apprvrNm
	 */
	public String getApprvrNm() {
		return apprvrNm;
	}
	/**
	 * @param apprvrNm the apprvrNm to set
	 */
	public void setApprvrNm(String apprvrNm) {
		this.apprvrNm = apprvrNm;
	}
	/**
	 * @return the aprvDt
	 */
	public String getAprvDt() {
		return aprvDt;
	}
	/**
	 * @param aprvDt the aprvDt to set
	 */
	public void setAprvDt(String aprvDt) {
		this.aprvDt = aprvDt;
	}
	/**
	 * @return the canclDt
	 */
	public String getCanclDt() {
		return canclDt;
	}
	/**
	 * @param canclDt the canclDt to set
	 */
	public void setCanclDt(String canclDt) {
		this.canclDt = canclDt;
	}
	/**
	 * @return the strtDt
	 */
	public String getStrtDt() {
		return strtDt;
	}
	/**
	 * @param strtDt the strtDt to set
	 */
	public void setStrtDt(String strtDt) {
		this.strtDt = strtDt;
	}
	/**
	 * @return the endDt
	 */
	public String getEndDt() {
		return endDt;
	}
	/**
	 * @param endDt the endDt to set
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getIntnBiznDivCd() {
		return intnBiznDivCd;
	}
	public void setIntnBiznDivCd(String intnBiznDivCd) {
		this.intnBiznDivCd = intnBiznDivCd;
	}

}
