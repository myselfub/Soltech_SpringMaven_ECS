package kw.ecs.pn.prdctnsttus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.pn.prdctnsttus.service.PrdctnSttusService;
import kw.ecs.pn.prdctnsttus.vo.PrdctnSttusVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * PrdctnSttusServiceImpl 서비스 클래스
 * 
 * @ClassName PrdctnSttusServiceImpl.java
 * @Description 생산 - 전력에너지 생산현황 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.15		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 15
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
@Service("prdctnSttusService")
public class PrdctnSttusServiceImpl extends DefaultServiceImpl implements PrdctnSttusService {
	protected final static Logger logger = Logger.getLogger(PrdctnSttusServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 생산의 발전월별 생산현황을 조회한다.
	 * 
	 * @param param
	 *            : prdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrdctnSttusSetcscByList(PrdctnSttusVo prdctnSttusVo) throws Exception {
		return ecsCommonDao.selectList("PRDCTN_STTUS_Dao_retrievePrdctnSttusSetcscByList", prdctnSttusVo);
	}

	/**
	 * 생산의 발전월별 생산현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : prdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrdctnSttusSetcscByChartList(PrdctnSttusVo prdctnSttusVo) throws Exception {
		return ecsCommonDao.selectList("PRDCTN_STTUS_Dao_retrievePrdctnSttusSetcscByChartList", prdctnSttusVo);
	}

	/**
	 * 생산의 부서별 생산현황을 조회한다.
	 * 
	 * @param param
	 *            : prdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrdctnSttusDeptByList(PrdctnSttusVo prdctnSttusVo) throws Exception {
		return ecsCommonDao.selectList("PRDCTN_STTUS_Dao_retrievePrdctnSttusDeptByList", prdctnSttusVo);
	}

	/**
	 * 생산의 부서별 생산현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : prdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrdctnSttusDeptByChartList(PrdctnSttusVo prdctnSttusVo) throws Exception {
		return ecsCommonDao.selectList("PRDCTN_STTUS_Dao_retrievePrdctnSttusDeptByChartList", prdctnSttusVo);
	}
}