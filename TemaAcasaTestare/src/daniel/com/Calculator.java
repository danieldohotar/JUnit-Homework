package daniel.com;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    List<Integer> valuesList = new ArrayList<>();
    List<String> units = new ArrayList<>();
    List<Character> operators = new ArrayList<>();
    List<Integer> values = new ArrayList<>();

    Convertor convertor = new Convertor();


    private void splitTheInput(String[] parts) {

        for (int i = 0; i < parts.length; i++) {

            if (parts[i].equals("mm") || parts[i].equals("cm") || parts[i].equals("dm") || parts[i].equals("m") || parts[i].equals("km")) {
                units.add(parts[i]);
            }
            if (parts[i].equals("-") || parts[i].equals("+")) {
                String inter = parts[i];
                char oper = inter.charAt(0);
                operators.add(oper);
            }

            if (parts[i].matches("^[0-9]*$")) {
                String inter = parts[i];
                int oper = Integer.parseInt(inter);
                valuesList.add(oper);
            }
        }
    }

    private int calculateBasedOperator(char operator, int firstValue, int secondValue) {
        int value;
        if (operator == '+') {
            value = firstValue + secondValue;
            return value;
        } else if (operator == '-') {
            value = firstValue - secondValue;
            return value;
        } else {
            return 0;
        }
    }

    private int calculateB() {

        int sum = calculateBasedOperator(operators.get(0), values.get(0), values.get(1));
        if (sum < 0) {

        }
        for (int i = 2; i < values.size(); i++) {
            int p = calculateBasedOperator(operators.get(i - 1), sum, values.get(i));
            int n1 = p;
            sum = n1;
        }
        return sum;
    }

    private void calc() {
        for (int i = 0; i < valuesList.size(); i++) {
            this.values.add(convertor.convertToSpecificUnit(valuesList.get(i), units.get(i)));
        }
    }

    public int evaluateExpression(String[] parts) {
        splitTheInput(parts);
        calc();
        return calculateB();
    }
}


