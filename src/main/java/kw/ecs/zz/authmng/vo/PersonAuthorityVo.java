/**
 * 개인 권한에 사용하는 Vo 클래스
 * @ClassName PersonAuthorityVo.java
 * @Description  PersonAuthorityVo.java Class 
 * @Modification-Information
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 7. 20.     60002841(권영훈)   최초생성
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 권영훈 
 * @since  2017. 7. 20.
 * @version 1.0
 * 
 *  Copyright (C) 2017 by Unlimited K-water, All right reserved.
 */

package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

public class PersonAuthorityVo extends DefaultVo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 메뉴시스템구분코드 */
	private String menuSysDivCd;
	/** 메뉴ID */
	private String menuId;
	/** 화면ID */
	private String scrinId;
	/** 화면URL */
	private String scrinUrl;
	/** 메뉴명 */
	private String menuNm;
	/** 메뉴레벨 */
	private String menuLvl;
	/** 상위메뉴ID */
	private String upperMenuId;
	/** 메뉴순서 */
	private String menuOrdr;
	/** 메뉴실행유무 */
	private String menuExecutYn;
	/** 메뉴신청일 */
	private String menuApplcDe;
	/** 메뉴완료일 */
	private String menuEndDe;
	/** 조회권한값 */
	private String inqireAthrVu;
	/** 저장권한값 */
	private String saveAthrVu;
	/** 삭제권한값 */
	private String delAthrVu;
	/** 출력권한값 */
	private String outptAthrVu;
	/** 엑셀다운로드권한값 */
	private String excelDwldAthrVu;
	/** 승인권한값 */
	private String aprvAthrVu;
	/** 승인취소권한값 */
	private String aprvCanclAthrVu;
	/**
	 * @return the menuSysDivCd
	 */
	public String getMenuSysDivCd() {
		return menuSysDivCd;
	}
	/**
	 * @param menuSysDivCd the menuSysDivCd to set
	 */
	public void setMenuSysDivCd(String menuSysDivCd) {
		this.menuSysDivCd = menuSysDivCd;
	}
	/**
	 * @return the menuId
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * @return the scrinId
	 */
	public String getScrinId() {
		return scrinId;
	}
	/**
	 * @param scrinId the scrinId to set
	 */
	public void setScrinId(String scrinId) {
		this.scrinId = scrinId;
	}
	/**
	 * @return the scrinUrl
	 */
	public String getScrinUrl() {
		return scrinUrl;
	}
	/**
	 * @param scrinUrl the scrinUrl to set
	 */
	public void setScrinUrl(String scrinUrl) {
		this.scrinUrl = scrinUrl;
	}
	/**
	 * @return the menuNm
	 */
	public String getMenuNm() {
		return menuNm;
	}
	/**
	 * @param menuNm the menuNm to set
	 */
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	/**
	 * @return the menuLvl
	 */
	public String getMenuLvl() {
		return menuLvl;
	}
	/**
	 * @param menuLvl the menuLvl to set
	 */
	public void setMenuLvl(String menuLvl) {
		this.menuLvl = menuLvl;
	}
	/**
	 * @return the upperMenuId
	 */
	public String getUpperMenuId() {
		return upperMenuId;
	}
	/**
	 * @param upperMenuId the upperMenuId to set
	 */
	public void setUpperMenuId(String upperMenuId) {
		this.upperMenuId = upperMenuId;
	}
	/**
	 * @return the menuOrdr
	 */
	public String getMenuOrdr() {
		return menuOrdr;
	}
	/**
	 * @param menuOrdr the menuOrdr to set
	 */
	public void setMenuOrdr(String menuOrdr) {
		this.menuOrdr = menuOrdr;
	}
	/**
	 * @return the menuExecutYn
	 */
	public String getMenuExecutYn() {
		return menuExecutYn;
	}
	/**
	 * @param menuExecutYn the menuExecutYn to set
	 */
	public void setMenuExecutYn(String menuExecutYn) {
		this.menuExecutYn = menuExecutYn;
	}
	/**
	 * @return the menuApplcDe
	 */
	public String getMenuApplcDe() {
		return menuApplcDe;
	}
	/**
	 * @param menuApplcDe the menuApplcDe to set
	 */
	public void setMenuApplcDe(String menuApplcDe) {
		this.menuApplcDe = menuApplcDe;
	}
	/**
	 * @return the menuEndDe
	 */
	public String getMenuEndDe() {
		return menuEndDe;
	}
	/**
	 * @param menuEndDe the menuEndDe to set
	 */
	public void setMenuEndDe(String menuEndDe) {
		this.menuEndDe = menuEndDe;
	}
	/**
	 * @return the inqireAthrVu
	 */
	public String getInqireAthrVu() {
		return inqireAthrVu;
	}
	/**
	 * @param inqireAthrVu the inqireAthrVu to set
	 */
	public void setInqireAthrVu(String inqireAthrVu) {
		this.inqireAthrVu = inqireAthrVu;
	}
	/**
	 * @return the saveAthrVu
	 */
	public String getSaveAthrVu() {
		return saveAthrVu;
	}
	/**
	 * @param saveAthrVu the saveAthrVu to set
	 */
	public void setSaveAthrVu(String saveAthrVu) {
		this.saveAthrVu = saveAthrVu;
	}
	/**
	 * @return the delAthrVu
	 */
	public String getDelAthrVu() {
		return delAthrVu;
	}
	/**
	 * @param delAthrVu the delAthrVu to set
	 */
	public void setDelAthrVu(String delAthrVu) {
		this.delAthrVu = delAthrVu;
	}
	/**
	 * @return the outptAthrVu
	 */
	public String getOutptAthrVu() {
		return outptAthrVu;
	}
	/**
	 * @param outptAthrVu the outptAthrVu to set
	 */
	public void setOutptAthrVu(String outptAthrVu) {
		this.outptAthrVu = outptAthrVu;
	}
	/**
	 * @return the excelDwldAthrVu
	 */
	public String getExcelDwldAthrVu() {
		return excelDwldAthrVu;
	}
	/**
	 * @param excelDwldAthrVu the excelDwldAthrVu to set
	 */
	public void setExcelDwldAthrVu(String excelDwldAthrVu) {
		this.excelDwldAthrVu = excelDwldAthrVu;
	}
	/**
	 * @return the aprvAthrVu
	 */
	public String getAprvAthrVu() {
		return aprvAthrVu;
	}
	/**
	 * @param aprvAthrVu the aprvAthrVu to set
	 */
	public void setAprvAthrVu(String aprvAthrVu) {
		this.aprvAthrVu = aprvAthrVu;
	}
	/**
	 * @return the aprvCanclAthrVu
	 */
	public String getAprvCanclAthrVu() {
		return aprvCanclAthrVu;
	}
	/**
	 * @param aprvCanclAthrVu the aprvCanclAthrVu to set
	 */
	public void setAprvCanclAthrVu(String aprvCanclAthrVu) {
		this.aprvCanclAthrVu = aprvCanclAthrVu;
	}
	
}
