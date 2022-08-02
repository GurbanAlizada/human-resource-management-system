package com.example.repository;

import com.example.model.cv.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Integer> {

    @Query("from Link l inner join l.candidate c where c.id =:candidateId")
    List<Link> findByCandidateId(int candidateId);

    List<Link> findByCandidate_Id(int id);




}
