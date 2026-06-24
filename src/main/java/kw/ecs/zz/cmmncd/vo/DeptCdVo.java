package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * DeptCdVo VO 클래스
 * 
 * @ClassName DeptCdVo.java
 * @Description 부서정보조회에 사용하는 VO 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.08.23		60003048(조영창)			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창
 * @since 2017. 08. 23.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
public class DeptCdVo extends DefaultVo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 부서코드 */
	private String objid;
	/** 부서명 */
	private String stext;

	public String getObjid() {
		return objid;
	}

	public void setObjid(String objid) {
		this.objid = objid;
	}

	public String getStext() {
		return stext;
	}

	public void setStext(String stext) {
		this.stext = stext;
	}
}