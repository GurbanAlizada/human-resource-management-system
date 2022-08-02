package com.example.service.inter;

import com.example.model.cv.Link;
import java.util.List;

public interface LinkServiceInter {

     List<Link> getAll();
     List<Link> getById(int id);

}
