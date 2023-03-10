package com.fabrick.banking.controller;

import com.fabrick.banking.constant.APIConstant;
import com.fabrick.banking.constant.SwaggerConstant;
import com.fabrick.banking.dto.request.account.AccountTransactionRequest;
import com.fabrick.banking.dto.response.account.AccountBalanceResponse;
import com.fabrick.banking.dto.response.account.AccountTransactionResponse;
import com.fabrick.banking.service.account.AccountManagementServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(APIConstant.AccountManagement.BASE_URL)
@RequiredArgsConstructor
public class AccountManagementController {

    private final AccountManagementServiceImpl accountManagementService;

    @Operation(summary = SwaggerConstant.AccountManagement.BALANCE_OPERATION_SUMMARY)
    @GetMapping(APIConstant.AccountManagement.ACCOUNT_BALANCE)
    public ResponseEntity<AccountBalanceResponse> getAccountBalance(@PathVariable(name = "accountId") String accountId){
        return ResponseEntity
                .ok()
                .body(accountManagementService.getAccountBalance(accountId));
    }

    @Operation(summary = SwaggerConstant.AccountManagement.TRANSACTIONS_OPERATION_SUMMARY)
    @GetMapping(APIConstant.AccountManagement.ACCOUNT_TRANSACTIONS)
    public ResponseEntity<AccountTransactionResponse> getAccountTransactions(
            @PathVariable(name = "accountId") String accountId,
            @Valid final AccountTransactionRequest request){

        return ResponseEntity
                .ok()
                .body(accountManagementService.getAccountTransactions(accountId, request));
    }
}
