package com.dpaula.scapplicationmain.api.controller;

import com.dpaula.scapplicationmain.api.model.AppCreateRequest;
import com.dpaula.scapplicationmain.api.model.AppModel;
import com.dpaula.scapplicationmain.api.model.AppUpdateRequest;
import com.dpaula.scapplicationmain.core.Mapper;
import com.dpaula.scapplicationmain.domain.entity.App;
import com.dpaula.scapplicationmain.domain.exception.AppNotFoundException;
import com.dpaula.scapplicationmain.domain.repository.AppRepository;
import com.dpaula.scapplicationmain.domain.service.AppManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/apps")
@RequiredArgsConstructor
public class AppController {

    private final AppManagementService appManagementService;
    private final AppRepository apps;
    private final Mapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppModel create(@RequestBody @Valid AppCreateRequest request) {

        App app = appManagementService.create(App.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build());

        return mapper.map(app, AppModel.class);
    }

    @PutMapping("/{appId}")
    public AppModel update(@PathVariable UUID appId,
                           @RequestBody @Valid AppUpdateRequest request) {

        App app = appManagementService.update(App.builder()
                .id(appId)
                .name(request.getName())
                .address(request.getAddress())
                .build());

        return mapper.map(app, AppModel.class);
    }

    @GetMapping("/{appId}")
    @Transactional
    public AppModel getById(@PathVariable UUID appId) {
        App app = apps.findById(appId)
                .orElseThrow(AppNotFoundException::new);

        return mapper.map(app, AppModel.class);
    }

    @GetMapping
    @Transactional
    public List<AppModel> getAll() {
        return apps.findAll()
                .stream()
                .map(app -> mapper.map(app, AppModel.class))
                .toList();
    }

}

