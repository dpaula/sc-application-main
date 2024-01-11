package com.dpaula.scapplicationmain.api;

import com.dpaula.scapplicationmain.api.model.AppModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * @author Fernando de Lima on 11/01/24
 */
@Slf4j
@Component
public class AppCreatedSupplier implements Supplier<AppModel> {

    @Override
    public AppModel get() {
        log.info("App criado com sucesso");
        return AppModel.builder()
                .id(UUID.randomUUID())
                .name("Name")
                .address("Address")
                .build();
    }
}
