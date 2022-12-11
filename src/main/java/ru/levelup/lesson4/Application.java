package ru.levelup.lesson4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(
                new FileReader("src/main/java/ru/levelup/lesson4/TextFile.txt"));
        Map<String, Integer> words = new HashMap<>();
        while (fileReader.ready()) {
            Arrays.stream(fileReader.readLine().replaceAll("[@#$%^&*.,!()-_+=\"]", "")
                            .split("\\s"))
                    .forEach(word -> {
                        String lcWord = word.toLowerCase();
                        if (words.containsKey(lcWord)) words.replace(lcWord, words.get(lcWord) + 1);
                        else words.put(lcWord, 1);
                    });
        }

        Map<String, Integer> sortedWords = words.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));

        sortedWords.forEach((key, value) -> System.out.println(key + " : " + value));


    }
}
