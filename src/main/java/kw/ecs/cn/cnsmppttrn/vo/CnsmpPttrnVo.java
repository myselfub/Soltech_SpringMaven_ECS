package kw.ecs.cn.cnsmppttrn.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 소비 - 사업장 소비패턴 분석현황 VO
 * 
 * @ClassName CnsmpPttrnVo.java
 * @Description 사업장 소비패턴 분석현황 VO
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
public class CnsmpPttrnVo extends ECSDefaultVo {
	private static final long serialVersionUID = 1102937404826638654L;

	/* ----- 조회조건 ----- */
	/** 조회시작날짜 - strtDt(SUPER) */
	/** 조회종료날짜 - endDt(SUPER) */
	/** ECS유역구분코드(기준유역) - ecsBasinDivCd(SUPER) */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */
	/** ECS소비원구분코드(소비원) - ecsCnstscDivCd(SUPER) */

	/* ----- 조회결과 ----- */
	/** 년월일 : ymd */
	/** 유역명(유역) : basinNm */
	/** 부서명(부서) : deptNm */
	/** 사업장명(시설명) : bplcNm */
	/** 소비량 일누계(kWh/일) : cnstqyAcmtl */
	/** 소비량 년누계(kWh/일) : cnstqyYyAcmtl */
	/** 용수공급량 일누계(㎥/일) : uswtrSqtyAcmtl */
	/** 용수공급량 년누계(㎥/월) : uswtrSqtyYyAcmtl */
	/** 일별 전력원단위(전력원단위(kWh/㎥)) : epbuAcmtl */
	/** 연별 전력원단위(전력원단위(kWh/㎥)) : epbuYyAcmtl */

	@Override
	public String toString() {
		return "CnsmpPttrnVo [], " + super.toString();
	}
}