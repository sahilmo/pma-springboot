package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	@Override
	List<Project> findAll();
	
	@Query(nativeQuery = true,value = "SELECT STAGE as label,COUNT(*) as  value " + 
			"FROM PROJECT GROUP BY STAGE")
	
	List<ChartData> getProjectStatus();
	
	
}
