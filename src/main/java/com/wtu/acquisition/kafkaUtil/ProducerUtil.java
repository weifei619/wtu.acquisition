package com.wtu.acquisition.kafkaUtil;

import org.apache.commons.logging.Log;
import org.slf4j.LoggerFactory;

import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;




public final class ProducerUtil {
	private static Log log = (Log) LoggerFactory.getLogger(ProducerUtil.class);
    private static Producer<String,byte[]> instance=null;
    private ProducerUtil(ProducerConfig pc)
    {
    }
    public static synchronized void syncInit()
    {
    	 if(instance==null)
		 {
			 instance =new Producer<String,byte[]>(ProducerConfigUtil.getInstance());
		 }
    }
    public static Producer<String,byte[]> getInstance()
    {
    	 if(instance==null)
		 {
    		 syncInit();
		 }
    	 return instance;
    }
}
