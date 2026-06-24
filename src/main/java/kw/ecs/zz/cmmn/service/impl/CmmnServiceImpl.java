package kw.ecs.zz.cmmn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.common.vo.ECSDefaultVo;
import kw.ecs.dao.EcsCommonDao;
import kw.ecs.zz.cmmn.service.CmmnService;
import kw.ecs.zz.cmmn.vo.CmmnEctccVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * CmmnServiceImpl 서비스 클래스
 * 
 * @ClassName CmmnServiceImpl.java
 * @Description 공통 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.07.01		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 07. 01
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
@Service("cmmnService")
public class CmmnServiceImpl extends DefaultServiceImpl implements CmmnService {
	protected final static Logger logger = Logger.getLogger(CmmnServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 공통 HRM 본부 목록 조회한다.
	 * 
	 * @param
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveHRMHQList() throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveHRMHQList");
	}

	/**
	 * 공통 HRM 부서(지사) 목록 조회한다.
	 * 
	 * @param
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveHRMDeptList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveHRMDeptList", ecsDefaultVo);
	}

	/**
	 * 공통 팝업에서 HRM 사용자 목록을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveHRMUserList(ECSDefaultVo ecsDefaultVo) {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveHRMUserList", ecsDefaultVo);
	}

	/**
	 * 공통 팝업에서 사용자 이름과 부서를 가지고 HRM의 사원번호 목록을 조회한다.(동명이인이면 사원번호가 가장 높은 사원번호로
	 * 조회한다.)
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveOasisElctrnDocHRMUser(ECSDefaultVo ecsDefaultVo) {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveOasisElctrnDocHRMUser", ecsDefaultVo);
	}

	/**
	 * 공통 팝업에서 오아시스 부서와 HRM 부서를 맵핑하여 조회한다.(오아시스 부서코드를 넣으면 HRM의 부서코드로 변환한다.)
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveOasisElctrnDocHRMDept(ECSDefaultVo ecsDefaultVo) {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveOasisElctrnDocHRMDept", ecsDefaultVo);
	}

	/**
	 * 공통 팝업에서 오아시스 부서와 HRM 폐기부서를 맵핑하여 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveOasisElctrnDocHRMDsuseDept(ECSDefaultVo ecsDefaultVo) {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveOasisElctrnDocHRMDsuseDept", ecsDefaultVo);
	}

	/**
	 * 공통 발전원 목록 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveSetcscList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveSetcscList", ecsDefaultVo);
	}

	/**
	 * 공통 발전소 목록 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveElcpwstnList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveElcpwstnList", ecsDefaultVo);
	}

	/**
	 * 공통 소비원 목록 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnstscList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveCnstscList", ecsDefaultVo);
	}

	/**
	 * 공통 ECS 연동 유역(공통코드) 목록 조회한다.
	 * 
	 * @param
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveBasinMappingList() throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveBasinMappingList");
	}

	/**
	 * 공통 ECS 연동 전체부서 목록 조회한다.
	 * 
	 * @param
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveAllDeptMappingList() throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveAllDeptMappingList");
	}

	/**
	 * 공통 ECS 연동 부서(지사) 목록 조회한다.
	 * 
	 * @param
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveDeptMappingList() throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveDeptMappingList");
	}

	/**
	 * 공통 ECS 사업장(공통코드) 목록을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveBplcList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveBplcList", ecsDefaultVo);
	}

	/**
	 * 공통 소비(GHG)의 조회조건(부서) 목록을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCnsmpCndDeptList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveCnsmpCndDeptList", ecsDefaultVo);
	}

	/**
	 * 공통 수전전력량계 관리의 조회조건(부서) 목록을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveWtwkEltengMsrinsCndDeptList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveWtwkEltengMsrinsCndDeptList", ecsDefaultVo);
	}

	/**
	 * 공통 생산의 조회조건(부서) 목록을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrdctnCndDeptList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrievePrdctnCndDeptList", ecsDefaultVo);
	}

	/**
	 * 공통 생산의 조회조건(발전소) 목록을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrdctnCndElcpwstnList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrievePrdctnCndElcpwstnList", ecsDefaultVo);
	}

	/**
	 * 공통 소비의 조회조건(부서) 목록을 조회한다.(한전)
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCnsmpSttusCndKepcoDeptList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveCnsmpSttusCndKepcoDeptList", ecsDefaultVo);
	}

	/**
	 * 공통 소비의 소내태양광 부서 목록을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveInhouseSnpwDeptList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveInhouseSnpwDeptList", ecsDefaultVo);
	}

	/**
	 * 공통 정산의 조회조건(REC발전원) 목록을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveRecCndSetcscList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveRecCndSetcscList", ecsDefaultVo);
	}

	/**
	 * 공통 소비전력 비교현황의 조회조건(부서) 목록을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCmprSttusDeptList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrieveCmprSttusDeptList", ecsDefaultVo);
	}

	/**
	 * 공통 계획/건설의 조회조건(진행현황) 목록을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrgsSttusList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("CMMN_SQL_Dao_retrievePrgsSttusList", ecsDefaultVo);
	}

	/**
	 * 공통 ECS_전자문서 상세 사업추진절차 목록을 조회한다.
	 * 
	 * @param @CmmnEctccVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveEctccPrgsList(CmmnEctccVo cmmnEctccVo) throws Exception {
		return ecsCommonDao.selectList("TM_ECS_ECTCC_LNK_Dao_retrieveEctccPrgsList", cmmnEctccVo);
	}

	/**
	 * 공통 ECS_전자문서 연계 목록을 조회한다.
	 * 
	 * @param @CmmnEctccVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveEctccList(CmmnEctccVo cmmnEctccVo) throws Exception {
		return ecsCommonDao.selectList("TM_ECS_ECTCC_LNK_Dao_retrieveEctccList", cmmnEctccVo);
	}

	/**
	 * 공통 ECS_전자문서 연계의 데이터를 저장한다.
	 * 
	 * @param @CmmnEctccVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map insertEctcc(CmmnEctccVo cmmnEctccVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = ecsCommonDao.insert("TM_ECS_ECTCC_LNK_Dao_insertEctcc", cmmnEctccVo);
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 공통 ECS_전자문서 연계의 데이터 목록을 저장/삭제한다.
	 * 
	 * @param @CmmnEctccVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map processEctccList(List<CmmnEctccVo> cmmnEctccVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (CmmnEctccVo cmmnEctccVo : cmmnEctccVoList) {
			if ("E".equals(cmmnEctccVo.getRowStatus()) || "D".equals(cmmnEctccVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.insert("TM_ECS_ECTCC_LNK_Dao_deleteEctcc", cmmnEctccVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.insert("TM_ECS_ECTCC_LNK_Dao_insertEctcc", cmmnEctccVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}

	/**
	 * 공통 ECS_전자문서 연계의 데이터를 삭제한다.
	 * 
	 * @param @CmmnEctccVo
	 * @return Map 데이터 맵 객체
	 * @throws Exception
	 */
	@Override
	public Map deleteEctcc(CmmnEctccVo cmmnEctccVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = ecsCommonDao.delete("TM_ECS_ECTCC_LNK_Dao_deleteEctcc", cmmnEctccVo);
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}