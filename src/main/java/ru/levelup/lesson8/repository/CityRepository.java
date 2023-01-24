package ru.levelup.lesson8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.levelup.lesson8.entity.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("select city from City city "+
            "where city.id = :id and city.nameRu = :nameRu")
    List<City> findCityByNameRuAndId(Integer id, String nameRu);

    @Query("select city from City city "+
            "where city.id = :id and city.nameRu = :nameRu")
    List<City> createCityWithSpecifiedRegion(Integer id, String nameRu);
}
