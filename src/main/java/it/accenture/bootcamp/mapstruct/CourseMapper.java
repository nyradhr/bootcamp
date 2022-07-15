package it.accenture.bootcamp.mapstruct;

import it.accenture.bootcamp.dtos.CourseDTO;
import it.accenture.bootcamp.models.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
    @Mapping(target = "id", source = "id")
    CourseDTO fromCourse (Course c);
    @Mapping(target = "id", source = "id")
    Course toCourse (CourseDTO cDTO);
}