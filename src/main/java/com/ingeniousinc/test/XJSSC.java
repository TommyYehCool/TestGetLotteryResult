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
		builder.append("XJSSC [issueNo=").append(issueNo).append(", lotteryNos=").append(lotteryNos).append(", digits=")
				.append(digits).append(", tens=").append(tens).append(", tailerThree=").append(tailerThree)
				.append(", type=").append(type).append(", sumOf3Star=").append(sumOf3Star).append(", bigSmallOf2Star=")
				.append(bigSmallOf2Star).append(", oddEvenOf2Star=").append(oddEvenOf2Star).append(", sumOf2Star=")
				.append(sumOf2Star).append("]");
		return builder.toString();
	}

}
