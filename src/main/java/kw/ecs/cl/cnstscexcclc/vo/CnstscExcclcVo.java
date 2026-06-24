package kw.ecs.cl.cnstscexcclc.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 정산 - 소비원 정산 VO
 * 
 * @ClassName CnstscExcclcVo.java
 * @Description 소비원 정산 VO
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
public class CnstscExcclcVo extends ECSDefaultVo {
	private static final long serialVersionUID = 5380428362444063598L;

	/* ----- 조회조건 ----- */
	/** 조회시작날짜(일/월/년) - strtDt(SUPER) */
	/** 조회종료날짜(일/월/년) - endDt(SUPER) */
	/** 조회구분 - cnd(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */

	/* ----- 조회결과 ----- */
	/** 배출시설지역본부코드 - dscfcLclhqCd */
	/** 배출시설지역본부명(유역) - dscfcLclhqNm */
	/** 배출시설사업장코드 - dscfcBplcCd */
	/** 배출시설사업장명(부서) - dscfcBplcNm */
	/** 사용량(사용량(kWh)) - usgqty */
	/** 금액(금액(원)) - amt */
	/** 배출시설코드 - dscfcId */
	/** 배출시설명(배출시설) - dscfcNm */
	/** 소비구분 - cnsmpDiv */
	/** 배출시설공정유형코드 - dscfcProcsTyCd */

	@Override
	public String toString() {
		return "CnstscExcclcVo [], " + super.toString();
	}
}