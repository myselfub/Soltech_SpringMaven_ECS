package kw.ecs.zz.ntt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.zz.ntt.service.EcsNttService;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * EcsNttServiceImpl 서비스 클래스
 * 
 * @ClassName EcsNttServiceImpl.java
 * @Description 공지사항 서비스 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.08.30		60002958			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 수자원통합 60002958
 * @since 2017. 08. 30.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@Service("ecsNttService")
public class EcsNttServiceImpl extends DefaultServiceImpl implements EcsNttService {
	protected final static Logger LOGGER = Logger.getLogger(EcsNttServiceImpl.class);

	/** CommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 공지팝업 조회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveNttPopup(Map param) throws Exception {
		return ecsCommonDao.selectList("TM_SC_NTT_Dao_retrieveNttPopup", param);
	}
}