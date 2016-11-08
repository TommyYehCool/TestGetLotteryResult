package com.ingeniousinc.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestGetLotteryResult {
	private final String CONNECTION_USER_AGENT = "Mozilla/5.0";

	private final int CONNECTION_TIMEOUT = 5 * 1000;
	
	// 天津時時彩
	private String URL_TJSSC = "http://www.caipiaokong.com/lottery/tjssc.html";
	private List<TJSSC> tjsscResults = new ArrayList<>();

	// 新疆時時彩
	private String URL_XJFLCP = "http://www.xjflcp.com/game/sscAnnounce";
	private List<XJFLCP> xjflcpResults = new ArrayList<>();

	// 重慶時時彩
	private String URL_CQCP = "http://www.cqcp.net/game/ssc/";
	private List<CQCP> cpcqResults = new ArrayList<>();
	
	// 山東11選5
	private String URL_SD11XUAN5 = "http://www.sdticai.com/find/find_syxw.asp";
	private List<SD11XUAN5> sd11xuan5Results = new ArrayList<>();
	
	// 廣東11選5
	private String URL_GD11XUAN5 = "http://trend.caipiao.163.com/gd11xuan5/";
	private List<GD11XUAN5> gd11xuan5Results = new ArrayList<>();
	
	// 江西11選5
	private String URL_JX11XUAN5 = "http://fx.cp2y.com/jx11x5kj/";
	private List<JX11XUAN5> jx11xuan5Results = new ArrayList<>();

	private void start() {
		long startTime = 0;
		
		startTime = System.currentTimeMillis();
		getTJSSC();
		System.out.println(">>>>> 天津時時彩 [url: " + URL_TJSSC + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
		showResults(tjsscResults);
		
//		startTime = System.currentTimeMillis();
//		getXjflcp();
//		System.out.println(">>>>> 新疆時時彩 [url: " + URL_XJFLCP + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
//		showResults(xjflcpResults);
//		
//		startTime = System.currentTimeMillis();
//		getCqcp();
//		System.out.println(">>>>> 重慶時時彩 [url: " + URL_CQCP + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
//		showResults(cpcqResults);
//		
//		startTime = System.currentTimeMillis();
//		getSD11XUAN5();
//		System.out.println(">>>>> 山東11選5 [url: " + URL_SD11XUAN5 + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
//		showResults(sd11xuan5Results);
//		
//		startTime = System.currentTimeMillis();
//		getGD11XUAN5();
//		System.out.println(">>>>> 廣東11選5 [url: " + URL_GD11XUAN5 + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
//		showResults(gd11xuan5Results);
//		
//		startTime = System.currentTimeMillis();
//		getJX11XUAN5();
//		System.out.println(">>>>> 江西11選5 [url: " + URL_GD11XUAN5 + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
//		showResults(jx11xuan5Results);
	}

	private void getTJSSC() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			
			Document doc = getDocumentWithUrl(URL_TJSSC);
			
			System.out.println("----- 連線到網址:[" + URL_TJSSC + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

			System.out.println(doc);
			
			// TODO 好像會被擋住, 請先登錄或註冊
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getXjflcp() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			
			Document doc = getDocumentWithUrl(URL_XJFLCP);
			
			System.out.println("----- 連線到網址:[" + URL_XJFLCP + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

			Element tableOfResult = doc.select("table.kj_tab").first();
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			allDatasLoop:
			for (Element trOfResult : trsOfResult) {
				XJFLCP xjflcpResult = new XJFLCP();
				
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
							String[] splitLotteryNos = data.split(",");
							for (String lotteryNo : splitLotteryNos) {
								xjflcpResult.addLotteryNo(lotteryNo);
							}
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

	private void getCqcp() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocumentWithUrl(URL_CQCP);

			System.out.println("----- 連線到網址:[" + URL_CQCP + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element divOfResult = doc.select("div.ssc25").first();
			Elements ulsOfResult = divOfResult.select("ul");
			
			for (int i = 1; i < ulsOfResult.size(); i++) {
				Element ulOfResult = ulsOfResult.get(i); 
				Elements lisOfResult = ulOfResult.select("li");
				
				CQCP cqcpResult = new CQCP(); 
				for (int j = 0; j < lisOfResult.size(); j++) {
					Element lsOfResult = lisOfResult.get(j);
					String data = lsOfResult.text();
					switch (j) {
						// 期號
						case 0:
							cqcpResult.setIssueNo(data);
							break;
							
						// 號碼
						case 1:
							String[] lotteryNos = data.split("-");
							for (String lotteryNo : lotteryNos) {
								cqcpResult.addLotteryNo(lotteryNo);
							}
							break;
							
						// 和值:
						case 2:
							cqcpResult.setSumOfTotal(Integer.parseInt(data));
							break;
							
						// 前三
						case 3:
							cqcpResult.setHeaderThree(data);
							break;
							
						// 中三
						case 4:
							cqcpResult.setMiddleThree(data);
							break;
							
						// 后三
						case 5:
							cqcpResult.setTailerThree(data);
							break;
						
						// 后三和
						case 6:
							cqcpResult.setSumOfTailerThree(Integer.parseInt(data));
							break;
							
						// 后二和
						case 7:
							cqcpResult.setSumOfTailerTwo(Integer.parseInt(data));
							break;
							
						// 大小單雙
						case 8:
							cqcpResult.setBigSmallOddEven(data);
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

	private void getSD11XUAN5() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocumentWithUrl(URL_SD11XUAN5);
			
			System.out.println("----- 連線到網址:[" + URL_SD11XUAN5 + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table[bgcolor=\"#006599\"]").first();
			Elements trsOfResult = tableOfResult.select("tr");
			
			for (int i = 2; i < trsOfResult.size(); i++) {
				SD11XUAN5 sd11xuan5Result = new SD11XUAN5();
				
				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
					switch (j) {
						case 0:
							sd11xuan5Result.setIssueNo(data);
							break;
							
						default:
							sd11xuan5Result.addLotteryNo(data);
					}
				}
				sd11xuan5Results.add(sd11xuan5Result);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getGD11XUAN5() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocumentWithUrl(URL_GD11XUAN5);

			System.out.println("----- 連線到網址:[" + URL_GD11XUAN5 + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

			Element tableOfResult = doc.select("table.dataTable").first();
			
			Element tbodyOfResult = tableOfResult.select("tbody[id=\"cpdata\"]").first();
			
			Elements trsOfResults = tbodyOfResult.select("tr");
			
			for (int i = 0; i < trsOfResults.size(); i++) {
				Element trOrResult = trsOfResults.get(i);
				
				Elements tdsOfResult = trOrResult.select("td");
				
				GD11XUAN5 gd11xuan5Result = new GD11XUAN5();
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
					
					switch (j) {
						case 0:
							gd11xuan5Result.setIssueNo(data);
							break;
							
						case 2:
						case 3:
						case 4:
						case 5:
						case 6:
							gd11xuan5Result.addLotteryNo(data);
							break;
							
						case 20:
							gd11xuan5Result.setSumOfTotal(Integer.parseInt(data));
							break;
							
						case 21:
							gd11xuan5Result.setOver(Integer.parseInt(data));
							break;
						
						case 22:
							gd11xuan5Result.setOddEvenRatio(data);
							break;
							
						case 23:
							gd11xuan5Result.setPrimeRatio(data);
							break;
					}
				}
				gd11xuan5Results.add(gd11xuan5Result);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getJX11XUAN5() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
	
			Document doc = getDocumentWithUrl(URL_JX11XUAN5);
	
			System.out.println("----- 連線到網址:[" + URL_JX11XUAN5 + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.kj-detail-table").first();
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			
			Elements trsOfResults = tbodyOfResult.select("tr");
			for (int i = 1; i < trsOfResults.size(); i++) {
				JX11XUAN5 jx11xuan5Result = new JX11XUAN5();
				
				Element trOfResult = trsOfResults.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					switch (j) {
						case 0:
							String data = tdOfResult.text();
							String[] split = data.split(" ");
							jx11xuan5Result.setIssueNo(split[0]);
							break;
							
						case 1:
							Elements iOfResults = tdOfResult.select("i");
							for (Element iOfResult : iOfResults) {
								jx11xuan5Result.addLotteryNo(iOfResult.text());
							}
							break;
					}
				}
				jx11xuan5Results.add(jx11xuan5Result);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Document getDocumentWithUrl(String url) throws IOException {
		Connection connection = Jsoup.connect(url);
		connection.timeout(CONNECTION_TIMEOUT);
		connection.userAgent(CONNECTION_USER_AGENT);
		Document doc = connection.get();
		return doc;
	}

	private <T> void showResults(List<T> results) {
		for (T result : results) {
			System.out.println(result);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new TestGetLotteryResult().start();
	}
}
