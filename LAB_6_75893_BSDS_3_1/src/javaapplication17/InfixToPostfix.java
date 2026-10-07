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
public class InfixToPostfix {
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
    public static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        String postfix = "";
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
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
            // If character is an operator
            else {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(ch)) {

                    postfix = postfix + stack.pop();
                }
                stack.push(ch);
            }
        }
        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix = postfix + stack.pop();
        }
        return postfix;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Infix Expression: ");
        String expression = input.nextLine();
        String postfix = infixToPostfix(expression);
        System.out.println("Postfix Expression: " + postfix);
        input.close();
    }
}