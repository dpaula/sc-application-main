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
public class AppUpdatedSupplier implements Supplier<AppModel> {

    @Override
    public AppModel get() {
        log.info("App Atualizado com sucesso");
        return AppModel.builder()
                .id(UUID.randomUUID())
                .name("Dpaula")
                .address("http://www.dpaula.com.br")
                .build();
    }
}
