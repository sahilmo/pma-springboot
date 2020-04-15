package com.jrp.pma.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jrp.pma.entities.Project;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD,scripts = {"classpath:schema.sql","classpath:data.sql"}),
			@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD,scripts = "classpath:drop.sql")})
public class ProjectRepositoryIntegrationTest {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Test
	public void ifNewProjectSave_thenSuccess() {
		Project project = new Project("Ecom","COMPLETED" ,"Test Description" );
		proRepo.save(project);
		assertEquals(5,proRepo.findAll().size());
	}
	
}
