package ru.itmo.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.itmo.dao.ClimberDAO;
import ru.itmo.dao.MountainsDAO;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
             EntityManager manager = emf.createEntityManager()) {

            Climbers climbers1 = new Climbers("oleg", "russia");
            Climbers climbers2 = new Climbers("ira", "russia");
            Mountains mountains1 = new Mountains("Everest", "Nepal", 8866);
            Mountains mountains2 = new Mountains("Gora", "rus", 8866);
            ClimbingGroup climbingGroup1 = new ClimbingGroup(false);
            climbingGroup1.setStartTime(LocalDate.of(2022, 05, 3));
            climbingGroup1.setEndTime(LocalDate.now());
            climbingGroup1.setMountains(mountains1);
            climbingGroup1.getGrop().add(climbers1);
            climbingGroup1.getGrop().add(climbers2);

            manager.getTransaction().begin();
            manager.persist(climbers1);
            manager.persist(climbers2);
            manager.persist(mountains1);
            manager.persist(mountains2);
            manager.persist(climbingGroup1);
            manager.getTransaction().commit();

            MountainsDAO mountainsDAO = new MountainsDAO(manager);
            List<String> arr = mountainsDAO.selectAlreadyClimbed();
            for (var a : arr) {
                System.out.println(a);
            }
            List<String> arr1 = mountainsDAO.selectHereWasNoClimb();
            for (var a : arr1) {
                System.out.println(a);
            }
            ClimberDAO climberDAO = new ClimberDAO(manager);
            List<String> arr3 = climberDAO.NamesMountainClimbers("Everest");
            for (var a : arr3) {
                System.out.println(a);
            }

            List<String> arr4 = mountainsDAO.selectGetNamesHeights(LocalDate.of(2022, 05, 2), LocalDate.now());
            for (var a : arr4) {
                System.out.println(a);
            }

            List<String> arr5 = climberDAO.NamesNotEnrolledNew(LocalDate.of(2021, 05, 2));
            for (var a : arr5) {
                System.out.println(a);
            }

        }

    }
}