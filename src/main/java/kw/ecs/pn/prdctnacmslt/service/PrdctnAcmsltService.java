package kw.ecs.pn.prdctnacmslt.service;

import java.util.List;
import java.util.Map;

import kw.ecs.pn.prdctnacmslt.vo.PrdctnAcmsltVo;

/**
 * PrdctnAcmsltService 서비스 인터페이스
 * 
 * @ClassName PrdctnAcmsltService.java
 * @Description 생산 - 전력에너지 생산실적 클래스
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
public interface PrdctnAcmsltService {

	/**
	 * 생산의 에너지 생산실적-발전량을 조회한다.
	 * 
	 * @param param
	 *            : @PrdctnAcmsltVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnAcmsltElyrsQyList(PrdctnAcmsltVo prdctnAcmsltVo) throws Exception;

	/**
	 * 생산의 에너지 생산실적-전력거래량(송전량)을 조회한다.
	 * 
	 * @param param
	 *            : @PrdctnAcmsltVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnAcmsltEpwrDelngQyList(PrdctnAcmsltVo prdctnAcmsltVo) throws Exception;

	/**
	 * 생산의 에너지 생산실적-소내소비를 조회한다.
	 * 
	 * @param param
	 *            : @PrdctnAcmsltVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnAcmsltInhouseCnstqyList(PrdctnAcmsltVo prdctnAcmsltVo) throws Exception;

	/**
	 * 생산의 에너지 생산실적-발전수익을 조회한다.
	 * 
	 * @param param
	 *            : @PrdctnAcmsltVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnAcmsltElyrsErnList(PrdctnAcmsltVo prdctnAcmsltVo) throws Exception;

	/**
	 * 생산의 에너지 생산실적-발전단가를 조회한다.
	 * 
	 * @param param
	 *            : @PrdctnAcmsltVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnAcmsltElyrsUpcList(PrdctnAcmsltVo prdctnAcmsltVo) throws Exception;

	/**
	 * 생산의 에너지 생산실적-가동률를 조회한다.
	 * 
	 * @param param
	 *            : @PrdctnAcmsltVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnAcmsltOrtoList(PrdctnAcmsltVo prdctnAcmsltVo) throws Exception;
}