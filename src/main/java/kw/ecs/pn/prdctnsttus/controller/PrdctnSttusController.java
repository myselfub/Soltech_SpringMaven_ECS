package kw.ecs.pn.prdctnsttus.controller;

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

import kw.ecs.pn.prdctnsttus.service.PrdctnSttusService;
import kw.ecs.pn.prdctnsttus.vo.PrdctnSttusVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * PrdctnSttusController 컨트롤러 클래스
 * 
 * @ClassName PrdctnSttusController.java
 * @Description 생산 - 전력에너지 생산현황
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
@RequestMapping("/pn/prdctnsttus")
public class PrdctnSttusController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(PrdctnSttusController.class);

	@Resource(name = "prdctnSttusService")
	public PrdctnSttusService prdctnSttusService;

	/**
	 * 생산의 발전월별 생산현황을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연월, ecsSetcscDivCd : ECS발전원구분코드(발전원),
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsChrgDeptId : ECS담당부서ID(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-sttus-setcsc.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnSttusSetcscByList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrdctnSttusVo prdctnSttusVo = mapper.convertValue(param, PrdctnSttusVo.class);

		if (prdctnSttusVo.getStrtDt() == null || "".equals(prdctnSttusVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prdctnSttusService.retrievePrdctnSttusSetcscByList(prdctnSttusVo));
		}
	}

	/**
	 * 생산의 발전월별 생산현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연월, ecsSetcscDivCd : ECS발전원구분코드(발전원),
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsChrgDeptId : ECS담당부서ID(부서),
	 *            cnd : year/month(연누계/월누계) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-sttus-setcsc-chart.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnSttusSetcscByChartList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrdctnSttusVo prdctnSttusVo = mapper.convertValue(param, PrdctnSttusVo.class);

		if (prdctnSttusVo.getStrtDt() == null || "".equals(prdctnSttusVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prdctnSttusService.retrievePrdctnSttusSetcscByChartList(prdctnSttusVo));
		}
	}

	/**
	 * 생산의 부서별 생산현황을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연월, ecsSetcscDivCd : ECS발전원구분코드(발전원),
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsChrgDeptId : ECS담당부서ID(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-sttus-dept.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnSttusDeptByList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrdctnSttusVo prdctnSttusVo = mapper.convertValue(param, PrdctnSttusVo.class);

		if (prdctnSttusVo.getStrtDt() == null || "".equals(prdctnSttusVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prdctnSttusService.retrievePrdctnSttusDeptByList(prdctnSttusVo));
		}
	}

	/**
	 * 생산의 부서별 생산현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연월, ecsSetcscDivCd : ECS발전원구분코드(발전원),
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsChrgDeptId : ECS담당부서ID(부서),
	 *            cnd : year/month(연누계/월누계) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-sttus-dept-chart.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnSttusDeptByChartList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrdctnSttusVo prdctnSttusVo = mapper.convertValue(param, PrdctnSttusVo.class);

		if (prdctnSttusVo.getStrtDt() == null || "".equals(prdctnSttusVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prdctnSttusService.retrievePrdctnSttusDeptByChartList(prdctnSttusVo));
		}
	}
}