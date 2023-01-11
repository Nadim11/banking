package com.fabrick.banking.dto.response.account;

import lombok.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountTransactionList {

    private List<AccountTransaction> list;
}
