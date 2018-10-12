package com.crazyboy.mathexam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crazyboy.mathexam.mybatis.model.Unit;
import com.crazyboy.mathexam.service.impl.UnitService;
/**
 * unit相关controller
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月3日
 */
@RestController
@RequestMapping("unit")
public class UnitController {
	@Autowired
	UnitService unitService;
	
	/**
	 * 获取所有题目
	 * @return
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	@GetMapping("listAll")
	public List<Unit> listAll() {
		return unitService.selectAll();
	}
	
	/**
	 * 更新单元最高得分
	 * @param maxScore
	 * @param unitId
	 * @since v1.0 
	 * @creator lin.tingmin @ 2018年10月12日
	 */
	@GetMapping("updateMaxScore")
	public void updateMaxScore(int maxScore, int unitId) {
		System.out.println(maxScore + ", " + unitId);
		unitService.updateMaxScore(maxScore, unitId);
	}
}
