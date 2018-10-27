package com.esme.spring.faircorp;

import com.esme.spring.faircorp.Model.Light;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightDao  extends JpaRepository<Light,Long> {
}
