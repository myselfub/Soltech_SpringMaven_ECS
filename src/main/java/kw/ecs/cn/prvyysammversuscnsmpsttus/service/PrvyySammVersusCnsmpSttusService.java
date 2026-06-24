package kw.ecs.cn.prvyysammversuscnsmpsttus.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cn.prvyysammversuscnsmpsttus.vo.PrvyySammVersusCnsmpSttusVo;

/**
 * PrvyySammVersusCnsmpSttusService 서비스 인터페이스
 * 
 * @ClassName PrvyySammVersusCnsmpSttusService.java
 * @Description 소비 - 전년동월대비 소비현황 클래스
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
public interface PrvyySammVersusCnsmpSttusService {
	/**
	 * 소비의 전년동월대비 소비현황의 조회조건을 조회한다.
	 * 
	 * @param @PrvyySammVersusCnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrvyySammVersusCnsmpSttusCndDeptList(
			PrvyySammVersusCnsmpSttusVo prvyySammVersusCnsmpSttusVo) throws Exception;

	/**
	 * 소비의 전년동월대비 소비현황 목록을 조회한다.
	 * 
	 * @param @PrvyySammVersusCnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrvyySammVersusCnsmpSttusList(PrvyySammVersusCnsmpSttusVo prvyySammVersusCnsmpSttusVo)
			throws Exception;

	/**
	 * 소비의 전년동월대비 소비현황 차트를 조회한다.
	 * 
	 * @param @PrvyySammVersusCnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrvyySammVersusCnsmpSttusChartList(PrvyySammVersusCnsmpSttusVo prvyySammVersusCnsmpSttusVo)
			throws Exception;
}