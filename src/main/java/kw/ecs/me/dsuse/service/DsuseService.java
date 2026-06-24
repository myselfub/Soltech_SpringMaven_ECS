package kw.ecs.me.dsuse.service;

import java.util.List;
import java.util.Map;

import kw.ecs.me.dsuse.vo.DsuseVo;

/**
 * DsuseService 서비스 인터페이스
 * 
 * @ClassName DsuseService.java
 * @Description 관리/폐기 - 폐기 목록 클래스
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
public interface DsuseService {
	/**
	 * 관리/폐기의 폐기 비용 목록을 조회한다.
	 * 
	 * @param @DsuseVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveDsuseList(DsuseVo dsuseVo) throws Exception;

	/**
	 * 관리/폐기의 폐기 목록 상세보기를 저장(수정)한다.
	 * 
	 * @param @DsuseVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map saveDsuse(DsuseVo dsuseVo) throws Exception;
	
	/**
	 * 관리/폐기의 폐기 목록을 삭제한다.
	 * 
	 * @param @DsuseVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map deleteDsuse(DsuseVo dsuseVo) throws Exception;
}