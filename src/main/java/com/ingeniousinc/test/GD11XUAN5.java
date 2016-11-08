package com.ingeniousinc.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 廣東11選5
 * 
 * @author tommy.feng
 *
 */
public class GD11XUAN5 {
	/**
	 * 期號
	 */
	private String issueNo;
	/**
	 * 開獎號碼
	 */
	private List<String> lotteryNos;
	/**
	 * 和值
	 */
	private Integer sumOfTotal;
	/**
	 * 跨度
	 */
	private Integer over;
	/**
	 * 奇偶比
	 */
	private String oddEvenRatio;
	/**
	 * 質和比
	 */
	private String primeRatio;
	
	public GD11XUAN5() {
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

	public Integer getSumOfTotal() {
		return sumOfTotal;
	}

	public void setSumOfTotal(Integer sumOfTotal) {
		this.sumOfTotal = sumOfTotal;
	}

	public Integer getOver() {
		return over;
	}

	public void setOver(Integer over) {
		this.over = over;
	}

	public String getOddEvenRatio() {
		return oddEvenRatio;
	}

	public void setOddEvenRatio(String oddEvenRatio) {
		this.oddEvenRatio = oddEvenRatio;
	}

	public String getPrimeRatio() {
		return primeRatio;
	}

	public void setPrimeRatio(String primeRatio) {
		this.primeRatio = primeRatio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GD11XUAN5 [issueNo=").append(issueNo).append(", lotteryNos=").append(lotteryNos)
				.append(", sumOfTotal=").append(sumOfTotal).append(", over=").append(over).append(", oddEvenRatio=")
				.append(oddEvenRatio).append(", primeRatio=").append(primeRatio).append("]");
		return builder.toString();
	}

}
