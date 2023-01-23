package ru.levelup.lesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson8.service.CityService;

@SpringBootApplication
public class JpaRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JpaRunner.class, args);
        CityService cityService = context.getBean(CityService.class);
        System.out.println(cityService.findById(495));
    }
}
