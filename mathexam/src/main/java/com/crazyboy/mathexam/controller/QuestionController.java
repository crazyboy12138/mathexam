package com.crazyboy.mathexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crazyboy.mathexam.service.impl.QuestionService;

/**
 * TODO <BR>
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月3日
 */
@RestController
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@GetMapping("test")
	public void test() {
		questionService.test();
	}
}
