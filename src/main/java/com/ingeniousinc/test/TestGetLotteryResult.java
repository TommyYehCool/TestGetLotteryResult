package com.ingeniousinc.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestGetLotteryResult {
	private int GET_DOC_TIMEOUT = 5 * 1000;

	// 新疆時時彩
	private String URL_XJFLCP = "http://www.xjflcp.com/game/sscAnnounce";
	private List<Xjflcp> xjflcpResults = new ArrayList<>();

	// 重慶時時彩
	private String URL_CQCP = "http://www.cqcp.net/game/ssc/";
	private List<Cqcp> cpcqResults = new ArrayList<>();

	private void start() {
		long startTime = 0;
		
		startTime = System.currentTimeMillis();
		getXjflcp();
		System.out.println(">>>>> 新疆時時彩 [url: " + URL_XJFLCP + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
		showResults(xjflcpResults);
		
		System.out.println();

		startTime = System.currentTimeMillis();
		getCqcp();
		System.out.println(">>>>> 重慶時時彩 [url: " + URL_CQCP + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
		showResults(cpcqResults);
	}

	private void getCqcp() {
		long startTime = 0;
		try {
			URL url = new URL(URL_CQCP);
			
			startTime = System.currentTimeMillis();
			Document doc = Jsoup.parse(url, GET_DOC_TIMEOUT);
			System.out.println("----- 連線到網址取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element divOfResult = doc.select("div.ssc25").first();
			Elements ulsOfResult = divOfResult.select("ul");
			
			// 印出 title
//			Element ulOfTitle = ulsOfResult.get(0);
//			Elements lisOfTitle = ulOfTitle.select("li");
//			for (Element liOfTitle : lisOfTitle) {
//				System.out.print(liOfTitle.text() + " ");
//			}
//			System.out.println();
			
			for (int i = 1; i < ulsOfResult.size(); i++) {
				Element ulOfResult = ulsOfResult.get(i); 
				Elements lisOfResult = ulOfResult.select("li");
				
				Cqcp cqcpResult = new Cqcp(); 
				for (int j = 0; j < lisOfResult.size(); j++) {
					Element lsOfResult = lisOfResult.get(j);
					switch (j) {
						// 期號
						case 0:
							cqcpResult.setIssueNo(lsOfResult.text());
							break;
							
						// 號碼
						case 1:
							cqcpResult.setLotteryNo(lsOfResult.text());
							break;
							
						// 和值:
						case 2:
							cqcpResult.setSumOfTotal(Integer.parseInt(lsOfResult.text()));
							break;
							
						// 前三
						case 3:
							cqcpResult.setHeaderThree(lsOfResult.text());
							break;
							
						// 中三
						case 4:
							cqcpResult.setMiddleThree(lsOfResult.text());
							break;
							
						// 后三
						case 5:
							cqcpResult.setTailerThree(lsOfResult.text());
							break;
						
						// 后三和
						case 6:
							cqcpResult.setSumOfTailerThree(Integer.parseInt(lsOfResult.text()));
							break;
							
						// 后二和
						case 7:
							cqcpResult.setSumOfTailerTwo(Integer.parseInt(lsOfResult.text()));
							break;
							
						// 大小單雙
						case 8:
							cqcpResult.setBigSmallOddEven(lsOfResult.text());
							break;
					}
				}
				cpcqResults.add(cqcpResult);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getXjflcp() {
		long startTime = 0;
		try {
			URL url = new URL(URL_XJFLCP);
			
			startTime = System.currentTimeMillis();
			Document doc = Jsoup.parse(url, GET_DOC_TIMEOUT);
			System.out.println("----- 連線到網址取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

			Element divOfResult = doc.select("table.kj_tab").first();
			
			// 印出 title
//			Element theadOfTitle = divOfResult.select("thead").first();
//			Elements thsOfTitle = theadOfTitle.select("th");
//			for (Element thOfTitle : thsOfTitle) {
//				System.out.print(thOfTitle.text() + " ");
//			}
//			System.out.println();
			
			Element tbodyOfResult = divOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			allDatasLoop:
			for (Element trOfResult : trsOfResult) {
				Xjflcp xjflcpResult = new Xjflcp();
				
				Elements tdsOfResult = trOfResult.select("td");
				for (int i = 0; i < tdsOfResult.size(); i++) {
					Element tdOfResult = tdsOfResult.get(i);

					String data = tdOfResult.text();
					if (data.equals("--")) {
						break allDatasLoop;
					}
					switch (i) {
						case 0:
							xjflcpResult.setIssueNo(data);
							break;
							
						case 1:
							xjflcpResult.setLotteryNo(data);
							break;
							
						case 2:
							String[] split = data.split(" ");
							for (int j = 0; j < split.length; j++) {
								switch (j) {
									case 0:
										xjflcpResult.setDigits(split[j]);
										break;
										
									case 1:
										xjflcpResult.setTens(split[j]);
										break;
										
									case 2:
										xjflcpResult.setTailerThree(split[j]);
										break;
								}
							}
							break;
					}
				}
				xjflcpResults.add(xjflcpResult);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private <T> void showResults(List<T> results) {
		for (T result : results) {
			System.out.println(result);
		}
	}

	public static void main(String[] args) {
		new TestGetLotteryResult().start();
	}
}
