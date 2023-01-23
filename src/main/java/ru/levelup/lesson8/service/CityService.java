package ru.levelup.lesson8.service;

import ru.levelup.lesson8.entity.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    Optional<City> findById(Integer id);

    List<City> findByIdAndNameRu(Integer id, String nameRu);

    void create(City city);

    void update(City city);

    void deleteById(Integer id);

}
