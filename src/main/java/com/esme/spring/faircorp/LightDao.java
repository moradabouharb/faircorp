package com.esme.spring.faircorp;

import com.esme.spring.faircorp.Model.Light;
import com.esme.spring.faircorp.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LightDao  extends JpaRepository<Light,Long>,LightDaoCustom {
}
