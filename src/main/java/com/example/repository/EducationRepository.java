package com.example.repository;

import com.example.model.cv.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education , Integer> {

   /* @Query("from Education e inner join e.candidate c where c.id =:candidateId")
    List<Education> findByCandidateId(int candidateId);*/

    List<Education> findByCandidate_Id(int id);

    List<Education> findByCandidate_IdOrderByEndDateDesc(int id);

}
