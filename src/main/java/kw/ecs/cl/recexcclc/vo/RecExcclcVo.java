package kw.ecs.cl.recexcclc.vo;

import kw.ecs.common.vo.ECSDefaultVo;

/**
 * 정산 - REC 정산 VO
 * 
 * @ClassName RecExcclcVo.java
 * @Description REC 정산 VO
 * @Modification_Information
 * 
 *                           <pre>
 *	수정일					수정자						수정내용
 * ------------		-----------------		-------------------------------
 * 2023.03.17		Soltech 김유빈			최초생성
 *                           </pre>
 * 
 * @author Soltech 김유빈
 * @since 2023. 03. 17
 * @version 1.0
 * 
 *          <pre>
 * Copyright (C) 2023 by Unlimited K-water, All right reserved.
 *          </pre>
 */
public class RecExcclcVo extends ECSDefaultVo {
	private static final long serialVersionUID = 6518471270171893758L;

	/** REC거래년도(거래연도) (NOT NULL) */
	private String recDelngYear = "";
	/** REC거래월 (NOT NULL) */
	private String recDelngMt = "";
	/** REC설비코드명(발전소) (NOT NULL) */
	private String recEqpCdNm = "";
	/** 수정사유 - updtRsn(SUPER) */
	/* ----- 태양광 ----- */
	/** REC정산제출량 */
	private String recExcclcSbmtQy;
	/** REC정산1차금액 */
	private String recExcclcTm1sAmt;
	/** REC정산2차금액 */
	private String recExcclcTm2sAmt;
	/** REC정산3차금액 */
	private String recExcclcTm3sAmt;
	/** REC정산4차금액 */
	private String recExcclcTm4sAmt;
	/** REC회계기준금액 */
	private String recAccnutSnrn;
	/* ----- 비태양광 ----- */
	/** REC정산량(수량) */
	private String recExcclcQy;
	/** REC정산단가(단가) */
	private String recExcclcUpc;
	/** REC정산총액(총액) */
	private String recExcclcTamt;

	/* ----- 조회조건 ----- */
	/** 조회연도 - strtDt(SUPER) */
	/** ECS유역구분코드(유역) - ecsBasinDivCd(SUPER) */
	/** ECS발전원구분코드(발전원) - ecsSetcscDivCd(SUPER) */
	/** ECS발전소구분코드(발전소) - ecsElcpwstnDivCd(SUPER) */

