package kw.ecs.me.wtwkeltengmsrins.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import kw.ecs.me.wtwkeltengmsrins.service.WtwkEltengMsrinsService;
import kw.ecs.me.wtwkeltengmsrins.vo.WtwkEltengMsrinsVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * WtwkEltengMsrinsController 컨트롤러 클
 * 
 * @ClassName WtwkEltengMsrinsController.java
 * @Description 관리/폐기 - 수전(수도) 전력량계 관리
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
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/me/wtwkeltengmsrins")
public class WtwkEltengMsrinsController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(WtwkEltengMsrinsController.class);

	@Resource(name = "wtwkEltengMsrinsService")
	public WtwkEltengMsrinsService wtwkEltengMsrinsService;

	/**
	 * 관리/폐기의 수전 전력량계 관리 조회조건 자체시설명 목록을 조회한다.
	 * 
	 * @param param
	 *            : { ecsChrgDeptId : 부서코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-wtwk-elteng-msrins-cnd-itslf-fclty-nm.do", method = RequestMethod.GET)
	public ModelAndView retrieveWtwkEltengMsrinsCndItslfFcltyNmList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		WtwkEltengMsrinsVo wtwkEltengMsrinsVo = mapper.convertValue(param, WtwkEltengMsrinsVo.class);

		return addResponseData(wtwkEltengMsrinsService.retrieveWtwkEltengMsrinsCndItslfFcltyNmList(wtwkEltengMsrinsVo));
	}

	/**
	 * 관리/폐기의 수전 전력량계 관리 목록을 조회한다.
	 * 
	 * @param param
	 *            : { ecsChrgDeptId : 부서코드, itslfFcltyNm : 자체시설명 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-wtwk-elteng-msrins.do", method = RequestMethod.GET)
	public ModelAndView retrieveWtwkEltengMsrinsList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		WtwkEltengMsrinsVo wtwkEltengMsrinsVo = mapper.convertValue(param, WtwkEltengMsrinsVo.class);

		return addResponseData(wtwkEltengMsrinsService.retrieveWtwkEltengMsrinsList(wtwkEltengMsrinsVo));
	}

	/**
	 * 관리/폐기의 수전 전력량계 관리 목록을 저장/수정/삭제한다.
	 * 
	 * @param @WtwkEltengMsrinsVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-wtwk-elteng-msrins.do", method = RequestMethod.POST)
	public ModelAndView processWtwkEltengMsrinsList(Map param) throws Exception {
		List<Map> paramDlt = (List<Map>) param.get("dltWtwkEltengMsrinsList");
		for (Map paramDma : paramDlt) {
			if ("C".equals(paramDma.get("rowStatus"))) {
				String ecsChrgDeptId = (String) paramDma.get("ecsChrgDeptId");
				if (ecsChrgDeptId == null || ecsChrgDeptId.equals("")) {
					paramDma.put("ecsChrgDeptId", paramDma.get("deptNm"));
				}
			}
		}

		ParameterMapper pm = new ParameterMapper();
		List<WtwkEltengMsrinsVo> wtwkEltengMsrinsVoList = (List<WtwkEltengMsrinsVo>) pm.getListData(param,
				"dltWtwkEltengMsrinsList", new WtwkEltengMsrinsVo());

		kwDefaultBeanValidator.validate(wtwkEltengMsrinsVoList);

		int rtnCnt = (int) wtwkEltengMsrinsService.processWtwkEltengMsrinsList(wtwkEltengMsrinsVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}
}