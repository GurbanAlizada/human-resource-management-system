package com.example.service.inter;

import com.example.model.cv.CoverLetter;
import java.util.List;


public interface CoverLetterServiceInter {

     List<CoverLetter> getAll();

     List<CoverLetter> getById(int id);


}
