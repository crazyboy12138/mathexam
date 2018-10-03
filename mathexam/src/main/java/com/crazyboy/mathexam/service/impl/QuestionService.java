package com.crazyboy.mathexam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crazyboy.mathexam.mybatis.dao.QuestionMapper;
import com.crazyboy.mathexam.mybatis.model.Question;

/**
 * TODO <BR>
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月3日
 */
@Service
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
}
