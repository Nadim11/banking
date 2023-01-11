package com.fabrick.banking.feign.model.request.account;

import com.fabrick.banking.feign.model.request.ClientRequest;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AccountTransactionClientRequest implements ClientRequest {

    private Date fromAccountingDate;
    private Date toAccountingDate;
}
