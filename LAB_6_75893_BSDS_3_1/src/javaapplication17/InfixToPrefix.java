/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication17;

/**
 *
 * @author hp
 */
import java.util.Stack;
import java.util.Scanner;

public class InfixToPrefix {

    // Check operator precedence
    public static int precedence(char ch) {

        if (ch == '+' || ch == '-') {
            return 1;
        }

        if (ch == '*' || ch == '/') {
            return 2;
        }

        if (ch == '^') {
            return 3;
        }

        return 0;
    }

    // Infix to Prefix conversion
    public static String infixToPrefix(String expression) {

        Stack<Character> stack = new Stack<>();

        // Step 1: Reverse the expression
        String reversed = "";

        for (int i = expression.length() - 1; i >= 0; i--) {

            char ch = expression.charAt(i);

            if (ch == '(') {
                reversed = reversed + ')';
            }
            else if (ch == ')') {
                reversed = reversed + '(';
            }
            else {
                reversed = reversed + ch;
            }
        }

        // Step 2: Convert reversed expression into postfix
        String postfix = "";

        for (int i = 0; i < reversed.length(); i++) {

            char ch = reversed.charAt(i);

            // If operand
            if (Character.isLetterOrDigit(ch)) {
                postfix = postfix + ch;
            }

            // If opening parenthesis
            else if (ch == '(') {
                stack.push(ch);
            }

            // If closing parenthesis
            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix = postfix + stack.pop();
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // If operator
            else {

                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek()) > precedence(ch)) {
                    postfix = postfix + stack.pop();
                }
                stack.push(ch);
            }
        }
        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix = postfix + stack.pop();
        }
        // Step 3: Reverse postfix to get prefix
        String prefix = "";
        for (int i = postfix.length() - 1; i >= 0; i--) {
            prefix = prefix + postfix.charAt(i);
        }
        return prefix;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Infix Expression: ");
        String expression = input.nextLine();
        String prefix = infixToPrefix(expression);
        System.out.println("Prefix Expression: " + prefix);
        input.close();
    }
}