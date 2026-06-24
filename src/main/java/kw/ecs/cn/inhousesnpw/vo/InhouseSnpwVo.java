package kw.ecs.cn.inhousesnpw.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 소비 - Net-Zero 소내태양광 현황  VO
 * 
 * @ClassName InhouseSnpwVo.java
 * @Description Net-Zero 소내태양광 현황 VO
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
public class InhouseSnpwVo extends ECSDefaultVo {
	private static final long serialVersionUID = 3991152481571059182L;

	/* ----- 조회조건 ----- */
	/** 조회시작일자 - strtDt(SUPER) */
	/** 조회종료일자 - endDt(SUPER) */
	/** 조회조건대상 - cnd(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */
	/** ECS소비원구분코드(사업장) - ecsCnstscDivCd(SUPER) */

	/* ----- 조회결과 ----- */
	/** 년월일 : ymd */
	/** 01월 : mon01 */
	/** 02월 : mon02 */
	/** 03월 : mon03 */
	/** 04월 : mon04 */
	/** 05월 : mon05 */
	/** 06월 : mon06 */
	/** 07월 : mon07 */
	/** 08월 : mon08 */
	/** 09월 : mon09 */
	/** 10월 : mon10 */
	/** 11월 : mon11 */
	/** 12월 : mon12 */
	/** 계 : total */

	@Override
	public String toString() {
		return "InhouseSnpwVo [], " + super.toString();
	}
}