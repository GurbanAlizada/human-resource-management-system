package com.example.service.impl;

import com.example.model.cv.Link;
import com.example.repository.LinkRepository;
import com.example.service.inter.LinkServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LinkServiceImpl implements LinkServiceInter {

    private final LinkRepository linkRepository;


    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }




    public List<Link> getAll(){
        return linkRepository.findAll();
    }

    @Override
    public List<Link> getById(int id) {
        return linkRepository.findByCandidateId(id);
    }


}
