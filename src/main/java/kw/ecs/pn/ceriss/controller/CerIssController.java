package kw.ecs.pn.ceriss.controller;

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

import kw.ecs.pn.ceriss.service.CerIssService;
import kw.ecs.pn.ceriss.vo.CerIssVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * CerIssController 컨트롤러 클래스
 * 
 * @ClassName CerIssController.java
 * @Description 생산 - CER 발급량
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.15		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 15
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/pn/ceriss")
public class CerIssController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(CerIssController.class);

	@Resource(name = "cerIssService")
	public CerIssService cerIssService;

	/**
	 * 생산의 CER 발급량 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작년도, endDt(*) : 조회종료년도, ecsElcpwstnDivCd :
	 *            발전소구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cer-iss.do", method = RequestMethod.GET)
	public ModelAndView retrieveCerIssList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CerIssVo cerIssVo = mapper.convertValue(param, CerIssVo.class);

		if (cerIssVo.getStrtDt() == null || "".equals(cerIssVo.getStrtDt()) || cerIssVo.getEndDt() == null
				|| "".equals(cerIssVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cerIssService.retrieveCerIssList(cerIssVo));
		}
	}

	/**
	 * 생산의 CER 발급량 목록을 저장/수정/삭제한다.
	 * 
	 * @param param
	 *            : @CerIssVo 의 데이터
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-cer-iss.do", method = RequestMethod.POST)
	public ModelAndView processCerIssList(Map param) throws Exception {
		List<Map> paramDlt = (List<Map>) param.get("dltCerIssList");
		for (Map paramDma : paramDlt) {
			if ("C".equals(paramDma.get("rowStatus"))) {
				String ecsElcpwstnDivCd = (String) paramDma.get("ecsElcpwstnDivCd");
				if (ecsElcpwstnDivCd == null || ecsElcpwstnDivCd.equals("")) {
					paramDma.put("ecsElcpwstnDivCd", paramDma.get("elcpwstnNm"));
				}
			}
		}

		ParameterMapper pm = new ParameterMapper();
		List<CerIssVo> cerIssVoList = (List<CerIssVo>) pm.getListData(param, "dltCerIssList", new CerIssVo());

		kwDefaultBeanValidator.validate(cerIssVoList);

		int rtnCnt = (int) cerIssService.processCerIssList(cerIssVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}
}