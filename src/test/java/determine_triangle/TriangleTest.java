package determine_triangle;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void set_sides() {
        Triangle t = new Triangle();
        double[] a = {1.2, 3, 3};
        t.set_sides(a);
    }

    @Test
    public void set_corners() {
        Triangle t = new Triangle();
        double[] a = {50, 50, 80};
        t.set_corners(a);
    }

    @Test
    public void verify_sides() {
        Triangle t = new Triangle();
        double[] a = {3, 3, 3};
        double[] b = {1, 1, 3};
        double[] c = {-1, 1, 3};
        double[] d = {10, 1, 3};
        double[] e = {1, 10, 3};
        double[] f = {1, -1, 3};
        double[] g = {1, 10, -3};
        t.set_sides(a);
        assertTrue(t.Verify_sides());
        t.set_sides(b);
        assertFalse(t.Verify_sides());
        t.set_sides(c);
        assertFalse(t.Verify_sides());
        t.set_sides(d);
        assertFalse(t.Verify_sides());
        t.set_sides(e);
        assertFalse(t.Verify_sides());
        t.set_sides(f);
        assertFalse(t.Verify_sides());
        t.set_sides(g);
        assertFalse(t.Verify_sides());
    }

    @Test
    public void verify_corners() {
        Triangle t = new Triangle();
        double[] a = {100, 30, 50};
        double[] b = {100, -30, 50};
        double[] c = {100, 50, 40};
        double[] e = {-100, 30, 50};
        double[] f = {100, 30, -50};
        t.set_corners(a);
        assertTrue(t.Verify_corners());
        t.set_corners(b);
        assertFalse(t.Verify_corners());
        t.set_corners(c);
        assertFalse(t.Verify_corners());
        t.set_corners(e);
        assertFalse(t.Verify_corners());
        t.set_corners(f);
        assertFalse(t.Verify_corners());

    }

    @Test
    public void determine() {
        Triangle t = new Triangle();
        double[] a = {3, 3, 3};
        double[] b = {3, 3, 4};
        double[] c = {2, 5, 6};
        double[] d = {3, 4, 5};
        double[] e = {2, 5, 5};
        double[] f = {5, 5, 2};
        double[] g = {5, 2, 5};
        double[] h = {3, 5, 4};
        double[] i = {5, 4, 3};
        //String[] ss = {"The triangle is Equilateral.\r\n", "The triangle is Isosceles.\r\n", "The triangle is Scalene.\r\n", "The triangle is Scalene and Right.\r\n","The triangle is Isosceles.\r\n"};
        List<double[]> testlist = new ArrayList<double[]>();
        testlist.add(a);
        testlist.add(b);
        testlist.add(c);
        testlist.add(d);
        testlist.add(e);
        testlist.add(f);
        testlist.add(g);
        testlist.add(h);
        testlist.add(i);
        int count=0;
        for (double[] test : testlist) {
            t.set_sides(test);
//            final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//            System.setOut(new PrintStream(outContent));
            t.determine();
            //assertEquals(ss[count], outContent.toString());
            count++;
        }
    }

    @Test
    public void getArea() {
        Triangle t = new Triangle();
        double[] sides = {3, 3, 3};
        double s = (sides[0] + sides[1] + sides[2]) / 2;
        double Area = Math.sqrt(s * (s - sides[0]) * (s - sides[1]) * (s - sides[2]));
        t.set_sides(sides);
        String result="The area is the triangle is: "+Area+"\r\n";
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        t.getArea();
        assertEquals(result,outContent.toString());

    }
}