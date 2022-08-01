package com.example.repository;

import com.example.model.cv.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoverLetterRepository extends JpaRepository<CoverLetter , Integer> {

    @Query("from CoverLetter  cl inner join cl.candidate c where c.id =:candidateId")
    List<CoverLetter> findByCandidateId(int candidateId);

}
