package kw.ecs.zz.authmng.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import kw.ecs.dao.EcsCommonDao;
import kw.ecs.zz.authmng.service.EcsAuthorityService;
import kw.ecs.zz.authmng.vo.AthrGrpMngVo;
import kw.ecs.zz.authmng.vo.AuthorityMenuVo;
import kw.ecs.zz.authmng.vo.AuthorityVo;
import kw.ecs.zz.authmng.vo.BtnAthrVo;
import kw.ecs.zz.authmng.vo.IntnAthrMenuVo;
import kw.ecs.zz.authmng.vo.IntnUsrMenuVo;
import kw.ecs.zz.authmng.vo.MenuMngVo;
import kw.ecs.zz.authmng.vo.PersonAuthorityVo;
import kw.ecs.zz.authmng.vo.ScrinBtnVo;
import kw.ecs.zz.authmng.vo.ScrinMngVo;
import kw.ecs.zz.authmng.vo.UsrAthrGrpMngVo;
import kw.ecs.zz.authmng.vo.UsrAthrRqstVo;
import kw.ecs.zz.authmng.vo.UsrSysAthrVo;
import kw.fw.adaptor.WqConstant;
import kw.fw.defaults.DefaultConsts;
import kw.fw.defaults.DefaultServiceImpl;
import kw.fw.mail.service.DaonMailService;
import kw.fw.mail.vo.DaonMailVo;
import kw.fw.util.DateUtil;
import kw.fw.util.KwUserDetailHelper;
import kw.fw.util.ParameterMapper;
import kw.fw.util.RequestContextUtil;
import kw.fw.util.StringUtil;
import kw.fw.vo.SessionVo;
import kw.scm.sc.cmmncd.vo.HrmVmHr01601Vo;
import kw.scm.sc.cmmncd.vo.UsrListVo;
import kw.scm.sc.file.service.ComnAttchFileMtService;
import kw.scm.sc.idvinfo.service.IdvinfoDealAthrService;
import kw.scm.sc.idvinfo.vo.IdvinfoDealAthrVo;
import kw.scm.sc.sanctn.jobsanctn.service.JobSanctnService;
import kw.scm.util.SapClient;

/**
 * EcsAuthorityServiceImpl 서비스 임플리먼트 클래스
 * 
 * @ClassName EcsAuthorityServiceImpl.java
 * @Description 권한 서비스 임플리먼트 클래스
 * @Modification Information 수정일 수정자 수정내용 ---------- ----------
 *               ------------------------------- 2017. 3. 1. Soft Arch 최초생성
 *               2017. 6. 14. yc.j 대내권한관리 생성
 * 
 * @author K-water 업무시스템 혁신사업 : Soft Arch 아무개
 * @since 2017. 3. 1.
 * @version 1.0
 * @see
 * 
 * 		Copyright (C) 2017 by Unlimited K-water, All right reserved.
 */
@Service("ecsAuthorityService")
public class EcsAuthorityServiceImpl extends DefaultServiceImpl implements EcsAuthorityService {
	protected final static Logger logger = Logger.getLogger(EcsAuthorityServiceImpl.class);

	/** EcsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;
	/** idvinfoDealAthrService */
	@Resource(name = "idvinfoDealAthrService")
	public IdvinfoDealAthrService idvinfoDealAthrService;
	/** daonMailService 적용 */
	@Resource(name = "daonMailService")
	private DaonMailService daonMailService;
	/** 업무결재서비스 */
	@Resource(name = "jobSanctnService")
	public JobSanctnService jobSanctnService;

	@Resource(name = "messageSource")
	private MessageSource messageSource;
	/** ComnAttchFileMtService */
	@Resource(name = "comnAttchFileMtService")
	private ComnAttchFileMtService comnAttchFileMtService;

	/**
	 * 권한 데이터를 조회한다.
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> getAuthorityList(Map param) {
		ParameterMapper pm = new ParameterMapper();
		AuthorityVo authorityVo = (AuthorityVo) pm.getMapData(param, "param", new AuthorityVo());
		return ecsCommonDao.selectList("AuthorityDao_getAuthorityList", authorityVo);
	}

	/**
	 * 여러 건의 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 *            Client 전달한 데이터 맵 객체
	 */
	public void saveAuthorityList(List<AuthorityVo> authorityList) {
		AuthorityVo vo = new AuthorityVo();
		for (int idx = 0; idx < authorityList.size(); idx++) {
			vo = authorityList.get(idx);
			if (vo != null) {
				saveAuthority(vo);
			}
		}
	}

	/**
	 * 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param sqlSession
	 * @param data
	 *            데이터 맵 객체
	 */
	public void saveAuthority(AuthorityVo authorityVo) {
		switch (authorityVo.getRowStatus()) {
		case WqConstant.ROW_TYPE_INSERTED:
			// 추가를 수행합니다.
			ecsCommonDao.insert("AuthorityDao_insertAuthority", authorityVo);
			break;
		case WqConstant.ROW_TYPE_UPDATED:
			// 수정을 수행합니다.
			ecsCommonDao.update("AuthorityDao_updateAuthority", authorityVo);
			break;
		case WqConstant.ROW_TYPE_DELETED:
		case WqConstant.ROW_TYPE_REMOVE:
			// 삭제를 수행합니다.
			ecsCommonDao.delete("AuthorityDao_deleteAuthority", authorityVo);
			break;
		default:
			break;
		}
	}

	/**
	 * 메뉴별 권한 데이터를 조회한다.
	 * 
	 * @param param
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> getAuthorityMenuList(Map param) {
		ParameterMapper pm = new ParameterMapper();
		AuthorityMenuVo authorityMenuVo = (AuthorityMenuVo) pm.getMapData(param, "param", new AuthorityMenuVo());
		return (List) ecsCommonDao.selectList("AuthorityDao_getAuthorityMenuList", authorityMenuVo);
	}

	/**
	 * 여러 건의 메뉴 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 *            Client 전달한 데이터 맵 객체
	 */
	public void saveAuthorityMenuList(List<AuthorityMenuVo> authorityMenuList) {
		AuthorityMenuVo vo = new AuthorityMenuVo();
		for (int idx = 0; idx < authorityMenuList.size(); idx++) {
			vo = authorityMenuList.get(idx);
			if (vo != null) {
				saveAuthorityMenu(vo);
			}
		}
	}

