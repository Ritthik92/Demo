package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

@RestController
public class Homecontroller {
	
	@Autowired
	EmployeeRepo emprepo;
	
	@GetMapping("/fetchemployees")
	public List<Employee> getEmployees(){
		
		return emprepo.findAll();
		
	}
	
	@PostMapping("/AddEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees){
		emprepo.saveAll(employees);
		return employees;
	}

	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable Long id) throws Exception {
		
		Employee emp=emprepo.findById(id).orElseThrow(()->new Exception("usernot found in the database with the specified id : "+id));
		
		emprepo.delete(emp);
		
		return "Employee Deleted";
		
	}
	
	@PostMapping("/AddEmployee")
	public String addEmployee(@RequestBody Employee employee){
		emprepo.save(employee);
		return "Employee Added in DB Successfully....";
	}
	
}
