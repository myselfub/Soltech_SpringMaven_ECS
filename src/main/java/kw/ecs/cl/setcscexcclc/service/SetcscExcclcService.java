package kw.ecs.cl.setcscexcclc.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cl.setcscexcclc.vo.SetcscExcclcVo;

/**
 * SetcscExcclcService 서비스 인터페이스
 * 
 * @ClassName SetcscExcclcService.java
 * @Description 정산 - 발전원 정산 클래스
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
public interface SetcscExcclcService {
	/**
	 * 정산의 발전원 정산 목록을 조회한다.
	 * 
	 * @param @SetcscExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveSetcscExcclcList(SetcscExcclcVo setcscExcclcVo) throws Exception;

	/**
	 * 정산의 전력거래 수수료 목록을 조회한다.
	 * 
	 * @param @SetcscExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveEpwrDelngFee(SetcscExcclcVo setcscExcclcVo) throws Exception;
}