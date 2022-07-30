package com.example.service.inter;

import com.example.dtos.request.EducationRequest;
import com.example.model.Education;

import java.util.List;

public interface EducationServiceInter {

    public Education addEducation(EducationRequest educationRequest);
    public List<Education> getAllBySorted(int id);

}
