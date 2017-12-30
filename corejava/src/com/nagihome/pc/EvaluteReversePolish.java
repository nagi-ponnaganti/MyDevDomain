package com.nagihome.pc;

import java.util.Stack;

public class EvaluteReversePolish {

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println("Evaluate: " + evaluate(tokens));
    }

    private static String evaluate(String[] tokens) {

        String operators = "+-*/";

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {

            String token = tokens[i];

            if (!operators.contains(token)) {
                stack.push(token);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (token) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(a - b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(a / b));
                        break;
                }
            }
        }

        return stack.pop();
    }
}
