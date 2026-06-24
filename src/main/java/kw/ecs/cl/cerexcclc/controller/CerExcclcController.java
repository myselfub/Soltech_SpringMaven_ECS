package kw.ecs.cl.cerexcclc.controller;

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

import kw.ecs.cl.cerexcclc.service.CerExcclcService;
import kw.ecs.cl.cerexcclc.vo.CerExcclcVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * CerExcclcController 컨트롤러 클래스
 * 
 * @ClassName CerExcclcController.java
 * @Description 정산 - CER 정산
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.17		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 17
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/cl/cerexcclc")
public class CerExcclcController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(CerExcclcController.class);

	@Resource(name = "cerExcclcService")
	public CerExcclcService cerExcclcService;

	/**
	 * 정산의 CER 정산을 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도, ecsElcpwstnDivCd : 발전소구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cer-excclc.do", method = RequestMethod.GET)
	public ModelAndView retrieveCerExcclcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CerExcclcVo cerExcclcVo = mapper.convertValue(param, CerExcclcVo.class);

		if (cerExcclcVo.getStrtDt() == null || "".equals(cerExcclcVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cerExcclcService.retrieveCerExcclcList(cerExcclcVo));
		}
	}

	/**
	 * 정산의 CER 정산을 목록을 저장/수정/삭제한다.
	 * 
	 * @param @CerExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-cer-excclc-snpw.do", method = RequestMethod.POST)
	public ModelAndView processCerExcclcSnpwList(Map param) throws Exception {
		List<Map> paramDlt = (List<Map>) param.get("dltCerExcclcList");
		for (Map paramDma : paramDlt) {
			if ("C".equals(paramDma.get("rowStatus"))) {
				String ecsElcpwstnDivCd = (String) paramDma.get("ecsElcpwstnDivCd");
				if (ecsElcpwstnDivCd == null || ecsElcpwstnDivCd.equals("")) {
					paramDma.put("ecsElcpwstnDivCd", paramDma.get("elcpwstnNm"));
				}
			}
		}

		ParameterMapper pm = new ParameterMapper();
		List<CerExcclcVo> cerExcclcVoList = (List<CerExcclcVo>) pm.getListData(param, "dltCerExcclcList",
				new CerExcclcVo());

		kwDefaultBeanValidator.validate(cerExcclcVoList);

		int rtnCnt = (int) cerExcclcService.processCerExcclcList(cerExcclcVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}
}