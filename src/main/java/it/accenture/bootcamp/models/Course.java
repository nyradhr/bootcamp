package it.accenture.bootcamp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Course /*implements DBModel*/{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name="TITLE")
    private String title;
    @Column(name="SECTOR")
    private long sectorId;
    @Column(name="DURATION")
    private int duration;
    @Column(name="COURSE_LEVEL")
    private String courseLevel;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="COST")
    private int cost;
}
