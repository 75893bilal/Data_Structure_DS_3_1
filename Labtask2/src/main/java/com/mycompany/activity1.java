/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.labtask2;

/**
 *
 * @author hp
 */
public class activity1 {
    public static void main(String[] args) {
        int[] arr = {45, 12, 78, 23, 9, 56, 34, 89, 17, 63};
        System.out.println("Array Elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int sum = 0;
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        double average = (double) sum / arr.length;
        System.out.println("\n\nSum = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
        int index = 3;
        int value = 100;
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        newArr[index] = value;
        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        System.out.println("\nAfter Insertion:");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
        int deleteIndex = 3;
        int[] deletedArr = new int[newArr.length - 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == deleteIndex) {
                continue;
            }
            deletedArr[j] = newArr[i];
            j++;
        }

        System.out.println("\n\nAfter Deletion:");
        for (int i = 0; i < deletedArr.length; i++) {
            System.out.print(deletedArr[i] + " ");
        }
    }
}