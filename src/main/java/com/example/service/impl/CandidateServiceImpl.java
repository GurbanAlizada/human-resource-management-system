package com.example.service.impl;

import com.example.adapters.impl.CheckPerson;
import com.example.dtos.request.*;
import com.example.exception.CandidateNotFoundException;
import com.example.exception.MernisNotFoundExcpeption;
import com.example.model.Candidate;
import com.example.model.User;
import com.example.model.cv.*;
import com.example.repository.*;
import com.example.service.inter.CandidateServiceInterr;
import com.example.service.inter.UserServiceInter;
import com.example.verifications.inter.FakeEmailVerificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CandidateServiceImpl implements CandidateServiceInterr {


    private final CandidateRepository candidateRepository;
    private final CheckPerson checkPerson;
    private final UserServiceInter userServiceInter;
    private final FakeEmailVerificationServiceImpl fakeEmailVerificationService;
    private final EducationRepository educationRepository;
    private final LanguageRepository languageRepository;
    private final ExperienceRepository experienceRepository;
    private final LinkRepository linkRepository;
    private final TechnologyRepository technologyRepository;
    private final CoverLetterRepository coverLetterRepository;


    public CandidateServiceImpl(CandidateRepository candidateRepository,
                            @Qualifier("MernisServiceAdapter")    CheckPerson checkPerson,
                                UserServiceInter userServiceInter,
                                FakeEmailVerificationServiceImpl fakeEmailVerificationService,
                                EducationRepository educationRepository,
                                LanguageRepository languageRepository,
                                ExperienceRepository  experienceRepository,
                                LinkRepository linkRepository,
                                TechnologyRepository technologyRepository,
                                CoverLetterRepository coverLetterRepository) {

        this.candidateRepository = candidateRepository;
        this.checkPerson = checkPerson;
        this.userServiceInter = userServiceInter;
        this.fakeEmailVerificationService = fakeEmailVerificationService;
        this.educationRepository = educationRepository;
        this.languageRepository = languageRepository;
        this.experienceRepository = experienceRepository;
        this.linkRepository = linkRepository;
        this.technologyRepository = technologyRepository;
        this.coverLetterRepository = coverLetterRepository;
    }

    private Candidate checkIdentityNumber(long identityNumber){
        return candidateRepository.getByIdentityNumber(identityNumber);
    }


    private User checkEmail(String  email){
        return userServiceInter.getByEmail(email);
    }


    @Override
    public Candidate getById(int id){
        return candidateRepository.findById(id)
                .orElseThrow(
                        ()->new CandidateNotFoundException("Boyle bir is ariyan bulunmadi"));
    }


    @Override
    public Candidate add(CandidateRequest candidateRequest ) {

        if (checkPerson.checkIfRealPerson(candidateRequest.getIdentityNumber() , candidateRequest.getName(), candidateRequest.getSurname(), candidateRequest.getDateOfBirth())) {
            if(checkIdentityNumber(candidateRequest.getIdentityNumber()) == null){
                if (checkEmail(candidateRequest.getEmail()) == null){
                    if(fakeEmailVerificationService.sendEmail(candidateRequest.getEmail())){

                        User user = new User(candidateRequest.getEmail(), candidateRequest.getPassword());

                        Candidate candidate = Candidate.builder()
                                .name(candidateRequest.getName())
                                .surname(candidateRequest.getSurname())
                                .identityNumber(candidateRequest.getIdentityNumber())
                                .dateOfBirth(candidateRequest.getDateOfBirth())
                                .user(user)
                                .build();

                        return candidateRepository.save(candidate);


                    }else{
                        throw new MernisNotFoundExcpeption("Email dogrulamasi yapilmadi");
                    }
                }else{
                    throw new MernisNotFoundExcpeption("Bu email zaten sistemde  var");
                }
            }else{
                throw new MernisNotFoundExcpeption("Sizin zaten sistemde bir kayitiniz var");
            }
        } else {
            throw new MernisNotFoundExcpeption("Bu bilgilerde bir kisi bulunamadi");
        }
    }



    @Override
    public List<Candidate> getAll(){

        return candidateRepository.findAll();
    }





    public String addEducation(EducationRequest educationRequest){

        Education education = Education.builder()
                .candidate(getById(educationRequest.getCandidateId()))
                .school(educationRequest.getSchool())
                .endDate(educationRequest.getEndDate())
                .startDate(educationRequest.getStartDate())
                .build();

        educationRepository.save(education);
        return "Basari ile eklendi";
    }




    public String addLanguage(LanguageRequest languageRequest){

        Language language = Language.builder()
                .languageLevel(languageRequest.getLanguageLevel())
                .candidate(getById(languageRequest.getCandidateId()))
                .name(languageRequest.getName())
                .build();

        languageRepository.save(language);
        return "Basari ile eklendi";
    }




    public String addExperience(ExperinceRequest experinceRequest){

        Experience experience = Experience.builder()
                .companyName(experinceRequest.getCompanyName())
                .candidate(getById(experinceRequest.getCandidateId()))
                .endDate(experinceRequest.getEndDate())
                .startDate(experinceRequest.getStartDate())
                .build();


        experienceRepository.save(experience);

        return "Basari ile eklendi";
    }


    public String addLink(LinkRequest linkRequest){

        Link link = Link.builder()
                .githubLink(linkRequest.getGithubLink())
                .linkedinLink(linkRequest.getLinkedinLink())
                .candidate(getById(linkRequest.getCandidateId()))
                .build();

        linkRepository.save(link);
        return "Basari ile eklendi";
    }





    public String addTechno(TechnologyRequest technologyRequest){

        Technology technology = Technology.builder()
                .usedTechnology(technologyRequest.getUsedTechnology())
                .candidate(getById(technologyRequest.getCandidateId()))
                .build();
        technologyRepository.save(technology);
        return "Basari ile eklendi";
    }



    public String addLetter(CoverLetterRequest coverLetterRequest){

        CoverLetter coverLetter = CoverLetter.builder()
                .cover(coverLetterRequest.getCover())
                .candidate(getById(coverLetterRequest.getCandidateId()))
                .build();
        coverLetterRepository.save(coverLetter);
        return "Basari ile eklendi";
    }




}
/*

{
  "dateOfBirth": "1985-01-06",
  "identityNumber": 28861499108,
  "name": "Engin",
  "surname": "Demiroğ"
}



{
  "dateOfBirth": "1985-01-06",
 "email": "qqqqq8q1qqq@gmail.com",
  "identityNumber": 28861499108,
  "name": "Engin",
 "password": "123455",
  "surname": "Demiroğ"
}


 */