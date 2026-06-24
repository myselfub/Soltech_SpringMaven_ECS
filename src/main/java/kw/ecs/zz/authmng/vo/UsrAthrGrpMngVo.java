package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 사용자 권한그룹에 사용하는 Vo 클래스
 * @ClassName UsrAthrGrpMngVo.java
 * @Description  UsrAthrGrpMngVo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 6. 22.     60003048      최초생성
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창 
 * @since  2017. 6. 22.
 * @version 1.0
 * @see  
 *  <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */

public class UsrAthrGrpMngVo extends DefaultVo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 권한ID */
	private String athrId;
	/** 권한명 */
	private String athrNm;
	/** 사용자ID */
	private String usrId;
	/** 사용자명 */
	private String usrNm;
	/** 사용자 사번 */
	private String usrEmpno;
	/** 사용자 부서코드 */
	private String usrDeptCd;
	/** 사용자 부서명 */
	private String usrDeptNm;
	/** 사용자 직위코드 */
	private String usrOfcpsCd;
	/** 사용자 직위명 */
	private String usrOfcpsNm;
	/** 사용자 직급코드 */
	private String usrJgrdCd;
	/** 사용자 직급명 */
	private String usrJgrdNm;	
	/** 그룹사용자명 */
	private String setGrpUsrNm;
	/** 적용시작일 */
	private String applcStrtDe;
	/** 적용종료일 */
	private String applcEndDe;
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
	 * @return the usrEmpno
	 */
	public String getUsrEmpno() {
		return usrEmpno;
	}
	/**
	 * @param usrEmpno the usrEmpno to set
	 */
	public void setUsrEmpno(String usrEmpno) {
		this.usrEmpno = usrEmpno;
	}
	/**
	 * @return the usrDeptCd
	 */
	public String getUsrDeptCd() {
		return usrDeptCd;
	}
	/**
	 * @param usrDeptCd the usrDeptCd to set
	 */
	public void setUsrDeptCd(String usrDeptCd) {
		this.usrDeptCd = usrDeptCd;
	}
	/**
	 * @return the usrDeptNm
	 */
	public String getUsrDeptNm() {
		return usrDeptNm;
	}
	/**
	 * @param usrDeptNm the usrDeptNm to set
	 */
	public void setUsrDeptNm(String usrDeptNm) {
		this.usrDeptNm = usrDeptNm;
	}
	/**
	 * @return the usrOfcpsCd
	 */
	public String getUsrOfcpsCd() {
		return usrOfcpsCd;
	}
	/**
	 * @param usrOfcpsCd the usrOfcpsCd to set
	 */
	public void setUsrOfcpsCd(String usrOfcpsCd) {
		this.usrOfcpsCd = usrOfcpsCd;
	}
	/**
	 * @return the usrOfcpsNm
	 */
	public String getUsrOfcpsNm() {
		return usrOfcpsNm;
	}
	/**
	 * @param usrOfcpsNm the usrOfcpsNm to set
	 */
	public void setUsrOfcpsNm(String usrOfcpsNm) {
		this.usrOfcpsNm = usrOfcpsNm;
	}
	/**
	 * @return the usrJgrdCd
	 */
	public String getUsrJgrdCd() {
		return usrJgrdCd;
	}
	/**
	 * @param usrJgrdCd the usrJgrdCd to set
	 */
	public void setUsrJgrdCd(String usrJgrdCd) {
		this.usrJgrdCd = usrJgrdCd;
	}
	/**
	 * @return the usrJgrdNm
	 */
	public String getUsrJgrdNm() {
		return usrJgrdNm;
	}
	/**
	 * @param usrJgrdNm the usrJgrdNm to set
	 */
	public void setUsrJgrdNm(String usrJgrdNm) {
		this.usrJgrdNm = usrJgrdNm;
	}
	/**
	 * @return the setGrpUsrNm
	 */
	public String getSetGrpUsrNm() {
		return setGrpUsrNm;
	}
	/**
	 * @param setGrpUsrNm the setGrpUsrNm to set
	 */
	public void setSetGrpUsrNm(String setGrpUsrNm) {
		this.setGrpUsrNm = setGrpUsrNm;
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
}
