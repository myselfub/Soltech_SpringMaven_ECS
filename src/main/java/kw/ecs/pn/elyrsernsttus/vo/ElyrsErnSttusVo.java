package kw.ecs.pn.elyrsernsttus.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 생산 - 계획대비 발전수익 현황 VO
 * 
 * @ClassName ElyrsErnSttusVo.java
 * @Description 계획대비 발전수익 현황 VO
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
public class ElyrsErnSttusVo extends ECSDefaultVo {
	private static final long serialVersionUID = -6348875479977618389L;

	/* ----- 조회조건 ----- */
	/** 조회시작년도 - strtDt(SUPER) */
	/** 조회종료년도 - endDt(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */
	/** ECS발전원구분코드(발전원) - ecsSetcscDivCd(SUPER) */

	/* ----- 조회결과 ----- */
	/** 년도 : year */
	/** 전력거래량계획(전력거래량(GWh) - 계획) : epwrDelngQyPlan */
	/** 전력거래량계획(전력거래량(GWh) - 실적) : epwrDelngQyAcmslt */
	/** 전력거래량계획(전력거래량(GWh) - 달성률) : epwrDelngQyAcmtrt */
	/** 발전수익계획(발전수익(억원) - 계획) : elyrsErnPlan */
	/** 발전수익계획(발전수익(억원) - 실적) : elyrsErnAcmslt */
	/** 발전수익계획(발전수익(억원) - 달성률) : elyrsErnAcmtrt */
	/** 판매단가계획(판매단가(원/kWh) - 계획) : sleUpcPlan */
	/** 판매단가실적(판매단가(원/kWh) - 실적) : sleUpcAcmslt */
	/** 판매단가달성률(판매단가(원/kWh) - 달성률) : sleUpcAcmtrt */

	@Override
	public String toString() {
		return "ElyrsErnSttusVo [], " + super.toString();
	}
}