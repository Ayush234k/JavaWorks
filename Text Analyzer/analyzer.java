import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class analyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text to analyze: ");
        String text = scanner.nextLine();

        int wordCount = countWords(text);
        int characterCount = countCharacters(text);

        Map<String, Integer> wordFrequency = calculateWordFrequency(text);

        System.out.println("\nAnalysis Results:");
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count (excluding spaces): " + characterCount);
        System.out.println("\nWord Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+"); 
        return words.length;
    }

    private static int countCharacters(String text) {
        String trimmedText = text.replaceAll("\\s+", ""); 
        return trimmedText.length();
    }

    private static Map<String, Integer> calculateWordFrequency(String text) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = text.toLowerCase().split("\\s+"); 

        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        return wordFrequency;
    }
}