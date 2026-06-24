package kw.ecs.cl.reccer.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cl.reccer.service.RecCerService;
import kw.ecs.cl.reccer.vo.RecCerVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * CbnrltServiceImpl 서비스 클래스
 * 
 * @ClassName RecCerServiceImpl.java
 * @Description 정산 - REC, CER 정산종합
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
@Service("recCerService")
public class RecCerServiceImpl extends DefaultServiceImpl implements RecCerService {
	protected final static Logger logger = Logger.getLogger(RecCerServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 정산의 REC, CER 정산종합을 조회한다.
	 * 
	 * @param @RecCerVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveRecCerList(RecCerVo recCerVo) throws Exception {
		return ecsCommonDao.selectList("REC_CER_Dao_retrieveRecCerList", recCerVo);
	}
}