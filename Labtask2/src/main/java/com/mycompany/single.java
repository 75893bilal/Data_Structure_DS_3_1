/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labtask2;

/**
 *
 * @author hp
 */
public class single{
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void delete(int value) {
        if (head == null) {
            return;
        }
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    public static void main(String[] args) {
        single list = new single();
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = new Node(40);
        list.head.next.next.next.next = new Node(50);                                     
        System.out.println("Initial Linked List:");
        list.display();
        list.insertAtBeginning(5);
        System.out.println("\nAfter Insertion at Beginning:");
        list.display();
        list.insertAtEnd(60);
        System.out.println("\nAfter Insertion at End:");
        list.display();
        int searchValue = 30;
        if (list.search(searchValue)) {
            System.out.println("\n" + searchValue + " found in the list.");
        } else {
            System.out.println("\n" + searchValue + " not found.");
        }
        list.delete(30);
        System.out.println("\nAfter Deleting 30:");
        list.display();
        System.out.println("\nFinal Linked List:");
        list.display();
    }
}