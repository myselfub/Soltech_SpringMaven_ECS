package kw.ecs.zz.login.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import kw.ecs.zz.login.vo.IntnUsrInfoVo;

/**
 * EcsIntnLoginService 서비스 인터페이스 클래스
 * 
 * @ClassName EcsIntnLoginService.java
 * @Description 로그인 서비스 인터페이스 클래스
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
public interface EcsIntnLoginService {
	public ModelAndView loginIntnUsr(IntnUsrInfoVo dmstUsrInfoVo, HttpServletRequest request) throws Exception;

	public ModelAndView logOutIntnUsr(IntnUsrInfoVo dmstUsrInfoVo, HttpServletRequest request) throws Exception;
}