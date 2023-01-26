package ru.levelup.lesson8.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levelup.lesson8.entity.Region;
import ru.levelup.lesson8.repository.RegionRepository;
import ru.levelup.lesson8.service.RegionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository repository;

    @Override
    public Optional<Region> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Region> findByNameRu(String nameRu) {
        return repository.findRegionByNameRu(nameRu);
    }

    @Override
    public void create(Region region) {
        repository.save(region);
    }

    @Override
    public void update(Region region) {
        repository.save(region);

    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
