package com.crazyboy.mathexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crazyboy.mathexam.mybatis.model.Unit;
import com.crazyboy.mathexam.service.impl.UnitService;
/**
 * TODO <BR>
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月3日
 */
@RestController
@RequestMapping("unit")
public class UnitController {
	@Autowired
	UnitService unitService;
	
	@GetMapping("insert")
	public String insert(Unit unit) {
		unitService.insert(unit);
		return "ok";
	}
}
