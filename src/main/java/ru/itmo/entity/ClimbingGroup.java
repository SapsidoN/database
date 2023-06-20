package ru.itmo.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Table(name = "ClimbingGroup")
public class ClimbingGroup extends  Unique{
@Column (nullable = false)
    private LocalDate start;
    @Column (nullable = false)
    private LocalDate end;
    @OneToOne
    @Column (nullable = false)
    private  Mountains mountains;
    @Column (nullable = false)
    private  Boolean kit;
    @OneToMany
    private ArrayList<Climbers> grop;
}
