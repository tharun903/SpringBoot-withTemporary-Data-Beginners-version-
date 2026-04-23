package com.example.employeelist;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployeeDetails(){
        return service.getEmployeeDetails();
    }

    @PostMapping("/employees")
    public Employee addEmployeeDetails(@RequestBody Employee employee){
        return service.addEmployeeDetails(employee);
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId){
        return service.getEmployeeById(employeeId);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployeDetails(@PathVariable("employeeId") int employeeId,@RequestBody Employee employee){
        return service.updateEmployeDetails(employeeId,employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployeeDetails(@PathVariable("employeeId") int employeeId){
        service.deleteEmployeeDetails(employeeId);
    }
}
