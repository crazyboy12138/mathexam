package com.crazyboy.mathexam;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * TODO <BR>
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月7日
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {
	@Override    
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) 
	{        // 注意这里要指向原先用main方法执行的Application启动类        
		return builder.sources(MathexamApplication.class);
	}
}
