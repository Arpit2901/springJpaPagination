package com.bhavna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.dao.EmployeeDao;
import com.bhavna.model.Employee;
import com.bhavna.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeDao dao;

	@PostMapping("/Employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee emp = this.employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	@GetMapping("/Employee/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable Integer id) {
		Employee emp = this.employeeService.getEmpById( id);
		return ResponseEntity.ok(emp);

	}
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok(this.employeeService.getAllEmployee());
	}

	@PutMapping("/Employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
		Employee emp = this.employeeService.updateEmployee(employee, id);
		return ResponseEntity.ok(emp);

	}

	@DeleteMapping("/Employee/{id}")
	public void deleteUser(@PathVariable Integer id) {
		this.employeeService.deleteEmployee(id);

	}

	@GetMapping("/Employees")
	Page<Employee> getEmployee(@RequestParam Optional<Integer> page) {
		return dao.findAll(PageRequest.of(0, 5));
	}

}
