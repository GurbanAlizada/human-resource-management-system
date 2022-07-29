package com.example.service.inter;

import com.example.dtos.request.CityRequest;
import com.example.model.City;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public interface CityServiceInter {


    public City add(CityRequest cityRequest);
    List<City> getAll();




}
