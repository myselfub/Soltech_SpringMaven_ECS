package kw.ecs.zz.cmmncd.vo;

import java.io.Serializable;

import kw.fw.defaults.DefaultVo;

/**
 * 인사테이블 부서정보에 사용하는 Vo 클래스
 * 
 * 중요) 부서를 조회 시에는 strdt(시작일자)와 enddt(종료일자)를 확인해야 한다.
 *        해당 컬럼과 현재 날짜로 삭제여부를 확인한다.
 * @ClassName HrmVmHr01A01Vo.java
 * @Description  HrmVmHr01A01Vo.java Class 
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
public class HrmVmHr01A01Vo extends DefaultVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 조직코드 */
	private String objid;
	/** 조직명 */
	private String stext;
	/** 등록일 */
	private String regdt;
	/** 수정일 */
	private String upddt;
	/** 재무부서코드 */
	private String zfcod;
	/** 시작일자 */
	private String strdt;
	/** 종료일자 */
	private String enddt;
	/** 상위조직코드 */
	private String upobj;
	/** 깊이 */
	private String depth;
	/** 순서 */
	private String seqno;
	/** 현장구분 */
	private String parts;
	/** 수시전보그룹1 */
	private String divi1;
	/** 수시전보그룹2 */
	private String divi2;
	/** 부서장 사번 */
	private String pernr;
	/** 코스트센터 */
	private String kostl;
	
	
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
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public String getUpddt() {
		return upddt;
	}
	public void setUpddt(String upddt) {
		this.upddt = upddt;
	}
	public String getZfcod() {
		return zfcod;
	}
	public void setZfcod(String zfcod) {
		this.zfcod = zfcod;
	}
	public String getStrdt() {
		return strdt;
	}
	public void setStrdt(String strdt) {
		this.strdt = strdt;
	}
	public String getEnddt() {
		return enddt;
	}
	public void setEnddt(String enddt) {
		this.enddt = enddt;
	}
	public String getUpobj() {
		return upobj;
	}
	public void setUpobj(String upobj) {
		this.upobj = upobj;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getParts() {
		return parts;
	}
	public void setParts(String parts) {
		this.parts = parts;
	}
	public String getDivi1() {
		return divi1;
	}
	public void setDivi1(String divi1) {
		this.divi1 = divi1;
	}
	public String getDivi2() {
		return divi2;
	}
	public void setDivi2(String divi2) {
		this.divi2 = divi2;
	}
	public String getPernr() {
		return pernr;
	}
	public void setPernr(String pernr) {
		this.pernr = pernr;
	}
	public String getKostl() {
		return kostl;
	}
	public void setKostl(String kostl) {
		this.kostl = kostl;
	}
}
