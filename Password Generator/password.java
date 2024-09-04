import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class password{

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include digits? (yes/no): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");

        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecialChars);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, 
                                          boolean includeDigits, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder(length);
        SecureRandom random = new SecureRandom();
        List<String> charCategories = new ArrayList<>();

        if (includeUppercase) {
            charCategories.add(UPPERCASE_LETTERS);
        }
        if (includeLowercase) {
            charCategories.add(LOWERCASE_LETTERS);
        }
        if (includeDigits) {
            charCategories.add(DIGITS);
        }
        if (includeSpecialChars) {
            charCategories.add(SPECIAL_CHARACTERS);
        }

        if (charCategories.isEmpty()) {
            throw new IllegalArgumentException("At least one character category must be selected");
        }

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        return password.toString();
    }
}
