package ru.levelup.lesson9_10.entity;

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

    @Id
    private Integer id;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "amount_of_citizens")
    private Integer amountOfCitizens;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_of_region")
    private Region region;
}
