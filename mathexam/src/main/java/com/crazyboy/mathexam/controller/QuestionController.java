package com.crazyboy.mathexam.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.crazyboy.mathexam.constant.Constant;
import com.crazyboy.mathexam.mybatis.model.Question;
import com.crazyboy.mathexam.service.impl.QuestionService;
import com.crazyboy.mathexam.util.RedisUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * question相关controller
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月3日
 */
@RestController
@RequestMapping("question")
@CrossOrigin
@Slf4j
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@Autowired
	RedisUtil redisUtil;
	
	/**
	 * 添加问题
	 * @param params
	 * @throws IOException
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	@GetMapping("insert")
	public void insert(@RequestParam() Map<String, Object> params) throws IOException {
		Question question = new Question();
		question.setUnitId(Integer.parseInt(params.get("unit").toString()));
		question.setContent(params.get("content").toString());
		question.setAnswer(params.get("answer").toString());
		
		Map<String, String> options = new HashMap();
		params.keySet().stream().forEach(x -> {
		    if(x.startsWith("option")) {
		    	char ch = x.charAt(x.toString().length() - 1);
		    	options.put(ch + "", params.get("option" + ch).toString());
		    }
		});
		question.setOptions(JSON.toJSONString(options));
		question.setUrls(redisUtil.get(params.get("timestamp").toString()));
		questionService.insert(question);
	}
	
	/**
	 * 根据questionId删除问题
	 * @param questionId
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	@GetMapping("delete")
	public void delete(int questionId) {
		questionService.delete(questionId);
	}
	
	/**
	 * 根据unitId，获取某一单元的所有题目
	 * @param unitId
	 * @return
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	@GetMapping("listQuestionByUnitId")
	public List<Question> listQuestionByUnitId(int unitId){
		return questionService.listQuestionByUnitId(unitId);
	}
	
	/**
	 * 上传图片
	 * 后端把图片的url放进list，把list的json字符串存进redis，key为前端传来的timestamp
	 * @param pictures
	 * @param timestamp
	 * @return
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	@PostMapping("uploadPic")
	public String uploadPic(MultipartFile[] pictures, String timestamp){
		log.info("timestamp: " + timestamp);
		File file = new File(Constant.PIC_STORE_PATH);
		file.mkdirs();
		List<String> urlList = new LinkedList();
		for(MultipartFile pic: pictures) {
			OutputStream os = null;
			try {
				File temp = new File(file, pic.getOriginalFilename());
				os = new BufferedOutputStream(new FileOutputStream(temp));
				log.info("图片完整路径：" + temp.getAbsolutePath());
				urlList.add(Constant.DOMAIN + pic.getOriginalFilename());
				os.write(pic.getBytes());
				os.flush();
			} catch (FileNotFoundException e) {
				log.warn("上传图片时，路径不存在", e);
			} catch (IOException e) {
				log.warn("", e);
			} finally {
				try {
					os.close();
				} catch (IOException e) {
					log.warn("OutputStream关闭发生异常", e);
				}
			}
		}
		redisUtil.set(timestamp, JSON.toJSONString(urlList));
		return "ok";
	}
	
	/**
	 * 根据questionId修改题干
	 * @param questionId
	 * @param content
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	@GetMapping("modifyContentByQuestionId")
	public void modifyContentByQuestionId(int questionId, String content) {
		questionService.modifyContentByQuestionId(questionId, content);
	}
	
	/**
	 * 修改题目选项
	 * @param questionId
	 * @param optionIndex
	 * @param content
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	@GetMapping("modifyOptions")
	public void modifyOptions(int questionId, int optionIndex, String content) {
		questionService.modifyOptions(questionId, optionIndex, content);
	}
}
