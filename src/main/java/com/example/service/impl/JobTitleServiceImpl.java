package com.example.service.impl;

import com.example.dtos.request.JobTitleRequest;
import com.example.exception.JobTitleNotFoundException;
import com.example.exception.MernisNotFoundExcpeption;
import com.example.model.JobTitle;
import com.example.repository.JobTitleRepository;
import com.example.service.inter.JobTitleServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class JobTitleServiceImpl implements JobTitleServiceInter {

    private final JobTitleRepository jobTitleRepository;

    public JobTitleServiceImpl(JobTitleRepository jobTitleRepository) {
        this.jobTitleRepository = jobTitleRepository;
    }


    @Override
    public JobTitle add(JobTitleRequest jobTitleRequest) {
        if(getByTitle(jobTitleRequest.getTitle())== null) {
            JobTitle jobTitle = new JobTitle();
            jobTitle.setTitle(jobTitleRequest.getTitle());
            return jobTitleRepository.save(jobTitle);
        }
        throw new MernisNotFoundExcpeption("Bu isimde zaten meslek var");
    }

    @Override
    public JobTitle update(int id, JobTitleRequest jobTitleRequest) {
        JobTitle jobTitle =jobTitleRepository.findById(id).orElseThrow(
                ()->new JobTitleNotFoundException("Boyle bir job title bulunmuyor"));
        jobTitle.setTitle(jobTitleRequest.getTitle());
        return jobTitleRepository.save(jobTitle);
    }

    @Override
    public JobTitle delete(int id) {
         JobTitle jobTitle =jobTitleRepository.findById(id)
                 .orElseThrow(
                         ()->new JobTitleNotFoundException("Boyle bir job title bulunmuyor"));
         jobTitleRepository.delete(jobTitle);
         return jobTitle;
    }

    @Override
    public List<JobTitle> getAll() {
        return jobTitleRepository.findAll();
    }

    @Override
    public JobTitle getById(int id) {
        return jobTitleRepository.findById(id).orElseThrow(
                ()->new JobTitleNotFoundException("Boyle bir job title bulunmuyor"));
    }

    @Override
    public JobTitle getByTitle(String title) {
        return jobTitleRepository.getByTitle(title);
    }


}
