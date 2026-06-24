package kw.ecs.pb.plancnstrc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.pb.plancnstrc.service.PlanCnstrcService;
import kw.ecs.pb.plancnstrc.vo.PlanCnstrcVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * PlanCnstrcServiceImpl 서비스 클래스
 * 
 * @ClassName PlanCnstrcServiceImpl.java
 * @Description 계획/건설 - 계획/건설 목록 클래스
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
@Service("planCnstrcService")
public class PlanCnstrcServiceImpl extends DefaultServiceImpl implements PlanCnstrcService {
	protected final static Logger logger = Logger.getLogger(PlanCnstrcServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 계획/건설의 계획/건설 목록을 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePlanCnstrcList(PlanCnstrcVo planCnstrcVo) throws Exception {
		return ecsCommonDao.selectList("TM_PB10001_Dao_retrievePlanCnstrcList", planCnstrcVo);
	}

	/**
	 * 계획/건설의 계획 목록을 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePlanList(PlanCnstrcVo planCnstrcVo) throws Exception {
		return ecsCommonDao.selectList("TM_PB10001_Dao_retrievePlanList", planCnstrcVo);
	}

	/**
	 * 계획/건설의 계획/건설 목록 상세보기를 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map selectPlanCnstrc(PlanCnstrcVo planCnstrcVo) throws Exception {
		return ecsCommonDao.select("TM_PB10001_Dao_selectPlanCnstrc", planCnstrcVo);
	}

	/**
	 * 계획/건설의 계획/건설 목록 상세보기 전자문서를 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePlanCnstrcElctrnDoc(PlanCnstrcVo planCnstrcVo) throws Exception {
		return ecsCommonDao.selectList("TM_PB10001_Dao_retrievePlanCnstrcElctrnDoc", planCnstrcVo);
	}

	/**
	 * 계획/건설의 계획/건설 목록-계획을 저장/수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map savePlan(PlanCnstrcVo planCnstrcVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		rtnCnt += ecsCommonDao.update("TM_PB10001_Dao_savePlan", planCnstrcVo);
		if (planCnstrcVo != null && planCnstrcVo.getCmsBsnsCd() != null && !"".equals(planCnstrcVo.getCmsBsnsCd())) {
			rtnCnt += ecsCommonDao.update("TM_PB10002_Dao_saveCnstrc", planCnstrcVo);
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 계획/건설의 계획/건설 목록-계획의 세부사항을 저장/수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map savePlanData(PlanCnstrcVo planCnstrcVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		rtnCnt += ecsCommonDao.update("TM_PB10001_Dao_savePlanData", planCnstrcVo);
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 계획/건설의 계획/건설 목록-계획 담당부서, 담당자, 수립일을 수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map updatePlanData(PlanCnstrcVo planCnstrcVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		rtnCnt += ecsCommonDao.update("TM_PB10001_Dao_updatePlanData", planCnstrcVo);
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 계획/건설의 계획-계획 설비용량, 금액, 계획내용을 수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map updatePlanCpctyAmtCtnt(PlanCnstrcVo planCnstrcVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		rtnCnt += ecsCommonDao.update("TM_PB10001_Dao_updatePlanCpctyAmtCtnt", planCnstrcVo);
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 계획/건설의 계획/건설 목록-계획을 삭제한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map deletePlan(PlanCnstrcVo planCnstrcVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = ecsCommonDao.update("TM_PB10001_Dao_deletePlan", planCnstrcVo);
		//rtnCnt += ecsCommonDao.delete("TM_ECS_ECTCC_LNK_Dao_deleteEctcc", planCnstrcVo);//test
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 계획/건설의 계획/건설 목록-건설을 저장/수정한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map saveCnstrc(PlanCnstrcVo planCnstrcVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = ecsCommonDao.update("TM_PB10002_Dao_saveCnstrc", planCnstrcVo);
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 계획/건설의 계획/건설 목록- 계획-건설의 개수를 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map selectCnstrcCount(PlanCnstrcVo planCnstrcVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = ecsCommonDao.select("TM_PB10002_Dao_selectCnstrcCount", planCnstrcVo);
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 계획/건설의 계획/건설 목록-건설을 삭제한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map deleteCnstrc(PlanCnstrcVo planCnstrcVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = ecsCommonDao.update("TM_PB10002_Dao_deleteCnstrc", planCnstrcVo);
		//rtnCnt += ecsCommonDao.delete("TM_ECS_ECTCC_LNK_Dao_deleteEctcc", planCnstrcVo);//test
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 계획/건설의 CMS 프로젝트 목록을 조회한다.
	 * 
	 * @param @PlanCnstrcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveProjectList(PlanCnstrcVo planCnstrcVo) throws Exception {
		return ecsCommonDao.selectList("VM_CS01003_01_Dao_retrieveProjectList", planCnstrcVo);
	}
}