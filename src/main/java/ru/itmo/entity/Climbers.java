package ru.itmo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "tb_ climbers")
public class Climbers extends  Unique  {
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    public String address;



}