package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repo;
	
	public Employee createEmployee(Employee emp) {
		return repo.save(emp);
	}
	
	public Employee getEmployee(int id) {
		return repo.findById(id).get();
	}
	
	public Employee updateEmployee(Employee emp) {
		Employee temp = repo.findById(emp.getId()).get();
		temp.setEmail(emp.getEmail());
		temp.setName(emp.getName());
		return repo.save(emp);
	}
	
	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}
	
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
}
