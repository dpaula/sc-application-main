package com.dpaula.scapplicationmain.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppProperties {
    private String appCreatedChannel = "appCreatedSupplier-out-0";
    private String appUpdatedChannel = "appUpdatedSupplier-out-0";
}
