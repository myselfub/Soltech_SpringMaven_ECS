package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 시스템별 버튼 관리 사용하는 Vo 클래스
 * @ClassName ScrinBtnVo.java
 * @Description  ScrinBtnVo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 09. 04.     60002727      최초생성
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 정보화표준 한재종 
 * @since  2017. 09. 04.
 * @version 1.0
 * @see  
 *  <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */

public class ScrinBtnVo extends DefaultVo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 내부시스템구분코드 */
	private String intnSysDivCd;
	/** 버튼순번 */
	private Integer btnSeq;
	/** 버튼명 */	
	private String btnNm;
	/** 권한값 */	
	private String btnAthrVu;
	/** 권한명 */	
	private String athrNm;
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
	 * @return the btnSeq
	 */
	public Integer getBtnSeq() {
		return btnSeq;
	}
	/**
	 * @param btnSeq the btnSeq to set
	 */
	public void setBtnSeq(Integer btnSeq) {
		this.btnSeq = btnSeq;
	}
	/**
	 * @return the btnNm
	 */
	public String getBtnNm() {
		return btnNm;
	}
	/**
	 * @param btnNm the btnNm to set
	 */
	public void setBtnNm(String btnNm) {
		this.btnNm = btnNm;
	}
	/**
	 * @return the btnAthrVu
	 */
	public String getBtnAthrVu() {
		return btnAthrVu;
	}
	/**
	 * @param btnAthrVu the btnAthrVu to set
	 */
	public void setBtnAthrVu(String btnAthrVu) {
		this.btnAthrVu = btnAthrVu;
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

}
