package ru.levelup.lesson8.service;

import ru.levelup.lesson8.entity.Region;

import java.util.List;
import java.util.Optional;

public interface RegionService {
    Optional<Region> findById(Integer id);

    List<Region> findByNameRu(String nameRu);

    void create(Region region);

    void update(Region region);

    void deleteById(Integer id);
}
