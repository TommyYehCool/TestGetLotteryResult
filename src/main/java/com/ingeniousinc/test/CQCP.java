package com.ingeniousinc.test;

/**
 * 重慶時時彩
 * 
 * @author tommy.feng
 *
 */
public class CQCP {
	/**
	 * 期號
	 */
	private String issueNo;
	/**
	 * 號碼
	 */
	private String lotteryNo;
	/**
	 * 和值
	 */
	private Integer sumOfTotal;
	/**
	 * 前三
	 */
	private String headerThree;
	/**
	 * 中三
	 */
	private String middleThree;
	/**
	 * 后三
	 */
	private String tailerThree;
	/**
	 * 后三和
	 */
	private Integer sumOfTailerThree;
	/**
	 * 后二和
	 */
	private Integer sumOfTailerTwo;
	/**
	 * 大小單双
	 */
	private String bigSmallOddEven;
	
	public CQCP() {
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

	public Integer getSumOfTotal() {
		return sumOfTotal;
	}

	public void setSumOfTotal(Integer sumOfTotal) {
		this.sumOfTotal = sumOfTotal;
	}

	public String getHeaderThree() {
		return headerThree;
	}

	public void setHeaderThree(String headerThree) {
		this.headerThree = headerThree;
	}

	public String getMiddleThree() {
		return middleThree;
	}

	public void setMiddleThree(String middleThree) {
		this.middleThree = middleThree;
	}

	public String getTailerThree() {
		return tailerThree;
	}

	public void setTailerThree(String tailerThree) {
		this.tailerThree = tailerThree;
	}

	public Integer getSumOfTailerThree() {
		return sumOfTailerThree;
	}

	public void setSumOfTailerThree(Integer sumOfTailerThree) {
		this.sumOfTailerThree = sumOfTailerThree;
	}

	public Integer getSumOfTailerTwo() {
		return sumOfTailerTwo;
	}

	public void setSumOfTailerTwo(Integer sumOfTailerTwo) {
		this.sumOfTailerTwo = sumOfTailerTwo;
	}

	public String getBigSmallOddEven() {
		return bigSmallOddEven;
	}

	public void setBigSmallOddEven(String bigSmallOddEven) {
		this.bigSmallOddEven = bigSmallOddEven;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cqcp [issueNo=").append(issueNo).append(", lotteryNo=").append(lotteryNo)
				.append(", sumOfTotal=").append(sumOfTotal).append(", headerThree=").append(headerThree)
				.append(", middleThree=").append(middleThree).append(", tailerThree=").append(tailerThree)
				.append(", sumOfTailerThree=").append(sumOfTailerThree).append(", sumOfTailerTwo=")
				.append(sumOfTailerTwo).append(", bigSmallOddEven=").append(bigSmallOddEven).append("]");
		return builder.toString();
	}
}