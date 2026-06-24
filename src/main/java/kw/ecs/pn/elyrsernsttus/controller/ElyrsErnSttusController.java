package kw.ecs.pn.elyrsernsttus.controller;

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

import kw.ecs.pn.elyrsernsttus.service.ElyrsErnSttusService;
import kw.ecs.pn.elyrsernsttus.vo.ElyrsErnSttusVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * ElyrsErnSttusController 컨트롤러 클래스
 * 
 * @ClassName ElyrsErnSttusController.java
 * @Description 생산 - 계획대비 발전수익 현황 클래스
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
@RequestMapping("/pn/elyrsernsttus")
public class ElyrsErnSttusController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(ElyrsErnSttusController.class);

	@Resource(name = "elyrsErnSttusService")
	public ElyrsErnSttusService elyrsErnSttusService;

	/**
	 * 생산 계획대비 발전수익 현황을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작년도, endDt(*) : 조회종료년도, ecsBasinDivCd :
	 *            ECS유역구분코드(유역), ecsSetcscDivCd : ECS발전원구분코드(발전원), ecsChrgDeptId
	 *            : ECS발전원구분코드(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-elyrs-ern-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrieveElyrsErnSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ElyrsErnSttusVo elyrsErnSttusVo = mapper.convertValue(param, ElyrsErnSttusVo.class);

		if (elyrsErnSttusVo.getStrtDt() == null || "".equals(elyrsErnSttusVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(elyrsErnSttusService.retrieveElyrsErnSttusList(elyrsErnSttusVo));
		}
	}
}