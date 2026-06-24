package kw.ecs.zz.authmng.service;

import java.util.List;
import java.util.Map;

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
import kw.scm.sc.cmmncd.vo.UsrListVo;

/**
 * EcsAuthorityService 서비스 인터페이스 클래스
 * 
 * @ClassName EcsAuthorityService.java
 * @Description 권한 서비스 인터페이스 클래스
 * @Modification-Information 수정일 수정자 수정내용 ---------- ----------
 *                           ------------------------------- 2017. 3. 1. Soft
 *                           Arch 최초생성 2017. 6. 14. yc.j 대내권한관리 생성
 * 
 * @author K-water 업무시스템 혁신사업 : Soft Arch 아무개
 * @since 2017. 3. 1.
 * @version 1.0
 * @see
 * 
 * 		Copyright (C) 2017 by Unlimited K-water, All right reserved.
 */
@SuppressWarnings("rawtypes")
public interface EcsAuthorityService {
	/**
	 * 권한 데이터를 조회한다.
	 * 
	 * @param param
	 * @return
	 */
	public List<Map> getAuthorityList(Map param) throws Exception;

	/**
	 * 여러 건의 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 *            Client 전달한 데이터 맵 객체
	 */
	public void saveAuthorityList(List<AuthorityVo> authorityList) throws Exception;

	/**
	 * 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param sqlSession
	 * @param data
	 *            데이터 맵 객체
	 */
	public void saveAuthority(AuthorityVo authorityVo) throws Exception;

	/**
	 * 메뉴별 권한 데이터를 조회한다.
	 * 
	 * @param param
	 * @return
	 */
	public List<Map> getAuthorityMenuList(Map param) throws Exception;

	/**
	 * 여러 건의 메뉴 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 *            Client 전달한 데이터 맵 객체
	 */
	public void saveAuthorityMenuList(List<AuthorityMenuVo> authorityMenuList) throws Exception;

	/**
	 * 메뉴 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param sqlSession
	 * @param data
	 *            데이터 맵 객체
	 */
	public void saveAuthorityMenu(AuthorityMenuVo authorityMenuVo) throws Exception;

	/**
	 * 권한별 사원 데이터를 조회한다.
	 * 
	 * @param param
	 * @return
	 */
	public List<Map> getPersonAuthorityList(Map param) throws Exception;

	/**
	 * 여러 건의 권한별 사원 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param param
	 *            Client 전달한 데이터 맵 객체
	 */
	public void savePersonAuthorityList(List<PersonAuthorityVo> personAuthorityList) throws Exception;

	/**
	 * 권한별 사원 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param sqlSession
	 * @param data
	 *            데이터 맵 객체
	 */
	public void savePersonAuthority(PersonAuthorityVo personAuthorityVo) throws Exception;

	/**
	 * 권한 데이터를 조회한다.
	 * 
	 * @param athrGrpMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveAthr(AthrGrpMngVo athrGrpMngVo) throws Exception;

	/**
	 * 권한 데이터를 조회한다.
	 * 
	 * @param athrGrpMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveAthrEcs(AthrGrpMngVo athrGrpMngVo) throws Exception;

	/**
	 * 권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param athrGrpMngVo
	 * @return
	 * @throws Exception
	 */
	// public void saveAthrMng(List<AthrGrpMngVo> athrGrpMngVo);
	public void saveAthrMngList(List<AthrGrpMngVo> athrGrpMngVo, List<IntnAthrMenuVo> intnAthrMenuVo,
			List<UsrAthrGrpMngVo> usrAthrGrpMngList) throws Exception;

