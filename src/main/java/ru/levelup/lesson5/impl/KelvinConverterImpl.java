package ru.levelup.lesson5.impl;

import org.springframework.stereotype.Component;
import ru.levelup.lesson5.TemperatureConverter;

@Component
public class KelvinConverterImpl implements TemperatureConverter {

    @Override
    public double convertTemperature(double from, String toType) {
        double result;
        if (toType.equals("KELVIN")) {
            result = from;
        } else if (toType.equals("FAHRENHEIT")) {
            result = ((from + 459.67) * 5) / 9;
        } else {
            result = from + 273.15;
        }
        System.out.println(result);
        return result;
    }
}
