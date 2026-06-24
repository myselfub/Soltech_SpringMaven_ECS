package kw.ecs.ec.energyacmsltmng.cbnntrlt.controller;

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

import kw.ecs.ec.energyacmsltmng.cbnntrlt.service.CbnNtrltService;
import kw.ecs.ec.energyacmsltmng.cbnntrlt.vo.CbnNtrltVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * EnergyAcmsltMngCbnNtrltController 컨트롤러 클래스
 * 
 * @ClassName EnergyAcmsltMngCbnNtrltController.java
 * @Description 에너지전주기 - 전력에너지실적현황의 탄소중립율 클래스
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
@RequestMapping("/ec/energyacmsltmng/cbnntrlt")
public class CbnNtrltController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(CbnNtrltController.class);

	@Resource(name = "cbnNtrltService")
	public CbnNtrltService cbnNtrltService;

	/**
	 * 전력에너지실적현황의 탄소중립율을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작날짜, endDt(*) : 조회종료날짜, ecsBasinDivCd :
	 *            ECS유역구분코드(유역), ecsChrgDeptId : ECS담당부서ID(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cbn-ntrlt.do", method = RequestMethod.GET)
	public ModelAndView retrieveCbnNtrltList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CbnNtrltVo cbnNtrltVo = mapper.convertValue(param, CbnNtrltVo.class);

		if (cbnNtrltVo.getStrtDt() == null || "".equals(cbnNtrltVo.getStrtDt()) || cbnNtrltVo.getEndDt() == null
				|| "".equals(cbnNtrltVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cbnNtrltService.retrieveCbnNtrltList(cbnNtrltVo));
		}
		/*
		 * ParameterMapper pm = new ParameterMapper(); CbnNtrltVo cbnNtrltVo =
		 * (CbnNtrltVo) pm.getMapData(param, "dmaSearchParam", new
		 * CbnNtrltVo());
		 * 
		 * return addResponseData(cbnNtrltService.retrieveCbnNtrltList(
		 * cbnNtrltVo));
		 */
	}
}