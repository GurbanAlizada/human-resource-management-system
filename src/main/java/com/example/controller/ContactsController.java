package com.example.controller;


import com.example.dtos.request.ContactRequest;
import com.example.model.Contact;
import com.example.service.inter.ContactServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {



    private final ContactServiceInter contactServiceInter;

    public ContactsController(ContactServiceInter contactServiceInter) {
        this.contactServiceInter = contactServiceInter;
    }



    @PostMapping("/addContact")
    public ResponseEntity<Contact> addContact(@Valid @RequestBody ContactRequest contactRequest){
        return ResponseEntity.ok( contactServiceInter.addContact(contactRequest));
    }





}
