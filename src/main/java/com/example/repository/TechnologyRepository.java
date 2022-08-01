package com.example.repository;

import com.example.model.cv.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TechnologyRepository extends JpaRepository<Technology , Integer> {

    @Query("from Technology  t inner join t.candidate c where c.id=:candidateId")
    List<Technology> findByCandidateId(int candidateId);


}
