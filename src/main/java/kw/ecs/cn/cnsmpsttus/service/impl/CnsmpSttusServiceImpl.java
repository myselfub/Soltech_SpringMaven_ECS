package kw.ecs.cn.cnsmpsttus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cn.cnsmpsttus.service.CnsmpSttusService;
import kw.ecs.cn.cnsmpsttus.vo.CnsmpSttusVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * CnsmpSttusServiceImpl 서비스 클래스
 * 
 * @ClassName CnsmpSttusServiceImpl.java
 * @Description 소비 - 전력에너지 소비현황 클래스
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
@Service("cnsmpSttusService")
public class CnsmpSttusServiceImpl extends DefaultServiceImpl implements CnsmpSttusService {
	protected final static Logger logger = Logger.getLogger(CnsmpSttusServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 소비의 에너지 소비현황의 조회조건 부서를 조회한다.
	 * 
	 * @param @CnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCnsmpSttusCndDeptList(CnsmpSttusVo cnsmpSttusVo) throws Exception {
		return ecsCommonDao.selectList("CNSMP_STTUS_Dao_retrieveCnsmpSttusCndDeptList", cnsmpSttusVo);
	}

	/**
	 * 소비의 에너지 소비현황 목록을 조회한다.
	 * 
	 * @param @CnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCnsmpSttusList(CnsmpSttusVo cnsmpSttusVo) throws Exception {
		return ecsCommonDao.selectList("CNSMP_STTUS_Dao_retrieveCnsmpSttusList", cnsmpSttusVo);
	}

	/**
	 * 소비의 에너지 소비현황 차트를 조회한다.
	 * 
	 * @param @CnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCnsmpSttusChart(CnsmpSttusVo cnsmpSttusVo) throws Exception {
		return ecsCommonDao.selectList("CNSMP_STTUS_Dao_retrieveCnsmpSttusChart", cnsmpSttusVo);
	}

	/**
	 * 소비의 에너지 소비현황 위탁사업장 목록을 조회한다.
	 * 
	 * @param @CnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCnsmpSttusCsmtBplcList(CnsmpSttusVo cnsmpSttusVo) throws Exception {
		return ecsCommonDao.selectList("CNSMP_STTUS_Dao_retrieveCnsmpSttusCsmtBplcList", cnsmpSttusVo);
	}
}