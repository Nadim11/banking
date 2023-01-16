package com.fabrick.banking.enumerable;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum FeeType {

    SHA("Shared fees"),
    OUR("Fees apply to debtor"),
    BEN("Fees apply to creditor");

    private final String feeDescription;
    public static boolean contains(String val){
        return Arrays.stream(FeeType.values())
                .anyMatch(fee -> fee.name().equals(val));
    }
}
