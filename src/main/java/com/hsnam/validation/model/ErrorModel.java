package com.hsnam.validation.model;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ErrorModel {
    private String field;
    private String value;
    private String reason;
}
