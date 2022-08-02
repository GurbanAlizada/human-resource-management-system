package com.example.repository;

import com.example.model.cv.Photo;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository  extends JpaRepository<Photo , Integer> {


    List<Photo> findByCandidate_Id(int candidateId);


}
