package kw.ecs.cl.drspexcclc.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cl.drspexcclc.vo.DrspExcclcVo;

/**
 * DrspExcclcService 서비스 인터페이스
 * 
 * @ClassName DrspExcclcService.java
 * @Description 정산 - DR 정산 클래스
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
public interface DrspExcclcService {
	/**
	 * 정산의 DR 정산 목록을 조회한다.
	 * 
	 * @param @DrspExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveDrspExcclcList(DrspExcclcVo drspExcclcVo) throws Exception;

	/**
	 * 정산의 DR 정산을 목록을 저장/수정/삭제한다.
	 * 
	 * @param @DrspExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processDrspExcclcList(List<DrspExcclcVo> drspExcclcVoList) throws Exception;
}