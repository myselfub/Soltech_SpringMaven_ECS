package kw.ecs.cn.pwcspcmprsttus.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 소비 - 소비전력 비교현황 VO
 * 
 * @ClassName PwcspRedcnRtVo.java
 * @Description 사업장 소비전력 비교현황 VO
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.15		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 15
 * @version 1.0
 * 
 *          <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *          </pre>
 */
public class PwcspCmprSttusVo extends ECSDefaultVo {
	private static final long serialVersionUID = 8288206712558829790L;

	/* ----- 조회조건 ----- */
	/** 조회시작날짜 - strtDt(SUPER) */
	/** 조회종료날짜 - endDt(SUPER) */
	/** 조회조건대상 - cnd(SUPER) */
	/** ECS유역구분코드(기준유역) - ecsBasinDivCd(SUPER) */
	/** ECS담당부서ID(기준부서) - ecsChrgDeptId(SUPER) */
	/** 비교ECS유역구분코드(비교유역) */
	private String cmprEcsBasinDivCd;
	/** ECS담당부서ID(비교부서) */
	private String cmprEcsChrgDeptId;

	/* ----- 조회결과 ----- */
	/** 부서명(부서) : deptNm */
	/** 설비용량 : eqpCcty */
	/** 연간누적소비전력량 : fyerAcmlCnsmpElteng */
	/** 당월소비전력량 : thsmonCnsmpElteng */
	/** 전년동월대비소비전력감소율 : prvyySammVersusPwcspDcrsRt */
	/** 전국전년동월대비소비절감률순위 : wntyPrvyySammVersusCnsmpRedcnRtRnk */
	/**
	 * 유역전년동월대비소비절감률순위(동일 권역내 전년 동월대비 소비 절감률 순위) :
	 * basinPrvyySammVersusCnsmpRedcnRtRnk
	 */
	/** 소내설비용량 : inhouseEqpCcty */
	/** 전년동월대비소내소비전력절감률 : prvyySammVersusInhousePwcspRedcnRt */

	public String getCmprEcsBasinDivCd() {
		return cmprEcsBasinDivCd;
	}

	public void setCmprEcsBasinDivCd(String cmprEcsBasinDivCd) {
		this.cmprEcsBasinDivCd = cmprEcsBasinDivCd;
	}

	public String getCmprEcsChrgDeptId() {
		return cmprEcsChrgDeptId;
	}

	public void setCmprEcsChrgDeptId(String cmprEcsChrgDeptId) {
		this.cmprEcsChrgDeptId = cmprEcsChrgDeptId;
	}

	@Override
	public String toString() {
		return "PwcspRedcnRtVo [cmprEcsBasinDivCd=" + cmprEcsBasinDivCd + ", cmprEcsChrgDeptId=" + cmprEcsChrgDeptId
				+ "], " + super.toString();
	}
}