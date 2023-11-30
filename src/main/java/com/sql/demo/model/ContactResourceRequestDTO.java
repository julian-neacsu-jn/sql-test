package com.sql.demo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ContactResourceRequestDTO {

    private String contactName;

    private String contactAddress;
}
