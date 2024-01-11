package com.dpaula.scapplicationmain.api.model;

import lombok.*;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppModel {
    private UUID id;
    private String name;
    private String address;
}