	/* ----- 조회결과 ----- */
	/** 발전소명 - elcpwstnNm */
	/** 1월 제출수량(1월 - 제출수량(REC)) - mon01SbmtQy */
	/** 1월 1차(1월 - 1차(원)) - mon01Tm1sAmt */
	/** 1월 2차(1월 - 2차(원)) - mon01Tm2sAmt */
	/** 1월 3차(1월 - 3차(원)) - mon01Tm3sAmt */
	/** 1월 4차(1월 - 4차(원)) - mon01Tm4sAmt */
	/** 1월 회계기준(1월 - 회계기준(원)) - mon01AccnutSnrn */
	/** 2월 제출수량(2월 - 제출수량(REC)) - mon02SbmtQy */
	/** 2월 1차(2월 - 1차(원)) - mon02Tm1sAmt */
	/** 2월 2차(2월 - 2차(원)) - mon02Tm2sAmt */
	/** 2월 3차(2월 - 3차(원)) - mon02Tm3sAmt */
	/** 2월 4차(2월 - 4차(원)) - mon02Tm4sAmt */
	/** 2월 회계기준(2월 - 회계기준(원)) - mon02AccnutSnrn */
	/** 3월 제출수량(3월 - 제출수량(REC)) - mon03SbmtQy */
	/** 3월 1차(3월 - 1차(원)) - mon03Tm1sAmt */
	/** 3월 2차(3월 - 2차(원)) - mon03Tm2sAmt */
	/** 3월 3차(3월 - 3차(원)) - mon03Tm3sAmt */
	/** 3월 4차(3월 - 4차(원)) - mon03Tm4sAmt */
	/** 3월 회계기준(3월 - 회계기준(원)) - mon03AccnutSnrn */
	/** 4월 제출수량(4월 - 제출수량(REC)) - mon04SbmtQy */
	/** 4월 1차(4월 - 1차(원)) - mon04Tm1sAmt */
	/** 4월 2차(4월 - 2차(원)) - mon04Tm2sAmt */
	/** 4월 3차(4월 - 3차(원)) - mon04Tm3sAmt */
	/** 4월 4차(4월 - 4차(원)) - mon04Tm4sAmt */
	/** 4월 회계기준(4월 - 회계기준(원)) - mon04AccnutSnrn */
	/** 5월 제출수량(5월 - 제출수량(REC)) - mon05SbmtQy */
	/** 5월 1차(5월 - 1차(원)) - mon05Tm1sAmt */
	/** 5월 2차(5월 - 2차(원)) - mon05Tm2sAmt */
	/** 5월 3차(5월 - 3차(원)) - mon05Tm3sAmt */
	/** 5월 4차(5월 - 4차(원)) - mon05Tm4sAmt */
	/** 5월 회계기준(5월 - 회계기준(원)) - mon05AccnutSnrn */
	/** 6월 제출수량(6월 - 제출수량(REC)) - mon06SbmtQy */
	/** 6월 1차(6월 - 1차(원)) - mon06Tm1sAmt */
	/** 6월 2차(6월 - 2차(원)) - mon06Tm2sAmt */
	/** 6월 3차(6월 - 3차(원)) - mon06Tm3sAmt */
	/** 6월 4차(6월 - 4차(원)) - mon06Tm4sAmt */
	/** 6월 회계기준(6월 - 회계기준(원)) - mon06AccnutSnrn */
	/** 7월 제출수량(7월 - 제출수량(REC)) - mon07SbmtQy */
	/** 7월 1차(7월 - 1차(원)) - mon07Tm1sAmt */
	/** 7월 2차(7월 - 2차(원)) - mon07Tm2sAmt */
	/** 7월 3차(7월 - 3차(원)) - mon07Tm3sAmt */
	/** 7월 4차(7월 - 4차(원)) - mon07Tm4sAmt */
	/** 7월 회계기준(7월 - 회계기준(원)) - mon07AccnutSnrn */
	/** 8월 제출수량(8월 - 제출수량(REC)) - mon08SbmtQy */
	/** 8월 1차(8월 - 1차(원)) - mon08Tm1sAmt */
	/** 8월 2차(8월 - 2차(원)) - mon08Tm2sAmt */
	/** 8월 3차(8월 - 3차(원)) - mon08Tm3sAmt */
	/** 8월 4차(8월 - 4차(원)) - mon08Tm4sAmt */
	/** 8월 회계기준(8월 - 회계기준(원)) - mon08AccnutSnrn */
	/** 9월 제출수량(9월 - 제출수량(REC)) - mon0SbmtQy */
	/** 9월 1차(9월 - 1차(원)) - mon09Tm1sAmt */
	/** 9월 2차(9월 - 2차(원)) - mon09Tm2sAmt */
	/** 9월 3차(9월 - 3차(원)) - mon09Tm3sAmt */
	/** 9월 4차(9월 - 4차(원)) - mon09Tm4sAmt */
	/** 9월 회계기준(9월 - 회계기준(원)) - mon09AccnutSnrn */
	/** 10월 제출수량(10월 - 제출수량(REC)) - mon10SbmtQy */
	/** 10월 1차(10월 - 1차(원)) - mon10Tm1sAmt */
	/** 10월 2차(10월 - 2차(원)) - mon10Tm2sAmt */
	/** 10월 3차(10월 - 3차(원)) - mon10Tm3sAmt */
	/** 10월 4차(10월 - 4차(원)) - mon10Tm4sAmt */
	/** 10월 회계기준(10월 - 회계기준(원)) - mon10AccnutSnrn */
	/** 11월 제출수량(11월 - 제출수량(REC)) - mon11SbmtQy */
	/** 11월 1차(11월 - 1차(원)) - mon11Tm1sAmt */
	/** 11월 2차(11월 - 2차(원)) - mon11Tm2sAmt */
	/** 11월 3차(11월 - 3차(원)) - mon11Tm3sAmt */
	/** 11월 4차(11월 - 4차(원)) - mon11Tm4sAmt */
	/** 11월 회계기준(11월 - 회계기준(원)) - mon11AccnutSnrn */
	/** 12월 제출수량(12월 - 제출수량(REC)) - mon12SbmtQy */
	/** 12월 1차(12월 - 1차(원)) - mon12Tm1sAmt */
	/** 12월 2차(12월 - 2차(원)) - mon12Tm2sAmt */
	/** 12월 3차(12월 - 3차(원)) - mon12Tm3sAmt */
	/** 12월 4차(12월 - 4차(원)) - mon12Tm4sAmt */
	/** 12월 회계기준(12월 - 회계기준(원)) - mon12AccnutSnrn */
	/** 총량(총계 - 수량) - totqy */
	/** 총액(총계 - 금액(원)) - tamt */

