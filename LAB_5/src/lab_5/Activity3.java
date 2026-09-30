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
public class Activity3 {
    static Scanner input = new Scanner(System.in);
    // CIRCULAR QUEUE
    static int[] queue = new int[5];
    static int front = 0;
    static int rear = -1;
    static int size = 0;
    static void enqueue(int value) {
        if (size == 5) {
            System.out.println("Queue is full.");
            return;
        }
        rear = (rear + 1) % 5;
        queue[rear] = value;
        size++;
        System.out.println(value + " inserted.");
    }
    static void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println(
                queue[front] + " deleted.");
        front = (front + 1) % 5;
        size--;}
    static void displayQueue() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return; }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % 5;
            System.out.print(queue[index] + " ");
        } System.out.println();}
    // PRIORITY QUEUE
    static int[] values = new int[5];
    static int[] priorities = new int[5];

    static int pqSize = 0;


    static void insertPriority(int value, int priority) {

        if (pqSize == 5) {

            System.out.println("Priority Queue is full.");
            return;
        }

        values[pqSize] = value;
        priorities[pqSize] = priority;

        pqSize++;

        System.out.println("Element inserted.");
    }


    static void removePriority() {

        if (pqSize == 0) {

            System.out.println("Priority Queue is empty.");
            return;
        }

        int highest = 0;

        for (int i = 1; i < pqSize; i++) {

            if (priorities[i] < priorities[highest]) {
                highest = i;
            }
        }

        System.out.println(
                "Removed: " + values[highest]
                + " Priority: " + priorities[highest]
        );

        for (int i = highest; i < pqSize - 1; i++) {

            values[i] = values[i + 1];
            priorities[i] = priorities[i + 1];
        }

        pqSize--;
    }


    static void displayPriority() {

        if (pqSize == 0) {

            System.out.println(
                    "Priority Queue is empty."
            );

            return;
        }

        System.out.println("Value\tPriority");

        for (int i = 0; i < pqSize; i++) {

            System.out.println(
                    values[i] + "\t" + priorities[i]
            );
        }
    }


    // =========================
    // DEQUE
    // =========================

    static int[] deque = new int[5];

    static int dequeFront = -1;
    static int dequeRear = -1;


    static boolean dequeEmpty() {

        return dequeFront == -1;
    }


    static boolean dequeFull() {

        return (dequeFront == 0
                && dequeRear == 4)
                || dequeFront == dequeRear + 1;
    }


    static void insertFront(int value) {

        if (dequeFull()) {

            System.out.println("Deque is full.");
            return;
        }

        if (dequeEmpty()) {

            dequeFront = dequeRear = 0;
        }
        else if (dequeFront == 0) {

            dequeFront = 4;
        }
        else {

            dequeFront--;
        }

        deque[dequeFront] = value;

        System.out.println(value + " inserted at front.");
    }


    static void insertRear(int value) {

        if (dequeFull()) {

            System.out.println("Deque is full.");
            return;
        }

        if (dequeEmpty()) {

            dequeFront = dequeRear = 0;
        }
        else if (dequeRear == 4) {

            dequeRear = 0;
        }
        else {

            dequeRear++;
        }

        deque[dequeRear] = value;

        System.out.println(value + " inserted at rear.");
    }


    static void deleteFront() {

        if (dequeEmpty()) {

            System.out.println("Deque is empty.");
            return;
        }

        System.out.println(
                deque[dequeFront]
                + " deleted from front."
        );

        if (dequeFront == dequeRear) {

            dequeFront = dequeRear = -1;
        }
        else if (dequeFront == 4) {

            dequeFront = 0;
        }
        else {

            dequeFront++;
        }
    }


    static void deleteRear() {

        if (dequeEmpty()) {

            System.out.println("Deque is empty.");
            return;
        }

        System.out.println(
                deque[dequeRear]
                + " deleted from rear."
        );

        if (dequeFront == dequeRear) {

            dequeFront = dequeRear = -1;
        }
        else if (dequeRear == 0) {

            dequeRear = 4;
        }
        else {

            dequeRear--;
        }
    }


    static void displayDeque() {

        if (dequeEmpty()) {

            System.out.println("Deque is empty.");
            return;
        }

        System.out.print("Deque: ");

        int i = dequeFront;

        while (true) {

            System.out.print(deque[i] + " ");

            if (i == dequeRear) {
                break;
            }

            i = (i + 1) % 5;
        }

        System.out.println();
    }


    // =========================
    // INFIX TO POSTFIX
    // =========================

    static int precedence(char ch) {

        if (ch == '+' || ch == '-') {
            return 1;
        }

        if (ch == '*' || ch == '/' || ch == '%') {
            return 2;
        }

        return 0;
    }


    static boolean isOperator(char ch) {

        return ch == '+'
                || ch == '-'
                || ch == '*'
                || ch == '/'
                || ch == '%';
    }


    static String infixToPostfix(String expression) {

        Stack<Character> stack = new Stack<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (Character.isLetterOrDigit(ch)) {

                result.append(ch).append(" ");
            }

            else if (ch == '(') {

                stack.push(ch);
            }

            else if (ch == ')') {

                while (!stack.isEmpty()
                        && stack.peek() != '(') {

                    result.append(stack.pop()).append(" ");
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            else if (isOperator(ch)) {

                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek())
                           >= precedence(ch)) {

                    result.append(stack.pop()).append(" ");
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {

            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }


    // =========================
    // MAIN MENU
    // =========================

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println();
            System.out.println(
                    "========== DATA STRUCTURES LAB 5 =========="
            );

            System.out.println("1. Circular Queue");
            System.out.println("2. Priority Queue");
            System.out.println("3. Deque");
            System.out.println("4. Infix to Postfix");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.println(
                            "\n--- Circular Queue ---"
                    );

                    enqueue(10);
                    enqueue(20);
                    enqueue(30);

                    displayQueue();

                    dequeue();

                    displayQueue();

                    break;


                case 2:

                    System.out.println(
                            "\n--- Priority Queue ---"
                    );

                    insertPriority(10, 3);
                    insertPriority(20, 1);
                    insertPriority(30, 2);
                    insertPriority(40, 1);

                    displayPriority();

                    removePriority();

                    displayPriority();

                    break;


                case 3:

                    System.out.println(
                            "\n--- Deque ---"
                    );

                    insertRear(10);
                    insertRear(20);
                    insertFront(5);

                    displayDeque();

                    deleteFront();
                    deleteRear();

                    displayDeque();

                    break;


                case 4:

                    input.nextLine();

                    System.out.print(
                            "Enter Infix Expression: "
                    );
                    String expression =
                            input.nextLine();
                    String postfix =
                            infixToPostfix(expression);
                    System.out.println(
                            "Infix Expression: "
                            + expression
                    );
                    System.out.println(
                            "Postfix Expression: "
                            + postfix
                    );
                    break;
                case 5:

                    System.out.println(
                            "Program terminated."
                    );
                    break;
                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        } while (choice != 5);
        input.close();
    }
}