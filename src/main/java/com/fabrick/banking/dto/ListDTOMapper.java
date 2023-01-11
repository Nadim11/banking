package com.fabrick.banking.dto;

import java.io.Serializable;
import java.util.List;

public interface ListDTOMapper <R extends DTO, C extends Serializable> extends DTOMapper<R, C> {

    List<R> toDTOList(List<C> var1);

    List<C> fromDTOList(List<R> var1);
}
