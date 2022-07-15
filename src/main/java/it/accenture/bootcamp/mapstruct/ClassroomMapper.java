package it.accenture.bootcamp.mapstruct;

import it.accenture.bootcamp.dtos.ClassroomDTO;
import it.accenture.bootcamp.models.Classroom;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassroomMapper {
    ClassroomMapper INSTANCE = Mappers.getMapper(ClassroomMapper.class);
    @Mapping(target = "id", source = "id")
    ClassroomDTO fromClassroom (Classroom c);
    @Mapping(target = "id", source = "id")
    Classroom toClassroom (ClassroomDTO cDTO);
}
