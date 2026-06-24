package kw.ecs.zz.menumng.service;

import java.util.List;
import java.util.Map;

/**
 * EcsMenuMngService 서비스 인터페이스 클래스
 * 
 * @ClassName EcsMenuMngService.java
 * @Description 메뉴 서비스 인터페이스 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.07.20		60002841(권영훈)			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 권영훈
 * @since 2017. 07. 20.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
public interface EcsMenuMngService {

	/**
	 * 사용자 메뉴 데이터를 조회한다.
	 * 
	 * @param param
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveUsrMenu(Map param);

	/**
	 * 대네메뉴접속로그 저장한다.
	 * 
	 * @param param
	 * @return
	 */
	public void insertCtznMenuConectLogTx(Map<String, Object> param);

	/**
	 * 메뉴접속로그 저장한다.
	 * 
	 * @param param
	 * @return
	 */
	public void insertMenuConectLogTx(Map<String, Object> param);
}
