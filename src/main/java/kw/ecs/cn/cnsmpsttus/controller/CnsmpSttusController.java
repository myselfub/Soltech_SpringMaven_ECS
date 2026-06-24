package kw.ecs.cn.cnsmpsttus.controller;

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

import kw.ecs.cn.cnsmpsttus.service.CnsmpSttusService;
import kw.ecs.cn.cnsmpsttus.vo.CnsmpSttusVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * CnsmpSttusController 컨트롤러 클래스
 * 
 * @ClassName CnsmpSttusController.java
 * @Description 소비 - 전력에너지 소비현황
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
@RequestMapping("/cn/cnsmpsttus")
public class CnsmpSttusController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(CnsmpSttusController.class);

	@Resource(name = "cnsmpSttusService")
	public CnsmpSttusService cnsmpSttusService;

	/**
	 * 소비의 에너지 소비현황의 조회조건을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt : 조회년도, ecsBasinDivCd : ECS유역구분코드(부서코드) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnsmp-sttus-cnd.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnsmpSttusCndList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CnsmpSttusVo cnsmpSttusVo = mapper.convertValue(param, CnsmpSttusVo.class);

		return addResponseData(cnsmpSttusService.retrieveCnsmpSttusCndDeptList(cnsmpSttusVo));
	}

	/**
	 * 소비의 에너지 소비현황을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작 년월, endDt(*) : 조회종료 년월, ecsBasinDivCd : 유역구분코드(부서코드), cnd(*) :
	 *            월별/연별 (mnby : 월별, yyby : 연별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnsmp-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnsmpSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CnsmpSttusVo cnsmpSttusVo = mapper.convertValue(param, CnsmpSttusVo.class);

		if (cnsmpSttusVo.getStrtDt() == null || "".equals(cnsmpSttusVo.getStrtDt()) || cnsmpSttusVo.getEndDt() == null
				|| "".equals(cnsmpSttusVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cnsmpSttusService.retrieveCnsmpSttusList(cnsmpSttusVo));
		}
	}

	/**
	 * 소비의 에너지 소비현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작 년월, endDt(*) : 조회종료 년월, ecsBasinDivCd : 유역구분코드(부서코드),
	 *            ecsChrgDeptId(*) : 담당부서코드(부서코드), cnd(*) : 월별/연별 (mnby : 월별,
	 *            yyby : 연별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnsmp-sttus-chart.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnsmpSttusChart(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CnsmpSttusVo cnsmpSttusVo = mapper.convertValue(param, CnsmpSttusVo.class);

		if (cnsmpSttusVo.getStrtDt() == null || "".equals(cnsmpSttusVo.getStrtDt()) || cnsmpSttusVo.getEndDt() == null
				|| "".equals(cnsmpSttusVo.getEndDt()) || cnsmpSttusVo.getEcsChrgDeptId() == null
				|| "".equals(cnsmpSttusVo.getEcsChrgDeptId())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cnsmpSttusService.retrieveCnsmpSttusChart(cnsmpSttusVo));
		}
	}

	/**
	 * 소비의 에너지 소비현황 위탁사업장 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작 년월, endDt(*) : 조회종료 년월, cnd(*) : 월별/연별 (mnby : 월별, yyby : 연별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnsmp-sttus-csmt-bplc.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnsmpSttusCsmtBplcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CnsmpSttusVo cnsmpSttusVo = mapper.convertValue(param, CnsmpSttusVo.class);

		if (cnsmpSttusVo.getStrtDt() == null || "".equals(cnsmpSttusVo.getStrtDt()) || cnsmpSttusVo.getEndDt() == null
				|| "".equals(cnsmpSttusVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cnsmpSttusService.retrieveCnsmpSttusCsmtBplcList(cnsmpSttusVo));
		}
	}
}