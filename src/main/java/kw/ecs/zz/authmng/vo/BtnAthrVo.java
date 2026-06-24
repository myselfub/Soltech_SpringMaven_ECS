package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 시스템별 버튼 관리 사용하는 Vo 클래스
 * @ClassName BtnAthrVo.java
 * @Description  BtnAthrVo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 09. 04.     60003048      최초생성
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창 
 * @since  2017. 09. 04.
 * @version 1.0
 * @see  
 *  <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */

public class BtnAthrVo extends DefaultVo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** 내부시스템구분코드 */
	private String intnSysDivCd;
	/** 버튼순번 */
	private String btnSeq;
	/** 버튼명 */	
	private String btnNm;
	/** 권한값 */	
	private String btnAthrVu;
	/** 권한명 */	
	private String athrNm;

	/** 부서코드 */	
	private String usrDeptCd;

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
	public String getBtnSeq() {
		return btnSeq;
	}
	/**
	 * @param btnSeq
	 */
	public void setBtnSeq(String btnSeq) {
		this.btnSeq = btnSeq;
	}
	/**
	 * @return
	 */
	public String getBtnNm() {
		return btnNm;
	}
	/**
	 * @param btnNm
	 */
	public void setBtnNm(String btnNm) {
		this.btnNm = btnNm;
	}
	/**
	 * @return
	 */
	public String getBtnAthrVu() {
		return btnAthrVu;
	}
	/**
	 * @param btnAthrVu
	 */
	public void setBtnAthrVu(String btnAthrVu) {
		this.btnAthrVu = btnAthrVu;
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
		this.athrNm = athrNm;
	}	

	/**
	 * @return
	 */
	public String getUsrDeptCd() {
		return usrDeptCd;
	}
	/**
	 * @param usrDeptCd
	 */
	public void setUsrDeptCd(String usrDeptCd) {
		this.usrDeptCd = usrDeptCd;
	}		
}
