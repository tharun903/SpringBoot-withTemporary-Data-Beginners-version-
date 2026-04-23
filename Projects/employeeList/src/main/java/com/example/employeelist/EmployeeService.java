package com.example.employeelist;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
@Service
public class EmployeeService implements EmployeeRepository{
    private static HashMap<Integer, Employee> employeeList = new HashMap<>();
    int unique = 7;
    public EmployeeService() {
        employeeList.put(1, new Employee(1, "John Doe", "johndoe@example.com", "Marketing"));
        employeeList.put(2, new Employee(2, "Jane Smith", "janesmith@example.com", "Human Resources"));
        employeeList.put(3, new Employee(3, "Bob Johnson", "bjohnson@example.com", "Sales"));
        employeeList.put(4, new Employee(4, "Alice Lee", "alee@example.com", "IT"));
        employeeList.put(5, new Employee(5, "Mike Brown", "mbrown@example.com", "Finance"));
        employeeList.put(6, new Employee(6, "Sara Lee", "slee@example.com", "Operations"));

    }
    @Override
    public ArrayList<Employee> getEmployeeDetails() {
        Collection<Employee> details = employeeList.values();
        ArrayList<Employee> detail = new ArrayList<>(details);
        return detail;
    }

    @Override
    public Employee addEmployeeDetails(Employee employee) {
        employee.setEmployeeId(unique);
        employeeList.put(unique,employee);
        unique+=1;
        return employee;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee detailsId = employeeList.get(employeeId);
        if(detailsId == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return detailsId;

    }


    @Override
    public Employee updateEmployeDetails(int employeeId, Employee employee) {
        Employee ExistingDetails = employeeList.get(employeeId);;
        if( ExistingDetails == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(employee.getEmployeeName() != null){
            ExistingDetails.setEmployeeName(employee.getEmployeeName());
        }
        if(employee.getEmail() != null){
            ExistingDetails.setEmail(employee.getEmail());
        }
        if(employee.getDepartment() != null){
            ExistingDetails.setDepartment(employee.getDepartment());
        }
        return ExistingDetails;
    }

    public void deleteEmployeeDetails(int employeeId) {
        Employee details = employeeList.get(employeeId);
        if(details == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        employeeList.remove(details);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
