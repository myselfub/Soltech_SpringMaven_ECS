package kw.ecs.me.cnvreqp.controller;

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

import kw.ecs.me.cnvreqp.service.CnvrEqpService;
import kw.ecs.me.cnvreqp.vo.CnvrEqpVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * CnvrEqpController 컨트롤러 클
 * 
 * @ClassName CnvrEqpController.java
 * @Description 관리/폐기 - 비오차시험/변환장치 관리대장 (변환설비)
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
@RequestMapping("/me/cnvreqp")
public class CnvrEqpController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(CnvrEqpController.class);

	@Resource(name = "cnvrEqpService")
	public CnvrEqpService cnvrEqpService;

	/**
	 * 관리/폐기의 변환설비 관리 목록을 조회한다.
	 * 
	 * @param param
	 *            : { ecsElcpwstnDivCd : ECS발전소구분코드, iemCd : 변환기-항목코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnvr-eqp.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnvrEqpList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CnvrEqpVo cnvrEqpVo = mapper.convertValue(param, CnvrEqpVo.class);

		return addResponseData(cnvrEqpService.retrieveCnvrEqpList(cnvrEqpVo));
	}

	/**
	 * 관리/폐기의 변환설비 관리 목록을 저장/수정/삭제한다.
	 * 
	 * @param @CnvrEqpVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-cnvr-eqp.do", method = RequestMethod.POST)
	public ModelAndView processCnvrEqpList(Map param) throws Exception {
		List<Map> paramDlt = (List<Map>) param.get("dltCnvrEqpList");
		for (Map paramDma : paramDlt) {
			if ("C".equals(paramDma.get("rowStatus"))) {
				String ecsElcpwstnDivCd = (String) paramDma.get("ecsElcpwstnDivCd");
				if (ecsElcpwstnDivCd == null || ecsElcpwstnDivCd.equals("")) {
					paramDma.put("ecsElcpwstnDivCd", paramDma.get("ecsElcpwstnDivNm"));
				}
				String iemCd = (String) paramDma.get("iemCd");
				if (iemCd == null || iemCd.equals("")) {
					paramDma.put("iemCd", paramDma.get("iemNm"));
				}
			}
		}

		ParameterMapper pm = new ParameterMapper();
		List<CnvrEqpVo> cnvrEqpVoList = (List<CnvrEqpVo>) pm.getListData(param,
				"dltCnvrEqpList", new CnvrEqpVo());

		kwDefaultBeanValidator.validate(cnvrEqpVoList);

		int rtnCnt = (int) cnvrEqpService.processCnvrEqpList(cnvrEqpVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}
}