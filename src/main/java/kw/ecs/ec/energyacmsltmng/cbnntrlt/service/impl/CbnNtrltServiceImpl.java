package kw.ecs.ec.energyacmsltmng.cbnntrlt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.ec.energyacmsltmng.cbnntrlt.service.CbnNtrltService;
import kw.ecs.ec.energyacmsltmng.cbnntrlt.vo.CbnNtrltVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * CbnNtrltServiceImpl 서비스 클래스
 * 
 * @ClassName CbnNtrltServiceImpl.java
 * @Description 에너지전주기 - 전력에너지실적현황의 탄소중립율
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.02.13		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 02. 13
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
@Service("cbnNtrltService")
public class CbnNtrltServiceImpl extends DefaultServiceImpl implements CbnNtrltService {
	protected final static Logger logger = Logger.getLogger(CbnNtrltServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 전력에너지실적현황의 탄소중립율을 조회한다.
	 * 
	 * @param @CbnNtrltVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCbnNtrltList(CbnNtrltVo cbnNtrltVo) throws Exception {
		return ecsCommonDao.selectList("CBN_NTRLT_Dao_retrieveCbnNtrltList", cbnNtrltVo);
	}
}