package kw.ecs.pn.reciss.service;

import java.util.List;
import java.util.Map;

import kw.ecs.pn.reciss.vo.RecIssVo;

/**
 * RecIssService 서비스 인터페이스
 * 
 * @ClassName RecIssService.java
 * @Description 생산 - REC 발급량 클래스
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
public interface RecIssService {
	/**
	 * 생산의 REC 발급량 목록을 조회한다.
	 * 
	 * @param param
	 *            : @RecIssVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveRecIssList(RecIssVo recIssVo) throws Exception;

	/**
	 * 생산의 REC 발급량 목록을 목록을 저장/수정/삭제한다.
	 * 
	 * @param param
	 *            : @RecIssVo 의 데이터
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processRecIssList(List<RecIssVo> recIssVoList) throws Exception;
}