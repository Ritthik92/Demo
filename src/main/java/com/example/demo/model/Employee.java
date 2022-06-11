package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Employee {

	@Id
	@Column(name="Emp_id")
	private Long id;
	@Column(name="Emp_Name")
	private String empName;
	@Column(name="Department")
	private String dept;

	public Employee(Long id, String empName, String dept) {
		this.id = id;
		this.empName = empName;
		this.dept = dept;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
