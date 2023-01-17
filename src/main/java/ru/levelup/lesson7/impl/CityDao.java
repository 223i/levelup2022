package ru.levelup.lesson7.impl;

import ru.levelup.lesson7.model.City;

import java.util.List;
import java.util.Optional;

public interface CityDao {

    List<City> findAll();

    Optional<City> getById(int cityId);

    int create(City city);

    void update(City city);

    void deleteById(int cityId);
}
