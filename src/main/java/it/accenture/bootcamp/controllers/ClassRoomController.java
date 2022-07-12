package it.accenture.bootcamp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.accenture.bootcamp.models.Classroom;

@RestController
public class ClassRoomController {

    @GetMapping(value = "/classroom")
    public Classroom hello() {
        System.out.println("Hello Spring & alessio");
        Classroom classroom = new Classroom(1, "Aula bella");
        return classroom;
    }
}
