package ru.levelup.lesson9_10.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.lesson9_10.entity.Region;
import ru.levelup.lesson9_10.repository.RegionRepository;
import ru.levelup.lesson9_10.service.RegionService;

import java.util.List;
import java.util.Optional;

import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository repository;

    @Transactional(isolation = READ_COMMITTED)
    @Override
    public Optional<Region> findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional(isolation = READ_COMMITTED)
    @Override
    public List<Region> findByNameRu(String nameRu) {
        return repository.findRegionByNameRu(nameRu);
    }

    @Override
    public void create(Region region) {
        repository.save(region);
    }

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public void update(Region region) {
        repository.save(region);

    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
