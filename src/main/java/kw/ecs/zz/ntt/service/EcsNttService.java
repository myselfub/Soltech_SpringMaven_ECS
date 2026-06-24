package kw.ecs.zz.ntt.service;

import java.util.List;
import java.util.Map;

/**
 * EcsNttService 서비스 인터페이스 클래스
 * 
 * @ClassName EcsNttService.java
 * @Description 공지사항 서비스 인터페이스 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.08.30		60002958			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 수자원통합 60002958
 * @since 2017. 08. 30.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
public interface EcsNttService {

	/**
	 * 공지팝업 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveNttPopup(Map param) throws Exception;
}