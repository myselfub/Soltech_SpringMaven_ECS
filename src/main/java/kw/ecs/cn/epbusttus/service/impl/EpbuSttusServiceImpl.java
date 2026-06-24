package kw.ecs.cn.epbusttus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cn.epbusttus.service.EpbuSttusService;
import kw.ecs.cn.epbusttus.vo.EpbuSttusVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * EpbuSttusServiceImpl 서비스 클래스
 * 
 * @ClassName EpbuSttusServiceImpl.java
 * @Description 소비 - 광역 전력원단위 현황
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
@Service("epbuSttusService")
public class EpbuSttusServiceImpl extends DefaultServiceImpl implements EpbuSttusService {
	protected final static Logger logger = Logger.getLogger(EpbuSttusServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 소비 광역 전력원단위 현황을 조회한다.
	 * 
	 * @param @EpbuSttusVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveEpbuSttusList(EpbuSttusVo epbuSttusVo) throws Exception {
		return ecsCommonDao.selectList("EPBU_STTUS_Dao_retrieveEpbuSttusList", epbuSttusVo);
	}
}