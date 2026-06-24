package kw.ecs.cn.pwcspcmprsttus.controller;

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

import kw.ecs.cn.pwcspcmprsttus.service.PwcspCmprSttusService;
import kw.ecs.cn.pwcspcmprsttus.vo.PwcspCmprSttusVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * PwcspCmprSttusController 컨트롤러 클래스
 * 
 * @ClassName PwcspCmprSttusController.java
 * @Description 소비 - 사업장 소비전력 비교현황
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
@SuppressWarnings({ "rawtypes" })
@Controller
@RequestMapping("/cn/pwcspcmprsttus")
public class PwcspCmprSttusController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(PwcspCmprSttusController.class);

	@Resource(name = "pwcspCmprSttusService")
	public PwcspCmprSttusService pwcspCmprSttusService;

	/**
	 * 소비의 소비전력 비교현황 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt : 조회시작날짜, endDt : 조회종료날짜, ecsChrgDeptId : 기준부서 ,
	 *            cmprEcsChrgDeptId : 비교부서, cnd(*) : 월별/연별 (mnby : 월별, yyby : 연별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-pwcsp-cmpr-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrievePwcspCmprSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PwcspCmprSttusVo pwcspCmprSttusVo = mapper.convertValue(param, PwcspCmprSttusVo.class);

		if (pwcspCmprSttusVo.getStrtDt() == null || "".equals(pwcspCmprSttusVo.getStrtDt())
				|| pwcspCmprSttusVo.getEcsChrgDeptId() == null || "".equals(pwcspCmprSttusVo.getEcsChrgDeptId())
				|| pwcspCmprSttusVo.getCmprEcsChrgDeptId() == null
				|| "".equals(pwcspCmprSttusVo.getCmprEcsChrgDeptId())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(pwcspCmprSttusService.retrievePwcspCmprSttusList(pwcspCmprSttusVo));
		}
	}

	/**
	 * 소비의 소비전력 비교현황 기준 차트를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt : 조회시작날짜, endDt : 조회종료날짜, ecsChrgDeptId : 기준부서 ,
	 *            cmprEcsChrgDeptId : 비교부서 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-pwcsp-cmpr-sttus-chart.do", method = RequestMethod.GET)
	public ModelAndView retrievePwcspCmprSttusChart(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PwcspCmprSttusVo pwcspCmprSttusVo = mapper.convertValue(param, PwcspCmprSttusVo.class);

		if (pwcspCmprSttusVo.getStrtDt() == null || "".equals(pwcspCmprSttusVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(pwcspCmprSttusService.retrievePwcspCmprSttusChart(pwcspCmprSttusVo));
		}
	}

	/**
	 * 소비의 소비전력 비교현황 비교 차트를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt : 조회시작날짜, endDt : 조회종료날짜, ecsChrgDeptId : 기준부서 ,
	 *            cmprEcsChrgDeptId : 비교부서 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-pwcsp-cmpr-sttus-chart-target.do", method = RequestMethod.GET)
	public ModelAndView retrievePwcspCmprSttusChartTarget(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PwcspCmprSttusVo pwcspCmprSttusVo = mapper.convertValue(param, PwcspCmprSttusVo.class);

		if (pwcspCmprSttusVo.getStrtDt() == null || "".equals(pwcspCmprSttusVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(pwcspCmprSttusService.retrievePwcspCmprSttusChartTarget(pwcspCmprSttusVo));
		}
	}
}