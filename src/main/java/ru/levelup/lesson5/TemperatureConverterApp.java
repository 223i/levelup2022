package ru.levelup.lesson5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;

@SpringBootApplication
public class TemperatureConverterApp {

//    Необходимо реализовать конвертер температур, позволяющий
//    переводить значения из одной системы в другую. В логике
//    программы следует предусмотреть конвертацию из Цельсий в
//    Кельвины и Фаренгейты, а также любой их комбинации. Объект,
//    получаемого конвертера, должен являться бином со скоупом
//    Singleton.

    private static HashMap<TemperatureTypes, TemperatureConverter> beansHashMap = new HashMap<>();

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TemperatureConverterApp.class, args);
        context.getBeansOfType(TemperatureConverter.class)
                .forEach((key, value) -> beansHashMap.put(value.returnBaseTemperatureType(), value));
        beansHashMap.get(TemperatureTypes.CELSIUS).convertTemperature(2.3, TemperatureTypes.FAHRENHEIT);
    }
}