	/**
	 * 메뉴 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param sqlSession
	 * @param data
	 *            데이터 맵 객체
	 */
	public void saveAuthorityMenu(AuthorityMenuVo authorityMenuVo) {
		switch (authorityMenuVo.getRowStatus()) {
		case WqConstant.ROW_TYPE_INSERTED:
			// 추가를 수행합니다.
			ecsCommonDao.insert("AuthorityDao_insertAuthorityMenu", authorityMenuVo);
			break;
		case WqConstant.ROW_TYPE_DELETED:
		case WqConstant.ROW_TYPE_REMOVE:
			// 삭제를 수행합니다.
			ecsCommonDao.delete("AuthorityDao_deleteAuthorityMenu", authorityMenuVo);
			break;
		default:
			break;
		}
	}

	/**
	 * 권한별 사원 데이터를 조회한다.
	 * 
	 * @param param
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> getPersonAuthorityList(Map param) {
		ParameterMapper pm = new ParameterMapper();
		PersonAuthorityVo personAuthorityVo = (PersonAuthorityVo) pm.getMapData(param, "param",
				new PersonAuthorityVo());
		return (List) ecsCommonDao.selectList("AuthorityDao_getPersonAuthorityList", personAuthorityVo);
	}

	/**
	 * 여러 건의 권한별 사원 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 *            Client 전달한 데이터 맵 객체
	 */
	public void savePersonAuthorityList(List<PersonAuthorityVo> personAuthorityList) {
		PersonAuthorityVo vo = new PersonAuthorityVo();
		for (int idx = 0; idx < personAuthorityList.size(); idx++) {
			vo = personAuthorityList.get(idx);
			if (vo != null) {
				savePersonAuthority(vo);
			}
		}
	}

	/**
	 * 권한별 사원 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param sqlSession
	 * @param data
	 *            데이터 맵 객체
	 */
	public void savePersonAuthority(PersonAuthorityVo personAuthorityVo) {
		switch (personAuthorityVo.getRowStatus()) {
		case WqConstant.ROW_TYPE_INSERTED:
			// 추가를 수행합니다.
			ecsCommonDao.insert("AuthorityDao_insertPersonAuthority", personAuthorityVo);
			break;
		case WqConstant.ROW_TYPE_DELETED:
		case WqConstant.ROW_TYPE_REMOVE:
			// 삭제를 수행합니다.
			ecsCommonDao.delete("AuthorityDao_deletePersonAuthority", personAuthorityVo);
			break;
		default:
			break;
		}
	}

