package kw.ecs.ec.energyacmsltmng.re100.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import kw.ecs.ec.energyacmsltmng.re100.service.Re100Service;
import kw.ecs.ec.energyacmsltmng.re100.vo.Re100Vo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * Re100Controller 컨트롤러 클래스
 * 
 * @ClassName Re100Controller.java
 * @Description 에너지전주기 - 전력에너지실적현황의 RE100 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.02.17		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 02. 17
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/ec/energyacmsltmng/re100")
public class Re100Controller extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(Re100Controller.class);

	@Resource(name = "re100Service")
	public Re100Service re100Service;

	/**
	 * 전력에너지실적현황의 RE100을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-re100.do", method = RequestMethod.GET)
	public ModelAndView retrieveRe100List(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Re100Vo re100Vo = mapper.convertValue(param, Re100Vo.class);

		if (re100Vo.getStrtDt() == null || "".equals(re100Vo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(re100Service.retrieveRe100List(re100Vo));
		}
	}

	/**
	 * 전력에너지실적현황의 RE100을 저장(수정)한다.
	 * 
	 * @param @Re100Vo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "save-re100.do", method = RequestMethod.POST)
	public ModelAndView saveRe100List(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<Re100Vo> re100VoListTemp = (List<Re100Vo>) pm.getListData(param, "dltRe100List", new Re100Vo());

		List<Re100Vo> re100VoList = re100VoListTemp.stream()
				.filter(re100Vo -> re100Vo.getEcsElcpwstnDivCd() != null && !re100Vo.getEcsElcpwstnDivCd().equals("")
						&& re100Vo.getIemNm() != null
						&& (re100Vo.getIemNm().equals("elyrsQy") || re100Vo.getIemNm().equals("issQy")))
				.collect(Collectors.toList());

		kwDefaultBeanValidator.validate(re100VoList);

		int rtnCnt = (int) re100Service.saveRe100(re100VoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}
}