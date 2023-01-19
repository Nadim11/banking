package com.fabrick.banking.dto;

import java.io.Serializable;

public interface DTOMapper<D extends DTO, S extends Serializable> {

    D toDTO(S s);
    S fromDTO(D d);
}
