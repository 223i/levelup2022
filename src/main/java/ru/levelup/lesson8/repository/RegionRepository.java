package ru.levelup.lesson8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelup.lesson8.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}
