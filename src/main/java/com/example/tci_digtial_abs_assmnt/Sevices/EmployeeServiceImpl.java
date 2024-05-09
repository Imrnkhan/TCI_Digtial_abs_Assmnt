package com.example.tci_digtial_abs_assmnt.Sevices;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.example.tci_digtial_abs_assmnt.Model.Employee;
import com.example.tci_digtial_abs_assmnt.Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @Override
    public List<Employee> getEligibleEmployees(String date) {

        LocalDate customDate = parseCustom(date);

        return employeeRepository.findAll().stream()
                .filter(employee -> isActiveOnDate(employee, customDate))
                .collect(Collectors.toList());
    }

    private boolean isActiveOnDate(Employee employee, LocalDate date) {

        LocalDate joiningDate = parseCustom(employee.getJoiningDate());
        LocalDate exitDate = parseCustom(employee.getExitDate());
        return !date.isBefore(joiningDate) && (exitDate.isAfter(date) || exitDate.isEqual(date));
    }

    private static LocalDate parseCustom(String date) {
        String[] parts = date.split("-");

        if (parts.length != 3) throw new IllegalArgumentException("Invalid date format: " + date);

        String month = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase();
        String day = parts[1];
        String year = parts[2];

        String dateString = month+"-"+day+"-"+year;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy", Locale.ENGLISH);

        return LocalDate.parse(dateString, formatter);

    }
}