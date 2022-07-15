package it.accenture.bootcamp.dtos;


import it.accenture.bootcamp.models.Course;
import it.accenture.bootcamp.models.Edition;
import it.accenture.bootcamp.models.Sector;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Long id;
    private String title;
    private long sectorId;
    private String sectorName;
    private int duration;
    private String courseLevel;
    private String description;
    private int cost;

//    public static CourseDTO fromCourse(Course c) {
//        return new CourseDTO(c.getId(), c.getTitle(), c.getSectorId(),
//                c.getDuration(), c.getCourseLevel(), c.getDescription(), c.getCost());
//    }
//
//    public Course toCourse() {
//        return new Course(this.getId(), this.getTitle(), this.getSectorId(), this.getDuration(), this.getCourseLevel(),
//                this.getDescription(), this.getCost());
//    }

}
