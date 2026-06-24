package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 메뉴등록에 사용하는 Vo 클래스
 * @ClassName MenuMngVo.java
 * @Description  MenuMngVo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 6. 15.     60003048     최초생성
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창 
 * @since  2017. 6. 15.
 * @version 1.0
 * @see  
 *  <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */

public class MenuMngVo extends DefaultVo implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 메뉴ID */
	private String menuId;
	/** 메뉴명 */
	private String menuNm;
	/** 메뉴시스템구분코드 */
	private String menuSysDivCd;
	/** 메뉴시스템구분코드명 */
	private String menuSysDivNm;
	/** 상위메뉴ID */
	private String upperMenuId;
	/** 상위메뉴명 */
	private String upperMenuNm;
	/** 메뉴정렬순서 */
	private String menuOrdr;
	/** 화면ID */
	private String scrinId;
	/** 화면명 */
	private String scrinNm;
	/** 메뉴레벨 */
	private String menuLvl;
	/** 메뉴설명 */
	private String menuDc;
	/** 팝업여부 */
	private String popupYn;
	/** 메뉴실행여부 */
	private String menuExecutYn;
	/** 메뉴사용여부 */
	private String useYn;
	/** 메뉴적용시작일자 */
	private String menuApplcDe;
	/** 메뉴적용종료일자 */
	private String menuEndDe;
	/** 호출URL */
	private String callParm;
	/** 1레벨 */
	private String fstLvl;
	/** 2레벨 */
	private String secLvl;
	/** 3레벨 */
	private String thrLvl;
	/** 최종수정정보 */
	private String lastInfo;
		
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
	 * @return
	 */
	public String getMenuSysdivCd() {
		return menuSysDivCd;
	}
	/**
	 * @param menuSysDivCd
	 */
	public void setMenuSysDivCd(String menuSysDivCd) {
		this.menuSysDivCd = menuSysDivCd;
	}	
	/**
	 * @return
	 */
	public String getMenuSysDivNm() {
		return menuSysDivNm;
	}
	/**
	 * @param menuSysDivNm
	 */
	public void setMenuSysDivNm(String menuSysDivNm) {
		this.menuSysDivNm = menuSysDivNm;
	}		
	/**
	 * @return
	 */
	public String getUpperMenuId() {
		return upperMenuId;
	}
	/**
	 * @param upperMenuId
	 */
	public void setUpperMenuId(String upperMenuId) {
		this.upperMenuId = upperMenuId;
	}
	/**
	 * @return
	 */
	public String getUpperMenuNm() {
		return upperMenuNm;
	}
	/**
	 * @param upperMenuNm
	 */
	public void setUpperMenuNm(String upperMenuNm) {
		this.upperMenuNm = upperMenuNm;
	}	
	/**
	 * @return
	 */
	public String getMenuOrdr() {
		return menuOrdr;
	}
	/**
	 * @param menuOrdr
	 */
	public void setMenuOrdr(String menuOrdr) {
		this.menuOrdr =menuOrdr;
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
	public String getMenuLvl() {
		return menuLvl;
	}
	/**
	 * @param menuLvl
	 */
	public void setMenuLvl(String menuLvl) {
		this.menuLvl = menuLvl;
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
	public String getMenuDc() {
		return menuDc;
	}
	/**
	 * @param menuDc
	 */
	public void setMenuDc(String menuDc) {
		this.menuDc = menuDc;
	}
	/**
	 * @return the popupYn
	 */
	public String getPopupYn() {
		return popupYn;
	}
	/**
	 * @param popupYn the popupYn to set
	 */
	public void setPopupYn(String popupYn) {
		this.popupYn = popupYn;
	}
	/**
	 * @return
	 */
	public String getMenuExecutYn() {
		return menuExecutYn;
	}
	/**
	 * @param menuExecutYn
	 */
	public void setMenuExecutYn(String menuExecutYn) {
		this.menuExecutYn = menuExecutYn;
	}	
	/**
	 * @return
	 */
	public String getMenuApplcDe() {
		return menuApplcDe;
	}
	/**
	 * @param menuApplcDe
	 */
	public void setMenuApplcDe(String menuApplcDe) {
		this.menuApplcDe = menuApplcDe;
	}	
	/**
	 * @return
	 */
	public String getMenuEndDe() {
		return menuEndDe;
	}
	/**
	 * @param menuEndDe
	 */
	public void setMenuEndDe(String menuEndDe) {
		this.menuEndDe = menuEndDe;
	}		
	/**
	 * @return
	 */
	public String getCallParm() {
		return callParm;
	}
	/**
	 * @param callParm
	 */
	public void setCallParm(String callParm) {
		this.callParm = callParm;
	}		
	/**
	 * @return
	 */
	public String getFstLvl() {
		return fstLvl;
	}
	/**
	 * @param fstLvl
	 */
	public void setFstLvl(String fstLvl) {
		this.fstLvl = fstLvl;
	}
	/**
	 * @return
	 */
	public String getSecLvl() {
		return secLvl;
	}
	/**
	 * @param secLvl
	 */
	public void setSecLvl(String secLvl) {
		this.secLvl = secLvl;
	}
	/**
	 * @return
	 */
	public String getThrLvl() {
		return thrLvl;
	}
	/**
	 * @param thrLvl
	 */
	public void setThrLvl(String thrLvl) {
		this.thrLvl = thrLvl;
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
