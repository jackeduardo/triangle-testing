package determine_triangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Triangle {
    private double[] sides;
    private double[] corners;

    Triangle() {
    }

    public void set_sides(double[] Sides) {
        this.sides = Sides;
    }

    public void set_corners(double[] Corners) {
        this.corners = Corners;
    }

    public boolean Verify_sides() {
        String[] sides_order = {"First", "Second", "Third"};
        boolean[] judge = {true, true, true};
        double a = sides[0], b = sides[1], c = sides[2];
        for (int i = 0; i < 3; i++) {
            if (sides[i] <= 0) {
                System.out.println("The value of " + sides_order[i] + " side is not a positive real-number.");
                judge[i] = false;
            }
        }
        if (judge[0] && judge[1] && judge[2])
            if (!((a + b) > c && (a + c) > b && (b + c) > a)) {
                System.out.println("Three side_lengths cannot determine a valid triangle.");
                judge[0] = false;
            }
        for (boolean j : judge) {
            if (!j) {
                return false;
            }
        }
        System.out.println("All sides are valid.");
        return true;
    }

    public boolean Verify_corners() {
        String[] corner_order = {"First", "Second", "Third"};
        boolean[] judge = {true, true, true};
        double c1 = corners[0], c2 = corners[1], c3 = corners[2];
        for (int i = 0; i < 3; i++) {
            if (corners[i] <= 0) {
                System.out.println("The value of " + corner_order[i] + " corner is not a positive real-number.");
                judge[i] = false;
            }
        }
        if (judge[0] && judge[1] && judge[2])
            if (c1 + c2 + c3 != 180) {
                System.out.println("The sum of three corners is not 180 degrees, cannot determine a valid triangle.");
                judge[0] = false;
            }
        for (boolean j : judge) {
            if (!j) {
                return false;
            }
        }
        System.out.println("All corners are valid.");
        return true;
    }

    public void determine() {
        double a = sides[0], b = sides[1], c = sides[2];
        String[] triangle_types = {"Equilateral", "Isosceles", "Scalene", "Right"};
        StringBuilder result = new StringBuilder();
        ArrayList<String> triangle_type_tags = new ArrayList<String>();
        if (a == b && b == c ) {
            triangle_type_tags.add(triangle_types[0]);
        }
        if ((a == b || b == c || a == c) && !(a == b && b == c )) {
            triangle_type_tags.add(triangle_types[1]);
        }
        if (a != b && b != c && a != c) {
            triangle_type_tags.add(triangle_types[2]);
        }
        if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
            triangle_type_tags.add(triangle_types[3]);
        }
        String[] triangle_type_tags_array = triangle_type_tags.toArray(new String[triangle_type_tags.size()]);
        if (triangle_type_tags.size() > 1) {
            for (int i = 0; i < triangle_type_tags.size(); i++)
                if (i != triangle_type_tags.size() - 1)
                    result.append(triangle_type_tags_array[i]).append(" and ");
                else
                    result.append(triangle_type_tags_array[i]);
        } else {
            result.append(triangle_type_tags_array[0]);
        }
        System.out.println("The triangle is " + result + ".");

    }

    public void getArea() {
        double a = sides[0], b = sides[1], c = sides[2];
        double s = (a + b + c) / 2;
        double Area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println("The area is the triangle is: " + Area);
    }

}

