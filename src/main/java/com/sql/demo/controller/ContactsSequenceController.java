package com.sql.demo.controller;

import com.sql.demo.model.ContactResourceRequestDTO;
import com.sql.demo.model.ContactServiceEntityDTO;
import com.sql.demo.service.ContactsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/contact")
@Slf4j
public class ContactsSequenceController {

    private final ContactsService contactsService;

    private final ContactTableService contactTableService;

    @Autowired
    public ContactsSequenceController(ContactsService contactsService, ContactTableService contactTableService) {
        log.info("<><>  CONSTRUCTING OBJECT :: {}  <><>", this.getClass().getCanonicalName());
        this.contactsService = contactsService;
        this.contactTableService = contactTableService;
    }

    @PostMapping(path = "/nextSequence", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ContactServiceEntityDTO> getContactsNextSequence(@RequestBody ContactResourceRequestDTO contactResourceRequestDTO){
        return new ResponseEntity<>(contactsService.saveContact(contactResourceRequestDTO), HttpStatus.OK);
    }

    @PostMapping(path = "/nextSequence/table", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ContactServiceEntityDTO> getContactsNextSequenceTable(@RequestBody ContactResourceRequestDTO contactResourceRequestDTO){
        return new ResponseEntity<>(contactTableService.saveContact(contactResourceRequestDTO), HttpStatus.OK);
    }
}
