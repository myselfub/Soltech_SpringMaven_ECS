package kw.ecs.cl.wthtexcclc.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cl.wthtexcclc.vo.WthtEqpSttusVo;
import kw.ecs.cl.wthtexcclc.vo.WthtExcclcSttusVo;

/**
 * WthtExcclcService 서비스 인터페이스
 * 
 * @ClassName WthtExcclcService.java
 * @Description 정산 - 수열 정산 클래스
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
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface WthtExcclcService {
	/**
	 * 정산의 수열 설비현황 목록을 조회한다.
	 * 
	 * @param @WthtExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveWthtEqpSttusList(WthtEqpSttusVo wthtEqpSttusVo) throws Exception;

	/**
	 * 정산의 수열 설비현황 목록을 저장/수정/삭제한다.
	 * 
	 * @param @WthtExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processWthtEqpSttusList(List<WthtEqpSttusVo> wthtEqpSttusVoList) throws Exception;

	/**
	 * 정산의 수열 정산현황 목록을 조회한다.
	 * 
	 * @param @WthtExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveWthtExcclcSttusList(WthtExcclcSttusVo wthtExcclcSttusVo) throws Exception;

	/**
	 * 정산의 수열 정산현황 목록을 저장/수정/삭제한다.
	 * 
	 * @param @WthtExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processWthtExcclcSttusList(List<WthtExcclcSttusVo> wthtExcclcSttusVoList) throws Exception;
}