	/**
	 * 권한등록 정보조회를 수행합니다.
	 * 
	 * @param athrGrpMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public Map selectAthrUse(AthrGrpMngVo athrGrpMngVo) throws Exception;

	/**
	 * 화면 데이터를 조회한다.
	 * 
	 * @param scrinMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveScrin(ScrinMngVo scrinMngVo) throws Exception;

	/**
	 * 도움말 정보를 조회합니다.
	 * 
	 * @param scrinMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveHpcm(ScrinMngVo scrinMngVo) throws Exception;

	/**
	 * 화면등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param scrinMngVo
	 * @return
	 * @throws Exception
	 */
	public void saveScrinMng(ScrinMngVo scrinMngVo) throws Exception;

	/**
	 * 화면 메뉴설정 정보조회를 수행합니다.
	 * 
	 * @param scrinMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> selectScrinInfo(ScrinMngVo scrinMngVo) throws Exception;

	/**
	 * 메뉴 데이터를 조회한다.
	 * 
	 * @param menuMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveMenu(MenuMngVo menuMngVo) throws Exception;

	/**
	 * 메뉴등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param menuMngVo
	 * @return
	 * @throws Exception
	 */
	public void saveMenuMng(MenuMngVo menuMngVo) throws Exception;

	/**
	 * 메뉴설정 정보조회를 수행합니다.
	 * 
	 * @param menuMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public Map selectMenuUse(MenuMngVo menuMngVo) throws Exception;

	/**
	 * 권한한별메뉴관리에서 권한그룹 조회를 수행합니다.
	 * 
	 * @param athrGrpMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveAthrGrp(AthrGrpMngVo athrGrpMngVo) throws Exception;

	/**
	 * 사용자별권한관리에서 사용자 권한부여현황 조회를 수행합니다.
	 * 
	 * @param usrAthrGrpMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retriebeUsrAthrGrp(UsrAthrGrpMngVo usrAthrGrpMngVo) throws Exception;

	/**
	 * 사용자별권한관리에서 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param usrAthrGrpMngList
	 * @return
	 * @throws Exception
	 */
	public void saveUsrAthrGrpMngList(List<UsrAthrGrpMngVo> usrAthrGrpMngList) throws Exception;

	/**
	 * 메뉴등록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param menuMngList
	 * @return
	 * @throws Exception
	 */
	public void saveMenuMngList(List<MenuMngVo> menuMngList) throws Exception;

	/**
	 * 화면별버튼권한
	 * 
	 * @param menuMngList
	 * @return Map
	 * @throws Exception
	 */
	public Map selectPgmAuth(Map param) throws Exception;

	/**
	 * 자신에게 부여된 권한관련 시스템구분코드를 조회한다.
	 * 
	 * @param param
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveAthrSysDivCd(Map para) throws Exception;

	/**
	 * 권한그룹별메뉴목록을 조회한다.
	 * 
	 * @param intnAthrMenuVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveIntnAthrMenu(IntnAthrMenuVo intnAthrMenuVo) throws Exception;

	/**
	 * 권한그룹별메뉴목록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param intnAthrMenuVo
	 * @return
	 * @throws Exception
	 */
	public void saveIntnAthrMenu(List<IntnAthrMenuVo> intnAthrMenuVo) throws Exception;

	/**
	 * 사용자별 메뉴접속권한 목록을 조회한다. 게시물 통합검색에서 사용자가 게시물 메뉴의 접근 권한 여부를 조회할 때 사용한다.
	 * 
	 * @param intnAthrMenuVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveUsrMenuAthr(IntnAthrMenuVo intnAthrMenuVo) throws Exception;

	/**
	 * 사용자별메뉴관리에서 사용자정보 조회를 수행합니다.
	 * 
	 * @param usrListVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveUsr(UsrListVo usrListVo) throws Exception;

	/**
	 * 사용자별메뉴목록을 조회한다.
	 * 
	 * @param intnUsrMenuVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveIntnUsrMenu(IntnUsrMenuVo intnUsrMenuVo) throws Exception;

	/**
	 * 사용자별메뉴목록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param intnUsrMenuVo
	 * @return
	 * @throws Exception
	 */
	public void saveIntnUsrMenu(List<IntnUsrMenuVo> intnUsrMenuVo) throws Exception;

