package com.example.tci_digtial_abs_assmnt.Controllers;

import com.example.tci_digtial_abs_assmnt.Model.Employee;
import com.example.tci_digtial_abs_assmnt.Model.EmployeeBonus;
import com.example.tci_digtial_abs_assmnt.Model.EmployeeBonusData;
import com.example.tci_digtial_abs_assmnt.Model.EmployeeBonusResponse;
import com.example.tci_digtial_abs_assmnt.Sevices.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tci")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee-bonus")
    public ResponseEntity<String> storeEmployees(@RequestBody List<Employee> employees) {
        employeeService.saveEmployees(employees);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employees stored successfully");
    }

    @GetMapping("/employee-bonus")
    public ResponseEntity<EmployeeBonusResponse> getEligibleEmployees(@RequestParam String date) {
        List<Employee> eligibleEmployees = employeeService.getEligibleEmployees(date);
        EmployeeBonusResponse response = formatResponse(eligibleEmployees);
        return ResponseEntity.ok(response);
    }


    private EmployeeBonusResponse formatResponse(List<Employee> employees) {

        EmployeeBonusResponse response = new EmployeeBonusResponse();
        response.setErrorMessage("");
        EmployeeBonusData bonusData1 = new EmployeeBonusData();
        bonusData1.setCurrency("INR");
        EmployeeBonusData bonusData2 = new EmployeeBonusData();
        bonusData2.setCurrency("USD");

        for (Employee employee : employees) {
            EmployeeBonus bonus = new EmployeeBonus();
            bonus.setEmpName(employee.getEmpName());
            bonus.setAmount(employee.getAmount());

            if(employee.getCurrency().equalsIgnoreCase("INR")){
                bonusData1.getEmployees().add(bonus);
            } else if (employee.getCurrency().equalsIgnoreCase("USD")) {
                bonusData2.getEmployees().add(bonus);
            }

        }

        if(!bonusData1.getEmployees().isEmpty()) response.getData().add(bonusData1);
        if(!bonusData2.getEmployees().isEmpty())response.getData().add(bonusData2);

        return response;
    }
}
