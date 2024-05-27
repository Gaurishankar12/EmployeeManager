package com.project.employeemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeemanager.entity.Employee;
import com.project.employeemanager.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl serv;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list = serv.findAllEmployee();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id){
		Employee employee = serv.findEmployeeById(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee emp = serv.addEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee emp = serv.updateEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
		 serv.deleteEmployee(id);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
}
