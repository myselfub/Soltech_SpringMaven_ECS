package kw.ecs.zz.menumng.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kw.ecs.dao.EcsCommonDao;
import kw.ecs.zz.authmng.vo.PersonAuthorityVo;
import kw.ecs.zz.menumng.service.EcsMenuMngService;
import kw.fw.defaults.DefaultConsts;
import kw.fw.defaults.DefaultServiceImpl;
import kw.fw.util.RequestContextUtil;

/**
 * EcsMenuMngServiceImpl 서비스 클래스
 * 
 * @ClassName EcsMenuMngServiceImpl.java
 * @Description 메뉴 서비스 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.07.20		60002841(권영훈)			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 권영훈
 * @since 2017. 07. 20.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@Service("ecsMenuMngService")
public class EcsMenuMngServiceImpl extends DefaultServiceImpl implements EcsMenuMngService {
	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 사용자 메뉴 데이터를 조회한다.
	 * 
	 * @param param
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map> retrieveUsrMenu(Map param) {
		PersonAuthorityVo personAutorityVo = new PersonAuthorityVo();
		personAutorityVo.setUsrId((String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID));
		personAutorityVo.setMenuSysDivCd((String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_SYS_DIV_CD));
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_MENU_Dao_retrieveUsrMenu", personAutorityVo);
	}

	/**
	 * 대네메뉴접속로그 저장한다.
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public void insertCtznMenuConectLogTx(Map<String, Object> param) {
		ecsCommonDao.insert("TH_ECS_CTZN_MENU_CONECT_Dao_insertMenuLogInfo", param);
	}

	/**
	 * 메뉴접속로그 저장한다.
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public void insertMenuConectLogTx(Map<String, Object> param) {
		ecsCommonDao.insert("TH_ECS_INTN_MENU_CONECT_Dao_insertMenuLogInfo", param);
	}
}