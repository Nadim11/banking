package com.fabrick.banking.dto;

import java.io.Serializable;

public interface DTOMapper<R extends DTO, C extends Serializable> {

    R toDTO(C c);
    C fromDTO(R r);
}
