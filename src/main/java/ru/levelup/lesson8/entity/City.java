package ru.levelup.lesson8.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cities")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id()
    private Integer id;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "amount_of_citizens")
    private Integer amountOfCitizens;

    @ManyToOne
    @JoinColumn(name = "id_of_region")
    private Region region;
}
