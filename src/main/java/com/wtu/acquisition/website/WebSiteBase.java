package com.wtu.acquisition.website;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public abstract class WebSiteBase {
	private static Log LOG = LogFactory.getLog(WebSiteBase.class);
	SimpleDateFormat SDF =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected Map<String, String> usercookies;
	public WebSiteBase() {
		super();
		this.usercookies=login();
	}
	abstract Map<String,String> login();
	private Document getDocument(String url,WebClient webclient) {
		Document doc=null;
		HtmlPage page;
		try {
			page = (HtmlPage) webclient.getPage(url);
			doc=Jsoup.parse(page.asXml());
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
}