	/**
	 * 권한 조회한다.
	 * 
	 * @param athrGrpMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveAthr(AthrGrpMngVo athrGrpMngVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_ATHR_Dao_retrieveAthr", athrGrpMngVo);
	}

	/**
	 * 권한 조회한다.
	 * 
	 * @param athrGrpMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveAthrEcs(AthrGrpMngVo athrGrpMngVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_ATHR_Dao_retrieveAthrEcs", athrGrpMngVo);
	}

	/**
	 * 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param athrGrpMngVo
	 * @return
	 * @throws Exception
	 */
	public void saveAthrMng(List<AthrGrpMngVo> athrGrpMngVo) {
		AthrGrpMngVo vo = new AthrGrpMngVo();
		for (int idx = 0; idx < athrGrpMngVo.size(); idx++) {
			vo = athrGrpMngVo.get(idx);

			if (vo != null) {
				switch (vo.getRowStatus()) {
				case WqConstant.ROW_TYPE_INSERTED:
					// 추가를 수행합니다.
					ecsCommonDao.insert("TM_ECS_INTN_ATHR_Dao_insertAthrMng", vo);
					break;
				case WqConstant.ROW_TYPE_UPDATED:
					// 수정을 수행합니다.
					ecsCommonDao.update("TM_ECS_INTN_ATHR_Dao_updateAthrMng", vo);
					break;
				case WqConstant.ROW_TYPE_DELETED:
				case WqConstant.ROW_TYPE_REMOVE:
					// 삭제를 수행합니다.
					ecsCommonDao.delete("TM_ECS_INTN_ATHR_Dao_deleteAthrMng", vo);
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see kw.ecs.zz.authmng.service.EcsAuthorityService#saveAthrMngList(java.util.List,
	 *      java.util.List, java.util.List)
	 */
	public void saveAthrMngList(List<AthrGrpMngVo> athrGrpMngVo, List<IntnAthrMenuVo> intnAthrMenuVo,
			List<UsrAthrGrpMngVo> usrAthrGrpMngList) {
		if (!athrGrpMngVo.isEmpty()) {
			saveAthrMng(athrGrpMngVo);
		}
		if (!intnAthrMenuVo.isEmpty()) {
			saveIntnAthrMenu(intnAthrMenuVo);
		}
		if (!usrAthrGrpMngList.isEmpty()) {
			saveUsrAthrGrpMngList(usrAthrGrpMngList);
		}
	}

	/**
	 * 권한등록 정보조회를 수행합니다.
	 * 
	 * @param athrGrpMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Map selectAthrUse(AthrGrpMngVo athrGrpMngVo) {
		return ecsCommonDao.select("TM_ECS_INTN_ATHR_Dao_selectAthrUse", athrGrpMngVo);
	}

	/**
	 * 화면 조회한다.
	 * 
	 * @param scrinMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveScrin(ScrinMngVo scrinMngVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_SCRIN_Dao_retrieveScrin", scrinMngVo);
	}

	/**
	 * 도움말 정보를 조회합니다.
	 * 
	 * @param scrinMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveHpcm(ScrinMngVo scrinMngVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_SCRIN_Dao_retrieveHpcm", scrinMngVo);
	}

	/**
	 * 화면등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param scrinMngVo
	 * @return
	 * @throws Exception
	 */
	public void saveScrinMng(ScrinMngVo scrinMngVo) {
		switch (scrinMngVo.getRowStatus()) {
		case WqConstant.ROW_TYPE_INSERTED:
			// 추가를 수행합니다.
			ecsCommonDao.insert("TM_ECS_INTN_SCRIN_Dao_insertScrinMng", scrinMngVo);
			break;
		case WqConstant.ROW_TYPE_UPDATED:
			// 수정을 수행합니다.
			ecsCommonDao.update("TM_ECS_INTN_SCRIN_Dao_updateScrinMng", scrinMngVo);
			break;
		case WqConstant.ROW_TYPE_DELETED:
		case WqConstant.ROW_TYPE_REMOVE:
			// 삭제를 수행합니다.
			ecsCommonDao.delete("TM_ECS_INTN_SCRIN_Dao_deleteScrinMng", scrinMngVo);
			break;
		default:
			break;
		}
	}

	/**
	 * 화면 메뉴설정 정보조회를 수행합니다.
	 * 
	 * @param scrinMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> selectScrinInfo(ScrinMngVo scrinMngVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_SCRIN_Dao_selectScrinInfo", scrinMngVo);
	}

	/**
	 * 메뉴 조회한다.
	 * 
	 * @param menuMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveMenu(MenuMngVo menuMngVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_MENU_Dao_retrieveMenu", menuMngVo);
	}

	/**
	 * 메뉴등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param menuMngVo
	 * @return
	 * @throws Exception
	 */
	public void saveMenuMng(MenuMngVo menuMngVo) {
		switch (menuMngVo.getRowStatus()) {
		case WqConstant.ROW_TYPE_INSERTED:
			// 추가를 수행합니다.
			ecsCommonDao.insert("TM_ECS_INTN_MENU_Dao_insertMenuMng", menuMngVo);
			break;
		case WqConstant.ROW_TYPE_UPDATED:
			// 수정을 수행합니다.
			ecsCommonDao.update("TM_ECS_INTN_MENU_Dao_updateMenuMng", menuMngVo);
			break;
		case WqConstant.ROW_TYPE_DELETED:
		case WqConstant.ROW_TYPE_REMOVE:
			// 삭제를 수행합니다.
			ecsCommonDao.delete("TM_ECS_INTN_MENU_Dao_deleteMenuMng", menuMngVo);
			break;
		default:
			break;
		}
	}

	/**
	 * 메뉴설정 정보조회를 수행합니다.
	 * 
	 * @param menuMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Map selectMenuUse(MenuMngVo menuMngVo) {
		return ecsCommonDao.select("TM_ECS_INTN_MENU_Dao_selectMenuUse", menuMngVo);
	}

	/**
	 * 권한한별메뉴관리에서 권한그룹 조회를 수행합니다.
	 * 
	 * @param athrGrpMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveAthrGrp(AthrGrpMngVo athrGrpMngVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_ATHR_Dao_retrieveAthrGrp", athrGrpMngVo);
	}

	/**
	 * 사용자별권한관리에서 사용자 권한부여현황 조회를 수행합니다.
	 * 
	 * @param usrAthrGrpMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retriebeUsrAthrGrp(UsrAthrGrpMngVo usrAthrGrpMngVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_USR_ATHR_Dao_retriebeUsrAthrGrp", usrAthrGrpMngVo);
	}

	/**
	 * 사용자별 권한그룹 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param usrAthrGrpMngList
	 * @return
	 * @throws Exception
	 */
	public void saveUsrAthrGrpMngList(List<UsrAthrGrpMngVo> usrAthrGrpMngList) {
		EgovMap athrMap = ecsCommonDao.selectOne("TM_ECS_INTN_ATHR_Dao_selectAthr",
				usrAthrGrpMngList.get(0).getAthrId());

		UsrAthrGrpMngVo vo = new UsrAthrGrpMngVo();
		for (int idx = 0; idx < usrAthrGrpMngList.size(); idx++) {
			vo = usrAthrGrpMngList.get(idx);
			if (vo != null) {
				vo.setAthrNm((String) athrMap.get("athrNm"));
				saveUsrAthrGrp(vo, (String) athrMap.get("idvinfoDealYn"));
			}
		}
	}

	/**
	 * 권한신청에의한 사용자별 권한그룹 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param usrAthrGrpMngVo
	 * @return
	 * @throws Exception
	 */
	public void saveUsrAthrGrpMng(UsrAthrGrpMngVo vo) {
		EgovMap athrMap = ecsCommonDao.selectOne("TM_ECS_INTN_ATHR_Dao_selectAthr", vo.getAthrId());
		vo.setAthrNm((String) athrMap.get("athrNm"));
		saveUsrAthrGrp(vo, (String) athrMap.get("idvinfoDealYn"));
	}

	/**
	 * 사용자별 권한그룹 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param usrAthrGrpMngVo
	 * @return
	 * @throws Exception
	 */
	public void saveUsrAthrGrp(UsrAthrGrpMngVo usrAthrGrpMngVo, String idvinfoDealYn) {
		if (usrAthrGrpMngVo != null) {
			switch (usrAthrGrpMngVo.getRowStatus()) {
			case WqConstant.ROW_TYPE_INSERTED:
				// 추가를 수행합니다. (기존 데이터가 있으면 날짜만 업데이트한다.)
				ecsCommonDao.insert("TM_ECS_INTN_USR_ATHR_Dao_mergeUsrAhtrGrpMng", usrAthrGrpMngVo);

				if (idvinfoDealYn != null && StringUtils.equals(idvinfoDealYn, "Y")) {
					IdvinfoDealAthrVo idvinfoDealAthrVo = new IdvinfoDealAthrVo();
					idvinfoDealAthrVo.setUsrId(usrAthrGrpMngVo.getUsrId());
					idvinfoDealAthrVo.setSysDivCd(KwUserDetailHelper.getAuthenticatedUser().getSysDivCd());
					idvinfoDealAthrVo.setApplcStrtDe(usrAthrGrpMngVo.getApplcStrtDe());
					idvinfoDealAthrVo.setApplcEndDe(usrAthrGrpMngVo.getApplcEndDe());
					idvinfoDealAthrVo.setAthrId(usrAthrGrpMngVo.getAthrId());
					idvinfoDealAthrVo.setAthrNm(usrAthrGrpMngVo.getAthrNm());
					idvinfoDealAthrVo.setApprvrId(usrAthrGrpMngVo.getFrstRgstrId());
					idvinfoDealAthrVo.setFrstRgstrId(usrAthrGrpMngVo.getFrstRgstrId());
					idvinfoDealAthrVo.setLastUpdusrId(usrAthrGrpMngVo.getLastUpdusrId());
					// 기존 데이터가 있는지 조회
					if (idvinfoDealAthrService.selectIdvinfoDealAthr(idvinfoDealAthrVo) == null) {
						// 새로 등록한다.
						idvinfoDealAthrService.registIdvinfoDealAthr(idvinfoDealAthrVo);
					} else {
						// 기존 데이터를 수정한다.
						idvinfoDealAthrService.updtIdvinfoDealAthr(idvinfoDealAthrVo);
					}
				}
				break;
			case WqConstant.ROW_TYPE_UPDATED:
				// 수정을 수행합니다.
				ecsCommonDao.update("TM_ECS_INTN_USR_ATHR_Dao_updateUsrAhtrGrpMng", usrAthrGrpMngVo);

				if (StringUtils.equals(idvinfoDealYn, "Y")) {
					IdvinfoDealAthrVo idvinfoDealAthrVo = new IdvinfoDealAthrVo();
					idvinfoDealAthrVo.setUsrId(usrAthrGrpMngVo.getUsrId());
					idvinfoDealAthrVo.setSysDivCd(KwUserDetailHelper.getAuthenticatedUser().getSysDivCd());
					idvinfoDealAthrVo.setApplcStrtDe(usrAthrGrpMngVo.getApplcStrtDe());
					idvinfoDealAthrVo.setApplcEndDe(usrAthrGrpMngVo.getApplcEndDe());
					idvinfoDealAthrService.updtIdvinfoDealAthr(idvinfoDealAthrVo);
				}
				break;
			case WqConstant.ROW_TYPE_DELETED:
			case WqConstant.ROW_TYPE_REMOVE:
				// 삭제를 수행합니다.
				ecsCommonDao.delete("TM_ECS_INTN_USR_ATHR_Dao_deleteUsrAhtrGrpMng", usrAthrGrpMngVo);

				if (StringUtils.equals(idvinfoDealYn, "Y")) {
					IdvinfoDealAthrVo idvinfoDealAthrVo = new IdvinfoDealAthrVo();
					idvinfoDealAthrVo.setUsrId(usrAthrGrpMngVo.getUsrId());
					idvinfoDealAthrVo.setSysDivCd(KwUserDetailHelper.getAuthenticatedUser().getSysDivCd());
					idvinfoDealAthrVo.setApplcStrtDe(usrAthrGrpMngVo.getApplcStrtDe());
					idvinfoDealAthrVo.setUseYn("N");
					idvinfoDealAthrService.updtIdvinfoDealAthr(idvinfoDealAthrVo);
				}
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 여러 건의 메뉴 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param menuMngList
	 * @return
	 * @throws Exception
	 */
	public void saveMenuMngList(List<MenuMngVo> menuMngList) {
		MenuMngVo vo = new MenuMngVo();
		for (int idx = 0; idx < menuMngList.size(); idx++) {
			vo = menuMngList.get(idx);
			if (vo != null) {
				saveMenuMng2(vo);
			}
		}
	}

	/**
	 * 메뉴등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param menuMngVo
	 * @return
	 * @throws Exception
	 */
	public void saveMenuMng2(MenuMngVo menuMngVo) {
		switch (menuMngVo.getRowStatus()) {
		case WqConstant.ROW_TYPE_INSERTED:
			// 추가를 수행합니다.
			ecsCommonDao.insert("TM_ECS_INTN_MENU_Dao_insertMenuMng", menuMngVo);
			break;
		case WqConstant.ROW_TYPE_UPDATED:
			// 수정을 수행합니다.
			ecsCommonDao.update("TM_ECS_INTN_MENU_Dao_updateMenuMng", menuMngVo);
			break;
		case WqConstant.ROW_TYPE_DELETED:
		case WqConstant.ROW_TYPE_REMOVE:
			// 삭제를 수행합니다.
			ecsCommonDao.delete("TM_ECS_INTN_MENU_Dao_deleteMenuMng", menuMngVo);
			break;
		default:
			break;
		}
	}

	/**
	 * 화면별버튼권한
	 * 
	 * @param menuMngList
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Map selectPgmAuth(Map param) {
		IntnUsrMenuVo intnUsrMenuVo = new IntnUsrMenuVo();
		intnUsrMenuVo.setUsrId((String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID));
		intnUsrMenuVo.setAthrId((String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_ATHR_ID));
		intnUsrMenuVo.setIntnSysDivCd((String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_SYS_DIV_CD));
		intnUsrMenuVo.setScrinId((String) param.get("pgmId"));

		List<EgovMap> btnAthrList = ecsCommonDao.selectList("TM_ECS_INTN_USR_ATHR_Dao_retrieveMenuBtnAthr",
				intnUsrMenuVo);
		Map<String, String> btnAthrMap = new HashMap<>();
		String vu = ",";

		for (EgovMap map : btnAthrList) {
			vu += (String) map.get("btnAthrList") + ",";
		}
		btnAthrMap.put("btnAthrList", vu);

		return btnAthrMap;
	}

	/**
	 * 자신에게 부여된 권한관련 시스템구분코드를 조회한다.
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveAthrSysDivCd(Map para) {
		return ecsCommonDao.selectList("TM_ECS_INTN_ATHR_Dao_retrieveAthrSysDivCd", para);
	}

	/**
	 * 권한그룹별메뉴목록을 조회한다.
	 * 
	 * @param intnAthrMenuVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveIntnAthrMenu(IntnAthrMenuVo intnAthrMenuVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_MENU_Dao_retrieveIntnAthrMenu", intnAthrMenuVo);
	}

	/**
	 * 메뉴등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param intnAthrMenuVo
	 * @return
	 * @throws Exception
	 */
	public void saveIntnAthrMenu(List<IntnAthrMenuVo> intnAthrMenuVo) {
		IntnAthrMenuVo vo = new IntnAthrMenuVo();
		for (int idx = 0; idx < intnAthrMenuVo.size(); idx++) {
			vo = intnAthrMenuVo.get(idx);

			if (vo != null) {
				switch (vo.getRowStatus()) {
				case WqConstant.ROW_TYPE_INSERTED:
					// 있으면 삭제를 수행합니다.
					ecsCommonDao.delete("TM_ECS_INTN_MENU_Dao_deleteAthrMenu", vo);
					// 추가를 수행합니다.
					ecsCommonDao.insert("TM_ECS_INTN_MENU_Dao_insertAthrMenu", vo);
					break;
				case WqConstant.ROW_TYPE_UPDATED:
					// 수정을 수행합니다.
					ecsCommonDao.update("TM_ECS_INTN_MENU_Dao_updateAthrMenu", vo);
					break;
				case WqConstant.ROW_TYPE_DELETED:
				case WqConstant.ROW_TYPE_REMOVE:
					// 삭제를 수행합니다.
					ecsCommonDao.delete("TM_ECS_INTN_MENU_Dao_deleteAthrMenu", vo);
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * 사용자별 메뉴접속권한 목록을 조회한다. 게시물 통합검색에서 사용자가 게시물 메뉴의 접근 권한 여부를 조회할 때 사용한다.
	 * 
	 * @param intnAthrMenuVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveUsrMenuAthr(IntnAthrMenuVo intnAthrMenuVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_MENU_Dao_retrieveUsrMenuAthr", intnAthrMenuVo);
	}

	/**
	 * 사용자별메뉴관리에서 사용자정보 조회를 수행합니다.
	 * 
	 * @param usrListVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveUsr(UsrListVo usrListVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_USR_INFO_Dao_retrieveUsr", usrListVo);
	}

	/**
	 * 사용자별메뉴목록을 조회한다.
	 * 
	 * @param intnAthrMenuVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveIntnUsrMenu(IntnUsrMenuVo intnUsrMenuVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_USR_MENU_Dao_retrieveIntnUsrMenu", intnUsrMenuVo);
	}

	/**
	 * 사용자별메뉴등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param intnAthrMenuVo
	 * @return
	 * @throws Exception
	 */
	public void saveIntnUsrMenu(List<IntnUsrMenuVo> intnUsrMenuVo) {
		IntnUsrMenuVo vo = new IntnUsrMenuVo();
		for (int idx = 0; idx < intnUsrMenuVo.size(); idx++) {
			vo = intnUsrMenuVo.get(idx);

			if (vo != null) {
				switch (vo.getRowStatus()) {
				case WqConstant.ROW_TYPE_INSERTED:
					// 있으면 삭제를 수행합니다.
					ecsCommonDao.delete("TM_ECS_INTN_USR_MENU_Dao_deleteUsrMenu", vo);
					// 추가를 수행합니다.
					ecsCommonDao.insert("TM_ECS_INTN_USR_MENU_Dao_insertUsrMenu", vo);
					break;
				case WqConstant.ROW_TYPE_UPDATED:
					// 수정을 수행합니다.
					ecsCommonDao.update("TM_ECS_INTN_USR_MENU_Dao_updateUsrMenu", vo);
					break;
				case WqConstant.ROW_TYPE_DELETED:
				case WqConstant.ROW_TYPE_REMOVE:
					// 삭제를 수행합니다.
					ecsCommonDao.delete("TM_ECS_INTN_USR_MENU_Dao_deleteUsrMenu", vo);
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * 사용자별시스템구분목록을 조회한다. .
	 * 
	 * @param usrSysAthrVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveUsrSysAthr(UsrSysAthrVo usrSysAthrVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_USR_SYS_ATHR_retrieveUsrSysAthr", usrSysAthrVo);
	}

	/**
	 * 사용자별시스템구분목록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param intnAthrMenuVo
	 * @return
	 * @throws Exception
	 */
	public void saveUsrSysAthr(List<UsrSysAthrVo> usrSysAthrVo) {
		UsrSysAthrVo vo = new UsrSysAthrVo();
		for (int idx = 0; idx < usrSysAthrVo.size(); idx++) {
			vo = usrSysAthrVo.get(idx);

			if (vo != null) {
				switch (vo.getRowStatus()) {
				case WqConstant.ROW_TYPE_INSERTED:
					// 추가를 수행합니다.
					ecsCommonDao.insert("TM_ECS_INTN_USR_SYS_ATHR_insertUsrSysAthr", vo);
					break;
				case WqConstant.ROW_TYPE_UPDATED:
					// 수정을 수행합니다.
					ecsCommonDao.update("TM_ECS_INTN_USR_SYS_ATHR_updateUsrSysAthr", vo);
					break;
				case WqConstant.ROW_TYPE_DELETED:
				case WqConstant.ROW_TYPE_REMOVE:
					// 삭제를 수행합니다.
					ecsCommonDao.delete("TM_ECS_INTN_USR_SYS_ATHR_deleteUsrSysAthr", vo);
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * 사용자별권한그룹조회를 한다.
	 * 
	 * @param usrSysAthrVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveUsrAthrRqst(UsrAthrRqstVo usrAthrRqstVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_USR_ATHR_RQST_Dao_retrieveUsrAthrRqst", usrAthrRqstVo);
	}

	/**
	 * 사용자별권한그룹조회를 한다.(관리자)
	 * 
	 * @param usrSysAthrVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveUsrAthrRqstAdmin(UsrAthrRqstVo usrAthrRqstVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_USR_ATHR_RQST_Dao_retrieveUsrAthrRqstAdmin", usrAthrRqstVo);
	}

	/**
	 * 사용자권한신청 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param intnAthrMenuVo
	 * @return
	 * @throws Exception
	 */
	public void saveUsrAthrRqst(List<UsrAthrRqstVo> usrAthrRqstVo) {
		UsrAthrRqstVo vo = new UsrAthrRqstVo();
		for (int idx = 0; idx < usrAthrRqstVo.size(); idx++) {
			vo = usrAthrRqstVo.get(idx);

			if (vo != null) {
				// 권한 등록을 위한 Vo 생성
				UsrAthrGrpMngVo athrVo = new UsrAthrGrpMngVo();
				athrVo.setUsrId(vo.getUsrId());
				athrVo.setAthrId(vo.getAthrId());
				athrVo.setApplcStrtDe(vo.getApplcStrtDe());
				athrVo.setApplcEndDe(vo.getApplcEndDe());

				switch (vo.getRowStatus()) {
				case WqConstant.ROW_TYPE_INSERTED:
					// 추가를 수행합니다.
					ecsCommonDao.insert("TM_ECS_INTN_USR_ATHR_RQST_Dao_insertUsrAthrRqst", vo);
					// if ( !vo.getApprvrId().isEmpty() ) {
					if (vo.getApprvrId() != null) {
						athrVo.setRowStatus(WqConstant.ROW_TYPE_INSERTED);
						saveUsrAthrGrpMng(athrVo);
					}
					break;
				case WqConstant.ROW_TYPE_UPDATED:
					// 수정을 수행합니다.
					ecsCommonDao.update("TM_ECS_INTN_USR_ATHR_RQST_Dao_updateUsrAthrRqst", vo);
					if ((vo.getApprvrId() != null) && "RO".equals(vo.getPrgstsCd())) {
						athrVo.setRowStatus(WqConstant.ROW_TYPE_INSERTED);
						saveUsrAthrGrpMng(athrVo);
					} else if ((vo.getApprvrId() != null) && "RA".equals(vo.getPrgstsCd())) {
						athrVo.setRowStatus(WqConstant.ROW_TYPE_DELETED);
						saveUsrAthrGrpMng(athrVo);
					}
					break;
				case WqConstant.ROW_TYPE_DELETED:
				case WqConstant.ROW_TYPE_REMOVE:
					// 삭제를 수행합니다.
					ecsCommonDao.delete("TM_ECS_INTN_USR_ATHR_RQST_Dao_deleteUsrAthrRqst", vo);
					if (vo.getApprvrId() != null) {
						athrVo.setRowStatus(WqConstant.ROW_TYPE_DELETED);
						saveUsrAthrGrpMng(athrVo);
					}
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * 통합권한신청 데이터를 등록한다.
	 * 
	 * @param usrAthrRqstVo
	 * @return
	 * @throws Exception
	 */
	public void insertUsrAthrRqst(UsrAthrRqstVo usrAthrRqstVo) {
		// 추가를 수행합니다. (사용자정보가 없으므로 FrstOperId 셋팅을 회피한다.)
		ecsCommonDao.getSqlSession().insert("TM_ECS_INTN_USR_ATHR_RQST_Dao_insertUsrAthrRqst", usrAthrRqstVo);
	}

	/**
	 * 통합권한신청 상태를 업데이트한다.
	 * 
	 * @param athrRqstList
	 *            통합권한신청상세 객체
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void transferUnifAthrRqst(Map unifAthrRqstDtlList) throws Exception {
		String scmUrl = "scm";

		// TODO : 운영에서 변경
		// 개발, 운영에 따라 도메인이 다름.
		/*
		 * String runMode = propertiesService.getString("run.mode"); if
		 * (!StringUtils.equals(runMode, "server")) { scmUrl = "d" + scmUrl; }
		 */

		String url = "https://" + scmUrl + ".[BASE_DOMAIN]/sc/unifathrrqst/updateUnifAthrRqstPrgsts.do";

		ObjectMapper mapper = new ObjectMapper();

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/json");
		post.setEntity(new StringEntity(mapper.writeValueAsString(unifAthrRqstDtlList)));
		client.execute(post);

		sendAthrRqstUsr(unifAthrRqstDtlList);
	}

	/**
	 * 권한 신청자에게 OASIS MAIL을 발송한다.
	 * 
	 * @param SanctnMastrVo
	 *            결재마스터
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void sendAthrRqstUsr(Map unifAthrRqstDtlList) throws Exception {
		// 메일Vo
		DaonMailVo dmVo = new DaonMailVo();

		// 승인자Vo
		SessionVo apprvrVo = KwUserDetailHelper.getAuthenticatedUser();

		// 승인된 권한신청목록
		List<Map> unifAthrRqstList = (List<Map>) unifAthrRqstDtlList.get("dltUnifAthrRqstDtlList");

		// 메일 보낸 ID 목록
		List<String> sendIdList = new ArrayList<>();

		for (Map unifAthrRqstMap : unifAthrRqstList) {

			// 신청자ID
			String usrId = (String) unifAthrRqstMap.get("usrId");
			// 신청상태
			String prgstsCd = (String) unifAthrRqstMap.get("prgstsCd");
			String prgstsNm = StringUtils.equals(prgstsCd, "40") ? "적용" : "회수";

			if (usrId != null) {
				// 해당ID의 메일발송 여부
				boolean sended = false;

				for (String sendId : sendIdList) {
					if (StringUtils.equals(sendId, usrId)) {
						sended = true;
					}
				}

				// 메일을 발송했으면 스킵
				if (sended) {
					continue;
				}

				// 필수값
				// 보낸이 사원번호
				dmVo.setSENDER_EMP_CODE((String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID));
				// 메일제목
				dmVo.setSUBJECT("[" + apprvrVo.getSysDivCd() + "] 사용자권한 적용완료 알림");
				// 메일 발송 시간(YYYYMMDDHH24MI)
				dmVo.setSEND_DATE(DateUtil.convertDateToString(new Date(), "yyyyMMddHHmm"));
				// 받는이 사원번호 ( 구분자 ; 세미콜론) - 유효한 사용자가 한명이라도 있으면 발송
				dmVo.setTO_EMP_CODE(usrId);
				// 메일전송을 위한 고유 파일이름 생성 (System별 고유)
				dmVo.setBODY_PHY_FILE_NAME((String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_SYS_DIV_CD));

				StringBuilder sb = new StringBuilder();
				sb.append("요청하신 사용자권한이 ").append(prgstsNm).append(" 완료되었습니다.<br/><br/>");
				sb.append("===============================================================================<br/>");
				sb.append("업 무 명 : [").append(apprvrVo.getSysDivCd()).append("]<br/>");
				sb.append("적 용 일 : ").append(DateUtil.convertDateToString(new Date(), "yyyy-MM-dd")).append("<br/>");
				sb.append("===============================================================================<br/><br/>");
				sb.append("★").append(prgstsNm).append("내역</br>");
				sb.append("===============================================================================<br/>");
				sb.append(
						"사번&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;성명&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;신청권한<br/>");
				sb.append("===============================================================================<br/>");
				for (Map unifAthrRqstSubMap : unifAthrRqstList) {
					if (StringUtils.equals(usrId, (String) unifAthrRqstSubMap.get("usrId"))) {
						sb.append((String) unifAthrRqstSubMap.get("usrId")).append("&nbsp;&nbsp;")
								.append((String) unifAthrRqstSubMap.get("usrNm")).append("&nbsp;&nbsp;")
								.append((String) unifAthrRqstSubMap.get("athrNm")).append("<br/>");
					}
				}
				sb.append("===============================================================================");

				dmVo.setCONTENT(sb.toString());

				daonMailService.processDaonMail(dmVo);

				// 메일 발송ID 추가
				sendIdList.add(usrId);
			}
		}
	}

	/**
	 * 사용자별권한그룹 사용여부 조회를 한다
	 * 
	 * @param menuMngList
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Map selectUsrAthrUse(UsrAthrRqstVo usrAthrRqstVo) {
		return ecsCommonDao.select("TM_ECS_INTN_USR_ATHR_Dao_selectUsrAthrUse", usrAthrRqstVo);
	}

	/**
	 * 사용자 자신에게 부여된 권한만 조회
	 * 
	 * @param usrSysAthrVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveUsrAthr(UsrAthrRqstVo usrAthrRqstVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_USR_ATHR_Dao_retrieveUsrAthr", usrAthrRqstVo);
	}

	/**
	 * 사용자 자신에게 부여된 권한만 조회
	 * 
	 * @param usrSysAthrVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveBtnInfo(BtnAthrVo btnAthrVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_SCRIN_BTN_MNG_Dao_retrieveBtnInfo", btnAthrVo);
	}

	/**
	 * 해당 시스템으로 사용중인 버튼권한정보 조회
	 * 
	 * @param scrinBtnVo
	 * @return Map
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Map selectScrinBtnUse(ScrinBtnVo scrinBtnVo) {
		return ecsCommonDao.select("TM_ECS_SCRIN_BTN_MNG_Dao_selectBtnUse", scrinBtnVo);
	}

	/**
	 * 대내화면버튼권한 데이터 목록을 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param dltScrinBtn
	 * @return
	 * @throws Exception
	 */
	public void saveScrinBtnList(List<ScrinBtnVo> dltScrinBtn) {
		for (ScrinBtnVo vo : dltScrinBtn) {
			saveScrinBtn(vo);
		}
	}

	/**
	 * 대내화면버튼권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param scrinBtnVo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void saveScrinBtn(ScrinBtnVo scrinBtnVo) {
		switch (scrinBtnVo.getRowStatus()) {
		case WqConstant.ROW_TYPE_INSERTED:
			// 추가를 수행합니다.
			ecsCommonDao.insert("TM_ECS_SCRIN_BTN_MNG_Dao_insertScrinBtn", scrinBtnVo);
			break;
		case WqConstant.ROW_TYPE_UPDATED:
			// 수정을 수행합니다.
			ecsCommonDao.update("TM_ECS_SCRIN_BTN_MNG_Dao_updateScrinBtn", scrinBtnVo);
			break;
		case WqConstant.ROW_TYPE_DELETED:
		case WqConstant.ROW_TYPE_REMOVE:
			// 목록삭제는 내부에서 사용중인지 체크한다.
			Map scrinBtnMap = selectScrinBtnUse(scrinBtnVo);
			if (scrinBtnMap != null) {
				BigDecimal menuCnt = (BigDecimal) scrinBtnMap.get("menuCnt");
				BigDecimal usrCnt = (BigDecimal) scrinBtnMap.get("usrCnt");
				if (menuCnt.intValue() == 0 && usrCnt.intValue() == 0) {
					// 삭제를 수행합니다.
					ecsCommonDao.delete("TM_ECS_SCRIN_BTN_MNG_Dao_deleteScrinBtn", scrinBtnVo);
				}
			}
			break;
		default:
			break;
		}
	}

	/**
	 * 화면의 조건정보조회를 수행합니다.
	 * 
	 * @param scrinMngVo
	 * @return Map
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public Map selectScrinConditionInfo(Map paramMap) throws Exception {
		ScrinMngVo scrinMngVo = new ScrinMngVo();
		scrinMngVo.setScrinId((String) paramMap.get("scrinId"));
		return ecsCommonDao.select("TM_ECS_INTN_SCRIN_Dao_selectScrinConditionInfo", scrinMngVo);
	}

	/**
	 * 인코딩된 사원번호와 페이지/메뉴정보를 조회한다.
	 * 
	 * @param scrinMngVo
	 * @return Map
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public Map selectLnkSys(ScrinMngVo scrinMngVo) {
		return ecsCommonDao.select("TM_ECS_INTN_SCRIN_Dao_selectLnkSys", scrinMngVo);
	}

	/**
	 * 자신에게 부여된 권한관련 시스템구분코드를 조회한다.(고도화)
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public List<Map> retrieveAthr_(AthrGrpMngVo athrGrpMngVo) throws Exception {
		List<Map> athrList = ecsCommonDao.selectList("TM_ECS_INTN_ATHR_Dao_retrieveAthr", athrGrpMngVo);

		// 통합권한신청 API
		if (StringUtil.isNotEmpty(athrGrpMngVo.getUsrId())) {
			// 사용자정보를 조회
			HrmVmHr01601Vo hrmVmHr01601Vo = new HrmVmHr01601Vo();
			hrmVmHr01601Vo.setUsrEmpno(athrGrpMngVo.getUsrId());
			Map usrInfo = ecsCommonDao.select("VM_HR01601_Dao_retrieveUsrList", hrmVmHr01601Vo);

			String usrPsitnDivCd = getPsitnDivCdByUsrInfo(usrInfo);
			// int usrJgrdAthrDivCd = getJgrdAthrDivCdByUsrInfo(usrInfo);
			String usrpsitnDeptCdList = usrInfo.get("usrHqCd") + "|" + usrInfo.get("usrDeptCd") + "|"
					+ usrInfo.get("usrSectCd") + "|" + usrInfo.get("usrTeamCd");

			Map athrMap = null;

			String bassAthrDivCd = "";
			String psitnAthrDivCd = "";
			// String jgrdAthrDivCd = "";
			String psitnDeptCdList = "";

			for (int i = 0; i < athrList.size(); i++) {
				athrMap = athrList.get(i);

				// 기본권한구분코드
				bassAthrDivCd = StringUtil.isNullToString(athrMap.get("bassAthrDivCd"));
				if (StringUtil.isNotEmpty(bassAthrDivCd)) {
					if ("1".equals(bassAthrDivCd) && athrGrpMngVo.getUsrId().compareTo("2") > 0) {
						athrList.remove(i);
						continue; // 정규직(1,2사번)
					} else if ("2".equals(bassAthrDivCd) && (athrGrpMngVo.getUsrId().compareTo("3") < 0
							|| athrGrpMngVo.getUsrId().compareTo("4") > 0)) {
						athrList.remove(i);
						continue; // 계약직(3,4사번)
					} else if ("3".equals(bassAthrDivCd) && (athrGrpMngVo.getUsrId().compareTo("5") < 0
							|| athrGrpMngVo.getUsrId().compareTo("8") > 0)) {
						athrList.remove(i);
						continue; // 비정규직(5,6,7,8사번)
					}
				}
				// 소속권한구분코드
				psitnAthrDivCd = StringUtil.isNullToString(athrMap.get("psitnAthrDivCd"));
				if (StringUtil.isNotEmpty(psitnAthrDivCd)) {
					if (!usrPsitnDivCd.equals(psitnAthrDivCd)) {
						athrList.remove(i);
						continue;
					}
				}
				// 소속부서코드
				psitnDeptCdList = StringUtil.isNullToString(athrMap.get("psitnDeptCdList"));
				if (StringUtil.isNotEmpty(psitnDeptCdList)) {
					boolean isUsrDept = false;
					for (String psitnDeptCd : psitnDeptCdList.split(" ")) {
						if (usrpsitnDeptCdList.indexOf(psitnDeptCd) > -1) {
							isUsrDept = true;
							break;
						}
					}
					if (!isUsrDept) {
						athrList.remove(i);
					}
				}
			}
		}
		return athrList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getPsitnDivCdByUsrInfo(Map usrInfo) throws Exception {
		Map sapMap = new HashMap();
		/* RFC_NAME */
		sapMap.put("RFC_NAME", "ZFIZ_IF_CSKS");
		/* IS_IMPORT */
		Map importMap = new HashMap();
		importMap.put("KSYS_ID", "SCM");
		importMap.put("IF_EMP_ID", (String) usrInfo.get("usrId"));
		sapMap.put("IS_IMPORT", importMap);
		/* 회사코드 및 코스트센터코드 */
		sapMap.put("IV_BUKRS", "KW00");// 회사코드
		sapMap.put("IV_KOSTL", (String) usrInfo.get("cstctCd"));// 코스트센터
		sapMap.put("IV_DATBI", DateUtil.getCurrentDate("yyyyMMdd"));// 기준일자
		/* EXPORT_RESULT */
		List exportResultList = new ArrayList();
		exportResultList.add("ES_EXPORT");
		sapMap.put("EXPORT_RESULT", exportResultList);
		/* EXPORT_TABLE */
		List exportTableList = new ArrayList();
		exportTableList.add("TT_DATA");
		sapMap.put("EXPORT_TABLE", exportTableList);
		/* SAP 호출 */
		Map<String, Object> maps = SapClient.getTable(sapMap);

		/**
		 * SAP RESULT TYPE S : 성공 / E : 에러 / W : 경고 / I : 정보 / A : 중단
		 */
		if (!"S".equals((String) maps.get("EAI_CD"))) {
			throw processException((String) maps.get("EAI_MSG"));
		}
		if (maps != null) {
			List data1 = (List) maps.get("data1");
			if (data1 != null && data1.size() > 0) {
				Map ttData = (Map) data1.get(0);
				// GSBER(사업영역) 가 101인 경우에는 본사. 나머지는 현장
				if (ttData.get("GSBER") != null && "101".equals(ttData.get("GSBER"))) {
					return "0";
				}
			}
		}
		return "1";
	}

	@SuppressWarnings({ "rawtypes" })
	public int getJgrdAthrDivCdByUsrInfo(Map usrInfo) {
		String usrJgrdCd = StringUtil.isNullToString(usrInfo.get("usrJgrdCd"));
		int rtnJgrdAthrDivCd = 9;

		switch (usrJgrdCd) {
		case "0010":
		case "0020":
		case "0030":
		case "0110":
		case "0220":
		case "02B0":
		case "0310":
			rtnJgrdAthrDivCd = 1;
			break;
		case "0115":
		case "0120":
		case "0130":
		case "0230":
		case "0240":
		case "02C0":
		case "02D0":
		case "0320":
		case "0330":
			rtnJgrdAthrDivCd = 3;
			break;
		default:
			rtnJgrdAthrDivCd = 9;
			break;
		}
		return rtnJgrdAthrDivCd;
	}

}