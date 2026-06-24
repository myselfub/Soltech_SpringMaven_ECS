package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 권한관리 메뉴에 사용하는 Vo 클래스
 * @ClassName AuthorityMenuVo.java
 * @Description  AuthorityMenuVo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 6. 15.     60003048      최초생성
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창
 * @since  2017. 6. 15.
 * @version 1.0
 * @see  
 *  <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */

public class AuthorityMenuVo extends DefaultVo implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 권한자 코드 */	
	private String authorityCd;
	/** 메뉴코드 */
	private String menuCd;
	/** 권한자명 */	
	private String authorityNm;
	/** 사용여부 */
	private String isUse;
	/** 설명 */
	private String note;
	
	/**
	 * @return
	 */
	public String getAuthorityCd() {
		return authorityCd;
	}
	/**
	 * @param authorityCd
	 */
	public void setAuthorityCd(String authorityCd) {
		this.authorityCd = authorityCd;
	}
	/**
	 * @return
	 */
	public String getMenuCd() {
		return menuCd;
	}
	/**
	 * @param menuCd
	 */
	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}
	/**
	 * @return
	 */
	public String getAuthorityNm() {
		return authorityNm;
	}
	/**
	 * @param authorityNm
	 */
	public void setAuthorityNm(String authorityNm) {
		this.authorityNm = authorityNm;
	}
	/**
	 * @return
	 */
	public String getIsUse() {
		return isUse;
	}
	/**
	 * @param isUse
	 */
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	/**
	 * @return
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}
}
