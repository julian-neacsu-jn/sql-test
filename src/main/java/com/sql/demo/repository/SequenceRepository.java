package com.sql.demo.repository;

import com.sql.demo.model.SequenceDTO;

import java.sql.SQLException;

public interface SequenceRepository  {

    SequenceDTO getNextEntity() throws SQLException;

}

