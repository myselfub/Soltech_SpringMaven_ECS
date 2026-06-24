package kw.ecs.cl.drspexcclc.controller;

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

import kw.ecs.cl.drspexcclc.service.DrspExcclcService;
import kw.ecs.cl.drspexcclc.vo.DrspExcclcVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * DrspExcclcController 컨트롤러 클래스
 * 
 * @ClassName DrspExcclcController.java
 * @Description 정산 - DR 정산
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
@RequestMapping("/cl/drexcclc")
public class DrspExcclcController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(DrspExcclcController.class);

	@Resource(name = "drspExcclcService")
	public DrspExcclcService drspExcclcService;

	/**
	 * 정산의 DR 정산을 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-drsp-excclc.do", method = RequestMethod.GET)
	public ModelAndView retrieveDrspExcclcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DrspExcclcVo drspExcclcVo = mapper.convertValue(param, DrspExcclcVo.class);

		if (drspExcclcVo.getStrtDt() == null || "".equals(drspExcclcVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(drspExcclcService.retrieveDrspExcclcList(drspExcclcVo));
		}
	}

	/**
	 * 정산의 DR 정산을 목록을 저장/수정/삭제한다.
	 * 
	 * @param @DrspExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-drsp-excclc.do", method = RequestMethod.POST)
	public ModelAndView processDrspExcclcList(Map param) throws Exception {
		List<Map> paramDlt = (List<Map>) param.get("dltDrspExcclcList");
		List<Map> drspExcclcList = new ArrayList<Map>();
		String[] iemNmArr = { "bassAmt", "acmsltAmt" };
		for (Map paramDma : paramDlt) {
			for (String iemNm : iemNmArr) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("rowStatus", paramDma.get("rowStatus"));
				map.put("excclcYear", paramDma.get("excclcYear"));
				if ("C".equals(paramDma.get("rowStatus"))) {
					map.put("bplcCdId", paramDma.get("bplcNm"));
				} else {
					map.put("bplcCdId", paramDma.get("bplcCdId"));
				}
				map.put("iemNm", iemNm);
				for (int i = 1; i <= 12; i++) {
					String month = i <= 9 ? "0" + i : String.valueOf(i);
					Object monData = paramDma.get(iemNm + "Mon" + month);
					map.put("mon" + month + "IemVu", monData != null ? monData : "");
				}
				if (iemNm == "bassAmt") {
					map.put("timeAddExcclcAmt", paramDma.get("timeAddExcclcAmt"));
				} else {
					map.put("timeAddExcclcAmt", "0");
				}
				map.put("updtRsn", paramDma.get("updtRsn"));
				drspExcclcList.add(map);
			}
		}
		param.put("drspExcclcList", drspExcclcList);

		ParameterMapper pm = new ParameterMapper();
		List<DrspExcclcVo> drspExcclcVoList = (List<DrspExcclcVo>) pm.getListData(param, "drspExcclcList",
				new DrspExcclcVo());

		kwDefaultBeanValidator.validate(drspExcclcVoList);

		int rtnCnt = (int) drspExcclcService.processDrspExcclcList(drspExcclcVoList).get("rtnCnt");
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}
}