package com.example.service.inter;

import com.example.dtos.AdvertisementDto;
import com.example.dtos.request.AdvertisementRequest;
import com.example.model.Advertisment;

import java.util.List;

public interface AdvertisementServiceInter {

    public Advertisment add(AdvertisementRequest advertisementRequest);
    public List<Advertisment> getAll();
    List<AdvertisementDto> getByEnableTrue();
    public List<AdvertisementDto> getAllBySorted();
    List<AdvertisementDto> getByEmployer_CompanyName(String companyName);
    public String deleteAdvertisement(int id);
    public String toPassiv(int id);
    public String toActive(int id);
}
