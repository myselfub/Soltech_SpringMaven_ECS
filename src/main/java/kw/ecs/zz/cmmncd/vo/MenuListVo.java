package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * MenuListVo VO 클래스
 * 
 * @ClassName MenuListVo.java
 * @Description 메뉴정보에 사용하는 VO 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.06.16		60003048(조영창)			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창
 * @since 2017. 06. 16.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
public class MenuListVo extends DefaultVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 메뉴시스템구분코드 */
	private String menuSysDivCd;
	/** 메뉴ID */
	private String menuId;
	/** 메뉴명 */
	private String menuNm;
	/** 메뉴정렬순서 */
	private String menuOrdr;
	/** 메뉴레벨 */
	private String menuLvl;

	public String getMenuSysDivCd() {
		return menuSysDivCd;
	}

	public void setMenuSysSeCd(String menuSysDivCd) {
		this.menuSysDivCd = menuSysDivCd;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	public String getMenuOrdr() {
		return menuOrdr;
	}

	public void setMenuOrdr(String menuOrdr) {
		this.menuOrdr = menuOrdr;
	}

	public String getMenuLvl() {
		return menuLvl;
	}

	public void setMenuLvl(String menuLvl) {
		this.menuLvl = menuLvl;
	}
}