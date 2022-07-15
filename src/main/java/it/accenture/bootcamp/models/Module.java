package it.accenture.bootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MODULE")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE", nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "EDITION", referencedColumnName = "ID")
    private Edition edition;
    @Column(name = "DURATION", nullable = false)
    private int duration;
    @Column(name = "Description")
    private String description;

    @OneToOne
    private Lecture lecture;
    @OneToOne
    private TeachingAssignment teachingAssignment;
}
