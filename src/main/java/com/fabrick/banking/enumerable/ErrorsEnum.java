package com.fabrick.banking.enumerable;

import com.fabrick.banking.constant.PatternConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorsEnum {

    INVALID_OR_MISSING_FIELD("Invalid or missing field"),
    INTERNAL_SERVER_ERROR("Something went wrong"),
    INVALID_DATE_FORMAT("Date format must correspond to " + PatternConstant.YYYY_MM_DD);

    private String description;
}
