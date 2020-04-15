package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService proService;
	@Autowired
	EmployeeService empService;

	@GetMapping("/")
	public String displayPrjects(Model model) {
		List<Project> project = proService.getAllPrjects();
		//model.addAttribute("projects", project);
		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String createProjectForm(Model model) {
		List<Employee> employees = empService.getAllEmployees();
		model.addAttribute("project", new Project());
		model.addAttribute("allEmployees", employees);
		return "projects/new-project";
	}

	@PostMapping("/save")
	public String processProjectForm(Project project, Model model) {
		proService.saveProject(project);
		//Iterable<Employee>chosenEmployees =empRepo.findAllById(employees);
		
		/*for(Employee emp : chosenEmployees)
		{
			emp.setProjects(project);
			empRepo.save(emp);
		}*/
		return "redirect:/projects/";
	}
}
