package kw.ecs.zz.menumng.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kw.ecs.zz.menumng.service.EcsMenuMngService;
import kw.fw.defaults.DefaultController;

/**
 * EcsMenuMngController 컨트롤러 클래스
 * 
 * @ClassName EcsMenuMngController.java
 * @Description 메뉴 컨트롤러 클래스
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
@Controller
@RequestMapping("/zz")
public class EcsMenuMngController extends DefaultController {
	/** LOGGER */
	protected final static Logger LOGGER = Logger.getLogger(EcsMenuMngController.class);
	/** 메뉴관리서비스 */
	@Resource(name = "ecsMenuMngService")
	public EcsMenuMngService ecsMenuMngService;

	/**
	 * 사용자 메뉴 데이터를 조회한다.
	 * 
	 * @param param
	 *            클라이언트에서 전달한 데이터 맵 객체
	 * @return ModelAndView
	 * @throws Exception
	 * @screenId index
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "menumng/retrieveUsrMenu.do")
	public ModelAndView retrieveUsrMenu(Map param) {
		return addResponseData(ecsMenuMngService.retrieveUsrMenu(param));
	}
}