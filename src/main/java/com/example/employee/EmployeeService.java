package com.example.employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee e) {
		return empDao.addEmployee(e);
	}

	public String listAllEmployee(List<Employee> e) {
		return empDao.listAllEmployee(e);
	}

	public Employee addEmployee(int e) {
		return empDao.addEmployee(e);
	}

	public List<Employee> addEmployee1() {
		return empDao.addEmployee1();
	}

	public String deleteEmployee(int e) {
		return empDao.deleteEmployee(e);
	}

	public String updateEmployee(Employee e) {
		return empDao.updateEmployee(e);
	}

	public List<Employee> getEmpByName(String name) {
		List<Employee> allEmp = empDao.addEmployee1();
		List<Employee> li = allEmp.stream().filter(x -> x.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		return li;

	}

	public Employee getMaxSalaryEmp() {
		List<Employee> maxprice = empDao.addEmployee1();
		Employee max = maxprice.stream().max(Comparator.comparing(Employee::getSalary)).get();
		return max;
	}

	public Employee getMinSalaryEmp() {
		List<Employee> minprice = empDao.addEmployee1();
		Employee min = minprice.stream().min(Comparator.comparing(Employee::getSalary)).get();
		return min;
	}

	public List<Employee> getage() {
		List<Employee> ages = empDao.addEmployee1();
		List<Employee> age1 = ages.stream().filter(x -> x.getAge() > 20).collect(Collectors.toList());
		return age1;
	}

	public List<Employee> findEmpBySalary(int sal1, int sal2) {
		return empDao.findEmpBySalary(sal1, sal2);
	}

	public List<Employee> findEmpByGender(String gender) {
		return empDao.findEmpByGender(gender);
	}

	public List<String> findname() {
		return empDao.findname();

	}

	public List<String> findNameAge() {
		return empDao.findNameAge();
	}

	public String addEmp(Employee e) {
		try {
			if (e.getAge() >= 18) {
				return empDao.addEmployee(e);
			} else {
				throw new AgeException("Below 18");
			}
		} catch (AgeException b) {
			b.printStackTrace();
			return "age Exception";
		}

	}

	public Employee getById(int id) throws EmployeeNotFoundException, Exception {
		return empDao.getById(id);
	}

	public List<Employee> getEmpName(String name) throws NameNotFoundException {
		List<Employee> li = empDao.getEmpName(name);
		List<Employee> s = li.stream().filter(x -> x.getName().equalsIgnoreCase(name)).toList();
		if (s.isEmpty()) {
			throw new NameNotFoundException();
		} else {
			return s;
		}
	}

	public List<Employee> findEmpSalary(int salary) throws SalaryNotFoundException {
		List<Employee> sal = empDao.findEmpSalary(salary);
		List<Employee> sal1 = sal.stream().filter(x -> x.getSalary() > salary).toList();
		if (sal1.isEmpty()) {
			throw new SalaryNotFoundException();
		} else {
			return sal1;
		}
	}

}
