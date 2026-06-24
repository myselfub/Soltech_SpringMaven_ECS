package kw.ecs.ec.dsbrd.pbme.service;

import java.util.List;
import java.util.Map;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * DsbrdPbmeService 서비스 인터페이스
 * 
 * @ClassName DsbrdPbmeService.java
 * @Description 에너지전주기 - 계획/건설/관리/폐기 대시보드
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.05.03		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 05. 03
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface DsbrdPbmeService {
	/**
	 * 계획/건설/관리/폐기 건수, 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비) PBME를 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePbmeSttusList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 계획/건설/관리/폐기 건수, 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 발전원별
	 * 수립/진행/완료(수선유지/개대체/점검정비) 등을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePbmeSttusSetcscList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 계획/건설/관리/폐기 건수, 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 유역별
	 * 수립/진행/완료(수선유지/개대체/점검정비) 등을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePbmeSttusBasinList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 유역별 계획의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePSttusBasinList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 유역별 건설의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBSttusBasinList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 유역별 관리의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveMSttusBasinList(ECSDefaultVo ecsDefaultVo) throws Exception;

	/**
	 * 유역별 폐기의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveESttusBasinList(ECSDefaultVo ecsDefaultVo) throws Exception;
}