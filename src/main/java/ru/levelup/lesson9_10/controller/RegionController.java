package ru.levelup.lesson9_10.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.levelup.lesson9_10.dto.RegionDto;
import ru.levelup.lesson9_10.entity.Region;
import ru.levelup.lesson9_10.service.RegionService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/region")
public class RegionController {
    @Autowired
    private ModelMapper modelMapper;
    private final RegionService regionService;

    @GetMapping("/findById")
    public ResponseEntity<RegionDto> findById(@RequestParam @Valid Integer id) {
        Optional<Region> region = regionService.findById(id);
        return region.map(result -> new ResponseEntity<>(modelMapper.map(result, RegionDto.class), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByNameRu")
    public List<RegionDto> findByNameRu(@RequestParam @Valid String nameRu) {
        return regionService.findByNameRu(nameRu).stream()
                .map(region -> modelMapper.map(region, RegionDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public void create(@RequestBody RegionDto region) {
        region.setId(Math.abs(new Random().nextInt()));
        Region regionEntity = modelMapper.map(region, Region.class);
        regionService.create(regionEntity);
    }

    @PutMapping("/update")
    public void update(@RequestBody RegionDto region) {
        Region regionEntity = modelMapper.map(region, Region.class);
        regionService.update(regionEntity);
    }

    @DeleteMapping("/deleteById")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestParam @Valid Integer id) {
        regionService.deleteById(id);
    }
}
