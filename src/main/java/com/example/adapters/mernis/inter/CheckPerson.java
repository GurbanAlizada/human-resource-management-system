package com.example.adapters.mernis.inter;

import java.time.LocalDate;

public interface CheckPerson {



    boolean checkIfRealPerson(
                              long identityNumber ,
                              String name ,
                              String surname ,
                              LocalDate dateOfBirth
    );




}
