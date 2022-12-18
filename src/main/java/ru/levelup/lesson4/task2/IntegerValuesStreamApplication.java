package ru.levelup.lesson4.task2;

import java.util.HashMap;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class IntegerValuesStreamApplication {

    public static void main(String[] args) {
        /*  Сгенерировать поток на 1000 целочисленных псевдослучайных значений.
            Необходимо рассчитать максимальное, минимальное, а также среднее значения в этом потоке.
          Также посчитать сумму всех нечетных элементов. */

        Supplier<Stream<Integer>> stream = () -> Stream.generate(new Random()::nextInt)
                .limit(1000);


        int minValue = stream.get().mapToInt(e -> e).min().getAsInt();
        int maxValue = stream.get().mapToInt(e -> e).max().getAsInt();
        double averageValue = stream.get().mapToInt(e -> e).average().getAsDouble();

        int sumOfUnevenElements = stream.get().mapToInt(e -> e)
                .filter(element -> element % 2 != 0)
                .sum();

        System.out.println("Results of calculation: \n"
                + "MinValue = " + minValue + "\n"
                + "MaxValue = " + maxValue + "\n"
                + "Average value = " + averageValue + "\n"
                + "Sum of uneven elements = " + sumOfUnevenElements + "\n");

        /*  Дополнительно можно преобразовать данный поток к карте так,
            чтобы ключом выступало текущее число, а значением -
            сумма цифр в этом числе или само число, если оно одноразрядное.
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        stream.get().forEach(element -> map.put(element, parsDigits(element)));

        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


    }

    public static int parsDigits(int number) {
        String s = Integer.toString(number).replace("-", "");
        Integer sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return sum;
    }

}