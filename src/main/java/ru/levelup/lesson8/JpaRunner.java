package ru.levelup.lesson8;

import org.apache.coyote.RequestGroupInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson8.entity.City;
import ru.levelup.lesson8.entity.Region;
import ru.levelup.lesson8.service.CityService;
import ru.levelup.lesson8.service.RegionService;

import java.util.Scanner;

@SpringBootApplication
public class JpaRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JpaRunner.class, args);
        CityService cityService = context.getBean(CityService.class);
        RegionService regionService = context.getBean(RegionService.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите параметры для создания города - код города, наименование на русском и английском, количество жителей и код региона: ");
        int idCity = scanner.nextInt();
        String nameRuCity = scanner.next();
        String nameEnCity = scanner.next();
        int citizensCity = scanner.nextInt();
        int idRegion = scanner.nextInt();
        if(cityService.findById(idCity).isEmpty()){
            if(regionService.findById(idRegion).isEmpty()){
                System.out.println("Введите параметры для создания региона - наименование на русском и английском: ");
                String nameRuRegion = scanner.next();
                String nameEnRegion = scanner.next();
                regionService.create(new Region(idRegion, nameRuRegion, nameEnRegion));
            }
            cityService.create(new City(idCity, nameRuCity, nameEnCity, citizensCity, regionService.findById(idRegion).get()));
        }
        System.out.println(cityService.findById(idCity));
        System.out.println(regionService.findById(idRegion));
    }
}
