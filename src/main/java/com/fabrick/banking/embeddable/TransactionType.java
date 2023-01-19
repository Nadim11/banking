package com.fabrick.banking.embeddable;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Embeddable
public class TransactionType {

    @Column(name = "enumeration_type")
    private String  enumeration;
    @Column(name = "enumeration_value")
    private String  value;
}
