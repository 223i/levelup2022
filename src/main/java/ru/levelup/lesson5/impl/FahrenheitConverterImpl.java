package ru.levelup.lesson5.impl;

import org.springframework.stereotype.Component;
import ru.levelup.lesson5.TemperatureConverter;

@Component
public class FahrenheitConverterImpl implements TemperatureConverter {
    @Override
    public double convertTemperature(double from, String toType) {
        double result;
        if (toType.equals("FAHRENHEIT")) {
            result = from;
        } else if (toType.equals("KELVIN")) {
            result = (from - 273.15) * 9 / 5 + 32;
        } else {
            result = (from - 32) * 5 / 9;
        }
        System.out.println(result);
        return result;
    }
}
