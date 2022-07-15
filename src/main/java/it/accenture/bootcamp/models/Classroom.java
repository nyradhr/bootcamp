package it.accenture.bootcamp.models;

import javax.persistence.*;

import it.accenture.bootcamp.models.abstractions.WithId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLASSROOM")
public class Classroom implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "CAPACITY")
    private Integer capacity;
    @Column(name = "SOFTWARE")
    private String software;
    @Column(name = "PROJECTOR")
    private Boolean hasProjector;
    @Column(name = "TEACHER_PC")
    private Boolean hasTeacherPc;
    @Column(name = "STUDENTS_PC")
    private Boolean hasStudentPc;
    @Column(name = "IS_VIRTUAL", nullable = false)
    private boolean isVirtual;
}
