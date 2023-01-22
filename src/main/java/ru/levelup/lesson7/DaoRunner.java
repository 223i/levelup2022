package ru.levelup.lesson7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson7.impl.CityDao;
import ru.levelup.lesson7.impl.RegionDao;
import ru.levelup.lesson7.model.City;
import ru.levelup.lesson7.model.Region;

import java.util.Scanner;

@SpringBootApplication
public class DaoRunner {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DaoRunner.class, args);

        workWithCity(context);
        System.out.println("---------------------------------");
        workWithRegion(context);

    }

    private static void workWithCity(ConfigurableApplicationContext context) {
        CityDao cityDao = context.getBean(CityDao.class);
        System.out.println("Введите номер города, его имя на русском и английском, количество жителей: \n");
        Integer cityId = input.nextInt();
        String nameCityRu = input.next();
        String nameCityEn = input.next();
        Integer citizens = input.nextInt();


        cityDao.create(new City(cityId, nameCityRu, nameCityEn, citizens, null));
        System.out.println(cityDao.findAll());
        System.out.println(cityDao.getById(cityId));

        System.out.println("Введите номер региона, его имя на русском и английском: \n");
        int regionId = input.nextInt();
        String nameRegionRu = input.next();
        String nameRegionEn = input.next();
        RegionDao regionDao = context.getBean(RegionDao.class);
        if (regionDao.getById(regionId).isEmpty()) {
            regionDao.create(new Region(regionId, nameRegionRu, nameRegionEn));
        }
        System.out.println(regionDao.getById(regionId));

        City city = new City(cityId, nameCityRu, nameCityEn, citizens,
                new Region(regionId, nameRegionRu, nameRegionEn));
        cityDao.update(city);
        System.out.println(cityDao.getById(cityId));
    }

    private static void workWithRegion(ConfigurableApplicationContext context) {

        System.out.println("Введите номер региона, его имя на русском и английском: ");
        int regionId = input.nextInt();
        String nameRegionRu = input.next();
        String nameRegionEn = input.next();
        RegionDao regionDao = context.getBean(RegionDao.class);
        Region region = new Region(regionId, nameRegionRu, nameRegionEn);
        regionDao.create(region);
        System.out.println(regionDao.findAll());
        System.out.println(regionDao.getById(regionId));
    }
}
