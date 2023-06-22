package ru.itmo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.time.LocalDate;
import java.util.List;

public class MountainsDAO {
    private EntityManager entityManager;

    public MountainsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<String> selectAlreadyClimbed() {
        Query nativeQ = entityManager.createNativeQuery("SELECT tb_mountains.name FROM tb_climbingGroup" +
                " JOIN tb_mountains ON " +
                "tb_climbingGroup.mountain_id = tb_mountains.id", String.class);
        return nativeQ.getResultList();
    }

    public List<String> selectHereWasNoClimb() {
        Query nativeQ = entityManager.createNativeQuery("SELECT tb_mountains.name FROM tb_mountains " +
                "LEFT JOIN tb_climbingGroup ON tb_climbingGroup.mountain_id = tb_mountains.id " +
                "WHERE tb_climbingGroup.id IS NULL", String.class);

        return nativeQ.getResultList();

    }

    public List<String> selectGetNamesHeights(LocalDate startDate, LocalDate endDate) {
        Query nativeQ = entityManager.createNativeQuery("SELECT tb_mountains.name, tb_mountains.height FROM tb_mountains " +
                "JOIN tb_climbingGroup ON tb_climbingGroup.mountain_id = tb_mountains.id " +
                "WHERE tb_climbingGroup.startTime BETWEEN :startDate AND :endDate", String.class).setParameter("startDate", startDate).setParameter("endDate", endDate);

        return nativeQ.getResultList();



    }

}
