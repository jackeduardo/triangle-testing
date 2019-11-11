package determine_triangle;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.rules.ExpectedException;
import org.junit.runner.JUnitCore;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main() {
        Main M = new Main();
        String inputMessage = "3\r\n"
                + "3\r\n"
                + "3\r\n"
                + "30\r\n"
                + "50\r\n"
                + "100\r\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputMessage.getBytes());
        System.setIn(in);
        Main.main(null);

    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void verify() {
        Triangle t = new Triangle();
        String inputMessage1 = "3\r\n"
                + "3\r\n"
                + "3\r\n"
                + "30\r\n"
                + "50\r\n"
                + "100\r\n";
        String inputMessage2="a\r\n"
                + "b\r\n"
                + "c\r\n"
                + "30\r\n"
                + "50\r\n"
                + "100\r\n";
        String inputMessage3 = "-1\r\n"
                + "3\r\n"
                + "5\r\n"
                + "30\r\n"
                + "50\r\n"
                + "100\r\n";
        String inputMessage4 = "3\r\n"
                + "3\r\n"
                + "3\r\n"
                + "-30\r\n"
                + "50\r\n"
                + "100\r\n";
        String inputMessage5 = "-3\r\n"
                + "3\r\n"
                + "3\r\n"
                + "-30\r\n"
                + "50\r\n"
                + "100\r\n";
        ByteArrayInputStream in1= new ByteArrayInputStream(inputMessage1.getBytes());
        System.setIn(in1);
        Main.Verify(t);

        ByteArrayInputStream in3 = new ByteArrayInputStream(inputMessage3.getBytes());
        System.setIn(in3);
        Main.Verify(t);

        ByteArrayInputStream in4 = new ByteArrayInputStream(inputMessage4.getBytes());
        System.setIn(in4);
        Main.Verify(t);

        ByteArrayInputStream in5 = new ByteArrayInputStream(inputMessage5.getBytes());
        System.setIn(in5);
        Main.Verify(t);

        ByteArrayInputStream in2 = new ByteArrayInputStream(inputMessage2.getBytes());
        System.setIn(in2);
        exceptionRule.expect(InputMismatchException.class);
        Main.Verify(t);
    }
}