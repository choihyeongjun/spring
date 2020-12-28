package com.company.app.emp.service.impl;

import java.util.List;

import com.company.app.emp.service.Dept;

public interface DeptMapper {
	public List<Dept>getDeptList();
	public Dept getDeptName(String id);
}

