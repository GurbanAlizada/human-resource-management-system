package com.example.repository;

import com.example.model.Employee;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {


}
