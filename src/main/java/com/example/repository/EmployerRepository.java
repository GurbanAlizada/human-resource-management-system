package com.example.repository;

import com.example.model.Employer;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer , Integer> {


}
