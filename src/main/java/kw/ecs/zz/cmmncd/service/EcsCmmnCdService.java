package kw.ecs.zz.cmmncd.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import kw.ecs.zz.cmmncd.vo.ClsCdVo;
import kw.ecs.zz.cmmncd.vo.CmmnCdVo;
import kw.ecs.zz.cmmncd.vo.CtgryVo;
import kw.ecs.zz.cmmncd.vo.DocClsCdVo;
import kw.ecs.zz.cmmncd.vo.HrmVmRs174Vo;
import kw.ecs.zz.cmmncd.vo.HrmVmRs175Vo;
import kw.ecs.zz.cmmncd.vo.MenuListVo;
import kw.ecs.zz.cmmncd.vo.ScrinListVo;
import kw.ecs.zz.cmmncd.vo.UsrListVo;

/**
 * EcsCmmnCdService 서비스 인터페이스 클래스
 * 
 * @ClassName EcsCmmnCdService.java
 * @Description 공통코드 서비스 인터페이스 클래스
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
public interface EcsCmmnCdService {

	/**
	 * 공통분류코드 및 공통코드를 조회한다.
	 * 
	 * @param list
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveClsCdCmmnCd(List list);

	/**
	 * 메뉴정보를 조회한다.
	 * 
	 * @param menuListVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveMenu(MenuListVo menuListVo);

	/**
	 * 화면정보를 조회한다.
	 * 
	 * @param scrinListVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getScrinSearch(ScrinListVo scrinListVo);

	/**
	 * 사용자정보를 조회한다.
	 * 
	 * @param usrListVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveUsrInqire(UsrListVo usrListVo);

	/**
	 * 공통분류코드를 조회한다.
	 * 
	 * @param clCdVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveClsCd(ClsCdVo clsCdVo);

	/**
	 * 공통코드를 조회한다.
	 * 
	 * @param cmmnCdVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveCmmnCd(CmmnCdVo cmmnCdVo);

	/**
	 * 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param clCdList
	 * @param cmmnCdList
	 * @return ModelAndView
	 * @throws Exception
	 */
	public ModelAndView saveClCmmnCdList(List<ClsCdVo> clsCdList, List<CmmnCdVo> cmmnCdList);

	/**
	 * 문서분류코드를 조회한다.
	 * 
	 * @param docClsCdVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveDocClsCd(DocClsCdVo docClsCdVo);

	/**
	 * 카테고리를 조회한다.
	 * 
	 * @param CtgryVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveCtgry(CtgryVo ctgryVo);

	/**
	 * 오라클 암호화 함수 호출을 하여 암호화값 조회한다.
	 * 
	 * @param map
	 * @return Map
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Map selectDataEnc(Map param);

	/**
	 * 인사뷰에서 부서정보를 조회한다.
	 * 
	 * @param deptCdVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveDeptInqire(Map param);

	/**
	 * 인사뷰에서 2차 깊이의 부서정보를 조회한다.
	 * 
	 * @param deptCdVo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveDept2Inqire(Map param);

	/**
	 * 인사뷰(VM_RS174)에서 정보를 조회한다.
	 * 
	 * @param HrmVmRs174Vo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveVmRs174Data(HrmVmRs174Vo hrmVmRs174Vo);

	/**
	 * 인사뷰(VM_RS175)에서 정보를 조회한다.
	 * 
	 * @param HrmVmRs175Vo
	 * @return List<Map>
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> retrieveVmRs175Data(HrmVmRs175Vo hrmVmRs175Vo);
}
