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
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "SURNAME", nullable = false)
    private String surname;
    @Column(name = "BDATE", nullable = false)
    private LocalDate bdate;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    //@OneToMany
    //private List<Attendance> attendances;
    //@OneToMany
    //private List<Enrollment> enrollments;
    //@OneToMany
    //private List<StudentExpertise> studentExpertises;
    //@OneToMany
    //private List<StudentFeedback> studentFeedbacks;
}
