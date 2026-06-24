package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * ClsCdVo VO 클래스
 * 
 * @ClassName ClsCdVo.java
 * @Description 공통분류코드에 사용하는 VO 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.07.05		60003048(조영창)			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창
 * @since 2017. 07. 05.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
public class ClsCdVo extends DefaultVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 공통분류코드 */
	private String clsCd;
	/** 공통분류코드명 */
	private String clsCdNm;
	/** 공통분류코드설명 */
	private String clsCdDc;
	/** 사용여부 */
	private String useYn;

	public String getClsCd() {
		return clsCd;
	}

	public void setClsCd(String clsCd) {
		this.clsCd = clsCd;
	}

	public String getClsCdNm() {
		return clsCdNm;
	}

	public void setClsCdNm(String clsCdNm) {
		this.clsCdNm = clsCdNm;
	}

	public String getClsCdDc() {
		return clsCdDc;
	}

	public void setClsCdDc(String clsCdDc) {
		this.clsCdDc = clsCdDc;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
}