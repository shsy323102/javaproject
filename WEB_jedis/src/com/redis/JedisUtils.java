package com.redis;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
	static JedisPool pool = null;
	static {
		InputStream in = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JedisPoolConfig poolconfig = new JedisPoolConfig();
		int maxidle = Integer.parseInt(pro.getProperty("maxidle"));
		poolconfig.setMaxIdle(maxidle);
		poolconfig.setMinIdle(Integer.parseInt(pro.getProperty("minidle").toString()));
		poolconfig.setMaxTotal(Integer.parseInt(pro.getProperty("maxtotal").toString()));
		pool = new JedisPool(poolconfig,pro.getProperty("url"),Integer.parseInt(pro.getProperty("port").toString()));	
	}
	public static Jedis getJedis() {
		return pool.getResource();
	}
}
