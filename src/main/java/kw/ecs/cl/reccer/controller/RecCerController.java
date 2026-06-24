package kw.ecs.cl.reccer.controller;

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

import kw.ecs.cl.reccer.service.RecCerService;
import kw.ecs.cl.reccer.vo.RecCerVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * RecCerController 컨트롤러 클래스
 * 
 * @ClassName RecCerController.java
 * @Description 정산 - REC, CER 정산종합 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.02.13		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 02. 13
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings({ "rawtypes" })
@Controller
@RequestMapping("/cl/reccer")
public class RecCerController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(RecCerController.class);

	@Resource(name = "recCerService")
	public RecCerService recCerService;

	/**
	 * 정산의 REC, CER 정산종합을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-rec-cer.do", method = RequestMethod.GET)
	public ModelAndView retrieveRecCerList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		RecCerVo recCerVo = mapper.convertValue(param, RecCerVo.class);

		if (recCerVo.getStrtDt() == null || "".equals(recCerVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(recCerService.retrieveRecCerList(recCerVo));
		}
	}
}