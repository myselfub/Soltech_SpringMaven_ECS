package kw.ecs.cn.epbusttus.controller;

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

import kw.ecs.cn.epbusttus.service.EpbuSttusService;
import kw.ecs.cn.epbusttus.vo.EpbuSttusVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * EpbuSttusController 컨트롤러 클래스
 * 
 * @ClassName EpbuSttusController.java
 * @Description 소비 - 광역 전력원단위 현황 클래스
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
@SuppressWarnings({ "rawtypes" })
@Controller
@RequestMapping("/cn/epbusttus")
public class EpbuSttusController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(EpbuSttusController.class);

	@Resource(name = "epbuSttusService")
	public EpbuSttusService epbuSttusService;

	/**
	 * 소비 광역 전력원단위 현황을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작년도, endDt(*) : 조회종료년도, ecsBasinDivCd : 유역,
	 *            ecsChrgDeptId : 부서, ecsCnstscDivCd : 소비원, cnd(*) : 월별/연별 (mnby : 월별, yyby : 연별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-epbu-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrieveEpbuSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		EpbuSttusVo epbuSttusVo = mapper.convertValue(param, EpbuSttusVo.class);

		if (epbuSttusVo.getStrtDt() == null || "".equals(epbuSttusVo.getStrtDt()) || epbuSttusVo.getEndDt() == null
				|| "".equals(epbuSttusVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(epbuSttusService.retrieveEpbuSttusList(epbuSttusVo));
		}
	}
}