package com.ingeniousinc.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 新疆時時彩
 * 
 * @author tommy.feng
 *
 */
public class XJSSC {
	/**
	 * 期號
	 */
	private String issueNo;
	/**
	 * 開獎號碼
	 */
	private List<String> lotteryNos;
	/**
	 * 個位
	 */
	private String digits;
	/**
	 * 十位
	 */
	private String tens;
	/**
	 * 后三
	 */
	private String tailerThree;
	
	public XJSSC() {
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public List<String> getLotteryNos() {
		return lotteryNos;
	}

	public void addLotteryNo(String lotteryNo) {
		if (lotteryNos == null) {
			lotteryNos = new ArrayList<String>();
		}
		lotteryNos.add(lotteryNo);
	}

	public String getDigits() {
		return digits;
	}

	public void setDigits(String digits) {
		this.digits = digits;
	}

	public String getTens() {
		return tens;
	}

	public void setTens(String tens) {
		this.tens = tens;
	}

	public String getTailerThree() {
		return tailerThree;
	}

	public void setTailerThree(String tailerThree) {
		this.tailerThree = tailerThree;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("XJSSC [issueNo=").append(issueNo).append(", lotteryNos=").append(lotteryNos).append(", digits=")
				.append(digits).append(", tens=").append(tens).append(", tailerThree=").append(tailerThree).append("]");
		return builder.toString();
	}

}
