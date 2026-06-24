package kw.ecs.me.elyrseltengmsrins.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.me.elyrseltengmsrins.service.ElyrsEltengMsrinsService;
import kw.ecs.me.elyrseltengmsrins.vo.ElyrsEltengMsrinsVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * ElyrsEltengMsrinsServiceImpl 서비스 클래스
 * 
 * @ClassName ElyrsEltengMsrinsServiceImpl.java
 * @Description 관리/폐기 - 발전 전력량계 관리 클래스
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
@SuppressWarnings("rawtypes")
@Service("elyrsEltengMsrinsService")
public class ElyrsEltengMsrinsServiceImpl extends DefaultServiceImpl implements ElyrsEltengMsrinsService {
	protected final static Logger logger = Logger.getLogger(ElyrsEltengMsrinsServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 관리/폐기의 발전 전력량계 관리 목록을 조회한다.
	 * 
	 * @param @ElyrsEltengMsrinsVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveElyrsEltengMsrinsList(ElyrsEltengMsrinsVo elyrsEltengMsrinsVo) throws Exception {
		return ecsCommonDao.selectList("TM_ME31001_Dao_retrieveElyrsEltengMsrinsList", elyrsEltengMsrinsVo);
	}

	/**
	 * 관리/폐기의 발전 전력량계 관리 목록을 저장/수정/삭제한다.
	 * 
	 * @param @ElyrsEltengMsrinsVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map processElyrsEltengMsrinsList(List<ElyrsEltengMsrinsVo> elyrsEltengMsrinsVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (ElyrsEltengMsrinsVo elyrsEltengMsrinsVo : elyrsEltengMsrinsVoList) {
			if ("E".equals(elyrsEltengMsrinsVo.getRowStatus()) || "D".equals(elyrsEltengMsrinsVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.delete("TM_ME31001_Dao_deleteElyrsEltengMsrinsList", elyrsEltengMsrinsVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_ME31001_Dao_saveElyrsEltengMsrinsList", elyrsEltengMsrinsVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 관리/폐기의 발전 전력량계 관리 목록을 저장(수정)한다.
	 * 
	 * @param @ElyrsEltengMsrinsVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map saveElyrsEltengMsrinsList(List<ElyrsEltengMsrinsVo> elyrsEltengMsrinsVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (ElyrsEltengMsrinsVo elyrsEltengMsrinsVo : elyrsEltengMsrinsVoList) {
			rtnCnt += ecsCommonDao.update("TM_ME31001_Dao_saveElyrsEltengMsrinsList", elyrsEltengMsrinsVo);
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 관리/폐기의 발전 전력량계 관리 목록을 삭제한다.
	 * 
	 * @param @ElyrsEltengMsrinsVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map deleteElyrsEltengMsrinsList(List<ElyrsEltengMsrinsVo> elyrsEltengMsrinsVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (ElyrsEltengMsrinsVo elyrsEltengMsrinsVo : elyrsEltengMsrinsVoList) {
			rtnCnt += ecsCommonDao.delete("TM_ME31001_Dao_deleteElyrsEltengMsrinsList", elyrsEltengMsrinsVo);
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}