package com.example.repository;

import com.example.model.cv.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language , Integer> {

    @Query("from Language l inner join  l.candidate c where c.id =:candidateId")
    List<Language> findByCandidateId(int candidateId);


    List<Language> findByCandidate_Id(int id);
}
