package kw.ecs.pn.prdctnacmslt.controller;

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

import kw.ecs.pn.prdctnacmslt.service.PrdctnAcmsltService;
import kw.ecs.pn.prdctnacmslt.vo.PrdctnAcmsltVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * PrdctnAcmsltController 컨트롤러 클래스
 * 
 * @ClassName PrdctnAcmsltController.java
 * @Description 생산 - 전력에너지 생산실적
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
@RequestMapping("/pn/prdctnacmslt")
public class PrdctnAcmsltController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(PrdctnAcmsltController.class);

	@Resource(name = "prdctnAcmsltService")
	public PrdctnAcmsltService prdctnAcmsltService;

	/**
	 * 생산의 에너지 생산실적-발전량을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도/조회시작년도, endDt : 조회종료년도, cnd : 일/월별 조건,
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsSetcscDivCd :
	 *            ECS발전원구분코드(발전원), ecsElcpwstnDivCd : ECS담당부서ID(발전소), cnd(*) :
	 *            월별/연별 (mnby : 월별, yyby : 연별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-acmslt-elyrs-qy.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnAcmsltElyrsQyList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrdctnAcmsltVo prdctnAcmsltVo = mapper.convertValue(param, PrdctnAcmsltVo.class);

		if (prdctnAcmsltVo.getStrtDt() == null || "".equals(prdctnAcmsltVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prdctnAcmsltService.retrievePrdctnAcmsltElyrsQyList(prdctnAcmsltVo));
		}
	}

	/**
	 * 생산의 에너지 생산실적-전력거래량(송전량)을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도/조회시작년도, endDt : 조회종료년도, cnd : 일/월별 조건,
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsSetcscDivCd :
	 *            ECS발전원구분코드(발전원), ecsElcpwstnDivCd : ECS담당부서ID(발전소), cnd(*) :
	 *            월별/연별 (mnby : 월별, yyby : 연별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-acmslt-epwr-delng-qy.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnAcmsltEpwrDelngQyList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrdctnAcmsltVo prdctnAcmsltVo = mapper.convertValue(param, PrdctnAcmsltVo.class);

		if (prdctnAcmsltVo.getStrtDt() == null || "".equals(prdctnAcmsltVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prdctnAcmsltService.retrievePrdctnAcmsltEpwrDelngQyList(prdctnAcmsltVo));
		}
	}

	/**
	 * 생산의 에너지 생산실적-소내소비를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도/조회시작년도, endDt : 조회종료년도, cnd : 일/월별 조건,
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsSetcscDivCd :
	 *            ECS발전원구분코드(발전원), ecsElcpwstnDivCd : ECS담당부서ID(발전소), cnd(*) :
	 *            월별/연별 (mnby : 월별, yyby : 연별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-inhouse-cnstqy-upc.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnAcmsltInhouseCnstqyList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrdctnAcmsltVo prdctnAcmsltVo = mapper.convertValue(param, PrdctnAcmsltVo.class);

		if (prdctnAcmsltVo.getStrtDt() == null || "".equals(prdctnAcmsltVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prdctnAcmsltService.retrievePrdctnAcmsltInhouseCnstqyList(prdctnAcmsltVo));
		}
	}

	/**
	 * 생산의 에너지 생산실적-발전수익을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도/조회시작년도, endDt : 조회종료년도, cnd : 일/월별 조건,
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsSetcscDivCd :
	 *            ECS발전원구분코드(발전원), ecsElcpwstnDivCd : ECS담당부서ID(발전소), cnd(*) :
	 *            월별/연별 (mnby : 월별, yyby : 연별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-acmslt-elyrs-ern.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnAcmsltElyrsErnList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrdctnAcmsltVo prdctnAcmsltVo = mapper.convertValue(param, PrdctnAcmsltVo.class);

		if (prdctnAcmsltVo.getStrtDt() == null || "".equals(prdctnAcmsltVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prdctnAcmsltService.retrievePrdctnAcmsltElyrsErnList(prdctnAcmsltVo));
		}
	}

	/**
	 * 생산의 에너지 생산실적-발전단가를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도/조회시작년도, endDt : 조회종료년도, cnd : 일/월별 조건,
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsSetcscDivCd :
	 *            ECS발전원구분코드(발전원), ecsElcpwstnDivCd : ECS담당부서ID(발전소), cnd(*) :
	 *            월별/연별 (mnby : 월별, yyby : 연별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-acmslt-elyrs-upc.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnAcmsltElyrsUpcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrdctnAcmsltVo prdctnAcmsltVo = mapper.convertValue(param, PrdctnAcmsltVo.class);

		if (prdctnAcmsltVo.getStrtDt() == null || "".equals(prdctnAcmsltVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prdctnAcmsltService.retrievePrdctnAcmsltElyrsUpcList(prdctnAcmsltVo));
		}
	}

	/**
	 * 생산의 에너지 생산실적-가동률를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도/조회시작년도, endDt : 조회종료년도, cnd : 일/월별 조건,
	 *            ecsBasinDivCd : ECS유역구분코드(유역), ecsSetcscDivCd :
	 *            ECS발전원구분코드(발전원), ecsElcpwstnDivCd : ECS담당부서ID(발전소), cnd(*) :
	 *            월별/연별 (mnby : 월별, yyby : 연별) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-acmslt-orto.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnAcmsltOrtoList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PrdctnAcmsltVo prdctnAcmsltVo = mapper.convertValue(param, PrdctnAcmsltVo.class);

		if (prdctnAcmsltVo.getStrtDt() == null || "".equals(prdctnAcmsltVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(prdctnAcmsltService.retrievePrdctnAcmsltOrtoList(prdctnAcmsltVo));
		}
	}
}