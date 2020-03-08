package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;
	@GetMapping("/")
	public String displayHome(Model model)
	{
		//we are querying the database for projects           
		List<Project> project = proRepo.findAll();
		model.addAttribute("projectsList", project);
		
		//we are querying the database for employees
		//List<Employee> employee=empRepo.findAll(); 
		List<EmployeeProject> employee=empRepo.employeeProject(); 
		model.addAttribute("employeesListProjectsCnt", employee);
		return "main/home";
	}
	
}
