package kw.ecs.cn.inhousesnpw.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cn.inhousesnpw.service.InhouseSnpwService;
import kw.ecs.cn.inhousesnpw.vo.InhouseSnpwVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * InhouseSnpwServiceImpl 서비스 클래스
 * 
 * @ClassName InhouseSnpwServiceImpl.java
 * @Description 소비 - Net-Zero 소내태양광 현황
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
@Service("inhouseSnpwService")
public class InhouseSnpwServiceImpl extends DefaultServiceImpl implements InhouseSnpwService {
	protected final static Logger logger = Logger.getLogger(InhouseSnpwServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 소비 Net-Zero 소내태양광 현황의 소내태양광발전량을 조회한다.
	 * 
	 * @param @InhouseSnpwVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveInhouseSnpwList(InhouseSnpwVo inhouseSnpwVo) throws Exception {
		return ecsCommonDao.selectList("INHOUSE_SNPW_Dao_retrieveInhouseSnpwList", inhouseSnpwVo);
	}

	/**
	 * 소비 Net-Zero 소내태양광 현황의 소내태양광발전량 예측값을 조회한다.
	 * 
	 * @param @InhouseSnpwVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveInhouseSnpwPredictList(InhouseSnpwVo inhouseSnpwVo) throws Exception {
		return ecsCommonDao.selectList("INHOUSE_SNPW_Dao_retrieveInhouseSnpwPredictList", inhouseSnpwVo);
	}
}