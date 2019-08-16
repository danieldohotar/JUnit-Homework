import daniel.com.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedTest {
    private Calculator calculator;
    private int expectedResult;
    private String expression;

    public ParametrizedTest(int expectedResult, String expression) {
        this.expectedResult = expectedResult;
        this.expression = expression;
    }

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> calculations() {

        Object[][] calc = new Object[][]{
                {90000, "50 m + 40 m"},
                {15015000, "15 m + 15 km"},
                {27500, "25 dm + 25 m"},
                {30300, "30 m + 30 cm"}};
        return Arrays.asList(calc);
    }

    @Test
    public void testingWithOnlyPlusOperators() {

        String expr = expression;
        String[] parts = expr.split(" ");
        int actualValue = calculator.evaluateExpression(parts);
        assertEquals("Failed the Test", expectedResult, actualValue);


    }
}
