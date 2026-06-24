package kw.ecs.zz.sitestats.controller;

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

import kw.ecs.common.vo.ECSDefaultVo;
import kw.ecs.zz.sitestats.service.SiteStatsService;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * CmmnController 컨트롤러 클래스
 * 
 * @ClassName SiteStatsController.java
 * @Description 로그 관리 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.07.01		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 07. 01
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings({ "rawtypes" })
@Controller
@RequestMapping("/zz/sitestats")
public class SiteStatsController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(SiteStatsController.class);

	@Resource(name = "siteStatsService")
	public SiteStatsService siteStatsService;

	/**
	 * 로그 관리 사이트 총 방문자수 목록을 조회한다.
	 * 
	 * @param param
	 *            : { cnd(*) : 일별/월별 (daly : 일별, mnby : 월별), strtDt(*) : 조회 시작
	 *            날짜(년월일/년월), endDt(*) : 조회 종료 날짜(년월일/년월)}
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-visitr-cnt-by-dt.do", method = RequestMethod.GET)
	public ModelAndView retrieveVisitrCntByDt(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getCnd() == null || "".equals(ecsDefaultVo.getCnd()) || ecsDefaultVo.getStrtDt() == null
				|| "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(siteStatsService.retrieveVisitrCntByDt(ecsDefaultVo));
		}
	}

	/**
	 * 로그 관리 사이트 총 부서별 방문자수 목록을 조회한다.
	 * 
	 * @param param
	 *            : { cnd(*) : 일별/월별 (daly : 일별, mnby : 월별), strtDt(*) : 조회 시작
	 *            날짜(년월일/년월), endDt(*) : 조회 종료 날짜(년월일/년월)}
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-dept-visitr-cnt-by-dt.do", method = RequestMethod.GET)
	public ModelAndView retrieveDeptVisitrCntByDt(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getCnd() == null || "".equals(ecsDefaultVo.getCnd()) || ecsDefaultVo.getStrtDt() == null
				|| "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(siteStatsService.retrieveDeptVisitrCntByDt(ecsDefaultVo));
		}
	}

	/**
	 * 로그 관리 사이트 월별/년별 총 방문자수 목록을 조회한다.
	 * 
	 * @param param
	 *            : { cnd(*) : 일별/월별 (daly : 일별, mnby : 월별), strtDt(*) : 조회 시작
	 *            날짜(년월일/년월), endDt(*) : 조회 종료 날짜(년월일/년월)}
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-mt-yy-visitr-cnt-by-dt.do", method = RequestMethod.GET)
	public ModelAndView retrieveMtYyVisitrCntByDt(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getCnd() == null || "".equals(ecsDefaultVo.getCnd()) || ecsDefaultVo.getStrtDt() == null
				|| "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(siteStatsService.retrieveMtYyVisitrCntByDt(ecsDefaultVo));
		}
	}

	/**
	 * 로그 관리 메뉴별 방문자수 목록을 조회한다.
	 * 
	 * @param param
	 *            : { cnd(*) : 일별/월별 (daly : 일별, mnby : 월별), strtDt(*) : 조회 시작
	 *            날짜(년월일/년월), endDt(*) : 조회 종료 날짜(년월일/년월)}
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-visitr-cnt-by-menu.do", method = RequestMethod.GET)
	public ModelAndView retrieveVisitrCntByMenu(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getCnd() == null || "".equals(ecsDefaultVo.getCnd()) || ecsDefaultVo.getStrtDt() == null
				|| "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(siteStatsService.retrieveVisitrCntByMenu(ecsDefaultVo));
		}
	}
}