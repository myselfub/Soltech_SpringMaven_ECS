package kw.ecs.pn.reciss.controller;

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

import kw.ecs.pn.reciss.service.RecIssService;
import kw.ecs.pn.reciss.vo.RecIssVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * RecIssController 컨트롤러 클래스
 * 
 * @ClassName RecIssController.java
 * @Description 생산 - REC 발급량
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
@RequestMapping("/pn/reciss")
public class RecIssController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(RecIssController.class);

	@Resource(name = "recIssService")
	public RecIssService recIssService;

	/**
	 * 생산의 REC 발급량 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도, ecsBasinDivCd : 유역구분코드, ecsSetcscDivCd :
	 *            발전원구분코드, ecsElcpwstnDivCd : 발전소구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-rec-iss.do", method = RequestMethod.GET)
	public ModelAndView retrieveRecIssList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		RecIssVo recIssVo = mapper.convertValue(param, RecIssVo.class);

		if (recIssVo.getStrtDt() == null || "".equals(recIssVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(recIssService.retrieveRecIssList(recIssVo));
		}
	}

	/**
	 * 생산의 REC 발급량 목록을 목록을 저장/수정/삭제한다.
	 * 
	 * @param param
	 *            : @RecIssVo 의 데이터
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-rec-iss.do", method = RequestMethod.POST)
	public ModelAndView processRecIssList(Map param) throws Exception {
		List<Map> paramDlt = (List<Map>) param.get("dltRecIssList");
		for (Map paramDma : paramDlt) {
			if ("C".equals(paramDma.get("rowStatus"))) {
				String recEqpCdNm = (String) paramDma.get("recEqpCdNm");
				if (recEqpCdNm == null || recEqpCdNm.equals("")) {
					paramDma.put("recEqpCdNm", paramDma.get("elcpwstnNm"));
				}
			}
		}

		ParameterMapper pm = new ParameterMapper();
		List<RecIssVo> recIssVoList = (List<RecIssVo>) pm.getListData(param, "dltRecIssList", new RecIssVo());

		kwDefaultBeanValidator.validate(recIssVoList);

		int rtnCnt = (int) recIssService.processRecIssList(recIssVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}
}