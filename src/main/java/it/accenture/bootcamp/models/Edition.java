package it.accenture.bootcamp.models;

import java.time.LocalDate;

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
@Table (name = "EDITION")
public class Edition  implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="START_DATE", nullable = false)
    private LocalDate startDate;
    @Column(name="END_DATE")
    private LocalDate endDate;
    @Column(name="COURSE", nullable = false)
    @OneToOne
    @JoinColumn(name = "COURSE", referencedColumnName = "ID")
    private Course course;
    @Column(name="FINANCING", nullable = false)
    private String financing;
    @Column(name="COST")
    private Integer cost;
    @Column(name="TUTOR", nullable = false)
    @OneToOne
    @JoinColumn(name = "TUTOR", referencedColumnName = "ID")
    private Tutor tutor;
    @Column(name="CODE", nullable = false)
    private String code;

    @OneToOne
    private Module module;
    @OneToOne
    private Enrollment enrollment;

}