	/**
	 * 사용자별시스템구분목록을 조회한다.
	 * 
	 * @param intnUsrMenuVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveUsrSysAthr(UsrSysAthrVo usrSysAthrVo) throws Exception;

	/**
	 * 사용자별시스템구분목록 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param intnUsrMenuVo
	 * @return
	 * @throws Exception
	 */
	public void saveUsrSysAthr(List<UsrSysAthrVo> usrSysAthrVo) throws Exception;

	/**
	 * 사용자별권한그룹조회를 한다.
	 * 
	 * @param usrAthrRqstVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveUsrAthrRqst(UsrAthrRqstVo usrAthrRqstVo) throws Exception;

	/**
	 * 사용자별권한그룹조회를 한다.(관리자)
	 * 
	 * @param usrAthrRqstVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveUsrAthrRqstAdmin(UsrAthrRqstVo usrAthrRqstVo) throws Exception;

	/**
	 * 사용자권한신청 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param usrAthrRqstVo
	 * @return
	 * @throws Exception
	 */
	public void saveUsrAthrRqst(List<UsrAthrRqstVo> usrAthrRqstVo) throws Exception;

	/**
	 * 통합권한신청 데이터를 등록한다.
	 * 
	 * @param usrAthrRqstVo
	 * @return
	 * @throws Exception
	 */
	public void insertUsrAthrRqst(UsrAthrRqstVo usrAthrRqstVo) throws Exception;

	/**
	 * 통합권한신청 상태를 업데이트한다.
	 * 
	 * @param athrRqstList
	 *            통합권한신청상세 객체
	 * @return
	 * @throws Exception
	 */
	public void transferUnifAthrRqst(Map unifAthrRqstDtlList) throws Exception;

	/**
	 * 사용자별권한그룹 사용여부 조회를 한다.
	 * 
	 * @param usrAthrRqstVo
	 * @return Map
	 * @throws Exception
	 */
	public Map selectUsrAthrUse(UsrAthrRqstVo usrAthrRqstVo) throws Exception;

	/**
	 * 사용자 자신에게 부여된 권한만 조회
	 * 
	 * @param usrAthrGrpMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveUsrAthr(UsrAthrRqstVo usrAthrRqstVo) throws Exception;

	/**
	 * 해당 시스템으로 설정된 대내화면버튼권한정보 조회
	 * 
	 * @param btnArthVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public List<Map> retrieveBtnInfo(BtnAthrVo btnAthrVo) throws Exception;

	/**
	 * 해당 시스템으로 사용중인 대내화면버튼권한정보 조회
	 * 
	 * @param scrinBtnVo
	 * @return Map
	 * @throws Exception
	 */
	public Map selectScrinBtnUse(ScrinBtnVo scrinBtnVo) throws Exception;

	/**
	 * 대내화면버튼권한 데이터 목록을 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param dltScrinBtn
	 * @return
	 * @throws Exception
	 */
	public void saveScrinBtnList(List<ScrinBtnVo> dltScrinBtn) throws Exception;

	/**
	 * 대내화면버튼권한 데이터를 변경(등록, 수정, 삭제)한다.
	 * 
	 * @param scrinBtnVo
	 * @return
	 * @throws Exception
	 */
	public void saveScrinBtn(ScrinBtnVo scrinBtnVo) throws Exception;

	/**
	 * 화면의 조건정보조회를 수행합니다.
	 * 
	 * @param scrinMngVo
	 * @return List<Map>
	 * @throws Exception
	 */
	public Map selectScrinConditionInfo(Map paramMap) throws Exception;

	/**
	 * 인코딩된 사원번호와 페이지/메뉴정보를 조회한다.
	 * 
	 * @param scrinMngVo
	 * @return Map
	 * @throws Exception
	 */
	public Map selectLnkSys(ScrinMngVo scrinMngVo);
}