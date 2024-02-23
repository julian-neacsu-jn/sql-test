package com.sql.demo.controller;

import com.sql.demo.entity.ContactSequenceEntity;
import com.sql.demo.model.ContactResourceTableDTO;
import com.sql.demo.model.SequenceDTO;
import com.sql.demo.repository.SequenceRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(path = "/contact")
@Slf4j
public class ContactsSequenceController {

    private final SequenceRepository sequenceRepository;

    @Autowired
    public ContactsSequenceController(SequenceRepository sequenceRepository) {
        log.info("<><>  CONSTRUCTING OBJECT :: {}  <><>", this.getClass().getCanonicalName());
        this.sequenceRepository = sequenceRepository;
    }

    @GetMapping(path = "/nextSequence", produces = MediaType.APPLICATION_JSON_VALUE)
    public synchronized ResponseEntity<SequenceDTO> getContactsNextSequence() throws SQLException {
        return new ResponseEntity<>(sequenceRepository.getNextEntity(), HttpStatus.OK);
    }

//    @PostMapping(path = "/nextSequence/table", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<ContactResourceTableDTO> getContactsNextSequenceTable(@RequestBody ContactResourceRequestDTO contactResourceRequestDTO) throws  Exception{
//        return new ResponseEntity<>(contactTableService.saveContact(
//                ContactResourceTableDTO
//                        .builder()
//                        .contactAddress(contactResourceRequestDTO.getContactAddress())
//                        .contactName(contactResourceRequestDTO.getContactName())
//                        .build()),
//                HttpStatus.OK);
//    }
}
