package it.accenture.bootcamp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SectorDTO {
    private Long id;
    private String name;
}
