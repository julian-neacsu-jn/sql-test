package com.sql.demo.entity;

import com.sql.demo.exception.NegativeCurrentBalanceException;
import jakarta.persistence.*;

@Entity
@Table(name = "savingsAccount")
public class SavingsAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountNumber")
    private Integer accountNumber;

    @Column(name = "accountOwner", nullable = false)
    private String accountOwner;

    @Column(name = "currentBalance", nullable = false)
    private double currentBalance;

    public void setCurrentBalance(double currentBalance) throws NegativeCurrentBalanceException {
        if (currentBalance <= 0.00){
            throw new NegativeCurrentBalanceException("Current account balance cannot be less or equal to $0.00", "Negative Current Balance");
        }

        this.currentBalance = currentBalance;
    }
}
