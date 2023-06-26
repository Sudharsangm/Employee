package com.example.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Employee_Controller {
	@Autowired
	EmployeeService empSer;

	@PostMapping(value = "/add")
	public String addEmployee(@RequestBody Employee e) {
		return empSer.addEmployee(e);
	}

	@PostMapping(value = "/list")
	public String listAllEmployee(@RequestBody List<Employee> e) {
		return empSer.listAllEmployee(e);
	}

	@GetMapping(value = "/byid/{e}")
	public Employee addEmployee(@PathVariable int e) {
		return empSer.addEmployee(e);

	}

	@GetMapping(value = "/findall")
	public List<Employee> addEmployee1() {
		return empSer.addEmployee1();
	}

	@DeleteMapping(value = "/deletebyid/{e}")
	public String deleteEmployee(@PathVariable int e) {
		return empSer.deleteEmployee(e);
	}

	@PutMapping(value = "/update/{e}")
	public String updateEmployee(@RequestBody Employee e) {
		return empSer.updateEmployee(e);
	}

	@GetMapping(value = "/getByName/{name}")
	public List<Employee> getEmpByName(@PathVariable String name) {
		return empSer.getEmpByName(name);
	}

	@GetMapping(value = "/maxsalary")
	public Employee getMaxSalaryEmp() {
		return empSer.getMaxSalaryEmp();
	}

	@GetMapping(value = "/minsalary")
	public Employee getMinSalaryEmp() {
		return empSer.getMinSalaryEmp();
	}

	@GetMapping(value = "/age")
	public List<Employee> getage() {
		return empSer.getage();
	}

	@GetMapping(value = "/findbysalary/{sal1}/{sal2}")
	public List<Employee> findEmpBySalary(@PathVariable int sal1, @PathVariable int sal2) {
		return empSer.findEmpBySalary(sal1, sal2);
	}

	@GetMapping(value = "/findbygender/{gender}")
	public List<Employee> findEmpByGender(@PathVariable String gender) {
		return empSer.findEmpByGender(gender);

	}

	@GetMapping(value = "/getname")
	public List<String> findname() {
		return empSer.findname();
	}

	@GetMapping(value = "/getnameage")
	public List<String> findNameAge() {
		return empSer.findNameAge();
	}
	
	@PostMapping(value="/exception")
	public String addEmp(@RequestBody Employee e) {
		return empSer.addEmp(e);
	}
	
	@GetMapping(value="/employeeNotFoundException/{id}")
	public Employee getById(@PathVariable int id) throws EmployeeNotFoundException, Exception {
	return empSer.getById(id);
	}
	
	@GetMapping(value="/empByNameException/{name}")
	public List<Employee> getEmpName(@PathVariable String name) throws NameNotFoundException	{
		return empSer.getEmpName(name);
	}
	
	@GetMapping(value="/empSalaryException/{salary}")
	public List<Employee> findEmpSalary(@PathVariable int salary) throws SalaryNotFoundException{
		return empSer.findEmpSalary(salary);
	}
	
	
	
	
	
	
}