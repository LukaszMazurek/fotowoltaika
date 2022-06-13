package com.example.fotowoltaika.domain;

import com.example.fotowoltaika.domain.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsJPARepository extends JpaRepository<Settings,Long> {
}
