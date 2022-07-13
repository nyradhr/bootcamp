package it.accenture.bootcamp.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.accenture.bootcamp.dtos.ClassroomDTO;
import it.accenture.bootcamp.exceptions.EntityNotFoundException;
import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.services.abstractions.EducationService;

@RestController
@RequestMapping("classroom")
public class ClassroomController {

    private EducationService eduService;

    @Autowired
    public ClassroomController(EducationService eduService) {
        this.eduService = eduService;
    }

    @GetMapping
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClassroomDTO> findById(@PathVariable long id) {
        Optional<Classroom> optClass = eduService.findClassroomById(id);
        if (optClass.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optClass.map(ClassroomDTO::fromClassroom).get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        try {
            eduService.deleteClassroomById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClassroomDTO cdto) {
        Classroom c = cdto.toClassroom();
        try {
            Classroom cSaved = eduService.saveOrUpdateClassroom(c);
            var dto = ClassroomDTO.fromClassroom(cSaved);
            URI uri = new URI("localhost:8080/classroom/" + cdto.getId());
            return ResponseEntity.created(uri).body(dto);
        } catch (URISyntaxException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody ClassroomDTO cdto, @PathVariable long id) {
        Classroom c = cdto.toClassroom();
        try {
            Classroom cSaved = eduService.saveOrUpdateClassroom(c);
            ClassroomDTO dto = ClassroomDTO.fromClassroom(cSaved);
            return ResponseEntity.ok(dto);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
