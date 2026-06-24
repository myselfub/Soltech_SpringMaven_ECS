package kw.ecs.ec.dsbrd.main.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.common.vo.ECSDefaultVo;
import kw.ecs.dao.EcsCommonDao;
import kw.ecs.ec.dsbrd.main.service.DsbrdMainService;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * DsbrdMainServiceImpl 서비스 클래스
 * 
 * @ClassName DsbrdMainServiceImpl.java
 * @Description 에너지전주기 - 메인 대시보드
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.05.03		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 05. 03
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
@Service("dsbrdMainService")
public class DsbrdMainServiceImpl extends DefaultServiceImpl implements DsbrdMainService {
	protected final static Logger logger = Logger.getLogger(DsbrdMainServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 메인 SMP 판매단가를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveSleUpcList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_MAIN_Dao_retrieveSMPSleUpcList", ecsDefaultVo);
	}

	/**
	 * 메인 K-Water 판매단가를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveKWaterUpcList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_MAIN_Dao_retrieveKWaterUpcList", ecsDefaultVo);
	}

	/**
	 * 메인 RE100 이행률을 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveRe100FlflList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("TM_EC42001_Dao_retrieveRe100FlflList", ecsDefaultVo);
	}

	/**
	 * 메인 전력에너지 전주기 현황 생산/소비 데이터를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCyclePCList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_MAIN_Dao_retrieveCyclePCList", ecsDefaultVo);
	}

	/**
	 * 메인 유역현황도 데이터를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBasinSttusList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_MAIN_Dao_retrieveBasinSttusList", ecsDefaultVo);
	}

	/**
	 * 메인 유역현황도 유역별 - 지도 정보(지사들의 좌표, 크기 등) 데이터를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBasinMapInfoList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_MAIN_Dao_retrieveBasinMapInfoList", ecsDefaultVo);
	}

	/**
	 * 메인 유역현황도 유역별 - 부서 생산 데이터를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBasinDeptPrdctnSttusList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_MAIN_Dao_retrieveBasinDeptPrdctnSttusList", ecsDefaultVo);
	}

	/**
	 * 메인 유역현황도 유역별 - 부서 소비 데이터를 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBasinDeptCnstnSttusList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_MAIN_Dao_retrieveBasinDeptCnstnSttusList", ecsDefaultVo);
	}
}