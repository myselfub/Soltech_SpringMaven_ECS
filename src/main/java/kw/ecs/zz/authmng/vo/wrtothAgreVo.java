package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 사용자별 시스템권한관리 에 사용하는 Vo 클래스
 * @ClassName wrtothAgreVo.java
 * @Description  wrtothAgreVo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창 
 * @since  2017. 08. 08.
 * @version 1.0
 * @see  
 *  <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */

public class wrtothAgreVo extends DefaultVo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 사용자ID */
	private String usrId;
	/** 서약서동의일시 */
	private String wrtothAgreDt;
	
	private String wrtothAgreNo;
	private String docNo;
	private String aprvRequstNo;
	private String docCd;
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
	 * @return the wrtothAgreDt
	 */
	public String getWrtothAgreDt() {
		return wrtothAgreDt;
	}
	/**
	 * @param usrId the wrtothAgreDt to set
	 */
	public void setWrtothAgreDt(String wrtothAgreDt) {
		this.wrtothAgreDt = wrtothAgreDt;
	}
	public String getWrtothAgreNo() {
		return wrtothAgreNo;
	}
	public void setWrtothAgreNo(String wrtothAgreNo) {
		this.wrtothAgreNo = wrtothAgreNo;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getAprvRequstNo() {
		return aprvRequstNo;
	}
	public void setAprvRequstNo(String aprvRequstNo) {
		this.aprvRequstNo = aprvRequstNo;
	}
	public String getDocCd() {
		return docCd;
	}
	public void setDocCd(String docCd) {
		this.docCd = docCd;
	}
	
}
