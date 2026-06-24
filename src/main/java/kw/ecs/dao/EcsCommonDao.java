/**
 *
 */
package kw.ecs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.session.ExecutorType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import kw.fw.defaults.DefaultConsts;
import kw.fw.defaults.DefaultVo;
import kw.fw.util.RequestContextUtil;

/**
 * EcsCommonDao 클래스
 * 
 * @ClassName EcsCommonDao.java
 * @Description 공통 Dao 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2017.07.20		60002841(권영훈)			최초생성
 * 2023.01.16		Soltech 김유빈			ECS로 마이그레이션
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 01. 16
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings({ "unchecked" })
public class EcsCommonDao extends EgovAbstractMapper {

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
	public <T> T select(String queryId) {
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
	 * UPDATE 쿼리를 실행하고 처리 건수를 int 값으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @param parameter
	 *            Input parameter 객체
	 * @excuteRow 묶어서 처리할 행수(0이면 제한 없음)
	 */
	public void updateBulk(String queryId, Object parameter) {
		updateBulk(queryId, parameter, 1000);
	}

	/**
	 * UPDATE 쿼리를 실행하고 처리 건수를 int 값으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @param parameter
	 *            Input parameter 객체
	 * @excuteRow 묶어서 처리할 행수(0이면 제한 없음)
	 */
	// public void updateBulk(String queryId,List<Object> list,int excuteRow) {
	public void updateBulk(String queryId, Object parameter, int excuteRow) {
		List<Object> list = (List<Object>) parameter;
		setThreadLocalValueBulk(list);
		// setThreadLocalValue(parameter);
		// SqlSessionTemplate sqlSessionbath =
		// sqlSession.getSqlSessionFactory().openSession(ExecutorType.BATCH);
		// org.mybatis.spring.SqlSessionFactoryBean sf =
		// sqlSession.getSqlSessionFactory();
		org.apache.ibatis.session.SqlSession sqlSessionbath = sqlSession.getSqlSessionFactory()
				.openSession(ExecutorType.BATCH);
		if (list != null) {
			if (excuteRow == 0) {
				for (Object obj : list) {
					sqlSessionbath.update(queryId, obj);
				}
			} else {
				int tmpi = 0;
				for (Object obj : list) {
					if (tmpi > excuteRow - 1) {
						sqlSessionbath.flushStatements();
						sqlSessionbath.commit();
						tmpi = 0;
					}
					sqlSessionbath.update(queryId, obj);
					tmpi++;

				}
				sqlSessionbath.flushStatements();
				sqlSessionbath.commit();
			}
		}
	}

	/**
	 * UPDATE 쿼리를 실행하고 처리 건수를 int 값으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @param parameter
	 *            Input parameter 객체
	 * @excuteRow 묶어서 처리할 행수(0이면 제한 없음)
	 */
	public void insertBulk(String queryId, Object parameter) {
		insertBulk(queryId, parameter, 1000);
	}

	/**
	 * UPDATE 쿼리를 실행하고 처리 건수를 int 값으로 반환한다.
	 *
	 * @param queryId
	 *            실행할 Query의 ID
	 * @param parameter
	 *            Input parameter 객체
	 * @excuteRow 묶어서 처리할 행수(0이면 제한 없음)
	 */
	// public void updateBulk(String queryId,List<Object> list,int excuteRow) {
	public void insertBulk(String queryId, Object parameter, int excuteRow) {
		List<Object> list = (List<Object>) parameter;
		setThreadLocalValueBulk(list);
		// setThreadLocalValue(parameter);
		// SqlSessionTemplate sqlSessionbath =
		// sqlSession.getSqlSessionFactory().openSession(ExecutorType.BATCH);
		// org.mybatis.spring.SqlSessionFactoryBean sf =
		// sqlSession.getSqlSessionFactory();
		org.apache.ibatis.session.SqlSession sqlSessionbath = sqlSession.getSqlSessionFactory()
				.openSession(ExecutorType.BATCH);
		if (list != null) {
			if (excuteRow == 0) {
				for (Object obj : list) {
					sqlSessionbath.insert(queryId, obj);
				}
			} else {
				int tmpi = 0;
				for (Object obj : list) {
					if (tmpi > excuteRow - 1) {
						sqlSessionbath.flushStatements();
						sqlSessionbath.commit();
						tmpi = 0;
					}
					sqlSessionbath.insert(queryId, obj);
					tmpi++;

				}
				sqlSessionbath.flushStatements();
				sqlSessionbath.commit();
			}
		}
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
	private void setThreadLocalValueBulk(List<Object> bindParams) {

		// 세션 자동만료 등 CurrentRequest가 없는 경우 아래 로직에서 에러가 발생하므로 리턴 처리
		if (!RequestContextUtil.isCurrentRequestEnabled()) {
			return;
		}

		if (bindParams != null) {
			if (bindParams.size() < 1) {
				return;
			}
			String p_RgstrId = (String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_USR_ID);
			String p_RgstrIp = (String) RequestContextUtil.get(DefaultConsts.THREAD_LOCAL_CONECT_IP);
			if (bindParams.get(0) instanceof Map) {
				for (Object m_map : bindParams) {
					((Map) m_map).put("frstRgstrId", p_RgstrId);
					((Map) m_map).put("frstRgstrIp", p_RgstrIp);
					// 최초나 최종 둘중 하나만 가지고 Update 혹은 Insert처리하면 됨
					// ((Map)m_map).put("lastUpdusrId", p_RgstrId);
					// ((Map)m_map).put("lastUpdusrIp", p_RgstrIp);
				}
			} else {
				for (Object m_map : bindParams) {
					((DefaultVo) m_map).setFrstRgstrId(p_RgstrId);
					((DefaultVo) m_map).setFrstRgstrIp(p_RgstrIp);
					// 최초나 최종 둘중 하나만 가지고 Update 혹은 Insert처리하면 됨
					// ((DefaultVo)m_map).setLastUpdusrId(p_RgstrId);
					// ((DefaultVo)m_map).setLastUpdusrIp(p_RgstrId);
				}
			}
		}
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
