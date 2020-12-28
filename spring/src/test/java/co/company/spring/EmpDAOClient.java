package co.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.service.dao.EmpDAO;

import co.company.spring.config.DBConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class })
public class EmpDAOClient {
	@Autowired EmpDAO empDAO;
	@Test
	public void empdaotest() {
		System.out.println(empDAO.getList());
	}
}
