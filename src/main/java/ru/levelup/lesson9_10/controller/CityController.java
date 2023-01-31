package ru.levelup.lesson9_10.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.levelup.lesson9_10.dto.CityDto;
import ru.levelup.lesson9_10.entity.City;
import ru.levelup.lesson9_10.service.CityService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private ModelMapper modelMapper;
    private final CityService cityService;


    @GetMapping("/findById")
    public ResponseEntity<CityDto> findById(@RequestParam @Valid Integer id) {
        Optional<City> city = cityService.findById(id);
        return city.map(result -> new ResponseEntity<>(modelMapper.map(result, CityDto.class), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByIdAndNameRu")
    public List<CityDto> findByIdAndNameRu(@Valid @RequestParam Integer id, @Valid @RequestParam String nameRu) {
        return cityService.findByIdAndNameRu(id, nameRu).stream()
                .map(city -> modelMapper.map(city, CityDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public void create(@RequestBody CityDto city) throws Exception {
        city.setId(Math.abs(new Random().nextInt()));
        City cityEntity = modelMapper.map(city, City.class);
        cityService.create(cityEntity);
    }

    @PutMapping("/update")
    public void update(@RequestBody CityDto city) {
        if (city.getId() <= 0) {
            throw new IllegalArgumentException("Not valid argument: city.id should be more than 0");
        }
        City cityEntity = modelMapper.map(city, City.class);
        cityService.update(cityEntity);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam @Valid Integer id) {
        cityService.deleteById(id);
    }
}
