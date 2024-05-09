package com.example.tci_digtial_abs_assmnt.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class EmployeeBonusResponse {
    private String errorMessage;
    private List<EmployeeBonusData> data;

    public EmployeeBonusResponse() {
        this.data = new ArrayList<>();
    }
}
