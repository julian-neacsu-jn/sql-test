package com.sql.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ContactSequenceEntity {

    @Id
    @Column(unique = true, nullable = false)
    private Integer sequence;
}
