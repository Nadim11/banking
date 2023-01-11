package com.fabrick.banking.enumerable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorsEnum {

    INVALID_OR_MISSING_FIELD("Invalid or missing field"),
    INTERNAL_SERVER_ERROR("Something went wrong");

    private String description;
}
