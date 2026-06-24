package kw.ecs.cl.recexcclc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cl.recexcclc.service.RecExcclcService;
import kw.ecs.cl.recexcclc.vo.RecExcclcVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * RecExcclcServiceImpl 서비스 클래스
 * 
 * @ClassName RecExcclcServiceImpl.java
 * @Description 정산 - REC 정산 클래스
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
@Service("recExcclcService")
public class RecExcclcServiceImpl extends DefaultServiceImpl implements RecExcclcService {
	protected final static Logger logger = Logger.getLogger(RecExcclcServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 정산의 REC 정산(태양광)을 목록을 조회한다.
	 * 
	 * @param @RecExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveRecExcclcSnpwList(RecExcclcVo recExcclcVo) throws Exception {
		return ecsCommonDao.selectList("TM_CL22001_Dao_retrieveRecExcclcSnpwList", recExcclcVo);
	}

	/**
	 * 정산의 REC 정산(태양광)을 목록을 저장/수정/삭제한다.
	 * 
	 * @param @RecExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processRecExcclcSnpwList(List<RecExcclcVo> recExcclcVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (RecExcclcVo recExcclcVo : recExcclcVoList) {
			if ("E".equals(recExcclcVo.getRowStatus()) || "D".equals(recExcclcVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.delete("TM_CL22001_Dao_deleteRecExcclcSnpwList", recExcclcVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_CL22001_Dao_saveRecExcclcSnpwList", recExcclcVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 정산의 REC 정산(비태양광)을 목록을 조회한다.
	 * 
	 * @param @RecExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveRecExcclcNotSnpwList(RecExcclcVo recExcclcVo) throws Exception {
		return ecsCommonDao.selectList("TM_CL22002_Dao_retrieveRecExcclcNotSnpwList", recExcclcVo);
	}

	/**
	 * 정산의 REC 정산(비태양광)을 목록을 저장/수정/삭제한다.
	 * 
	 * @param @RecExcclcVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processRecExcclcNotSnpwList(List<RecExcclcVo> recExcclcVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (RecExcclcVo recExcclcVo : recExcclcVoList) {
			if ("E".equals(recExcclcVo.getRowStatus()) || "D".equals(recExcclcVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.delete("TM_CL22002_Dao_deleteRecExcclcNotSnpwList", recExcclcVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_CL22002_Dao_saveRecExcclcNotSnpwList", recExcclcVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}