package com.sql.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PersonStoredProc extends JpaRepository<> {
}
