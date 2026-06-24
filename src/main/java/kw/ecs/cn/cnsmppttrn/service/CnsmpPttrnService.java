package kw.ecs.cn.cnsmppttrn.service;

import java.util.List;
import java.util.Map;

import kw.ecs.cn.cnsmppttrn.vo.CnsmpPttrnVo;

/**
 * CnsmpPttrnService 서비스 인터페이스
 * 
 * @ClassName CnsmpPttrnService.java
 * @Description 소비 - 사업장 소비패턴 분석현황 클래스
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.15		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 15
 * @version 1.0
 * @see
 * 
 *      <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *      </pre>
 */
@SuppressWarnings("rawtypes")
public interface CnsmpPttrnService {
	/**
	 * 소비의 사업장 소비패턴 분석현황 목록을 조회한다.
	 * 
	 * @param @CnsmpPttrnVo
	 * @return list 데이터 맵 리스트 객체
	 * @throws Exception
	 */
	public List<Map> retrieveCnsmpPttrnList(CnsmpPttrnVo cnsmpPttrnVo) throws Exception;
}