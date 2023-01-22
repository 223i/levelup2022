package ru.levelup.lesson7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    private Integer id;
    private String nameRu;
    private String nameEn;
    private Integer amountOfCitizens;
    private Region region;
}
