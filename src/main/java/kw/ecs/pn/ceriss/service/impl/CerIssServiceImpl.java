package kw.ecs.pn.ceriss.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.pn.ceriss.service.CerIssService;
import kw.ecs.pn.ceriss.vo.CerIssVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * CerIssServiceImpl 서비스 클래스
 * 
 * @ClassName CerIssServiceImpl.java
 * @Description 생산 - CER 발급량 클래스
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
@Service("cerIssService")
public class CerIssServiceImpl extends DefaultServiceImpl implements CerIssService {
	protected final static Logger logger = Logger.getLogger(CerIssServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 생산의 CER 발급량 목록을 조회한다.
	 * 
	 * @param param
	 *            : @CerIssVo 의 데이터
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCerIssList(CerIssVo cerIssVo) throws Exception {
		return ecsCommonDao.selectList("TM_PN60001_Dao_retrieveCerIssList", cerIssVo);
	}

	/**
	 * 생산의 CER 발급량 목록을 저장/수정/삭제한다.
	 * 
	 * @param param
	 *            : @CerIssVo 의 데이터
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map processCerIssList(List<CerIssVo> cerIssVoList) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = 0;

		for (CerIssVo cerIssVo : cerIssVoList) {
			if ("E".equals(cerIssVo.getRowStatus()) || "D".equals(cerIssVo.getRowStatus())) {
				rtnCnt += ecsCommonDao.update("TM_PN60001_Dao_deleteCerIssList", cerIssVo);
			} else { // C, U
				rtnCnt += ecsCommonDao.update("TM_PN60001_Dao_saveCerIssList", cerIssVo);
			}
		}
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}