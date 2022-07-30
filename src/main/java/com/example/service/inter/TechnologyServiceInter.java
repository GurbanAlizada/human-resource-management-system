package com.example.service.inter;

import com.example.dtos.request.TechnologyRequest;
import com.example.model.Technology;

public interface TechnologyServiceInter {
    public Technology addTechnology(TechnologyRequest technologyRequest);
}
