package kw.ecs.me.wtwkeltengmsrins.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.me.wtwkeltengmsrins.service.WtwkEltengMsrinsService;
import kw.ecs.me.wtwkeltengmsrins.vo.WtwkEltengMsrinsVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * WtwkEltengMsrinsServiceImpl 서비스 클래스
 * 
 * @ClassName WtwkEltengMsrinsServiceImpl.java
 * @Description 관리/폐기 - 수전 전력량계 관리 클래스
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
@Service("wtwkEltengMsrinsService")
public class WtwkEltengMsrinsServiceImpl extends DefaultServiceImpl implements WtwkEltengMsrinsService {
	protected final static Logger logger = Logger.getLogger(WtwkEltengMsrinsServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 관리/폐기의 수전 전력량계 관리 조회조건 자체시설명 목록을 조회한다.
	 * 
	 * @param @WtwkEltengMsrinsVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveWtwkEltengMsrinsCndItslfFcltyNmList(WtwkEltengMsrinsVo wtwkEltengMsrinsVo)
			throws Exception {
		return ecsCommonDao.selectList("TM_ME32001_Dao_retrieveWtwkEltengMsrinsCndItslfFcltyNmList",
				wtwkEltengMsrinsVo);
	}

	/**
	 * 관리/폐기의 수전 전력량계 관리 목록을 조회한다.
	 * 
	 * @param @WtwkEltengMsrinsVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveWtwkEltengMsrinsList(WtwkEltengMsrinsVo wtwkEltengMsrinsVo) throws Exception {
		return ecsCommonDao.selectList("TM_ME32001_Dao_retrieveWtwkEltengMsrinsList", wtwkEltengMsrinsVo);
	}

	/**
	 * 관리/폐기의 수전 전력량계 관리 목록을 저장/수정/삭제한다.
	 * 
	 * @param @WtwkEltengMsrinsVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processWtwkEltengMsrinsList(List<WtwkEltengMsrinsVo> wtwkEltengMsrinsVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (WtwkEltengMsrinsVo wtwkEltengMsrinsVo : wtwkEltengMsrinsVoList) {
			if ("E".equals(wtwkEltengMsrinsVo.getRowStatus()) || "D".equals(wtwkEltengMsrinsVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.delete("TM_ME32001_Dao_deleteWtwkEltengMsrinsList", wtwkEltengMsrinsVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_ME32001_Dao_saveWtwkEltengMsrinsList", wtwkEltengMsrinsVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}