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
public class BonusTask {
    static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            // If token is a number
            if (token.matches("\\d+")) {
                int number = Integer.parseInt(token);
                stack.push(number);
            }
            // If token is an operator
            else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    default:
                        System.out.println(
                                "Invalid operator."
                        );
                }
            }
        }
        return stack.pop();
    }
   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print(
                "Enter Postfix Expression: "
        );
        String expression = input.nextLine();
        int result = evaluatePostfix(expression);
        System.out.println(
                "Result: " + result
        );
        input.close();
    }
}