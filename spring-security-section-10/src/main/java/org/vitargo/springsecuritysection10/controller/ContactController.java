package org.vitargo.springsecuritysection10.controller;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vitargo.springsecuritysection10.repository.ContactRepository;
import org.vitargo.springsecuritysection10.model.Contact;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/contact")
     @PreFilter("filterObject.contactName != 'Test'")
//    @PostFilter("filterObject.contactName != 'Test'")
    public List<Contact> saveContactInquiryDetails(@RequestBody List<Contact> contacts) {
        List<Contact> returnContacts = new ArrayList<>();
        if(!contacts.isEmpty()) {
            Contact contact = contacts.get(0);
            contact.setContactId(getServiceReqNumber());
            contact.setCreateDt(new Date(System.currentTimeMillis()));
            contact = contactRepository.save(contact);
            returnContacts.add(contact);
        }
        return returnContacts;
    }

    public UUID getServiceReqNumber() {
        return UUID.randomUUID();
    }
}
