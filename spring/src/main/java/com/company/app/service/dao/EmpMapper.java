package com.company.app.service.dao;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
	public List<Emp>getEmpList(EmpSearch emp);
	public int updateEmp(Emp emp);
	public Emp getEmp(Emp emp);//단건조회 메소드이름이랑 id일치
	public int insertEmp(Emp emp);
	public int deleteEMp(Emp emp);
	public int deleteMultiEmp(EmpSearch emp);
	public void insertEmpProc(Emp emp);
	public int getCount();
	public List<Map<String,Object>> getStatDept();
	public List<Jobs>jobSelect();
	public List<Dept>deptSelect();
}
