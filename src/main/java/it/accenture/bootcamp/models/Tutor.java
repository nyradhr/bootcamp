package it.accenture.bootcamp.models;

import java.time.LocalDate;

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
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name="SURNAME")
    private String surname;
    @Column(name="BDATE")
    private LocalDate bdate;
    @Column(name="GENDER")
    private String gender;
    @Column(name="PHONE")
    private String phone;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PREFERRED_SECTOR")
    private long sectorId;
}