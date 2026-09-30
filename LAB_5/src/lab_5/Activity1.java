/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_5;

/**
 *
 * @author hp
 */
public class Activity1{
    // PART A - CIRCULAR QUEUE
    static class CircularQueue {
        int[] queue = new int[5];
        int front = 0;
        int rear = -1;
        int size = 0;
        void enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue Overflow!");
                return;
            }
            rear = (rear + 1) % queue.length;
            queue[rear] = value;
            size++;
            System.out.println(value + " inserted.");
        }
        void dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Underflow!");
                return;
            }
            System.out.println(queue[front] + " deleted.");
            front = (front + 1) % queue.length;
            size--;
        }
        void peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
            } else {
                System.out.println("Front element: " + queue[front]);
            }
        }
        void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }
            System.out.print("Circular Queue: ");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % queue.length;
                System.out.print(queue[index] + " ");
            }
            System.out.println();
        }
        boolean isEmpty() {
            return size == 0;
        }
        boolean isFull() {
            return size == queue.length;
        }
    }
    // PART B - PRIORITY QUEUE
    static class PriorityQueue {
        int[] values = new int[5];
        int[] priorities = new int[5];
        int size = 0;
        void insert(int value, int priority) {
            if (size == 5) {
                System.out.println("Priority Queue is full.");
                return;
            }
            values[size] = value;
            priorities[size] = priority;
            size++;
            System.out.println(
                    value + " inserted with priority " + priority
            );
        }
        void remove() {
            if (size == 0) {
                System.out.println("Priority Queue is empty.");
                return;
            }
            int highest = 0;
            for (int i = 1; i < size; i++) {
                if (priorities[i] < priorities[highest]) {
                    highest = i;
                }
            }
            System.out.println(
                    "Removed: " + values[highest]
                    + " Priority: " + priorities[highest]
            );
            for (int i = highest; i < size - 1; i++) {
                values[i] = values[i + 1];
                priorities[i] = priorities[i + 1];
            }
            size--;
        }
        void display() {
            if (size == 0) {
                System.out.println("Priority Queue is empty.");
                return;
            }
            System.out.println("Value\tPriority");
            for (int i = 0; i < size; i++) {
                System.out.println(
                        values[i] + "\t" + priorities[i]
                );
            }
        }
    }
    // PART C - DEQUE
    static class Deque {
        int[] deque = new int[5];
        int front = -1;
        int rear = -1;
        boolean isEmpty() {
            return front == -1;
        }
        boolean isFull() {
            return (front == 0 && rear == deque.length - 1)
                    || front == rear + 1;
        }
        void insertFront(int value) {
            if (isFull()) {
                System.out.println("Deque is full.");
                return;
            }
            if (isEmpty()) {
                front = rear = 0;
            }
            else if (front == 0) {
                front = deque.length - 1;
            }
            else {
                front--;
            }
            deque[front] = value;
            System.out.println(
                    value + " inserted at front."
            );
        }
        void insertRear(int value) {
            if (isFull()) {
                System.out.println("Deque is full.");
                return;
            }
            if (isEmpty()) {
                front = rear = 0;
            }
            else if (rear == deque.length - 1) {
                rear = 0;
            }
            else {
                rear++;
            }

            deque[rear] = value;

            System.out.println(
                    value + " inserted at rear."
            );
        }
        void deleteFront() {

            if (isEmpty()) {
                System.out.println("Deque is empty.");
                return;
            }

            System.out.println(
                    deque[front] + " deleted from front."
            );

            if (front == rear) {
                front = rear = -1;
            }
            else if (front == deque.length - 1) {
                front = 0;
            }
            else {
                front++;
            }
        }

        void deleteRear() {

            if (isEmpty()) {
                System.out.println("Deque is empty.");
                return;
            }

            System.out.println(
                    deque[rear] + " deleted from rear."
            );

            if (front == rear) {
                front = rear = -1;
            }
            else if (rear == 0) {
                rear = deque.length - 1;
            }
            else {
                rear--;
            }
        }
        void display() {

            if (isEmpty()) {
                System.out.println("Deque is empty.");
                return;
            }
            System.out.print("Deque: ");
            int i = front;
            while (true) {
                System.out.print(deque[i] + " ");
                if (i == rear) {
                    break;
                }
                i = (i + 1) % deque.length;
            }
            System.out.println();
        }
    }
// =========================
    // MAIN
    // =========================

    public static void main(String[] args) {
        // Circular Queue
        System.out.println("===== CIRCULAR QUEUE =====");
        CircularQueue cq = new CircularQueue();
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.dequeue();
        cq.dequeue();
        cq.enqueue(50);
        cq.enqueue(60);
        cq.display();
        cq.peek();
        // Priority Queue
        System.out.println("\n===== PRIORITY QUEUE =====");
        PriorityQueue pq = new PriorityQueue();
        pq.insert(10, 3);
        pq.insert(20, 1);
        pq.insert(30, 2);
        pq.insert(40, 1);
        pq.display();
        pq.remove();
        pq.display();
        // Deque
        System.out.println("\n===== DEQUE =====");
        Deque dq = new Deque();
        dq.insertRear(10);
        dq.insertRear(20);
        dq.insertFront(5);
        dq.display();
        dq.deleteFront();
        dq.deleteRear();
        dq.display();
    }
}