package com.ingeniousinc.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 天津時時彩
 * 
 * @author tommy.feng
 *
 */
public class TJSSC {
	/**
	 * 期號
	 */
	private String issueNo;
	/**
	 * 開獎號碼
	 */
	private List<String> lotteryNos;
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
	private String sumOf2Start;
	
	public TJSSC() {
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

	public String getSumOf2Start() {
		return sumOf2Start;
	}

	public void setSumOf2Start(String sumOf2Start) {
		this.sumOf2Start = sumOf2Start;
	}

	public void setLotteryNos(List<String> lotteryNos) {
		this.lotteryNos = lotteryNos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TJSSC [issueNo=").append(issueNo).append(", lotteryNos=").append(lotteryNos).append(", type=")
				.append(type).append(", sumOf3Star=").append(sumOf3Star).append(", bigSmallOf2Star=")
				.append(bigSmallOf2Star).append(", oddEvenOf2Star=").append(oddEvenOf2Star).append(", sumOf2Start=")
				.append(sumOf2Start).append("]");
		return builder.toString();
	}

}
