package com.fabrick.banking.controller;

import com.fabrick.banking.dto.request.AccountTransactionRequest;
import com.fabrick.banking.dto.response.account.AccountBalanceResponse;
import com.fabrick.banking.dto.response.account.AccountTransactionResponse;
import com.fabrick.banking.service.AccountManagementServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banking/v1/accounts")
@RequiredArgsConstructor
public class AccountManagementController {

    private final AccountManagementServiceImpl accountManagementService;

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<AccountBalanceResponse> getAccountBalance(@PathVariable(name = "accountId") String accountId){
        return ResponseEntity
                .ok()
                .body(accountManagementService.getAccountBalance(accountId));
    }

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<AccountTransactionResponse> getAccountTransactions(
            @PathVariable(name = "accountId") String accountId,
            @RequestBody @Valid AccountTransactionRequest request){

        return ResponseEntity
                .ok()
                .body(accountManagementService.getAccountTransactions(accountId, request));
    }
}
