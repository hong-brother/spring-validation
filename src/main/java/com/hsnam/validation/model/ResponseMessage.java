package com.hsnam.validation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage<T> {
    private boolean success;
    private String message;
    private T data;
    private T error;
}
