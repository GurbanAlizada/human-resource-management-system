package com.example.repository;

import com.example.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact , Integer> {


}
