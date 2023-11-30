package com.sql.demo.service;

import com.sql.demo.model.ContactResourceRequestDTO;
import com.sql.demo.model.ContactServiceEntityDTO;

public interface ContactsService {

    ContactServiceEntityDTO saveContact(ContactResourceRequestDTO contactResourceRequestDTO);
}
