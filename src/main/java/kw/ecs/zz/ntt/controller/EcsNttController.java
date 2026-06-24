package kw.ecs.zz.ntt.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kw.ecs.zz.ntt.service.EcsNttService;
import kw.fw.defaults.DefaultController;

/**
 * EcsNttController 컨트롤러 클래스
 * 
 * @ClassName EcsNttController.java
 * @Description 공지사항 컨트롤러 클래스
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
@Controller
@RequestMapping("/zz/ntt")
public class EcsNttController extends DefaultController {

	protected final static Logger LOGGER = Logger.getLogger(EcsNttController.class);

	@Resource(name = "ecsNttService")
	public EcsNttService ecsNttService;

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping("/retrieveNttPopup.do")
	public ModelAndView retrieveNttPopup(Map param) throws Exception {
		return addResponseData(ecsNttService.retrieveNttPopup(param));
	}
}