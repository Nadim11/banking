package com.fabrick.banking.deserializer;

import com.fabrick.banking.constant.ErrorConstant;
import com.fabrick.banking.constant.PatternConstant;
import com.fabrick.banking.dto.response.error.ErrorResponseDTO;
import com.fabrick.banking.dto.response.error.ErrorReturnResponseDTO;
import com.fabrick.banking.enumerable.ErrorsEnum;
import com.fabrick.banking.exception.BadRequestException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    private final SimpleDateFormat sdf = new SimpleDateFormat(PatternConstant.YYYY_MM_DD);


    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        LocalDate localDate;
        try{
            localDate = LocalDate.ofInstant(sdf.parse(node.asText()).toInstant(), ZoneId.systemDefault());
        }catch (ParseException ex){
            throw new BadRequestException(
              ErrorReturnResponseDTO
                      .builder()
                      .status(ErrorConstant.KO)
                      .errors(List.of(
                              ErrorResponseDTO
                                      .builder()
                                      .code(ErrorsEnum.INVALID_DATE_FORMAT.name())
                                      .description(ErrorsEnum.INVALID_DATE_FORMAT.getDescription())
                                      .params(node.asText())
                                      .build()
                      ))
                      .build()
            );
        }

        return localDate;
    }
}
