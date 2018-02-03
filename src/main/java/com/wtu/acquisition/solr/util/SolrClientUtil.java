package com.wtu.acquisition.solr.util;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.eclipse.jetty.util.log.Log;
import org.slf4j.Logger;

import com.alibaba.fastjson.JSONObject;

public class SolrClientUtil {
   private Logger log = (Logger) Log.getLogger(SolrClientUtil.class);
   
   static {
	   
   }
   //单例连接solrclient，防止挂了继续连接
   
  //普通连接
   private static SolrClient getClient(String collection) 
   {
	   HttpSolrClient  solrClient =new HttpSolrClient ("http://192.168.243.3:8080/solr/"+collection);
	   return solrClient;
   }
   private static void deleteById(String id) {
	  JSONObject obj=new JSONObject();
	  obj.put("delete", id);
   }
}


