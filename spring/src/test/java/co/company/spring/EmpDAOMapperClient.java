package co.company.spring;


import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.service.dao.Emp;
import com.company.app.service.dao.EmpMapper;
import com.company.app.service.dao.EmpSearch;

import co.company.spring.config.DBConfiguration;
import co.company.spring.config.MybatisConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { 
		DBConfiguration.class,
		MybatisConfiguration.class})
public class EmpDAOMapperClient {
	@Autowired EmpMapper empDAO;
	
	@Test
	public void getstattest() {
		List<Map<String,Object>>list=empDAO.getStatDept();
		System.out.println(list.get(0));
	}
	//@Test
	public void Counttest() {
		System.out.println(empDAO.getCount());
	}
	//@Test
	public void InsertProcTest() {
		Emp emp=new Emp();
		
		emp.setLastName("choi");
		emp.setEmail("dedddsdd@a");
		emp.setJobId("IT_PROG");
		empDAO.insertEmpProc(emp);
		System.out.println(emp.getEmployeeId()+":"+emp.getMsg());
	}
	//@Test
	public void InsertTest() {
		Emp emp=new Emp();
		
		emp.setFirstName("ddd");
		emp.setLastName("choi");
		emp.setEmail("aaadd@a");
		emp.setHireDate(new Date(System.currentTimeMillis()));
		emp.setJobId("IT_PROG");
		empDAO.insertEmp(emp);
		System.out.println(emp.getEmployeeId());
	}
	//@Test
	public void deleteMULTTest() {
		EmpSearch emp=new EmpSearch();
		emp.setList(new String[] {"1000","1001"});
		empDAO.deleteMultiEmp(emp);
	}
	//@Test
	public void updateTest() {
		Emp emp=new Emp();
		emp.setEmployeeId("100");
		System.out.println(empDAO.getEmp(emp));
		emp.setFirstName("hong");
	//	emp.setEmployeeId("100");
		empDAO.updateEmp(emp);
		System.out.println(empDAO.getEmp(emp));
	}
	//@Test
	public void empdaotest() {
		EmpSearch empvo=new EmpSearch();
	//	empvo.setFirstName("ex");
		//empvo.setFirstName("pat");
		//empvo.setDepartmentId("20");
		
		empvo.setMinSalary(10000);
		empvo.setMaxSalary(20000);
		List <Emp> list=empDAO.getEmpList(empvo);
		for(Emp emp:list) {
			System.out.println(emp.getEmployeeId()+":"
					+emp.getFirstName()
					+emp.getDepartmentId()
					+":"+emp.getSalary()+":");
		
		
		}
	}
}
