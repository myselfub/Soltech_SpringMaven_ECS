package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * CmmnCdVo VO 클래스
 * 
 * @ClassName CmmnCdVo.java
 * @Description 공통코드에 사용하는 VO 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.10.17		60002956(박용민)			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 지방상수도 박용민
 * @since 2017. 10. 17.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
public class CmmnCdVo extends DefaultVo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 공통분류코드 */
	private String clsCd;
	/** 공통분류코드명 */
	private String clsCdNm;
	/** 공통분류코드설명 */
	private String clsCdDc;
	/** 공통코드 */
	private String cmmnCd;
	/** 공통코드명 */
	private String cmmnCdNm;
	/** 공통코드설명 */
	private String cmmnCdDc;
	/** 상위공통분류코드 */
	private String upperClsCd;
	/** 상위공통코드 */
	private String upperCmmnCd;
	/** 사용여부 */
	private String useYn;
	/** 정렬순서 */
	private String sortOrdr;
	/** SAP 연계여부 */
	private String sapLnkYn;
	/** 사용자기타정의1 */
	private String usrDfnVu1;
	/** 사용자기타정의2 */
	private String usrDfnVu2;
	/** 사용자기타정의3 */
	private String usrDfnVu3;
	/** 사용자기타정의4 */
	private String usrDfnVu4;
	/** 사용자기타정의5 */
	private String usrDfnVu5;
	/** 사용자기타정의6 */
	private String usrDfnVu6;
	/** 사용자기타정의7 */
	private String usrDfnVu7;
	/** 사용자기타정의8 */
	private String usrDfnVu8;
	/** 사용자기타정의구분 */
	private String usrDfnVu;
	/** 사용자기타정의값 */
	private String usrDfnEtcVu;
	/** 공통분류코드목록 */
	private String clsCdList;
	/** 암호화 */
	private String dataEnc;
	/** 복호화 */
	private String dataDec;
	/** 시스템구분 */
	private String sysDiv;
	/** 공통코드 최초여부 */
	private String frstYn;

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

	public String getCmmnCd() {
		return cmmnCd;
	}

	public void setCmmnCd(String cmmnCd) {
		this.cmmnCd = cmmnCd;
	}

	public String getCmmnCdNm() {
		return cmmnCdNm;
	}

	public void setCmmnCdNm(String cmmnCdNm) {
		this.cmmnCdNm = cmmnCdNm;
	}

	public String getCmmnCdDc() {
		return cmmnCdDc;
	}

	public void setCmmnCdDc(String cmmnCdDc) {
		this.cmmnCdDc = cmmnCdDc;
	}

	public String getUpperClsCd() {
		return upperClsCd;
	}

	public void setUpperClCd(String upperClsCd) {
		this.upperClsCd = upperClsCd;
	}

	public String getUpperCmmnCd() {
		return upperCmmnCd;
	}

	public void setUpperCmmnCd(String upperCmmnCd) {
		this.upperCmmnCd = upperCmmnCd;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getSortOrdr() {
		return sortOrdr;
	}

	public void setSortOrdr(String sortOrdr) {
		this.sortOrdr = sortOrdr;
	}

	public String getSapLnkYn() {
		return sapLnkYn;
	}

	public void setSapLnkYn(String sapLnkYn) {
		this.sapLnkYn = sapLnkYn;
	}

	public String getUsrDfnVu1() {
		return usrDfnVu1;
	}

	public void setUsrDfnVu1(String usrDfnVu1) {
		this.usrDfnVu1 = usrDfnVu1;
	}

	public String getUsrDfnVu2() {
		return usrDfnVu2;
	}

	public void setUsrDfnVu2(String usrDfnVu2) {
		this.usrDfnVu2 = usrDfnVu2;
	}

	public String getUsrDfnVu3() {
		return usrDfnVu3;
	}

	public void setUsrDfnVu3(String usrDfnVu3) {
		this.usrDfnVu3 = usrDfnVu3;
	}

	public String getUsrDfnVu4() {
		return usrDfnVu4;
	}

	public void setUsrDfnVu4(String usrDfnVu4) {
		this.usrDfnVu4 = usrDfnVu4;
	}

	public String getUsrDfnVu() {
		return usrDfnVu;
	}

	public void setUsrDfnVu(String usrDfnVu) {
		this.usrDfnVu = usrDfnVu;
	}

	public String getUsrDfnEtcVu() {
		return usrDfnEtcVu;
	}

	public void setUsrDfnEtcVu(String usrDfnEtcVu) {
		this.usrDfnEtcVu = usrDfnEtcVu;
	}

	public String getClsCdList() {
		return clsCdList;
	}

	public void setClCdList(String clsCdList) {
		this.clsCdList = clsCdList;
	}

	public String getDataEnc() {
		return dataEnc;
	}

	public void setDataEnc(String dataEnc) {
		this.dataEnc = dataEnc;
	}

	public String getDataDec() {
		return dataDec;
	}

	public void setDataDec(String dataDec) {
		this.dataDec = dataDec;
	}

	public String getSysDiv() {
		return sysDiv;
	}

	public void setsysDiv(String sysDiv) {
		this.sysDiv = sysDiv;
	}

	public String getFrstYn() {
		return frstYn;
	}

	public void setFrstYn(String frstYn) {
		this.frstYn = frstYn;
	}

	public String getUsrDfnVu5() {
		return usrDfnVu5;
	}

	public void setUsrDfnVu5(String usrDfnVu5) {
		this.usrDfnVu5 = usrDfnVu5;
	}

	public String getUsrDfnVu6() {
		return usrDfnVu6;
	}

	public void setUsrDfnVu6(String usrDfnVu6) {
		this.usrDfnVu6 = usrDfnVu6;
	}

	public String getUsrDfnVu7() {
		return usrDfnVu7;
	}

	public void setUsrDfnVu7(String usrDfnVu7) {
		this.usrDfnVu7 = usrDfnVu7;
	}

	public String getUsrDfnVu8() {
		return usrDfnVu8;
	}

	public void setUsrDfnVu8(String usrDfnVu8) {
		this.usrDfnVu8 = usrDfnVu8;
	}
}