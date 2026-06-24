package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * ScrinListVo VO 클래스
 * 
 * @ClassName ScrinListVo.java
 * @Description 화면정보에 사용하는 VO 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.07.10		60003048(조영창)			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창
 * @since 2017. 07. 10.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
public class ScrinListVo extends DefaultVo implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 화면ID */
	private String scrinId;
	/** 내부시스템구분코드 */
	private String intnSysDivCd;
	/** 화면명 */
	private String scrinNm;
	/** 화면 URL */
	private String scrinUrl;
	/** 화면설명 */
	private String scrinDc;
	/** SAP라이센스구분코드 */
	private String sapLcnsTyCd;
	/** 사용여부 */
	private String useYn;
	
	public String getScrinId() {
		return scrinId;
	}
	public void setScrinId(String scrinId) {
		this.scrinId = scrinId;
	}
	public String getIntnSysDivCd() {
		return intnSysDivCd;
	}
	public void setIntnSysDivCd(String intnSysDivCd) {
		this.intnSysDivCd = intnSysDivCd;
	}	
	public String getScrinNm() {
		return scrinNm;
	}
	public void setScrinNm(String scrinNm) {
		this.scrinNm = scrinNm;
	}	
	public String getScrinUrl() {
		return scrinUrl;
	}
	public void setScrinUrl(String scrinUrl) {
		this.scrinUrl = scrinUrl;
	}		
	public String getScrinDc() {
		return scrinDc;
	}
	public void setScrinDc(String scrinDc) {
		this.scrinDc = scrinDc;
	}
	public String getSapLcnsCd() {
		return sapLcnsTyCd;
	}
	public void setSapLcnsCd(String sapLcnsTyCd) {
		this.sapLcnsTyCd = sapLcnsTyCd;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
}
