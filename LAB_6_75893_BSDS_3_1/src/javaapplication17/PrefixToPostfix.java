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
public class PrefixToPostfix {
    public static String prefixToPostfix(String expression) {
        Stack<String> stack = new Stack<>();
        // Read Prefix expression from right to left
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            // If symbol is an operand
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            else {
                // Pop first operand
                String operand1 = stack.pop();
                // Pop second operand
                String operand2 = stack.pop();
                // Combine operands with operator
                String result = operand1 + operand2 + ch;
                // Push result back
                stack.push(result);
            }
        }
        // Final element is Postfix expression
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Prefix Expression: ");
        String expression = input.nextLine();
        String postfix = prefixToPostfix(expression);
        System.out.println("Postfix Expression: " + postfix);
        input.close();
    }
}