package ru.itmo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.time.LocalDate;
import java.util.List;

public class ClimberDAO {

    private EntityManager entityManager;
    public  ClimberDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public List<String> NamesMountainClimbers(String mountainName){
        Query query = entityManager.createNativeQuery("SELECT tb_climbers.fullName FROM tb_climbers " +
                "JOIN grop_climber ON  tb_climbers.id = grop_climber.climber_id  " +
                "JOIN tb_climbingGroup ON grop_climber.grop_id = tb_climbingGroup.id " +
                "JOIN tb_mountains ON tb_climbingGroup.mountain_id = tb_mountains.id " +
                "WHERE tb_mountains.name = :mountainName"
                ,String.class).setParameter("mountainName",mountainName);
        return query.getResultList();
    }

    public List<String> NamesNotEnrolledNew(LocalDate date){
        Query query = entityManager.createNativeQuery("SELECT tb_climbers.fullName FROM tb_climbers " +
                        "LEFT JOIN grop_climber ON tb_climbers.id = grop_climber.climber_id " +
                        "LEFT JOIN tb_climbingGroup ON  grop_climber.grop_id = tb_climbingGroup.id " +
                        "AND tb_climbingGroup.startTime > :date " +
                        "WHERE tb_climbingGroup.id IS NULL"
                ,String.class).setParameter("date",date);
        return query.getResultList();
    }
}
