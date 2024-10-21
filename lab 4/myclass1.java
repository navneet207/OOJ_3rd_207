import java.util.Scanner;

abstract class Shape {
    protected int dim1;
    protected int dim2;

    abstract void printArea();
}

class Rectangle extends Shape {
    public Rectangle(int length, int width) {
        this.dim1 = length;
        this.dim2 = width;
    }

    void printArea() {
        double area = dim1 * dim2;
        System.out.println("Area of Rectangle is: " + area);
    }
}

class Triangle extends Shape {
    public Triangle(int base, int height) {
        this.dim1 = height;
        this.dim2 = base;
    }

    void printArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle is: " + area);
    }
}

class Circle extends Shape {
    public Circle(int radius) {
        this.dim1 = radius;
        this.dim2 = 0; // dim2 is not used in circle, but kept for consistency
    }

    void printArea() {
        double area = Math.PI * dim1 * dim1;
        System.out.println("Area of Circle is: " + area);
    }
}

public class MyClass1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Rectangle
        System.out.println("Enter length and width of rectangle: ");
        int reclength = sc.nextInt();
        int recwidth = sc.nextInt();
        Shape rec = new Rectangle(reclength, recwidth);
        rec.printArea();

        // Triangle
        System.out.println("Enter base and height of triangle: ");
        int tribase = sc.nextInt();
        int triheight = sc.nextInt();
        Shape tri = new Triangle(tribase, triheight);
        tri.printArea();

        // Circle
        System.out.println("Enter radius of circle: ");
        int cirradius = sc.nextInt();
        Shape cir = new Circle(cirradius);
        cir.printArea();

        sc.close();
    }
}
