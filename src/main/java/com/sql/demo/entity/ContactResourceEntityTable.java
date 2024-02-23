package com.sql.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table
@Entity(name = "sequence")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ContactResourceEntityTable {

    @Id
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column
    private String contactName;

    @Column
    private String contactAddress;
}
