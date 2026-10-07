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
public class PostfixToPrefix {
    public static String postfixToPrefix(String expression) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (Character.isLetterOrDigit(symbol)) {
                stack.push(String.valueOf(symbol));
            }
            else if (symbol == '+' || symbol == '-' ||
                     symbol == '*' || symbol == '/') {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String result = symbol + operand2 + operand1;
                stack.push(result);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Postfix Expression: ");
        String expression = input.nextLine();
        String prefix = postfixToPrefix(expression);
        System.out.println("Prefix Expression: " + prefix);
        input.close();
    }
}