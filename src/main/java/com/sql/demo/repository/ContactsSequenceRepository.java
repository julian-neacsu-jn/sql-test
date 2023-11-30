package com.sql.demo.repository;

import com.sql.demo.entity.ContactResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ContactsSequenceRepository extends JpaRepository<ContactResourceEntity, Integer> {

}
