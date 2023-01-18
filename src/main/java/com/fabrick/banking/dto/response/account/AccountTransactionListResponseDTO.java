package com.fabrick.banking.dto.response.account;

import com.fabrick.banking.dto.DTO;
import lombok.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountTransactionListResponseDTO implements DTO {

    private List<AccountTransactionResponseDTO> list;
}
