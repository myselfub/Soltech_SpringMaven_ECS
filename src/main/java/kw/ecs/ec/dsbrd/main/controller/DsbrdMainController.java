package kw.ecs.ec.dsbrd.main.controller;

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
import kw.ecs.ec.dsbrd.main.service.DsbrdMainService;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * DsbrdMainController 컨트롤러 클래스
 * 
 * @ClassName DsbrdMainController.java
 * @Description 에너지전주기 - 메인 대시보드 클래스
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
@RequestMapping("/ec/main")
public class DsbrdMainController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(DsbrdMainController.class);

	@Resource(name = "dsbrdMainService")
	public DsbrdMainService dsbrdMainService;

	/**
	 * 메인 SMP 판매단가를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt : 조회연도 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-sle-upc.do", method = RequestMethod.GET)
	public ModelAndView retrieveSleUpcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdMainService.retrieveSleUpcList(ecsDefaultVo));
		}
	}

	/**
	 * 메인 K-Water 판매단가를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt : 조회연도 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-kwater-upc.do", method = RequestMethod.GET)
	public ModelAndView retrieveKWaterUpcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdMainService.retrieveKWaterUpcList(ecsDefaultVo));
		}
	}

	/**
	 * 메인 RE100 이행률을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt : 조회 시작 년도, endDt : 조회 종료 년도 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-re100-flfl.do", method = RequestMethod.GET)
	public ModelAndView retrieveRe100FlflList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdMainService.retrieveRe100FlflList(ecsDefaultVo));
		}
	}

	/**
	 * 메인 전력에너지 전주기 현황 생산/소비 데이터를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt : 조회 시작 년도, endDt : 조회 종료 년도, inqireDe : 조회 일자,
	 *            ecsBasinDivCd : 유역 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cycle-pc.do", method = RequestMethod.GET)
	public ModelAndView retrieveCyclePCList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt()) || ecsDefaultVo.getInqireDe() == null
				|| "".equals(ecsDefaultVo.getInqireDe())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdMainService.retrieveCyclePCList(ecsDefaultVo));
		}
	}

	/**
	 * 메인 유역현황도 데이터를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회 시작 년월, endDt(*) : 조회 종료 년월 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-basin-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrieveBasinSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdMainService.retrieveBasinSttusList(ecsDefaultVo));
		}
	}

	/**
	 * 메인 유역현황도 유역별 - 지도 정보(지사들의 좌표, 크기 등) 데이터를 조회한다.
	 * 
	 * @param param
	 *            : { ecsBasinDivCd : ECS유역구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-basin-map-info.do", method = RequestMethod.GET)
	public ModelAndView retrieveBasinMapInfoList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(dsbrdMainService.retrieveBasinMapInfoList(ecsDefaultVo));
	}

	/**
	 * 메인 유역현황도 유역별 - 부서 생산 데이터를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회 시작 년도, endDt(*) : 조회 종료 년도,
	 *            ecsBasinDivCd(*) : ECS유역구분코드, ecsChrgDeptId : ECS담당부서ID(부서/지사)
	 *            }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-basin-dept-prdctn-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrieveBasinDeptPrdctnSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdMainService.retrieveBasinDeptPrdctnSttusList(ecsDefaultVo));
		}
	}

	/**
	 * 메인 유역현황도 유역별 - 부서 소비 데이터를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회 시작 년도, endDt(*) : 조회 종료 년도,
	 *            ecsBasinDivCd(*) : ECS유역구분코드, ecsChrgDeptId : ECS담당부서ID(부서/지사)
	 *            }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-basin-dept-cnstn-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrieveBasinDeptPCSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt()) || ecsDefaultVo.getEndDt() == null
				|| "".equals(ecsDefaultVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdMainService.retrieveBasinDeptCnstnSttusList(ecsDefaultVo));
		}
	}
}