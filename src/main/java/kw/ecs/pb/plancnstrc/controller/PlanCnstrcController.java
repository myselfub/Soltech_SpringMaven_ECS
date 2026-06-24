package kw.ecs.pb.plancnstrc.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import kw.ecs.pb.plancnstrc.service.PlanCnstrcService;
import kw.ecs.pb.plancnstrc.vo.PlanCnstrcVo;
import kw.ecs.zz.cmmn.service.CmmnService;
import kw.ecs.zz.cmmn.vo.CmmnEctccVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * PlanCnstrcController 컨트롤러 클래스
 * 
 * @ClassName PlanCnstrcController.java
 * @Description 계획/건설 - 계획/건설 목록 클래스
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
@RequestMapping("/pb/plancnstrc")
public class PlanCnstrcController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(PlanCnstrcController.class);

	@Resource(name = "planCnstrcService")
	public PlanCnstrcService planCnstrcService;

	@Resource(name = "cmmnService")
	public CmmnService cmmnService;

	/**
	 * 계획/건설의 계획/건설 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작날짜, endDt(*) : 조회종료날짜, ecsBasinDivCd :
	 *            유역구분코드, ecsSetcscDivCd : 발전원구분코드, ntntrsSportYn : 구분(자체, 국고) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-plan-cnstrc.do", method = RequestMethod.GET)
	public ModelAndView retrievePlanCnstrcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PlanCnstrcVo planCnstrcVo = mapper.convertValue(param, PlanCnstrcVo.class);

		if (planCnstrcVo.getStrtDt() == null || "".equals(planCnstrcVo.getStrtDt()) || planCnstrcVo.getEndDt() == null
				|| "".equals(planCnstrcVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(planCnstrcService.retrievePlanCnstrcList(planCnstrcVo));
		}
	}

	/**
	 * 계획/건설의 계획 목록을 조회한다.
	 * 
	 * @param param
	 *            : { planBsnsNm : 계획사업명, planChargerEmpno : 계획 담당자명 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-plan.do", method = RequestMethod.GET)
	public ModelAndView retrievePlanList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PlanCnstrcVo planCnstrcVo = mapper.convertValue(param, PlanCnstrcVo.class);

		return addResponseData(planCnstrcService.retrievePlanList(planCnstrcVo));
	}

	/**
	 * 계획/건설의 계획/건설 목록 상세보기를 조회한다.
	 * 
	 * @param param
	 *            : { planEsntlId(*) : 계획고유ID, cnstrcEsntlId : 건설고유ID }
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Deprecated
	@RequestMapping(value = "select-plan-cnstrc.do", method = RequestMethod.GET)
	public ModelAndView selectPlanCnstrc(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PlanCnstrcVo planCnstrcVo = mapper.convertValue(param, PlanCnstrcVo.class);

		if (planCnstrcVo.getPlanEsntlId() == null || "".equals(planCnstrcVo.getPlanEsntlId())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(planCnstrcService.selectPlanCnstrc(planCnstrcVo));
		}
	}

	/**
	 * 계획/건설의 계획/건설 목록 상세보기 전자문서를 조회한다.
	 * 
	 * @param param
	 *            { planEsntlId(*) : 계획고유ID }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-plan-cnstrc-elctrn-doc.do", method = RequestMethod.GET)
	public ModelAndView retrievePlanCnstrcElctrnDoc(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PlanCnstrcVo planCnstrcVo = mapper.convertValue(param, PlanCnstrcVo.class);

		if (planCnstrcVo.getPlanEsntlId() == null || "".equals(planCnstrcVo.getPlanEsntlId())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(planCnstrcService.retrievePlanCnstrcElctrnDoc(planCnstrcVo));
		}
	}

	/**
	 * 계획/건설의 계획/건설 목록-계획을 저장/수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "save-plan.do", method = RequestMethod.POST)
	public ModelAndView savePlan(Map param) throws Exception {
		Map paramDma = (Map) param.get("dmaPlanCnstrc");
		String planEsntlId = (String) paramDma.get("planEsntlId");
		if (planEsntlId == null || "".equals(planEsntlId)) {
			paramDma.put("planEsntlId", "P_" + Long.toHexString(System.currentTimeMillis()).toUpperCase());
		}

		ParameterMapper pm = new ParameterMapper();
		PlanCnstrcVo planCnstrcVo = (PlanCnstrcVo) pm.getMapData(param, "dmaPlanCnstrc", new PlanCnstrcVo());

		kwDefaultBeanValidator.validate(planCnstrcVo);

		int rtnCnt = (int) planCnstrcService.savePlan(planCnstrcVo).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 계획/건설의 계획/건설 목록-계획 담당부서, 담당자, 수립일을 수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "update-plan.do", method = RequestMethod.POST)
	public ModelAndView updatePlan(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		PlanCnstrcVo planCnstrcVo = (PlanCnstrcVo) pm.getMapData(param, "dmaEctcc", new PlanCnstrcVo());
		int rtnCnt = 0;

		rtnCnt += (int) planCnstrcService.updatePlanData(planCnstrcVo).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 계획/건설의 계획-계획 설비용량, 금액, 계획내용을 수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "update-plan-cpcty-amt-ctnt.do", method = RequestMethod.POST)
	public ModelAndView updatePlanCpctyAmtCtnt(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		PlanCnstrcVo planCnstrcVo = (PlanCnstrcVo) pm.getMapData(param, "dmaPlanCnstrc", new PlanCnstrcVo());
		int rtnCnt = 0;

		kwDefaultBeanValidator.validate(planCnstrcVo);

		rtnCnt += (int) planCnstrcService.updatePlanCpctyAmtCtnt(planCnstrcVo).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 계획/건설의 계획/건설 목록-계획/건설을 삭제한다.
	 * 
	 * @param planEsntlId
	 *            { planEsntlId(*) : 계획고유ID, cnstrcEsntlId : 건설고유ID }
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "delete-plan-cnstrc.do", method = RequestMethod.POST)
	public ModelAndView deletePlanCnstrc(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		PlanCnstrcVo planCnstrcVo = (PlanCnstrcVo) pm.getMapData(param, "dmaPlanCnstrc", new PlanCnstrcVo());
		CmmnEctccVo ectccVo = new CmmnEctccVo();
		ectccVo.setCnstrcEsntlId(planCnstrcVo.getCnstrcEsntlId());

		kwDefaultBeanValidator.validate(planCnstrcVo);
		kwDefaultBeanValidator.validate(ectccVo);

		int cnstrcCnt = (int) planCnstrcService.selectCnstrcCount(planCnstrcVo).get("rtnCnt");
		int rtnCnt = 0;

		if (cnstrcCnt < 2) {
			// 계획 삭제
			rtnCnt += (int) planCnstrcService.deletePlan(planCnstrcVo).get("rtnCnt");
			ectccVo.setPlanEsntlId(planCnstrcVo.getPlanEsntlId());
		}
		// 건설 삭제
		rtnCnt += (int) planCnstrcService.deleteCnstrc(planCnstrcVo).get("rtnCnt");
		// 사업추진절차 프로세스 삭제
		rtnCnt += (int) cmmnService.deleteEctcc(ectccVo).get("rtnCnt");

		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 계획/건설의 계획/건설 목록-건설을 저장/수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "save-cnstrc.do", method = RequestMethod.POST)
	public ModelAndView saveCnstrc(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		PlanCnstrcVo planCnstrcVo = (PlanCnstrcVo) pm.getMapData(param, "dmaPlanCnstrc", new PlanCnstrcVo());
		PlanCnstrcVo planCnstrcVoOld = (PlanCnstrcVo) pm.getMapData(param, "dmaPlanCnstrcOld", new PlanCnstrcVo());

		String cnstrcEsntlId = planCnstrcVo.getCnstrcEsntlId();
		String cmsBsnsCd = planCnstrcVo.getCmsBsnsCd();
		String cmsPrjctCd = planCnstrcVo.getCmsPrjctCd();
		String cmsPrjctSqncIdtfr = planCnstrcVo.getCmsPrjctSqncIdtfr();
		String edptChargerId = planCnstrcVo.getEdptChargerId();
		String cmsBsnsCdOld = planCnstrcVoOld.getCmsBsnsCd();
		String cmsPrjctCdOld = planCnstrcVoOld.getCmsPrjctCd();
		String cmsPrjctSqncIdtfrOld = planCnstrcVoOld.getCmsPrjctSqncIdtfr();

		if (edptChargerId != null) {
			planCnstrcVo.setEdptChargerNm(edptChargerId);
		}

		// 기존 건설ID가 있다면
		if (cnstrcEsntlId != null && !"".equals(cnstrcEsntlId)) {
			CmmnEctccVo ectccVo = new CmmnEctccVo();
			ectccVo.setCnstrcEsntlId(planCnstrcVo.getCnstrcEsntlId());
			kwDefaultBeanValidator.validate(ectccVo);
			if (!StringUtils.equals(cmsBsnsCd, cmsBsnsCdOld) || !StringUtils.equals(cmsPrjctCd, cmsPrjctCdOld)
					|| !StringUtils.equals(cmsPrjctSqncIdtfr, cmsPrjctSqncIdtfrOld)) {
				// 건설 데이터 삭제
				planCnstrcService.deleteCnstrc(planCnstrcVo);
				// 사업추진절차 프로세스 데이터 삭제
				cmmnService.deleteEctcc(ectccVo);

				// 저장데이터가 건설입력이면
				if ((cmsBsnsCd == null || "".equals(cmsBsnsCd)) && (cmsPrjctCd == null || "".equals(cmsPrjctCd))
						&& (cmsPrjctSqncIdtfr == null || "".equals(cmsPrjctSqncIdtfr))) {
					// 건설ID 부여
					planCnstrcVo.setCnstrcEsntlId("C_" + Long.toHexString(System.currentTimeMillis()).toUpperCase());
				} else {
					// 오아시스 전자문서라면 CMS사업코드_CMS프로젝트코드_CMS프로젝트회차식별자 건설ID 부여
					planCnstrcVo.setCnstrcEsntlId("C_" + cmsBsnsCd + "_" + cmsPrjctCd + "_" + cmsPrjctSqncIdtfr);
				}
			}
		} else {
			// 기존 건설ID가 없다면
			if ((cmsBsnsCd == null || "".equals(cmsBsnsCd)) && (cmsPrjctCd == null || "".equals(cmsPrjctCd))
					&& (cmsPrjctSqncIdtfr == null || "".equals(cmsPrjctSqncIdtfr))) {
				// 건설ID 부여
				planCnstrcVo.setCnstrcEsntlId("C_" + Long.toHexString(System.currentTimeMillis()).toUpperCase());
			} else {
				// 오아시스 전자문서라면 CMS사업코드_CMS프로젝트코드_CMS프로젝트회차식별자 건설ID 부여
				planCnstrcVo.setCnstrcEsntlId("C_" + cmsBsnsCd + "_" + cmsPrjctCd + "_" + cmsPrjctSqncIdtfr);
			}
		}

		kwDefaultBeanValidator.validate(planCnstrcVo);

		int rtnCnt = (int) planCnstrcService.saveCnstrc(planCnstrcVo).get("rtnCnt");

		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 계획/건설의 CMS 프로젝트 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작날짜(착공일), endDt(*) : 조회종료날짜, ordgTit : 계약명,
	 *            edptNm : 시행부서명 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-project.do", method = RequestMethod.GET)
	public ModelAndView retrieveProjectList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PlanCnstrcVo planCnstrcVo = mapper.convertValue(param, PlanCnstrcVo.class);

		if (planCnstrcVo.getStrtDt() == null || "".equals(planCnstrcVo.getStrtDt()) || planCnstrcVo.getEndDt() == null
				|| "".equals(planCnstrcVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(planCnstrcService.retrieveProjectList(planCnstrcVo));
		}
	}
}