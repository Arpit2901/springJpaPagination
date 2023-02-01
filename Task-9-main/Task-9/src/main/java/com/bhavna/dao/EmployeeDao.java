package com.bhavna.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bhavna.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>,PagingAndSortingRepository<Employee, Integer> {
//	List<Employee> findAllByPrice(double salary, Pageable pageable);
	Employee findById(int id);
}
