package kw.ecs.cl.wthtexcclc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cl.wthtexcclc.service.WthtExcclcService;
import kw.ecs.cl.wthtexcclc.vo.WthtEqpSttusVo;
import kw.ecs.cl.wthtexcclc.vo.WthtExcclcSttusVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * WthtExcclcServiceImpl 서비스 클래스
 * 
 * @ClassName WthtExcclcServiceImpl.java
 * @Description 정산 - 수열 정산 클래스
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
@SuppressWarnings("rawtypes")
@Service("wthtExcclcService")
public class WthtExcclcServiceImpl extends DefaultServiceImpl implements WthtExcclcService {
	protected final static Logger logger = Logger.getLogger(WthtExcclcServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 정산의 수열 설비현황 목록을 조회한다.
	 * 
	 * @param @WthtExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveWthtEqpSttusList(WthtEqpSttusVo wthtEqpSttusVo) throws Exception {
		return ecsCommonDao.selectList("TM_CL12001_Dao_retrieveWthtEqpSttusList", wthtEqpSttusVo);
	}

	/**
	 * 정산의 수열 설비현황 목록을 저장/수정/삭제한다.
	 * 
	 * @param @WthtExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map processWthtEqpSttusList(List<WthtEqpSttusVo> wthtEqpSttusVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (WthtEqpSttusVo wthtEqpSttusVo : wthtEqpSttusVoList) {
			if ("E".equals(wthtEqpSttusVo.getRowStatus()) || "D".equals(wthtEqpSttusVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.delete("TM_CL12001_Dao_deleteWthtEqpSttusList", wthtEqpSttusVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_CL12001_Dao_saveWthtEqpSttusList", wthtEqpSttusVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 정산의 수열 정산현황 목록을 조회한다.
	 * 
	 * @param @WthtExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveWthtExcclcSttusList(WthtExcclcSttusVo wthtExcclcSttusVo) throws Exception {
		return ecsCommonDao.selectList("TM_CL12002_Dao_retrieveWthtExcclcSttusList", wthtExcclcSttusVo);
	}

	/**
	 * 정산의 수열 정산현황 목록을 저장/수정/삭제한다.
	 * 
	 * @param @WthtExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map processWthtExcclcSttusList(List<WthtExcclcSttusVo> wthtExcclcSttusVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (WthtExcclcSttusVo wthtExcclcSttusVo : wthtExcclcSttusVoList) {
			if ("E".equals(wthtExcclcSttusVo.getRowStatus()) || "D".equals(wthtExcclcSttusVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.delete("TM_CL12002_Dao_deleteWthtExcclcSttusList", wthtExcclcSttusVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_CL12002_Dao_saveWthtExcclcSttusList", wthtExcclcSttusVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}