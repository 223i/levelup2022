package ru.levelup.lesson7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    private Integer id;
    private String name_ru;
    private String name_en;
}
