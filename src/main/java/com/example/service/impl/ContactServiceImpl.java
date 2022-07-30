package com.example.service.impl;

import com.example.dtos.request.ContactRequest;
import com.example.exception.ContactNotFoundException;
import com.example.model.Contact;
import com.example.model.Cv;
import com.example.repository.ContactRepository;
import com.example.service.inter.ContactServiceInter;
import org.springframework.stereotype.Service;


@Service
public class ContactServiceImpl implements ContactServiceInter {

    private final ContactRepository contactRepository;


    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    protected Contact getById(int id){
        return contactRepository.findById(id)
                .orElseThrow(
                        ()->new ContactNotFoundException
                                ("Bu parametrlerde iletisim bilgileri bulunmadu"));
    }



    @Override
    public Contact addContact(ContactRequest contactRequest){

       Contact contact = Contact.builder()
               .gitHubLink(contactRequest.getGitHubLink())
               .linkedInLink(contactRequest.getLinkedInLink())
               .build();
        return contactRepository.save(contact);
    }



}
