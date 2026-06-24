package kw.ecs.pn.prvyysammversusprdctnsttus.service;

import java.util.List;
import java.util.Map;

import kw.ecs.pn.prvyysammversusprdctnsttus.vo.PrvyySammVersusPrdctnSttusVo;

/**
 * PrvyySammVersusPrdctnSttusService 서비스 인터페이스
 * 
 * @ClassName PrvyySammVersusPrdctnSttusService.java
 * @Description 생산 - 전년동월대비 생산현황 클래스
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
public interface PrvyySammVersusPrdctnSttusService {
	/**
	 * 발전원별 생산의 전년 동월 대비 생산현황 목록을 조회한다.
	 *
	 * @param param
	 *            : prvyySammVersusPrdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrvyySammVersusPrdctnSttusSetcscByList(
			PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo) throws Exception;

	/**
	 * 발전원별 생산의 전년 동월 대비 생산현황 차트를 조회한다.
	 *
	 * @param param
	 *            : prvyySammVersusPrdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrvyySammVersusPrdctnSttusSetcscByChartList(
			PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo) throws Exception;

	/**
	 * 부서별 생산의 전년 동월 대비 생산현황 목록을 조회한다.
	 *
	 * @param param
	 *            : prvyySammVersusPrdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrvyySammVersusPrdctnSttusDeptByList(
			PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo) throws Exception;

	/**
	 * 부서별 생산의 전년 동월 대비 생산현황 차트 조회한다.
	 *
	 * @param param
	 *            : prvyySammVersusPrdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrvyySammVersusPrdctnSttusDeptByChartList(
			PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo) throws Exception;
}