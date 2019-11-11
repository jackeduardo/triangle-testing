package determine_triangle;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        System.out.println("A triangle");
        Triangle triangle = new Triangle();
        Verify(triangle);
    }

    public static void Verify(Triangle t) {
        Scanner read_sides = new Scanner(System.in);
        double first_side;
        double second_side;
        double third_side;
        double first_corner;
        double second_corner;
        double third_corner;
        try {
            System.out.println("Enter sides for the triangle");
            first_side = read_sides.nextDouble();
            second_side = read_sides.nextDouble();
            third_side = read_sides.nextDouble();
            System.out.println("Enter corners for the triangle");
            first_corner = read_sides.nextDouble();
            second_corner = read_sides.nextDouble();
            third_corner = read_sides.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Input is invalid，Program ended.");
            throw e;
        }
        System.out.println("First side is: " + first_side);
        System.out.println("Second side is :" + second_side);
        System.out.println("Third side is :" + third_side);
        System.out.println("First corner is: " + first_corner);
        System.out.println("Second corner is :" + second_corner);
        System.out.println("Third corner is :" + third_corner);
        double[] sides = {first_side, second_side, third_side};
        double[] corners = {first_corner, second_corner, third_corner};
        t.set_sides(sides);
        t.set_corners(corners);
        boolean judge_sides = t.Verify_sides();
        boolean judge_corners = t.Verify_corners();
        if (judge_sides && judge_corners) {
            System.out.println("Initializing the triangle...");
            t.determine();
            t.getArea();
        }
    }

}