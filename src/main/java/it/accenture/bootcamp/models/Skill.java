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
@Table(name = "SECTOR")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "SECTOR")
    @OneToOne
    @JoinColumn(name = "SECTOR", referencedColumnName = "ID")
    private Sector sector;

    @OneToOne
    private StudentExpertise studentExpertise;
}
