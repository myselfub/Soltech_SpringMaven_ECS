package kw.ecs.dao;

import java.util.List;
import java.util.Map;

import kw.fw.defaults.DefaultConsts;
import kw.fw.defaults.DefaultVo;
import kw.fw.util.RequestContextUtil;

import org.apache.ibatis.annotations.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * ObasinCommonDao 클래스
 * 
 * @ClassName ObasinCommonDao.java
 * @Description ObasinCommonDao.java Class
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.09.06		60002958				최초생성
 * 2023.01.16		Soltech 김유빈			ECS로 마이그레이션
 *                           </pre>
 * 
 * @author K-water 업무시스템 혁신사업 : 수자원통합 60002958
 * @since 2023. 01. 16
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings({ "unchecked" })
public class ObasinCommonDao extends EgovAbstractMapper {

	private SqlSessionTemplate sqlSession;

	protected Logger log = LogManager.getLogger(this.getClass());

	/**
	 * SELECT 쿼리를 실행하고 결과를 단건으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @return 조회된 단건 데이터
	 */
	@Options(flushCache = true)
	public <T> T select(String queryId) throws Exception {
		return (T) sqlSession.selectOne(queryId);
	}

	/**
	 * SELECT 쿼리를 실행하고 결과를 단건으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @param parameter
	 *            Input parameter 객체
	 * @return 조회된 단건 데이터
	 */
	@Options(flushCache = true)
	public <T> T select(String queryId, Object parameter) {
		setThreadLocalValue(parameter);
		return (T) sqlSession.selectOne(queryId, parameter);
	}

	/**
	 * SELECT 쿼리를 실행하고 결과를 List로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @return 조회된 목록 데이터
	 */
	@Options(flushCache = true)
	public <E> List<E> selectList(String queryId) {
		return (List<E>) sqlSession.selectList(queryId);
	}

	/**
	 * SELECT 쿼리를 실행하고 결과를 List로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @param parameter
	 *            Input parameter 객체
	 * @param rowBounds
	 *            특정 범위의 데이터만 조회하기 위한 범위 설정 객체
	 * @return 조회된 목록 데이터
	 */
	@Options(flushCache = true)
	public <E> List<E> selectList(String queryId, Object parameter) {
		return (List<E>) sqlSession.selectList(queryId, parameter);
	}

	/**
	 * INSERT 쿼리를 실행하고 처리 건수를 int 값으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @return 처리 건수
	 */
	public int insert(String queryId) {
		return sqlSession.insert(queryId);
	}

	/**
	 * INSERT 쿼리를 실행하고 처리 건수를 int 값으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @param parameter
	 *            Input parameter 객체
	 * @return 처리 건수
	 */
	public int insert(String queryId, Object parameter) {
		setThreadLocalValue(parameter);
		return sqlSession.insert(queryId, parameter);
	}

	/**
	 * UPDATE 쿼리를 실행하고 처리 건수를 int 값으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @param parameter
	 *            Input parameter 객체
	 * @return 처리 건수
	 */
	public int update(String queryId) {
		return sqlSession.update(queryId);
	}

	/**
	 * UPDATE 쿼리를 실행하고 처리 건수를 int 값으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @param parameter
	 *            Input parameter 객체
	 * @return 처리 건수
	 */
	public int update(String queryId, Object parameter) {
		setThreadLocalValue(parameter);
		return sqlSession.update(queryId, parameter);
	}

	/**
	 * DELETE 쿼리를 실행하고 처리 건수를 int 값으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @return 처리 건수
	 */
	public int delete(String queryId) {
		return sqlSession.delete(queryId);
	}

	/**
	 * DELETE 쿼리를 실행하고 처리 건수를 int 값으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @param parameter
	 *            Input parameter 객체
	 * @return 처리 건수
	 */
	public int delete(String queryId, Object parameter) {
		setThreadLocalValue(parameter);
		return sqlSession.delete(queryId, parameter);
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	/**
	 * ThreadLocal 값을 쿼리 바인딩 파라미터로 전달하기 위해 설정한다.
	 *
	 * @param bindParams
	 *            VO/Map형태의 바인딩 파라미터 객체
	 */
	@SuppressWarnings({ "rawtypes" })
	private void setThreadLocalValue(Object bindParams) {

		// 세션 자동만료 등 CurrentRequest가 없는 경우 아래 로직에서 에러가 발생하므로 리턴 처리
		if (!RequestContextUtil.isCurrentRequestEnabled()) {
			return;
		}

		if (bindParams != null) {
			if (bindParams instanceof Map) {
				((Map) bindParams).put("frstRgstrId",
						(String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID));
				((Map) bindParams).put("lastUpdusrId",
						(String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID));
				((Map) bindParams).put("frstRgstrIp",
						(String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_CONECT_IP));
				((Map) bindParams).put("lastUpdusrIp",
						(String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_CONECT_IP));

			} else {
				((DefaultVo) bindParams)
						.setFrstRgstrId((String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID));
				((DefaultVo) bindParams)
						.setLastUpdusrId((String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID));
				((DefaultVo) bindParams)
						.setFrstRgstrIp((String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_CONECT_IP));
				((DefaultVo) bindParams)
						.setLastUpdusrIp((String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_CONECT_IP));
			}
		}
	}

}
