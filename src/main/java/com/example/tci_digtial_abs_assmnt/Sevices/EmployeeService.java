package com.example.tci_digtial_abs_assmnt.Sevices;

import com.example.tci_digtial_abs_assmnt.Model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> saveEmployees(List<Employee> employees);
    List<Employee> getEligibleEmployees(String date);
}