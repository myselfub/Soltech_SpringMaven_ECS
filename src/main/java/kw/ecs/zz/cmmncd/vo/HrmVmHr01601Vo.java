package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 인사테이블 사용자정보에 사용하는 Vo 클래스
 * 
 * 본부 - 부서 - 부(팀) - 과(팀) 순으로 계층화되어있는데
 * 부(팀)과 과(팀)은 특별히 정해진 이름이 없음. 상황에 따라서 충분히 다르게 부를 수 있음.
 * @ClassName HrmVmHr01601Vo.java
 * @Description  HrmVmHr01601Vo.java Class 
 * @Modification Information
 * <pre>
 *    수정일   수정자                   수정내용
 *  ----------   --------------------    -------------------------------
 *  2017. 10. 23.    60001234  강만석      최초생성
 * </pre>
 * @author K-water 업무시스템 혁신사업 : 공통팀 강만석 
 * @since  2017. 10. 23.
 * @version 1.0
 * <pre>Copyright (C) 2017 by Unlimited K-water, All right reserved. </pre>
 */
public class HrmVmHr01601Vo extends DefaultVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 사번 */
	private String usrEmpno;
	/** 한글성명 */
	private String usrNm;
	/** 본부코드 */
	private String usrHqCd;
	/** 본부명 */
	private String usrHqNm;
    /* 부서코드
     * objid는 ERP 부서코드이고, buscd는 Non-ERP 부서코드인데
     * objid를 사용하기로 회의함 (2017. 10. 23)
	private String buscd;
	*/
	/** 부서코드 */
	private String usrDeptCd;
	/** 부서명 */
	private String usrDeptNm;
	/** 부(팀)코드 */
	private String usrSectCd;
	/** 부(팀)명 */
	private String usrSectNm;
	/** 과(팀)코드 */
	private String usrTeamCd;
	/** 과(팀)명 */
	private String usrTeamNm;
	/** 직군코드 */
	private String usrJbgpCd;
	/** 직군명 */
	private String usrJbgpNm;
	/** 직렬코드 */
	private String usrJblnCd;
	/** 직렬명 */
	private String usrJblnNm;
	/** 직무코드 */
	private String usrDtyCd;
	/** 직무명 */
	private String usrDtyNm;
	/** 직급코드 */
	private String usrJgrdCd;
	/** 직급명 */
	private String usrJgrdNm;
	/** 직위코드 */
	private String usrOfcpsCd;
	/** 직위명 */
	private String usrOfcpsNm;
	/** 내선전화번호 */
	private String usrLxtnTelno;
	/** 이메일 */
	private String usrEmail;
	/** 코스트센터코드 */
	private String cstctCd;
	/** 코스트센터명 */
	private String cstctNm;
	/** 최하위부서코드 */
	private String lowestDeptCd;
	/** 최하위부서명 */
	private String lowestDeptNm;
	/** 최상위부서코드(조회조건) */
	private String topDeptCd;
	/** 조직도 Depth(조회조건, 기본값은 999) */
	private int orgchtDp;
	
	
	public String getUsrEmpno() {
		return usrEmpno;
	}
	public void setUsrEmpno(String usrEmpno) {
		this.usrEmpno = usrEmpno;
	}
	public String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
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
	public String getUsrDeptTelno() {
		return usrLxtnTelno;
	}
	public void setUsrDeptTelno(String usrLxtnTelno) {
		this.usrLxtnTelno = usrLxtnTelno;
	}
	public String getUsrEmail() {
		return usrEmail;
	}
	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}
	public String getCstctCd() {
		return cstctCd;
	}
	public void setCstctCd(String cstctCd) {
		this.cstctCd = cstctCd;
	}
	public String getCstctNm() {
		return cstctNm;
	}
	public void setCstctNm(String cstctNm) {
		this.cstctNm = cstctNm;
	}
	public String getLowestDeptCd() {
		return lowestDeptCd;
	}
	public void setLowestDeptCd(String lowestDeptCd) {
		this.lowestDeptCd = lowestDeptCd;
	}
	public String getLowestDeptNm() {
		return lowestDeptNm;
	}
	public void setLowestDeptNm(String lowestDeptNm) {
		this.lowestDeptNm = lowestDeptNm;
	}
	public String getTopDeptCd() {
		return topDeptCd;
	}
	public void setTopDeptCd(String topDeptCd) {
		this.topDeptCd = topDeptCd;
	}
	public int getOrgchtDp() {
		return orgchtDp;
	}
	public void setOrgchtDp(int orgchtDp) {
		this.orgchtDp = orgchtDp;
	}
}
