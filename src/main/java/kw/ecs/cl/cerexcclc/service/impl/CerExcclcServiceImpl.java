package kw.ecs.cl.cerexcclc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cl.cerexcclc.service.CerExcclcService;
import kw.ecs.cl.cerexcclc.vo.CerExcclcVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * CerExcclcServiceImpl 서비스 클래스
 * 
 * @ClassName CerExcclcServiceImpl.java
 * @Description 정산 - CER 정산 클래스
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
@Service("cerExcclcService")
public class CerExcclcServiceImpl extends DefaultServiceImpl implements CerExcclcService {
	protected final static Logger logger = Logger.getLogger(CerExcclcServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 정산의 CER 정산 목록을 조회한다.
	 * 
	 * @param @CerExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCerExcclcList(CerExcclcVo cerExcclcVo) throws Exception {
		return ecsCommonDao.selectList("TM_CL23001_Dao_retrieveCerExcclcList", cerExcclcVo);
	}

	/**
	 * 정산의 CER 정산 목록을 저장/수정/삭제한다.
	 * 
	 * @param @CerExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map processCerExcclcList(List<CerExcclcVo> cerExcclcVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (CerExcclcVo cerExcclcVo : cerExcclcVoList) {
			if ("E".equals(cerExcclcVo.getRowStatus()) || "D".equals(cerExcclcVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.delete("TM_CL23001_Dao_deleteCerExcclcList", cerExcclcVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_CL23001_Dao_saveCerExcclcList", cerExcclcVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}