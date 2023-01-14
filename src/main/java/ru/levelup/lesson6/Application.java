package ru.levelup.lesson6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.levelup.lesson6.service.FibonacciCalculationService;

@SpringBootApplication
public class Application {

    @Autowired
    private FibonacciCalculationService fibonacciCalculationService;

    public static void main(String[] args) {
        SpringApplication.run(ru.levelup.lesson6.Application.class, args);
    }

    @RestController
    public class ConverterController {

        @GetMapping("fibonacciCounter/{value}")
        public String counter(@PathVariable Integer value) {
            String welcomePhrase = "Let's count fibonacci value: for " + value + " = ";
            return welcomePhrase + fibonacciCalculationService.calculate(value);
        }
    }

}

