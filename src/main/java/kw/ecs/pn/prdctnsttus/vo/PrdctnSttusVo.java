package kw.ecs.pn.prdctnsttus.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 생산 - 생산현황 VO
 * 
 * @ClassName PrdctnSttusVo.java
 * @Description 전력에너지 생산현황 VO
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
public class PrdctnSttusVo extends ECSDefaultVo {
	private static final long serialVersionUID = 2594514993569880074L;

	/** ECS발전원구분코드(발전원) - ecsSetcscDivCd(SUPER) */

	/* ----- 조회조건 ----- */
	/** 조회연월 - strtDt(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */

	/* ----- 조회결과 ----- */
	/** 발전원명(발전원) : setcscNm */
	/** 발전원코드(발전원) : setcscCd */
	/** 부서명(부서) : deptNm */
	/** 부서코드(부서) : deptCd */
	/** 설비용량(설비용량(MW)) : eqpCpcty */
	/** 월간발전량계획(월간 전력거래량(누계) - 계획(MWh)) : mlyElyrsQyPlan */
	/** 월간발전량실적(월간 전력거래량(누계) - 실적(MWh)) : mlyElyrsQyAcmslt */
	/** 월간발전량달성률(월간 전력거래량(누계) - 달성률(%)) : mlyElyrsQyAcmtrt */
	/** 월간설비이용률(월간 전력거래량(누계) - 이용률(%)) : mlyEqpUtlzRt */
	/** 연간발전량계획(연간 전력거래량(누계) - 계획(MWh)) : fyerElyrsQyPlan */
	/** 연간발전량실적(연간 전력거래량(누계) - 실적(MWh)) : fyerElyrsQyAcmslt */
	/** 연간발전량달성률(연간 전력거래량(누계) - 달성률(%)) : fyerElyrsQyAcmtrt */
	/** 연간설비이용률(연간 전력거래량(누계) - 이용률(%)) : fyerEqpUtlzRt */
	/** 연간수익(연간수익(억원)) : fyerErn */

	@Override
	public String toString() {
		return "PrdctnSttusVo [], " + super.toString();
	}
}