package com.wtu.acquisition.kafka;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.commons.logging.Log;
import org.slf4j.LoggerFactory;

import com.wtu.acquisition.kafkaUtil.ProducerUtil;
import com.wtu.acquisition.solr.IndexDocVO;
import com.wtu.acquisition.sys.filewatch.SysConfig;
import com.wtu.acquisition.util.Util;

import kafka.producer.KeyedMessage;
import kafka.producer.Producer;

public final class Myproducer {
	private static Log log = (Log) LoggerFactory.getLogger(Myproducer.class);
	public static Producer<String, byte[]> p=ProducerUtil.getInstance();
	private static final String KAFA_TOPIC=SysConfig.getIndexConfig("kafka_topic");
	private Myproducer()
	{
	}
	public static void sendToKafka(IndexDocVO vo) throws IOException
	{
		if(null==vo)
		{
		   log.error("VO错误:"+vo);
		   return;
		}
		String shareurl =vo.getShareurl();
		if(shareurl==null||shareurl.isEmpty())
		{
			Util.compressContent(vo);
		}
		byte[] bt=null;
		ByteArrayOutputStream obj=new ByteArrayOutputStream();
		ObjectOutputStream out =new ObjectOutputStream(obj);
		out.writeObject(vo);
		bt=obj.toByteArray();
		KeyedMessage<String,byte[]> d =new KeyedMessage<String,byte[]>(KAFA_TOPIC,bt);
//		p.send(d);
//		p.send(d);
	}
}