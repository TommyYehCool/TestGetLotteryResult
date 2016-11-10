package com.ingeniousinc.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 重慶時時彩
 * 
 * @author tommy.feng
 *
 */
public class CQSSC {
	/**
	 * 期號
	 */
	private String issueNo;
	/**
	 * 號碼
	 */
	private List<String> lotteryNos;
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
	/**
	 * 類型
	 */
	private String type;
	/**
	 * 3星和
	 */
	private String sumOf3Star;
	/**
	 * 2星大小
	 */
	private String bigSmallOf2Star;
	/**
	 * 2星單雙
	 */
	private String oddEvenOf2Star;
	/**
	 * 2星和
	 */
	private String sumOf2Star;
	
	public CQSSC() {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSumOf3Star() {
		return sumOf3Star;
	}

	public void setSumOf3Star(String sumOf3Star) {
		this.sumOf3Star = sumOf3Star;
	}

	public String getBigSmallOf2Star() {
		return bigSmallOf2Star;
	}

	public void setBigSmallOf2Star(String bigSmallOf2Star) {
		this.bigSmallOf2Star = bigSmallOf2Star;
	}

	public String getOddEvenOf2Star() {
		return oddEvenOf2Star;
	}

	public void setOddEvenOf2Star(String oddEvenOf2Star) {
		this.oddEvenOf2Star = oddEvenOf2Star;
	}

	public String getSumOf2Star() {
		return sumOf2Star;
	}

	public void setSumOf2Star(String sumOf2Star) {
		this.sumOf2Star = sumOf2Star;
	}

	public void setLotteryNos(List<String> lotteryNos) {
		this.lotteryNos = lotteryNos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CQSSC [issueNo=").append(issueNo).append(", lotteryNos=").append(lotteryNos)
				.append(", sumOfTotal=").append(sumOfTotal).append(", headerThree=").append(headerThree)
				.append(", middleThree=").append(middleThree).append(", tailerThree=").append(tailerThree)
				.append(", sumOfTailerThree=").append(sumOfTailerThree).append(", sumOfTailerTwo=")
				.append(sumOfTailerTwo).append(", bigSmallOddEven=").append(bigSmallOddEven).append(", type=")
				.append(type).append(", sumOf3Star=").append(sumOf3Star).append(", bigSmallOf2Star=")
				.append(bigSmallOf2Star).append(", oddEvenOf2Star=").append(oddEvenOf2Star).append(", sumOf2Star=")
				.append(sumOf2Star).append("]");
		return builder.toString();
	}
}