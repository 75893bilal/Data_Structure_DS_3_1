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

public class Sorting {
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
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
               if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
           while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] original = {64, 25, 12, 22, 11, 90, 34};

        int[] bubble = original.clone();
        System.out.println("Original Array: "
                + Arrays.toString(original));
        bubbleSort(bubble);
        System.out.println("Bubble Sort: "
                + Arrays.toString(bubble));
        int[] selection = original.clone();
        selectionSort(selection);
        System.out.println("Selection Sort: "
                + Arrays.toString(selection));
        int[] insertion = original.clone();
        insertionSort(insertion);
        System.out.println("Insertion Sort: "
                + Arrays.toString(insertion));
    }
}
