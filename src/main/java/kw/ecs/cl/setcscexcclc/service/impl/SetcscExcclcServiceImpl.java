package kw.ecs.cl.setcscexcclc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cl.setcscexcclc.service.SetcscExcclcService;
import kw.ecs.cl.setcscexcclc.vo.SetcscExcclcVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * SetcscExcclcServiceImpl 서비스 클래스
 * 
 * @ClassName SetcscExcclcServiceImpl.java
 * @Description 정산 - 발전원 정산 클래스
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
@Service("setcscExcclcService")
public class SetcscExcclcServiceImpl extends DefaultServiceImpl implements SetcscExcclcService {
	protected final static Logger logger = Logger.getLogger(SetcscExcclcServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 정산의 발전원 정산 목록을 조회한다.
	 * 
	 * @param @SetcscExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveSetcscExcclcList(SetcscExcclcVo setcscExcclcVo) throws Exception {
		return ecsCommonDao.selectList("SETCSC_EXCCLC_Dao_retrieveSetcscExcclcList", setcscExcclcVo);
	}

	/**
	 * 정산의 전력거래 수수료 목록을 조회한다.
	 * 
	 * @param @SetcscExcclcVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveEpwrDelngFee(SetcscExcclcVo setcscExcclcVo) throws Exception {
		return ecsCommonDao.selectList("SETCSC_EXCCLC_Dao_retrieveEpwrDelngFee", setcscExcclcVo);
	}
}