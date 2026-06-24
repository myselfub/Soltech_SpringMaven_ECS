package kw.ecs.me.dsuse.controller;

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

import kw.ecs.me.dsuse.service.DsuseService;
import kw.ecs.me.dsuse.vo.DsuseVo;
import kw.ecs.zz.cmmn.service.CmmnService;
import kw.ecs.zz.cmmn.vo.CmmnEctccVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * DsuseController 컨트롤러 클래스
 * 
 * @ClassName DsuseController.java
 * @Description 관리/폐기 - 폐기 목록
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
@RequestMapping("/me/dsuse")
public class DsuseController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(DsuseController.class);

	@Resource(name = "dsuseService")
	public DsuseService dsuseService;

	@Resource(name = "cmmnService")
	public CmmnService cmmnService;

	/**
	 * 관리/폐기의 폐기 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작년도, endDt(*) : 조회종료년도, ecsBasinDivCd :
	 *            유역구분코드, ecsDeptDivCd : 담당부서 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-dsuse.do", method = RequestMethod.GET)
	public ModelAndView retrieveDsuseList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DsuseVo dsuseVo = mapper.convertValue(param, DsuseVo.class);

		if (dsuseVo.getStrtDt() == null || "".equals(dsuseVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(dsuseService.retrieveDsuseList(dsuseVo));
		}
	}

	/**
	 * 관리/폐기의 폐기 목록 상세보기를 저장(수정)한다.
	 * 
	 * @param param
	 *            : { dsuseEsntlId(*) : 폐기고유ID, ecsSetcscDivCd : ECS발전원구분코드,
	 *            dsuseDtlCtnt : 폐기상세내용(폐기내용), eqpCpcty : 설비용량, cmsBsnsCd :
	 *            CMS사업코드, cmsPrjctCd : CMS프로젝트코드, cmsPrjctSqncIdtfr :
	 *            CMS프로젝트회차식별자 }
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "save-dsuse.do", method = RequestMethod.POST)
	public ModelAndView saveDsuse(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		DsuseVo dsuseVo = (DsuseVo) pm.getMapData(param, "dmaSetcscDsusePrcsDtlHist", new DsuseVo());
		DsuseVo dsuseVoOld = (DsuseVo) pm.getMapData(param, "dmaSetcscDsusePrcsDtlHistOld", new DsuseVo());

		String dsuseEsntlId = dsuseVo.getDsuseEsntlId();
		String cmsBsnsCd = dsuseVo.getCmsBsnsCd();
		String cmsPrjctCd = dsuseVo.getCmsPrjctCd();
		String cmsPrjctSqncIdtfr = dsuseVo.getCmsPrjctSqncIdtfr();
		String edptChargerId = dsuseVo.getEdptChargerId();
		String cmsBsnsCdOld = dsuseVoOld.getCmsBsnsCd();
		String cmsPrjctCdOld = dsuseVoOld.getCmsPrjctCd();
		String cmsPrjctSqncIdtfrOld = dsuseVoOld.getCmsPrjctSqncIdtfr();

		if (edptChargerId != null) {
			dsuseVo.setEdptChargerNm(edptChargerId);
		}

		if (dsuseEsntlId != null && !"".equals(dsuseEsntlId)) {
			CmmnEctccVo ectccVo = new CmmnEctccVo();
			ectccVo.setCnstrcEsntlId(dsuseVo.getDsuseEsntlId());
			kwDefaultBeanValidator.validate(ectccVo);
			// 기존 데이터가 오아시스 전자문서라면
			if (!StringUtils.equals(cmsBsnsCd, cmsBsnsCdOld) || !StringUtils.equals(cmsPrjctCd, cmsPrjctCdOld)
					|| !StringUtils.equals(cmsPrjctSqncIdtfr, cmsPrjctSqncIdtfrOld)) {
				// 폐기 삭제
				dsuseService.deleteDsuse(dsuseVo);
				// 사업추진절차 프로세스 데이터 삭제
				cmmnService.deleteEctcc(ectccVo);

				//저장데이터가 폐기입력이면
				if ((cmsBsnsCd == null || "".equals(cmsBsnsCd)) && (cmsPrjctCd == null || "".equals(cmsPrjctCd))
						&& (cmsPrjctSqncIdtfr == null || "".equals(cmsPrjctSqncIdtfr))) {
					// 폐기ID 부여
					dsuseVo.setDsuseEsntlId("D_" + Long.toHexString(System.currentTimeMillis()).toUpperCase());
				} else {
					// 오아시스 전자문서라면 CMS사업코드_CMS프로젝트코드_CMS프로젝트회차식별자 폐기ID 부여
					dsuseVo.setDsuseEsntlId("D_" + cmsBsnsCd + "_" + cmsPrjctCd + "_" + cmsPrjctSqncIdtfr);
				}
			}
		} else {
			// 기존 데이터가 없다면
			if ((cmsBsnsCd == null || "".equals(cmsBsnsCd)) && (cmsPrjctCd == null || "".equals(cmsPrjctCd))
					&& (cmsPrjctSqncIdtfr == null || "".equals(cmsPrjctSqncIdtfr))) {
				// 폐기ID 부여
				dsuseVo.setDsuseEsntlId("D_" + Long.toHexString(System.currentTimeMillis()).toUpperCase());
			} else {
				// 오아시스 전자문서라면 CMS사업코드_CMS프로젝트코드_CMS프로젝트회차식별자 폐기ID 부여
				dsuseVo.setDsuseEsntlId("D_" + cmsBsnsCd + "_" + cmsPrjctCd + "_" + cmsPrjctSqncIdtfr);
			}
		}

		kwDefaultBeanValidator.validate(dsuseVo);

		int rtnCnt = (int) dsuseService.saveDsuse(dsuseVo).get("rtnCnt");

		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 관리/폐기의 폐기 목록을 삭제한다.
	 * 
	 * @param param
	 *            : { dsuseEsntlId(*) : 폐기고유ID }
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "delete-dsuse.do", method = RequestMethod.POST)
	public ModelAndView deleteDsuse(Map param) throws Exception {
		Map paramDma = (Map) param.get("dmaSetcscDsusePrcsDtlHist");
		String dsuseEsntlId = (String) paramDma.get("dsuseEsntlId");

		ParameterMapper pm = new ParameterMapper();
		DsuseVo dsuseVo = (DsuseVo) pm.getMapData(param, "dmaSetcscDsusePrcsDtlHist", new DsuseVo());
		CmmnEctccVo ectccVo = new CmmnEctccVo();
		ectccVo.setCnstrcEsntlId(dsuseVo.getDsuseEsntlId());

		kwDefaultBeanValidator.validate(dsuseVo);
		kwDefaultBeanValidator.validate(ectccVo);

		if (dsuseEsntlId == null || "".equals(dsuseEsntlId)) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			int rtnCnt = 0;
			// 폐기 삭제
			rtnCnt = (int) dsuseService.deleteDsuse(dsuseVo).get("rtnCnt");
			// 사업추진절차 프로세스 삭제
			rtnCnt += (int) cmmnService.deleteEctcc(ectccVo).get("rtnCnt");
			if (rtnCnt > 0) {
				return addResponseData(ResponseData.STATUS_SUCESS);
			} else {
				return addResponseData(ResponseData.STATUS_ERROR);
			}
		}
	}
}