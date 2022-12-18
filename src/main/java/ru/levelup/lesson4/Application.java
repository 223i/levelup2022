package ru.levelup.lesson4;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws IOException {
        Scanner fileReader = new Scanner(new File("src/main/resources/TextFile.txt"));
        Map<String, Integer> words = new HashMap<>();
        while (fileReader.hasNextLine()) {
            Arrays.stream(fileReader.nextLine().replaceAll("[@#$%^&*.,!()-+=\"]", "")
                            .split("\\s"))
                    .forEach(word -> {
                        String lcWord = word.toLowerCase();
                        if(words.putIfAbsent(lcWord, 1) != null)  words.replace(lcWord, words.get(lcWord) + 1);
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
