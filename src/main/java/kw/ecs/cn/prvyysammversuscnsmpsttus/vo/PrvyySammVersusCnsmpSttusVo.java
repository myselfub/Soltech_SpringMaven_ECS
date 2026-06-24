package kw.ecs.cn.prvyysammversuscnsmpsttus.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 소비 - 전년동월대비 소비현황 VO
 * 
 * @ClassName PrvyySammVersusCnsmpSttusVo.java
 * @Description 전년동월대비 소비현황 VO
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
public class PrvyySammVersusCnsmpSttusVo extends ECSDefaultVo {
	private static final long serialVersionUID = -1856379448880017011L;

	/* ----- 조회조건 ----- */
	/** 비교조회년월 - strtDt(SUPER) */
	/** 대상조회년월 - endDt(SUPER) */
	/** ECS유역구분코드(기준유역) - ecsBasinDivCd(SUPER) */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */

	/* ----- 조회결과 ----- */
	/** 번호 : no */
	/** 유역코드(유역코드) : basinCd */
	/** 유역명(유역명) : basinNm */
	/** 부서코드(부서코드) : deptCd */
	/** 부서명(부서) : deptNm */
	/** 공정구분명(공정구분) : dscfcProcsTyNm */
	/** 공정구분코드(공정구분코드) : dscfcProcsTyCd */
	/** 전년소비전력(yyyy(-1).mm소비전력) : prvyyPwcsp */
	/** 당년소비전력(yyyy.mm소비전력) : thsyyPwcsp */
	/** 증감량(증감량(kWh)) : irdsQy */
	/** 절감률(증감률(%)) : redcnRt */

	@Override
	public String toString() {
		return "PrvyySammVersusCnsmpSttusVo [], " + super.toString();
	}
}