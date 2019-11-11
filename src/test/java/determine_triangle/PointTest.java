package determine_triangle;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void setX() {
        Point p=new Point(1,2);
        p.setX(1);

    }

    @Test
    public void setY() {
        Point p=new Point(1,2);
        p.setY(1);
    }

    @Test
    public void getX() {
        Point p=new Point(1,2);
        p.getX();
    }

    @Test
    public void getY() {
        Point p=new Point(1,2);
        p.getY();
    }
}