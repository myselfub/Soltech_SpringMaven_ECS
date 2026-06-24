package kw.ecs.me.cnvreqp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.me.cnvreqp.service.CnvrEqpService;
import kw.ecs.me.cnvreqp.vo.CnvrEqpVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * CnvrEqpServiceImpl 서비스 클래스
 * 
 * @ClassName CnvrEqpServiceImpl.java
 * @Description 관리/폐기 - 비오차시험/변환장치 관리대장 클래스 (변환설비)
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
@Service("cnvrEqpService")
public class CnvrEqpImpl extends DefaultServiceImpl implements CnvrEqpService {
	protected final static Logger logger = Logger.getLogger(CnvrEqpImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 관리/폐기의 변환설비 관리 목록을 조회한다.
	 * 
	 * @param @CnvrEqpVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCnvrEqpList(CnvrEqpVo cnvrEqpVo) throws Exception {
		return ecsCommonDao.selectList("TM_ME33001_Dao_retrieveCnvrEqpList", cnvrEqpVo);
	}

	/**
	 * 관리/폐기의 변환설비 관리 목록을 저장/수정/삭제한다.
	 * 
	 * @param @CnvrEqpVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processCnvrEqpList(List<CnvrEqpVo> cnvrEqpVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (CnvrEqpVo cnvrEqpVo : cnvrEqpVoList) {
			if ("E".equals(cnvrEqpVo.getRowStatus()) || "D".equals(cnvrEqpVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.delete("TM_ME33001_Dao_deleteCnvrEqpList", cnvrEqpVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_ME33001_Dao_saveCnvrEqpList", cnvrEqpVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}