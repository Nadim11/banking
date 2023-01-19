package com.fabrick.banking.entity.account;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int                 id;

    @Column(name = "account_id", unique = true)
    private String              accountId;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Transaction>    transactions;
}
