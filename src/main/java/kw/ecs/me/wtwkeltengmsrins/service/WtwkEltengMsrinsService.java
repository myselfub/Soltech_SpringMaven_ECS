package kw.ecs.me.wtwkeltengmsrins.service;

import java.util.List;
import java.util.Map;

import kw.ecs.me.wtwkeltengmsrins.vo.WtwkEltengMsrinsVo;

/**
 * WtwkEltengMsrinsService 서비스 인터페이스
 * 
 * @ClassName WtwkEltengMsrinsService.java
 * @Description 관리/폐기 - 수전 전력량계 관리
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.13		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 13
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface WtwkEltengMsrinsService {
	/**
	 * 관리/폐기의 수전 전력량계 관리 조회조건 자체시설명 목록을 조회한다.
	 * 
	 * @param @WtwkEltengMsrinsVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveWtwkEltengMsrinsCndItslfFcltyNmList(WtwkEltengMsrinsVo wtwkEltengMsrinsVo)
			throws Exception;

	/**
	 * 관리/폐기의 수전 전력량계 관리 목록을 조회한다.
	 * 
	 * @param @WtwkEltengMsrinsVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveWtwkEltengMsrinsList(WtwkEltengMsrinsVo wtwkEltengMsrinsVo) throws Exception;

	/**
	 * 관리/폐기의 수전 전력량계 관리 목록을 저장/수정/삭제한다.
	 * 
	 * @param @WtwkEltengMsrinsVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processWtwkEltengMsrinsList(List<WtwkEltengMsrinsVo> wtwkEltengMsrinsVoList) throws Exception;
}