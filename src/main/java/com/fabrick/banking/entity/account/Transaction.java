package com.fabrick.banking.entity.account;

import com.fabrick.banking.embeddable.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int             id;
    private String          transactionId;
    private String          operationId;
    private Date            accountingDate;
    private Date            valueDate;

    @Embedded
    private TransactionType type;
    private BigDecimal      amount;
    private String          currency;
    private String          description;
}
