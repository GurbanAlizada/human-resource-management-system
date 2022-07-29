package com.example.dtos.convert;


import com.example.dtos.AdvertisementDto;
import com.example.model.Advertisment;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementDtoConvertor {


    public AdvertisementDto convertToAdvertisementDto(Advertisment advertisement){
      return  new AdvertisementDto(
              advertisement.getJobTitle().getTitle(),
              advertisement.getEmployer().getCompanyName(),
              advertisement.getNumberOfPosition(),
              advertisement.getCreateDate(),
              advertisement.getDeleteDate()
      );
    }


}
