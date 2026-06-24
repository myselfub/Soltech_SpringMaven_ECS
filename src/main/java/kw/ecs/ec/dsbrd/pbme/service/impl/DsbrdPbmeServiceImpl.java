package kw.ecs.ec.dsbrd.pbme.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.common.vo.ECSDefaultVo;
import kw.ecs.dao.EcsCommonDao;
import kw.ecs.ec.dsbrd.pbme.service.DsbrdPbmeService;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * DsbrdPbmeServiceImpl 서비스 클래스
 * 
 * @ClassName DsbrdPbmeServiceImpl.java
 * @Description 에너지전주기 - 계획/건설/관리/폐기 대시보드
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.05.03		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 05. 03
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
@Service("dsbrdPbmeService")
public class DsbrdPbmeServiceImpl extends DefaultServiceImpl implements DsbrdPbmeService {
	protected final static Logger logger = Logger.getLogger(DsbrdPbmeServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 계획/건설/관리/폐기 건수, 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비) PBME를 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePbmeSttusList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PBME_Dao_retrievePbmeSttusList", ecsDefaultVo);
	}

	/**
	 * 계획/건설/관리/폐기 건수, 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 발전원별
	 * 수립/진행/완료(수선유지/개대체/점검정비) 등을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePbmeSttusSetcscList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PBME_Dao_retrievePbmeSttusSetcscList", ecsDefaultVo);
	}

	/**
	 * 계획/건설/관리/폐기 건수, 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 유역별
	 * 수립/진행/완료(수선유지/개대체/점검정비) 등을 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePbmeSttusBasinList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PBME_Dao_retrievePbmeSttusBasinList", ecsDefaultVo);
	}

	/**
	 * 유역별 계획의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrievePSttusBasinList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PBME_Dao_retrievePSttusBasinList", ecsDefaultVo);
	}

	/**
	 * 유역별 건설의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveBSttusBasinList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PBME_Dao_retrieveBSttusBasinList", ecsDefaultVo);
	}

	/**
	 * 유역별 관리의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveMSttusBasinList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PBME_Dao_retrieveMSttusBasinList", ecsDefaultVo);
	}

	/**
	 * 유역별 폐기의 용량, 금액, 합계 수립/진행/완료(수선유지/개대체/점검정비), 수립/진행/완료(수선유지/개대체/점검정비) 등을
	 * 조회한다.
	 * 
	 * @param @ECSDefaultVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveESttusBasinList(ECSDefaultVo ecsDefaultVo) throws Exception {
		return ecsCommonDao.selectList("DSBRD_PBME_Dao_retrieveESttusBasinList", ecsDefaultVo);
	}
}