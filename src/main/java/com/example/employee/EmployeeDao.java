package com.example.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;

	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "Successful saved";
	}

	public String listAllEmployee(List<Employee> e) {
		empRepo.saveAll(e);
		return "Successful saved";
	}

	public Employee addEmployee(int e) {
		return empRepo.findById(e).get();

	}

	public List<Employee> addEmployee1() {

		return empRepo.findAll();
	}

	public String deleteEmployee(int e) {
		empRepo.deleteById(e);
		return "Successfully deleted";
	}

	public String updateEmployee(Employee e) {
		empRepo.save(e);
		return "Updated successfully";
	}

	public List<Employee> findEmpBySalary(int sal1, int sal2) {
		return empRepo.getBySalary(sal1, sal2);
	}

	public List<Employee> findEmpByGender(String gender) {
		return empRepo.getByGender(gender);
	}

	public List<String> findname() {
		return empRepo.getname();
	}

	public List<String> findNameAge() {
		return empRepo.getNameAge();
	}

	public Employee getById(int id) throws EmployeeNotFoundException, Exception {
		return empRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException());
	}

	public List<Employee> getEmpName(String name) {
		return empRepo.findAll();
	}

	public List<Employee> findEmpSalary(int salary) {
		return empRepo.findAll();
	}

}