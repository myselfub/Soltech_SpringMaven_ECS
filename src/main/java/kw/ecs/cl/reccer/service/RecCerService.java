package kw.ecs.cl.reccer.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cl.reccer.vo.RecCerVo;

/**
 * RecCerService 서비스 인터페이스
 * 
 * @ClassName RecCerService.java
 * @Description 정산 - REC, CER 정산종합
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.02.13		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 02. 13
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface RecCerService {
	/**
	 * 정산의 REC, CER 정산종합을 조회한다.
	 * 
	 * @param @RecCerVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveRecCerList(RecCerVo recCerVo) throws Exception;
}