import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input coefficients a, b, and c
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        // Calculate the discriminant
        double discriminant = b * b - 4 * a * c;

        // Check the nature of the roots
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots are real and different.");
            System.out.printf("Root 1: %.2f\n", root1);
            System.out.printf("Root 2: %.2f\n", root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Roots are real and the same.");
            System.out.printf("Root: %.2f\n", root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("Roots are complex and different.");
            System.out.printf("Root 1: %.2f + %.2fi\n", realPart, imaginaryPart);
            System.out.printf("Root 2: %.2f - %.2fi\n", realPart, imaginaryPart);
        }

        scanner.close();
    }
}
