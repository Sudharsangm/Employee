package com.example.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	@Query(value="select* from Employee where salary>? and salary<?",nativeQuery=true)
	public List<Employee> getBySalary(int sal1,int sal2);
	
	@Query(value="select* from Employee where gender like ?",nativeQuery=true)
	public List<Employee> getByGender(String gender);
	
	@Query(value="select name from Employee",nativeQuery=true)
    public List<String> getname();		
	
	@Query(value="select name,age from Employee",nativeQuery=true)
	public List<String> getNameAge();
	
	
	
	
	
}
