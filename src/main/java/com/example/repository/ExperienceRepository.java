package com.example.repository;

import com.example.model.cv.Education;
import com.example.model.cv.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience , Integer> {


    @Query("FROM Experience e inner join e.candidate c where c.id =:candidateId")
    List<Experience> findByCandidateId(int candidateId);





    List<Experience> findByCandidate_IdOrderByEndDateDesc(int id);


}
