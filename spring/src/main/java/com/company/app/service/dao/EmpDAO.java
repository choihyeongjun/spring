package com.company.app.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EmpDAO {
	@Autowired DataSource ds;
	Connection conn;
	PreparedStatement psmt;
	final String SELECT="select * from employees";
	final String INSERT="insert into employees(employee_id,last_name,email,hire_date,job_id) values(?,?,?,sysdate,'IT_PROG')";
	public void insert(Emp emp) {
		try {
			conn=ds.getConnection();
			psmt=conn.prepareStatement(INSERT);
			psmt.setString(1,emp.getEmployeeId());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Emp>getList(){
		ArrayList<Emp>list=new ArrayList<Emp>();
		try {
			conn=ds.getConnection();
			psmt=conn.prepareStatement(SELECT);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				Emp emp=new Emp();
				emp.setFirstName(rs.getString("fistname"));
				emp.setLastName(rs.getString("lat_name"));
				emp.setEmployeeId(rs.getString("employtt_id"));
				list.add(emp);
			}
		}catch(Exception e) {
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
