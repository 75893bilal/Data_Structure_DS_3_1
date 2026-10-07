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
public class PrefixToInfix {
    public static String prefixToInfix(String expression) {
        Stack<String> stack = new Stack<>();
        // Read expression from right to left
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            // If operand, push into stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            // If operator
            else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String result = "(" + operand1 + " " + ch + " " + operand2 + ")";
                stack.push(result);
            }
        }
        // Final stack element is the Infix expression
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Prefix Expression: ");
        String expression = input.nextLine();
        String infix = prefixToInfix(expression);
        System.out.println("Infix Expression: " + infix);
        input.close();
    }
}