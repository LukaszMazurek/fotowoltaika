package com.example.fotowoltaika.domain;

import com.example.fotowoltaika.domain.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementJPARepository extends JpaRepository<Measurement,Long> {
}
