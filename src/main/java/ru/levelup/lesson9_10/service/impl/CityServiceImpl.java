package ru.levelup.lesson9_10.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.lesson9_10.entity.City;
import ru.levelup.lesson9_10.repository.CityRepository;
import ru.levelup.lesson9_10.service.CityService;


import java.util.List;
import java.util.Optional;

import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;

@Service
@RequiredArgsConstructor
@Transactional
public class CityServiceImpl implements CityService {

    private final CityRepository repository;
    @Transactional(isolation = READ_COMMITTED)
    @Override
    public Optional<City> findById(Integer id) {
        return repository.findById(id);
    }
    @Transactional(isolation = READ_COMMITTED)
    @Override
    public List<City> findByIdAndNameRu(Integer id, String nameRu) {
        return repository.findCityByNameRuAndId(id, nameRu);
    }

    @Override
    public void create(City city) {
        repository.save(city);
    }

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public void update(City city) {
        repository.save(city);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
