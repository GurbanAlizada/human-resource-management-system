package com.example.repository;

import com.example.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City , Integer> {
}
