package com.ingeniousinc.test;

/**
 * 新疆時時彩
 * 
 * @author tommy.feng
 *
 */
public class XJFLCP {
	/**
	 * 期號
	 */
	private String issueNo;
	/**
	 * 開獎號碼
	 */
	private String lotteryNo;
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
	
	public XJFLCP() {
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
		builder.append("Xjflcp [issueNo=").append(issueNo).append(", lotteryNo=").append(lotteryNo).append(", digits=")
				.append(digits).append(", tens=").append(tens).append(", tailerThree=").append(tailerThree).append("]");
		return builder.toString();
	}
}
