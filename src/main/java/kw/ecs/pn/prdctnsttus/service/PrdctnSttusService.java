package kw.ecs.pn.prdctnsttus.service;

import java.util.List;
import java.util.Map;

import kw.ecs.pn.prdctnsttus.vo.PrdctnSttusVo;

/**
 * PrdctnSttusService 서비스 인터페이스
 * 
 * @ClassName PrdctnSttusService.java
 * @Description 생산 - 전력에너지 생산현황 클래스
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
public interface PrdctnSttusService {
	/**
	 * 생산의 발전월별 생산현황 목록을 조회한다.
	 * 
	 * @param param
	 *            : prdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnSttusSetcscByList(PrdctnSttusVo prdctnSttusVo) throws Exception;

	/**
	 * 생산의 발전월별 생산현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : prdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnSttusSetcscByChartList(PrdctnSttusVo prdctnSttusVo) throws Exception;

	/**
	 * 생산의 부서별 생산현황 목록을 조회한다.
	 * 
	 * @param param
	 *            : prdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnSttusDeptByList(PrdctnSttusVo prdctnSttusVo) throws Exception;

	/**
	 * 생산의 부서별 생산현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : prdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnSttusDeptByChartList(PrdctnSttusVo prdctnSttusVo) throws Exception;
}