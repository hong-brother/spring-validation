package com.hsnam.validation.model;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class DataModel {
    @NotBlank(message = "이름을 채워 넣어주세요.")
    private String name;
    private String email;
    @Min(20) private int phone;
}
