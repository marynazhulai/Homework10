package task10;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {

        String path = "C:/Users/maryna.zhulai/java/Rihanna-Umbrella.txt";

        try {
            String content = Files.readString(Paths.get(path));
            content = content.toLowerCase();
            Map<String, Integer> myMap = new HashMap<>();
            asList(content .split("\\W+")).forEach(s -> {
                if (myMap.containsKey(s)) {
                    Integer count = myMap.get(s);
                    myMap.put(s, count + 1);
                } else {
                    myMap.put(s, 1);
                }
            });
            System.out.println(myMap.toString());



            System.out.println(Collections.max(myMap.values()));

            for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
                if (entry.getValue().equals(45)) {
                    System.out.printf("word " + entry.getKey() + ": " + Collections.max(myMap.values()) + " times");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




