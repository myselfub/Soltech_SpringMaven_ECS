package kw.ecs.cl.setcscexcclc.controller;

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

import kw.ecs.cl.setcscexcclc.service.SetcscExcclcService;
import kw.ecs.cl.setcscexcclc.vo.SetcscExcclcVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * SetcscExcclcController 컨트롤러 클래스
 * 
 * @ClassName SetcscExcclcController.java
 * @Description 정산 - 발전원 정산
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
@SuppressWarnings({ "rawtypes" })
@Controller
@RequestMapping("/cl/setcscexcclc")
public class SetcscExcclcController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(SetcscExcclcController.class);

	@Resource(name = "setcscExcclcService")
	public SetcscExcclcService setcscExcclcService;

	/**
	 * 정산의 발전원 정산 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작날짜(일/월/년), endDt(*) : 조회종료날짜(일/월/년), cnd :
	 *            조회구분(daly : 일별, mnby : 월별, yyby : 년별) ecsBasinDivCd : 유역구분코드,
	 *            ecsSetcscDivCd : 발전원구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-setcsc-excclc.do", method = RequestMethod.GET)
	public ModelAndView retrieveSetcscExcclcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		SetcscExcclcVo setcscExcclcVo = mapper.convertValue(param, SetcscExcclcVo.class);

		if (setcscExcclcVo.getStrtDt() == null || "".equals(setcscExcclcVo.getStrtDt())
				|| setcscExcclcVo.getEndDt() == null || "".equals(setcscExcclcVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(setcscExcclcService.retrieveSetcscExcclcList(setcscExcclcVo));
		}
	}

	/**
	 * 정산의 전력거래 수수료 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작날짜(일/월/년), endDt(*) : 조회종료날짜(일/월/년) ecsBasinDivCd : 유역구분코드,
	 *            ecsSetcscDivCd : 발전원구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-epwr-delng-fee.do", method = RequestMethod.GET)
	public ModelAndView retrieveEpwrDelngFee(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		SetcscExcclcVo setcscExcclcVo = mapper.convertValue(param, SetcscExcclcVo.class);

		if (setcscExcclcVo.getStrtDt() == null || "".equals(setcscExcclcVo.getStrtDt())
				|| setcscExcclcVo.getEndDt() == null || "".equals(setcscExcclcVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(setcscExcclcService.retrieveEpwrDelngFee(setcscExcclcVo));
		}
	}
}