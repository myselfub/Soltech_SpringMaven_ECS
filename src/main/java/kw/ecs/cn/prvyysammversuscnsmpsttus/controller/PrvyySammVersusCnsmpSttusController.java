package kw.ecs.cn.prvyysammversuscnsmpsttus.controller;

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

import kw.ecs.cn.prvyysammversuscnsmpsttus.service.PrvyySammVersusCnsmpSttusService;
import kw.ecs.cn.prvyysammversuscnsmpsttus.vo.PrvyySammVersusCnsmpSttusVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * PrvyySammVersusCnsmpSttusController 컨트롤러 클래스
 * 
 * @ClassName PrvyySammVersusCnsmpSttusController.java
 * @Description 소비 - 전년동월대비 소비현황
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
@RequestMapping("/cn/prvyysammversuscnsmpsttus")
public class PrvyySammVersusCnsmpSttusController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(PrvyySammVersusCnsmpSttusController.class);

	@Resource(name = "prvyySammVersusCnsmpSttusService")
	public PrvyySammVersusCnsmpSttusService prvyySammVersusCnsmpSttusService;

	/**
	 * 소비의 전년동월대비 소비현황의 조회조건을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt : 조회년월, ecsBasinDivCd : ECS유역구분코드(유역) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prvyy-samm-versus-cnsmp-sttus-cnd.do", method = RequestMethod.GET)
	public ModelAndView retrievePrvyySammVersusCnsmpSttusCndDeptList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrvyySammVersusCnsmpSttusVo prvyySammVersusCnsmpSttusVo = mapper.convertValue(param,
				PrvyySammVersusCnsmpSttusVo.class);

		return addResponseData(prvyySammVersusCnsmpSttusService
				.retrievePrvyySammVersusCnsmpSttusCndDeptList(prvyySammVersusCnsmpSttusVo));
	}

	/**
	 * 소비의 전년동월대비 소비현황을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 비교조회년월, endDt(*) : 대상조회년월, ecsBasinDivCd :
	 *            ECS유역구분코드(유역) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prvyy-samm-versus-cnsmp-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrievePrvyySammVersusCnsmpSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrvyySammVersusCnsmpSttusVo prvyySammVersusCnsmpSttusVo = mapper.convertValue(param,
				PrvyySammVersusCnsmpSttusVo.class);

		if (prvyySammVersusCnsmpSttusVo.getStrtDt() == null || "".equals(prvyySammVersusCnsmpSttusVo.getStrtDt())
				|| prvyySammVersusCnsmpSttusVo.getEndDt() == null
				|| "".equals(prvyySammVersusCnsmpSttusVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prvyySammVersusCnsmpSttusService
					.retrievePrvyySammVersusCnsmpSttusList(prvyySammVersusCnsmpSttusVo));
		}
	}

	/**
	 * 소비의 전년동월대비 소비현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 비교조회년월, endDt(*) : 대상조회년월, ecsBasinDivCd :
	 *            ECS유역구분코드(유역), ecsChrgDeptId : ECS담당부서ID(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prvyy-samm-versus-cnsmp-sttus-chart.do", method = RequestMethod.GET)
	public ModelAndView retrievePrvyySammVersusCnsmpSttusChartList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrvyySammVersusCnsmpSttusVo prvyySammVersusCnsmpSttusVo = mapper.convertValue(param,
				PrvyySammVersusCnsmpSttusVo.class);

		if (prvyySammVersusCnsmpSttusVo.getStrtDt() == null || "".equals(prvyySammVersusCnsmpSttusVo.getStrtDt())
				|| prvyySammVersusCnsmpSttusVo.getEndDt() == null
				|| "".equals(prvyySammVersusCnsmpSttusVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prvyySammVersusCnsmpSttusService
					.retrievePrvyySammVersusCnsmpSttusChartList(prvyySammVersusCnsmpSttusVo));
		}
	}
}