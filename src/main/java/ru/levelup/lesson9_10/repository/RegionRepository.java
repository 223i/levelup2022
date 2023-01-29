package ru.levelup.lesson9_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.levelup.lesson9_10.entity.Region;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer> {

    @Query("select region from Region region " +
            "where region.nameRu = :nameRu")
    List<Region> findRegionByNameRu(String nameRu);
}
