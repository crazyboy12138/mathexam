package com.crazyboy.mathexam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crazyboy.mathexam.mybatis.dao.QuestionMapper;
import com.crazyboy.mathexam.mybatis.model.Question;

import lombok.extern.slf4j.Slf4j;


/**
 * TODO <BR>
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月3日
 */
@Service
@Slf4j
public class QuestionService{
	@Autowired
	QuestionMapper questionMapper;
	
	public void insert(Question question) {
		questionMapper.insert(question);
	}
	
	public void delete(int questionId) {
		questionMapper.deleteByPrimaryKey(questionId);
	}
	
	public List<Question> listQuestionByUnitId(int unitId){
		return questionMapper.selectByUnitId(unitId);
	}
	
	public void modifyContentByQuestionId(int questionId, String content) {
		questionMapper.modifyContentByPrimaryKey(questionId, content);
	}
	
	public void modifyOptions(int questionId, int optionIndex, String content) {
		String str = questionMapper.selectOptionsByPrimaryKey(questionId);
		log.info("oldjson: " + str);
		JSONObject json = JSON.parseObject(str);
		log.info("key: " + String.valueOf((char)('A' + optionIndex)));
		json.put(String.valueOf((char)('A' + optionIndex)), content);
		log.info("newjson: " + json.toJSONString());
		questionMapper.modifyOptionsByPrimaryKey(questionId, json.toJSONString());
	}
}
