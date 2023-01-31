package ru.levelup.lesson9_10.dto;

import lombok.Data;

@Data
public class CityDto {
    private Integer id;
    private String nameRu;
    private String nameEn;
    private Integer amountOfCitizens;
    private RegionDto region;
}
