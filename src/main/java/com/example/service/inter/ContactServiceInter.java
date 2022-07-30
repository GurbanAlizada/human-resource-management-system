package com.example.service.inter;

import com.example.dtos.request.ContactRequest;
import com.example.model.Contact;

public interface ContactServiceInter {

    public Contact addContact(ContactRequest contactRequest);
}
