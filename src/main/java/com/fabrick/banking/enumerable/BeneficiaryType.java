package com.fabrick.banking.enumerable;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum BeneficiaryType {

    NATURAL_PERSON("beneficiary is a natural person"),
    LEGAL_PERSON("beneficiary is a legal person");

    private final String description;

    public static boolean contains(String val){
        return Arrays.stream(BeneficiaryType.values())
                .anyMatch(type -> type.name().equals(val));
    }
}
