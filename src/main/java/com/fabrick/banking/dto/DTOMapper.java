package com.fabrick.banking.dto;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public interface DTOMapper<D extends DTO, S extends Serializable> {

    D toDTO(S s);
    S fromDTO(D d);

    default LocalDate map(Date date){
        return date == null ? null : date.toLocalDate();
    }

    default Date map(LocalDate localDate){
        return localDate == null ? null : Date.valueOf(localDate);
    }
}
