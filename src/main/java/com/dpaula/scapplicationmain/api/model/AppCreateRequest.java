package com.dpaula.scapplicationmain.api.model;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;

@Data
public class AppCreateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String address;
}
