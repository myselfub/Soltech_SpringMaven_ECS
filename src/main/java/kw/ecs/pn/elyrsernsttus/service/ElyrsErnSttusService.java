package kw.ecs.pn.elyrsernsttus.service;

import java.util.List;
import java.util.Map;

import kw.ecs.pn.elyrsernsttus.vo.ElyrsErnSttusVo;

/**
 * ElyrsErnSttusService 서비스 인터페이스
 * 
 * @ClassName ElyrsErnSttusService.java
 * @Description 생산 - 계획대비 발전수익 현황
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
public interface ElyrsErnSttusService {
	/**
	 * 생산 계획대비 발전수익 현황을 조회한다.
	 * 
	 * @param @ElyrsErnSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveElyrsErnSttusList(ElyrsErnSttusVo elyrsErnSttusVo) throws Exception;
}