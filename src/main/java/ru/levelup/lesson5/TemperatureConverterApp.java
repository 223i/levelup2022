package ru.levelup.lesson5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson5.impl.CelsiusConverterImpl;

@SpringBootApplication
public class TemperatureConverterApp {

//    Необходимо реализовать конвертер температур, позволяющий
//    переводить значения из одной системы в другую. В логике
//    программы следует предусмотреть конвертацию из Цельсий в
//    Кельвины и Фаренгейты, а также любой их комбинации. Объект,
//    получаемого конвертера, должен являться бином со скоупом
//    Singleton.

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TemperatureConverterApp.class, args);
        CelsiusConverterImpl celsiusConverter = context.getBean(CelsiusConverterImpl.class);
        celsiusConverter.convertTemperature(2.3, TemperatureTypes.FAHRENHEIT);
    }
}
