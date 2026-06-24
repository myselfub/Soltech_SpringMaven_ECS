package kw.ecs.cl.wthtexcclc.controller;

import java.util.List;
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

import kw.ecs.cl.wthtexcclc.service.WthtExcclcService;
import kw.ecs.cl.wthtexcclc.vo.WthtEqpSttusVo;
import kw.ecs.cl.wthtexcclc.vo.WthtExcclcSttusVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * WthtExcclcController 컨트롤러 클래스
 * 
 * @ClassName WthtExcclcController.java
 * @Description 정산 - 수열 정산
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
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/cl/wthtexcclc")
public class WthtExcclcController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(WthtExcclcController.class);

	@Resource(name = "wthtExcclcService")
	public WthtExcclcService wthtExcclcService;

	/**
	 * 정산의 수열 설비현황 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작날짜, endDt(*) : 조회종료날짜, ecsBasinDivCd :
	 *            ECS유역구분코드, iemDivNm : 구분(내부, 외부) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-wtht-eqp-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrieveWthtEqpSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		WthtEqpSttusVo wthtEqpSttusVo = mapper.convertValue(param, WthtEqpSttusVo.class);

		if (wthtEqpSttusVo.getStrtDt() == null || "".equals(wthtEqpSttusVo.getStrtDt())
				|| wthtEqpSttusVo.getEndDt() == null || "".equals(wthtEqpSttusVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(wthtExcclcService.retrieveWthtEqpSttusList(wthtEqpSttusVo));
		}
	}

	/**
	 * 정산의 수열 설비현황 목록을 저장/수정/삭제한다.
	 * 
	 * @param param
	 *            : @WthtEqpSttusVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-wtht-eqp-sttus.do", method = RequestMethod.POST)
	public ModelAndView processWthtEqpSttusList(Map param) throws Exception {
		List<Map> paramDlt = (List<Map>) param.get("dltWthtEqpSttusList");
		for (Map paramDma : paramDlt) {
			if ("C".equals(paramDma.get("rowStatus"))) {
				String ecsChrgDeptId = (String) paramDma.get("ecsChrgDeptId");
				if (ecsChrgDeptId == null || ecsChrgDeptId.equals("")) {
					paramDma.put("ecsChrgDeptId", paramDma.get("deptNm"));
				}
				String iemDivNm = (String) paramDma.get("iemDivNm");
				if (iemDivNm == null || iemDivNm.equals("")) {
					paramDma.put("iemDivNm", paramDma.get("iemDivCd"));
				}
			}
		}

		ParameterMapper pm = new ParameterMapper();
		List<WthtEqpSttusVo> wthtEqpSttusVoList = (List<WthtEqpSttusVo>) pm.getListData(param, "dltWthtEqpSttusList",
				new WthtEqpSttusVo());

		kwDefaultBeanValidator.validate(wthtEqpSttusVoList);

		int rtnCnt = (int) wthtExcclcService.processWthtEqpSttusList(wthtEqpSttusVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 정산의 수열 정산현황 목록을 조회한다.
	 * 
	 * @param param
	 *            : { wthtSuplyBeginDe(*) : 수열공급개시일, eqpNm(*) : 설비명 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-wtht-excclc-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrieveWthtExcclcSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		WthtExcclcSttusVo wthtExcclcSttusVo = mapper.convertValue(param, WthtExcclcSttusVo.class);

		if (wthtExcclcSttusVo.getWthtSuplyBeginDe() == null || "".equals(wthtExcclcSttusVo.getWthtSuplyBeginDe())
				|| wthtExcclcSttusVo.getEqpNm() == null || "".equals(wthtExcclcSttusVo.getEqpNm())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(wthtExcclcService.retrieveWthtExcclcSttusList(wthtExcclcSttusVo));
		}
	}

	/**
	 * 정산의 수열 정산현황 목록을 저장/수정/삭제한다.
	 * 
	 * @param @WthtExcclcSttusVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-wtht-excclc-sttus.do", method = RequestMethod.POST)
	public ModelAndView processWthtExcclcSttusList(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<WthtExcclcSttusVo> wthtExcclcSttusVoList = (List<WthtExcclcSttusVo>) pm.getListData(param,
				"dltWthtExcclcSttusList", new WthtExcclcSttusVo());

		kwDefaultBeanValidator.validate(wthtExcclcSttusVoList);

		int rtnCnt = (int) wthtExcclcService.processWthtExcclcSttusList(wthtExcclcSttusVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}
}