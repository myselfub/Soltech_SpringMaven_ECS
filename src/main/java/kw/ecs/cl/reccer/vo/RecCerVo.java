package kw.ecs.cl.reccer.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 정산 - REC, CER 정산종합
 * 
 * @ClassName RecCerVo.java
 * @Description REC, CER 정산종합 VO
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
public class RecCerVo extends ECSDefaultVo {
	private static final long serialVersionUID = -4866802633765562528L;

	/* ----- 조회조건 ----- */
	/** 조회연도 - strtDt(SUPER) */

	/* ----- 조회결과 ----- */
	/** 년월 : ym */
	/** 소수력(REC 정산총액(원) - 소수력) : smlhp */
	/** 태양광(REC 정산총액(원) - 태양광) : snpw */
	/** 풍력(REC 정산총액(원) - 풍력) : wdpw */
	/** 시화조력(CER 정산총액(원) - 시화조력) : tdpw */
	/** 해외(CER 정산총액(원) - 해외(파트린드)) : ovsea */
	/** 합계(합계(원)) : sum */

	@Override
	public String toString() {
		return "RecCerVo [], " + super.toString();
	}
}