package kw.ecs.zz.menumng.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kw.ecs.zz.menumng.service.EcsMenuMngService;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.log.MenuLogService;
import kw.fw.util.WebUtil;

/**
 * EcsCtznMenuConectController 컨트롤러 클래스
 * 
 * @ClassName EcsCtznMenuConectController.java
 * @Description 대민메뉴접속 컨트롤러 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.08.28		Yc.J			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창
 * @since 2017. 08. 28.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@Controller
@RequestMapping("/zz")
public class EcsCtznMenuConectController extends DefaultController {
	/** 메뉴관리서비스 */
	@Resource(name = "ecsMenuMngService")
	public EcsMenuMngService ecsMenuMngService;
	/** 메뉴로그서비스 */
	@Resource(name = "menuLogService")
	public MenuLogService menuLogService;

	/**
	 * 사용자 메뉴 로그를 저장한다. intnYn 의 값이 없거나, "N" 일 경우 대외메뉴접속로그에 저장한다. 그 외의 경우면 대내에
	 * 저장한다.
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "menulog/insertUnifMenuConectLog.do")
	public ModelAndView createUnifMenuConectLog(Map<String, Object> param) {

		if (param == null) {
			return addResponseData(ResponseData.STATUS_ERROR);
		}

		Object intnYn = param.get("intnYn");

		param.put("conectIp", WebUtil.getClientIp());

		// 대외, 대내 여부. 기본은 대외.
		if (intnYn == null || (intnYn instanceof String && StringUtils.equals((String) intnYn, "N"))) {
			ecsMenuMngService.insertCtznMenuConectLogTx(param);
		} else {
			ecsMenuMngService.insertMenuConectLogTx(param);
		}

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 사용자 메뉴 로그를 대외에 저장한다.
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "menulog/insertCtznMenuConectLog.do")
	public ModelAndView createCtznMenuConectLog(Map<String, Object> param) {

		if (param == null) {
			return addResponseData(ResponseData.STATUS_ERROR);
		}

		param.put("conectIp", WebUtil.getClientIp());

		ecsMenuMngService.insertCtznMenuConectLogTx(param);
		return addResponseData(ResponseData.STATUS_SUCESS);
	}
}