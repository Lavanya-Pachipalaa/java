abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double calculateArea();

    public void displayInfo() {
        System.out.println("Shape: " + name);
        System.out.println("Area: " + calculateArea());
    }
}

// TODO: Create a Circle class that extends Shape
// The Circle class should have a private double radius attribute and a
// constructor to initialize it
// It should also implement the calculateArea() method
class Circle extends Shape {

    private double radius;

    public Circle(String name, double radius) {
        super(name);

        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// TODO: Create a Rectangle class that extends Shape
// The Rectangle class should have private double attributes for length and
// width, and a constructor to initialize them
// It should also implement the calculateArea() method
class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(String name, double length, double width) {
        super(name);

        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }
}
