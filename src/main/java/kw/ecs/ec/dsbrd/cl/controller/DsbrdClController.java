package kw.ecs.ec.dsbrd.cl.controller;

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
import kw.ecs.ec.dsbrd.cl.service.DsbrdClService;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * DsbrdClController 컨트롤러 클래스
 * 
 * @ClassName DsbrdClController.java
 * @Description 에너지전주기 - 정산 대시보드 클래스
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
@RequestMapping("/ec/cl")
public class DsbrdClController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(DsbrdClController.class);

	@Resource(name = "dsbrdClService")
	public DsbrdClService dsbrdClService;

	/**
	 * 정산 발전수익을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회 시작 년도, endDt(*) : 조회 종료 년도, inqireDe : 조회
	 *            년도, ecsBasinDivCd : ECS유역구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-excclc.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnExcclcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdClService.retrievePrdctnExcclcList(ecsDefaultVo));
		}
	}

	/**
	 * 정산 기타수익을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회 시작 년도, endDt(*) : 조회 종료 년도, ecsBasinDivCd :
	 *            ECS유역구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-etc-excclc.do", method = RequestMethod.GET)
	public ModelAndView retrieveEtcExcclcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdClService.retrieveEtcExcclcList(ecsDefaultVo));
		}
	}

	/**
	 * 정산 소비정산을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회 시작 년도, endDt(*) : 조회 종료 년도, inqireDe : 조회
	 *            년도, ecsBasinDivCd : ECS유역구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnstn-excclc.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnstnExcclcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdClService.retrieveCnstnExcclcList(ecsDefaultVo));
		}
	}
}