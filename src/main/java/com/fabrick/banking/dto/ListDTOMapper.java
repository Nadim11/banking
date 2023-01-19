package com.fabrick.banking.dto;

import java.io.Serializable;
import java.util.List;

public interface ListDTOMapper <D extends DTO, S extends Serializable> extends DTOMapper<D, S> {

    List<D> toDTOList(List<S> var1);

    List<S> fromDTOList(List<D> var1);
}
