package com.wtu.acquisition.website;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.gargoylesoftware.htmlunit.AjaxController;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.wtu.acquisition.sys.filewatch.SysConfig;
/**
 * 
 * @author weifei
 *
 */
public abstract class WebSiteBase {
	private static Log LOG = LogFactory.getLog(WebSiteBase.class);
	SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected Map<String, String> usercookies;

	public WebSiteBase() {
		super();
		this.usercookies = login();
	}

	abstract Map<String, String> login();

	/**
	 * 根据URL，webclient，，返回document
	 * 
	 * @param url
	 * @param webclient
	 * @return document
	 */
	private Document getDocument(String url, WebClient webclient) {
		Document doc = null;
		HtmlPage page;
		try {
			page = (HtmlPage) webclient.getPage(url);
			doc = Jsoup.parse(page.asXml());
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

	/**
	 * 获得最大页面数
	 * 
	 * @param homeDoc
	 * @param css
	 * @return maxPage
	 */
	protected int getmaxPage(Document homeDoc, String... css) {
		int maxPage = 1;
		String selectCss = "div.page a";
		if (css.length > 0) {
			selectCss = css[0];
		}
		String numText = homeDoc.select(selectCss).text();
		Matcher matcher = Pattern.compile("[0-9]+").matcher(numText);
		while (matcher.find()) {
			maxPage = Integer.max(maxPage, Integer.parseInt(matcher.group()));
		}
		return maxPage;
	}

	/**
	 * 模拟浏览器登录
	 * 
	 * @param client
	 * @param loginUrl
	 */
	protected void loginByWebClient(WebClient client, String loginUrl) {
		client.getOptions().setJavaScriptEnabled(true);
		client.getOptions().setCssEnabled(false);
		client.setAjaxController(new AjaxController());
		client.getOptions().setThrowExceptionOnScriptError(false);
		client.getOptions().setThrowExceptionOnFailingStatusCode(false);
		HtmlPage page;
		try {
			page = client.getPage(loginUrl);
			HtmlInput in = page.getHtmlElementById("uid");
			HtmlInput paw = page.getHtmlElementById("paw");
			HtmlInput submit = page.getElementByName("sumbit");
			in.setAttribute("value", SysConfig.getIndexConfig("web.login.name"));
			paw.setAttribute("pawword", SysConfig.getIndexConfig("web.login.password"));
			submit.click();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭client连接
	 * 
	 * @param client
	 */
	protected static void closeWebClient(WebClient client) {
		for (WebWindow win : client.getWebWindows()) {
			win.getJobManager().removeAllJobs();
		}
		client.closeAllWindows();
		System.gc();
	}
}
