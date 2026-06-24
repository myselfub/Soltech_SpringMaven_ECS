package kw.ecs.cn.prvyysammversuscnsmpsttus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cn.prvyysammversuscnsmpsttus.service.PrvyySammVersusCnsmpSttusService;
import kw.ecs.cn.prvyysammversuscnsmpsttus.vo.PrvyySammVersusCnsmpSttusVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * PrvyySammVersusCnsmpSttusServiceImpl 서비스 클래스
 * 
 * @ClassName PrvyySammVersusCnsmpSttusServiceImpl.java
 * @Description 소비 - 전년동월대비 소비현황 클래스
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
@Service("prvyySammVersusCnsmpSttusService")
public class PrvyySammVersusCnsmpSttusServiceImpl extends DefaultServiceImpl
		implements PrvyySammVersusCnsmpSttusService {
	protected final static Logger logger = Logger.getLogger(PrvyySammVersusCnsmpSttusServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 소비의 전년동월대비 소비현황의 조회조건을 조회한다.
	 * 
	 * @param @PrvyySammVersusCnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrvyySammVersusCnsmpSttusCndDeptList(
			PrvyySammVersusCnsmpSttusVo prvyySammVersusCnsmpSttusVo) throws Exception {
		return ecsCommonDao.selectList("PRVYY_SAMM_VERSUS_CNSMP_STTUS_Dao_retrievePrvyySammVersusCnsmpSttusCndDeptList",
				prvyySammVersusCnsmpSttusVo);
	}

	/**
	 * 소비의 전년동월대비 소비현황을 조회한다.
	 * 
	 * @param @PrvyySammVersusCnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrvyySammVersusCnsmpSttusList(PrvyySammVersusCnsmpSttusVo prvyySammVersusCnsmpSttusVo)
			throws Exception {
		return ecsCommonDao.selectList("PRVYY_SAMM_VERSUS_CNSMP_STTUS_Dao_retrievePrvyySammVersusCnsmpSttusList",
				prvyySammVersusCnsmpSttusVo);
	}

	/**
	 * 소비의 전년동월대비 소비현황 차트를 조회한다.
	 * 
	 * @param @PrvyySammVersusCnsmpSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrievePrvyySammVersusCnsmpSttusChartList(PrvyySammVersusCnsmpSttusVo prvyySammVersusCnsmpSttusVo)
			throws Exception {
		return ecsCommonDao.selectList("PRVYY_SAMM_VERSUS_CNSMP_STTUS_Dao_retrievePrvyySammVersusCnsmpSttusChartList",
				prvyySammVersusCnsmpSttusVo);
	}
}