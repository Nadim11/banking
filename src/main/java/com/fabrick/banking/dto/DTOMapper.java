package com.fabrick.banking.dto;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public interface DTOMapper<R extends DTO, C extends Serializable> {

    R toDTO(C c);
    C fromDTO(R r);

    default LocalDate map(Date date){
        return date == null ? null : date.toLocalDate();
    }

    default Date map(LocalDate localDate){
        return localDate == null ? null : Date.valueOf(localDate);
    }
}
