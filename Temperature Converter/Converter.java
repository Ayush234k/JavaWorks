import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperature, convertedTemperature;
        char choice;

        do {
            System.out.println("\nTemperature Converter");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.print("Enter your choice (1 or 2): ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    System.out.print("Enter temperature in Celsius: ");
                    temperature = scanner.nextDouble();
                    convertedTemperature = celsiusToFahrenheit(temperature);
                    System.out.println(temperature + "°C is equal to " + convertedTemperature + "°F");
                    break;
                case '2':
                    System.out.print("Enter temperature in Fahrenheit: ");
                    temperature = scanner.nextDouble();
                    convertedTemperature = fahrenheitToCelsius(temperature);
                    System.out.println(temperature + "°F is equal to " + convertedTemperature + "°C");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.print("Do you want to continue (y/n)? ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        scanner.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}