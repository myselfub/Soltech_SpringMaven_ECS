package kw.ecs.zz.cmmncd.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kw.ecs.dao.EcsCommonDao;
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
import kw.fw.adaptor.WqConstant;
import kw.fw.dao.CommonDao;
import kw.fw.defaults.DefaultConsts;
import kw.fw.defaults.DefaultServiceImpl;

/**
 * EcsCmmnCdServiceImpl 서비스 클래스
 * 
 * @ClassName EcsCmmnCdServiceImpl.java
 * @Description 공통코드 서비스 클래스
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
@Service("ecsCmmnCdService")
public class EcsCmmnCdServiceImpl extends DefaultServiceImpl implements EcsCmmnCdService {

	protected final static Logger LOGGER = Logger.getLogger(EcsCmmnCdServiceImpl.class);

	/** CommonDao 적용 */
	@Resource(name = "commonDao")
	private CommonDao commonDao;

	/** ecsCommonDao 적용 */
	@Resource(name = "ecsCommonDao")
	private EcsCommonDao ecsCommonDao;

	/**
	 * 공통분류코드 및 공통코드를 조회한다.
	 * 
	 * @param list
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveClsCdCmmnCd(List list) {
		return (List) ecsCommonDao.selectList("TC_ECS_CD_Dao_retrieveClsCdCmmnCd", list);
	}

	/**
	 * 메뉴정보를 조회한다.
	 * 
	 * @param menuListVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveMenu(MenuListVo menuListVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_MENU_Dao_retrieveMenu", menuListVo);
	}

	/**
	 * 화면정보를 조회한다.
	 * 
	 * @param scrinListVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> getScrinSearch(ScrinListVo scrinListVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_DMST_SCRIN_Dao_getScrinSearch", scrinListVo);
	}

	/**
	 * 사용자정보를 조회한다.
	 * 
	 * @param usrListVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveUsrInqire(UsrListVo usrListVo) {
		return (List) ecsCommonDao.selectList("TM_ECS_INTN_USR_INFO_Dao_retrieveUsrInqire", usrListVo);
	}

	/**
	 * 공통분류코드를 조회한다.
	 * 
	 * @param clCdVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveClsCd(ClsCdVo clsCdVo) {
		return (List) ecsCommonDao.selectList("TC_ECS_CLS_CD_Dao_retrieveClsCd", clsCdVo);
	}

	/**
	 * 공통코드를 조회한다.
	 * 
	 * @param cmmnCdVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveCmmnCd(CmmnCdVo cmmnCdVo) {
		cmmnCdVo.setsysDiv(cmmnCdVo.getClsCd().substring(0, 3));
		return (List) ecsCommonDao.selectList("TC_ECS_CD_Dao_retrieveCmmnCd", cmmnCdVo);
	}

	/**
	 * 데이터를 변경(등록, 수정, 삭제) 한다.
	 * 
	 * @param clCdList
	 * @param cmmnCdList
	 * @return ModelAndView
	 * @throws Exception
	 */
	public ModelAndView saveClCmmnCdList(List<ClsCdVo> clsCdList, List<CmmnCdVo> cmmnCdList) {
		/*
		 * 2017. 12. 7. 60003256 강만석. 시큐어코딩 조치 try { saveClsCdList( clsCdList );
		 * 
		 * if( cmmnCdList != null ) { saveCmmnCdList( cmmnCdList );
		 * saveCmmnCdHist( cmmnCdList ); } } catch ( Exception e ) { return
		 * addResponseData( DefaultConsts.STATUS_ERROR ) ; }
		 */

		saveClsCdList(clsCdList);

		if (cmmnCdList != null) {
			saveCmmnCdList(cmmnCdList);
			saveCmmnCdHist(cmmnCdList);
		}

		return addResponseData(DefaultConsts.STATUS_SUCESS);
	}

	/**
	 * 공통분류코드 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param clCdList
	 * @return int
	 * @throws Exception
	 */
	public int saveClsCdList(List<ClsCdVo> clsCdList) {
		int insertRowCnt = 0;
		int updateRowCnt = 0;
		int deleteRowCnt = 0;

		ClsCdVo clsCdVo = new ClsCdVo();
		for (int idx = 0; idx < clsCdList.size(); idx++) {
			clsCdVo = clsCdList.get(idx);

			if (clsCdVo != null) {
				switch (clsCdVo.getRowStatus()) {
				case WqConstant.ROW_TYPE_INSERTED:
					// 추가를 수행합니다.
					insertRowCnt += ecsCommonDao.insert("TC_ECS_CLS_CD_Dao_insertClsCdList", clsCdVo);
					break;
				case WqConstant.ROW_TYPE_UPDATED:
					// 수정을 수행합니다.
					updateRowCnt += ecsCommonDao.update("TC_ECS_CLS_CD_Dao_updateClsCdList", clsCdVo);
					break;
				case WqConstant.ROW_TYPE_DELETED:
					// 삭제를 수행합니다.
					deleteRowCnt += ecsCommonDao.delete("TC_ECS_CLS_CD_Dao_deleteClsCdList", clsCdVo);
					break;
				default:
					break;
				}
			}
		}

		return insertRowCnt + updateRowCnt + deleteRowCnt;
	}

	/**
	 * 공통코드 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param cmmnCdList
	 * @return int
	 * @throws Exception
	 */
	public int saveCmmnCdList(List<CmmnCdVo> cmmnCdList) {
		int insertRowCnt = 0;
		int updateRowCnt = 0;
		int deleteRowCnt = 0;

		CmmnCdVo cmmnCdVo = new CmmnCdVo();
		for (int idx = 0; idx < cmmnCdList.size(); idx++) {
			cmmnCdVo = cmmnCdList.get(idx);

			if (cmmnCdVo != null) {
				switch (cmmnCdVo.getRowStatus()) {
				case WqConstant.ROW_TYPE_INSERTED:
					// 추가를 수행합니다.
					insertRowCnt += ecsCommonDao.insert("TC_ECS_CD_Dao_insertCmmnCdList", cmmnCdVo);
					break;
				case WqConstant.ROW_TYPE_UPDATED:
					// 수정을 수행합니다.
					updateRowCnt += ecsCommonDao.update("TC_ECS_CD_Dao_updateCmmnCdList", cmmnCdVo);
					break;
				case WqConstant.ROW_TYPE_DELETED:
					// 삭제를 수행합니다.
					deleteRowCnt += ecsCommonDao.delete("TC_ECS_CD_Dao_deleteCmmnCdList", cmmnCdVo);
					break;
				default:
					break;
				}
			}
		}

		return insertRowCnt + updateRowCnt + deleteRowCnt;
	}

	/**
	 * 공통코드 데이터 .변경 이력을 남긴다.
	 * 
	 * @param cmmnCdList
	 * @return int
	 * @throws Exception
	 */
	public int saveCmmnCdHist(List<CmmnCdVo> cmmnCdList) {
		int insertRowCnt = 0;

		CmmnCdVo cmmnCdVo = new CmmnCdVo();
		for (int idx = 0; idx < cmmnCdList.size(); idx++) {
			cmmnCdVo = cmmnCdList.get(idx);

			/*
			 * 2017. 12. 7. 60003256 강만석. 시큐어코딩 조치 if ( cmmnCdVo.getFrstYn() !=
			 * "Y" ) {
			 */
			if (!"Y".equals(cmmnCdVo.getFrstYn())) {
				insertRowCnt += commonDao.insert("TH_SC_CD_HIST_Dao_insertCmmnCdHist", cmmnCdVo);
			}
		}

		return insertRowCnt;
	}

	/**
	 * 문서분류 코드를 조회한다.
	 * 
	 * @param docClsCdVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map> retrieveDocClsCd(DocClsCdVo docClsCdVo) {
		return (List) ecsCommonDao.selectList("TC_ECS_DOC_CLS_CD_Dao_retrieveDocClCd", docClsCdVo);
	}

	/**
	 * 오라클 암호화 함수 호출을 하여 암호화값 조회한v다.
	 * 
	 * @param map
	 * @return map
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public Map selectDataEnc(Map param) {
		return ecsCommonDao.select("TC_ECS_CD_Dao_selectDataEnc", param);
	}

	/**
	 * 카테고리를 조회한다.
	 * 
	 * @param CtgryVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveCtgry(CtgryVo ctgryVo) {
		return ecsCommonDao.selectList("TC_ECS_CTG_Dao_retrieveCtgry", ctgryVo);
	}

	/**
	 * 인사뷰에서 부서정보를 조회한다.
	 * 
	 * @param deptCdVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveDeptInqire(Map param) {
		return (List) ecsCommonDao.selectList("VM_HR01A01_Dao_retrieveDeptInqire", param);
	}

	/**
	 * 인사뷰에서 2차 깊이의 부서정보를 조회한다.
	 * 
	 * @param deptCdVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveDept2Inqire(Map param) {
		return (List) ecsCommonDao.selectList("VM_HR01A01_Dao_retrieveDept2Inqire", param);
	}

	/**
	 * 인사뷰(VM_RS174)에서 정보를 조회한다.
	 * 
	 * @param HrmVmRs174Vo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveVmRs174Data(HrmVmRs174Vo hrmVmRs174Vo) {
		return (List) ecsCommonDao.selectList("VM_RS174_Dao_retrieveVmRs174Data", hrmVmRs174Vo);
	}

	/**
	 * 인사뷰(VM_RS175)에서 정보를 조회한다.
	 * 
	 * @param HrmVmRs175Vo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> retrieveVmRs175Data(HrmVmRs175Vo hrmVmRs175Vo) {
		return (List) ecsCommonDao.selectList("VM_RS175_Dao_retrieveVmRs175Data", hrmVmRs175Vo);
	}
}
