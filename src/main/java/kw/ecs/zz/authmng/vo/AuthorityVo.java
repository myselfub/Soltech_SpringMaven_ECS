/**
 * 권한에 사용하는 Vo 클래스
 * @ClassName AuthorityVo.java
 * @Description  AuthorityVo.java Class 
 * @Modification-Information
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 3. 16.     user      최초생성
 * 
 * @author K-water 업무시스템 혁신사업 : 팀명 user 
 * @since  2017. 3. 16.
 * @version 1.0
 * @see 
 * 
 *  Copyright (C) 2017 by Unlimited K-water, All right reserved.
 */

package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

public class AuthorityVo extends DefaultVo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * authorityCd
	 */
	private String authorityCd;
	/**
	 * authorityNm
	 */
	private String authorityNm;
	/**
	 * 
	 */
	private String isUse;
	/**
	 * isUse
	 */
	private String note;
	/**
	 * empCd
	 */
	private String empCd;
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
	/**
	 * @return
	 */
	public String getEmpCd() {
		return empCd;
	}
	/**
	 * @param empCd
	 */
	public void setEmpCd(String empCd) {
		this.empCd = empCd;
	}
}