	/** 1월 수량(1월 - REC 거래량) - mon01Qy */
	/** 1월 단가(1월 - 평균가) - mon01Upc */
	/** 1월 총액(1월 - 판매 총액) - mon01Tamt */
	/** 2월 수량(2월 - REC 거래량) - mon02Qy */
	/** 2월 단가(2월 - 평균가) - mon02Upc */
	/** 2월 총액(2월 - 판매 총액) - mon02Tamt */
	/** 3월 수량(3월 - REC 거래량) - mon03Qy */
	/** 3월 단가(3월 - 평균가) - mon03Upc */
	/** 3월 총액(3월 - 판매 총액) - mon03Tamt */
	/** 4월 수량(4월 - REC 거래량) - mon04Qy */
	/** 4월 단가(4월 - 평균가) - mon04Upc */
	/** 4월 총액(4월 - 판매 총액) - mon04Tamt */
	/** 5월 수량(5월 - REC 거래량) - mon05Qy */
	/** 5월 단가(5월 - 평균가) - mon05Upc */
	/** 5월 총액(5월 - 판매 총액) - mon05Tamt */
	/** 6월 수량(6월 - REC 거래량) - mon06Qy */
	/** 6월 단가(6월 - 평균가) - mon06Upc */
	/** 6월 총액(6월 - 판매 총액) - mon06Tamt */
	/** 7월 수량(7월 - REC 거래량) - mon07Qy */
	/** 7월 단가(7월 - 평균가) - mon07Upc */
	/** 7월 총액(7월 - 판매 총액) - mon07Tamt */
	/** 8월 수량(8월 - REC 거래량) - mon08Qy */
	/** 8월 단가(8월 - 평균가) - mon08Upc */
	/** 8월 총액(8월 - 판매 총액) - mon08Tamt */
	/** 9월 수량(9월 - REC 거래량) - mon09Qy */
	/** 9월 단가(9월 - 평균가) - mon09Upc */
	/** 9월 총액(9월 - 판매 총액) - mon09Tamt */
	/** 10월 수량(10월 - REC 거래량) - mon10Qy */
	/** 10월 단가(10월 - 평균가) - mon10Upc */
	/** 10월 총액(10월 - 판매 총액) - mon10Tamt */
	/** 11월 수량(11월 - REC 거래량) - mon11Qy */
	/** 11월 단가(11월 - 평균가) - mon11Upc */
	/** 11월 총액(11월 - 판매 총액) - mon11Tamt */
	/** 12월 수량(12월 - REC 거래량) - mon12Qy */
	/** 12월 단가(12월 - 평균가) - mon12Upc */
	/** 12월 총액(12월 - 판매 총액) - mon12Tamt */
	/** 총량(합계 - REC 총거래량) - totqy */
	/** 총액(합계 - 판매 총액) - tamt */

