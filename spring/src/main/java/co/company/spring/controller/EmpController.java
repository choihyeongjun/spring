package co.company.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.company.app.service.dao.Dept;
import com.company.app.service.dao.Emp;
import com.company.app.service.dao.EmpMapper;
import com.company.app.service.dao.EmpSearch;
import com.company.app.service.dao.Jobs;


@Controller
public class EmpController {
	@Autowired EmpMapper dao;
	
	@RequestMapping("/ajax/jobSelect")
	@ResponseBody //위에 그냥컨트롤 ㅇ리스폰스 바디 위에 래스트 컨트롤 그냥
	public List<Jobs>jobSelect(){
		return dao.jobSelect();
	}
	/*
	 * @RequestMapping(value="/empSelect",method=RequestMethod.GET) public String
	 * select(Model model,EmpSearch emp) {
	 * model.addAttribute("list",dao.getEmpList(emp)); return "select"; }
	 */
	@ModelAttribute("jobs")
	public List<Jobs>jobs(){
		return dao.jobSelect();
	}
	@ModelAttribute("dept")
	public List<Dept>depts(){
		return dao.deptSelect();
	}
	
	@RequestMapping(value="/empSelectM",method=RequestMethod.GET)
	public ModelAndView select(EmpSearch emp) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("list",dao.getEmpList(emp));
		mav.setViewName("select");
		return mav;
		
	}
	
	@GetMapping("/empinsertForm")
	public String insertForm(Model model,Emp emp) {
		//model.addAttribute("jobs",dao.jobSelect());
		//model.addAttribute("dept",dao.deptSelect());
		return "insert";
	}
	@GetMapping("/empUpdateForm")
	public String updateForm(Model model,Emp emp) {
		model.addAttribute("emp",dao.getEmp(emp));
	//	model.addAttribute("jobs",dao.jobSelect());
	//	model.addAttribute("dept",dao.deptSelect());
		return "insert";
	}
	/*@PostMapping("/empInsert")
	public String insert(HttpServletRequest request,@RequestParam(value="lastName",
							required=false,
							defaultValue="noname") String lName,
			@RequestParam(required=false)
	int salary,Emp emp) {
		String firstName=request.getParameter("firstName");
		System.out.println(lName+":"+firstName);
		System.out.println("emp\n"+emp);
		return "redirect:/empSelect";
	}*/
	@PostMapping("/empInsert")
	public String insert(Emp emp,Errors errors) {//emp말고 속성명 다르게 하고싶을때사용
		new EmpValidator().validate(emp,errors);
		if(errors.hasErrors()) {
			return "insert"; //에러있으면 등록페이지로감
		}
		dao.insertEmp(emp);
		/* return "redirect:/empSelect"; */
		//request.setAttribute("emp",emp);
		if(emp.getEmployeeId()==null)
			dao.insertEmp(emp);
		else
			dao.updateEmp(emp);
		return "insertOutput";
	}
	
	
}
