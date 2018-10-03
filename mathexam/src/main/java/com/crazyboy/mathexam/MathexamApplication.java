package com.crazyboy.mathexam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.crazyboy.mathexam.mybatis.dao")
public class MathexamApplication {
	public static void main(String[] args) {
		SpringApplication.run(MathexamApplication.class, args);
	}
}
