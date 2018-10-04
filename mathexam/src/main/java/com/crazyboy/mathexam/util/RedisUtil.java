package com.crazyboy.mathexam.util;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crazyboy.mathexam.constant.Constant;
import com.crazyboy.mathexam.constant.RedisConfig;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * TODO <BR>
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月4日
 */
@Slf4j
@Component
public class RedisUtil {
	@Autowired
	private RedisConfig redisConfig;

	private static RedisUtil util;
	private static Jedis jedis;
	private static JedisPool pool;

	/**
	 * 在构造方法之后执行
	 * 
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年8月20日
	 */
	@PostConstruct
	public void beforeInit() {
		util = this;
		
		//如果配置有密码用第一个构造函数
		if(StringUtil.isStringValid((util.redisConfig.getPassword()))) {
			System.out.println("pass exists: " + util.redisConfig.getPassword());
			pool = new JedisPool(new JedisPoolConfig(), util.redisConfig.getHost(), util.redisConfig.getPort(), util.redisConfig.getTimeout(), util.redisConfig.getPassword());
		} else {
			pool = new JedisPool(new JedisPoolConfig(),  util.redisConfig.getHost(),  util.redisConfig.getPort());
		}
	}

	
	/**
	 * 将键值对存入redis的map
	 * 
	 * @Param mapName map名
	 * 
	 * @Param key
	 * 
	 * @Param value
	 */
	public static void hset(String mapName, String key, String value) {
		try(Jedis jedis = pool.getResource()){
			jedis.hset(Constant.REDIS_PREFIX + mapName, key, value);
		}
	}

	/**
	 * 根据key获取redis map对应的值
	 */
	public static String hget(String mapName, String key) {
		String res = null;
		try(Jedis jedis = pool.getResource()){
			res = jedis.hget(Constant.REDIS_PREFIX + mapName,  key);
		}
		return res;
	}

	/**
	 * 判断redis中是否存在某key
	 */
	public static boolean exists(String key) {
		boolean res = false;
		try(Jedis jedis = pool.getResource()){
			res = jedis.exists(Constant.REDIS_PREFIX + key);
		}
		return res;
	}
	
	
	/**
	 * 设置过期时间
	 * @param key 
	 * @param seconds
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年8月17日
	 */
	public static void expire(String key, int seconds) {
		try(Jedis jedis = pool.getResource()){
			jedis.expire(Constant.REDIS_PREFIX + key, seconds);
		}
	}
	
	public static void set(String key, String value) {
		try(Jedis jedis = pool.getResource()){
			jedis.set(Constant.REDIS_PREFIX + key,  value);
		}
	}
	
	public static String get(String key) {
		try(Jedis jedis = pool.getResource()){
			return jedis.get(Constant.REDIS_PREFIX + key);
		}
	}
}
