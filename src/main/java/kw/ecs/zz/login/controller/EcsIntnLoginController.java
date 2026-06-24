package kw.ecs.zz.login.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kw.fw.defaults.DefaultController;
import kw.fw.util.KwUserDetailHelper;
import kw.fw.util.ParameterMapper;
import kw.scm.sc.login.service.IntnLoginService;
import kw.scm.sc.login.vo.IntnUsrInfoVo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * EcsIntnLoginController 컨트롤러 클래스
 * 
 * @ClassName EcsIntnLoginController.java
 * @Description 대내사용자로그인 컨트롤러 클래스
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
public class EcsIntnLoginController extends DefaultController {

	protected final static Logger LOGGER = Logger.getLogger(EcsIntnLoginController.class);

	@Resource(name = "ecsIntnLoginService")
	public IntnLoginService ecsIntnLoginService;

	/**
	 * 대내사용자 로그인을 처리를 한다.
	 * 
	 * @param param
	 *            클라이언트에서 전달한 데이터 맵 객체
	 * @return ModelAndView
	 * @throws Exception
	 * @screenId login
	 */
	@RequestMapping(value = "login/loginIntnUsr.do")
	public ModelAndView loginIntnUsr(Map<String, Object> param, HttpServletRequest request) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		IntnUsrInfoVo intnUsrInfoVo = (IntnUsrInfoVo) pm.getMapData(param, "dmaReqInfo", new IntnUsrInfoVo());
		kwDefaultBeanValidator.validate(intnUsrInfoVo);
		return ecsIntnLoginService.loginIntnUsr(intnUsrInfoVo, request);
	}

	@RequestMapping(value = "login/logoutIntnUsr.do")
	public ModelAndView logoutIntnUsr(Map<String, Object> param, HttpServletRequest request) throws Exception {
		// System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%% LOG OUT " +
		// KwUserDetailHelper.getAuthenticatedUser().getUsrId());
		LOGGER.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  LOG OUT " + KwUserDetailHelper.getAuthenticatedUser().getUsrId());
		return addResponseData("0", "로그아웃 되었습니다.");
	}
}