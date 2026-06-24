package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 인사제공뷰(PA02 직급, PA04 직렬) 에 사용하는 Vo 클래스
 * @ClassName HrmVmRs175Vo.java
 * @Description  HrmVmRs175Vo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 7. 5.    60002841      최초생성
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 정보화표준 권영훈
 * @since  2017. 7. 5.
 * @version 1.0
 * @see  
 *  <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */
public class HrmVmRs175Vo extends DefaultVo implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 공통그룹코드 */
	private String cogrp;
	/** 공통하위그룹코드 */
	private String cogr2;
	/** 공통코드코드 */
	private String cogr3;
	/** 공통코드명 */
	private String cotx3;
	/** 사용플래그 */
	private String useFg;
	public String getCogrp() {
		return cogrp;
	}
	public void setCogrp(String cogrp) {
		this.cogrp = cogrp;
	}
	public String getCogr2() {
		return cogr2;
	}
	public void setCogr2(String cogr2) {
		this.cogr2 = cogr2;
	}
	public String getCogr3() {
		return cogr3;
	}
	public void setCogr3(String cogr3) {
		this.cogr3 = cogr3;
	}
	public String getCotx3() {
		return cotx3;
	}
	public void setCotx3(String cotx3) {
		this.cotx3 = cotx3;
	}
	public String getUseFg() {
		return useFg;
	}
	public void setUseFg(String useFg) {
		this.useFg = useFg;
	}	
}
