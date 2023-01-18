package com.fabrick.banking.entity.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Entity
public class AccountTransaction {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int                 id;

    @Column(name = "account_id", unique = true)
    private String              accountId;

    //@OneToMany
    private Set<Transaction>    transactions;
}
