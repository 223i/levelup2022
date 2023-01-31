package ru.levelup.lesson9_10.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    private Integer id;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_en")
    private String nameEn;
}
