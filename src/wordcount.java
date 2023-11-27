import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.IOException;

public class wordcount {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a file name");
        String pathOfFile = sc.nextLine();
        try {
            Map<String, Integer> wordCounts = fileRead(pathOfFile);
            String result = calculateWordCount(wordCounts);
            System.out.println(result);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static Map<String, Integer> fileRead(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Map<String, Integer> countMap = new HashMap<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    countMap.put(word, countMap.getOrDefault(word, 0) + 1);
                }
            }

            return countMap;
        }
    }

    public static String calculateWordCount(Map<String, Integer> countMap) {
        return countMap.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}
