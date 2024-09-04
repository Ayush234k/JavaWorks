import java.util.Scanner;

public class bmiCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter weight and height
        System.out.println("Enter your weight in kilograms:");
        double weight = scanner.nextDouble();
        
        System.out.println("Enter your height in meters:");
        double height = scanner.nextDouble();

        // Calculate BMI
        double bmi = calculateBMI(weight, height);

        // Display the result
        System.out.printf("Your BMI is: %.2f%n", bmi);

        // Close the scanner
        scanner.close();
    }

    public static double calculateBMI(double weight, double height) {
        if (height > 0) {
            return weight / (height * height);
        } else {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
    }
}
