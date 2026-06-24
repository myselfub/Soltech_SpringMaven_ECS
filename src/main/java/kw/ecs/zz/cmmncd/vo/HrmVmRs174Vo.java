package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 인사제공뷰(PA02 직군, OM07 직위) 에 사용하는 Vo 클래스
 * @ClassName HrmVmRs174Vo.java
 * @Description  HrmVmRs174Vo.java Class 
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
public class HrmVmRs174Vo extends DefaultVo implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 공통그룹코드 */
	private String cogrp;
	/** 공통코드 */
	private String cogr2;
	/** 공통코드명 */
	private String cotx2;
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
	public String getCotx2() {
		return cotx2;
	}
	public void setCotx2(String cotx2) {
		this.cotx2 = cotx2;
	}
	public String getUseFg() {
		return useFg;
	}
	public void setUseFg(String useFg) {
		this.useFg = useFg;
	}
	
}
