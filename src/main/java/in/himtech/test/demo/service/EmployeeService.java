package in.himtech.test.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.himtech.test.demo.dao.EmployeeRepository;
import in.himtech.test.demo.domain.Employee;
import in.himtech.test.demo.utilities.InvalidInputException;
import in.himtech.test.demo.utilities.ResourceNotFoundException;

@Component
public class EmployeeService {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeService.class.getName());
	
	
	@Autowired
	private EmployeeRepository empRepo;
	
	public List<Employee> getAllEmployee() throws ResourceNotFoundException {
		List<Employee> empList =  empRepo.findAll();
		if(empList.isEmpty()) {
			throw new ResourceNotFoundException("Data Not Found");
		}
		return empList;
	}
	
	public Employee getEmployee(Integer id) throws ResourceNotFoundException {
		return empRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
	}

	public Employee addEmployee(Employee employee) throws InvalidInputException {
		Employee persistEmp = null;
		if(employee != null) {			
			persistEmp = empRepo.save(employee);
		}else {
			throw new InvalidInputException("Invalid data");
		}
		return persistEmp;
	}
	
	public Employee updateEmployee(Employee employee) throws InvalidInputException {
		Employee persistEmp = null;
		if(employee != null && employee.getId() != null) {			
			persistEmp = empRepo.save(employee);
		} else {
			throw new InvalidInputException("Invalid data");
		}
		return persistEmp;
	}
	
	public String deleteEmployee(Integer id) throws ResourceNotFoundException {
		Employee emp =  empRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
		empRepo.delete(emp);
		return "Employee delete successfully";
	}

}
