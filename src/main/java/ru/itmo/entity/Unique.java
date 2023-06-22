package ru.itmo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
abstract public class Unique {
    @Id
    @GeneratedValue
    protected int id;

    public Unique() {
    }


}