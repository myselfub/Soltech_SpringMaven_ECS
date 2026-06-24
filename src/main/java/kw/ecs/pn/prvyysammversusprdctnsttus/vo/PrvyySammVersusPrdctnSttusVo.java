package kw.ecs.pn.prvyysammversusprdctnsttus.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 소비 - 전년 동월 대비 생산현황 VO
 * 
 * @ClassName PrvyySammVersusPrdctnEpwrVo.java
 * @Description 전년동월대비 생산현황 VO
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
public class PrvyySammVersusPrdctnSttusVo extends ECSDefaultVo {
	private static final long serialVersionUID = -1904576280518860064L;

	/* ----- 조회조건 ----- */
	/** 비교조회년월 - strtDt(SUPER) */
	/** 대상조회년월 - endDt(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS발전원구분코드(발전원) - ecsSetcscDivCd(SUPER) */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */

	/* ----- 조회결과 ----- */
	/** 번호 : no */
	/** 발전원 : setcsc */
	/** 부서명(부서) : deptNm */
	/** 전년 생산전력(yyyy(-1).mm생산전력) : prvyyPrdctnEpwr */
	/** 당년 생산전력(yyyy.mm생산전력) : thsyyPrdctnEpwr */
	/** 증감량(증감량(kWh)) : irdsQy */
	/** 달성률(달성률(%)) : achivRt */

	@Override
	public String toString() {
		return "PrvyySammVersusPrdctnSttusVo [], " + super.toString();
	}
}