package kw.ecs.ec.dsbrd.pc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.common.vo.ECSDefaultVo;
import kw.ecs.dao.EcsCommonDao;
import kw.ecs.ec.dsbrd.pc.service.DsbrdPcService;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * DsbrdPcServiceImpl 서비스 클래스
 * 
 * @ClassName DsbrdPcServiceImpl.java
 * @Description 에너지전주기 - 생산/소비 대시보드
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
@Service("dsbrdPcService")
public class DsbrdPcServiceImpl extends DefaultServiceImpl implements DsbrdPcService {
	protected final static Logger logger = Logger.getLogger(DsbrdPcServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 생산/소비 전력에너지 운영현황 차트를 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveEpwrEnergyOperSttusList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PC_Dao_retrieveEpwrEnergyOperSttusList", ecsDefaultVo);
	}

	/**
	 * 생산/소비 전력생산을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnEpwrList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PC_Dao_retrievePrdctnEpwrList", ecsDefaultVo);
	}

	/**
	 * 생산/소비 전력소비를 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnstnEpwrList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PC_Dao_retrieveCnstnEpwrList", ecsDefaultVo);
	}

	/**
	 * 생산/소비 유역별 생산현황 차트를 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnChartList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PC_Dao_retrievePrdctnChartList", ecsDefaultVo);
	}

	/**
	 * 생산/소비 유역별 소비현황 차트를 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnstnChartList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PC_Dao_retrieveCnstnChartList", ecsDefaultVo);
	}

	/**
	 * 탄소중립현황을 조회한다.
	 * 
	 * @param @EcsDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCbnNtrlt(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PC_Dao_retrieveCbnNtrltList", ecsDefaultVo);
	}
}