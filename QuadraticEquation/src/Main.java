import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Enter a, b, c in the quadratic equation: ax^2 + bx + c
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Giải phương trình bậc hai ax^2 + bx + c\n");
        System.out.printf("a = ");
        double a = scanner.nextDouble();
        System.out.printf("b = ");
        double b = scanner.nextDouble();
        System.out.printf("c = ");
        double c = scanner.nextDouble();

        // Create and solve the equation
        QuadraticEquation equation1 = new QuadraticEquation(a, b, c);
        equation1.solveEquation();
    }
}