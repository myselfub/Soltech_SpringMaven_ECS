package kw.ecs.cl.cnstscexcclc.controller;

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

import kw.ecs.cl.cnstscexcclc.service.CnstscExcclcService;
import kw.ecs.cl.cnstscexcclc.vo.CnstscExcclcVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * CnstscExcclcController 컨트롤러 클래스
 * 
 * @ClassName CnstscExcclcController.java
 * @Description 정산 - 소비원 정산
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
@SuppressWarnings({ "rawtypes" })
@Controller
@RequestMapping("/cl/cnstscexcclc")
public class CnstscExcclcController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(CnstscExcclcController.class);

	@Resource(name = "cnstscExcclcService")
	public CnstscExcclcService cnstscExcclcService;

	/**
	 * 정산의 소비원 정산 자체 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작날짜(일/월/년), endDt(*) : 조회종료날짜(일/월/년), cnd :
	 *            조회구분(daly : 일별, mnby : 월별, yyby : 년별) ecsBasinDivCd : 유역구분코드,
	 *            ecsSetcscDivCd : 발전원구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnstsc-excclc.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnstscExcclcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CnstscExcclcVo cnstscExcclcVo = mapper.convertValue(param, CnstscExcclcVo.class);

		if (cnstscExcclcVo.getStrtDt() == null || "".equals(cnstscExcclcVo.getStrtDt())
				|| cnstscExcclcVo.getEndDt() == null || "".equals(cnstscExcclcVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cnstscExcclcService.retrieveCnstscExcclcList(cnstscExcclcVo));
		}
	}

	/**
	 * 정산의 소비원 정산 차트 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작날짜(일/월/년), endDt(*) : 조회종료날짜(일/월/년), cnd :
	 *            조회구분(daly : 일별, mnby : 월별, yyby : 년별) ecsBasinDivCd : 유역구분코드,
	 *            ecsSetcscDivCd : 발전원구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnstsc-excclc-chart.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnstscExcclcChartList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CnstscExcclcVo cnstscExcclcVo = mapper.convertValue(param, CnstscExcclcVo.class);

		if (cnstscExcclcVo.getStrtDt() == null || "".equals(cnstscExcclcVo.getStrtDt())
				|| cnstscExcclcVo.getEndDt() == null || "".equals(cnstscExcclcVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cnstscExcclcService.retrieveCnstscExcclcChartList(cnstscExcclcVo));
		}
	}

	/**
	 * 정산의 소비원 정산 위탁 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작날짜(일/월/년), endDt(*) : 조회종료날짜(일/월/년), cnd :
	 *            조회구분(daly : 일별, mnby : 월별, yyby : 년별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnstsc-excclc-csmt-bplc.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnstscExcclcCsmtBplcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CnstscExcclcVo cnstscExcclcVo = mapper.convertValue(param, CnstscExcclcVo.class);

		if (cnstscExcclcVo.getStrtDt() == null || "".equals(cnstscExcclcVo.getStrtDt())
				|| cnstscExcclcVo.getEndDt() == null || "".equals(cnstscExcclcVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cnstscExcclcService.retrieveCnstscExcclcCsmtBplcList(cnstscExcclcVo));
		}
	}
}