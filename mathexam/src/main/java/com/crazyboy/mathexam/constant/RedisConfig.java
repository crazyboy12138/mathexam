package com.crazyboy.mathexam.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 
 * TODO <BR>
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月4日
 */
@Component
@PropertySource(value = "classpath:application.properties")
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisConfig {
	private String host;
	private String password;
	private int port;
	private int timeout;
}
