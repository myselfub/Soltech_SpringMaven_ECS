package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 권한별메뉴관리에 사용하는 Vo 클래스
 * @ClassName IntnAthrMenuVo.java
 * @Description  IntnAthrMenuVo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 08. 03.     60003048     최초생성
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창 
 * @since  2017. 08. 03.
 * @version 1.0
 * @see  
 *  <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */

public class IntnAthrMenuVo extends DefaultVo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** 권한명 */
	private String athrNm;
	/** 시스템구분코드 */
	private String intnSysDivCd;
	/** 메뉴ID */
	private String menuId;
	/** 메뉴명 */
	private String menuNm;
	/** 메뉴설명 */
	private String menuDc;
	/** 화면ID */
	private String scrinId;
	/** 화면명*/
	private String scrinNm;
	/** 권한부여 */
	private String grantYn;
	/** 버튼권한리스트 */
	private String btnAthrList;
	/** 적용시작일 */
	private String applcStrtDe;
	/** 적용종료일 */
	private String applcEndDe;

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
	public String getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return
	 */
	public String getMenuNm() {
		return menuNm;
	}

	/**
	 * @param menuNm
	 */
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	/**
	 * @return the menuDc
	 */
	public String getMenuDc() {
		return menuDc;
	}

	/**
	 * @param menuDc the menuDc to set
	 */
	public void setMenuDc(String menuDc) {
		this.menuDc = menuDc;
	}

	/**
	 * @return
	 */
	public String getScrinId() {
		return scrinId;
	}

	/**
	 * @param scrinId
	 */
	public void setScrinId(String scrinId) {
		this.scrinId = scrinId;
	}

	/**
	 * @return
	 */
	public String getScrinNm() {
		return scrinNm;
	}

	/**
	 * @param scrinNm
	 */
	public void setScrinNm(String scrinNm) {
		this.scrinNm = scrinNm;
	}

	/**
	 * @return
	 */
	public String getGrantYn() {
		return grantYn;
	}

	/**
	 * @param grantYn
	 */
	public void setGrantYn(String grantYn) {
		this.grantYn = grantYn;
	}

	/**
	 * @return
	 */
	public String getBtnAthrList() {
		return btnAthrList;
	}

	/**
	 * @param btnAthrList
	 */
	public void setBtnAthrList(String btnAthrList) {
		this.btnAthrList = btnAthrList;
	}

	/**
	 * @return
	 */
	public String getApplcStrtDe() {
		return applcStrtDe;
	}

	/**
	 * @param applcStrtDe
	 */
	public void setApplcStrtDe(String applcStrtDe) {
		this.applcStrtDe = applcStrtDe;
	}

	/**
	 * @return
	 */
	public String getApplcEndDe() {
		return applcEndDe;
	}

	/**
	 * @param applcEndDe
	 */
	public void setApplcEndDe(String applcEndDe) {
		this.applcEndDe = applcEndDe;
	}
}
