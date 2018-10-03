package com.crazyboy.mathexam.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.crazyboy.mathexam.mybatis.model.Question;
import com.crazyboy.mathexam.service.impl.QuestionService;

/**
 * TODO <BR>
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月3日
 */
@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@GetMapping("insert")
	public void insert(@RequestParam() Map params) {
		Question question = new Question();
		question.setUnitId(Integer.parseInt(params.get("unit").toString()));
		question.setContent(params.get("content").toString());
		question.setAnswer(params.get("answer").toString());
		
		Map<String, String> options = new HashMap();
		params.keySet().stream().forEach(x -> {
		    if(x.toString().startsWith("option")) {
		    	char ch = x.toString().charAt(x.toString().length() - 1);
		    	options.put(ch + "", params.get("option" + ch).toString());
		    }
		});
		question.setOptions(JSON.toJSONString(options));
		
		questionService.insert(question);
	}
	
}
