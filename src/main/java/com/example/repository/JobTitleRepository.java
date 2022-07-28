package com.example.repository;

import com.example.model.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle , Integer> {

    JobTitle getByTitle(String title);

}
