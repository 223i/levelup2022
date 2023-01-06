package ru.levelup.lesson6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.levelup.lesson6.servers.FibonacciCalculationService;

import java.math.BigInteger;

@SpringBootApplication
public class Application {

    @Autowired
    private FibonacciCalculationService fibonacciCalculationService;

//    Необходимо реализовать сервис, который вычисляет n-ый член
//    последовательности Фибоначчи. Данный параметр необходимо
//    запрашивать из консоли пользователя. Также требуется
//    предусмотреть отдельный конфигурационный параметр, с
//    помощью которого следует предусмотреть возможность
//    «получения» данных из кэша в памяти (если ранее такие
//    значения вычислялись или содержались в результате предыдущих расчетов).


    public static void main(String[] args) {
        SpringApplication.run(ru.levelup.lesson6.Application.class, args);
    }

    @RestController
    public class ConverterController {

        @GetMapping({"fibonacciCounter/{value}"})
        public String counter(@PathVariable BigInteger value) {
            String welcomePhrase = "Let's count fibonacci value: for " + value + " = ";
            return welcomePhrase + fibonacciCalculationService.calculate(value);
        }
    }

}

