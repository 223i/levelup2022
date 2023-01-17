package ru.levelup.lesson7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson7.impl.CityDao;
import ru.levelup.lesson7.impl.RegionDao;
import ru.levelup.lesson7.model.City;
import ru.levelup.lesson7.model.Region;

@SpringBootApplication
public class DaoRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DaoRunner.class, args);
        CityDao cityDao = context.getBean(CityDao.class);
        System.out.println(cityDao.findAll());
        System.out.println(cityDao.getById(1));
        City city = new City(1, "город", "city", 234,
                new Region(2, "регион", "region"));
        cityDao.update(city);
        System.out.println(cityDao.getById(1));


        RegionDao regionDao = context.getBean(RegionDao.class);
        Region region = new Region(123, "регион", "region");
        regionDao.create(region);
        System.out.println(regionDao.findAll());
        System.out.println(regionDao.getById(2));

    }
}
