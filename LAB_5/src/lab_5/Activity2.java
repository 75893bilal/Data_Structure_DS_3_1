/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_5;

/**
 *
 * @author hp
 */
import java.util.Scanner;
import java.util.Stack;
public class Activity2 {
    // Find operator precedence
    static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }
        if (operator == '*' ||
            operator == '/' ||
            operator == '%') {
            return 2;
        }
        return 0;
    }
    // Check whether character is an operator
    static boolean isOperator(char ch) {
        return ch == '+' ||
               ch == '-' ||
               ch == '*' ||
               ch == '/' ||
               ch == '%';
    }
    // Convert Infix to Postfix
    static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            // Ignore spaces
            if (ch == ' ') {
                continue;
            }
            // Operand
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
                postfix.append(' ');
            }
            // Opening parenthesis
            else if (ch == '(') {
                stack.push(ch);
            }
            // Closing parenthesis
            else if (ch == ')') {
                while (!stack.isEmpty()
                        && stack.peek() != '(') {
                    postfix.append(stack.pop());
                    postfix.append(' ');
                }
                if (!stack.isEmpty()
                        && stack.peek() == '(') {
                    stack.pop();
                }
            }
            // Operator
            else if (isOperator(ch)) {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek())
                           >= precedence(ch)) {
                    postfix.append(stack.pop());
                    postfix.append(' ');
                }
                stack.push(ch);
            }
        }
        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
            postfix.append(' ');
        }
        return postfix.toString().trim();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Infix Expression: ");
        String expression = input.nextLine();
        String postfix = infixToPostfix(expression);
        System.out.println(
                "Infix Expression: " + expression
        );
        System.out.println(
                "Postfix Expression: " + postfix
        );
        input.close();
    }
}
