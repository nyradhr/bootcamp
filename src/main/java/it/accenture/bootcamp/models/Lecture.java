package it.accenture.bootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LECTURE")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "MODULE", referencedColumnName = "ID")
    private Module module;
    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;
    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    @Column(name = "TEACHER")
    @OneToOne
    @JoinColumn(name = "TEACHER", referencedColumnName = "ID")
    private Teacher teacher;
    @Column(name = "CLASSROOM")
    @OneToOne
    @JoinColumn(name = "CLASSROOM", referencedColumnName = "ID")
    private Classroom classroom;

    @OneToOne
    private Attendance attendance;


}
