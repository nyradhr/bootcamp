package it.accenture.bootcamp.dtos;

import it.accenture.bootcamp.models.Edition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditionDTO {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private long courseId;
    private String financing;
    private Integer cost;
    private long tutorId;
    private String code;

//    public static EditionDTO fromEdition(Edition e) {
//        return new EditionDTO(e.getId(), e.getStartDate(), e.getEndDate(), e.getCourseId(),
//                e.getFinancing(), e.getCost(), e.getTutorId(), e.getCode());
//    }
//
//
//    public Edition toEdition() {
//        return new Edition(this.id, this.startDate, this.endDate, this.courseId, this.financing,
//                this.cost, this.tutorId, this.code);
//    }


}