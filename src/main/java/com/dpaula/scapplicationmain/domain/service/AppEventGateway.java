package com.dpaula.scapplicationmain.domain.service;

import com.dpaula.scapplicationmain.domain.entity.App;

/**
 * @author Fernando de Lima on 12/01/24
 */
public interface AppEventGateway {

    void sendAppCreatedEvent(App app);
    void sendAppUpdatedEvent(App app);
}
