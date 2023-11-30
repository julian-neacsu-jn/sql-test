package com.sql.demo.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class ContactServiceEntityDTO {

    private Integer contactSequence;

    private String contactName;

    private String contactAddress;
}
