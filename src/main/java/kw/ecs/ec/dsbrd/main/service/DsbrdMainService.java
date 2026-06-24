package kw.ecs.ec.dsbrd.main.service;

import java.util.List;
import java.util.Map;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * DsbrdMainService 서비스 인터페이스
 * 
 * @ClassName DsbrdMainService.java
 * @Description 에너지전주기 - 메인 대시보드
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
public interface DsbrdMainService {
	/**
	 * 메인 SMP, K-Water 판매단가를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveSleUpcList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 메인 K-Water 판매단가를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveKWaterUpcList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 메인 RE100 이행률을 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveRe100FlflList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 메인 전력에너지 전주기 현황 생산/소비 데이터를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCyclePCList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 메인 유역현황도 데이터를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBasinSttusList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 메인 유역현황도 유역별 - 지도 정보(지사들의 좌표, 크기 등) 데이터를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBasinMapInfoList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 메인 유역현황도 유역별 - 부서 생산 데이터를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBasinDeptPrdctnSttusList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 메인 유역현황도 유역별 - 부서 소비 데이터를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBasinDeptCnstnSttusList(ECSDefaultVo ecsDefaultVo) throws Exception;
}