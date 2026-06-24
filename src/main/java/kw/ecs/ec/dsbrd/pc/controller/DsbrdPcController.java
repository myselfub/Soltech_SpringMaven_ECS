package kw.ecs.ec.dsbrd.pc.controller;

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
import kw.ecs.ec.dsbrd.pc.service.DsbrdPcService;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * DsbrdPcController 컨트롤러 클래스
 * 
 * @ClassName DsbrdPcController.java
 * @Description 에너지전주기 - 생산/소비 대시보드 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.05.03		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 05. 03
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings({ "rawtypes" })
@Controller
@RequestMapping("/ec/pc")
public class DsbrdPcController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(DsbrdPcController.class);

	@Resource(name = "dsbrdPcService")
	public DsbrdPcService dsbrdPcService;

	/**
	 * 생산/소비 전력에너지 운영현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작년월, endDt(*) : 조회종료년월, ecsBasinDivCd :
	 *            유역구분코드(한강: 01, 금강: 02, 영섬: 03, 낙동강: 04) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-epwr-energy-oper-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrieveEpwrEnergyOperSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPcService.retrieveEpwrEnergyOperSttusList(ecsDefaultVo));
		}
	}

	/**
	 * 생산/소비 전력생산을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작년월, endDt(*) : 조회종료년월, ecsBasinDivCd :
	 *            ECS유역구분코드(한강: 01, 금강: 02, 영섬: 03, 낙동강: 04) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-epwr.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnEpwrList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPcService.retrievePrdctnEpwrList(ecsDefaultVo));
		}
	}

	/**
	 * 생산/소비 전력소비를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작년월, endDt(*) : 조회종료년월, ecsBasinDivCd :
	 *            ECS유역구분코드(한강: 01, 금강: 02, 영섬: 03, 낙동강: 04) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnstn-epwr.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnstnEpwrList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPcService.retrieveCnstnEpwrList(ecsDefaultVo));
		}
	}

	/**
	 * 생산/소비 유역별 생산량을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작년월, endDt(*) : 조회종료년월, ecsBasinDivCd : 조회
	 *            유역(한강: 01, 금강: 02, 영섬: 03, 낙동강: 04) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnChartList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPcService.retrievePrdctnChartList(ecsDefaultVo));
		}
	}

	/**
	 * 생산/소비 유역별 소비량을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작년월, endDt(*) : 조회종료년월, ecsBasinDivCd : 조회
	 *            유역(한강: 01, 금강: 02, 영섬: 03, 낙동강: 04) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnstn.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnstnChartList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPcService.retrieveCnstnChartList(ecsDefaultVo));
		}
	}

	/**
	 * 탄소중립현황을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회 시작 년도, endDt(*) : 조회 종료 년도, ecsBasinDivCd :
	 *            ECS유역구분코드(유역) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cbn-ntrlt.do", method = RequestMethod.GET)
	public ModelAndView retrieveCbnNtrltList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPcService.retrieveCbnNtrlt(ecsDefaultVo));
		}
	}
}