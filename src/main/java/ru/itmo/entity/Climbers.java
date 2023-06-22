package ru.itmo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tb_climbers")
public class Climbers extends  Unique  {
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String address;


    public Climbers(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
    }
}