package com.example.tci_digtial_abs_assmnt.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeBonusData {
    private String currency;
    private List<EmployeeBonus> employees;

    public EmployeeBonusData() {
        this.employees = new ArrayList<>();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<EmployeeBonus> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeBonus> employees) {
        this.employees = employees;
    }
}
