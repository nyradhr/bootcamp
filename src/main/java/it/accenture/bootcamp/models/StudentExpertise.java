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
@Table(name = "STUDENT_EXPERTISE")
public class StudentExpertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "STUDENT")
    @OneToOne
    @JoinColumn(name = "STUDENT", referencedColumnName = "ID")
    private Student student;
    @Column(name = "SKILL")
    @OneToOne
    @JoinColumn(name = "SKILL", referencedColumnName = "ID")
    private Skill skill;

    @Column(name = "SKILL_LEVEL")
    private String skillLevel;

}
