package kw.ecs.me.mntmng.controller;

import java.util.ArrayList;
import java.util.HashMap;
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

import kw.ecs.me.mntmng.service.MntmngService;
import kw.ecs.me.mntmng.vo.BudgetExcutVo;
import kw.ecs.me.mntmng.vo.MntmngVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;
import kw.scm.sc.file.service.ComnAttchFileMtService;
import kw.scm.sc.file.vo.ComnAttchFileMtVo;

/**
 * MntmngController 컨트롤러 클래스
 * 
 * @ClassName MntmngController.java
 * @Description 관리/폐기 - 에너지 관리
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.13		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 13
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/me/mntmng")
public class MntmngController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(MntmngController.class);

	@Resource(name = "mntmngService")
	public MntmngService mntmngService;

	@Resource(name = "comnAttchFileMtService")
	public ComnAttchFileMtService comnAttchFileMtService;

	/**
	 * 관리/폐기의 에너지 관리 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도, ecsBasinDivCd : ECS유역구분코드(유역),
	 *            ecsChrgDeptId : ECS담당부서ID(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-mntmng.do", method = RequestMethod.GET)
	public ModelAndView retrieveMntmngList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MntmngVo mntmngVo = mapper.convertValue(param, MntmngVo.class);

		if (mntmngVo.getStrtDt() == null || "".equals(mntmngVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(mntmngService.retrieveMntmngList(mntmngVo));
		}
	}

	/**
	 * 관리/폐기의 설비관리 상세이력 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도, ecsSetcscCd : ECS발전원구분코드(발전원),
	 *            ecsChrgDeptId : ECS담당부서ID(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-mntmng-hist.do", method = RequestMethod.GET)
	public ModelAndView retrieveMntmngHistList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MntmngVo mntmngVo = mapper.convertValue(param, MntmngVo.class);

		if (mntmngVo.getStrtDt() == null || "".equals(mntmngVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(mntmngService.retrieveMntmngHistList(mntmngVo));
		}
	}

	/**
	 * 관리/폐기의 에너지 관리 목록을 저장/수정/삭제한다.
	 * 
	 * @param @MntmngVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-mntmng.do", method = RequestMethod.POST)
	public ModelAndView processMntmng(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<Map> paramDlt = (List<Map>) param.get("dltEqpMngList");
		List<Map> atchfDlt1 = (List<Map>) param.get("dltFile1");
		List<Map> atchfDlt2 = (List<Map>) param.get("dltFile2");

		/* 첨부파일 */
		if (atchfDlt1.size() > 0) {
			List<ComnAttchFileMtVo> comnAttchFileMtVoList = (List<ComnAttchFileMtVo>) pm.getListData(param, "dltFile1",
					new ComnAttchFileMtVo());
			comnAttchFileMtVoList.get(0).setAtchflId(comnAttchFileMtVoList.get(0).getAtchflId() + "01");
			if (comnAttchFileMtVoList.get(0).getDocClsCd() == null
					|| "".equals(comnAttchFileMtVoList.get(0).getDocClsCd())) {
				comnAttchFileMtVoList.get(0).setDocClsCd("ECS300");
			}
			comnAttchFileMtService.deleteAttchFile(comnAttchFileMtVoList);
			comnAttchFileMtService.insertAttchFileService(comnAttchFileMtVoList, "ECS", "ECS300");
		}
		if (atchfDlt2.size() > 0) {
			List<ComnAttchFileMtVo> comnAttchFileMtVoList = (List<ComnAttchFileMtVo>) pm.getListData(param, "dltFile2",
					new ComnAttchFileMtVo());
			comnAttchFileMtVoList.get(0).setAtchflId(comnAttchFileMtVoList.get(0).getAtchflId() + "02");
			if (comnAttchFileMtVoList.get(0).getDocClsCd() == null
					|| "".equals(comnAttchFileMtVoList.get(0).getDocClsCd())) {
				comnAttchFileMtVoList.get(0).setDocClsCd("ECS300");
			}
			comnAttchFileMtService.deleteAttchFile(comnAttchFileMtVoList);
			comnAttchFileMtService.insertAttchFileService(comnAttchFileMtVoList, "ECS", "ECS300");
		}

		List<Map> eqpMngList = new ArrayList<Map>();
		List<BudgetExcutVo> budgetExcutVoList = new ArrayList<BudgetExcutVo>();
		BudgetExcutVo budgetExcutVo = null;

		/* DB 저장 */
		for (Map paramDma : paramDlt) {
			if ("C".equals(paramDma.get("rowStatus"))) {
				String ecsSetcscDivCd = (String) paramDma.get("ecsSetcscDivCd");
				if (ecsSetcscDivCd == null || "".equals(ecsSetcscDivCd)) {
					paramDma.put("ecsSetcscDivCd", paramDma.get("setcscNm"));
				}
			} else if ("U".equals(paramDma.get("rowStatus"))) {
				String setcscNm = (String) paramDma.get("setcscNm");
				if (setcscNm != null && !"".equals(setcscNm)) {
					paramDma.put("ecsSetcscDivCd", paramDma.get("setcscNm"));
				}
			}
			if ("C".equals(paramDma.get("rowStatus")) || "U".equals(paramDma.get("rowStatus"))) {
				String iemDivNm = (String) paramDma.get("iemDivNm");
				String iemDivCd = (String) paramDma.get("iemDivCd");
				if (iemDivCd != null && !"".equals(iemDivCd) && iemDivNm.matches("[^0-9]+")) {
					paramDma.put("iemDivNm", iemDivCd);
				}
			}

			if ("Y".equals(paramDma.get("cnd"))) {
				budgetExcutVo = new BudgetExcutVo();
				budgetExcutVo.setSlipNo((String) paramDma.get("cntrctNo"));
				budgetExcutVo.setIemTitCtnt((String) paramDma.get("ordgTit"));
				budgetExcutVo.setEcsChrgDeptId((String) paramDma.get("requstDeptCd"));
				budgetExcutVo.setSlipPstde((String) paramDma.get("competDe"));
				budgetExcutVo.setEntrpsNm((String) paramDma.get("scsbidEntrpsNm"));
				budgetExcutVo.setChargerId((String) paramDma.get("rqstrEmpno"));
				budgetExcutVo.setExcutAmt(String.valueOf(paramDma.get("excutAmt")));
				budgetExcutVo.setSumAmt(String.valueOf(paramDma.get("competam")));
				budgetExcutVo.setEcsSetcscDivCd((String) paramDma.get("ecsSetcscDivCd"));
				budgetExcutVo.setIemDtlCtnt((String) paramDma.get("iemDtlCtnt"));
				budgetExcutVo.setLrgeChckAtchflNm((String) paramDma.get("lrgeChckAtchflNm"));
				budgetExcutVo.setLrgeChckAtchFlpth((String) paramDma.get("lrgeChckAtchFlpth"));
				budgetExcutVo.setDcompChckAtchflNm((String) paramDma.get("dcompChckAtchflNm"));
				budgetExcutVo.setDcompChckAtchFlpth((String) paramDma.get("dcompChckAtchFlpth"));
				budgetExcutVo.setRowStatus((String) paramDma.get("rowStatus"));

				budgetExcutVoList.add(budgetExcutVo);
			} else {
				eqpMngList.add(paramDma);
			}
		}
		Map customParam = new HashMap<String, Object>();
		customParam.put("dltEqpMngList", eqpMngList);

		List<MntmngVo> mntmngVoList = (List<MntmngVo>) pm.getListData(customParam, "dltEqpMngList", new MntmngVo());

		kwDefaultBeanValidator.validate(mntmngVoList);
		kwDefaultBeanValidator.validate(budgetExcutVoList);

		int rtnCnt = (int) mntmngService.processMntmng(mntmngVoList).get("rtnCnt");
		rtnCnt += (int) mntmngService.processBudgetExcut(budgetExcutVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 관리/폐기의 에너지 관리 상세보기를 저장(수정)한다.
	 * 
	 * @param @MntmngVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "save-mntmng.do", method = RequestMethod.POST)
	public ModelAndView saveMntmng(Map param) throws Exception {
		Map paramDma = (Map) param.get("dmaEqpMng");
		String cntrctNo = (String) paramDma.get("cntrctNo");
		if ("C".equals(paramDma.get("rowStatus")) || "U".equals(paramDma.get("rowStatus"))) {
			String iemDivNm = (String) paramDma.get("iemDivNm");
			String iemDivCd = (String) paramDma.get("iemDivCd");
			if (iemDivNm != null && !"".equals(iemDivNm) && iemDivCd.matches("[0-9]+")) {
				paramDma.put("iemDivNm", iemDivCd);
			}
		}

		ParameterMapper pm = new ParameterMapper();
		MntmngVo mntmngVo = (MntmngVo) pm.getMapData(param, "dmaEqpMng", new MntmngVo());

		kwDefaultBeanValidator.validate(mntmngVo);
		if (cntrctNo == null || "".equals(cntrctNo)) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			int rtnCnt = (int) mntmngService.saveMntmng(mntmngVo).get("rtnCnt");
			if (rtnCnt > 0) {
				return addResponseData(ResponseData.STATUS_SUCESS);
			} else {
				return addResponseData(ResponseData.STATUS_ERROR);
			}
		}
	}

	/**
	 * 관리/폐기의 에너지 관리 상세보기를 저장(수정)한다.
	 * 
	 * @param @MntmngVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "delete-mntmng.do", method = RequestMethod.POST)
	public ModelAndView deleteMntmng(Map param) throws Exception {
		Map paramDma = (Map) param.get("dmaEqpMng");
		String cntrctNo = (String) paramDma.get("cntrctNo");

		ParameterMapper pm = new ParameterMapper();
		MntmngVo mntmngVo = (MntmngVo) pm.getMapData(param, "dmaEqpMng", new MntmngVo());

		kwDefaultBeanValidator.validate(mntmngVo);

		if (cntrctNo == null || "".equals(cntrctNo)) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			int rtnCnt = (int) mntmngService.deleteMntmng(mntmngVo).get("rtnCnt");
			if (rtnCnt > 0) {
				return addResponseData(ResponseData.STATUS_SUCESS);
			} else {
				return addResponseData(ResponseData.STATUS_ERROR);
			}
		}
	}

	/**
	 * 관리/폐기의 예산집행(RFC) 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도, ecsChrgDeptId : ECS담당부서ID(부서) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-budget-excut.do", method = RequestMethod.GET)
	public ModelAndView retrieveBudgetExcutList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		BudgetExcutVo budgetExcutVo = mapper.convertValue(param, BudgetExcutVo.class);

		if (budgetExcutVo.getStrtDt() == null || "".equals(budgetExcutVo.getStrtDt())
				|| budgetExcutVo.getEcsChrgDeptId() == null || "".equals(budgetExcutVo.getEcsChrgDeptId())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(mntmngService.retrieveBudgetExcutList(budgetExcutVo));
		}
	}

	/**
	 * 관리/폐기의 예산집행(RFC)를 저장/수정/삭제한다.
	 * 
	 * @param @MntmngVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-budget-excut.do", method = RequestMethod.POST)
	public ModelAndView processBudgetExcut(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<BudgetExcutVo> budgetExcutVoList = (List<BudgetExcutVo>) pm.getListData(param, "dltBudgetExcutList",
				new BudgetExcutVo());

		kwDefaultBeanValidator.validate(budgetExcutVoList);

		int rtnCnt = (int) mntmngService.processBudgetExcut(budgetExcutVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}
}