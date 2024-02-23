package com.sql.demo.service;

import com.sql.demo.entity.ContactResourceEntityTable;
import com.sql.demo.entity.ContactSequenceEntity;
import com.sql.demo.model.ContactResourceTableDTO;
import com.sql.demo.repository.ContactResourceTableRepository;
import com.sql.demo.repository.SequenceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.StaleObjectStateException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Service
@Slf4j
@EnableRetry
public class ContactTableServiceImpl  {

//    private final ContactResourceTableRepository contactResourceTableRepository;
//
//    private final SequenceRepository sequenceRepository;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Autowired
//    public ContactTableServiceImpl(
//            ContactResourceTableRepository contactResourceTableRepository,
//            SequenceRepository sequenceRepository) {
//
//        this.contactResourceTableRepository = contactResourceTableRepository;
//        this.sequenceRepository = sequenceRepository;
//    }
//
//    @Override
//    @Transactional
//    @Retryable(retryFor = {SQLException.class, StaleObjectStateException.class, DataIntegrityViolationException.class}, maxAttempts = 7, backoff = @Backoff(delay = 500, multiplier = 3))
//    public ContactResourceTableDTO saveContact(ContactResourceTableDTO contactResourceTableDTO) throws SQLException {
//
//        int lastSequence = sequenceRepository.findLatestSequence();
//        log.info("<><>  READ CURRENT SEQUENCE = {}  <><>  AT :: {}  <><>", lastSequence, LocalDateTime.now());
//        int rows = sequenceRepository.saveNextSequence(lastSequence + 1, lastSequence);
//
//        if(rows != 1 ){
//            throw new SQLException("<><>  FAILED TO UPDATE RECORD :: " + lastSequence);
//        }
//
//        ContactResourceEntityTable contactResourceEntityTable =
//                ContactResourceEntityTable
//                        .builder()
//                        .contactAddress(contactResourceTableDTO.getContactAddress())
//                        .contactName(contactResourceTableDTO.getContactName())
//                        .id(lastSequence)
//                        .build();
//
//        ContactResourceEntityTable savedEntityTable = contactResourceTableRepository.save(contactResourceEntityTable);
//
//
//        log.info("<><>  Saving Resource Contact Table  AT {}  <><>", LocalDateTime.now());
//
//        return ContactResourceTableDTO
//                .builder()
//                .contactAddress(savedEntityTable.getContactAddress())
//                .contactName(savedEntityTable.getContactName())
//                .id(savedEntityTable.getId())
//                .build();
//    }
//
//    public int getSequence(){
//
//    }
}
