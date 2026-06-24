package kw.ecs.cl.drspexcclc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cl.drspexcclc.service.DrspExcclcService;
import kw.ecs.cl.drspexcclc.vo.DrspExcclcVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * DrExcclcServiceImpl 서비스 클래스
 * 
 * @ClassName DrspExcclcServiceImpl.java
 * @Description 정산 - DR 정산클래스
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
@Service("drspExcclcService")
public class DrspExcclcServiceImpl extends DefaultServiceImpl implements DrspExcclcService {
	protected final static Logger logger = Logger.getLogger(DrspExcclcServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 정산의 DR 정산 목록을 조회한다.
	 * 
	 * @param @DrspExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveDrspExcclcList(DrspExcclcVo drspExcclcVo) throws Exception {
		return ecsCommonDao.selectList("TM_CL24001_Dao_retrieveDrspExcclcList", drspExcclcVo);
	}

	/**
	 * 정산의 DR 정산을 목록을 저장/수정/삭제한다.
	 * 
	 * @param @DrspExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map processDrspExcclcList(List<DrspExcclcVo> drspExcclcVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (DrspExcclcVo drspExcclcVo : drspExcclcVoList) {
			if ("E".equals(drspExcclcVo.getRowStatus()) || "D".equals(drspExcclcVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.delete("TM_CL24001_Dao_deleteDrspExcclcList", drspExcclcVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_CL24001_Dao_saveDrspExcclcList", drspExcclcVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}