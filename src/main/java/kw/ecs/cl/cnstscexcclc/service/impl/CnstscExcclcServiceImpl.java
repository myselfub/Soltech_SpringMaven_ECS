package kw.ecs.cl.cnstscexcclc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cl.cnstscexcclc.service.CnstscExcclcService;
import kw.ecs.cl.cnstscexcclc.vo.CnstscExcclcVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * CnstscExcclcServiceImpl 서비스 클래스
 * 
 * @ClassName CnstscExcclcServiceImpl.java
 * @Description 정산 - 소비원 정산 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.17		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 17
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
@Service("cnstscExcclcService")
public class CnstscExcclcServiceImpl extends DefaultServiceImpl implements CnstscExcclcService {
	protected final static Logger logger = Logger.getLogger(CnstscExcclcServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 정산의 소비원 정산 자체 목록을 조회한다.
	 * 
	 * @param @CnstscExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCnstscExcclcList(CnstscExcclcVo cnstscExcclcVo) throws Exception {
		return ecsCommonDao.selectList("CNSTSC_EXCCLC_Dao_retrieveCnstscExcclcList", cnstscExcclcVo);
	}

	/**
	 * 정산의 소비원 정산 차트 목록을 조회한다.
	 * 
	 * @param @CnstscExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCnstscExcclcChartList(CnstscExcclcVo cnstscExcclcVo) throws Exception {
		return ecsCommonDao.selectList("CNSTSC_EXCCLC_Dao_retrieveCnstscExcclcChartList", cnstscExcclcVo);
	}

	/**
	 * 정산의 소비원 정산 위탁 목록을 조회한다.
	 * 
	 * @param @CnstscExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCnstscExcclcCsmtBplcList(CnstscExcclcVo cnstscExcclcVo) throws Exception {
		return ecsCommonDao.selectList("CNSTSC_EXCCLC_Dao_retrieveCnstscExcclcCsmtBplcList", cnstscExcclcVo);
	}
}