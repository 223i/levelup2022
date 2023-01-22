package ru.levelup.lesson7.impl;

import ru.levelup.lesson7.model.Region;

import java.util.List;
import java.util.Optional;

public interface RegionDao {

    List<Region> findAll();

    Optional<Region> getById(int regionId);

    int create(Region region);
}
