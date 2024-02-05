package com.demo.FinalProject.Service;

import java.util.List;

import com.demo.FinalProject.Model.Employee;

public interface EmpService {
	
	public Employee saveEmp(Employee emp);
    public List<Employee> getAllEmp();
    public Employee getEmpById(int id);
    public boolean deleteEmp(int id);

}
