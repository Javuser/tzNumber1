package org.example.tznumber1.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.tznumber1.entity.Employee;
import org.example.tznumber1.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id " + id + " not found"));
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> searchEmployees(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return employeeRepository.findAll();
        }
        return employeeRepository.findByLastName(keyword);
    }
}
