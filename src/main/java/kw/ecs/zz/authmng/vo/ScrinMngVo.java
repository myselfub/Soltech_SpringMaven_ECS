package kw.ecs.zz.authmng.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 화면등록에 사용하는 Vo 클래스
 * 
 * @ClassName ScrinMngVo.java
 * @Description ScrinMngVo.java Class
 * @Modification Information
 * 
 *               <pre>
 *    수정일   수정자       수정내용
 *  ----------   ----------   -------------------------------
 *  2017. 6. 15.     60003048      최초생성
 *               </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창
 * @since 2017. 6. 15.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */

public class ScrinMngVo extends DefaultVo implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 화면ID */
	private String scrinId;
	/** 시스템구분코드 */
	private String intnSysDivCd;
	/** 시스템구분코드명 */
	private String intnSysDivNm;
	/** 화면명 */
	private String scrinNm;
	/** 화면 URL */
	private String scrinUrl;
	/** 화면설명 */
	private String scrinDc;
	/** 도움말파일명 */
	private String hpcmFileNm;
	/** 페이지번호 */
	private String pgeNo;
	/** 도움말영상파일명 */
	private String hpcmVidoFileNm;
	/** 화면사용여부 */
	private String useYn;
	/** 최종수정정보 */
	private String lastInfo;
	/** 규정연계 */
	private String linkinfo;
	/** 조회조건코드 */
	private String parmVu;

	/**
	 * @return the scrinId
	 */
	public String getScrinId() {
		return scrinId;
	}

	/**
	 * @param scrinId
	 *            the scrinId to set
	 */
	public void setScrinId(String scrinId) {
		this.scrinId = scrinId;
	}

	/**
	 * @return the intnSysDivCd
	 */
	public String getIntnSysDivCd() {
		return intnSysDivCd;
	}

	/**
	 * @param intnSysDivCd
	 *            the intnSysDivCd to set
	 */
	public void setIntnSysDivCd(String intnSysDivCd) {
		this.intnSysDivCd = intnSysDivCd;
	}

	/**
	 * @return the intnSysDivNm
	 */
	public String getIntnSysDivNm() {
		return intnSysDivNm;
	}

	/**
	 * @param intnSysDivNm
	 *            the intnSysDivNm to set
	 */
	public void setIntnSysDivNm(String intnSysDivNm) {
		this.intnSysDivNm = intnSysDivNm;
	}

	/**
	 * @return the scrinNm
	 */
	public String getScrinNm() {
		return scrinNm;
	}

	/**
	 * @param scrinNm
	 *            the scrinNm to set
	 */
	public void setScrinNm(String scrinNm) {
		this.scrinNm = scrinNm;
	}

	/**
	 * @return the scrinUrl
	 */
	public String getScrinUrl() {
		return scrinUrl;
	}

	/**
	 * @param scrinUrl
	 *            the scrinUrl to set
	 */
	public void setScrinUrl(String scrinUrl) {
		this.scrinUrl = scrinUrl;
	}

	/**
	 * @return the scrinDc
	 */
	public String getScrinDc() {
		return scrinDc;
	}

	/**
	 * @param scrinDc
	 *            the scrinDc to set
	 */
	public void setScrinDc(String scrinDc) {
		this.scrinDc = scrinDc;
	}

	/**
	 * @return the hpcmFileNm
	 */
	public String getHpcmFileNm() {
		return hpcmFileNm;
	}

	/**
	 * @param hpcmFileNm
	 *            the hpcmFileNm to set
	 */
	public void setHpcmFileNm(String hpcmFileNm) {
		this.hpcmFileNm = hpcmFileNm;
	}

	/**
	 * @return the pgeNo
	 */
	public String getPgeNo() {
		return pgeNo;
	}

	/**
	 * @param pgeNo
	 *            the pgeNo to set
	 */
	public void setPgeNo(String pgeNo) {
		this.pgeNo = pgeNo;
	}

	/**
	 * @return the hpcmVidoFileNm
	 */
	public String getHpcmVidoFileNm() {
		return hpcmVidoFileNm;
	}

	/**
	 * @param hpcmVidoFileNm
	 *            the hpcmVidoFileNm to set
	 */
	public void setHpcmVidoFileNm(String hpcmVidoFileNm) {
		this.hpcmVidoFileNm = hpcmVidoFileNm;
	}

	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}

	/**
	 * @param useYn
	 *            the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	/**
	 * @return the lastInfo
	 */
	public String getLastInfo() {
		return lastInfo;
	}

	/**
	 * @param lastInfo
	 *            the lastInfo to set
	 */
	public void setLastInfo(String lastInfo) {
		this.lastInfo = lastInfo;
	}

	/**
	 * @return the linkinfo
	 */
	public String getLinkinfo() {
		return linkinfo;
	}

	/**
	 * @param linkinfo
	 *            the linkinfo to set
	 */
	public void setLinkinfo(String linkinfo) {
		this.linkinfo = linkinfo;
	}

	/**
	 * @return parmVu
	 */
	public String getParmVu() {
		return parmVu;
	}

	/**
	 * @param parmVu
	 *            the parmVu to set
	 */
	public void setParmVu(String parmVu) {
		this.parmVu = parmVu;
	}

	@Override
	public String toString() {
		return "ScrinMngVo [scrinId=" + scrinId + ", intnSysDivCd=" + intnSysDivCd + ", intnSysDivNm=" + intnSysDivNm
				+ ", scrinNm=" + scrinNm + ", scrinUrl=" + scrinUrl + ", scrinDc=" + scrinDc + ", hpcmFileNm="
				+ hpcmFileNm + ", pgeNo=" + pgeNo + ", hpcmVidoFileNm=" + hpcmVidoFileNm + ", useYn=" + useYn
				+ ", lastInfo=" + lastInfo + ", linkinfo=" + linkinfo + ", parmVu=" + parmVu + "]";
	}
}