import java.util.Scanner;

// Step 1: Define the interface
interface Polygon {
    double area();
    double perimeter();
}

/* =========================================================
   Step 2: Base classes + concrete polygon classes
   ========================================================= */

// A general triangle (defined by 3 sides)
class Triangle implements Polygon {
    protected double a, b, c;

    public Triangle(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle sides.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    protected static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0
                && a + b > c
                && a + c > b
                && b + c > a;
    }
    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        double s = perimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

// Isosceles triangle: two equal sides + base
class IsoscelesTriangle extends Triangle {
    protected double equalSide;
    protected double base;

    public IsoscelesTriangle(double equalSide, double base) {
        super(equalSide, equalSide, base);
        this.equalSide = equalSide;
        this.base = base;
    }

    @Override
    public double area() {
        double half = base / 2.0;
        double h = Math.sqrt(equalSide * equalSide - half * half);
        return 0.5 * base * h;
    }
}
// Equilateral triangle: all sides equal
class EquilateralTriangle extends IsoscelesTriangle {
    public EquilateralTriangle(double side) {
        super(side, side);
    }
    public double area() {
        return (Math.sqrt(3) / 4.0) * equalSide * equalSide;
    }
}

// Quadrilateral base class
class Quadrilateral implements Polygon {
    protected double side1, side2, side3, side4;
    public Quadrilateral(double s1, double s2, double s3, double s4) {
        if (s1 <= 0 || s2 <= 0 || s3 <= 0 || s4 <= 0) {
            throw new IllegalArgumentException("Sides must be positive.");
        }
        side1 = s1;
        side2 = s2;
        side3 = s3;
        side4 = s4;
    }
    public double area() {
        return 0;
    }
    public double perimeter() {
        return side1 + side2 + side3 + side4;
    }
}

// Rectangle subclass
class Rectangle extends Quadrilateral {
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        super(length, width, length, width);
        this.length = length;
        this.width = width;
    }
    public double area() {
        return length * width;
    }
    public double perimeter() {
        return 2 * (length + width);
    }
}

// Square subclass
class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

// Regular polygon base (for Pentagon/Hexagon/Octagon)
class RegularPolygon implements Polygon {
    protected int n;        // number of sides
    protected double side;  // side length

    public RegularPolygon(int n, double side) {
        if (n < 3 || side <= 0) {
            throw new IllegalArgumentException("Invalid regular polygon.");
        }
        this.n = n;
        this.side = side;
    }

    public double perimeter() {
        return n * side;
    }
    public double area() {
        // Area = (n * s^2) / (4 * tan(pi/n))
        return (n * side * side) / (4.0 * Math.tan(Math.PI / n));
    }
}

class Pentagon extends RegularPolygon {
    public Pentagon(double side) {
        super(5, side);
    }
}

class Hexagon extends RegularPolygon {
    public Hexagon(double side) {
        super(6, side);
    }
}

class Octagon extends RegularPolygon {
    public Octagon(double side) {
        super(8, side);
    }
}

/* =========================================================
   Main class for user interface
   ========================================================= */

public class Polygon_interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCreate a polygon:");
            System.out.println("1. Triangle  2. Isosceles Triangle   3. Equilateral Triangle");
            System.out.println("4. Rectangle  5. Square"   );
            System.out.println("6. Pentagon (regular)   7. Hexagon (regular)   8. Octagon (regular)"   );
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice;
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number (0-8).");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            Polygon polygon = null;

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter sides a b c: ");
                        double a = scanner.nextDouble();
                        double b = scanner.nextDouble();
                        double c = scanner.nextDouble();
                        polygon = new Triangle(a, b, c);
                    }
                    case 2 -> {
                        System.out.print("Enter equalSide and base: ");
                        double equalSide = scanner.nextDouble();
                        double base = scanner.nextDouble();
                        polygon = new IsoscelesTriangle(equalSide, base);
                    }
                    case 3 -> {
                        System.out.print("Enter side: ");
                        double side = scanner.nextDouble();
                        polygon = new EquilateralTriangle(side);
                    }
                    case 4 -> {
                        System.out.print("Enter length and width: ");
                        double length = scanner.nextDouble();
                        double width = scanner.nextDouble();
                        polygon = new Rectangle(length, width);
                    }
                    case 5 -> {
                        System.out.print("Enter side: ");
                        double side = scanner.nextDouble();
                        polygon = new Square(side);
                    }
                    case 6 -> {
                        System.out.print("Enter side: ");
                        double side = scanner.nextDouble();
                        polygon = new Pentagon(side);
                    }
                    case 7 -> {
                        System.out.print("Enter side: ");
                        double side = scanner.nextDouble();
                        polygon = new Hexagon(side);
                    }
                    case 8 -> {
                        System.out.print("Enter side: ");
                        double side = scanner.nextDouble();
                        polygon = new Octagon(side);
                    }
                    default -> System.out.println("Invalid choice.");
                }

                if (polygon != null) {
                    System.out.println("Perimeter: " + polygon.perimeter());
                    System.out.println("Area: " + polygon.area());
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                // clear the rest of the line so the next loop works cleanly
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
