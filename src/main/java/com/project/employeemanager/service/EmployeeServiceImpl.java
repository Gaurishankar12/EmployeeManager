package com.project.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.employeemanager.entity.Employee;
import com.project.employeemanager.exception.UserNotFoundException;
import com.project.employeemanager.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return repo.save(employee);
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repo.save(employee);
	}

	@Override
	public Employee findEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()-> new UserNotFoundException("User by id: "+id+"was not found"));
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		repo.deleteEmployeeById(id);
	}

}
