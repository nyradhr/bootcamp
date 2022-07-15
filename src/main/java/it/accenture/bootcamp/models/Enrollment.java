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
@Table(name = "ENROLLMENT")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "STUDENT")
    @OneToOne
    @JoinColumn(name = "STUDENT", referencedColumnName = "ID")
    private Student student;
    @Column(name = "EDITION")
    @OneToOne
    @JoinColumn(name = "EDITION", referencedColumnName = "ID")
    private Edition edition;
    @Column(name = "DROPOUT_DATE")
    private LocalDate dropOutDate;
    @Column(name = "PAYMENT_DATE")
    private LocalDate paymentDate;
    @Column(name = "COURSE_FEEDBACK")
    private String courseFeedback;
    @Column(name = "COURSE_EVALUATION")
    private int courseEvaluation;
    @Column(name = "STUDENT_FEEDBACK")
    private String studentFeedback;
    @Column(name = "STUDENT_EVALUATION")
    private int studentEvaluation;

}
