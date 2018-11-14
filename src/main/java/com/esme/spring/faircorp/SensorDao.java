package com.esme.spring.faircorp;
import com.esme.spring.faircorp.Model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDao extends JpaRepository<Sensor,Long> {
}