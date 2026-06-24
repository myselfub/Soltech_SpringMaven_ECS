package kw.ecs.zz.cmmncd.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kw.ecs.zz.cmmncd.service.EcsCmmnCdService;
import kw.ecs.zz.cmmncd.vo.ClsCdVo;
import kw.ecs.zz.cmmncd.vo.CmmnCdVo;
import kw.ecs.zz.cmmncd.vo.CtgryVo;
import kw.ecs.zz.cmmncd.vo.DocClsCdVo;
import kw.ecs.zz.cmmncd.vo.HrmVmRs174Vo;
import kw.ecs.zz.cmmncd.vo.HrmVmRs175Vo;
import kw.ecs.zz.cmmncd.vo.MenuListVo;
import kw.ecs.zz.cmmncd.vo.ScrinListVo;
import kw.ecs.zz.cmmncd.vo.UsrListVo;
import kw.fw.defaults.DefaultController;
import kw.fw.util.ParameterMapper;

/**
 * EcsCmmnCdController 컨트롤러 클래스
 * 
 * @ClassName EcsCmmnCdController.java
 * @Description 공통코드 컨트롤러 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.06.14		60003048(조영창)			최초생성
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 정보화표준 조영창
 * @since 2017. 06. 14.
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2017 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@Controller
@RequestMapping("/zz")
public class EcsCmmnCdController extends DefaultController {

	protected final static Logger LOGGER = Logger.getLogger(EcsCmmnCdController.class);

	@Resource(name = "ecsCmmnCdService")
	public EcsCmmnCdService ecsCmmnCdService;

	/**
	 * 공통분류코드 및 공통코드를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "cmmncd/retrieveClsCdCmmnCd.do")
	public ModelAndView retrieveClsCdCmmnCd(Map param) {
		List list = (List) param.get("clsCdList");
		return addResponseData(ecsCmmnCdService.retrieveClsCdCmmnCd(list));
	}

	/**
	 * 메뉴정보를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC20000003
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cmmncd/retrieveMenu.do")
	public ModelAndView retrieveMenu(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		MenuListVo menuListVo = (MenuListVo) pm.getMapData(param, "dmaInqireParam", new MenuListVo());
		return addResponseData(ecsCmmnCdService.retrieveMenu(menuListVo));
	}

	/**
	 * 화면정보를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC20000004
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cmmncd/getScrinSearch.do")
	public ModelAndView getScrinSearch(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		ScrinListVo scrinListVo = (ScrinListVo) pm.getMapData(param, "dmaSearchParam", new ScrinListVo());
		return addResponseData(ecsCmmnCdService.getScrinSearch(scrinListVo));
	}

	/**
	 * 사용자 정보를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC20000001
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cmmncd/retrieveUsrInqire.do")
	public ModelAndView retrieveUsrInqire(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		UsrListVo usrListVo = (UsrListVo) pm.getMapData(param, "dmaInqireParam", new UsrListVo());
		return addResponseData(ecsCmmnCdService.retrieveUsrInqire(usrListVo));
	}

	/**
	 * 공통분류코드를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC50000001
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cmmncd/retrieveClsCd.do")
	public ModelAndView retrieveClsCd(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		ClsCdVo clsCdVo = (ClsCdVo) pm.getMapData(param, "dmaInqireParam", new ClsCdVo());
		return addResponseData(ecsCmmnCdService.retrieveClsCd(clsCdVo));
	}

	/**
	 * 공통코드를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC50000001
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cmmncd/retrieveCmmnCd.do")
	public ModelAndView retrieveCmmnCd(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		CmmnCdVo cmmnCdVo = (CmmnCdVo) pm.getMapData(param, "dmaInqireParam", new CmmnCdVo());
		return addResponseData(ecsCmmnCdService.retrieveCmmnCd(cmmnCdVo));
	}

	/**
	 * 공통분류코드 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC50000001
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cmmncd/saveCdList.do")
	public ModelAndView saveCdList(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		List<ClsCdVo> clsCdList = pm.getListData(param, "dltClsCdList", new ClsCdVo());
		List<CmmnCdVo> cmmnCdList = pm.getListData(param, "dltCmmnCdList", new CmmnCdVo());

		if (cmmnCdList != null) {
			kwDefaultBeanValidator.validate(clsCdList);
			kwDefaultBeanValidator.validate(cmmnCdList);
		} else {
			kwDefaultBeanValidator.validate(clsCdList);
		}

		return ecsCmmnCdService.saveClCmmnCdList(clsCdList, cmmnCdList);
	}

	/**
	 * 문서분류코드를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC40000001
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cmmncd/retrieveDocClsCd.do")
	public ModelAndView retrieveDocClsCdList(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		DocClsCdVo docClsCdVo = (DocClsCdVo) pm.getMapData(param, "dmaSearchParam", new DocClsCdVo());
		return addResponseData(ecsCmmnCdService.retrieveDocClsCd(docClsCdVo));
	}

	/**
	 * 오라클 암호화 함수 호출을 하여 암호화값 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cmmncd/selectDataEnc.do")
	public ModelAndView selectDataEnc(Map param) {
		return addResponseData(ecsCmmnCdService.selectDataEnc(param));
	}

	/**
	 * 카테고리를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cmmncd/retrieveCtgry.do")
	public ModelAndView retrieveCtgry(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		CtgryVo ctgryVo = (CtgryVo) pm.getMapData(param, "dmaSearchParam", new CtgryVo());
		return addResponseData(ecsCmmnCdService.retrieveCtgry(ctgryVo));
	}

	/**
	 * 인사뷰에서 부서정보를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "cmmncd/retrieveDeptInqire.do")
	public ModelAndView retrieveDeptInqire(Map param) {
		return addResponseData(ecsCmmnCdService.retrieveDeptInqire(param));
	}

	/**
	 * 인사뷰에서 2차 깊이의 부서정보를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "cmmncd/retrieveDept2Inqire.do")
	public ModelAndView retrieveDept2Inqire(Map param) {
		return addResponseData(ecsCmmnCdService.retrieveDept2Inqire(param));
	}

	/**
	 * 인사뷰(VM_RS174)에서 정보를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC11000001
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cmmncd/retrieveVmRs174Data.do")
	public ModelAndView retrieveVmRs174Data(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		HrmVmRs174Vo hrmVmRs174Vo = (HrmVmRs174Vo) pm.getMapData(param, "data", new HrmVmRs174Vo());
		return addResponseData(ecsCmmnCdService.retrieveVmRs174Data(hrmVmRs174Vo));
	}

	/**
	 * 인사뷰(VM_RS175)에서 정보를 조회한다.
	 * 
	 * @param param
	 * @return ModelAndView
	 * @throws Exception
	 * @ScreenId SCMSC11000001
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "cmmncd/retrieveVmRs175Data.do")
	public ModelAndView retrieveVmRs175Data(Map param) throws Exception {
		ParameterMapper pm = new ParameterMapper();
		HrmVmRs175Vo hrmVmRs175Vo = (HrmVmRs175Vo) pm.getMapData(param, "data", new HrmVmRs175Vo());
		return addResponseData(ecsCmmnCdService.retrieveVmRs175Data(hrmVmRs175Vo));
	}
}