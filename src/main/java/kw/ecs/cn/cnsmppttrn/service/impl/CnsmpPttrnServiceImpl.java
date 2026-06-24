package kw.ecs.cn.cnsmppttrn.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kw.ecs.cn.cnsmppttrn.service.CnsmpPttrnService;
import kw.ecs.cn.cnsmppttrn.vo.CnsmpPttrnVo;
import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * CnsmpPttrn ServiceImpl 서비스 클래스
 * 
 * @ClassName CnsmpPttrn ServiceImpl.java
 * @Description 소비 - 사업장 소비패턴 분석현황 클래스
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
@Service("cnsmpPttrnService")
public class CnsmpPttrnServiceImpl extends DefaultServiceImpl implements CnsmpPttrnService {
	protected final static Logger logger = Logger.getLogger(CnsmpPttrnServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 소비의 사업장 소비패턴 분석현황 목록을 조회한다.
	 * 
	 * @param @CnsmpPttrnVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@Override
	public List<Map> retrieveCnsmpPttrnList(CnsmpPttrnVo cnsmpPttrnVo) throws Exception {
		return ecsCommonDao.selectList("CNSMP_PTTRN_Dao_retrieveCnsmpPttrnList", cnsmpPttrnVo);
	}
}