package com.example.service.inter;

import com.example.dtos.request.JobTitleRequest;
import com.example.model.JobTitle;

import java.util.List;

public interface JobTitleServiceInter {

    JobTitle add(JobTitleRequest jobTitleRequest);

    JobTitle update(int id , JobTitleRequest jobTitleRequest);

    JobTitle delete(int id);

    List<JobTitle> getAll();

    JobTitle getById(int id);

    JobTitle getByTitle(String title);


}
