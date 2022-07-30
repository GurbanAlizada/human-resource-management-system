package com.example.service.inter;

import com.example.dtos.request.CvRequest;
import com.example.model.Cv;

import java.util.List;

public interface CvServiceInter {

    public Cv addCv(CvRequest cvRequest);
    public List<Cv> getAll();
}
