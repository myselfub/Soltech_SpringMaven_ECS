package kw.ecs.cl.cnstscexcclc.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cl.cnstscexcclc.vo.CnstscExcclcVo;

/**
 * CnstscExcclcService 서비스 인터페이스
 * 
 * @ClassName CnstscExcclcService.java
 * @Description 정산 - 소비원 정산 클래스
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
public interface CnstscExcclcService {
	/**
	 * 정산의 소비원 정산 자체 목록을 조회한다.
	 * 
	 * @param @CnstscExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnstscExcclcList(CnstscExcclcVo cnstscExcclcVo) throws Exception;

	/**
	 * 정산의 소비원 정산 차트 목록을 조회한다.
	 * 
	 * @param @CnstscExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnstscExcclcChartList(CnstscExcclcVo cnstscExcclcVo) throws Exception;

	/**
	 * 정산의 소비원 정산 위탁 목록을 조회한다.
	 * 
	 * @param @CnstscExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnstscExcclcCsmtBplcList(CnstscExcclcVo cnstscExcclcVo) throws Exception;
}