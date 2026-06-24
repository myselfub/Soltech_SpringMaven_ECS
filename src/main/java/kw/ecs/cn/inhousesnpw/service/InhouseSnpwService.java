package kw.ecs.cn.inhousesnpw.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cn.inhousesnpw.vo.InhouseSnpwVo;

/**
 * InhouseSnpwService 서비스 인터페이스
 * 
 * @ClassName InhouseSnpwService.java
 * @Description 소비 - Net-Zero 소내태양광 현황
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.02.17		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 02. 17
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface InhouseSnpwService {
	/**
	 * 소비 Net-Zero 소내태양광 현황의 소내태양광발전량을 조회한다.
	 * 
	 * @param @InhouseSnpwVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveInhouseSnpwList(InhouseSnpwVo inhouseSnpwVo) throws Exception;

	/**
	 * 소비 Net-Zero 소내태양광 현황의 소내태양광발전량 예측값을 조회한다.
	 * 
	 * @param @InhouseSnpwVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveInhouseSnpwPredictList(InhouseSnpwVo inhouseSnpwVo) throws Exception;
}