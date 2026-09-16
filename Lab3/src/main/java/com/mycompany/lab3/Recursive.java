/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3;

/**
 *
 * @author hp
 */
public class Recursive {

    public static void printArray(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        System.out.print(arr[index] + " ");
        printArray(arr, index + 1);
    }
    public static int calculateSum(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + calculateSum(arr, index + 1);
    }
    public static int search(int[] arr, int index, int target) {

        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return search(arr, index + 1, target);
    }
    public static void main(String[] args) {
        int[] arr = {12, 45, 7, 23, 56, 89, 34};
        System.out.print("Array Elements: ");
        printArray(arr, 0);
        int sum = calculateSum(arr, 0);
        System.out.println("\nSum = " + sum);
        int target = 23;
        int index = search(arr, 0, target);
        if (index != -1) {
            System.out.println(target + " found at index: " + index);
        } else {
            System.out.println(target + " not found.");
        }
    }
}