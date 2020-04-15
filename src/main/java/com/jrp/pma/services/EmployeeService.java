package com.jrp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	public List<Employee> getAllEmployees() {
		List<Employee> employee = empRepo.findAll();
		return employee;
	}


	public void saveEmployee(Employee employee) {
		empRepo.save(employee);
	}
	
	public  List<EmployeeProject> employeeProject() {
		List<EmployeeProject> empPro = 	empRepo.employeeProject();
	return empPro;
	}
}