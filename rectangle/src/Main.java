import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Enter length and width of the rectangle
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter width and height of the rectangle");
        System.out.printf("Width: ");
        double width = scanner.nextDouble();
        System.out.printf("Length: ");
        double length = scanner.nextDouble();

        Rectangle rectangle1 = new Rectangle(length, width);

        // calculate area and perimeter
        System.out.println("Area: " + rectangle1.getArea());
        System.out.println("Perimeter: " + rectangle1.getPerimeter());
    }
}