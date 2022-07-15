package it.accenture.bootcamp.models;

import javax.persistence.*;

import it.accenture.bootcamp.models.abstractions.WithId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name = "COURSE")
public class Course implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name="TITLE")
    private String title;
    @Column(name="SECTOR")
    @ManyToOne
    @JoinColumn(name = "SECTOR", referencedColumnName = "ID")
    private Sector sector;
    @Column(name="DURATION")
    private int duration;
    @Column(name="COURSE_LEVEL")
    private String courseLevel;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="COST")
    private int cost;

    //@OneToMany
    //private List<Edition> editions;
}
