package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 권한그룹관리에 사용하는 Vo 클래스
 * @ClassName AthrGrpMngVo.java
 * @Description  AthrGrpMngVo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 6. 14.     60003048      최초생성
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창 
 * @since  2017. 6. 14.
 * @version 1.0
 * @see  
 *  <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */

public class AthrGrpMngVo extends DefaultVo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
		

	/** 시스템구분코드 */
	private String intnSysDivCd;
	/** 시스템구분명 */
	private String intnSysDivNm;
	/** 권한그룹명 */
	private String athrNm;
	/** 권한그룹설명 */
	private String athrDc;
	/** 사용여부 */
	private String useYn;
	/** 개인정보취급여부 */
	private String idvinfoDealYn;
	/** 최종수정정보 */
	private String lastInfo;

	/**
	 * @return
	 */
	public String getIntnSysDivCd() {
		return intnSysDivCd;
	}
	/**
	 * @param intnSysDivCd
	 */
	public void setIntnSysDivCd(String intnSysDivCd) {
		this.intnSysDivCd = intnSysDivCd;
	}
	/**
	 * @return
	 */
	public String getIntnSysDivNm() {
		return intnSysDivNm;
	}
	/**
	 * @param intnSysDivNm
	 */
	public void setIntnSysDivNm(String intnSysDivNm) {
		this.intnSysDivNm = intnSysDivNm;
	}
	/**
	 * @return
	 */
	public String getAthrNm() {
		return athrNm;
	}
	/**
	 * @param athrNm
	 */
	public void setAthrNm(String athrNm) {
		this.athrNm =athrNm;
	}
	/**
	 * @return
	 */
	public String getAthrDc() {
		return athrDc;
	}
	/**
	 * @param athrDc
	 */
	public void setAthrDc(String athrDc) {
		this.athrDc = athrDc;
	}
	/**
	 * @return
	 */
	public String getUseYn() {
		return useYn;
	}
	/**
	 * @param useYn
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	/**
	 * @return
	 */
	public String getIdvinfoDealYn() {
		return idvinfoDealYn;
	}
	/**
	 * @param idvinfoDealYn
	 */
	public void setIdvinfoDealYn(String idvinfoDealYn) {
		this.idvinfoDealYn = idvinfoDealYn;
	}
	/**
	 * @return
	 */
	public String getLastInfo() {
		return lastInfo;
	}
	/**
	 * @param lastInfo
	 */
	public void setLastInfo(String lastInfo) {
		this.lastInfo = lastInfo;
	}
}
