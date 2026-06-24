package kw.ecs.zz.login.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kw.ecs.dao.EcsCommonDao;
import kw.fw.defaults.DefaultConsts;
import kw.fw.log.LoginLogService;
import kw.fw.util.SessionUtil;
import kw.fw.util.WebUtil;
import kw.fw.vo.SessionVo;
import kw.scm.sc.cmmncd.service.CmmnCdService;
import kw.scm.sc.login.service.IntnLoginService;
import kw.scm.sc.login.service.impl.IntnLoginServiceImpl;
import kw.scm.sc.login.vo.IntnUsrInfoVo;

/**
 * EcsIntnLoginServiceImpl 서비스 클래스
 * 
 * @ClassName EcsIntnLoginServiceImpl.java
 * @Description 대내사용자 로그인 서비스 클래스
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
@Service("ecsIntnLoginService")
public class EcsIntnLoginServiceImpl extends IntnLoginServiceImpl implements IntnLoginService {

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	@Resource(name = "cmmnCdService")
	public CmmnCdService cmmnCdService;

	@Resource(name = "loginLogService")
	private LoginLogService loginLogService;

	protected final static Logger LOGGER = Logger.getLogger(EcsIntnLoginServiceImpl.class);

	public ModelAndView loginIntnUsr(IntnUsrInfoVo intnUsrInfoVo, HttpServletRequest request) throws Exception {
		IntnUsrInfoVo loginInfo = ecsCommonDao.select("TM_ECS_INTN_USR_INFO_Dao_loginIntnUsr", intnUsrInfoVo);

		SessionVo sessionVo = new SessionVo();

		if (loginInfo != null) {
			sessionVo.setUsrId(loginInfo.getUsrId());
			sessionVo.setUsrEmpno(loginInfo.getUsrEmpno());
			sessionVo.setUsrNm(loginInfo.getUsrNm());
			sessionVo.setSysDivCd(loginInfo.getSysDivCd());
			sessionVo.setBiznDivCd(loginInfo.getBiznDivCd());
			sessionVo.setAthrId(loginInfo.getAthrId());
			sessionVo.setUsrDeptCd(loginInfo.getUsrDeptCd());
			sessionVo.setUsrDeptNm(loginInfo.getUsrDeptNm());
			sessionVo.setUsrOfcpsCd(loginInfo.getUsrOfcpsCd());
			sessionVo.setUsrOfcpsNm(loginInfo.getUsrOfcpsNm());
			sessionVo.setUsrJgrdCd(loginInfo.getUsrJgrdCd());
			sessionVo.setUsrJgrdNm(loginInfo.getUsrJgrdNm());

			sessionVo.setUsrHqCd(loginInfo.getUsrHqCd());
			sessionVo.setUsrHqNm(loginInfo.getUsrHqNm());
			sessionVo.setUsrSectCd(loginInfo.getUsrSectCd());
			sessionVo.setUsrSectNm(loginInfo.getUsrSectNm());
			sessionVo.setUsrTeamCd(loginInfo.getUsrTeamCd());
			sessionVo.setUsrTeamNm(loginInfo.getUsrTeamNm());
			sessionVo.setUsrJbgpCd(loginInfo.getUsrJbgpCd());
			sessionVo.setUsrJbgpNm(loginInfo.getUsrJbgpNm());
			sessionVo.setUsrJblnCd(loginInfo.getUsrJblnCd());
			sessionVo.setUsrJblnNm(loginInfo.getUsrJblnNm());
			sessionVo.setUsrDtyCd(loginInfo.getUsrDtyCd());
			sessionVo.setUsrDtyNm(loginInfo.getUsrDtyNm());
			sessionVo.setCstctCd(loginInfo.getCstctCd());

			sessionVo.setConectIp(WebUtil.getClientIp());

			/* 테스트용
			 * sessionVo.setSysDivCd("ECS");
			 * sessionVo.setAthrId("ECSGN01");
			 */
		}

		return doLogin(request, sessionVo);
		// return doLoginTemp(request, sessionVo);
	}

	@SuppressWarnings("unused")
	@Override
	public ModelAndView logOutIntnUsr(IntnUsrInfoVo dmstUsrInfoVo, HttpServletRequest request) throws Exception {
		SessionVo sessionVo = SessionUtil.getLoginSession(request);

		return addResponseData(DefaultConsts.STATUS_SUCESS, "로그아웃 했습니다. ");
	}
}