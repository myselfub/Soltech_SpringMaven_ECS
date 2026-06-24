package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 사용자별 시스템권한관리 에 사용하는 Vo 클래스
 * @ClassName UsrSysAthrVo.java
 * @Description  UsrSysAthrVo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 08. 08.     60003048      최초생성
 *  2017. 09. 21.     60003234      관리자구분 추가
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창 
 * @since  2017. 08. 08.
 * @version 1.0
 * @see  
 *  <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */

public class UsrSysAthrVo extends DefaultVo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 사용자ID */
	private String usrId;
	/** 관리자구분코드 */
	private String adminDivCd;
	/** 사용자명 */
	private String usrNm;
	/** 직무 */
	private String dtyNm;
	/** 접속IP */
	private String conectIp;
	/** 권한순서 */
	private Integer athrOrdr;
	/** 사용여부 */
	private String useYn;
	/** 시스템구분코드 */
	private String intnSysDivCd;
	/** 시스템구분명 */
	private String intnSysDivNm;
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
	 * @return the adminDivCd
	 */
	public String getAdminDivCd() {
		return adminDivCd;
	}
	/**
	 * @param adminDivCd the adminDivCd to set
	 */
	public void setAdminDivCd(String adminDivCd) {
		this.adminDivCd = adminDivCd;
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
	 * @return the dtyNm
	 */
	public String getDtyNm() {
		return dtyNm;
	}
	/**
	 * @param dtyNm the dtyNm to set
	 */
	public void setDtyNm(String dtyNm) {
		this.dtyNm = dtyNm;
	}
	/**
	 * @return the conectIp
	 */
	public String getConectIp() {
		return conectIp;
	}
	/**
	 * @param conectIp the conectIp to set
	 */
	public void setConectIp(String conectIp) {
		this.conectIp = conectIp;
	}
	/**
	 * @return the athrOrdr
	 */
	public Integer getAthrOrdr() {
		return athrOrdr;
	}
	/**
	 * @param athrOrdr the athrOrdr to set
	 */
	public void setAthrOrdr(Integer athrOrdr) {
		this.athrOrdr = athrOrdr;
	}
	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}
	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
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
	 * @return the intnSysDivNm
	 */
	public String getIntnSysDivNm() {
		return intnSysDivNm;
	}
	/**
	 * @param intnSysDivNm the intnSysDivNm to set
	 */
	public void setIntnSysDivNm(String intnSysDivNm) {
		this.intnSysDivNm = intnSysDivNm;
	}
}
