package kw.ecs.ec.energyacmsltmng.re100.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.ec.energyacmsltmng.re100.service.Re100Service;
import kw.ecs.ec.energyacmsltmng.re100.vo.Re100Vo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * Re100ServiceImpl 서비스 클래스
 * 
 * @ClassName Re100ServiceImpl.java
 * @Description 에너지전주기 - 전력에너지실적현황의 RE100
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
@Service("re100Service")
public class Re100ServiceImpl extends DefaultServiceImpl implements Re100Service {
	protected final static Logger logger = Logger.getLogger(Re100ServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 전력에너지실적현황의 RE100을 조회한다.
	 * 
	 * @param @Re100Vo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveRe100List(Re100Vo re100Vo) throws Exception {
		return ecsCommonDao.selectList("TM_EC42001_Dao_retrieveRe100List", re100Vo);
	}

	/**
	 * 전력에너지실적현황의 RE100을 저장(수정)한다.
	 * 
	 * @param @Re100Vo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map saveRe100(List<Re100Vo> re100VoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (Re100Vo re100Vo : re100VoList) {
			rtnCnt += ecsCommonDao.update("TM_EC42001_Dao_saveRe100", re100Vo);
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}