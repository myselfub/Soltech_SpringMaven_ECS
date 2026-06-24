package kw.ecs.zz.authmng.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
import kw.fw.defaults.DefaultConsts;
import kw.fw.defaults.DefaultController;
import kw.fw.handler.ResponseData;
import kw.fw.token.SavedToken;
import kw.fw.token.ValidationToken;
import kw.fw.util.FasooDrmUtil;
import kw.fw.util.FileUtil;
import kw.fw.util.ParameterMapper;
import kw.fw.util.RequestContextUtil;
import kw.scm.sc.cmmncd.vo.UsrListVo;
import kw.scm.sc.file.vo.ComnAttchFileMtVo;

/**
 * EcsAuthorityController 컨트롤러 클래스
 * 
 * @ClassName EcsAuthorityController.java
 * @Description 권한 컨트롤러 클래스
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
@Controller
@RequestMapping("/zz")
public class EcsAuthorityController extends DefaultController {
	/**
	 * Logger
	 */
	protected final static Logger LOGGER = Logger.getLogger(EcsAuthorityController.class);

	/**
	 * ecsAuthorityService
	 */
	@Resource(name = "ecsAuthorityService")
	public EcsAuthorityService ecsAuthorityService;

	/**
	 * 권한 데이터를 조회한다.
	 * 
	 * @param param
	 *            클라이언트에서 전달한 데이터 맵 객체
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "authmng/getAuthorityList.do")
	public ModelAndView getAuthorityList(Map param) throws Exception {
		return addResponseData(ecsAuthorityService.getAuthorityList(param));
	}

	/**
	 * 한 건 또는 다 건의 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 *            클라이언트에서 전달한 데이터 맵 객체
	 * @return
	 */
	@ValidationToken
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveAuthorityList.do")
	public ModelAndView saveAuthorityList(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<AuthorityVo> authorityList = pm.getListData(param, "data", new AuthorityVo());
		kwDefaultBeanValidator.validate(authorityList);
		ecsAuthorityService.saveAuthorityList(authorityList);
		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 메뉴별 권한 데이터를 조회한다.
	 * 
	 * @param param
	 *            클라이언트에서 전달한 데이터 맵 객체
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "authmng/getAuthorityMenuList.do")
	public ModelAndView getAuthorityMenuList(Map param) throws Exception {
		return addResponseData(ecsAuthorityService.getAuthorityMenuList(param));
	}

	/**
	 * 한 건 또는 다 건의 메뉴별 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 *            클라이언트에서 전달한 데이터 맵 객체
	 * @return
	 */
	@ValidationToken
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveAuthorityMenuList.do")
	public ModelAndView saveAuthorityMenuList(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<AuthorityMenuVo> authorityMenuList = pm.getListData(param, "data", new AuthorityMenuVo());
		kwDefaultBeanValidator.validate(authorityMenuList);

		ecsAuthorityService.saveAuthorityMenuList(authorityMenuList);
		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 권한별 사원 데이터를 조회한다.
	 * 
	 * @param param
	 *            클라이언트에서 전달한 데이터 맵 객체
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "authmng/getPersonAuthorityList.do")
	public ModelAndView getPersonAuthorityList(Map param) throws Exception {
		return addResponseData(ecsAuthorityService.getPersonAuthorityList(param));
	}

	/**
	 * 한 건 또는 다 건의 권한별 사원 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 *            클라이언트에서 전달한 데이터 맵 객체
	 * @return
	 */
	@ValidationToken
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/savePersonAuthorityList.do")
	public ModelAndView savePersonAuthorityList(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<PersonAuthorityVo> personAuthorityList = pm.getListData(param, "data", new PersonAuthorityVo());
		kwDefaultBeanValidator.validate(personAuthorityList);
		ecsAuthorityService.savePersonAuthorityList(personAuthorityList);
		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 권한체크 및 CSRF
	 * 
	 * @param param
	 *            클라이언트에서 전달한 데이터 맵 객체
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "authmng/selectPgmAuth.do")
	public ModelAndView selectPgmAuth(Map param, HttpServletRequest req) throws Exception {

		ModelAndView mav = createModelAndView();

		Map<String, Object> message = new HashMap<String, Object>();
		message.put(DefaultConsts.MESSAGE_CODE_NODE_NAME, DefaultConsts.STATUS_SUCESS);
		message.put(DefaultConsts.MESSAGE_CODE_NAME_NODE_NAME, DefaultConsts.STATUS_SUCESS_MESSAGE);
		mav.addObject(DefaultConsts.MESSAGE_NODE_NAME, message);

		// 버튼권한체크
		Map map = ecsAuthorityService.selectPgmAuth(param);
		mav.addObject(DefaultConsts.DATA_NODE_NAME, map);

		// Valid Token 생성
		String strSavedToken = SavedToken.setToken(req, SavedToken.DEFAULT_TOKEN_NAME);
		mav.addObject(DefaultConsts.WEBSQUARE_TOKEN_NAME, strSavedToken);

		// logging 화면접근 기타등등 추가해야함
		return mav;
	}

	/**
	 * SAVED TOKEN 값 생성
	 * 
	 * @param param
	 *            클라이언트에서 전달한 데이터 맵 객체
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "authmng/selectSavedToken.do")
	public ModelAndView selectSavedToken(Map param, HttpServletRequest req) throws Exception {
		ModelAndView mav = createModelAndView();

		Map<String, Object> message = new HashMap<String, Object>();
		message.put(DefaultConsts.MESSAGE_CODE_NODE_NAME, DefaultConsts.STATUS_SUCESS);
		message.put(DefaultConsts.MESSAGE_CODE_NAME_NODE_NAME, DefaultConsts.STATUS_SUCESS_MESSAGE);
		mav.addObject(DefaultConsts.MESSAGE_NODE_NAME, message);

		// Valid Token 생성
		String strSavedToken = SavedToken.setToken(req, SavedToken.DEFAULT_TOKEN_NAME);
		mav.addObject(DefaultConsts.WEBSQUARE_TOKEN_NAME, strSavedToken);

		return mav;
	}

	/**
	 * 권한조회를 수행합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000001
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveAthr.do")
	public ModelAndView retrieveAthr(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		AthrGrpMngVo athrGrpMngVo = (AthrGrpMngVo) pm.getMapData(param, "dmaInqireParam", new AthrGrpMngVo());
		return addResponseData(ecsAuthorityService.retrieveAthr(athrGrpMngVo));
	}

	/**
	 * 권한조회를 수행합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000001
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveAthrEcs.do")
	public ModelAndView retrieveAthrEcs(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		AthrGrpMngVo athrGrpMngVo = (AthrGrpMngVo) pm.getMapData(param, "dmaInqireParam", new AthrGrpMngVo());
		return addResponseData(ecsAuthorityService.retrieveAthrEcs(athrGrpMngVo));
	}

	/**
	 * 권한관리 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000001
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveAthrMng.do")
	public ModelAndView saveAthrMng(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();

		List<AthrGrpMngVo> athrGrpMngVo = pm.getListData(param, "dltAthrList", new AthrGrpMngVo());
		List<IntnAthrMenuVo> intnAthrMenuVo = pm.getListData(param, "dltMenuAthrList", new IntnAthrMenuVo());
		List<UsrAthrGrpMngVo> usrAthrGrpMngList = pm.getListData(param, "dltUsrAthrList", new UsrAthrGrpMngVo());

		if (!athrGrpMngVo.isEmpty()) {
			kwDefaultBeanValidator.validate(athrGrpMngVo);
			// ecsAuthorityService.saveAthrMng(athrGrpMngVo);
		}

		if (!intnAthrMenuVo.isEmpty()) {
			kwDefaultBeanValidator.validate(intnAthrMenuVo);
			// ecsAuthorityService.saveIntnAthrMenu(intnAthrMenuVo);
		}

		if (!usrAthrGrpMngList.isEmpty()) {
			kwDefaultBeanValidator.validate(usrAthrGrpMngList);
			// ecsAuthorityService.saveUsrAthrGrpMngList(usrAthrGrpMngList);
		}

		ecsAuthorityService.saveAthrMngList(athrGrpMngVo, intnAthrMenuVo, usrAthrGrpMngList);

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 삭제전 권한이 등록된 정보조회를 수행합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000001
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/selectAthrUse.do")
	public ModelAndView selectAthrUse(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		AthrGrpMngVo athrGrpMngVo = (AthrGrpMngVo) pm.getMapData(param, "dmaSaveAthr", new AthrGrpMngVo());
		return addResponseData(ecsAuthorityService.selectAthrUse(athrGrpMngVo));
	}

	/**
	 * 화면조회를 수행합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000003
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveScrin.do")
	public ModelAndView retrieveScrin(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		ScrinMngVo scrinMngVo = (ScrinMngVo) pm.getMapData(param, "dmaInqireParam", new ScrinMngVo());
		return addResponseData(ecsAuthorityService.retrieveScrin(scrinMngVo));
	}

	/**
	 * 도움말 정보를 조회합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveHpcm.do")
	public ModelAndView retrieveHpcm(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		ScrinMngVo scrinMngVo = (ScrinMngVo) pm.getMapData(param, "dmaInqireParam", new ScrinMngVo());
		return addResponseData(ecsAuthorityService.retrieveHpcm(scrinMngVo));
	}

	/**
	 * 화면도움말 파일을 업로드한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000003
	 */
	@Deprecated
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveScrinHelpFile.do")
	public ModelAndView saveScrinHelpFile(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();

		ComnAttchFileMtVo fileVo = (ComnAttchFileMtVo) pm.getMapData(param, "dmaSaveScrin", new ComnAttchFileMtVo());

		String drmInstall = propertiesService.getString("kw.drm.install", "N");
		String fileExtsnm = "pdf";

		Path fileTmprPath = Paths.get(propertiesService.getString("global.fileupload.tempPath"),
				fileVo.getFileTmprPath());
		Path toFileName = Paths.get(propertiesService.getString("global.fileupload.path"), "manual",
				fileVo.getOrginlFileNm());
		Path toFilePath = toFileName.getParent();

		if (Files.notExists(toFilePath)) {
			Files.createDirectories(toFilePath);
		}

		FasooDrmUtil drmUtil = new FasooDrmUtil();
		String returnPath = "";
		if ("Y".equals(drmInstall) && drmUtil.drmExtCheck(fileExtsnm)) {
			int checkType = drmUtil.GetFileType(fileTmprPath.toString());
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("checkType1 : " + checkType);
			}
			if (checkType == 103) {
				returnPath = drmUtil.FasooDocDec(fileTmprPath.toString(), toFileName.toString());
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("returnPath : " + returnPath);
				}

				if (StringUtils.isEmpty(returnPath)) {
					return addResponseData(DefaultConsts.STATUS_ERROR, "첨부파일 처리중 에러가 발생하였습니다.");
				}
			} else {
				// 임시저장폴더에서 실제저장 폴더로 복사
				FileUtil.copyFile(fileTmprPath.toString(), toFileName.toString());
			}
		} else {
			// 임시저장폴더에서 실제저장 폴더로 복사
			FileUtil.copyFile(fileTmprPath.toString(), toFileName.toString());
		}

		// 임시저장폴더에 있는 파일 삭제처리
		FileUtil.deleteFile(fileTmprPath.toString());

		// 파일복사 체크
		if (Files.notExists(toFileName)) {
			return addResponseData(DefaultConsts.STATUS_ERROR, "첨부파일 처리중 에러가 발생하였습니다.");
		}

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 화면등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000003
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveScrinMng.do")
	public ModelAndView saveScrinMng(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();

		ScrinMngVo scrinMngVo = (ScrinMngVo) pm.getMapData(param, "dmaSaveScrin", new ScrinMngVo());

		if (scrinMngVo != null) {
			kwDefaultBeanValidator.validate(scrinMngVo);
			ecsAuthorityService.saveScrinMng(scrinMngVo);
		}

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 삭제전 화면메뉴설정 정보조회를 수행합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000003
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/selectScrinInfo.do")
	public ModelAndView selectScrinInfo(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		ScrinMngVo scrinMngVo = (ScrinMngVo) pm.getMapData(param, "dmaSaveScrin", new ScrinMngVo());
		return addResponseData(ecsAuthorityService.selectScrinInfo(scrinMngVo));
	}

	/**
	 * 메뉴조회를 수행합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000002
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveMenu.do")
	public ModelAndView retrieveMenu(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		MenuMngVo menuMngVo = (MenuMngVo) pm.getMapData(param, "dmaInqireParam", new MenuMngVo());
		return addResponseData(ecsAuthorityService.retrieveMenu(menuMngVo));
	}

	/**
	 * 메뉴등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000002
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveMenuMng.do")
	public ModelAndView saveMenuMng(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();

		MenuMngVo menuMngVo = (MenuMngVo) pm.getMapData(param, "dmaSaveMenu", new MenuMngVo());
		kwDefaultBeanValidator.validate(menuMngVo);

		ecsAuthorityService.saveMenuMng(menuMngVo);

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 삭제전 메뉴설정 정보조회를 수행합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000002
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/selectMenuUse.do")
	public ModelAndView selectMenuUse(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		MenuMngVo menuMngVo = (MenuMngVo) pm.getMapData(param, "dmaSaveMenu", new MenuMngVo());
		return addResponseData(ecsAuthorityService.selectMenuUse(menuMngVo));
	}

	/**
	 * 사용자별권한관리에서 권한그룹 조회를 수행합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000004
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveAthrGrp.do")
	public ModelAndView retrieveAthrGrp(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		AthrGrpMngVo athrGrpMngVo = (AthrGrpMngVo) pm.getMapData(param, "dmaInqireParam", new AthrGrpMngVo());
		return addResponseData(ecsAuthorityService.retrieveAthrGrp(athrGrpMngVo));
	}

	/**
	 * 사용자별권한관리에서 사용자 권한부여현황 조회를 수행합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000004
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retriebeUsrAthrGrp.do")
	public ModelAndView retriebeUsrAthrGrp(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		UsrAthrGrpMngVo usrAthrGrpMngVo = (UsrAthrGrpMngVo) pm.getMapData(param, "dmaInqireUsrAthr",
				new UsrAthrGrpMngVo());
		return addResponseData(ecsAuthorityService.retriebeUsrAthrGrp(usrAthrGrpMngVo));
	}

	/**
	 * 사용자별권한관리에서 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000004
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveUsrAthrGrpMngList.do")
	public ModelAndView saveUsrAthrGrpMngList(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();

		List<UsrAthrGrpMngVo> usrAthrGrpMngList = pm.getListData(param, "dltUsrAthrList", new UsrAthrGrpMngVo());
		kwDefaultBeanValidator.validate(usrAthrGrpMngList);

		ecsAuthorityService.saveUsrAthrGrpMngList(usrAthrGrpMngList);

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 메뉴등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000002
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveMenuMngList.do")
	public ModelAndView saveMenuMngList(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();

		List<MenuMngVo> menuMngList = pm.getListData(param, "dltMenuList", new MenuMngVo());
		kwDefaultBeanValidator.validate(menuMngList);

		ecsAuthorityService.saveMenuMngList(menuMngList);

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 자신에게 부여된 권한관련 시스템구분코드를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "authmng/retrieveAthrSysDivCd.do")
	public ModelAndView retrieveAthrSysDivCd(Map param) throws Exception {
		Map para = (Map) param.get("data");
		return addResponseData(ecsAuthorityService.retrieveAthrSysDivCd(para));
	}

	/**
	 * 권한그룹별메뉴목록을 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000005
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveIntnAthrMenu.do")
	public ModelAndView retrieveIntnAthrMenu(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		IntnAthrMenuVo intnAthrMenuVo = (IntnAthrMenuVo) pm.getMapData(param, "dmaInqireMenuAthr",
				new IntnAthrMenuVo());
		return addResponseData(ecsAuthorityService.retrieveIntnAthrMenu(intnAthrMenuVo));
	}

	/**
	 * 권한별메뉴목록 등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000005
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveIntnAthrMenu.do")
	public ModelAndView saveIntnAthrMenu(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();

		List<IntnAthrMenuVo> intnAthrMenuVo = pm.getListData(param, "dltMenuAthrList", new IntnAthrMenuVo());
		kwDefaultBeanValidator.validate(intnAthrMenuVo);

		ecsAuthorityService.saveIntnAthrMenu(intnAthrMenuVo);

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 사용자별 메뉴접속권한 목록을 조회한다. 게시물 통합검색에서 사용자가 게시물 메뉴의 접근 권한 여부를 조회할 때 사용한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveUsrMenuAthr.do")
	public ModelAndView retrieveUsrMenuAthr(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		IntnAthrMenuVo intnAthrMenuVo = (IntnAthrMenuVo) pm.getMapData(param, "dmaInqireParam", new IntnAthrMenuVo());
		return addResponseData(ecsAuthorityService.retrieveUsrMenuAthr(intnAthrMenuVo));
	}

	/**
	 * 사용자별메뉴관리에서 사요자정보 조회를 수행합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000006
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveUsr.do")
	public ModelAndView retrieveUsr(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		UsrListVo usrListVo = (UsrListVo) pm.getMapData(param, "dmaInqireParam", new UsrListVo());
		return addResponseData(ecsAuthorityService.retrieveUsr(usrListVo));
	}

	/**
	 * 사용자별메뉴목록을 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000006
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveIntnUsrMenu.do")
	public ModelAndView retrieveIntnUsrMenu(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		IntnUsrMenuVo intnUsrMenuVo = (IntnUsrMenuVo) pm.getMapData(param, "dmaInqireUsrMenu", new IntnUsrMenuVo());
		return addResponseData(ecsAuthorityService.retrieveIntnUsrMenu(intnUsrMenuVo));
	}

	/**
	 * 사용자별메뉴목록 등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000006
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveIntnUsrMenu.do")
	public ModelAndView saveIntnUsrMenu(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();

		List<IntnUsrMenuVo> intnUsrMenuVo = pm.getListData(param, "dltIntnUsrMenu", new IntnUsrMenuVo());
		kwDefaultBeanValidator.validate(intnUsrMenuVo);

		ecsAuthorityService.saveIntnUsrMenu(intnUsrMenuVo);

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 사용자별시스템구분목록을 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000007
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveUsrSysAthr.do")
	public ModelAndView retrieveUsrSysAthr(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		UsrSysAthrVo usrSysAthrVo = (UsrSysAthrVo) pm.getMapData(param, "dmaInqireParam", new UsrSysAthrVo());
		return addResponseData(ecsAuthorityService.retrieveUsrSysAthr(usrSysAthrVo));
	}

	/**
	 * 사용자별시스템구분목록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000007
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveUsrSysAthr.do")
	public ModelAndView saveUsrSysAthr(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();

		List<UsrSysAthrVo> usrSysAthrVo = pm.getListData(param, "dltUsrSysDivList", new UsrSysAthrVo());
		kwDefaultBeanValidator.validate(usrSysAthrVo);

		ecsAuthorityService.saveUsrSysAthr(usrSysAthrVo);

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 사용자별권한그룹조회를 한다. .
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000008
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveUsrAthrRqst.do")
	public ModelAndView retrieveUsrAthrRqst(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		UsrAthrRqstVo usrAthrRqstVo = (UsrAthrRqstVo) pm.getMapData(param, "dmaInqireParam", new UsrAthrRqstVo());
		return addResponseData(ecsAuthorityService.retrieveUsrAthrRqst(usrAthrRqstVo));
	}

	/**
	 * 사용자별권한그룹조회를 한다. (관리자)
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000009
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveUsrAthrRqstAdmin.do")
	public ModelAndView retrieveUsrAthrRqstAdmin(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		UsrAthrRqstVo usrAthrRqstVo = (UsrAthrRqstVo) pm.getMapData(param, "dmaInqireParam", new UsrAthrRqstVo());
		return addResponseData(ecsAuthorityService.retrieveUsrAthrRqstAdmin(usrAthrRqstVo));
	}

	/**
	 * 사용자별권한정보 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000008
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveUsrAthrRqst.do")
	public ModelAndView saveUsrAthrRqst(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<UsrAthrRqstVo> usrAthrRqstVo = pm.getListData(param, "dltUsrAthrRqstList", new UsrAthrRqstVo());

		kwDefaultBeanValidator.validate(usrAthrRqstVo);
		ecsAuthorityService.saveUsrAthrRqst(usrAthrRqstVo);

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 통합권한신청 데이터를 등록한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000008
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/insertUsrAthrRqst.do")
	public ModelAndView insertUsrAthrRqst(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		UsrAthrRqstVo usrAthrRqstVo = (UsrAthrRqstVo) pm.getMapData(param, "dmaUsrAthrRqst", new UsrAthrRqstVo());

		kwDefaultBeanValidator.validate(usrAthrRqstVo);
		ecsAuthorityService.insertUsrAthrRqst(usrAthrRqstVo);

		return addResponseData(ResponseData.STATUS_SUCESS);
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
	@RequestMapping(value = "authmng/transferUnifAthrRqst.do")
	public ModelAndView transferUnifAthrRqst(Map param) throws Exception {
		ecsAuthorityService.transferUnifAthrRqst(param);
		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 사용자별 권한그룹 등록여부 조회
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000008
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/selectUsrAthrUse.do")
	public ModelAndView selectUsrAthrGrp(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		UsrAthrRqstVo usrAthrRqstVo = (UsrAthrRqstVo) pm.getMapData(param, "dmaInqireUsrAthrUse", new UsrAthrRqstVo());
		return addResponseData(ecsAuthorityService.selectUsrAthrUse(usrAthrRqstVo));
	}

	/**
	 * 사용자 자신에게 부여된 권한만 조회
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000008
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/retrieveUsrAthr.do")
	public ModelAndView retrieveUsrAthr(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		UsrAthrRqstVo usrAthrRqstVo = (UsrAthrRqstVo) pm.getMapData(param, "dmaInqireParam", new UsrAthrRqstVo());
		return addResponseData(ecsAuthorityService.retrieveUsrAthr(usrAthrRqstVo));
	}

	/**
	 * 해당 시스템으로 설정된 대내화면버튼권한정보 조회
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000010
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = { "authmng/retrieveBtnInfo.do", "authmng/retrieveScrinBtn.do" })
	public ModelAndView retrieveBtnInfo(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		BtnAthrVo btnAthrVo = (BtnAthrVo) pm.getMapData(param, "dmaInqireParam", new BtnAthrVo());
		return addResponseData(ecsAuthorityService.retrieveBtnInfo(btnAthrVo));
	}

	/**
	 * 삭제전 대내화면버튼권한이 등록된 정보조회를 수행합니다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC30000010
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/selectScrinBtnUse.do")
	public ModelAndView selectScrinBtnUse(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		ScrinBtnVo scrinBtnVo = (ScrinBtnVo) pm.getMapData(param, "dmaSaveScrinBtn", new ScrinBtnVo());
		return addResponseData(ecsAuthorityService.selectScrinBtnUse(scrinBtnVo));
	}

	/**
	 * 대내화면버튼권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 * @return ModelAndViewn
	 * @throws Exception
	 * @ScreenId SCMSC30000010
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/saveScrinBtn.do")
	public ModelAndView saveScrinBtn(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();

		List<ScrinBtnVo> dltScrinBtn = pm.getListData(param, "dltScrinBtnList", new ScrinBtnVo());

		if (!dltScrinBtn.isEmpty()) {
			kwDefaultBeanValidator.validate(dltScrinBtn);
			ecsAuthorityService.saveScrinBtnList(dltScrinBtn);
		}

		return addResponseData(ResponseData.STATUS_SUCESS);
	}

	/**
	 * 화면의 조건정보조회를 수행합니다.
	 * 
	 * @param param
	 *            화면 ID
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "authmng/selectScrinConditionInfo.do")
	public ModelAndView selectScrinConditionInfo(Map<String, Object> param) throws Exception {
		return addResponseData(ecsAuthorityService.selectScrinConditionInfo(param));
	}

	/**
	 * 인코딩된 사원번호와 페이지/메뉴정보를 조회한다.
	 * 
	 * @param param
	 *            : {
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "authmng/selectLnkSys.do", method = RequestMethod.POST)
	public ModelAndView selectLnkSys(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		ScrinMngVo scrinMngVo = (ScrinMngVo) pm.getMapData(param, "dmaInqireParam", new ScrinMngVo());

		if ((scrinMngVo.getIntnSysDivCd() == null || "".equals(scrinMngVo.getIntnSysDivCd()))
				|| scrinMngVo.getScrinId() == null || "".equals(scrinMngVo.getScrinId())) {
			return addResponseData(ResponseData.STATUS_ERROR);
		} else {
			/*
			 * String encNO = (String)
			 * RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID); // 사번
			 * String encMs = Long.toString(System.currentTimeMillis()); // 시간
			 * scrinMngVo.setUsrId(FasooDrmUtil.getEncStr(encNO + "#" + encMs));
			 */
			String usrId = (String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID); // 사용자ID(userId)
			scrinMngVo.setUsrId(FasooDrmUtil.getEncStr(usrId));
			return addResponseData(ecsAuthorityService.selectLnkSys(scrinMngVo));
		}
	}
}