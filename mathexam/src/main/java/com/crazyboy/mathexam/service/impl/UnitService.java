package com.crazyboy.mathexam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crazyboy.mathexam.mybatis.dao.UnitMapper;
import com.crazyboy.mathexam.mybatis.model.Unit;

/**
 * TODO <BR>
 * 
 * @author 15软件工程2班第六小组
 * @since lin.tingmin@2018年10月3日
 */
@Service
public class UnitService {
	@Autowired
	UnitMapper unitMapper;

	public void insert(Unit unit) {
		unitMapper.insert(unit);
	}

	public List<Unit> selectAll() {
		return unitMapper.selectAll();
	}

	public void updateMaxScore(int maxScore, int unitId) {
		unitMapper.updateMaxScore(maxScore, unitId);
	}
}
