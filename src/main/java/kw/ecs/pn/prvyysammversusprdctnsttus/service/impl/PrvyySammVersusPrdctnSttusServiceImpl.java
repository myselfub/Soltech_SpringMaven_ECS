package kw.ecs.pn.prvyysammversusprdctnsttus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.pn.prvyysammversusprdctnsttus.service.PrvyySammVersusPrdctnSttusService;
import kw.ecs.pn.prvyysammversusprdctnsttus.vo.PrvyySammVersusPrdctnSttusVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * PrvyySammVersusPrdctnSttusServiceImpl 서비스 클래스
 * 
 * @ClassName PrvyySammVersusPrdctnSttusServiceImpl.java
 * @Description 생산 - 전년동월대비 생산현황 클래스
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
@Service("prvyySammVersusPrdctnSttusService")
public class PrvyySammVersusPrdctnSttusServiceImpl extends DefaultServiceImpl
		implements PrvyySammVersusPrdctnSttusService {
	protected final static Logger logger = Logger.getLogger(PrvyySammVersusPrdctnSttusServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 발전원별 생산의 전년 동월 대비 생산현황 목록을 조회한다.
	 * 
	 * @param param
	 *            : prvyySammVersusPrdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrvyySammVersusPrdctnSttusSetcscByList(
			PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo) throws Exception {
		return ecsCommonDao.selectList(
				"PRVYY_SAMM_VERSUS_PRDCTN_STTUS_Dao_retrievePrvyySammVersusPrdctnSttusSetcscByList",
				prvyySammVersusPrdctnSttusVo);
	}

	/**
	 * 발전원별 생산의 전년 동월 대비 생산현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : prvyySammVersusPrdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrvyySammVersusPrdctnSttusSetcscByChartList(
			PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo) throws Exception {
		return ecsCommonDao.selectList(
				"PRVYY_SAMM_VERSUS_PRDCTN_STTUS_Dao_retrievePrvyySammVersusPrdctnSttusSetcscByChartList",
				prvyySammVersusPrdctnSttusVo);
	}

	/**
	 * 부서별 생산의 전년 동월 대비 생산현황 목록을 조회한다.
	 * 
	 * @param param
	 *            : prvyySammVersusPrdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrvyySammVersusPrdctnSttusDeptByList(
			PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo) throws Exception {
		return ecsCommonDao.selectList(
				"PRVYY_SAMM_VERSUS_PRDCTN_STTUS_Dao_retrievePrvyySammVersusPrdctnSttusDeptByList",
				prvyySammVersusPrdctnSttusVo);
	}

	/**
	 * 부서별 생산의 전년 동월 대비 생산현황 차트를 조회한다.
	 * 
	 * @param param
	 *            : prvyySammVersusPrdctnSttusVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrvyySammVersusPrdctnSttusDeptByChartList(
			PrvyySammVersusPrdctnSttusVo prvyySammVersusPrdctnSttusVo) throws Exception {
		return ecsCommonDao.selectList(
				"PRVYY_SAMM_VERSUS_PRDCTN_STTUS_Dao_retrievePrvyySammVersusPrdctnSttusDeptByChartList",
				prvyySammVersusPrdctnSttusVo);
	}
}