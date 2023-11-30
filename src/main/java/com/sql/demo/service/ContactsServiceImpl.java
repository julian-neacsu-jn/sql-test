package com.sql.demo.service;

import com.sql.demo.entity.ContactResourceEntity;
import com.sql.demo.model.ContactResourceRequestDTO;
import com.sql.demo.model.ContactServiceEntityDTO;
import com.sql.demo.repository.ContactsSequenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContactsServiceImpl implements ContactsService {

    private final ContactsSequenceRepository contactsSequenceRepository;

    @Autowired
    public ContactsServiceImpl(ContactsSequenceRepository contactsSequenceRepository){
        log.info("<><>  CONSTRUCTING OBJECT :: {}  <><>", this.getClass().getCanonicalName());
        this.contactsSequenceRepository = contactsSequenceRepository;
    }

    @Override
    public ContactServiceEntityDTO saveContact(ContactResourceRequestDTO contactResourceRequestDTO) {
        ContactResourceEntity contactResourceEntity =
                contactsSequenceRepository
                        .save(ContactResourceEntity.builder()
                                .contactAddress(contactResourceRequestDTO.getContactAddress())
                                .contactName(contactResourceRequestDTO.getContactName())
                                .build());

        ContactServiceEntityDTO contactServiceEntityDTO =
                ContactServiceEntityDTO
                        .builder()
                        .contactSequence(contactResourceEntity.getNextContactsSequence())
                        .contactAddress(contactResourceEntity.getContactAddress())
                        .contactName(contactResourceEntity.getContactName())
                        .build();

        log.info("<><>  GETTING NEXT SEQUENCE :: {}  <><>", contactServiceEntityDTO);

        return  contactServiceEntityDTO;
    }
}
