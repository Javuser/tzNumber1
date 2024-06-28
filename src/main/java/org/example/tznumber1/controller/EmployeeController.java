package org.example.tznumber1.controller;


import org.example.tznumber1.entity.Employee;
import org.example.tznumber1.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listEmployees(@RequestParam(required = false) String keyword, Model model) {
        List<Employee> employees = employeeService.searchEmployees(keyword);
        model.addAttribute("employees", employees);
        model.addAttribute("keyword", keyword);
        return "employee/employee_list";
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee/employee_form";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee()); // Передаем новый объект Employee для заполнения формы
        return "employee/employee_form";
    }

    @PostMapping
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @PostMapping("/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee) {
        employee.setId(id);
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
