package kw.ecs.pb.plancnstrc.service;

import java.util.List;
import java.util.Map;

import kw.ecs.pb.plancnstrc.vo.PlanCnstrcVo;

/**
 * PlanCnstrcService 서비스 인터페이스
 * 
 * @ClassName PlanCnstrcService.java
 * @Description 계획/건설 - 계획/건설 목록 클래스
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
public interface PlanCnstrcService {
	/**
	 * 계획/건설의 계획/건설 목록을 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePlanCnstrcList(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 계획 목록을 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePlanList(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 계획/건설 목록 상세보기를 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	public Map selectPlanCnstrc(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 계획/건설 목록 상세보기 전자문서를 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePlanCnstrcElctrnDoc(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 계획/건설 목록-계획을 저장/수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	public Map savePlan(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 계획/건설 목록-계획의 세부사항을 저장/수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	public Map savePlanData(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 계획/건설 목록-계획 담당부서, 담당자, 수립일을 수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	public Map updatePlanData(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 계획-계획 설비용량, 금액, 계획내용을 수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	public Map updatePlanCpctyAmtCtnt(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 계획/건설 목록-계획을 삭제한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	public Map deletePlan(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 계획/건설 목록-건설을 저장/수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	public Map saveCnstrc(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 계획/건설 목록- 계획-건설의 개수를 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	public Map selectCnstrcCount(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 계획/건설 목록-건설을 삭제한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	public Map deleteCnstrc(PlanCnstrcVo planCnstrcVo) throws Exception;

	/**
	 * 계획/건설의 CMS 프로젝트 목록을 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveProjectList(PlanCnstrcVo planCnstrcVo) throws Exception;
}