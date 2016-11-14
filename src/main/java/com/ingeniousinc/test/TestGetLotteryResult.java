package com.ingeniousinc.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestGetLotteryResult {
	private static final int RETRY_TIMES = 5;

	private static final long RETRY_INTERVAL = 5 * 1000;

	private final String CONNECTION_USER_AGENT = "Mozilla/5.0";

	private final int CONNECTION_TIMEOUT = 5 * 1000;
	
	private final String OUTPUT_FILE_PATH = System.getProperty("user.home") + "\\Desktop\\result.txt";
	
	// 天津時時彩_C
	private final String NAME_TJSSC_C = "天津時時彩_C";
	private final String URL_TJSSC_C = "http://www.caipiaokong.com/lottery/tjssc.html";
	private List<TJSSC> tjssc_C = new ArrayList<>();
	
	// 天津時時彩_D
	private final String NAME_TJSSC_D = "天津時時彩_D";
	private final String URL_TJSSC_D = "http://pub.icaile.com/tjssckjjg.php";
	private List<TJSSC> tjssc_D = new ArrayList<>();

	// 新疆時時彩_A
	private final String NAME_XJSSC_A = "新疆時時彩_A";
	private final String URL_XJSSC_A = "http://www.xjflcp.com/game/sscAnnounce";
	private List<XJSSC> xjssc_A = new ArrayList<>();
	
	// 新疆時時彩_C
	private final String NAME_XJSSC_C = "新疆時時彩_C";
	private final String URL_XJSSC_C = "http://www.caipiaokong.com/lottery/xjssc.html";
	private List<XJSSC> xjssc_C = new ArrayList<>();
	
	// 新疆時時彩_D
	private final String NAME_XJSSC_D = "新疆時時彩_D";
	private final String URL_XJSSC_D = "http://pub.icaile.com/xjssckjjg.php";
	private List<XJSSC> xjssc_D = new ArrayList<>();

	// 重慶時時彩_A
	private final String NAME_CQSSC_A = "重慶時時彩_A";
	private final String URL_CQSSC_A = "http://www.cqcp.net/game/ssc/";
	private List<CQSSC> cqssc_A = new ArrayList<>();
	
	// 重慶時時彩_C
	private final String NAME_CQSSC_C = "重慶時時彩_C";
	private final String URL_CQSSC_C = "http://www.caipiaokong.com/lottery/cqssc.html";
	private List<CQSSC> cqssc_C = new ArrayList<>();
	
	// 重慶時時彩_D
	private final String NAME_CQSSC_D = "重慶時時彩_D";
	private final String URL_CQSSC_D = "http://pub.icaile.com/cqssckjjg.php";
	private List<CQSSC> cqssc_D = new ArrayList<>();
	
	// 山東11選5_A
	private final String NAME_SD11XUAN5_A = "山東11選5_A";
	private final String URL_SD11XUAN5_A = "http://www.sdticai.com/find/find_syxw.asp";
	private List<SD11XUAN5> sd11xuan5_A = new ArrayList<>();
	
	// 山東11選5_C
	private final String NAME_SD11XUAN5_C = "山東11選5_C";
	private final String URL_SD11XUAN5_C = "http://www.caipiaokong.com/lottery/sdsyydj.html";
	private List<SD11XUAN5> sd11xuan5_C = new ArrayList<>();
	
	// 山東11選5_D
	private final String NAME_SD11XUAN5_D = "山東11選5_D";
	private final String URL_SD11XUAN5_D = "http://pub.icaile.com/sd11x5kjjg.php";
	private List<SD11XUAN5> sd11xuan5_D = new ArrayList<>();
	
	// 廣東11選5_A
	private final String NAME_GD11XUAN5_A = "廣東11選5_A";
	private final String URL_GD11XUAN5_A = "http://trend.caipiao.163.com/gd11xuan5/";
	private List<GD11XUAN5> gd11xuan5_A = new ArrayList<>();
	
	// 廣東11選5_B
	private final String NAME_GD11XUAN5_B = "廣東11選5_B";
	private final String URL_GD11XUAN5_B = "http://trend.baidu.lecai.com/gd11x5/";
	private List<GD11XUAN5> gd11xuan5_B = new ArrayList<>();
	
	// 廣東11選5_C
	private final String NAME_GD11XUAN5_C = "廣東11選5_C";
	private final String URL_GD11XUAN5_C = "http://www.caipiaokong.com/lottery/gdsyxw.html";
	private List<GD11XUAN5> gd11xuan5_C = new ArrayList<>();
	
	// 廣東11選5_D
	private final String NAME_GD11XUAN5_D = "廣東11選5_D";
	private final String URL_GD11XUAN5_D = "http://pub.icaile.com/gd11x5kjjg.php#from=zx";
	private List<GD11XUAN5> gd11xuan5_D = new ArrayList<>();
	
	// 江西11選5_A
	private final String NAME_JX11XUAN5_A = "江西11選5_A";
	private final String URL_JX11XUAN5_A = "http://fx.cp2y.com/jx11x5kj/";
	private List<JX11XUAN5> jx11xuan5_A = new ArrayList<>();
	
	// 江西11選5_B
	private final String NAME_JX11XUAN5_B = "江西11選5_B";
	private final String URL_JX11XUAN5_B = "http://trend.baidu.lecai.com/jx11x5/";
	private List<JX11XUAN5> jx11xuan5_B = new ArrayList<>();
	
	// 江西11選5_C
	private final String NAME_JX11XUAN5_C = "江西11選5_C";
	private final String URL_JX11XUAN5_C = "http://www.caipiaokong.com/lottery/jxsyxw.html";
	private List<JX11XUAN5> jx11xuan5_C = new ArrayList<>();
	
	// 江西11選5_D
	private final String NAME_JX11XUAN5_D = "江西11選5_D";
	private final String URL_JX11XUAN5_D = "http://pub.icaile.com/jx11x5kjjg.php";
	private List<JX11XUAN5> jx11xuan5_D = new ArrayList<>();

	private void start() {
		processTJSSC();
		
		processXJSSC();
		
		processCQSSC();
		
		processSD11XUAN5();
		
		processGD11XUAN5();
		
		processJX11XUAN5();
		
		outputResults();
	}
	
	private void processTJSSC() {
		long startTime = 0;

		startTime = System.currentTimeMillis();
		getSSCFromCaipiaokong(TJSSC.class, NAME_TJSSC_C, URL_TJSSC_C, tjssc_C);
		System.out.println(">>>>> " + NAME_TJSSC_C + " [" + URL_TJSSC_C + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

		startTime = System.currentTimeMillis();
		getTJSSC_D();
		System.out.println(">>>>> " + NAME_TJSSC_D + " [" + URL_TJSSC_D + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
	}
	
	private void processXJSSC() {
		long startTime = 0;

		startTime = System.currentTimeMillis();
		getXJSSC_A();
		System.out.println(">>>>> " + NAME_XJSSC_A + " [" + URL_XJSSC_A + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		getSSCFromCaipiaokong(XJSSC.class, NAME_XJSSC_C, URL_XJSSC_C, xjssc_C);
		System.out.println(">>>>> " + NAME_XJSSC_C + " [" + URL_XJSSC_C + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		getXJSSC_D();
		System.out.println(">>>>> " + NAME_XJSSC_D + " [" + URL_XJSSC_D + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
	}
	
	private void processCQSSC() {
		long startTime = 0;

		startTime = System.currentTimeMillis();
		getCQSSC_A();
		System.out.println(">>>>> " + NAME_CQSSC_A + " [" + URL_CQSSC_A + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		getSSCFromCaipiaokong(CQSSC.class, NAME_CQSSC_C, URL_CQSSC_C, cqssc_C);
		System.out.println(">>>>> " + NAME_CQSSC_C + " [" + URL_CQSSC_C + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		getCQSSC_D();
		System.out.println(">>>>> " + NAME_CQSSC_D + " [" + URL_CQSSC_D + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
	}

	private void processSD11XUAN5() {
		long startTime = 0;

		startTime = System.currentTimeMillis();
		getSD11XUAN5_A();
		System.out.println(">>>>> " + NAME_SD11XUAN5_A + " [" + URL_SD11XUAN5_A + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		get11xuan5FromCaipiaokong(SD11XUAN5.class, NAME_SD11XUAN5_C, URL_SD11XUAN5_C, sd11xuan5_C);
		System.out.println(">>>>> " + NAME_SD11XUAN5_C + " [" + URL_SD11XUAN5_C + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

		startTime = System.currentTimeMillis();
		getSD11XUAN5_D();
		System.out.println(">>>>> " + NAME_SD11XUAN5_D + " [" + URL_SD11XUAN5_D + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
	}

	private void processGD11XUAN5() {
		long startTime = 0;

		startTime = System.currentTimeMillis();
		getGD11XUAN5_A();
		System.out.println(">>>>> " + NAME_GD11XUAN5_A + " [" + URL_GD11XUAN5_A + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		get11xuan5FromTrendBaidu(GD11XUAN5.class, NAME_GD11XUAN5_B, URL_GD11XUAN5_B, gd11xuan5_B);
		System.out.println(">>>>> " + NAME_GD11XUAN5_B + " [" + URL_GD11XUAN5_B + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		get11xuan5FromCaipiaokong(GD11XUAN5.class, NAME_GD11XUAN5_C, URL_GD11XUAN5_C, gd11xuan5_C);
		System.out.println(">>>>> " + NAME_GD11XUAN5_C + " [" + URL_GD11XUAN5_C + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		getGD11XUAN5_D();
		System.out.println(">>>>> " + NAME_GD11XUAN5_D + " [" + URL_GD11XUAN5_D + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
	}

	private void processJX11XUAN5() {
		long startTime = 0;

		startTime = System.currentTimeMillis();
		getJX11XUAN5_A();
		System.out.println(">>>>> " + NAME_JX11XUAN5_A + " [" + URL_JX11XUAN5_A + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		get11xuan5FromTrendBaidu(JX11XUAN5.class, NAME_JX11XUAN5_B, URL_JX11XUAN5_B, jx11xuan5_B);
		System.out.println(">>>>> " + NAME_JX11XUAN5_B + " [" + URL_JX11XUAN5_B + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		get11xuan5FromCaipiaokong(JX11XUAN5.class, NAME_JX11XUAN5_C, URL_JX11XUAN5_C, jx11xuan5_C);
		System.out.println(">>>>> " + NAME_JX11XUAN5_C + " [" + URL_JX11XUAN5_C + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		getJX11XUAN5_D();
		System.out.println(">>>>> " + NAME_JX11XUAN5_D + " [" + URL_JX11XUAN5_D + "], 取得中獎號碼, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
	}
	
	private void getTJSSC_C() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			
			Document doc = getDocument(URL_TJSSC_C);
			
			System.out.println(">>>>> 天津時時彩_C [" + URL_TJSSC_C + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

			Element tableOfResult = doc.select("table.dt").first();
			if (tableOfResult == null) {
				System.out.println(doc);
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
				tjssc_C.add(tjsscResult);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getTJSSC_D() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			
			Document doc = getDocument(URL_TJSSC_D);
			
			System.out.println(">>>>> 天津時時彩_D [" + URL_TJSSC_D + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.today").first();
			if (tableOfResult == null) {
				System.out.println(doc);
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
							
						case 2:
							Elements lotteryNos = tdOfResult.select("em");
							for (Element lotteryNo : lotteryNos) {
								String no = lotteryNo.text();
								tjsscResult.addLotteryNo(no);
							}
							break;
					}
				}
				tjssc_D.add(tjsscResult);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getXJSSC_A() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			
			Document doc = getDocument(URL_XJSSC_A);
			
			System.out.println(">>>>> 新疆時時彩_A [" + URL_XJSSC_A + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

			Element tableOfResult = doc.select("table.kj_tab").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
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
				xjssc_A.add(xjflcpResult);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getXJSSC_C() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			
			Document doc = getDocument(URL_XJSSC_C);
			
			System.out.println(">>>>> 新疆時時彩_C [" + URL_XJSSC_C + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

			Element tableOfResult = doc.select("table.dt").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
				XJSSC xjsscResult = new XJSSC();
				
				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
					
					switch (j) {
						case 0:
							xjsscResult.setIssueNo(data);
							break;

						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
							xjsscResult.addLotteryNo(data);
							break;
						
						case 6:
							xjsscResult.setType(data);
							break;
							
						case 7:
							xjsscResult.setSumOf3Star(data);
							break;
							
						case 8:
							xjsscResult.setBigSmallOf2Star(data);
							break;
							
						case 9:
							xjsscResult.setOddEvenOf2Star(data);
							break;
							
						case 10:
							xjsscResult.setSumOf2Star(data);
							break;
					}
				}
				xjssc_C.add(xjsscResult);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getXJSSC_D() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			
			Document doc = getDocument(URL_XJSSC_D);
			
			System.out.println(">>>>> 新疆時時彩_D [" + URL_XJSSC_D + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.today").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
				XJSSC xjsscResult = new XJSSC();
				
				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
					
					switch (j) {
						case 0:
							xjsscResult.setIssueNo(data);
							break;
							
						case 2:
							Elements lotteryNos = tdOfResult.select("em");
							for (Element lotteryNo : lotteryNos) {
								String no = lotteryNo.text();
								xjsscResult.addLotteryNo(no);
							}
							break;
					}
				}
				xjssc_D.add(xjsscResult);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getCQSSC_A() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_CQSSC_A);

			System.out.println(">>>>> 重慶時時彩_A [" + URL_CQSSC_A + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element divOfResult = doc.select("div.ssc25").first();
			if (divOfResult == null) {
				System.out.println(doc);
				return;
			}
			
			Elements ulsOfResult = divOfResult.select("ul");
			
			for (int i = 1; i < ulsOfResult.size(); i++) {
				CQSSC cqsscResult = new CQSSC();

				Element ulOfResult = ulsOfResult.get(i); 
				Elements lisOfResult = ulOfResult.select("li");
				for (int j = 0; j < lisOfResult.size(); j++) {
					Element lsOfResult = lisOfResult.get(j);
					String data = lsOfResult.text();
					switch (j) {
						case 0:
							cqsscResult.setIssueNo(data);
							break;
							
						case 1:
							String[] lotteryNos = data.split("-");
							for (String lotteryNo : lotteryNos) {
								cqsscResult.addLotteryNo(lotteryNo);
							}
							break;
							
						case 2:
							cqsscResult.setSumOfTotal(Integer.parseInt(data));
							break;
							
						case 3:
							cqsscResult.setHeaderThree(data);
							break;
							
						case 4:
							cqsscResult.setMiddleThree(data);
							break;
							
						case 5:
							cqsscResult.setTailerThree(data);
							break;
						
						case 6:
							cqsscResult.setSumOfTailerThree(Integer.parseInt(data));
							break;
							
						case 7:
							cqsscResult.setSumOfTailerTwo(Integer.parseInt(data));
							break;
							
						case 8:
							cqsscResult.setBigSmallOddEven(data);
							break;
					}
				}
				cqssc_A.add(cqsscResult);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getCQSSC_C() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_CQSSC_C);

			System.out.println(">>>>> 重慶時時彩_C [" + URL_CQSSC_C + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.dt").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
				CQSSC cqsscResult = new CQSSC();

				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();

					switch (j) {
						case 0:
							cqsscResult.setIssueNo(data);
							break;
							
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
							cqsscResult.addLotteryNo(data);
							break;
							
						case 6:
							cqsscResult.setType(data);
							break;
							
						case 7:
							cqsscResult.setSumOf3Star(data);
							break;
							
						case 8:
							cqsscResult.setBigSmallOf2Star(data);
							break;
							
						case 9:
							cqsscResult.setOddEvenOf2Star(data);
							break;
							
						case 10:
							cqsscResult.setSumOf2Star(data);
							break;
					}
				}
				cqssc_C.add(cqsscResult);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getCQSSC_D() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_CQSSC_D);

			System.out.println(">>>>> 重慶時時彩_D [" + URL_CQSSC_D + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.today").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
				CQSSC cqsscResult = new CQSSC();
				
				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
					
					switch (j) {
						case 0:
							cqsscResult.setIssueNo(data);
							break;
							
						case 2:
							Elements lotteryNos = tdOfResult.select("em");
							for (Element lotteryNo : lotteryNos) {
								String no = lotteryNo.text();
								cqsscResult.addLotteryNo(no);
							}
							break;
					}
				}
				cqssc_D.add(cqsscResult);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getSD11XUAN5_A() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_SD11XUAN5_A);
			
			System.out.println(">>>>> 山東11選5_A [" + URL_SD11XUAN5_A + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table[bgcolor=\"#006599\"]").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
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
				sd11xuan5_A.add(sd11xuan5Result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getSD11XUAN5_C() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_SD11XUAN5_C);

			System.out.println(">>>>> 山東11選5_C [" + URL_SD11XUAN5_C + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.dt").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
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
							
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
							sd11xuan5Result.addLotteryNo(data);
							break;
					}
				}
				sd11xuan5_C.add(sd11xuan5Result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getSD11XUAN5_D() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_SD11XUAN5_D);

			System.out.println(">>>>> 山東11選5_D [" + URL_SD11XUAN5_D + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.today").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
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
							
						case 2:
							Elements lotteryNos = tdOfResult.select("em");
							for (Element lotteryNo : lotteryNos) {
								String no = lotteryNo.text();
								sd11xuan5Result.addLotteryNo(no);
							}
							break;
					}
				}
				sd11xuan5_D.add(sd11xuan5Result);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getGD11XUAN5_A() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_GD11XUAN5_A);

			System.out.println(">>>>> 廣東11選5_A [" + URL_GD11XUAN5_A + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");

			Element tableOfResult = doc.select("table.dataTable").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
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
				gd11xuan5_A.add(gd11xuan5Result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getGD11XUAN5_B() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_GD11XUAN5_B);

			System.out.println(">>>>> 廣東11選5_B [" + URL_GD11XUAN5_B + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element divOfResults = doc.select("div.chart_table_wrapper").first();
			if (divOfResults == null) {
				System.out.println(doc);
				return;
			}
			
			Element tableOfResults = divOfResults.select("table.chart_table").first();
			Element tbodyOfResults = tableOfResults.select("tbody").first();
			Elements trsOfResults = tbodyOfResults.select("tr");
					
			allDatasLoop:
			for (int i = 0; i < trsOfResults.size(); i++) {
				GD11XUAN5 gd11xuan5Result = new GD11XUAN5();
				
				Element trOrResult = trsOfResults.get(i);
				Elements tdsOfResult = trOrResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
					
					switch (j) {
						case 0:
							if (data.equals("总次数")) {
								break allDatasLoop;
							}
							break;
					
						case 1:
							gd11xuan5Result.setIssueNo(data);
							break;
							
						case 2:
						case 3:
						case 4:
						case 5:
						case 6:
							gd11xuan5Result.addLotteryNo(data);
							break;
					}
				}
				gd11xuan5_B.add(gd11xuan5Result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getGD11XUAN5_C() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_GD11XUAN5_C);

			System.out.println(">>>>> 廣東11選5_C [" + URL_GD11XUAN5_C + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.dt").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
				GD11XUAN5 gd11xuan5Result = new GD11XUAN5();

				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();

					switch (j) {
						case 0:
							gd11xuan5Result.setIssueNo(data);
							break;
							
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
							gd11xuan5Result.addLotteryNo(data);
							break;
					}
				}
				gd11xuan5_C.add(gd11xuan5Result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getGD11XUAN5_D() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_GD11XUAN5_D);

			System.out.println(">>>>> 廣東11選5_D [" + URL_GD11XUAN5_D + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.today").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
				GD11XUAN5 gd11xuan5Result = new GD11XUAN5();
				
				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
					
					switch (j) {
						case 0:
							gd11xuan5Result.setIssueNo(data);
							break;
							
						case 2:
							Elements lotteryNos = tdOfResult.select("em");
							for (Element lotteryNo : lotteryNos) {
								String no = lotteryNo.text();
								gd11xuan5Result.addLotteryNo(no);
							}
							break;
					}
				}
				gd11xuan5_D.add(gd11xuan5Result);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getJX11XUAN5_A() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
	
			Document doc = getDocument(URL_JX11XUAN5_A);
	
			System.out.println(">>>>> 江西11選5_A [" + URL_JX11XUAN5_A + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.kj-detail-table").first();
			if (tableOfResult == null) {
				System.out.println(doc);
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
				jx11xuan5_A.add(jx11xuan5Result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getJX11XUAN5_B() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_JX11XUAN5_B);

			System.out.println(">>>>> 江西11選5_B [" + URL_JX11XUAN5_B + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element divOfResults = doc.select("div.chart_table_wrapper").first();
			if (divOfResults == null) {
				System.out.println(doc);
				return;
			}
			
			Element tableOfResults = divOfResults.select("table.chart_table").first();
			Element tbodyOfResults = tableOfResults.select("tbody").first();
			Elements trsOfResults = tbodyOfResults.select("tr");
					
			allDatasLoop:
			for (int i = 0; i < trsOfResults.size(); i++) {
				JX11XUAN5 jx11xuan5Result = new JX11XUAN5();
				
				Element trOrResult = trsOfResults.get(i);
				Elements tdsOfResult = trOrResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
					
					switch (j) {
						case 0:
							if (data.equals("总次数")) {
								break allDatasLoop;
							}
							break;
					
						case 1:
							jx11xuan5Result.setIssueNo(data);
							break;
							
						case 2:
						case 3:
						case 4:
						case 5:
						case 6:
							jx11xuan5Result.addLotteryNo(data);
							break;
					}
				}
				jx11xuan5_B.add(jx11xuan5Result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getJX11XUAN5_C() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_JX11XUAN5_C);

			System.out.println(">>>>> 江西11選5_C [" + URL_JX11XUAN5_C + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.dt").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
				JX11XUAN5 jx11xuan5Result = new JX11XUAN5();

				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();

					switch (j) {
						case 0:
							jx11xuan5Result.setIssueNo(data);
							break;
							
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
							jx11xuan5Result.addLotteryNo(data);
							break;
					}
				}
				jx11xuan5_C.add(jx11xuan5Result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getJX11XUAN5_D() {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();

			Document doc = getDocument(URL_JX11XUAN5_D);

			System.out.println(">>>>> 江西11選5_D [" + URL_JX11XUAN5_D + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.today").first();
			if (tableOfResult == null) {
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
				JX11XUAN5 jx11xuan5Result = new JX11XUAN5();
				
				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
					
					switch (j) {
						case 0:
							jx11xuan5Result.setIssueNo(data);
							break;
							
						case 2:
							Elements lotteryNos = tdOfResult.select("em");
							for (Element lotteryNo : lotteryNos) {
								String no = lotteryNo.text();
								jx11xuan5Result.addLotteryNo(no);
							}
							break;
					}
				}
				jx11xuan5_D.add(jx11xuan5Result);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Class<?>[] getStringParameter() {
		Class<?>[] paramString = new Class[1];
		paramString[0] = String.class;
		return paramString;
	}
	
	@SuppressWarnings("unchecked")
	private void getSSCFromCaipiaokong(Class<?> clz, String name, String url, Object resultList) {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
			
			// 這邊塞 cookie 就不會被判斷未登入或請先註冊
			Document doc = getDocument(url, createCookieForCaipiaokong());
			
			System.out.println(">>>>> " + name + " [" + url + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
	
			Element tableOfResult = doc.select("table.dt").first();
			
			int currentRetryTimes = 1;
			boolean isFailed = false;
			while (tableOfResult == null && currentRetryTimes++ <= RETRY_TIMES) {
				System.out.println("網站偵測到未登入, 5秒後, 嘗試重新取得...");
				try {
					Thread.sleep(RETRY_INTERVAL);
				} catch (InterruptedException e) {}
				doc = getDocument(url, createCookieForCaipiaokong());
				tableOfResult = doc.select("table.dt").first();
				
				isFailed = tableOfResult == null;
			}
			
			if (isFailed) {
				System.out.println("抓取失敗...");
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
	
			for (int i = 1; i < trsOfResult.size(); i++) {
				Class<?> cls = Class.forName(clz.getName());
				Object instance = cls.newInstance();
	
				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
	
					Method method = null;
					switch (j) {
						case 0:
							method = cls.getDeclaredMethod("setIssueNo", getStringParameter()); 
							method.invoke(instance, data);
							break;
							
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
							method = cls.getDeclaredMethod("addLotteryNo", getStringParameter());
							method.invoke(instance, data);
							break;
							
						case 6:
							method = cls.getDeclaredMethod("setType", getStringParameter());
							method.invoke(instance, data);
							break;
							
						case 7:
							method = cls.getDeclaredMethod("setSumOf3Star", getStringParameter());
							method.invoke(instance, data);
							break;
							
						case 8:
							method = cls.getDeclaredMethod("setBigSmallOf2Star", getStringParameter());
							method.invoke(instance, data);
							break;
							
						case 9:
							method = cls.getDeclaredMethod("setOddEvenOf2Star", getStringParameter());
							method.invoke(instance, data);
							break;
							
						case 10:
							method = cls.getDeclaredMethod("setSumOf2Star", getStringParameter());
							method.invoke(instance, data);
							break;
					}
				}
				((List<Object>) resultList).add(instance);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void get11xuan5FromTrendBaidu(Class<?> clz, String name, String url, Object resultList) {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
	
			Document doc = getDocument(url);
	
			System.out.println(">>>>> " + name + " [" + url + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element divOfResults = doc.select("div.chart_table_wrapper").first();
			int currentRetryTimes = 1;
			boolean isFailed = false;
			while (divOfResults == null && currentRetryTimes++ <= RETRY_TIMES) {
				System.out.println("抓取失敗, 5秒後, 嘗試重新取得...");
				try {
					Thread.sleep(RETRY_INTERVAL);
				} catch (InterruptedException e) {}
				doc = getDocument(url, createCookieForCaipiaokong());
				divOfResults = doc.select("div.chart_table_wrapper").first();
				
				isFailed = divOfResults == null;
			}
			
			if (isFailed) {
				System.out.println("抓取失敗...");
				System.out.println(doc);
				return;
			}
			
			Element tableOfResults = divOfResults.select("table.chart_table").first();
			Element tbodyOfResults = tableOfResults.select("tbody").first();
			Elements trsOfResults = tbodyOfResults.select("tr");
					
			allDatasLoop:
			for (int i = 0; i < trsOfResults.size(); i++) {
				Class<?> cls = Class.forName(clz.getName());
				Object instance = cls.newInstance();
				
				Element trOrResult = trsOfResults.get(i);
				Elements tdsOfResult = trOrResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
					
					Method method = null;
					switch (j) {
						case 0:
							if (data.equals("总次数")) {
								break allDatasLoop;
							}
							break;
					
						case 1:
							method = cls.getDeclaredMethod("setIssueNo", getStringParameter());
							method.invoke(instance, data);
							break;
							
						case 2:
						case 3:
						case 4:
						case 5:
						case 6:
							method = cls.getDeclaredMethod("addLotteryNo", getStringParameter());
							method.invoke(instance, data);
							break;
					}
				}
				((List<Object>) resultList).add(instance);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void get11xuan5FromCaipiaokong(Class<?> clz, String name, String url, Object resultList) {
		long startTime = 0;
		try {
			startTime = System.currentTimeMillis();
	
			// 這邊塞 cookie 就不會被判斷未登入或請先註冊
			Document doc = getDocument(url, createCookieForCaipiaokong());
	
			System.out.println(">>>>> " + name + " [" + url + "], 取得 Document, time-spent: " + (System.currentTimeMillis() - startTime) + " ms");
			
			Element tableOfResult = doc.select("table.dt").first();

			int currentRetryTimes = 1;
			boolean isFailed = false;
			while (tableOfResult == null && currentRetryTimes++ <= RETRY_TIMES) {
				System.out.println("網站偵測到未登入, 5秒後, 嘗試重新取得...");
				try {
					Thread.sleep(RETRY_INTERVAL);
				} catch (InterruptedException e) {}
				doc = getDocument(url, createCookieForCaipiaokong());
				tableOfResult = doc.select("table.dt").first();
				
				isFailed = tableOfResult == null;
			}
			
			if (isFailed) {
				System.out.println("抓取失敗...");
				System.out.println(doc);
				return;
			}
			
			Element tbodyOfResult = tableOfResult.select("tbody").first();
			Elements trsOfResult = tbodyOfResult.select("tr");
			
			for (int i = 1; i < trsOfResult.size(); i++) {
				Class<?> cls = Class.forName(clz.getName());
				Object instance = cls.newInstance();
	
				Element trOfResult = trsOfResult.get(i);
				Elements tdsOfResult = trOfResult.select("td");
				for (int j = 0; j < tdsOfResult.size(); j++) {
					Element tdOfResult = tdsOfResult.get(j);
					String data = tdOfResult.text();
	
					Method method = null;
					switch (j) {
						case 0:
							method = cls.getDeclaredMethod("setIssueNo", getStringParameter()); 
							method.invoke(instance, data);
							break;
							
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
							method = cls.getDeclaredMethod("addLotteryNo", getStringParameter()); 
							method.invoke(instance, data);
							break;
					}
				}
				((List<Object>) resultList).add(instance);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	private Map<String, String> createCookieForCaipiaokong() {
		Map<String, String> cookie = new HashMap<String, String>();
		cookie.put("caipiaokong_4891_saltkey", "dmbgCWDB");
		cookie.put("caipiaokong_4891_lastvisit", "1478594642");
		cookie.put("caipiaokong_4891_caipiaokong_ySn", "1");
		cookie.put("aliyungf_tc", "AQAAACukZw30uQEAH7P7PP7uow8Wx4Gz");
		cookie.put("acw_tc", "AQAAAF4GchnofwIAH7P7PBo1BeMPzy0e");
		cookie.put("caipiaokong_4891_caipiaokong_ZXC", "1");
		cookie.put("caipiaokong_4891_lastact", "1478768045%09index.php%09tjssc");
		cookie.put("Hm_lvt_1fa650cb7d8eae53d0e6fbd8aec3eb67", "1478598245,1478741515");
		cookie.put("Hm_lpvt_1fa650cb7d8eae53d0e6fbd8aec3eb67", "1478768047");
		return cookie;
	}

	private Document getDocument(String url) throws IOException {
		return getDocument(url, null);
	}

	private Document getDocument(String url, Map<String, String> cookie) throws IOException {
		Connection connection = Jsoup.connect(url);
		connection.timeout(CONNECTION_TIMEOUT);
		connection.userAgent(CONNECTION_USER_AGENT);
		if (cookie != null) {
			connection.cookies(cookie);
		}
		Document doc = connection.get();
		return doc;
	}

	private <T> void showResults(List<T> results) {
		for (T result : results) {
			System.out.println(result);
		}
		System.out.println();
	}
	
	private void outputResults() {
		File outputFile = new File(OUTPUT_FILE_PATH);
		
		if (outputFile.isFile()) {
			outputFile.delete();
			System.out.println("刪除現有檔案: " + OUTPUT_FILE_PATH + " -> 成功");
		}
		
		System.out.println(">>>>> 開始將結果寫至: " + OUTPUT_FILE_PATH);
		
		try (RandomAccessFile writer = new RandomAccessFile(outputFile, "rw")) {
			writeResults(writer, NAME_TJSSC_C, URL_TJSSC_C, tjssc_C);
			
			writeResults(writer, NAME_TJSSC_D, URL_TJSSC_D, tjssc_D);

			writeResults(writer, NAME_XJSSC_A, URL_XJSSC_A, xjssc_A);
			
			writeResults(writer, NAME_XJSSC_C, URL_XJSSC_C, xjssc_C);
			
			writeResults(writer, NAME_XJSSC_D, URL_XJSSC_D, xjssc_D);
			
			writeResults(writer, NAME_CQSSC_A, URL_CQSSC_A, cqssc_A);

			writeResults(writer, NAME_CQSSC_C, URL_CQSSC_C, cqssc_C);

			writeResults(writer, NAME_CQSSC_D, URL_CQSSC_D, cqssc_D);

			writeResults(writer, NAME_SD11XUAN5_A, URL_SD11XUAN5_A, sd11xuan5_A);
			
			writeResults(writer, NAME_SD11XUAN5_C, URL_SD11XUAN5_C, sd11xuan5_C);
			
			writeResults(writer, NAME_SD11XUAN5_D, URL_SD11XUAN5_D, sd11xuan5_D);

			writeResults(writer, NAME_GD11XUAN5_A, URL_GD11XUAN5_A, gd11xuan5_A);
			
			writeResults(writer, NAME_GD11XUAN5_B, URL_GD11XUAN5_B, gd11xuan5_B);
			
			writeResults(writer, NAME_GD11XUAN5_C, URL_GD11XUAN5_C, gd11xuan5_C);
			
			writeResults(writer, NAME_GD11XUAN5_D, URL_GD11XUAN5_D, gd11xuan5_D);
			
			writeResults(writer, NAME_JX11XUAN5_A, URL_JX11XUAN5_A, jx11xuan5_A);
			
			writeResults(writer, NAME_JX11XUAN5_B, URL_JX11XUAN5_B, jx11xuan5_B);
			
			writeResults(writer, NAME_JX11XUAN5_C, URL_JX11XUAN5_C, jx11xuan5_C);
			
			writeResults(writer, NAME_JX11XUAN5_D, URL_JX11XUAN5_D, jx11xuan5_D);
			
			System.out.println(">>>>> 結果產生完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private <T> void writeResults(RandomAccessFile writer, String name, String url, List<T> results) throws IOException {
		writer.write((">>>>> 項目: [" + name + "], URL: [" + url + "] <<<<<\n").getBytes());
		for (T result : results) {
			writer.write(result.toString().getBytes());
			writer.write("\n".getBytes());
		}
		writer.write("\n".getBytes());
	}

	public static void main(String[] args) {
		new TestGetLotteryResult().start();
	}
}
