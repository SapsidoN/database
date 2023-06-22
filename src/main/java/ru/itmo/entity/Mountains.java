package ru.itmo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_mountains")
public class Mountains extends  Unique{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private int height;

    public Mountains(String name, String country, int height) {
        this.name = name;
        this.country = country;
        this.height = height;
    }
}
