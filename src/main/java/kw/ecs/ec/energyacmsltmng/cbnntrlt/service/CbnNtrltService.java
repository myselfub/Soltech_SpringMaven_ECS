package kw.ecs.ec.energyacmsltmng.cbnntrlt.service;

import java.util.List;
import java.util.Map;

import kw.ecs.ec.energyacmsltmng.cbnntrlt.vo.CbnNtrltVo;

/**
 * CbnNtrltService 서비스 인터페이스
 * 
 * @ClassName CbnNtrltService.java
 * @Description 에너지전주기 - 전력에너지실적현황의 탄소중립율
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.02.13		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 02. 13
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface CbnNtrltService {
	/**
	 * 전력에너지실적현황의 탄소중립율을 조회한다.
	 * 
	 * @param @CbnNtrltVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCbnNtrltList(CbnNtrltVo cbnNtrltVo) throws Exception;
}