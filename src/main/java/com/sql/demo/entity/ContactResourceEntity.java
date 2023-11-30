package com.sql.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ContactResourceEntity {

    @Id
    @GeneratedValue(generator = "contacts_seq")
    @SequenceGenerator(name = "contacts_seq", sequenceName = "contacts_seq", allocationSize = 1)
    @GenericGenerator(
            name = "contacts_seq",
            type = SequenceStyleGenerator.class,
            parameters = {
                    @Parameter(name = "contacts_seq", value = "contacts_seq"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Integer nextContactsSequence;

    @Column
    private String contactName;

    @Column
    private String contactAddress;



}
