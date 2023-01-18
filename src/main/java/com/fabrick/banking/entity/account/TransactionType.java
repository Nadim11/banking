package com.fabrick.banking.entity.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int     id;

    @Column(name = "enumeration_type")
    private String  enumeration;
    @Column(name = "enumeration_value")
    private String  value;
}
