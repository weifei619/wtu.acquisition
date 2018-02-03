package com.wtu.acquisition.website;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.wtu.acquisition.util.Util;

public class stackoverflowAcquisition extends WebSiteBase {
	private static Logger log = Log.getLogger(stackoverflowAcquisition.class);
	private final static int retryNum = 3;

	public static void main(String[] args) {

	}

	public void process() {
		String pageTemplate = "http://stackoverflow.com/questions?page=%s&sort=newest&pagesize=50";
		int totalPage = getTotalPageNum(pageTemplate);
		walkPage(pageTemplate, 1, totalPage);
	}

	private void walkPage(String pageTemplate, int beginPage, int totalPage) {
		for (int i = beginPage; i <= totalPage; i++) {
			Document doc = connectByTimes(String.format(pageTemplate, i), retryNum);
			Elements eles = doc.select("#question div.question-summary");
			for (Element ele : eles) {
				String createTime = ele.select("span.relativetime").first().attr("title").replace("Z", "");
				Date currentDate = Util.parserDate(createTime, "yyyy-MM-dd HH:mm:ss");
				// 更新增量
				Element nameEle = ele.select("a.question-hyperlink").first();
				String title = Util.cutHtmlTag(nameEle.text());
				String url = "http://stackoverflow.com" + nameEle.attr("href");

			}
		}
	}
   //执行次数，频率
	private Document connectByTimes(String url, int times) {
		Document doc = null;
		for (int j = 0; j < times; j++) {
			try {
				doc = Jsoup.connect(url).get();
				break;
			} catch (IOException e) {
				try {
					Thread.sleep(1 * 1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}
		return doc;
	}

	/**
	 * 得到页面总数
	 * 
	 * @param pageTemplate
	 * @return
	 */
	private int getTotalPageNum(String pageTemplate) {
		Document pageDoc = connectByTimes(String.format(pageTemplate, "1"), retryNum);
		Elements pageEles = pageDoc.select("div.pager span.page-numbers");
		int totalPage = Integer.parseInt(pageEles.get(pageEles.size() - 2).text());
		return totalPage;
	}

	// 不用登录
	@Override
	Map<String, String> login() {
		return null;
	}
}
