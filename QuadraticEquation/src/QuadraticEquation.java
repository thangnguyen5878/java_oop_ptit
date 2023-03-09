import java.text.DecimalFormat;
import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    // Format số double cho đẹp hơn
    // Loại bỏ tất cả chữ số 0 ở phần thập phân, chuyển về kiểu String
    // VD: fm.format(3.400000) -> "3.4"
    DecimalFormat fm = new DecimalFormat("0.#");

    // Constructors
    public QuadraticEquation() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Getters and setters
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDelta() {
        return (b * b) - (4 * a * c);
    }

    public void solveEquation() {
        double delta = getDelta();

        if (delta < 0) {
            System.out.printf("Delta: %s\n", fm.format(delta));
            System.out.println("Phương trình vô nghiệm");
        } else if (delta == 0) {
            double x = -b/(2*a);
            System.out.printf("Delta: %s\n", fm.format(delta));
            System.out.printf("Phương trình có nghiệm kép: %s", x);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.printf("Delta: %s\n", fm.format(delta));
            System.out.printf("Phương trình có hai nghiệm phân biệt: x1 = %s, x2 = %s", fm.format(x1), fm.format(x2));
        }
    }
}