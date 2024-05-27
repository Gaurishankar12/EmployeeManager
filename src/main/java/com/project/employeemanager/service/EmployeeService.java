package com.project.employeemanager.service;

import java.util.List;

import com.project.employeemanager.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public List<Employee> findAllEmployee();
	public Employee updateEmployee(Employee employee);
	public Employee findEmployeeById(Long id);
	public void deleteEmployee(Long id);
}
