package kw.ecs.cn.pwcspcmprsttus.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cn.pwcspcmprsttus.vo.PwcspCmprSttusVo;

/**
 * PwcspCmprSttusService 서비스 인터페이스
 * 
 * @ClassName PwcspCmprSttusService.java
 * @Description 소비 - 사업장 소비전력 비교현황 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.15		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 15
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface PwcspCmprSttusService {
	/**
	 * 소비의 소비전력 비교현황 목록을 조회한다.
	 * 
	 * @param @PwcspCmprSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePwcspCmprSttusList(PwcspCmprSttusVo pwcspCmprSttusVo) throws Exception;

	/**
	 * 소비의 소비전력 비교현황 기준 차트를 조회한다.
	 * 
	 * @param @PwcspCmprSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePwcspCmprSttusChart(PwcspCmprSttusVo pwcspCmprSttusVo) throws Exception;

	/**
	 * 소비의 소비전력 비교현황 비교 차트를 조회한다.
	 * 
	 * @param @PwcspCmprSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePwcspCmprSttusChartTarget(PwcspCmprSttusVo pwcspCmprSttusVo) throws Exception;
}