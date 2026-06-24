package kw.ecs.cl.recexcclc.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cl.recexcclc.vo.RecExcclcVo;

/**
 * RecExcclcService 서비스 인터페이스
 * 
 * @ClassName RecExcclcService.java
 * @Description 정산 - REC 정산 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.17		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 17
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface RecExcclcService {
	/**
	 * 정산의 REC 정산(태양광)을 목록을 조회한다.
	 * 
	 * @param @RecExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveRecExcclcSnpwList(RecExcclcVo recExcclcVo) throws Exception;

	/**
	 * 정산의 REC 정산(태양광)을 목록을 저장/수정/삭제한다.
	 * 
	 * @param @RecExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processRecExcclcSnpwList(List<RecExcclcVo> recExcclcVoList) throws Exception;

	/**
	 * 정산의 REC 정산(비태양광)을 목록을 조회한다.
	 * 
	 * @param @RecExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveRecExcclcNotSnpwList(RecExcclcVo recExcclcVo) throws Exception;

	/**
	 * 정산의 REC 정산(비태양광)을 목록을 저장/수정/삭제한다.
	 * 
	 * @param @RecExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processRecExcclcNotSnpwList(List<RecExcclcVo> recExcclcVoList) throws Exception;
}