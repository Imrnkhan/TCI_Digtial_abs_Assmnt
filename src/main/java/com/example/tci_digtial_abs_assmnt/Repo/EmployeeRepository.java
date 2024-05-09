package com.example.tci_digtial_abs_assmnt.Repo;

import com.example.tci_digtial_abs_assmnt.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
