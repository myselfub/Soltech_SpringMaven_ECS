package kw.ecs.zz.menumng.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kw.ecs.zz.menumng.service.EcsMenuMngService;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.log.MenuLogService;
import kw.fw.util.KwUserDetailHelper;
import kw.fw.util.WebUtil;

/**
 * EcsIntnMenuConectController 컨트롤러 클래스
 * 
 * @ClassName EcsIntnMenuConectController.java
 * @Description 대네메뉴접속 컨트롤러 클래스
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
public class EcsIntnMenuConectController extends DefaultController {
	/** 메뉴관리서비스 */
	@Resource(name = "ecsMenuMngService")
	public EcsMenuMngService ecsMenuMngService;
	/** 메뉴로그서비스 */
	@Resource(name = "menuLogService")
	public MenuLogService menuLogService;

	/**
	 * 메뉴접속로그를 생성한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 */
	@RequestMapping(value = "menumng/insertMenuConectLog.do")
	public ModelAndView createMenuConectLog(HttpServletRequest req, Map<String, Object> param) {
		if (param == null) {
			return addResponseData(ResponseData.STATUS_ERROR);
		}

		param.put("usrId", KwUserDetailHelper.getAuthenticatedUser(req).getUsrId());
		param.put("sysDivCd", KwUserDetailHelper.getAuthenticatedUser(req).getSysDivCd());
		param.put("conectIp", WebUtil.getClientIp());

		ecsMenuMngService.insertMenuConectLogTx(param);

		return addResponseData(ResponseData.STATUS_SUCESS);
	}
}