package kw.ecs.me.cnvreqp.service;

import java.util.List;
import java.util.Map;

import kw.ecs.me.cnvreqp.vo.CnvrEqpVo;

/**
 * CnvrEqpService 서비스 인터페이스
 * 
 * @ClassName CnvrEqpService.java
 * @Description 관리/폐기 - 비오차시험/변환장치 관리대장 (변환설비)
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.13		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 13
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface CnvrEqpService {
	/**
	 * 관리/폐기의 변환설비 관리 목록을 조회한다.
	 * 
	 * @param @CnvrEqpVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnvrEqpList(CnvrEqpVo cnvrEqpVo) throws Exception;

	/**
	 * 관리/폐기의 변환설비 관리 목록을 저장/수정/삭제한다.
	 * 
	 * @param @CnvrEqpVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processCnvrEqpList(List<CnvrEqpVo> cnvrEqpVoList) throws Exception;
}