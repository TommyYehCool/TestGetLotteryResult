package com.ingeniousinc.test;

public class SD11XUAN5 {
	private String issueNo;
	
	private String lotteryNo;
	
	public SD11XUAN5() {
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public String getLotteryNo() {
		return lotteryNo;
	}

	public void setLotteryNo(String lotteryNo) {
		this.lotteryNo = lotteryNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SD11XUAN5 [issueNo=").append(issueNo).append(", lotteryNo=").append(lotteryNo).append("]");
		return builder.toString();
	}
}	
