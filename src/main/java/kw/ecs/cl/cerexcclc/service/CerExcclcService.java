package kw.ecs.cl.cerexcclc.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cl.cerexcclc.vo.CerExcclcVo;

/**
 * CerExcclcService 서비스 인터페이스
 * 
 * @ClassName CerExcclcService.java
 * @Description 정산 - CER 정산 클래스
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
public interface CerExcclcService {
	/**
	 * 정산의 CER 정산 목록을 조회한다.
	 * 
	 * @param @CerExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCerExcclcList(CerExcclcVo cerExcclcVo) throws Exception;

	/**
	 * 정산의 CER 정산 목록을 저장/수정/삭제한다.
	 * 
	 * @param @CerExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processCerExcclcList(List<CerExcclcVo> cerExcclcVoList) throws Exception;
}