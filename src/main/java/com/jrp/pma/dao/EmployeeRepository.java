package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Override
	List<Employee> findAll();
	
	@Query(nativeQuery=true, value="SELECT E.FIRST_NAME firstName,E.LAST_NAME lastName,COUNT(PE.EMPLOYEE_ID) projectCount " + 
			"FROM EMPLOYEE E LEFT JOIN PROJECT_EMPLOYEE PE ON E.EMPLOYEE_ID = PE.EMPLOYEE_ID " + 
			"GROUP BY E.FIRST_NAME,E.LAST_NAME " + 
			"ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProject();

}
