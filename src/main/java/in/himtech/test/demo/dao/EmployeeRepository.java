package in.himtech.test.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.himtech.test.demo.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
