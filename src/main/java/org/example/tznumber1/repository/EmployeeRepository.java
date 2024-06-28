package org.example.tznumber1.repository;

import org.example.tznumber1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByLastName(String lastName);
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByCountry(String country);
    List<Employee> findByCity(String city);


}
