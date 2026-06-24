package kw.ecs.cn.epbusttus.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 소비 - 광역 전력원단위 현황 VO
 * 
 * @ClassName EpbuSttusVo.java
 * @Description 광역 전력원단위 현황 VO
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.17		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 17
 * @version 1.0
 * 
 *          <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *          </pre>
 */
public class EpbuSttusVo extends ECSDefaultVo {
	private static final long serialVersionUID = 3991152481571059182L;

	/* ----- 조회조건 ----- */
	/** 조회시작년도 - strtDt(SUPER) */
	/** 조회종료년도 - endDt(SUPER) */
	/** 조회조건대상 - cnd(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */
	/** ECS소비원구분코드(소비원) - ecsCnstscDivCd(SUPER) */

	/* ----- 조회결과 ----- */
	/** 유역명(유역) : basinNm */
	/** 부서명(사업장 - 부서) : deptNm */
	/** 사업장명(사업장 - 사업장) : bplcNm */
	/** 용수공급량(용수공급량(㎥)) : uswtrSqty */
	/** 전력사용량(전력사용량(kWh)) : epwrUsgqty */
	/** 한전고지요금(한전고지요금(원)) : kepcoNticCg */
	/** 수요거래정산금(수요거래 정산금(원)) : excclcAmt */
	/** 전력원단위(전력원단위(kWh/㎥)) : epbu */
	/** 태양광발전(소내소비용 태양광발전(kWh)) : snpwElyrs */

	@Override
	public String toString() {
		return "EpbuSttusVo [], " + super.toString();
	}
}