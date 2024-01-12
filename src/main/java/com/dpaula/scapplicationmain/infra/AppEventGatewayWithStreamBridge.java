package com.dpaula.scapplicationmain.infra;

import com.dpaula.scapplicationmain.api.model.AppModel;
import com.dpaula.scapplicationmain.config.AppProperties;
import com.dpaula.scapplicationmain.core.Mapper;
import com.dpaula.scapplicationmain.domain.entity.App;
import com.dpaula.scapplicationmain.domain.service.AppEventGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

/**
 * @author Fernando de Lima on 12/01/24
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AppEventGatewayWithStreamBridge implements AppEventGateway {

    private final StreamBridge streamBridge;
    private final AppProperties appProperties;
    private final Mapper mapper;

    @Override
    public void sendAppCreatedEvent(App app) {
        log.info("App criado " + app.getId());

        final var appModel = mapper.map(app, AppModel.class);
        streamBridge.send(appProperties.getAppCreatedChannel(), appModel);
    }

    @Override
    public void sendAppUpdatedEvent(App app) {
        log.info("App atualizado " + app.getId());

        final var appModel = mapper.map(app, AppModel.class);
        streamBridge.send(appProperties.getAppUpdatedChannel(), appModel);
    }
}
