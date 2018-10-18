package com.esme.spring.faircorp;

import com.esme.spring.faircorp.Model.Light;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LightDaoImpl implements LightDaoCustom {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Light> findOnLights(long id) {
        String jpql = "SELECT lt from Light lt where lt.Light_ID =:id";

        return em.createQuery(jpql, Light.class)
                .setParameter("id", id)
                .getResultList();
    }

/*
    @Override
    public Light findOnLights(long id) {

        return jdbcTemplate.queryForObject("select Status from Light where light_ID=?", new Object[] {
                id},

                new BeanPropertyRowMapper<>(Light.class));

    }
    */
}