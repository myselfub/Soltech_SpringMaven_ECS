package kw.ecs.cn.cnsmpsttus.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cn.cnsmpsttus.vo.CnsmpSttusVo;

/**
 * CnsmpSttusService 서비스 인터페이스
 * 
 * @ClassName CnsmpSttusService.java
 * @Description 소비 - 전력에너지 소비현황
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
public interface CnsmpSttusService {
	/**
	 * 소비의 에너지 소비현황의 조회조건 부서를 조회한다.
	 * 
	 * @param @CnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnsmpSttusCndDeptList(CnsmpSttusVo cnsmpSttusVo) throws Exception;

	/**
	 * 소비의 에너지 소비현황 목록을 조회한다.
	 * 
	 * @param @CnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnsmpSttusList(CnsmpSttusVo cnsmpSttusVo) throws Exception;

	/**
	 * 소비의 에너지 소비현황 차트를 조회한다.
	 * 
	 * @param @CnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnsmpSttusChart(CnsmpSttusVo cnsmpSttusVo) throws Exception;

	/**
	 * 소비의 에너지 소비현황 위탁사업장 목록을 조회한다.
	 * 
	 * @param @CnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnsmpSttusCsmtBplcList(CnsmpSttusVo cnsmpSttusVo) throws Exception;
}