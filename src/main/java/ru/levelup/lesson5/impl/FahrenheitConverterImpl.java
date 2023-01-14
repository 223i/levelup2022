package ru.levelup.lesson5.impl;

import org.springframework.stereotype.Component;
import ru.levelup.lesson5.TemperatureConverter;
import ru.levelup.lesson5.TemperatureTypes;

@Component
public class FahrenheitConverterImpl implements TemperatureConverter {
    @Override
    public double convertTemperature(double from, TemperatureTypes toType) {
        double result;
        if (toType.equals(TemperatureTypes.FAHRENHEIT)) {
            result = from;
        } else if (toType.equals(TemperatureTypes.KELVIN)) {
            result = (from - 273.15) * 9 / 5 + 32;
        } else {
            result = (from - 32) * 5 / 9;
        }
        System.out.println(result);
        return result;
    }

    @Override
    public TemperatureTypes returnBaseTemperatureType() {
        return TemperatureTypes.FAHRENHEIT;
    }
}
