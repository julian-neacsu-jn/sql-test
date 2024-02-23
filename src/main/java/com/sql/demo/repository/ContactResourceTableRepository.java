package com.sql.demo.repository;

import com.sql.demo.entity.ContactResourceEntityTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ContactResourceTableRepository extends JpaRepository<ContactResourceEntityTable, Integer> {
}
