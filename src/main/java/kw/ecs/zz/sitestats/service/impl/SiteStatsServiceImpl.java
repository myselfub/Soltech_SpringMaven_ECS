package kw.ecs.zz.sitestats.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.common.vo.ECSDefaultVo;
import kw.ecs.zz.sitestats.service.SiteStatsService;
import kw.fw.dao.CommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * SiteStatsServiceImpl 서비스 클래스
 * 
 * @ClassName SiteStatsServiceImpl.java
 * @Description 로그 관리 클래스
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
@Service("siteStatsService")
public class SiteStatsServiceImpl extends DefaultServiceImpl implements SiteStatsService {
	protected final static Logger logger = Logger.getLogger(SiteStatsServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "commonDao")
	private CommonDao commonDao;

	/**
	 * 로그 관리 사이트 총 방문자수 목록을 조회한다.
	 * 
	 * @param ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveVisitrCntByDt(ECSDefaultVo ecsDefaultVo) throws Exception {
		return commonDao.selectList("SITE_STATS_Dao_retrieveVisitrCntByDt", ecsDefaultVo);
	}

	/**
	 * 로그 관리 사이트 총 부서별 방문자수 목록을 조회한다.
	 * 
	 * @param ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveDeptVisitrCntByDt(ECSDefaultVo ecsDefaultVo) throws Exception {
		return commonDao.selectList("SITE_STATS_Dao_retrieveDeptVisitrCntByDt", ecsDefaultVo);
	}

	/**
	 * 로그 관리 사이트 월별/년별 총 방문자수 목록을 조회한다.
	 * 
	 * @param ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveMtYyVisitrCntByDt(ECSDefaultVo ecsDefaultVo) throws Exception {
		return commonDao.selectList("SITE_STATS_Dao_retrieveMtYyVisitrCntByDt", ecsDefaultVo);
	}

	/**
	 * 로그 관리 메뉴별 방문자수 목록을 조회한다.
	 * 
	 * @param ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveVisitrCntByMenu(ECSDefaultVo ecsDefaultVo) throws Exception {
		return commonDao.selectList("SITE_STATS_Dao_retrieveVisitrCntByMenu", ecsDefaultVo);
	}
}