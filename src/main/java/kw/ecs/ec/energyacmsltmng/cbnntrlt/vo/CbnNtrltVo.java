package kw.ecs.ec.energyacmsltmng.cbnntrlt.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 에너지전주기 - 전력에너지실적현황 탄소중립율
 * 
 * @ClassName CbnNtrltVo.java
 * @Description 탄소중립율 VO
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.02.15		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 02. 15
 * @version 1.0
 * 
 *          <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *          </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CbnNtrltVo extends ECSDefaultVo {
	private static final long serialVersionUID = 6477794347297622213L;

	/* ----- 조회조건 ----- */
	/** 조회시작날짜 - strtDt(SUPER) */
	/** 조회종료날짜 - endDt(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */

	/* ----- 조회결과 ----- */
	/** 탄소배출감축년월 : ym */
	/** 취수장탄소배출량(배출량(tCO2) - 취수시설) : itkpl */
	/** 가압장탄소배출량(배출량(tCO2) - 가압시설) : prnplc */
	/** 정수장탄소배출량(배출량(tCO2) - 정수시설) : fltplt */
	/** 건물탄소배출량(배출량(tCO2) - 건물) : buld */
	/** 댐탄소배출량(배출량(tCO2) - 댐시설) : dam */
	/** 수송탄소배출량(배출량(tCO2) - 수송) : trnsp */
	/** 기타탄소배출량(배출량(tCO2) - 기타) : etc */
	/** 배출량합계 : dsqtySum(배출량(tCO2) - 합계) */
	/** 대수력탄소감축량(감축량(tCO2) - 대수력) : lgwtpw */
	/** 소수력탄소감축량(감축량(tCO2) - 소수력) : smlhp */
	/** 조력탄소감축량(감축량(tCO2) - 조력) : tdpw */
	/** 풍력탄소감축량(감축량(tCO2) - 풍력) : wdpw */
	/** 태양광판매탄소감축량(감축량(tCO2) - 태양광) : snpw */
	/** 감축량합계(감축량(tCO2) - 합계) : rqtySum */
	/** 달성률(달성률(%)) : acmtrt */

	@Override
	public String toString() {
		return "CbnNtrltVo [], " + super.toString();
	}
}