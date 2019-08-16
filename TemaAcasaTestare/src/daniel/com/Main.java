package daniel.com;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner s = new Scanner(System.in);

        System.out.println("Please write an expession: ");
        String expr = s.nextLine();
        String[] parts = expr.split(" ");

        System.out.println(calculator.evaluateExpression(parts) + " mm");
    }
}

