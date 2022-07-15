package it.accenture.bootcamp.mapstruct;


import it.accenture.bootcamp.dtos.SectorDTO;
import it.accenture.bootcamp.models.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SectorMapper {
    SectorMapper INSTANCE = Mappers.getMapper(SectorMapper.class);
    @Mapping(target = "id", source = "id")
    SectorDTO fromSector (Sector s);
    @Mapping(target = "id", source = "id")
    Sector toSector (SectorDTO sDTO);
}