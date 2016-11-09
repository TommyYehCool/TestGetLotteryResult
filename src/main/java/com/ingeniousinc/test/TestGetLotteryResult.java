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
	
	// 天津時時彩_C
	private String URL_TJSSC_C = "http://www.caipiaokong.com/lottery/tjssc.html";
	private List<TJSSC> tjsscResults_C = new ArrayList<>();
	
	// 天津時時彩_D
	private String URL_TJSSC_D = "http://pub.icaile.com/tjssckjjg.php";
	private List<TJSSC> tjsscResults_D = new ArrayList<>();

	// 新疆時時彩_A
	private String URL_XJFLCP_A = "http://www.xjflcp.com/game/sscAnnounce";
	private List<XJSSC> xjflcpResults_A = new ArrayList<>();

	// 重慶時時彩_A
	private String URL_CQCP_A = "http://www.cqcp.net/game/ssc/";
	private List<CQSSC> cpcqResults_A = new ArrayList<>();
	
	// 山東11選5_A
	private String URL_SD11XUAN5_A = "http://www.sdticai.com/find/find_syxw.asp";
	private List<SD11XUAN5> sd11xuan5Results_A = new ArrayList<>();
	
	// 廣東11選5_A
	private String URL_GD11XUAN5_A = "http://trend.caipiao.163.com/gd11xuan5/";
	private List<GD11XUAN5> gd11xuan5Results_A = new ArrayList<>();
	
	// 江西11選5_B
	private String URL_JX11XUAN5_B = "http://fx.cp2y.com/jx11x5kj/";
	private List<JX11XUAN5> jx11xuan5Results_B = new ArrayList<>();

	private void start() {
		long startTime = 0;
		
		startTime = System.currentTimeMillis();
		getTJSSC_C();
		System.out.println(">>>>> 天津時時彩_C [" + URL_TJSSC_C + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
		showResults(tjsscResults_C);
		
		startTime = System.currentTimeMillis();
		getTJSSC_D();
		System.out.println(">>>>> 天津時時彩_D [" + URL_TJSSC_D + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
		showResults(tjsscResults_D);
		
		startTime = System.currentTimeMillis();
		getXjflcp_A();
		System.out.println(">>>>> 新疆時時彩_A [" + URL_XJFLCP_A + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
		showResults(xjflcpResults_A);
		
		startTime = System.currentTimeMillis();
		getCqcp_A();
		System.out.println(">>>>> 重慶時時彩_A [" + URL_CQCP_A + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
		showResults(cpcqResults_A);
		
		startTime = System.currentTimeMillis();
		getSD11XUAN5_A();
		System.out.println(">>>>> 山東11選5_A [" + URL_SD11XUAN5_A + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
		showResults(sd11xuan5Results_A);
		
		startTime = System.currentTimeMillis();
		getGD11XUAN5_A();
		System.out.println(">>>>> 廣東11選5_A [" + URL_GD11XUAN5_A + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
		showResults(gd11xuan5Results_A);
		
		startTime = System.currentTimeMillis();
		getJX11XUAN5_B();
		System.out.println(">>>>> 江西11選5_B [" + URL_JX11XUAN5_B + "], 取得中獎號碼總花費時間: " + (System.currentTimeMillis() - startTime) + " ms <<<<<");
		showResults(jx11xuan5Results_B);
	}

	private void getTJSSC_C() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			
			Document doc = getDocumentWithUrl(URL_TJSSC_C);
			
			System.out.println("----- 連線到網址 [" + URL_TJSSC_C + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

			Element tableOfResult = doc.select("table.dt").first();
			if (tableOfResult == null) {
				System.err.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
				TJSSC tjsscResult = new TJSSC();

				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();

					switch (j) {
						case 0:
							tjsscResult.setIssueNo(data);
							break;
							
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
							tjsscResult.addLotteryNo(data);
							break;
							
						case 6:
							tjsscResult.setType(data);
							break;
							
						case 7:
							tjsscResult.setSumOf3Star(data);
							break;
							
						case 8:
							tjsscResult.setBigSmallOf2Star(data);
							break;
							
						case 9:
							tjsscResult.setOddEvenOf2Star(data);
							break;
							
						case 10:
							tjsscResult.setSumOf2Star(data);
							break;
					}
				}
				tjsscResults_C.add(tjsscResult);
			}	
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getTJSSC_D() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			
			Document doc = getDocumentWithUrl(URL_TJSSC_D);
			
			System.out.println("----- 連線到網址 [" + URL_TJSSC_D + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.today").first();
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
				TJSSC tjsscResult = new TJSSC();

				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
					
					switch (j) {
						case 0:
							tjsscResult.setIssueNo(data);
							break;
							
						case 2:
							Elements lotteryNos = tdOfResult.select("em");
							for (Element lotteryNo : lotteryNos) {
								String no = lotteryNo.text();
								tjsscResult.addLotteryNo(no);
							}
							break;
					}
				}
				tjsscResults_D.add(tjsscResult);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getXjflcp_A() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			
			Document doc = getDocumentWithUrl(URL_XJFLCP_A);
			
			System.out.println("----- 連線到網址 [" + URL_XJFLCP_A + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

			Element tableOfResult = doc.select("table.kj_tab").first();
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			allDatasLoop:
			for (Element trOfResult : trsOfResult) {
				XJSSC xjflcpResult = new XJSSC();
				
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
				xjflcpResults_A.add(xjflcpResult);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getCqcp_A() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocumentWithUrl(URL_CQCP_A);

			System.out.println("----- 連線到網址 [" + URL_CQCP_A + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element divOfResult = doc.select("div.ssc25").first();
			Elements ulsOfResult = divOfResult.select("ul");
			
			for (int i = 1; i < ulsOfResult.size(); i++) {
				CQSSC cqcpResult = new CQSSC();

				Element ulOfResult = ulsOfResult.get(i); 
				Elements lisOfResult = ulOfResult.select("li");
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
				cpcqResults_A.add(cqcpResult);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getSD11XUAN5_A() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocumentWithUrl(URL_SD11XUAN5_A);
			
			System.out.println("----- 連線到網址 [" + URL_SD11XUAN5_A + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
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
				sd11xuan5Results_A.add(sd11xuan5Result);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getGD11XUAN5_A() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocumentWithUrl(URL_GD11XUAN5_A);

			System.out.println("----- 連線到網址 [" + URL_GD11XUAN5_A + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

			Element tableOfResult = doc.select("table.dataTable").first();
			Element tbodyOfResult = tableOfResult.select("tbody[id=\"cpdata\"]").first();
			Elements trsOfResults = tbodyOfResult.select("tr");
			
			for (int i = 0; i < trsOfResults.size(); i++) {
				GD11XUAN5 gd11xuan5Result = new GD11XUAN5();
				
				Element trOrResult = trsOfResults.get(i);
				Elements tdsOfResult = trOrResult.select("td");
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
				gd11xuan5Results_A.add(gd11xuan5Result);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getJX11XUAN5_B() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
	
			Document doc = getDocumentWithUrl(URL_JX11XUAN5_B);
	
			System.out.println("----- 連線到網址 [" + URL_JX11XUAN5_B + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.kj-detail-table").first();
			if (tableOfResult == null) {
				System.err.println(doc);
				return;
			}
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
				jx11xuan5Results_B.add(jx11xuan5Result);
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
