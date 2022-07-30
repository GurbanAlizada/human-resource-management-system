package com.example.service.inter;

import com.example.dtos.request.ExperinceRequest;
import com.example.model.Experince;

import java.util.List;

public interface ExperinceServiceInter {

    public List<Experince> getAllBySorted(int id);
    public Experince addExperince(ExperinceRequest experinceRequest);

}
