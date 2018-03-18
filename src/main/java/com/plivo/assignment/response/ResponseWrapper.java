package com.plivo.assignment.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseWrapper<T> {
    private String status;

    private int httpCode;

    private String message;

    private T payload;
}
