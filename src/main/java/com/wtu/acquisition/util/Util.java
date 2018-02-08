package com.wtu.acquisition.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpStatus;
import org.springframework.context.ApplicationContext;

import com.wtu.acquisition.solr.IndexDocVO;

public class Util {

	private final static int MM = 1 * 1024 * 1024;
	private static ApplicationContext applicationContext;

	public static void setApplicationContext(ApplicationContext applicationContext) {
		Util.applicationContext = applicationContext;
	}

	// 得到bean
	public static Object getBeanByName(String name) {
		return applicationContext.getBean(name);
	}

	/**
	 * 返回int
	 * 
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	public static int parseInt(String str, int... defaultVal) {
		if (defaultVal.length > 0) {
			return defaultVal[0];
		}
		return Integer.parseInt(StringUtils.trim(str));
	}

	/**
	 * 返回日期
	 * 
	 * @param strdate
	 * @param pattern
	 * @return
	 */
	public static Date parserDate(String strdate, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(strdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 去掉html标签
	 * 
	 * @param content
	 * @return
	 */
	public static String cutHtmlTag(String content) {
		if (StringUtils.isBlank(content)) {
			return "";
		}
		String findStr = content.replaceAll("(\\s+)", " ").replaceAll("<[^<>]*>", " ").replaceAll("(&nbsp;)+", " ");
		return findStr;
	}

	/**
	 * 去掉url后面参数
	 *
	 * @param url
	 * @return
	 */
	public static String cutUrl(String url) {
		if (StringUtils.isBlank(url)) {
			return "";
		}
		if (url.indexOf("?") > 0) {
			url = url.substring(0, url.indexOf("?"));
		}
		return url;
	}

	public static void compressContent(IndexDocVO vo) throws IOException {
		String content = vo.getContent();
		String origcontent = content;
		if (content == null || content.isEmpty()) {
			return;
		}
		if (Util.isStringMorethan1M(content))
		{
			//压缩
	         // 创建一个新的 byte 数组输出流  
	         ByteArrayOutputStream out = new ByteArrayOutputStream();  
	         // 使用默认缓冲区大小创建新的输出流  
	         GZIPOutputStream gzip = new GZIPOutputStream(out);  
	         // 将 b.length 个字节写入此输出流  
	         gzip.write(origcontent.getBytes());  
	         // 使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串  
	         out.toString("ISO-8859-1");  
	         gzip.close();  
		}
	}
	public static String FileUpload(String url,File file,String key) throws Exception, IOException
	{
		String body="{}";
		if(url==null||url.equals(""))
		{
			return "参数不存在";
		}
		if(!file.exists())
		{
			return "上传的文件名不存在";
		}
		PostMethod postMethod=new PostMethod();
		//Filepart 用来上传文件的类
		FilePart fp=new FilePart("file",file.getName(),file);
		fp.setCharSet("utf-8");
		Part[] parts= {fp,new StringPart("key",key,"utf-8"),new StringPart("name",file.getName(),"utf-8")};
		MultipartRequestEntity mre =new MultipartRequestEntity(parts,postMethod.getParams());
		postMethod.setRequestEntity(mre);
		
		HttpClient client =new HttpClient();
		//由于上传文件可能比较大，会超时
		client.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
		
		int status=client.executeMethod(postMethod);
		if(status==HttpStatus.OK_200)
		{
			InputStream input=postMethod.getResponseBodyAsStream();
			BufferedReader bf=new BufferedReader(new InputStreamReader(input));
			StringBuffer sb=new StringBuffer();
			String str="";
			while((str=bf.readLine())!=null)
			{
				sb.append(str);
			}
			body=sb.toString();
		}
		else 
		{
			body="fail";
		}
		return body;
	}

	/**
	 * 判断压缩文件
	 * 
	 * @param content
	 * @return xxx
	 */
	public static boolean isStringMorethan1M(String content) {
		int finalSizeInBytes = content.getBytes().length;
		double finalSizeInMB = finalSizeInBytes / MM;
		return finalSizeInMB > 1;
	}
}
