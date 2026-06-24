package kw.ecs.pn.reciss.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.pn.reciss.service.RecIssService;
import kw.ecs.pn.reciss.vo.RecIssVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * RecIssServiceImpl 서비스 클래스
 * 
 * @ClassName RecIssServiceImpl.java
 * @Description 생산 - REC 발급량 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.15		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 15
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
@Service("recIssService")
public class RecIssServiceImpl extends DefaultServiceImpl implements RecIssService {
	protected final static Logger logger = Logger.getLogger(RecIssServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 생산의 REC 발급량 목록을 조회한다.
	 * 
	 * @param param
	 *            : @RecIssVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveRecIssList(RecIssVo recIssVo) throws Exception {
		return ecsCommonDao.selectList("TM_PN50001_Dao_retrieveRecIssList", recIssVo);
	}

	/**
	 * 생산의 REC 발급량 목록을 목록을 저장/수정/삭제한다.
	 * 
	 * @param param
	 *            : @RecIssVo 의 데이터
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map processRecIssList(List<RecIssVo> recIssVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (RecIssVo recIssVo : recIssVoList) {
			if ("E".equals(recIssVo.getRowStatus()) || "D".equals(recIssVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.update("TM_PN50001_Dao_deleteRecIssList", recIssVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_PN50001_Dao_saveRecIssList", recIssVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}