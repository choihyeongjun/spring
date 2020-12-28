package co.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.service.dao.Emp;
import com.company.app.service.dao.EmpDAOJdbcTemplate;

import co.company.spring.config.DBConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class })
public class EmpDaoJdbcTemplateClient {
	@Autowired EmpDAOJdbcTemplate empDAO;
	@Test
	public void empdaotest() {
		System.out.println(empDAO.getListMap());
	}
	@Test
	public void empinserttest() {
		Emp emp=new Emp();
		emp.setLastName("aa");
		emp.setEmail("a@a");
		emp.setEmployeeId("2504");
		empDAO.insert(emp);
	}
}
