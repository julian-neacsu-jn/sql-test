package com.sql.demo.service;

import com.sql.demo.model.ContactResourceTableDTO;

import java.sql.SQLException;

public interface ContactTableService {

    ContactResourceTableDTO saveContact(ContactResourceTableDTO contactResourceTableDTO) throws SQLException;
}
