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
public class PostfixToInfix {
    public static String postfixToInfix(String expression) {
       Stack<String> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            // If symbol is an operand
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            // If symbol is an operator
            else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result = "(" + operand1 + " " + ch + " " + operand2 + ")";
                stack.push(result);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Postfix Expression: ");
        String expression = input.nextLine();
        String infix = postfixToInfix(expression);
        System.out.println("Infix Expression: " + infix);
        
        input.close();
    }
}