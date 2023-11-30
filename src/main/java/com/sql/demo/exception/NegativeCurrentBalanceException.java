package com.sql.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NegativeCurrentBalanceException extends Exception {

    private String errorCause;

    private String errorMessage;


}
