package com.project.employeemanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.employeemanager.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
		public Optional<Employee> findEmployeeById(Long id);
}
