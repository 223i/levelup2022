package ru.levelup.lesson7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    private Integer id;
    private String name_ru;
    private String name_en;
    private Integer amount_of_citizens;
    private Region region;
}
