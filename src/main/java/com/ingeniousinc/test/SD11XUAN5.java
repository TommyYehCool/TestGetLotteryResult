package com.ingeniousinc.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 山東11選5
 * 
 * @author tommy.feng
 */
public class SD11XUAN5 {
	/**
	 * 期號
	 */
	private String issueNo;
	/**
	 * 開獎號碼
	 */
	private List<String> lotteryNos;
	
	public SD11XUAN5() {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SD11XUAN5 [issueNo=").append(issueNo).append(", lotteryNos=").append(lotteryNos).append("]");
		return builder.toString();
	}
}	
