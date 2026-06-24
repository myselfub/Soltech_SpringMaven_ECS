package kw.ecs.zz.cmmn.controller;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import kw.ecs.cn.epbusttus.vo.EpbuSttusVo;
import kw.ecs.common.vo.ECSDefaultVo;
import kw.ecs.pb.plancnstrc.vo.PlanCnstrcVo;
import kw.ecs.zz.cmmn.service.CmmnService;
import kw.ecs.zz.cmmn.vo.CmmnEctccVo;
import kw.fw.defaults.DefaultConsts;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.FasooDrmUtil;
import kw.fw.util.ParameterMapper;
import kw.fw.util.RequestContextUtil;
import kw.scm.sc.sap.service.SapClientService;

/**
 * CmmnController 컨트롤러 클래스
 * 
 * @ClassName CmmnController.java
 * @Description 공통 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.07.01		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 07. 01
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/zz/cmmn")
public class CmmnController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(CmmnController.class);

	@Resource(name = "cmmnService")
	public CmmnService cmmnService;

	@Resource(name = "sapClientService")
	public SapClientService sapClientService;

	/**
	 * 공통 HRM 본부 목록 조회한다.
	 * 
	 * @param
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-hrm-hq.do", method = RequestMethod.GET)
	public ModelAndView retrieveHRMHQList(@RequestParam Map param) throws Exception {
		return addResponseData(cmmnService.retrieveHRMHQList());
	}

	/**
	 * 공통 HRM 부서(지사) 목록 조회한다.
	 * 
	 * @param param
	 *            { ecsBasinDivCd : ECS유역구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-hrm-dept.do", method = RequestMethod.GET)
	public ModelAndView retrieveHRMDeptList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(cmmnService.retrieveHRMDeptList(ecsDefaultVo));
	}

	/**
	 * 공통 팝업에서 HRM 사용자 목록을 조회한다.
	 * 
	 * @param param
	 *            : { usrNm : 사원이름, ecsChrgDeptId : 부서코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-hrm-user.do", method = RequestMethod.GET)
	public ModelAndView retrieveHRMUserList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(cmmnService.retrieveHRMUserList(ecsDefaultVo));
	}

	/**
	 * 공통 팝업에서 사용자 이름과 부서를 가지고 HRM의 사원번호 목록을 조회한다.(동명이인이면 사원번호가 가장 높은 사원번호로
	 * 조회한다.)
	 * 
	 * @param param
	 *            : { usrNm : 사원이름, deptNm : 부서명, ecsChrgDeptId : 부서코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-oasis-elctrn-doc-hrm-user.do", method = RequestMethod.GET)
	public ModelAndView retrieveOasisElctrnDocHRMUser(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(cmmnService.retrieveOasisElctrnDocHRMUser(ecsDefaultVo));
	}

	/**
	 * 공통 발전원 목록 조회한다.
	 * 
	 * @param param
	 *            : { cnd(*) : 발전원목록구분(01 : 전체, 02 : 일반소수력/보소수력 분리, 03 :
	 *            수공태양광/한전태양광분리)}
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-setcsc.do", method = RequestMethod.GET)
	public ModelAndView retrieveSetcscList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getCnd() == null || "".equals(ecsDefaultVo.getCnd())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cmmnService.retrieveSetcscList(ecsDefaultVo));
		}
	}

	/**
	 * 공통 발전소 목록 조회한다.
	 * 
	 * @param param
	 *            : { cnd(*) : 발전소구분(1 : 대수력, 2 : 일반소수력, 3 : 보소수력, 4 : 전체소수력, 5 : 조력) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-elcpwstn.do", method = RequestMethod.GET)
	public ModelAndView retrieveElcpwstnList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(cmmnService.retrieveElcpwstnList(ecsDefaultVo));
	}

	/**
	 * 공통 소비원 목록 조회한다.
	 * 
	 * @param param
	 *            : { ecsCnstscDivCd : 소비원구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnstsc.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnstscList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, EpbuSttusVo.class);

		return addResponseData(cmmnService.retrieveCnstscList(ecsDefaultVo));
	}

	/**
	 * 공통 ECS 연동 유역(공통코드) 목록 조회한다.
	 * 
	 * @param
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-basin-mapping.do", method = RequestMethod.GET)
	public ModelAndView retrieveBasinMappingList(@RequestParam Map param) throws Exception {
		return addResponseData(cmmnService.retrieveBasinMappingList());
	}

	/**
	 * 공통 ECS 연동 전체부서 목록 조회한다.
	 * 
	 * @param
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-all-dept-mapping.do", method = RequestMethod.GET)
	public ModelAndView retrieveAllDeptMappingList(@RequestParam Map param) throws Exception {
		return addResponseData(cmmnService.retrieveAllDeptMappingList());
	}

	/**
	 * 공통 ECS 연동 부서(지사) 목록 조회한다.
	 * 
	 * @param
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-dept-mapping.do", method = RequestMethod.GET)
	public ModelAndView retrieveDeptMappingList(@RequestParam Map param) throws Exception {
		return addResponseData(cmmnService.retrieveDeptMappingList());
	}

	/**
	 * 공통 ECS 사업장(공통코드) 목록을 조회한다.
	 * 
	 * @param :
	 *            { ecsBasinDivCd : ECS유역구분코드, ecsChrgDeptId : ECS담당부서ID }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-bplc.do", method = RequestMethod.GET)
	public ModelAndView retrieveBplcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, EpbuSttusVo.class);

		return addResponseData(cmmnService.retrieveBplcList(ecsDefaultVo));
	}

	/**
	 * 공통 소비(GHG)의 조회조건(부서) 목록을 조회한다.
	 * 
	 * @param param
	 *            : { ecsChrgDeptId : ECS유역구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnsmp-cnd-dept.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnsmpCndDeptList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(cmmnService.retrieveCnsmpCndDeptList(ecsDefaultVo));
	}

	/**
	 * 공통 수전전력량계 관리의 조회조건(부서) 목록을 조회한다.
	 * 
	 * @param
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-wtwk-elteng-msrins-cnd-dept.do", method = RequestMethod.GET)
	public ModelAndView retrieveWtwkEltengMsrinsCndDeptList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(cmmnService.retrieveWtwkEltengMsrinsCndDeptList(ecsDefaultVo));
	}

	/**
	 * 공통 생산의 조회조건(부서/발전원) 목록을 조회한다.
	 * 
	 * @param param
	 *            : { cnd(*) : 조회조건대상(dept : 부서, setcsc : 발전원, setcscKepco :
	 *            발전원(한전포함)), cnd1 : 조회조건대상(01/02/03/04... : ECS_1001의
	 *            USR_DFN_VU3 발전원그룹구분), ecsBasinDivCd : ECS유역구분코드,
	 *            ecsSetcscDivCd : ECS발전원구분코드, ecsChrgDeptId : ECS담당부서아이디 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prdctn-cnd.do", method = RequestMethod.GET)
	public ModelAndView retrievePrdctnCndList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		if (ecsDefaultVo.getCnd() != null && "dept".equals(ecsDefaultVo.getCnd())) {
			return addResponseData(cmmnService.retrievePrdctnCndDeptList(ecsDefaultVo));
		} else if (ecsDefaultVo.getCnd() != null
				&& ("elcpwstn".equals(ecsDefaultVo.getCnd()) || "elcpwstnKepco".equals(ecsDefaultVo.getCnd()))) {
			return addResponseData(cmmnService.retrievePrdctnCndElcpwstnList(ecsDefaultVo));
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 공통 소비의 조회조건(부서) 목록을 조회한다.(한전)
	 * 
	 * @param param
	 *            : { ecsBasinDivCd : ECS유역구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnsmp-sttus-cnd-kepco-dept.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnsmpSttusCndKepcoDeptList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(cmmnService.retrieveCnsmpSttusCndKepcoDeptList(ecsDefaultVo));
	}

	/**
	 * 공통 소비의 소내태양광 부서 목록을 조회한다.
	 * 
	 * @param param
	 *            : { cnd : 부서/사업장 구분(dept/bplc), ecsBasinDivCd : ECS유역구분코드,
	 *            ecsChrgDeptId : ECS담당부서ID }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-inhouse-snpw-dept.do", method = RequestMethod.GET)
	public ModelAndView retrieveInhouseSnpwDeptList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(cmmnService.retrieveInhouseSnpwDeptList(ecsDefaultVo));
	}

	/**
	 * 공통 정산의 조회조건(REC발전원) 목록을 조회한다.
	 * 
	 * @param param
	 *            : { ecsSetcscDivCd : 발전원구분코드(0으로 시작(01:태양광, 02:비태양광),
	 *            그외(ALL:전체, 21:소수력, 22:보소수력, 41:태양광(수공), 42:태양광(한전), 50:풍력)),
	 *            ecsBasinDivCd : 유역구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-rec-cnd-setcsc.do", method = RequestMethod.GET)
	public ModelAndView retrieveRecCndSetcscList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(cmmnService.retrieveRecCndSetcscList(ecsDefaultVo));
	}

	/**
	 * 공통 소비전력 비교현황의 조회조건(부서) 목록을 조회한다.
	 * 
	 * @param
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cmpr-sttus-dept.do", method = RequestMethod.GET)
	public ModelAndView retrieveCmprSttusDeptList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(cmmnService.retrieveCmprSttusDeptList(ecsDefaultVo));
	}

	/**
	 * 공통 계획/건설의 조회조건(진행현황) 목록을 조회한다.
	 * 
	 * @param {
	 *            cnd : 진행현황 첫글자(P:계획,C:건설,M:관리,D:폐기,PC:계획/건설) }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-prgs-sttus.do", method = RequestMethod.GET)
	public ModelAndView retrievePrgsSttusList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		return addResponseData(cmmnService.retrievePrgsSttusList(ecsDefaultVo));
	}

	/**
	 * 공통 오아시스 전자문서 목록을 조회한다.
	 * 
	 * @param param
	 *            : { empCode(*) : 사원번호, strtDt(*) : 조회 시작 날짜, endDt(*) : 조회 종료
	 *            날짜 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-oasis-elctrn-doc.do", method = RequestMethod.GET)
	public ModelAndView oasisElctrnDoc(@RequestParam Map param) throws Exception {
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setContentType(MediaType.APPLICATION_JSON);
		 * HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
		 * MultiValueMap<String, String> params = new
		 * LinkedMultiValueMap<String, String>(); params.add("EMPCODE", (String)
		 * param.get("empCode")); params.add("STARTDATE", (String)
		 * param.get("strtDt")); params.add("ENDDATE", (String)
		 * param.get("endDt")); if (param.get("title") != null &&
		 * !"".equals(param.get("title"))) { params.add("TITLE", (String)
		 * param.get("title")); } String url = UriComponentsBuilder.fromHttpUrl(
		 * "http://toasis.[BASE_DOMAIN]/custom/erp/cms/getApprovalList.jsp")
		 * .queryParams(params).build(true).toString(); String responseEntity =
		 * new RestTemplate().getForObject(url, String.class);
		 */

		// DEV
		// String url =
		// "http://toasis.[BASE_DOMAIN]/custom/erp/cms/getApprovalList.jsp";
		/*
		 * String sendData = sendData.replace("${EMPCODE}",
		 * "20172350").replace("${STARTDATE}", "20210101").replace("${ENDDATE}",
		 * "20211115");
		 */

		// OPER
		String url = "http://oasis.[BASE_DOMAIN]/custom/erp/cms/getApprovalList.jsp";
		String sendData = "EMPCODE=${EMPCODE}&STARTDATE=${STARTDATE}&ENDDATE=${ENDDATE}";

		sendData = sendData.replace("${EMPCODE}", (String) param.get("empCode"))
				.replace("${STARTDATE}", (String) param.get("strtDt"))
				.replace("${ENDDATE}", (String) param.get("endDt"));

		if (param.get("title") != null && !"".equals(param.get("title"))) {
			sendData += "&TITLE=" + (String) param.get("title");
		}

		URLConnection conn = new URL(url).openConnection();
		conn.setRequestProperty("Connection", "close");
		conn.setConnectTimeout(30 * 1000);
		conn.setReadTimeout(30 * 1000);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
		wr.write(sendData);
		wr.flush();
		wr.close();
		InputStream in = conn.getInputStream();
		byte[] response = IOUtils.toByteArray(in);
		in.close();
		String responseStr = new String(response, StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String, Object> responseMap = mapper.readValue(responseStr, Map.class);
		List<Map> resultList = (List<Map>) responseMap.get("DOCLIST");

		String hrmDeptCd = "";
		if (resultList.size() > 0) {
			String deptId = (String) resultList.get(0).get("DRAFTDEPTID");
			ECSDefaultVo ecsDefaultVo = new ECSDefaultVo();
			ecsDefaultVo.setEcsChrgDeptId(deptId);
			List<Map> hrmDeptList = cmmnService.retrieveOasisElctrnDocHRMDept(ecsDefaultVo);

			if (hrmDeptList.size() > 0) {
				hrmDeptCd = (String) hrmDeptList.get(0).get("hrmDeptId");
			} else {
				/*
				 * String deptNm = ""; String _deptNm = (String)
				 * resultList.get(0).get("DOCREGNO"); String[] deptNmSplit =
				 * _deptNm.split("-"); if (deptNmSplit.length > 1) { for (int i
				 * = 0; i < deptNmSplit.length - 1; i++) {
				 * deptNm.concat(deptNmSplit[i]); } } else { deptNm = _deptNm; }
				 * ecsDefaultVo.setDeptNm(deptNm);
				 */
				List<Map> hrmDsuseDeptList = cmmnService.retrieveOasisElctrnDocHRMDsuseDept(ecsDefaultVo);
				if (hrmDsuseDeptList.size() > 0) {
					hrmDeptCd = (String) hrmDsuseDeptList.get(0).get("objid");
				}
			}
		}

		for (int idx = 0; idx < resultList.size(); idx++) {
			resultList.get(idx).put("DRAFTDEPTID", hrmDeptCd);
			resultList.get(idx).put("lnkEsntlId", param.get("lnkEsntlId"));
			resultList.get(idx).put("ecsBsnsPrgsDivCd", param.get("ecsBsnsPrgsDivCd"));
			resultList.get(idx).put("planChargerEmpno", param.get("empCode"));
		}

		if (responseStr == null || responseStr.length() < 0) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(resultList);
		}
	}

	/**
	 * 계획/건설/폐기 목록의 공통 등록된 전자문서 상세 사업추진절차 목록을 조회한다.
	 * 
	 * @param param
	 *            : { planEsntlId : 계획고유ID, cnstrcEsntlId : 건설고유ID dsuseEsntlId
	 *            : 폐기고유ID }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-ectcc-prgs.do", method = RequestMethod.GET)
	public ModelAndView retrieveEctccPrgsList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CmmnEctccVo cmmnEctccVo = mapper.convertValue(param, CmmnEctccVo.class);

		if ((cmmnEctccVo.getPlanEsntlId() == null || "".equals(cmmnEctccVo.getPlanEsntlId()))
				&& cmmnEctccVo.getDsuseEsntlId() == null || "".equals(cmmnEctccVo.getDsuseEsntlId())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cmmnService.retrieveEctccPrgsList(cmmnEctccVo));
		}
	}

	/**
	 * 계획/건설/폐기 목록의 공통 등록된 오아시스 전자문서를 조회한다.
	 * 
	 * @param param
	 *            : { planEsntlId : 계획고유ID, cnstrcEsntlId : 건설고유ID dsuseEsntlId
	 *            : 폐기고유ID }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-ectcc.do", method = RequestMethod.GET)
	public ModelAndView retrieveEctccList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CmmnEctccVo cmmnEctccVo = mapper.convertValue(param, CmmnEctccVo.class);

		if ((cmmnEctccVo.getPlanEsntlId() == null || "".equals(cmmnEctccVo.getPlanEsntlId()))
				&& cmmnEctccVo.getDsuseEsntlId() == null || "".equals(cmmnEctccVo.getDsuseEsntlId())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cmmnService.retrieveEctccList(cmmnEctccVo));
		}
	}

	/**
	 * 계획/건설/폐기 목록의 공통 오아시스 전자문서를 등록 및 계획/건설 정보를 저장/삭제한다.
	 * 
	 * @param {
	 * @CmmnEctccVo - lnkEsntlId : 연계고유ID, ecsBsnsPrgsDivCd : ECS사업진행구분코드,
	 *              ectccId : 전자문서ID, ectccTit : 전자문서제목, reltDocNo : 관련문서번호,
	 * @PlanCnstrcVo - planEsntlId : 계획고유ID, drftDeptCd : 기안자 담당부서 코드,
	 *               drafterEmpno : 계획담당자사원번호, drftDe : 계획수립일 }
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-ectcc.do", method = RequestMethod.POST)
	public ModelAndView processEctccList(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<CmmnEctccVo> cmmnEctccVoList = (List<CmmnEctccVo>) pm.getListData(param, "dltEctccList",
				new CmmnEctccVo());

		kwDefaultBeanValidator.validate(cmmnEctccVoList);

		int rtnCnt = (int) cmmnService.processEctccList(cmmnEctccVoList).get("rtnCnt");

		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 계획/건설/폐기 목록의 공통 오아시스 전자문서를 등록 및 계획/건설 정보를 수정한다.
	 * 
	 * @param {
	 * @CmmnEctccVo - lnkEsntlId : 연계고유ID, ecsBsnsPrgsDivCd : ECS사업진행구분코드,
	 *              ectccId : 전자문서ID, ectccTit : 전자문서제목, reltDocNo : 관련문서번호,
	 * @PlanCnstrcVo - planEsntlId : 계획고유ID, ecsChrgDeptId : ECS담당부서ID,
	 *               planChargerEmpno : 계획담당자사원번호, planFoundngDe : 계획수립일 }
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "save-ectcc.do", method = RequestMethod.POST)
	public ModelAndView saveEctcc(Map param) throws Exception {
		Map paramDma = (Map) param.get("dmaEctcc");
		String lnkEsntlId = (String) paramDma.get("lnkEsntlId");
		int rtnCnt = 0;

		ParameterMapper pm = new ParameterMapper();
		PlanCnstrcVo planCnstrcVo = (PlanCnstrcVo) pm.getMapData(param, "dmaEctcc", new PlanCnstrcVo());
		planCnstrcVo.setPlanEsntlId(lnkEsntlId);

		CmmnEctccVo ectccVo = (CmmnEctccVo) pm.getMapData(param, "dmaEctcc", new CmmnEctccVo());

		// rtnCnt += (int)
		// planCnstrcService.savePlanData(planCnstrcVo).get("rtnCnt");
		/*
		 * if (!"D".equals(lnkEsntlId.substring(0, 1))) { if
		 * ("P".equals(lnkEsntlId.substring(0, 1))) { // 계획 수정 rtnCnt += (int)
		 * planCnstrcService.savePlanData(planCnstrcVo).get("rtnCnt"); } else if
		 * ("C".equals(lnkEsntlId.substring(0, 1))) { // 건설 수정 rtnCnt += (int)
		 * planCnstrcService.savePlanData(planCnstrcVo).get("rtnCnt"); } if
		 * (rtnCnt == 0) { return addResponseData(ResponseData.STATUS_SUCESS); }
		 * }
		 */

		rtnCnt += (int) cmmnService.insertEctcc(ectccVo).get("rtnCnt");

		kwDefaultBeanValidator.validate(planCnstrcVo);
		kwDefaultBeanValidator.validate(ectccVo);

		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 계획/건설의 공통 오아시스 전자문서를 삭제한다.
	 * 
	 * @param :
	 *            { planEsntlId : 계획고유ID, cnstrcEsntlId : 건설고유ID,
	 *            ecsBsnsPrgsDivCd : ECS사업구분코드, ectccId : 전자문서ID }
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "delete-ectcc.do", method = RequestMethod.POST)
	public ModelAndView deleteEctcc(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		CmmnEctccVo ectccVo = (CmmnEctccVo) pm.getMapData(param, "dmaEctcc", new CmmnEctccVo());

		kwDefaultBeanValidator.validate(ectccVo);

		int rtnCnt = 0;

		// 계획 삭제
		rtnCnt += (int) cmmnService.deleteEctcc(ectccVo).get("rtnCnt");

		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}

	/**
	 * 인코딩된 사원번호를 조회한다.
	 * 
	 * @param param
	 *            : { usrId : 인코딩할 사번 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "enc-emp-no.do", method = RequestMethod.GET)
	public ModelAndView selectEncEmpNo(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		String usrId = ecsDefaultVo.getUsrId(); // RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID)
		if (usrId == null || "".equals(usrId)) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			/*
			 * String encNO = (String)
			 * RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID); // 사번
			 * String encMs = Long.toString(System.currentTimeMillis()); // 시간
			 * scrinMngVo.setUsrId(FasooDrmUtil.getEncStr(encNO + "#" + encMs));
			 */
			ecsDefaultVo.setUsrId(FasooDrmUtil.getEncStr(usrId));
			Map map = new HashMap<String, String>();
			map.put("EMPNO", ecsDefaultVo.getUsrId());
			return addResponseData(map);
		}
	}

	/**
	 * 오아시스의 인코딩된 사원번호를 조회한다.
	 * 
	 * @param param
	 *            : { usrId : 인코딩할 사번, conectIp : IP, sysDivCd : 시스템구분코드}
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "oasis-enc-emp-no.do", method = RequestMethod.GET)
	public ModelAndView selectOasisEncEmpNo(HttpServletRequest request, @RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ECSDefaultVo ecsDefaultVo = mapper.convertValue(param, ECSDefaultVo.class);

		Map map = new HashMap<String, String>();
		String encMs = Long.toString(System.currentTimeMillis());
		String usrId = ecsDefaultVo.getUsrId();
		if (usrId == null || "".equals(usrId)) {
			usrId = (String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID);
		}
		String conectIp = ecsDefaultVo.getConectIp();
		if (conectIp == null || "".equals(conectIp)) {
			conectIp = request.getRemoteAddr();
		}
		map.put("encKey", FasooDrmUtil.getEncStr(usrId + "#" + encMs + "#" + conectIp));

		String sysDivCd = ecsDefaultVo.getSysDivCd();
		if (sysDivCd != null && !"".equals(sysDivCd)) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
			String url = UriComponentsBuilder
					.fromHttpUrl("https://" + sysDivCd.toLowerCase() + ".[BASE_DOMAIN]/sc/AccessCrtfcServlet")
					.queryParams(params).build(true).toString();
			String responseEntity = new RestTemplate().getForObject(url, String.class);
			map.put("accessCrtfc", responseEntity);
		}

		return addResponseData(map);
	}

	/**
	 * RFC를 조회한다.
	 * 
	 * @param param
	 *            : { }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-rfc.do", method = RequestMethod.POST)
	public ModelAndView retrieveRFC(Map param) throws Exception {
		// String result = sapClientService.getTable4Json(param);
		Map result = sapClientService.getTable(param);

		return addResponseData((List<Map>) result.get("ET_RESULT2"));
	}
}