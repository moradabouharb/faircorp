package com.esme.spring.faircorp;

import com.esme.spring.faircorp.Model.Light;
import com.esme.spring.faircorp.Model.Room;

import java.util.List;

public interface LightDaoCustom {
     List<Light> findOnLights(long id);
}
