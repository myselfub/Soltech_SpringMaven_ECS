package kw.ecs.zz.login.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 대내사용자 로그인에 사용하는 Vo 클래스
 * 
 * @ClassName DmstUsrInfoVo.java
 * @Description 대내사용자 로그인에 사용하는 Vo 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.03.01		Soft Arch			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : Soft Arch 아무개
 * @since 2017. 03. 01.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
public class IntnUsrInfoVo extends DefaultVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 사용자사원번호 EMPNO */
	private String usrEmpno;

	/** 사용자부서코드 OBJID */
	private String usrDeptCd;

	/** 사용자부서명 DEPT */
	private String usrDeptNm;

	/** 사용자직위코드 CALCD */
	private String usrOfcpsCd;

	/** 사용자직위명 POSIT */
	private String usrOfcpsNm;

	/** 사용자직급코드 ZGRCD */
	private String usrJgrdCd;

	/** 사용자직급명 GRADE */
	private String usrJgrdNm;

	// 세션 항목 추가 2017.08.16 이덕형

	/** 사용자본부코드 BONCD */
	private String usrHqCd;

	/** 사용자본부명 HEAD */
	private String usrHqNm;

	/** 사용자부(문)코드 TIMCD */
	private String usrSectCd;

	/** 사용자부(문)명 SECT */
	private String usrSectNm;

	/** 사용자팀코드 KWACD */
	private String usrTeamCd;

	/** 사용자팀명 TEAM */
	private String usrTeamNm;

	/** 사용자직군코드 ZGUNC */
	private String usrJbgpCd;

	/** 사용자직군명 BGROUP */
	private String usrJbgpNm;

	/** 사용자직렬코드 ZGPCD */
	private String usrJblnCd;

	/** 사용자직렬명 DGROUP */
	private String usrJblnNm;

	/** 사용자직무코드 STECD */
	private String usrDtyCd;

	/** 사용자직무명 AFFCD */
	private String usrDtyNm;

	/** 코스트센터코드 KOSTL */
	private String cstctCd;

	public String getUsrEmpno() {
		return usrEmpno;
	}

	public void setUsrEmpno(String usrEmpno) {
		this.usrEmpno = usrEmpno;
	}

	public String getUsrDeptCd() {
		return usrDeptCd;
	}

	public void setUsrDeptCd(String usrDeptCd) {
		this.usrDeptCd = usrDeptCd;
	}

	public String getUsrDeptNm() {
		return usrDeptNm;
	}

	public void setUsrDeptNm(String usrDeptNm) {
		this.usrDeptNm = usrDeptNm;
	}

	public String getUsrOfcpsCd() {
		return usrOfcpsCd;
	}

	public void setUsrOfcpsCd(String usrOfcpsCd) {
		this.usrOfcpsCd = usrOfcpsCd;
	}

	public String getUsrOfcpsNm() {
		return usrOfcpsNm;
	}

	public void setUsrOfcpsNm(String usrOfcpsNm) {
		this.usrOfcpsNm = usrOfcpsNm;
	}

	public String getUsrJgrdCd() {
		return usrJgrdCd;
	}

	public void setUsrJgrdCd(String usrJgrdCd) {
		this.usrJgrdCd = usrJgrdCd;
	}

	public String getUsrJgrdNm() {
		return usrJgrdNm;
	}

	public void setUsrJgrdNm(String usrJgrdNm) {
		this.usrJgrdNm = usrJgrdNm;
	}

	// 세션 항목 추가 2017.08.16 이덕형
	// 항목명 수정 2017.10.24 한재종

	public String getUsrHqCd() {
		return usrHqCd;
	}

	public void setUsrHqCd(String usrHqCd) {
		this.usrHqCd = usrHqCd;
	}

	public String getUsrHqNm() {
		return usrHqNm;
	}

	public void setUsrHqNm(String usrHqNm) {
		this.usrHqNm = usrHqNm;
	}

	public String getUsrSectCd() {
		return usrSectCd;
	}

	public void setUsrSectCd(String usrSectCd) {
		this.usrSectCd = usrSectCd;
	}

	public String getUsrSectNm() {
		return usrSectNm;
	}

	public void setUsrSectNm(String usrSectNm) {
		this.usrSectNm = usrSectNm;
	}

	public String getUsrTeamCd() {
		return usrTeamCd;
	}

	public void setUsrTeamCd(String usrTeamCd) {
		this.usrTeamCd = usrTeamCd;
	}

	public String getUsrTeamNm() {
		return usrTeamNm;
	}

	public void setUsrTeamNm(String usrTeamNm) {
		this.usrTeamNm = usrTeamNm;
	}

	public String getUsrJbgpCd() {
		return usrJbgpCd;
	}

	public void setUsrJbgpCd(String usrJbgpCd) {
		this.usrJbgpCd = usrJbgpCd;
	}

	public String getUsrJbgpNm() {
		return usrJbgpNm;
	}

	public void setUsrJbgpNm(String usrJbgpNm) {
		this.usrJbgpNm = usrJbgpNm;
	}

	public String getUsrJblnCd() {
		return usrJblnCd;
	}

	public void setUsrJblnCd(String usrJblnCd) {
		this.usrJblnCd = usrJblnCd;
	}

	public String getUsrJblnNm() {
		return usrJblnNm;
	}

	public void setUsrJblnNm(String usrJblnNm) {
		this.usrJblnNm = usrJblnNm;
	}

	public String getUsrDtyCd() {
		return usrDtyCd;
	}

	public void setUsrDtyCd(String usrDtyCd) {
		this.usrDtyCd = usrDtyCd;
	}

	public String getUsrDtyNm() {
		return usrDtyNm;
	}

	public void setUsrDtyNm(String usrDtyNm) {
		this.usrDtyNm = usrDtyNm;
	}

	public String getCstctCd() {
		return cstctCd;
	}

	public void setCstctCd(String cstctCd) {
		this.cstctCd = cstctCd;
	}
}