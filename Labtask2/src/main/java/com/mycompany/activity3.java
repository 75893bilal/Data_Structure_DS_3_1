/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labtask2;

/**
 *
 * @author hp
 */
import java.util.Scanner;

public class activity3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of layers: ");
        int layers = input.nextInt();

        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        int[][][] arr = new int[layers][rows][columns];

        
        System.out.println("\nEnter array elements:");

        for (int i = 0; i < layers; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    arr[i][j][k] = input.nextInt();
                }
            }
        }

      
        System.out.println("\n3D Array:");

        for (int i = 0; i < layers; i++) {

            System.out.println("Layer " + (i + 1) + ":");

            for (int j = 0; j < rows; j++) {

                for (int k = 0; k < columns; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }

                System.out.println();
            }

            System.out.println();
        }

      
        int sum = 0;
        int max = arr[0][0][0];
        int min = arr[0][0][0];

        for (int i = 0; i < layers; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {

                    sum += arr[i][j][k];

                    if (arr[i][j][k] > max) {
                        max = arr[i][j][k];
                    }

                    if (arr[i][j][k] < min) {
                        min = arr[i][j][k];
                    }
                }
            }
        }

        int totalElements = layers * rows * columns;
        double average = (double) sum / totalElements;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);

       
        System.out.println("\nLayer Sums:");

        for (int i = 0; i < layers; i++) {

            int layerSum = 0;

            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    layerSum += arr[i][j][k];
                }
            }

            System.out.println("Layer " + (i + 1) + " = " + layerSum);
        }

        System.out.print("\nEnter value to search: ");
        int search = input.nextInt();

        boolean found = false;

        for (int i = 0; i < layers; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {

                    if (arr[i][j][k] == search) {

                        System.out.println(
                            "Value found at Layer " + (i + 1)
                            + ", Row " + (j + 1)
                            + ", Column " + (k + 1)
                        );

                        found = true;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("Value not found.");
        }

        input.close();
    }
}