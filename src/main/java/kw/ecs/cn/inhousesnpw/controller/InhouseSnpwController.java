package kw.ecs.cn.inhousesnpw.controller;

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

import kw.ecs.cn.inhousesnpw.service.InhouseSnpwService;
import kw.ecs.cn.inhousesnpw.vo.InhouseSnpwVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;

/**
 * InhouseSnpwController 컨트롤러 클래스
 * 
 * @ClassName InhouseSnpwController.java
 * @Description 소비 - Net-Zero 소내태양광 현황 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.02.17		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 02. 17
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings({ "rawtypes" })
@Controller
@RequestMapping("/cn/inhousesnpw")
public class InhouseSnpwController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(InhouseSnpwController.class);

	@Resource(name = "inhouseSnpwService")
	public InhouseSnpwService inhouseSnpwService;

	/**
	 * 소비 Net-Zero 소내태양광 현황의 소내태양광발전량을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작년도, endDt(*) : 조회종료년도, cnd :
	 *            일별/월별(daly/mnby), ecsBasinDivCd : 유역, ecsChrgDeptId : 부서,
	 *            ecsCnstscDivCd : 사업장 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-inhouse-snpw.do", method = RequestMethod.GET)
	public ModelAndView retrieveInhouseSnpwList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		InhouseSnpwVo inhouseSnpwVo = mapper.convertValue(param, InhouseSnpwVo.class);

		if (inhouseSnpwVo.getStrtDt() == null || "".equals(inhouseSnpwVo.getStrtDt())
				|| inhouseSnpwVo.getEndDt() == null || "".equals(inhouseSnpwVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(inhouseSnpwService.retrieveInhouseSnpwList(inhouseSnpwVo));
		}
	}

	/**
	 * 소비 Net-Zero 소내태양광 현황의 소내태양광발전량 예측값을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회시작년도, endDt(*) : 조회종료년도, ecsBasinDivCd : 유역,
	 *            ecsChrgDeptId : 부서, ecsCnstscDivCd : 사업장 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-inhouse-snpw-predict.do", method = RequestMethod.GET)
	public ModelAndView retrieveInhouseSnpwPredictList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		InhouseSnpwVo inhouseSnpwVo = mapper.convertValue(param, InhouseSnpwVo.class);

		if (inhouseSnpwVo.getStrtDt() == null || "".equals(inhouseSnpwVo.getStrtDt())
				|| inhouseSnpwVo.getEndDt() == null || "".equals(inhouseSnpwVo.getEndDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			return addResponseData(inhouseSnpwService.retrieveInhouseSnpwPredictList(inhouseSnpwVo));
		}
	}
}