package kw.ecs.pn.prdctnacmslt.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 생산 - 에너지 생산실적 VO
 * 
 * @ClassName PrdctnAcmsltVo.java
 * @Description 전력에너지 생산실적 VO
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
public class PrdctnAcmsltVo extends ECSDefaultVo {
	private static final long serialVersionUID = 4297194941398015570L;

	/* ----- 조회조건 ----- */
	/** 조회연도/조회시작년도 - strtDt(SUPER) */
	/** 조회종료년도 - endDt(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS발전원구분코드(발전원) - ecsSetcscDivCd(SUPER) */
	/** ECS발전소구분코드(발전소) - ecsElcpwstnDivCd(SUPER) */

	/* ----- 조회결과 ----- */
	/** 년월일(일자/연도) : ymd */
	/** 1월 : mon01 */
	/** 2월 : mon02 */
	/** 3월 : mon03 */
	/** 4월 : mon04 */
	/** 5월 : mon05 */
	/** 6월 : mon06 */
	/** 7월 : mon07 */
	/** 8월 : mon08 */
	/** 9월 : mon09 */
	/** 10월 : mon10 */
	/** 11월 : mon11 */
	/** 12월 : mon12 */
	/** 계 : total */

	@Override
	public String toString() {
		return "PrdctnAcmsltVo [], " + super.toString();
	}
}