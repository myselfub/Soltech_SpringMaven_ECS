package kw.ecs.ec.energyacmsltmng.re100.service;

import java.util.List;
import java.util.Map;

import kw.ecs.ec.energyacmsltmng.re100.vo.Re100Vo;

/**
 * Re100Service 서비스 인터페이스
 * 
 * @ClassName Re100Service.java
 * @Description 에너지전주기 - 전력에너지실적현황의 RE100
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.02.17		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 02. 17
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface Re100Service {
	/**
	 * 전력에너지실적현황의 RE100을 조회한다.
	 * 
	 * @param @Re100Vo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveRe100List(Re100Vo re100Vo) throws Exception;

	/**
	 * 전력에너지실적현황의 RE100을 저장(수정)한다.
	 * 
	 * @param @Re100Vo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map saveRe100(List<Re100Vo> re100VoList) throws Exception;
}