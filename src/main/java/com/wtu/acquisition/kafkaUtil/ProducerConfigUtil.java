package com.wtu.acquisition.kafkaUtil;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import kafka.producer.ProducerConfig;

public class ProducerConfigUtil {
	private static Logger log = LoggerFactory.getLogger(ProducerConfigUtil.class);
	private static ProducerConfig instance = null;
	private static Properties props = null;

	public static final String ACTIONPATH = "system.properties";
	/**
	 * 属性文件
	 */
	public static Properties prop = new Properties();

	private ProducerConfigUtil(Properties props) {
	}

	static {
		Resource resource = new ClassPathResource(ACTIONPATH);
		try {
			prop = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			log.error("kafka初始化错误:"+e.getMessage());
		}
		props = new Properties();
		// 设置kafka服务器的列表，kafka集群包含多个服务器，这里制定一个服务器的子集
		props.put("metadata.broker.list", prop.getProperty("kafka.server"));

		// props.put("serializer.class","kafka.serializer.StringEncoder");
		// key.serializer.class默认为serializer.class
		// props.put("key.serializer.class")
		// "producer.type"默认值，sync决定消息是否应在一个后台线程异步发送，合法值为async，表示异步发送
		// sync表示异步发送，设置为async则允许批量发送请求，这回带来更高的吞吐量，但是client的机器挂了的话
		props.put("producer.type", "async");
		// queue.buffering.max.ms,默认值为5000
		props.put("queue.buffering.max.ms", "5000");
		// queue.buffering.max.messages,默认值10000，异步时缓冲最大时刻
		props.put("queue.buffering.max.messages", "10000");
		// 异步模式下，一个batch发送的消息数量，producer会等待知道要发送的消息数量达到这个值
		props.put("batch.num.message", "100");

		props.put("request.required.acks", "1");

	}

	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new ProducerConfig(props);
		}
	}

	public static ProducerConfig getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}

}
