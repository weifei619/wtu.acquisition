package com.wtu.acquisition.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.wtu.acquisition.sys.filewatch.SysConfig;

public class MongoUtil {
	private final static Logger LOG = (Logger) org.slf4j.LoggerFactory.getLogger(MongoUtil.class);

	private static String username = "";
	private static String password = "";
	private static String hostports = "";
	private static String database = "";

	public MongoUtil() {

	}

	static {
		hostports = SysConfig.getIndexConfig("mongo.port");
		database = SysConfig.getIndexConfig("mongo.database");
		username = SysConfig.getIndexConfig("mongo.username");
		password = SysConfig.getIndexConfig("mongo.password");
		mongoclient();
	}

	public static MongoClient mongoclient() {
		MongoClient mongoClient = null;
		List<ServerAddress> addrs = new ArrayList<ServerAddress>();
		// MongoClientOptions.Builder build = new MongoClientOptions.Builder();
		// build.connectionsPerHost(Integer.valueOf());
		// build.threadsAllowedToBlockForConnectionMultiplier(Integer.valueOf(maxWaitThread));
		// build.connectTimeout(Integer.valueOf(maxTimeOut) * 1000);
		// build.maxWaitTime(Integer.valueOf(maxWaitTime) * 1000);
		// MongoClientOptions options = build.build();
		for (String hostport : hostports.split(",")) {
			if (StringUtils.isBlank(hostport)) {
				continue;
			}
			hostport = hostport.trim();

			ServerAddress serverAddress = new ServerAddress(hostport.split(":")[0],
					Integer.valueOf(hostport.split(":")[1]));
			addrs.add(serverAddress);
		}

		MongoCredential credential = MongoCredential.createScramSha1Credential(username, database,
				password.toCharArray());
		List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		credentials.add(credential);

		mongoClient = new MongoClient(addrs, credentials/* , options */);
		return mongoClient;
	}

	/**
	 * 获取指定的集合
	 * 
	 * @param collectionName：要连接的集合
	 * @return
	 */
	public static DBCollection getDBCollection(String collectionName) {
		DBCollection dbCollection = null;
		if (collectionName == null) { // 如果为空则从配置文件中查找
			collectionName = SysConfig.getIndexConfig("collectionName");
		} else {
			DB db = mongoclient().getDB(database);
			dbCollection = db.getCollection(collectionName);
		}
		return dbCollection;
	}
}
