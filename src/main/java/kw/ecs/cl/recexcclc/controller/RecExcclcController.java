package kw.ecs.cl.recexcclc.controller;

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

import kw.ecs.cl.recexcclc.service.RecExcclcService;
import kw.ecs.cl.recexcclc.vo.RecExcclcVo;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.util.ParameterMapper;

/**
 * RecExcclcController 컨트롤러 클래스
 * 
 * @ClassName RecExcclcController.java
 * @Description 정산 - REC 정산
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
@RequestMapping("/cl/recexcclc")
public class RecExcclcController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(RecExcclcController.class);

	@Resource(name = "recExcclcService")
	public RecExcclcService recExcclcService;

	/**
	 * 정산의 REC 정산을 목록을 조회한다.
	 * 
	 * @param param
	 *            : { strtDt(*) : 조회연도, ecsBasinDivCd : 유역구분코드,
	 *            ecsSetcscDivCd(*) : 발전원구분코드(01:태양광, 02:비태양광), ecsElcpwstnDivCd
	 *            : 발전소 }
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@RequestMapping(value = "retrieve-rec-excclc.do", method = RequestMethod.GET)
	public ModelAndView retrieveRecExcclcList(@RequestParam Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		RecExcclcVo recExcclcVo = mapper.convertValue(param, RecExcclcVo.class);

		if (recExcclcVo.getStrtDt() == null || "".equals(recExcclcVo.getStrtDt())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			if (recExcclcVo.getEcsSetcscDivCd() != null && "01".equals(recExcclcVo.getEcsSetcscDivCd())) {
				// 태양광
				return addResponseData(recExcclcService.retrieveRecExcclcSnpwList(recExcclcVo));
			} else if (recExcclcVo.getEcsSetcscDivCd() != null && "02".equals(recExcclcVo.getEcsSetcscDivCd())) {
				// 비태양광
				return addResponseData(recExcclcService.retrieveRecExcclcNotSnpwList(recExcclcVo));
			} else {
				return addResponseData(ResponseData.STATUS_ERROR);
			}
		}
	}

	/**
	 * 정산의 REC 정산을 목록을 저장/수정/삭제한다.
	 * 
	 * @param param
	 *            : { ecsSetcscDivCd : 발전원구분코드(01:태양광, 02:비태양광) }, @RecExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@RequestMapping(value = "process-rec-excclc.do", method = RequestMethod.POST)
	public ModelAndView processRecExcclcList(@RequestParam Map requestParam, Map param) throws Exception {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		RecExcclcVo recExcclcVo = mapper.convertValue(requestParam, RecExcclcVo.class);

		int rtnCnt = 0;
		if (recExcclcVo.getEcsSetcscDivCd() != null && "01".equals(recExcclcVo.getEcsSetcscDivCd())) {
			// 태양광
			List<Map> paramDlt = (List<Map>) param.get("dltRecExcclcSnpwList");
			List<Map> recExcclcSnpwList = new ArrayList<Map>();
			for (Map paramDma : paramDlt) {
				for (int i = 1; i <= 12; i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					String month = i <= 9 ? "0" + i : String.valueOf(i);
					map.put("rowStatus", paramDma.get("rowStatus"));
					map.put("recDelngYear", paramDma.get("recDelngYear"));
					if ("C".equals(paramDma.get("rowStatus"))) {
						map.put("recEqpCdNm", paramDma.get("elcpwstnNm"));
					} else {
						map.put("recEqpCdNm", paramDma.get("recEqpCdNm"));
					}
					map.put("recDelngMt", month);

					boolean isAllNull = true;
					Object sbmtQy = paramDma.get("mon" + month + "SbmtQy");
					if ((sbmtQy != null && !"".equals(sbmtQy))) {
						isAllNull = false;
						map.put("recExcclcSbmtQy", sbmtQy);
					}

					Object tm1sAmt = paramDma.get("mon" + month + "Tm1sAmt");
					if ((tm1sAmt != null && !"".equals(tm1sAmt))) {
						isAllNull = false;
						map.put("recExcclcTm1sAmt", tm1sAmt);
					}

					Object tm2sAmt = paramDma.get("mon" + month + "Tm2sAmt");
					if ((tm2sAmt != null && !"".equals(tm2sAmt))) {
						isAllNull = false;
						map.put("recExcclcTm2sAmt", tm2sAmt);
					}

					Object tm3sAmt = paramDma.get("mon" + month + "Tm3sAmt");
					if ((tm3sAmt != null && !"".equals(tm3sAmt))) {
						isAllNull = false;
						map.put("recExcclcTm3sAmt", tm3sAmt);
					}

					Object tm4sAmt = paramDma.get("mon" + month + "Tm4sAmt");
					if ((tm4sAmt != null && !"".equals(tm4sAmt))) {
						isAllNull = false;
						map.put("recExcclcTm4sAmt", tm4sAmt);
					}

					Object accnutSnrn = paramDma.get("mon" + month + "AccnutSnrn");
					if ((accnutSnrn != null && !"".equals(accnutSnrn))) {
						isAllNull = false;
						map.put("recAccnutSnrn", accnutSnrn);
					}

					map.put("updtRsn", paramDma.get("updtRsn"));

					if (!isAllNull) {
						recExcclcSnpwList.add(map);
					}
				}
			}
			param.put("recExcclcSnpwList", recExcclcSnpwList);

			ParameterMapper pm = new ParameterMapper();
			List<RecExcclcVo> recExcclcSnpwVoList = (List<RecExcclcVo>) pm.getListData(param, "recExcclcSnpwList",
					new RecExcclcVo());

			kwDefaultBeanValidator.validate(recExcclcSnpwVoList);

			rtnCnt = (int) recExcclcService.processRecExcclcSnpwList(recExcclcSnpwVoList).get("rtnCnt");
		} else if (recExcclcVo.getEcsSetcscDivCd() != null && "02".equals(recExcclcVo.getEcsSetcscDivCd())) {
			// 비태양광
			List<Map> paramDlt = (List<Map>) param.get("dltRecExcclcNotSnpwList");
			List<Map> recExcclcNotSnpwList = new ArrayList<Map>();
			for (Map paramDma : paramDlt) {
				for (int i = 1; i <= 12; i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					String month = i <= 9 ? "0" + i : String.valueOf(i);
					map.put("rowStatus", paramDma.get("rowStatus"));
					map.put("recDelngYear", paramDma.get("recDelngYear"));
					if ("C".equals(paramDma.get("rowStatus"))) {
						map.put("recEqpCdNm", paramDma.get("elcpwstnNm"));
					} else {
						map.put("recEqpCdNm", paramDma.get("recEqpCdNm"));
					}
					map.put("recDelngMt", month);

					boolean isAllNull = true;
					Object qy = paramDma.get("mon" + month + "Qy");
					if ((qy != null && !"".equals(qy))) {
						isAllNull = false;
						map.put("recExcclcQy", qy);
					}

					Object upc = paramDma.get("mon" + month + "Upc");
					if ((upc != null && !"".equals(upc))) {
						isAllNull = false;
						map.put("recExcclcUpc", upc);
					}

					Object tamt = paramDma.get("mon" + month + "Tamt");
					if ((tamt != null && !"".equals(tamt))) {
						isAllNull = false;
						map.put("recExcclcTamt", tamt);
					}

					map.put("updtRsn", paramDma.get("updtRsn"));

					if (!isAllNull) {
						recExcclcNotSnpwList.add(map);
					} else {
						if ("U".equals(paramDma.get("rowStatus"))) {
							map.put("rowStatus", "D");
							recExcclcNotSnpwList.add(map);
						}
					}
				}
			}
			param.put("recExcclcNotSnpwList", recExcclcNotSnpwList);

			ParameterMapper pm = new ParameterMapper();
			List<RecExcclcVo> recExcclcNotSnpwVoList = (List<RecExcclcVo>) pm.getListData(param, "recExcclcNotSnpwList",
					new RecExcclcVo());

			kwDefaultBeanValidator.validate(recExcclcNotSnpwVoList);

			rtnCnt = (int) recExcclcService.processRecExcclcNotSnpwList(recExcclcNotSnpwVoList).get("rtnCnt");
		}
		if (rtnCnt > 0) {
			return addResponseData(ResponseData.STATUS_SUCESS);
		} else {
			return addResponseData(ResponseData.STATUS_ERROR);
		}
	}
}