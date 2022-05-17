package in.himtech.test.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.himtech.test.demo.domain.Employee;
import in.himtech.test.demo.service.EmployeeService;
import in.himtech.test.demo.utilities.InvalidInputException;
import in.himtech.test.demo.utilities.ResourceNotFoundException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/add")
	public Employee addEmplyee(@RequestBody Employee employee) throws InvalidInputException {
		return service.addEmployee(employee);
	}

	@GetMapping
	public List<Employee> getAllEmployee() throws ResourceNotFoundException{
		return this.service.getAllEmployee();
	}
	
	@GetMapping("/{empId}")
	public Employee getEmployee(@PathVariable Integer empId) throws ResourceNotFoundException{
		return this.service.getEmployee(empId);
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId) throws ResourceNotFoundException{
		return new ResponseEntity<>(this.service.deleteEmployee(empId), HttpStatus.OK);
	}
}
