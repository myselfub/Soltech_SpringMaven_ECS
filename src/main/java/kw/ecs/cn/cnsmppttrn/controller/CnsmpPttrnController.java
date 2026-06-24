package kw.ecs.cn.cnsmppttrn.controller;

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

import kw.ecs.cn.cnsmppttrn.service.CnsmpPttrnService;
import kw.ecs.cn.cnsmppttrn.vo.CnsmpPttrnVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * CnsmpPttrnController 컨트롤러 클래스
 * 
 * @ClassName CnsmpPttrnController.java
 * @Description 소비 - 사업장 소비패턴 분석현황
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
@RequestMapping("/cn/cnsmppttrn")
public class CnsmpPttrnController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(CnsmpPttrnController.class);

	@Resource(name = "cnsmpPttrnService")
	public CnsmpPttrnService cnsmpPttrnService;

	/**
	 * 소비의 사업장 소비패턴 분석현황을 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작날짜, endDt(*) : 조회종료날짜, cnd : 일/월별 조건,
	 *            ecsBasinDivCd : ECS유역구분코드, ecsChrgDeptId : ECS담당부서ID,
	 *            ecsCnstscDivCd : ECS소비원구분코드 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-cnsmp-pttrn.do", method = RequestMethod.GET)
	public ModelAndView retrieveCnsmpPttrnList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CnsmpPttrnVo cnsmpPttrnVo = mapper.convertValue(param, CnsmpPttrnVo.class);

		if (cnsmpPttrnVo.getStrtDt() == null || "".equals(cnsmpPttrnVo.getStrtDt()) || cnsmpPttrnVo.getEndDt() == null
				|| "".equals(cnsmpPttrnVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(cnsmpPttrnService.retrieveCnsmpPttrnList(cnsmpPttrnVo));
		}
	}
}