package com.company.app.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EmpDAOJdbcTemplate {
	final String SELECT="select * from employees";
	final String INSERT="insert into employees(employee_id,last_name,email,hire_date,job_id) values(?,?,?,sysdate,'IT_PROG')";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Map<String, Object>> getListMap(){
		return jdbcTemplate.queryForList(SELECT);
	}
	public void insert(Emp emp) {
		Object[] param=new Object[] {
				emp.getEmployeeId(),
				emp.getLastName(),
				emp.getEmail()
		};
		jdbcTemplate.update(INSERT,param);
	}
	public List<Emp>getList(){
		return jdbcTemplate.query(SELECT,new RowMapper<Emp>(){
			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp=new Emp();
				emp.setFirstName(rs.getString("fistname"));
				emp.setLastName(rs.getString("lat_name"));
				emp.setEmployeeId(rs.getString("employtt_id"));
				return emp;
			}});
	}
}
