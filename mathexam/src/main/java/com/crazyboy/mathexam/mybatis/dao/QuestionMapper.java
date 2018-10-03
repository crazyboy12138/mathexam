package com.crazyboy.mathexam.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.crazyboy.mathexam.mybatis.model.Question;
@Mapper
public interface QuestionMapper{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer questionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbggenerated
     */
    int insert(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbggenerated
     */
    Question selectByPrimaryKey(Integer questionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbggenerated
     */
    List<Question> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Question record);
}