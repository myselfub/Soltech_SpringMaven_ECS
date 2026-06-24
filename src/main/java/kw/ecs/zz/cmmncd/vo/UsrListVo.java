package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * UsrListVo VO 클래스
 * 
 * @ClassName UsrListVo.java
 * @Description 사용자정보에 사용하는 VO 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.06.29		Yc.J			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 Yc.J
 * @since 2017. 06. 29.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
public class UsrListVo extends DefaultVo implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 사용자ID */
	private String usrId;
	/** 사용자명 */
	private String usrNm;
	/** 사용자사번 */
	private String usrEmpno;
	/** 사용자부서CD */
	private String usrDeptCd;
	/** 사용자본부명 */
	private String usrHqNm;
	/** 사용자부서명 */
	private String usrDeptNm;
	/** 사용자부명 */
	private String usrSectNm;
	/** 사용자팀명 */
	private String usrTeamNm;
	/** 사용자직군CD */
	private String usrJbgpCd;
	/** 사용자직군명 */
	private String usrJbgpNm;
	/** 사용자직렬명 */
	private String usrJblnNm;
	/** 사용자직위CD */
	private String usrOfcpsCd;
	/** 사용자직위명 */
	private String usrOfcpsNm;
	/** 사용자직급CD */
	private String usrClsfCd;
	/** 사용자직급명 */
	private String usrClsfNm;
	/** 사용자직급CD */
	private String usrJgrdCd;
	/** 사용자직급명 */
	private String usrJgrdNm;
	/** 사용자직무CD */
	private String usrDtyCd;
	/** 사용자직무명 */
	private String usrDtyNm;
	/** 내선전화번호 */
	private String usrLxtnTelno;
	/** 이메일 */
	private String usrEmail;
	/** 사용여부 */
	private String useYn;
	/** 성명 조회조건(Ajax 호출시) */
	private String searchUsrNm;

	/**
	 * @return the usrId
	 */
	public String getUsrId() {
		return usrId;
	}

	/**
	 * @param usrId
	 *            the usrId to set
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * @return the usrNm
	 */
	public String getUsrNm() {
		return usrNm;
	}

	/**
	 * @param usrNm
	 *            the usrNm to set
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	/**
	 * @return the usrEmpno
	 */
	public String getUsrEmpno() {
		return usrEmpno;
	}

	/**
	 * @param usrEmpno
	 *            the usrEmpno to set
	 */
	public void setUsrEmpno(String usrEmpno) {
		this.usrEmpno = usrEmpno;
	}

	/**
	 * @return the usrDeptCd
	 */
	public String getUsrDeptCd() {
		return usrDeptCd;
	}

	/**
	 * @param usrDeptCd
	 *            the usrDeptCd to set
	 */
	public void setUsrDeptCd(String usrDeptCd) {
		this.usrDeptCd = usrDeptCd;
	}

	/**
	 * @return the usrHqNm
	 */
	public String getUsrHqNm() {
		return usrHqNm;
	}

	/**
	 * @param usrHqNm
	 *            the usrHqNm to set
	 */
	public void setUsrHqNm(String usrHqNm) {
		this.usrHqNm = usrHqNm;
	}

	/**
	 * @return the usrDeptNm
	 */
	public String getUsrDeptNm() {
		return usrDeptNm;
	}

	/**
	 * @param usrDeptNm
	 *            the usrDeptNm to set
	 */
	public void setUsrDeptNm(String usrDeptNm) {
		this.usrDeptNm = usrDeptNm;
	}

	/**
	 * @return the usrSectNm
	 */
	public String getUsrSectNm() {
		return usrSectNm;
	}

	/**
	 * @param usrSectNm
	 *            the usrSectNm to set
	 */
	public void setUsrSectNm(String usrSectNm) {
		this.usrSectNm = usrSectNm;
	}

	/**
	 * @return the usrTeamNm
	 */
	public String getUsrTeamNm() {
		return usrTeamNm;
	}

	/**
	 * @param usrTeamNm
	 *            the usrTeamNm to set
	 */
	public void setUsrTeamNm(String usrTeamNm) {
		this.usrTeamNm = usrTeamNm;
	}

	/**
	 * @return the usrJbgpCd
	 */
	public String getUsrJbgpCd() {
		return usrJbgpCd;
	}

	/**
	 * @param usrJbgpCd
	 *            the usrJbgpCd to set
	 */
	public void setUsrJbgpCd(String usrJbgpCd) {
		this.usrJbgpCd = usrJbgpCd;
	}

	/**
	 * @return the usrJbgpNm
	 */
	public String getUsrJbgpNm() {
		return usrJbgpNm;
	}

	/**
	 * @param usrJbgpNm
	 *            the usrJbgpNm to set
	 */
	public void setUsrJbgpNm(String usrJbgpNm) {
		this.usrJbgpNm = usrJbgpNm;
	}

	/**
	 * @return the usrJblnNm
	 */
	public String getUsrJblnNm() {
		return usrJblnNm;
	}

	/**
	 * @param usrJblnNm
	 *            the usrJblnNm to set
	 */
	public void setUsrJblnNm(String usrJblnNm) {
		this.usrJblnNm = usrJblnNm;
	}

	/**
	 * @return the usrOfcpsCd
	 */
	public String getUsrOfcpsCd() {
		return usrOfcpsCd;
	}

	/**
	 * @param usrOfcpsCd
	 *            the usrOfcpsCd to set
	 */
	public void setUsrOfcpsCd(String usrOfcpsCd) {
		this.usrOfcpsCd = usrOfcpsCd;
	}

	/**
	 * @return the usrOfcpsNm
	 */
	public String getUsrOfcpsNm() {
		return usrOfcpsNm;
	}

	/**
	 * @param usrOfcpsNm
	 *            the usrOfcpsNm to set
	 */
	public void setUsrOfcpsNm(String usrOfcpsNm) {
		this.usrOfcpsNm = usrOfcpsNm;
	}

	/**
	 * @return the usrClsfCd
	 */
	public String getUsrClsfCd() {
		return usrClsfCd;
	}

	/**
	 * @param usrClsfCd
	 *            the usrClsfCd to set
	 */
	public void setUsrClsfCd(String usrClsfCd) {
		this.usrClsfCd = usrClsfCd;
	}

	/**
	 * @return the usrClsfNm
	 */
	public String getUsrClsfNm() {
		return usrClsfNm;
	}

	/**
	 * @param usrClsfNm
	 *            the usrClsfNm to set
	 */
	public void setUsrClsfNm(String usrClsfNm) {
		this.usrClsfNm = usrClsfNm;
	}

	/**
	 * @return the usrJgrdCd
	 */
	public String getUsrJgrdCd() {
		return usrJgrdCd;
	}

	/**
	 * @param usrJgrdCd
	 *            the usrJgrdCd to set
	 */
	public void setUsrJgrdCd(String usrJgrdCd) {
		this.usrJgrdCd = usrJgrdCd;
	}

	/**
	 * @return the usrJgrdNm
	 */
	public String getUsrJgrdNm() {
		return usrJgrdNm;
	}

	/**
	 * @param usrJgrdNm
	 *            the usrJgrdNm to set
	 */
	public void setUsrJgrdNm(String usrJgrdNm) {
		this.usrJgrdNm = usrJgrdNm;
	}

	/**
	 * @return the usrDtyCd
	 */
	public String getUsrDtyCd() {
		return usrDtyCd;
	}

	/**
	 * @param usrDtyCd
	 *            the usrDtyCd to set
	 */
	public void setUsrDtyCd(String usrDtyCd) {
		this.usrDtyCd = usrDtyCd;
	}

	/**
	 * @return the usrDtyNm
	 */
	public String getUsrDtyNm() {
		return usrDtyNm;
	}

	/**
	 * @param usrDtyNm
	 *            the usrDtyNm to set
	 */
	public void setUsrDtyNm(String usrDtyNm) {
		this.usrDtyNm = usrDtyNm;
	}

	/**
	 * @return the usrLxtnTelno
	 */
	public String getUsrLxtnTelno() {
		return usrLxtnTelno;
	}

	/**
	 * @param usrLxtnTelno
	 *            the usrLxtnTelno to set
	 */
	public void setUsrLxtnTelno(String usrLxtnTelno) {
		this.usrLxtnTelno = usrLxtnTelno;
	}

	/**
	 * @return the usrEmail
	 */
	public String getUsrEmail() {
		return usrEmail;
	}

	/**
	 * @param usrEmail
	 *            the usrEmail to set
	 */
	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
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
	 * @return the searchUsrNm
	 */
	public String getSearchUsrNm() {
		return searchUsrNm;
	}

	/**
	 * @param searchUsrNm
	 *            the searchUsrNm to set
	 */
	public void setSearchUsrNm(String searchUsrNm) {
		this.searchUsrNm = searchUsrNm;
	}
}
