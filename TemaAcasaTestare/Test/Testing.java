import daniel.com.Calculator;
import org.junit.*;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Testing {
    private Calculator calculator;


    @Before
    public void setup() {
        calculator = new Calculator();

    }

    @Test
    public void testingWithOnlyPlusOperators() {
        String expr = "100 m + 300 m + 500 m";
        String[] parts = expr.split(" ");
        int actualValue = calculator.evaluateExpression(parts);
        assertEquals("Failed the Test", 900000, actualValue);

    }

    @Test
    public void testingWithOnlyMinusOperators() {
        String expr = "900 m - 300 m - 200 m";
        String[] parts = expr.split(" ");
        int actualValue = calculator.evaluateExpression(parts);
        assertEquals("Failed the Test", 400000, actualValue);

    }

    @Test
    public void testingWithBothOperators() {
        String expr = "900 m - 300 m + 200 m";
        String[] parts = expr.split(" ");
        int actualValue = calculator.evaluateExpression(parts);
        assertEquals("Failed the Test", 800000, actualValue);

    }

    @Test
    public void testingWithMultipleUnits() {
        String expr = "900 km - 300 dm + 200 mm";
        String[] parts = expr.split(" ");
        int actualValue = calculator.evaluateExpression(parts);
        assertEquals("Failed the Test", 899970200, actualValue);

    }

    @Test
    public void duration() {
        List<Duration> statistics = new ArrayList<>();
        Instant start1 = Instant.now();
        testingWithMultipleUnits();
        Instant stop1 = Instant.now();
        Duration duration1 = Duration.between(start1, stop1);
        System.out.println("Duration of first test: " + duration1);
        statistics.add(duration1);
        for (Duration dur : statistics) {
            System.out.println(dur);
        }

    }

    @Test
    public void duration2() {
        List<Duration> statistics = new ArrayList<>();
        Instant start2 = Instant.now();
        testingWithBothOperators();
        Instant stop2 = Instant.now();
        Duration duration2 = Duration.between(start2, stop2);
        System.out.println("Duration of second test: " + duration2);
        statistics.add(duration2);
        for (Duration dur : statistics) {

            System.out.println("The Duration is: " + dur);
        }
    }


    @Test
    public void duration3() throws InterruptedException {
        double start = System.currentTimeMillis();
        List<Duration> statistics = new ArrayList<>();
        testingWithOnlyMinusOperators();
        for (Duration dur : statistics) {
            System.out.println(dur);
        }
        double stop = System.currentTimeMillis();
        System.out.println(stop);
    }

    @Test
    public void duration4() {
        List<Duration> statistics = new ArrayList<>();
        Instant start4 = Instant.now();
        testingWithOnlyPlusOperators();
        Instant stop4 = Instant.now();
        Duration duration4 = Duration.between(start4, stop4);
        System.out.println("Duration of fourth test: " + duration4);

        for (Duration dur : statistics) {
            statistics.add(dur);
            System.out.println(dur);
        }

    }
}
