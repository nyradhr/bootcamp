package it.accenture.bootcamp.controllers;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.accenture.bootcamp.dtos.ClassroomDTO;
import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.services.abstractions.EducationService;

@RestController
public class ClassroomController {

    private EducationService eduService;

    @Autowired
    public ClassroomController(EducationService eduService) {
        this.eduService = eduService;
    }

    @GetMapping(value = "/classroom")
    public ResponseEntity<Iterable<ClassroomDTO>> getAll() {
        // System.out.println("Hello Spring & alessio");
        // Classroom classroom = new Classroom(1, "Aula bella");
        // return null;
        // non restituire mai entity:
        // sono oggetti complicati e il cliente non ha bisogno di tutti i dati
        // le entity possono contenere dati sensibili
        // i dati magari sono utili ma la entity li espone in modo complicato, ex quando
        // una entity contiene un'altra entity
        // json potrebbe anche andare in loop quando due entity si chiamano
        // vicendevolmente (relazioni bi-direzionali)
        // se ritorno le entity e poi ne modifico una crasheranno tutti i client del
        // servizio immediatamente, perchè andrebbero a cercare nell'output json cose
        // che non esistono più, per modificare il servizio vanno create diverse
        // versioni

        // flattening: ritornare oggetti semplificati: DTO data transfering objects
        // classe simile all'entity che nasconde dati sensibili o strutture compliacate
        // e solo quelle necessarie
        var cls = eduService.getAllClassrooms();
        var dtos = StreamSupport.stream(cls.spliterator(), false).map(ClassroomDTO::fromClassroom).toList();

        return ResponseEntity.ok(dtos);
    }
}
