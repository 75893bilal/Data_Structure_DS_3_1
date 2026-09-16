/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labtask2;

/**
 *
 * @author hp
 */
import java.util.Arrays;

public class bouns {
    static class Node {
        int marks;
        Node next;

        Node(int marks) {
            this.marks = marks;
            this.next = null;
        }
    }

    public static void displayList(Node head) {

        Node current = head;

        while (current != null) {

            System.out.print(current.marks + " -> ");

            current = current.next;
        }

        System.out.println("null");
    }

    public static Node insert(Node head, int marks) {

        Node newNode = new Node(marks);

        if (head == null) {
            return newNode;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        return head;
    }

    public static Node delete(Node head, int marks) {

        if (head == null) {
            return null;
        }

        if (head.marks == marks) {
            return head.next;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.marks == marks) {
                current.next = current.next.next;
                break;
            }

            current = current.next;
        }

        return head;
    }

    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];

                    arr[j] = arr[j + 1];

                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] marks = {78, 65, 89, 55, 92};

        System.out.println("Original Marks:");
        System.out.println(Arrays.toString(marks));

        int max = marks[0];
        int min = marks[0];
        int sum = 0;

        for (int mark : marks) {

            sum += mark;

            if (mark > max) {
                max = mark;
            }

            if (mark < min) {
                min = mark;
            }
        }

        double average = (double) sum / marks.length;

        System.out.println("\nMaximum = " + max);
        System.out.println("Minimum = " + min);
        System.out.println("Average = " + average);

        bubbleSort(marks);

        System.out.println("\nSorted Marks:");
        System.out.println(Arrays.toString(marks));

        Node head = null;

        for (int mark : marks) {
            head = insert(head, mark);
        }
        System.out.println("\nMarks in Linked List:");
        displayList(head);

        head = insert(head, 70);

        System.out.println("\nAfter Inserting 70:");
        displayList(head);

        head = delete(head, 65);

        System.out.println("\nAfter Deleting 65:");
        displayList(head);

        System.out.println("\nFinal Linked List:");
        displayList(head);

        System.out.println("\nFinal Array:");
        System.out.println(Arrays.toString(marks));
    }
}
