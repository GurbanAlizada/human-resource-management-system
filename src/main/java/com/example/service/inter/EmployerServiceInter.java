package com.example.service.inter;

import com.example.dtos.request.EmployerRequest;
import com.example.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerServiceInter  {

    Employer add(EmployerRequest employerRequest);

}
