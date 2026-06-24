package kw.ecs.zz.sitestats.service;

import java.util.List;
import java.util.Map;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * SiteStatsService 서비스 인터페이스
 * 
 * @ClassName SiteStatsService.java
 * @Description 로그 관리 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.07.01		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 07. 01
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface SiteStatsService {
	/**
	 * 로그 관리 사이트 총 방문자수 목록을 조회한다.
	 * 
	 * @param ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveVisitrCntByDt(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 로그 관리 사이트 총 부서별 방문자수 목록을 조회한다.
	 * 
	 * @param ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveDeptVisitrCntByDt(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 로그 관리 사이트 월별/년별 총 방문자수 목록을 조회한다.
	 * 
	 * @param ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveMtYyVisitrCntByDt(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 로그 관리 메뉴별 방문자수 목록을 조회한다.
	 * 
	 * @param ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveVisitrCntByMenu(ECSDefaultVo ecsDefaultVo) throws Exception;
}