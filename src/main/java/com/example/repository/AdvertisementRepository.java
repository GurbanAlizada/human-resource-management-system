package com.example.repository;

import com.example.model.Advertisment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisment ,Integer> {


    @Query("select a from Advertisment a left join fetch a.city left join fetch  a.employer left join  fetch a.jobTitle")
    List<Advertisment> getAll();


    @Query("select a from Advertisment a  left join fetch a.city left join fetch  a.employer left join  fetch a.jobTitle where a.enable = true")
    List<Advertisment> getByEnableTrue();


    List<Advertisment> getByEmployer_CompanyName(String companyName);






}
