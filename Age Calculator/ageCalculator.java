import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class ageCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input date of birth
        System.out.print("Enter your birth year (YYYY): ");
        int year = scanner.nextInt();

        System.out.print("Enter your birth month (MM): ");
        int month = scanner.nextInt();

        System.out.print("Enter your birth day (DD): ");
        int day = scanner.nextInt();

        // Calculate age
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        if (birthDate.isAfter(currentDate)) {
            System.out.println("Please enter a valid date.");
            return;
        }

        Period age = Period.between(birthDate, currentDate);

        // Output age
        System.out.println("You are " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days old.");
    }
}
