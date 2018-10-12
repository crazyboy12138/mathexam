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
 * question相关业务逻辑
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月3日
 */
@Service
@Slf4j
public class QuestionService{
	@Autowired
	QuestionMapper questionMapper;
	
	/**
	 * 添加题目
	 * @param question
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	public void insert(Question question) {
		questionMapper.insert(question);
	}
	
	/**
	 * 根据questionId删除题目
	 * @param questionId
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	public void delete(int questionId) {
		questionMapper.deleteByPrimaryKey(questionId);
	}
	
	/**
	 * 根据unitId获取某一单元的所有题目
	 * @param unitId
	 * @return
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	public List<Question> listQuestionByUnitId(int unitId){
		return questionMapper.selectByUnitId(unitId);
	}
	
	/**
	 * 修改题干
	 * @param questionId
	 * @param content
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	public void modifyContentByQuestionId(int questionId, String content) {
		questionMapper.modifyContentByPrimaryKey(questionId, content);
	}
	
	/**
	 * 修改选项
	 * 先获取原有选项的json字符串，转成JSONObject，修改后，转成json字符串存进数据库
	 * 
	 * @param questionId
	 * @param optionIndex
	 * @param content
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
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
