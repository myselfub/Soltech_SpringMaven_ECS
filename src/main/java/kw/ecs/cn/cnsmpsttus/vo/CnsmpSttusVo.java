package kw.ecs.cn.cnsmpsttus.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 소비 - 에너지 소비현황 VO
 * 
 * @ClassName PwcspVo.java
 * @Description 전력에너지 소비현황 VO
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
public class CnsmpSttusVo extends ECSDefaultVo {
	private static final long serialVersionUID = -4130621896197894134L;

	/* ----- 조회조건 ----- */
	/** 조회시작날짜 - strtDt(SUPER) */
	/** 조회종료날짜 - endDt(SUPER) */
	/** 조회조건대상 - cnd(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS담당부서ID(부서) - ecsChrgDeptId(SUPER) */

	/* ----- 조회결과(자체) ----- */
	/** 배출시설사업장코드 - dscfcBplcCd */
	/** 부서 - dscfcBplcNm */
	/** 취수시설 - itkpl */
	/** 가압시설 - prnplc */
	/** 정수시설 - fltplt */
	/** 건물 - buld */
	/** 수송 - trnsp */
	/** 댐시설 - dam */
	/** 기타 - etc */
	/** 소비량 소계 - totCnsmp */
	/** 취수시설금액 - itkplAmt */
	/** 가압시설금액 - prnplcAmt */
	/** 정수시설금액 - fltpltAmt */
	/** 건물금액 - buldAmt */
	/** 수송금액 - trnspAmt */
	/** 댐시설금액 - damAmt */
	/** 기타금액 - etcAmt */
	/** 금액 - totAmt */

	/* ----- 조회결과(위탁) ----- */
	/** 배출시설코드 - dscfcId */
	/** 배출시설명 - dscfcNm */
	/** 소비구분 - cnsmpDiv */
	/** 사용일 - useDe */
	/** 사용량 - usgqty */
	/** 금액 - amt */

	/* ----- 조회결과(차트) ----- */
	/** 사업장명 - dscfcBplcNm */
	/** 데이터 - inqireIemVu */

	@Override
	public String toString() {
		return "CnsmpSttusVo [], " + super.toString();
	}
}