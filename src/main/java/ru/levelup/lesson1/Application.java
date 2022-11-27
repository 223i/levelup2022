package ru.levelup.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public class ConverterController {

        @GetMapping({"converter/{value}"})
        public String converter(@PathVariable Integer value) {
            String welcomePhrase = "Let's convert from dollar to ruble:";
            return welcomePhrase + " " + value + "$ = " + value * 60 + " RUB";
        }
    }

}
