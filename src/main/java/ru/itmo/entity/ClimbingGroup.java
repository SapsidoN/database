package ru.itmo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_climbingGroup")
public class ClimbingGroup extends  Unique{
@Column (nullable = false)
    private LocalDate startTime;
    @Column (nullable = false)
    private LocalDate endTime;
    @ManyToOne
    @JoinColumn(name = "mountain_id")
    private Mountains mountains;
    @Column (nullable = false)
    private  Boolean kit;
    @ManyToMany
    @JoinTable(name = "grop_climber",
    joinColumns = @JoinColumn(name = "grop_id"),
    inverseJoinColumns = @JoinColumn(name = "climber_id"))
    private List<Climbers> grop = new ArrayList<>();

    public ClimbingGroup(Boolean kit) {
        this.kit = kit;
    }


    public List<Climbers> getGrop() {
        return grop;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public void setMountains(Mountains mountains) {
        this.mountains = mountains;
    }
}
