package org.example.tznumber1.service;


import org.example.tznumber1.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
    List<Employee> searchEmployees(String keyword);
}
