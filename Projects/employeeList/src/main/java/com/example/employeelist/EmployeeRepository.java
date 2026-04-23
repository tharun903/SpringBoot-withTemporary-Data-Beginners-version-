package com.example.employeelist;

import java.util.ArrayList;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployeeDetails();

    Employee addEmployeeDetails(Employee employee);

    Employee getEmployeeById(int employeeId);

    Employee updateEmployeDetails(int employeeId, Employee employee);
}
