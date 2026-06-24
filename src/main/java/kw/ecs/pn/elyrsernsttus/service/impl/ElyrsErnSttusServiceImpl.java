package kw.ecs.pn.elyrsernsttus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.pn.elyrsernsttus.service.ElyrsErnSttusService;
import kw.ecs.pn.elyrsernsttus.vo.ElyrsErnSttusVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * ElyrsErnSttusServiceImpl 서비스 클래스
 * 
 * @ClassName ElyrsErnSttusServiceImpl.java
 * @Description 생산 - 계획대비 발전수익 현황
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.02.17		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 02. 17
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
@Service("elyrsErnSttusService")
public class ElyrsErnSttusServiceImpl extends DefaultServiceImpl implements ElyrsErnSttusService {
	protected final static Logger logger = Logger.getLogger(ElyrsErnSttusServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 생산 계획대비 발전수익 현황을 조회한다.
	 * 
	 * @param @ElyrsErnSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveElyrsErnSttusList(ElyrsErnSttusVo elyrsErnSttusVo) throws Exception {
		return ecsCommonDao.selectList("ELYRS_ERN_STTUS_Dao_retrieveElyrsErnSttusList", elyrsErnSttusVo);
	}
}