	public String getRecDelngYear() {
		return recDelngYear;
	}

	public void setRecDelngYear(String recDelngYear) {
		this.recDelngYear = recDelngYear;
	}

	public String getRecDelngMt() {
		return recDelngMt;
	}

	public void setRecDelngMt(String recDelngMt) {
		this.recDelngMt = recDelngMt;
	}

	public String getRecExcclcSbmtQy() {
		return recExcclcSbmtQy;
	}

	public void setRecExcclcSbmtQy(String recExcclcSbmtQy) {
		this.recExcclcSbmtQy = recExcclcSbmtQy;
	}

	public String getRecExcclcTm1sAmt() {
		return recExcclcTm1sAmt;
	}

	public void setRecExcclcTm1sAmt(String recExcclcTm1sAmt) {
		this.recExcclcTm1sAmt = recExcclcTm1sAmt;
	}

	public String getRecExcclcTm2sAmt() {
		return recExcclcTm2sAmt;
	}

	public void setRecExcclcTm2sAmt(String recExcclcTm2sAmt) {
		this.recExcclcTm2sAmt = recExcclcTm2sAmt;
	}

	public String getRecExcclcTm3sAmt() {
		return recExcclcTm3sAmt;
	}

	public void setRecExcclcTm3sAmt(String recExcclcTm3sAmt) {
		this.recExcclcTm3sAmt = recExcclcTm3sAmt;
	}

	public String getRecExcclcTm4sAmt() {
		return recExcclcTm4sAmt;
	}

	public void setRecExcclcTm4sAmt(String recExcclcTm4sAmt) {
		this.recExcclcTm4sAmt = recExcclcTm4sAmt;
	}

	public String getRecAccnutSnrn() {
		return recAccnutSnrn;
	}

	public void setRecAccnutSnrn(String recAccnutSnrn) {
		this.recAccnutSnrn = recAccnutSnrn;
	}

	public String getRecExcclcQy() {
		return recExcclcQy;
	}

	public void setRecExcclcQy(String recExcclcQy) {
		this.recExcclcQy = recExcclcQy;
	}

	public String getRecExcclcUpc() {
		return recExcclcUpc;
	}

	public void setRecExcclcUpc(String recExcclcUpc) {
		this.recExcclcUpc = recExcclcUpc;
	}

	public String getRecExcclcTamt() {
		return recExcclcTamt;
	}

	public void setRecExcclcTamt(String recExcclcTamt) {
		this.recExcclcTamt = recExcclcTamt;
	}

	public String getRecEqpCdNm() {
		return recEqpCdNm;
	}

	public void setRecEqpCdNm(String recEqpCdNm) {
		this.recEqpCdNm = recEqpCdNm;
	}

	@Override
	public String toString() {
		return "RecExcclcVo [recDelngYear=" + recDelngYear + ", recDelngMt=" + recDelngMt + ", recEqpCdNm=" + recEqpCdNm
				+ ", recExcclcSbmtQy=" + recExcclcSbmtQy + ", recExcclcTm1sAmt=" + recExcclcTm1sAmt
				+ ", recExcclcTm2sAmt=" + recExcclcTm2sAmt + ", recExcclcTm3sAmt=" + recExcclcTm3sAmt
				+ ", recExcclcTm4sAmt=" + recExcclcTm4sAmt + ", recAccnutSnrn=" + recAccnutSnrn + ", recExcclcQy="
				+ recExcclcQy + ", recExcclcUpc=" + recExcclcUpc + ", recExcclcTamt=" + recExcclcTamt + "], "
				+ super.toString();
	}
}