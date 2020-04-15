package com.jrp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entities.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository proRep;
	
	public List<Project> getAllPrjects() {
		List<Project> projects = proRep.findAll();
		return projects;
	}


	public void saveProject(Project project) {
		proRep.save(project);
	}
	
	public List<ChartData> getProjectStatus(){
		List<ChartData> chartData = proRep.getProjectStatus();
		return chartData;
	}
}
