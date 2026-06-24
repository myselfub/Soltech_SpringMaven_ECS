package kw.ecs.ec.dsbrd.cl.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.common.vo.ECSDefaultVo;
import kw.ecs.dao.EcsCommonDao;
import kw.ecs.ec.dsbrd.cl.service.DsbrdClService;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * DsbrdClServiceImpl 서비스 클래스
 * 
 * @ClassName DsbrdClServiceImpl.java
 * @Description 에너지전주기 - 정산 대시보드
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
@Service("dsbrdClService")
public class DsbrdClServiceImpl extends DefaultServiceImpl implements DsbrdClService {
	protected final static Logger logger = Logger.getLogger(DsbrdClServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 정산 발전수익을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePrdctnExcclcList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_CL_Dao_retrievePrdctnExcclcList", ecsDefaultVo);
	}

	/**
	 * 정산 기타수익을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveEtcExcclcList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_CL_Dao_retrieveEtcExcclcList", ecsDefaultVo);
	}

	/**
	 * 정산 소비정산을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnstnExcclcList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_CL_Dao_retrieveCnstnExcclcList", ecsDefaultVo);
	}
}