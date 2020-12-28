package com.company.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.app.emp.service.impl.EmpMapper;

@Controller
public class HomeController {
	@Autowired EmpMapper empMapper;
	@RequestMapping(value="/emplist")
	public String empList(Model model) {
		model.addAttribute("list",empMapper.getEmpList());
		return "";
	}
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("main/home");
	}
}
