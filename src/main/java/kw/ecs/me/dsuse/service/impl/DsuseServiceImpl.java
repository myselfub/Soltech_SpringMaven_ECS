package kw.ecs.me.dsuse.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.me.dsuse.service.DsuseService;
import kw.ecs.me.dsuse.vo.DsuseVo;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * DsuseServiceImpl 서비스 클래스
 * 
 * @ClassName DsuseServiceImpl.java
 * @Description 관리/폐기 - 폐기 목록 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.13		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 13
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
@Service("dsuseService")
public class DsuseServiceImpl extends DefaultServiceImpl implements DsuseService {
	protected final static Logger logger = Logger.getLogger(DsuseServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 관리/폐기의 폐기 목록을 조회한다.
	 * 
	 * @param @DsuseVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveDsuseList(DsuseVo dsuseVo) throws Exception {
		return ecsCommonDao.selectList("TM_ME20001_Dao_retrieveDsuseList", dsuseVo);
	}

	/**
	 * 관리/폐기의 폐기 목록 상세보기를 저장(수정)한다.
	 * 
	 * @param @DsuseVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map saveDsuse(DsuseVo dsuseVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = ecsCommonDao.update("TM_ME20001_Dao_saveDsuse", dsuseVo);
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
	
	/**
	 * 관리/폐기의 폐기 목록을 삭제한다.
	 * 
	 * @param @DsuseVo
	 * @return Map : { rtnCnt : 결과 개수 }
	 * @throws Exception
	 */
	@Override
	public Map deleteDsuse(DsuseVo dsuseVo) throws Exception {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		int rtnCnt = ecsCommonDao.delete("TM_ME20001_Dao_deleteDsuse", dsuseVo);
		rtnMap.put("rtnCnt", rtnCnt);

		return rtnMap;
	}
}