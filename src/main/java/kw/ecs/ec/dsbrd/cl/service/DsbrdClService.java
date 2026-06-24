package kw.ecs.ec.dsbrd.cl.service;

import java.util.List;
import java.util.Map;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * DsbrdClService 서비스 인터페이스
 * 
 * @ClassName DsbrdClService.java
 * @Description 에너지전주기 - 정산 대시보드
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.05.03		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 05. 03
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface DsbrdClService {

	/**
	 * 정산 발전수익을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnExcclcList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 정산 기타수익을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveEtcExcclcList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 정산 소비정산을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnstnExcclcList(ECSDefaultVo ecsDefaultVo) throws Exception;
}