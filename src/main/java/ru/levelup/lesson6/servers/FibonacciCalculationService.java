package ru.levelup.lesson6.servers;

import org.springframework.stereotype.Component;
import ru.levelup.lesson6.FibonacciService;

import java.math.BigInteger;
import java.util.HashMap;

@Component
public class FibonacciCalculationService implements FibonacciService {

    private static HashMap<BigInteger, BigInteger> calculatedValues = new HashMap<>();


    @Override
    public BigInteger calculate(BigInteger numberOfValue) {
        if (calculatedValues.containsKey(numberOfValue)) {
            System.out.println("Fibonacci results for " + numberOfValue +
                    " value is taken from cache and equals to " + calculatedValues.get(numberOfValue));
            return calculatedValues.get(numberOfValue);
        } else {

            BigInteger n0 = new BigInteger("1");
            BigInteger n1 = new BigInteger("1");
            BigInteger result = new BigInteger("0");
            for (int i = 1; i <= numberOfValue.intValue(); i++) {
                result = n0.add(n1);
                n0 = n1;
                n1 = result;
                if (!calculatedValues.containsKey(BigInteger.valueOf(i))){
                    calculatedValues.put(BigInteger.valueOf(i), result);
                }
            }
            calculatedValues.put(numberOfValue, result);
            System.out.println("Fibonacci results for " + numberOfValue +
                    " value is calculated and added to cache ");
            return result;
        }
    }
}
