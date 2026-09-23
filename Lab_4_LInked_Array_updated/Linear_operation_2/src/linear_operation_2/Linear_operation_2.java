/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linear_operation_2;

/**
 *
 * @author hp
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Linear_operation_2 {

    // Linear Search Method
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
// USER INPUT
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
// ARRAY DECLARATION
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100) + 1;
        }
        System.out.println("\nGenerated Array: " + Arrays.toString(numbers));
        System.out.print("Enter target value to search: ");
        int target = scanner.nextInt();
        int resultIndex = linearSearch(numbers, target);
        System.out.println("\n--- Linear Search Result ---");
        if (resultIndex != -1) {
            System.out.println("Target " + target + " found at index: " + resultIndex);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }

        scanner.close();
    }
}
