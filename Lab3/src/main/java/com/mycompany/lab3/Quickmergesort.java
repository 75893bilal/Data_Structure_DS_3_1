/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3;

/**
 *
 * @author hp
 */
public class Quickmergesort{

    public static void main(String[] args) {

        // Initializing test arrays
        int[] arrayForMerge = {64, 25, 12, 22, 11, 90, 34};
        int[] arrayForQuick = {64, 25, 12, 22, 11, 90, 34};

        // ==================== MERGE SORT ====================

        System.out.println("=================================================");
        System.out.println("RUNNING MERGE SORT DEMO");
        System.out.println("=================================================");

        System.out.print("Initial State: ");
        printFullArray(arrayForMerge);

        System.out.println();

        mergeSort(arrayForMerge, 0, arrayForMerge.length - 1);

        System.out.print("\nFinal Sorted Array (Merge Sort): ");
        printFullArray(arrayForMerge);

        System.out.println();

        // ==================== QUICK SORT ====================

        System.out.println("\n=================================================");
        System.out.println("RUNNING QUICK SORT DEMO");
        System.out.println("=================================================");

        System.out.print("Initial State: ");
        printFullArray(arrayForQuick);

        System.out.println();

        quickSort(arrayForQuick, 0, arrayForQuick.length - 1);

        System.out.print("\nFinal Sorted Array (Quick Sort): ");
        printFullArray(arrayForQuick);

        System.out.println();
    }


    // ==================== MERGE SORT ====================

    public static void mergeSort(int[] arr, int left, int right) {

        // Base Case
        if (left < right) {

            int mid = left + (right - left) / 2;

            System.out.print("Splitting subarray: ");
            printSubarray(arr, left, right);
            System.out.println();

            // Recursive call for left half
            mergeSort(arr, left, mid);

            // Recursive call for right half
            mergeSort(arr, mid + 1, right);

            // Merge both halves
            merge(arr, left, mid, right);
        }
    }


    // ==================== MERGE METHOD ====================

    private static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy left half
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        // Copy right half
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        System.out.print(" Merging parts -> Left: ");
        printFullArray(L);

        System.out.print(" and Right: ");
        printFullArray(R);

        int i = 0;
        int j = 0;
        int k = left;

        // Compare elements
        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {

                arr[k] = L[i];
                i++;

            } else {

                arr[k] = R[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from L
        while (i < n1) {

            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements from R
        while (j < n2) {

            arr[k] = R[j];
            j++;
            k++;
        }

        System.out.print(" Result after merge phase: ");
        printSubarray(arr, left, right);
        System.out.println();
    }


    // ==================== QUICK SORT ====================

    public static void quickSort(int[] arr, int low, int high) {

        // Base Case
        if (low < high) {

            System.out.print("Processing index range: ");
            printSubarray(arr, low, high);
            System.out.println();

            // Partition array
            int pi = partition(arr, low, high);

            // Recursive call for left partition
            quickSort(arr, low, pi - 1);

            // Recursive call for right partition
            quickSort(arr, pi + 1, high);
        }
    }


    // ==================== PARTITION ====================

    private static int partition(int[] arr, int low, int high) {

        // Last element as pivot
        int pivot = arr[high];

        System.out.println(" Selected Pivot Value: [" + pivot + "]");

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {

                i++;

                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot with element at i + 1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        System.out.print(" Current Array State after Partition: ");
        printFullArray(arr);

        System.out.println();

        System.out.println(
            " Pivot element locked at index location: " + (i + 1)
        );

        return i + 1;
    }


    // ==================== PRINT FULL ARRAY ====================

    private static void printFullArray(int[] arr) {

        for (int val : arr) {
            System.out.print(val + " ");
        }

        System.out.println();
    }


    // ==================== PRINT SUBARRAY ====================

    private static void printSubarray(int[] arr, int left, int right) {

        for (int i = left; i <= right; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}