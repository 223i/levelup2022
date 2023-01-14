package ru.levelup.lesson6.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;

@Service
public class FibonacciCalculationService implements FibonacciService {

    @Value("${levelup.application.useStorage}")
    private boolean useStorage;

    private static HashMap<Integer, BigInteger> calculatedValues = new HashMap<>();

    @Override
    public BigInteger calculate(Integer numberOfValue) {
        if (useStorage && calculatedValues.containsKey(numberOfValue)) {
            System.out.println("Fibonacci results for " + numberOfValue +
                    " value is taken from cache and equals to " + calculatedValues.get(numberOfValue));
            return calculatedValues.get(numberOfValue);
        } else {

            BigInteger n0 = new BigInteger("1");
            BigInteger n1 = new BigInteger("1");
            BigInteger result = new BigInteger("0");
            for (int i = 1; i <= numberOfValue; i++) {
                result = n0.add(n1);
                n0 = n1;
                n1 = result;
                if (useStorage && !calculatedValues.containsKey(i)) {
                    calculatedValues.put(i, result);
                }
            }

            if (useStorage) {
                calculatedValues.put(numberOfValue, result);
                System.out.println("Fibonacci results for " + numberOfValue +
                        " value is calculated and added to cache ");
            }
            return result;
        }
    }
}
