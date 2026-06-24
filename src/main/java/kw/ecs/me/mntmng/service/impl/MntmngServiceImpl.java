package kw.ecs.me.mntmng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.me.mntmng.service.MntmngService;
import kw.ecs.me.mntmng.vo.BudgetExcutVo;
import kw.ecs.me.mntmng.vo.MntmngVo;
import kw.fw.dao.CommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * MntmngServiceImpl 서비스 클래스
 * 
 * @ClassName MntmngServiceImpl.java
 * @Description 관리/폐기 - 에너지 관리 클래스
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
@Service("mntmngService")
public class MntmngServiceImpl extends DefaultServiceImpl implements MntmngService {
	protected final static Logger logger = Logger.getLogger(MntmngServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;
	/** CommonDao 적용 */
	@Resource(name = "commonDao")
	private CommonDao commonDao;

	/**
	 * 관리/폐기의 에너지 관리 목록을 조회한다.
	 * 
	 * @param @MntmngVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveMntmngList(MntmngVo mntmngVo) throws Exception {
		return ecsCommonDao.selectList("TM_ME10001_Dao_retrieveMntmngList", mntmngVo);
	}

	/**
	 * 관리/폐기의 설비관리 상세이력 목록을 조회한다.
	 * 
	 * @param @MntmngVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveMntmngHistList(MntmngVo mntmngVo) throws Exception {
		/*
		 * List<Map> histList =
		 * ecsCommonDao.selectList("TM_ME10001_Dao_retrieveMntmngHistList",
		 * mntmngVo);
		 * 
		 * Set<String> paramSet = new HashSet<String>(); for (Object obj :
		 * histList) { Map result = (Map) obj; if (result.get("ordgDrftId") !=
		 * null && !"".equals((String) result.get("ordgDrftId"))) {
		 * paramSet.add((String) result.get("ordgDrftId")); } if
		 * (result.get("scsbidDrftId") != null && !"".equals((String)
		 * result.get("scsbidDrftId"))) { paramSet.add((String)
		 * result.get("scsbidDrftId")); } if (result.get("cntrctDrftId") != null
		 * && !"".equals((String) result.get("cntrctDrftId"))) {
		 * paramSet.add((String) result.get("cntrctDrftId")); } } List<Object>
		 * titleList =
		 * commonDao.selectList("TM_SC_SANCTN_MSTR_retrieveEctccTitleList",
		 * paramSet.stream().collect(Collectors.toList())); if (titleList ==
		 * null || titleList.size() < 1) { return histList; } Map<String,
		 * String> mappingMap = titleList.stream().collect(Collectors.toMap(
		 * obj1 -> (String) ((Map) obj1).get("aprvRequstNo"), obj2 -> (String)
		 * ((Map) obj2).get("docTit")));
		 * 
		 * List<Map> resultMap = histList.stream().map(obj -> { Map map = (Map)
		 * obj; if (map.get("ordgDrftId") != null && !"".equals((String)
		 * map.get("ordgDrftId"))) { String title = mappingMap.get((String)
		 * map.get("ordgDrftId")); if (title != null && !"".equals(title)) {
		 * map.put("ordgDfrtTit", title); } } if (map.get("scsbidDrftId") !=
		 * null && !"".equals((String) map.get("scsbidDrftId"))) { String title
		 * = mappingMap.get((String) map.get("scsbidDrftId")); if (title != null
		 * && !"".equals(title)) { map.put("scsbidDrftTit", title); } } if
		 * (map.get("cntrctDrftId") != null && !"".equals((String)
		 * map.get("cntrctDrftId"))) { String title = mappingMap.get((String)
		 * map.get("cntrctDrftId")); if (title != null && !"".equals(title)) {
		 * map.put("cntrctDrftTit", title); } } return map;
		 * }).collect(Collectors.toList());
		 * 
		 * return resultMap;
		 */
		return ecsCommonDao.selectList("TM_ME10001_Dao_retrieveMntmngHistList", mntmngVo);
	}

	/**
	 * 관리/폐기의 에너지 관리 목록을 저장/수정/삭제한다.
	 * 
	 * @param @MntmngVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map processMntmng(List<MntmngVo> mntmngVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (MntmngVo mntmngVo : mntmngVoList) {
			if ("E".equals(mntmngVo.getRowStatus()) || "D".equals(mntmngVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.delete("TM_ME10001_Dao_deleteMntmng", mntmngVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_ME10001_Dao_saveMntmng", mntmngVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 관리/폐기의 에너지 관리 상세보기를 저장(수정)한다.
	 * 
	 * @param @MntmngVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map saveMntmng(MntmngVo mntmngVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = ecsCommonDao.update("TM_ME10001_Dao_saveMntmng", mntmngVo);
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 관리/폐기의 에너지 관리 상세보기를 삭제한다.
	 * 
	 * @param @MntmngVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map deleteMntmng(MntmngVo mntmngVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = ecsCommonDao.update("TM_ME10001_Dao_deleteMntmng", mntmngVo);
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 관리/폐기의 예산집행(RFC) 목록을 조회한다.
	 * 
	 * @param @BudgetExcutVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBudgetExcutList(BudgetExcutVo budgetExcutVo) throws Exception {
		return ecsCommonDao.selectList("TM_ME10002_Dao_retrieveBudgetExcutList", budgetExcutVo);
	}

	/**
	 * 관리/폐기의 예산집행(RFC)를 저장/수정/삭제한다.
	 * 
	 * @param @BudgetExcutVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	public Map processBudgetExcut(List<BudgetExcutVo> budgetExcutVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (BudgetExcutVo budgetExcutVo : budgetExcutVoList) {
			if ("E".equals(budgetExcutVo.getRowStatus()) || "D".equals(budgetExcutVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.delete("TM_ME10002_Dao_deleteBudgetExcut", budgetExcutVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_ME10002_Dao_saveBudgetExcut", budgetExcutVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}