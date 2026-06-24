package kw.ecs.ec.dsbrd.pbme.controller;

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
import kw.ecs.ec.dsbrd.pbme.service.DsbrdPbmeService;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * DsbrdPbmeController 컨트롤러 클래스
 * 
 * @ClassName DsbrdPbmeController.java
 * @Description 에너지전주기 - 계획/건설/관리/폐기 대시보드 클래스
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
@RequestMapping("/ec/pbme")
public class DsbrdPbmeController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(DsbrdPbmeController.class);

	@Resource(name = "dsbrdPbmeService")
	public DsbrdPbmeService dsbrdPbmeService;

	/**
	 * 계획/건설/관리/폐기 건수, 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비) PBME를 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작연도, endDt(*) : 조회종료연도 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-pbme-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrievePbme5YearList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPbmeService.retrievePbmeSttusList(ecsDefaultVo));
		}
	}

	/**
	 * 계획/건설/관리/폐기 건수, 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 발전원별
	 * 수립/진행/완료(수선유지/개대체/점검정비) 등을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작연도, endDt(*) : 조회종료연도 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-pbme-sttus-setcsc.do", method = RequestMethod.GET)
	public ModelAndView retrievePbmeYearList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPbmeService.retrievePbmeSttusSetcscList(ecsDefaultVo));
		}
	}

	/**
	 * 계획/건설/관리/폐기 건수, 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 유역별
	 * 수립/진행/완료(수선유지/개대체/점검정비) 등을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작연도, endDt(*) : 조회종료연도, ecsBasinDivCd : 유역
	 *            }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-pbme-sttus-basin.do", method = RequestMethod.GET)
	public ModelAndView retrievePbmeSttusBasinList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPbmeService.retrievePbmeSttusBasinList(ecsDefaultVo));
		}
	}

	/**
	 * 유역별 계획의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작연도, endDt(*) : 조회종료연도, ecsBasinDivCd : 유역
	 *            }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-p-sttus-basin.do", method = RequestMethod.GET)
	public ModelAndView retrievePSttusBasinList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPbmeService.retrievePSttusBasinList(ecsDefaultVo));
		}
	}

	/**
	 * 유역별 건설의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작연도, endDt(*) : 조회종료연도, ecsBasinDivCd : 유역
	 *            }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-b-sttus-basin.do", method = RequestMethod.GET)
	public ModelAndView retrieveBSttusBasinList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPbmeService.retrieveBSttusBasinList(ecsDefaultVo));
		}
	}

	/**
	 * 유역별 관리의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작연도, endDt(*) : 조회종료연도, ecsBasinDivCd : 유역
	 *            }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-m-sttus-basin.do", method = RequestMethod.GET)
	public ModelAndView retrieveMSttusBasinList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPbmeService.retrieveMSttusBasinList(ecsDefaultVo));
		}
	}

	/**
	 * 유역별 폐기의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작연도, endDt(*) : 조회종료연도, ecsBasinDivCd : 유역
	 *            }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-e-sttus-basin.do", method = RequestMethod.GET)
	public ModelAndView retrieveESttusBasinList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getStrtDt() == null || "".equals(ecsDefaultVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsbrdPbmeService.retrieveESttusBasinList(ecsDefaultVo));
		}
	}
}