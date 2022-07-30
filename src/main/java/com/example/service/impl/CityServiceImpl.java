package com.example.service.impl;

import com.example.dtos.request.CityRequest;
import com.example.model.Advertisment;
import com.example.model.City;
import com.example.repository.CityRepository;
import com.example.service.inter.CityServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityServiceImpl implements CityServiceInter {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }



    @Override
    public City add(CityRequest cityRequest){
        City city = City.builder()
                .name(cityRequest.getName())
                .build();
        return cityRepository.save(city);
    }


    @Override
    public List<City> getAll(){
        return cityRepository.findAll();
    }






}
