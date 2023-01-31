package ru.levelup.lesson9_10.service;

import ru.levelup.lesson9_10.entity.Region;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface RegionService {
    Optional<Region> findById(Integer id);

    List<Region> findByNameRu(String nameRu);

    void create(Region region);

    void update(Region region);

    void deleteById(Integer id);
}
