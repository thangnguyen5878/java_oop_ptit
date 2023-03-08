public class Rectangle {
    private double length;
    private double width;

    // Constructors
    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Getters and setters
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Methods
    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length * width);
    }
}