package kw.ecs.me.elyrseltengmsrins.controller;

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

import kw.ecs.me.elyrseltengmsrins.service.ElyrsEltengMsrinsService;
import kw.ecs.me.elyrseltengmsrins.vo.ElyrsEltengMsrinsVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * ElyrsEltengMsrinsController 컨트롤러 클
 * 
 * @ClassName ElyrsEltengMsrinsController.java
 * @Description 관리/폐기 - 발전 전력량계 관리
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
@RequestMapping("/me/elyrseltengmsrins")
public class ElyrsEltengMsrinsController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(ElyrsEltengMsrinsController.class);

	@Resource(name = "elyrsEltengMsrinsService")
	public ElyrsEltengMsrinsService elyrsEltengMsrinsService;

	/**
	 * 관리/폐기의 발전 전력량계 관리 목록을 조회한다.
	 * 
	 * @param param
	 *            : { ecsChrgDeptId : 부서코드, ecsElcpwstnDivCd : 발전소구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-elyrs-elteng-msrins.do", method = RequestMethod.GET)
	public ModelAndView retrieveElyrsEltengMsrinsList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ElyrsEltengMsrinsVo elyrsEltengMsrinsVo = mapper.convertValue(param, ElyrsEltengMsrinsVo.class);

		return addResponseData(elyrsEltengMsrinsService.retrieveElyrsEltengMsrinsList(elyrsEltengMsrinsVo));
	}

	/**
	 * 관리/폐기의 발전 전력량계 관리 목록을 저장/수정/삭제한다.
	 * 
	 * @param @ElyrsEltengMsrinsVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-elyrs-elteng-msrins.do", method = RequestMethod.POST)
	public ModelAndView processElyrsEltengMsrinsList(Map param) throws Exception {
		List<Map> paramDlt = (List<Map>) param.get("dltElyrsEltengMsrinsList");
		for (Map paramDma : paramDlt) {
			if ("C".equals(paramDma.get("rowStatus"))) {
				String ecsElcpwstnDivCd = (String) paramDma.get("ecsElcpwstnDivCd");
				if (ecsElcpwstnDivCd == null || ecsElcpwstnDivCd.equals("")) {
					paramDma.put("ecsElcpwstnDivCd", paramDma.get("elcpwstnNm"));
				}
			}
		}

		ParameterMapper pm = new ParameterMapper();
		List<ElyrsEltengMsrinsVo> elyrsEltengMsrinsVoList = (List<ElyrsEltengMsrinsVo>) pm.getListData(param,
				"dltElyrsEltengMsrinsList", new ElyrsEltengMsrinsVo());

		kwDefaultBeanValidator.validate(elyrsEltengMsrinsVoList);

		int rtnCnt = (int) elyrsEltengMsrinsService.processElyrsEltengMsrinsList(elyrsEltengMsrinsVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 관리/폐기의 발전 전력량계 관리 목록을 저장(수정)한다.
	 * 
	 * @param @ElyrsEltengMsrinsVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "save-elyrs-elteng-msrins.do", method = RequestMethod.POST)
	public ModelAndView saveElyrsEltengMsrinsList(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<ElyrsEltengMsrinsVo> elyrsEltengMsrinsVoList = (List<ElyrsEltengMsrinsVo>) pm.getListData(param,
				"dltElyrsEltengMsrinsList", new ElyrsEltengMsrinsVo());

		kwDefaultBeanValidator.validate(elyrsEltengMsrinsVoList);

		int rtnCnt = (int) elyrsEltengMsrinsService.saveElyrsEltengMsrinsList(elyrsEltengMsrinsVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 관리/폐기의 발전 전력량계 관리 목록을 삭제한다.
	 * 
	 * @param @ElyrsEltengMsrinsVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "delete-elyrs-elteng-msrins.do", method = RequestMethod.POST)
	public ModelAndView deleteElyrsEltengMsrinsList(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<ElyrsEltengMsrinsVo> elyrsEltengMsrinsVoList = (List<ElyrsEltengMsrinsVo>) pm.getListData(param,
				"dltElyrsEltengMsrinsList", new ElyrsEltengMsrinsVo());

		int rtnCnt = (int) elyrsEltengMsrinsService.deleteElyrsEltengMsrinsList(elyrsEltengMsrinsVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}
}