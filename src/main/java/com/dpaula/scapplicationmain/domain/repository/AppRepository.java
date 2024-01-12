package com.dpaula.scapplicationmain.domain.repository;

import com.dpaula.scapplicationmain.domain.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppRepository extends JpaRepository<App, UUID> {
}
