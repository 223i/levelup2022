package ru.levelup.lesson8.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levelup.lesson8.entity.City;
import ru.levelup.lesson8.repository.CityRepository;
import ru.levelup.lesson8.service.CityService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    @Override
    public Optional<City> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<City> findByIdAndNameRu(Integer id, String nameRu) {
        return repository.findCityByNameRuAndId(id, nameRu);
    }

    @Override
    public void create(City city) {
        repository.save(city);
    }

    @Override
    public void update(City city) {
        repository.save(city);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
