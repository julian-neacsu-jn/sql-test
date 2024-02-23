package com.sql.demo.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ContactResourceTableDTO {

    private Integer id;

    private String contactName;

    private String contactAddress;
}