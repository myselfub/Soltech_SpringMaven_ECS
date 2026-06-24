package kw.ecs.me.mntmng.service;

import java.util.List;
import java.util.Map;

import kw.ecs.me.mntmng.vo.BudgetExcutVo;
import kw.ecs.me.mntmng.vo.MntmngVo;

/**
 * MntmngService 서비스 인터페이스
 * 
 * @ClassName MntmngService.java
 * @Description 관리/폐기 - 에너지 관리 클래스
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
public interface MntmngService {
	/**
	 * 관리/폐기의 에너지 관리 목록을 조회한다.
	 * 
	 * @param @MntmngVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveMntmngList(MntmngVo mntmngVo) throws Exception;

	/**
	 * 관리/폐기의 설비관리 상세이력 목록을 조회한다.
	 * 
	 * @param @MntmngVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveMntmngHistList(MntmngVo mntmngVo) throws Exception;

	/**
	 * 관리/폐기의 에너지 관리 목록을 저장/수정/삭제한다.
	 * 
	 * @param @MntmngVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processMntmng(List<MntmngVo> mntmngVoList) throws Exception;

	/**
	 * 관리/폐기의 에너지 관리 상세보기를 저장(수정)한다.
	 * 
	 * @param @MntmngVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map saveMntmng(MntmngVo mntmngVo) throws Exception;

	/**
	 * 관리/폐기의 에너지 관리 상세보기를 삭제한다.
	 * 
	 * @param @MntmngVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map deleteMntmng(MntmngVo mntmngVo) throws Exception;

	/**
	 * 관리/폐기의 예산집행(RFC) 목록을 조회한다.
	 * 
	 * @param @BudgetExcutVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBudgetExcutList(BudgetExcutVo budgetExcutVo) throws Exception;

	/**
	 * 관리/폐기의 예산집행(RFC)를 저장/수정/삭제한다.
	 * 
	 * @param @BudgetExcutVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processBudgetExcut(List<BudgetExcutVo> budgetExcutVoList) throws Exception;
}