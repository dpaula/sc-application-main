package com.dpaula.scapplicationmain.domain.service;

import com.dpaula.scapplicationmain.domain.entity.App;
import com.dpaula.scapplicationmain.domain.exception.AppNotFoundException;
import com.dpaula.scapplicationmain.domain.repository.AppRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppManagementService {

    private final AppRepository apps;
    private final AppEventGateway appEventGateway;

    @Transactional
    public App create(App app) {
        Validate.notNull(app);
        apps.saveAndFlush(app);
        appEventGateway.sendAppCreatedEvent(app);

        return app;
    }

    @Transactional
    public App update(App updatedApp) {
        Validate.notNull(updatedApp);

        App existingApp = findAppById(updatedApp.getId());

        existingApp.update(updatedApp);
        apps.saveAndFlush(existingApp);
        appEventGateway.sendAppUpdatedEvent(existingApp);

        return existingApp;
    } 

    private App findAppById(UUID appId) {
        return apps.findById(appId)
                .orElseThrow(AppNotFoundException::new);
    }

}
