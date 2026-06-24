package kw.ecs.pn.prvyysammversusprdctnsttus.controller;

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

import kw.ecs.pn.prvyysammversusprdctnsttus.service.PrvyySammVersusPrdctnSttusService;
import kw.ecs.pn.prvyysammversusprdctnsttus.vo.PrvyySammVersusPrdctnSttusVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * PrvyySammVersusPrdctnSttusController 컨트롤러 클래스
 * 
 * @ClassName PrvyySammVersusPrdctnSttusController.java
 * @Description 생산 - 전년동월대비 생산현황
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
@RequestMapping("/pn/prvyysammversusprdctnsttus")
public class PrvyySammVersusPrdctnSttusController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(PrvyySammVersusPrdctnSttusController.class);

	@Resource(name = "prvyySammVersusPrdctnSttusService")
	public PrvyySammVersusPrdctnSttusService prvyySammVersusPrdctnSttusService;

	/**
	 * 생산의 발전원별 전년 동월 대비 생산현황 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 비교 조회 년월, endDt(*) : 대상 조회 년월, 부서별 조건,
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsSetcscDivCd :
	 *            ECS발전원구분코드(발전원), ecsChrgDeptId : ECS담당부서ID(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prvyy-samm-versus-prdctn-sttus-setcsc.do", method = RequestMethod.GET)
	public ModelAndView retrievePrvyySammVersusPrdctnSttusSetcscByList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo = mapper.convertValue(param,
				PrvyySammVersusPrdctnSttusVo.class);

		if (prvyySammVersusPrdctnSttusVo.getStrtDt() == null || "".equals(prvyySammVersusPrdctnSttusVo.getStrtDt())
				|| prvyySammVersusPrdctnSttusVo.getEndDt() == null
				|| "".equals(prvyySammVersusPrdctnSttusVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prvyySammVersusPrdctnSttusService
					.retrievePrvyySammVersusPrdctnSttusSetcscByList(prvyySammVersusPrdctnSttusVo));
		}
	}

	/**
	 * 생산의 발전원별 전년 동월 대비 생산현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 비교 조회 년월, endDt(*) : 대상 조회 년월, 부서별 조건,
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsSetcscDivCd :
	 *            ECS발전원구분코드(발전원), ecsChrgDeptId : ECS담당부서ID(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prvyy-samm-versus-prdctn-sttus-setcsc-chart.do", method = RequestMethod.GET)
	public ModelAndView retrievePrvyySammVersusPrdctnSttusSetcscByChartList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo = mapper.convertValue(param,
				PrvyySammVersusPrdctnSttusVo.class);

		if (prvyySammVersusPrdctnSttusVo.getStrtDt() == null || "".equals(prvyySammVersusPrdctnSttusVo.getStrtDt())
				|| prvyySammVersusPrdctnSttusVo.getEndDt() == null
				|| "".equals(prvyySammVersusPrdctnSttusVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prvyySammVersusPrdctnSttusService
					.retrievePrvyySammVersusPrdctnSttusSetcscByChartList(prvyySammVersusPrdctnSttusVo));
		}
	}

	/**
	 * 생산의 부서별 전년 동월 대비 생산현황 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 비교 조회 년월, endDt(*) : 대상 조회 년월, 부서별 조건,
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsSetcscDivCd :
	 *            ECS발전원구분코드(발전원), ecsChrgDeptId : ECS담당부서ID(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prvyy-samm-versus-prdctn-sttus-dept.do", method = RequestMethod.GET)
	public ModelAndView retrievePrvyySammVersusPrdctnSttusDeptByList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo = mapper.convertValue(param,
				PrvyySammVersusPrdctnSttusVo.class);

		if (prvyySammVersusPrdctnSttusVo.getStrtDt() == null || "".equals(prvyySammVersusPrdctnSttusVo.getStrtDt())
				|| prvyySammVersusPrdctnSttusVo.getEndDt() == null
				|| "".equals(prvyySammVersusPrdctnSttusVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prvyySammVersusPrdctnSttusService
					.retrievePrvyySammVersusPrdctnSttusDeptByList(prvyySammVersusPrdctnSttusVo));
		}
	}

	/**
	 * 생산의 부서별 전년 동월 대비 생산현황 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 비교 조회 년월, endDt(*) : 대상 조회 년월, 부서별 조건,
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsSetcscDivCd :
	 *            ECS발전원구분코드(발전원), ecsChrgDeptId : ECS담당부서ID(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prvyy-samm-versus-prdctn-sttus-dept-chart.do", method = RequestMethod.GET)
	public ModelAndView retrievePrvyySammVersusPrdctnSttusDeptByChartList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo = mapper.convertValue(param,
				PrvyySammVersusPrdctnSttusVo.class);

		if (prvyySammVersusPrdctnSttusVo.getStrtDt() == null || "".equals(prvyySammVersusPrdctnSttusVo.getStrtDt())
				|| prvyySammVersusPrdctnSttusVo.getEndDt() == null
				|| "".equals(prvyySammVersusPrdctnSttusVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prvyySammVersusPrdctnSttusService
					.retrievePrvyySammVersusPrdctnSttusDeptByChartList(prvyySammVersusPrdctnSttusVo));
		}
	}
}