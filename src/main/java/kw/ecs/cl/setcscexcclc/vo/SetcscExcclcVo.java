package kw.ecs.cl.setcscexcclc.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 정산 - 발전원 정산 VO
 * 
 * @ClassName SetcscExcclcVo.java
 * @Description 발전원 정산 VO
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
public class SetcscExcclcVo extends ECSDefaultVo {
	private static final long serialVersionUID = -4686673125905902147L;

	/* ----- 조회조건 ----- */
	/** 조회시작날짜(일/월/년) - strtDt(SUPER) */
	/** 조회종료날짜(일/월/년) - endDt(SUPER) */
	/** 조회구분 - cnd(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS발전원구분코드(발전원) - ecsSetcscDivCd(SUPER) */
	/** ECS발전소구분코드(발전소) - ecsElcpwstnDivCd(SUPER) */

	/* ----- 조회결과 ----- */
	/** 날짜(조회일/조회월/조회년) - dt */
	/** 유역명(유역) - basinNm */
	/** 발전원명(발전원) - setcscNm */
	/** 발전소명(발전소) - elcpwstnNm */
	/** 전력량정산금액(전력량정산금(SEP)) - sep */
	/** 용량정산금액(용량정산금(CP)) - cp */
	/** 보조서비스CON(보조서비스-제약발전(CON)) - con */
	/** 보조서비스ASP(보조서비스-ASP) - asp */
	/** 소계 - subsum */
	/** REC - rec */
	/** CER - cer */
	/** 합계 - sum */

	@Override
	public String toString() {
		return "SetcscExcclcVo [], " + super.toString();
	}
}