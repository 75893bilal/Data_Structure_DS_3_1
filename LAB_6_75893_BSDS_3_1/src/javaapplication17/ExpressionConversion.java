/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication17;

/**
 *
 * @author hp
 */
import java.util.Scanner;
import java.util.Stack;

public class ExpressionConversion {

    // Check whether a character is an operator
    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Return operator precedence
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default:
                return -1;
        }
    }

    // =========================================================
    // 1. INFIX TO POSTFIX
    // =========================================================
    static String infixToPostfix(String expression) {

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // Ignore spaces
            if (ch == ' ') {
                continue;
            }

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch).append(" ");
            }

            // Opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }

                if (stack.isEmpty()) {
                    throw new IllegalArgumentException(
                            "Invalid expression: mismatched brackets."
                    );
                }

                stack.pop();
            }

            // Operator
            else if (isOperator(ch)) {

                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(ch)) {

                    result.append(stack.pop()).append(" ");
                }

                stack.push(ch);
            }

            else {
                throw new IllegalArgumentException(
                        "Invalid character found: " + ch
                );
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {

            if (stack.peek() == '(') {
                throw new IllegalArgumentException(
                        "Invalid expression: mismatched brackets."
                );
            }

            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    // =========================================================
    // 2. POSTFIX TO INFIX
    // =========================================================
    static String postfixToInfix(String expression) {

        Stack<String> stack = new Stack<>();

        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {

            // Operand
            if (token.length() == 1 &&
                    Character.isLetterOrDigit(token.charAt(0))) {

                stack.push(token);
            }

            // Operator
            else if (token.length() == 1 &&
                    isOperator(token.charAt(0))) {

                if (stack.size() < 2) {
                    throw new IllegalArgumentException(
                            "Invalid postfix expression."
                    );
                }

                String operand2 = stack.pop();
                String operand1 = stack.pop();

                String result = "(" + operand1
                        + " " + token + " "
                        + operand2 + ")";

                stack.push(result);
            }

            else {
                throw new IllegalArgumentException(
                        "Invalid token: " + token
                );
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException(
                    "Invalid postfix expression."
            );
        }

        return stack.pop();
    }

    // =========================================================
    // 3. INFIX TO PREFIX
    // =========================================================
    static String infixToPrefix(String expression) {

        // Reverse expression
        StringBuilder reversed = new StringBuilder(expression)
                .reverse();

        // Swap brackets
        for (int i = 0; i < reversed.length(); i++) {

            if (reversed.charAt(i) == '(') {
                reversed.setCharAt(i, ')');
            }

            else if (reversed.charAt(i) == ')') {
                reversed.setCharAt(i, '(');
            }
        }

        // Convert reversed expression to postfix
        String postfix = infixToPostfix(reversed.toString());

        // Reverse postfix to get prefix
        String[] tokens = postfix.split("\\s+");

        StringBuilder prefix = new StringBuilder();

        for (int i = tokens.length - 1; i >= 0; i--) {
            prefix.append(tokens[i]).append(" ");
        }

        return prefix.toString().trim();
    }

    // =========================================================
    // 4. PREFIX TO POSTFIX
    // =========================================================
    static String prefixToPostfix(String expression) {

        Stack<String> stack = new Stack<>();

        String[] tokens = expression.trim().split("\\s+");

        // Read from right to left
        for (int i = tokens.length - 1; i >= 0; i--) {

            String token = tokens[i];

            // Operand
            if (token.length() == 1 &&
                    Character.isLetterOrDigit(token.charAt(0))) {

                stack.push(token);
            }

            // Operator
            else if (token.length() == 1 &&
                    isOperator(token.charAt(0))) {

                if (stack.size() < 2) {
                    throw new IllegalArgumentException(
                            "Invalid prefix expression."
                    );
                }

                String operand1 = stack.pop();
                String operand2 = stack.pop();

                String result = operand1 + " "
                        + operand2 + " "
                        + token;

                stack.push(result);
            }

            else {
                throw new IllegalArgumentException(
                        "Invalid token: " + token
                );
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException(
                    "Invalid prefix expression."
            );
        }

        return stack.pop();
    }

    // =========================================================
    // 5. POSTFIX TO PREFIX
    // =========================================================
    static String postfixToPrefix(String expression) {

        Stack<String> stack = new Stack<>();

        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {

            // Operand
            if (token.length() == 1 &&
                    Character.isLetterOrDigit(token.charAt(0))) {

                stack.push(token);
            }

            // Operator
            else if (token.length() == 1 &&
                    isOperator(token.charAt(0))) {

                if (stack.size() < 2) {
                    throw new IllegalArgumentException(
                            "Invalid postfix expression."
                    );
                }

                String operand2 = stack.pop();
                String operand1 = stack.pop();

                String result = token + " "
                        + operand1 + " "
                        + operand2;

                stack.push(result);
            }

            else {
                throw new IllegalArgumentException(
                        "Invalid token: " + token
                );
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException(
                    "Invalid postfix expression."
            );
        }

        return stack.pop();
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            try {

                System.out.println();
                System.out.println("========== EXPRESSION CONVERSION ==========");
                System.out.println("1. Infix to Postfix");
                System.out.println("2. Postfix to Infix");
                System.out.println("3. Infix to Prefix");
                System.out.println("4. Prefix to Postfix");
                System.out.println("5. Postfix to Prefix");
                System.out.println("6. Exit");
                System.out.println("===========================================");

                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(input.nextLine());

                if (choice == 6) {
                    System.out.println("Program ended.");
                    break;
                }

                if (choice < 1 || choice > 6) {
                    throw new IllegalArgumentException(
                            "Invalid choice. Please select 1 to 6."
                    );
                }

                System.out.print("Enter expression: ");
                String expression = input.nextLine().trim();

                if (expression.isEmpty()) {
                    throw new IllegalArgumentException(
                            "Expression cannot be empty."
                    );
                }

                String result;

                switch (choice) {

                    case 1:
                        result = infixToPostfix(expression);

                        System.out.println("\nInfix Expression:");
                        System.out.println(expression);

                        System.out.println("Postfix Expression:");
                        System.out.println(result);
                        break;

                    case 2:
                        result = postfixToInfix(expression);

                        System.out.println("\nPostfix Expression:");
                        System.out.println(expression);

                        System.out.println("Infix Expression:");
                        System.out.println(result);
                        break;

                    case 3:
                        result = infixToPrefix(expression);

                        System.out.println("\nInfix Expression:");
                        System.out.println(expression);

                        System.out.println("Prefix Expression:");
                        System.out.println(result);
                        break;

                    case 4:
                        result = prefixToPostfix(expression);

                        System.out.println("\nPrefix Expression:");
                        System.out.println(expression);

                        System.out.println("Postfix Expression:");
                        System.out.println(result);
                        break;

                    case 5:
                        result = postfixToPrefix(expression);

                        System.out.println("\nPostfix Expression:");
                        System.out.println(expression);

                        System.out.println("Prefix Expression:");
                        System.out.println(result);
                        break;
                }

            }

            // Handle invalid number input and conversion errors
            catch (NumberFormatException e) {

                System.out.println(
                        "Error: Please enter a valid numeric choice."
                );

            }

            // Handle invalid expressions
            catch (IllegalArgumentException e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );

            }

            // Handle any unexpected error
            catch (Exception e) {

                System.out.println(
                        "Unexpected error: " + e.getMessage()
                );
            }
        }

        input.close();
    }
}