/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment_1;

/**
 *
 * @author hp
 */
import java.util.Scanner;

public class FinTechTradingSystem {

    static Scanner input = new Scanner(System.in);

    // =========================
    // ASSET DATA
    // =========================

    static int[] assetId = {
        101, 102, 103, 104, 105,
        106, 107, 108, 109, 110
    };

    static String[] assetName = {
        "Apple", "Tesla", "Bitcoin", "Gold", "Microsoft",
        "Amazon", "Ethereum", "Silver", "Google", "Nvidia"
    };

    static String[] assetType = {
        "Stock", "Stock", "Crypto", "Commodity", "Stock",
        "Stock", "Crypto", "Commodity", "Stock", "Stock"
    };

    static double[] price = {
        220.50, 250.75, 65000.00, 2650.50, 430.25,
        195.60, 3500.00, 31.50, 175.80, 140.25
    };

    static double[] percentageChange = {
        2.5, -1.2, 3.1, 0.8, 1.4,
        -0.5, 2.7, 1.1, 0.6, 4.2
    };

   
    // WATCHLIST 
    

    static class Node {
        int assetId;
        Node next;

        Node(int assetId) {
            this.assetId = assetId;
            this.next = null;
        }
    }

    static Node head = null;

    
    // STACK
    static String[] stack = new String[5];
    static int top = -1;

    // QUEUE
    static String[] queue = new String[5];
    static int front = 0;
    static int rear = -1;

    // MAIN
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("       FINTECH TRADING SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Manage Market Assets");
            System.out.println("2. Search Asset");
            System.out.println("3. Sort Market Assets");
            System.out.println("4. Manage Watchlist");
            System.out.println("5. Calculate Portfolio Value");
            System.out.println("6. Manage Transactions");
            System.out.println("7. Manage Trading Orders");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    assetMenu();
                    break;

                case 2:
                    searchMenu();
                    break;

                case 3:
                    sortingMenu();
                    break;

                case 4:
                    watchlistMenu();
                    break;

                case 5:
                    portfolioMenu();
                    break;

                case 6:
                    stackMenu();
                    break;

                case 7:
                    queueMenu();
                    break;

                case 8:
                    System.out.println("\nProgram ended.");
                    break;

                default:
                    System.out.println("\nInvalid choice.");
            }

        } while (choice != 8);

        input.close();
    }

    // 1. MARKET ASSETS

    static void assetMenu() {

        int choice;

        do {

            System.out.println("\n---------- MARKET ASSETS ----------");
            System.out.println("1. Display All Assets");
            System.out.println("2. Average Price");
            System.out.println("3. Highest Price");
            System.out.println("4. Lowest Price");
            System.out.println("5. Back");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    displayAssets();
                    break;

                case 2:
                    averagePrice();
                    break;

                case 3:
                    highestPrice();
                    break;

                case 4:
                    lowestPrice();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }


    static void displayAssets() {

        System.out.println("\n================ MARKET ASSETS ================");

        System.out.printf("%-8s %-15s %-12s %-12s %-10s%n",
                "ID", "Name", "Type", "Price", "Change");

        for (int i = 0; i < assetId.length; i++) {

            System.out.printf("%-8d %-15s %-12s %-12.2f %-10.2f%%%n",
                    assetId[i],
                    assetName[i],
                    assetType[i],
                    price[i],
                    percentageChange[i]);
        }
    }


    static void averagePrice() {

        double sum = 0;

        for (int i = 0; i < price.length; i++) {
            sum = sum + price[i];
        }

        double average = sum / price.length;

        System.out.println("\nAverage Price: " + average);
    }



    static void highestPrice() {

        int index = 0;

        for (int i = 1; i < price.length; i++) {

            if (price[i] > price[index]) {
                index = i;
            }
        }

        System.out.println("\nHighest Priced Asset:");

        displayOneAsset(index);
    }


    static void lowestPrice() {

        int index = 0;

        for (int i = 1; i < price.length; i++) {

            if (price[i] < price[index]) {
                index = i;
            }
        }

        System.out.println("\nLowest Priced Asset:");

        displayOneAsset(index);
    }

    static void displayOneAsset(int index) {

        System.out.printf("%-8d %-15s %-12s %-12.2f %-10.2f%%%n",
                assetId[index],
                assetName[index],
                assetType[index],
                price[index],
                percentageChange[index]);
    }

    // 2. SEARCHING


    static void searchMenu() {

        System.out.println("\n---------- SEARCH ASSET ----------");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");

        System.out.print("Enter choice: ");
        int choice = input.nextInt();

        System.out.print("Enter Asset ID: ");
        int id = input.nextInt();

        if (choice == 1) {

            linearSearch(id);

        } else if (choice == 2) {

            binarySearch(id);

        } else {

            System.out.println("Invalid choice.");
        }
    }

    // Linear Search

    static void linearSearch(int id) {

        boolean found = false;

        for (int i = 0; i < assetId.length; i++) {

            if (assetId[i] == id) {

                System.out.println("\nAsset Found:");
                displayOneAsset(i);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nAsset not found.");
        }
    }

    // Binary Search

    static void binarySearch(int id) {

     

        int[] ids = new int[assetId.length];

        for (int i = 0; i < assetId.length; i++) {
            ids[i] = assetId[i];
        }

     
        for (int i = 0; i < ids.length - 1; i++) {

            for (int j = 0; j < ids.length - i - 1; j++) {

                if (ids[j] > ids[j + 1]) {

                    int temp = ids[j];
                    ids[j] = ids[j + 1];
                    ids[j + 1] = temp;
                }
            }
        }

        int low = 0;
        int high = ids.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            System.out.println(
                    "Low = " + low +
                    " High = " + high +
                    " Mid = " + mid
            );

            if (ids[mid] == id) {

                System.out.println("\nAsset Found:");

                for (int i = 0; i < assetId.length; i++) {

                    if (assetId[i] == id) {
                        displayOneAsset(i);
                        break;
                    }
                }

                return;
            }

            if (ids[mid] < id) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        System.out.println("\nAsset not found.");
    }

    // 3. SORTING
  

    static void sortingMenu() {

        System.out.println("\n---------- SORT MARKET ASSETS ----------");

        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");

        System.out.print("Enter choice: ");
        int choice = input.nextInt();



        int[] ids = assetId.clone();
        String[] names = assetName.clone();
        String[] types = assetType.clone();
        double[] prices = price.clone();
        double[] changes = percentageChange.clone();

        if (choice == 1) {

            bubbleSort(ids, names, types, prices, changes);
            System.out.println("\nBubble Sort completed.");

        } else if (choice == 2) {

            selectionSort(ids, names, types, prices, changes);
            System.out.println("\nSelection Sort completed.");

        } else if (choice == 3) {

            insertionSort(ids, names, types, prices, changes);
            System.out.println("\nInsertion Sort completed.");

        } else if (choice == 4) {

            mergeSort(ids, names, types, prices, changes, 0, prices.length - 1);
            System.out.println("\nMerge Sort completed.");

        } else if (choice == 5) {

            quickSort(ids, names, types, prices, changes, 0, prices.length - 1);
            System.out.println("\nQuick Sort completed.");

        } else {

            System.out.println("Invalid choice.");
            return;
        }

        displaySortedAssets(ids, names, types, prices, changes);
    }

    // Bubble Sort

    static void bubbleSort(int[] ids, String[] names,
            String[] types, double[] prices, double[] changes) {

        for (int i = 0; i < prices.length - 1; i++) {

            for (int j = 0; j < prices.length - i - 1; j++) {

                if (prices[j] > prices[j + 1]) {

                    swapAll(ids, names, types, prices, changes, j, j + 1);
                }
            }
        }
    }

    // Selection Sort

    static void selectionSort(int[] ids, String[] names,
            String[] types, double[] prices, double[] changes) {

        for (int i = 0; i < prices.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < prices.length; j++) {

                if (prices[j] < prices[min]) {
                    min = j;
                }
            }

            swapAll(ids, names, types, prices, changes, i, min);
        }
    }

    // Insertion Sort

    static void insertionSort(int[] ids, String[] names,
            String[] types, double[] prices, double[] changes) {

        for (int i = 1; i < prices.length; i++) {

            double priceKey = prices[i];
            int idKey = ids[i];
            String nameKey = names[i];
            String typeKey = types[i];
            double changeKey = changes[i];

            int j = i - 1;

            while (j >= 0 && prices[j] > priceKey) {

                prices[j + 1] = prices[j];
                ids[j + 1] = ids[j];
                names[j + 1] = names[j];
                types[j + 1] = types[j];
                changes[j + 1] = changes[j];

                j--;
            }

            prices[j + 1] = priceKey;
            ids[j + 1] = idKey;
            names[j + 1] = nameKey;
            types[j + 1] = typeKey;
            changes[j + 1] = changeKey;
        }
    }

    // Merge Sort

    static void mergeSort(int[] ids, String[] names,
            String[] types, double[] prices, double[] changes,
            int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(ids, names, types, prices, changes, left, mid);

            mergeSort(ids, names, types, prices, changes, mid + 1, right);

            merge(ids, names, types, prices, changes,
                    left, mid, right);
        }
    }

    static void merge(int[] ids, String[] names,
            String[] types, double[] prices, double[] changes,
            int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftId = new int[n1];
        int[] rightId = new int[n2];

        String[] leftName = new String[n1];
        String[] rightName = new String[n2];

        String[] leftType = new String[n1];
        String[] rightType = new String[n2];

        double[] leftPrice = new double[n1];
        double[] rightPrice = new double[n2];

        double[] leftChange = new double[n1];
        double[] rightChange = new double[n2];

        for (int i = 0; i < n1; i++) {

            leftId[i] = ids[left + i];
            leftName[i] = names[left + i];
            leftType[i] = types[left + i];
            leftPrice[i] = prices[left + i];
            leftChange[i] = changes[left + i];
        }

        for (int j = 0; j < n2; j++) {

            rightId[j] = ids[mid + 1 + j];
            rightName[j] = names[mid + 1 + j];
            rightType[j] = types[mid + 1 + j];
            rightPrice[j] = prices[mid + 1 + j];
            rightChange[j] = changes[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            if (leftPrice[i] <= rightPrice[j]) {

                ids[k] = leftId[i];
                names[k] = leftName[i];
                types[k] = leftType[i];
                prices[k] = leftPrice[i];
                changes[k] = leftChange[i];

                i++;

            } else {

                ids[k] = rightId[j];
                names[k] = rightName[j];
                types[k] = rightType[j];
                prices[k] = rightPrice[j];
                changes[k] = rightChange[j];

                j++;
            }

            k++;
        }

        while (i < n1) {

            ids[k] = leftId[i];
            names[k] = leftName[i];
            types[k] = leftType[i];
            prices[k] = leftPrice[i];
            changes[k] = leftChange[i];

            i++;
            k++;
        }

        while (j < n2) {

            ids[k] = rightId[j];
            names[k] = rightName[j];
            types[k] = rightType[j];
            prices[k] = rightPrice[j];
            changes[k] = rightChange[j];

            j++;
            k++;
        }
    }

    // Quick Sort

    static void quickSort(int[] ids, String[] names,
            String[] types, double[] prices, double[] changes,
            int low, int high) {

        if (low < high) {

            int pivot = partition(
                    ids, names, types, prices, changes,
                    low, high
            );

            quickSort(
                    ids, names, types, prices, changes,
                    low, pivot - 1
            );

            quickSort(
                    ids, names, types, prices, changes,
                    pivot + 1, high
            );
        }
    }

    static int partition(int[] ids, String[] names,
            String[] types, double[] prices, double[] changes,
            int low, int high) {

        double pivot = prices[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (prices[j] <= pivot) {

                i++;

                swapAll(
                        ids, names, types, prices, changes,
                        i, j
                );
            }
        }

        swapAll(
                ids, names, types, prices, changes,
                i + 1, high
        );

        return i + 1;
    }

    static void swapAll(int[] ids, String[] names,
            String[] types, double[] prices, double[] changes,
            int i, int j) {

        int tempId = ids[i];
        ids[i] = ids[j];
        ids[j] = tempId;

        String tempName = names[i];
        names[i] = names[j];
        names[j] = tempName;

        String tempType = types[i];
        types[i] = types[j];
        types[j] = tempType;

        double tempPrice = prices[i];
        prices[i] = prices[j];
        prices[j] = tempPrice;

        double tempChange = changes[i];
        changes[i] = changes[j];
        changes[j] = tempChange;
    }

    static void displaySortedAssets(int[] ids,
            String[] names, String[] types,
            double[] prices, double[] changes) {

        System.out.println("\n========== SORTED ASSETS ==========");

        System.out.printf("%-8s %-15s %-12s %-12s %-10s%n",
                "ID", "Name", "Type", "Price", "Change");

        for (int i = 0; i < ids.length; i++) {

            System.out.printf(
                    "%-8d %-15s %-12s %-12.2f %-10.2f%%%n",
                    ids[i],
                    names[i],
                    types[i],
                    prices[i],
                    changes[i]
            );
        }
    }

    // 4. WATCHLIST - SINGLY LINKED LIST
  

    static void watchlistMenu() {

        int choice;

        do {

            System.out.println("\n---------- WATCHLIST ----------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Back");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Asset ID: ");
                    int insertId = input.nextInt();

                    insertWatchlist(insertId);
                    break;

                case 2:

                    System.out.print("Enter Asset ID: ");
                    int deleteId = input.nextInt();

                    deleteWatchlist(deleteId);
                    break;

                case 3:

                    System.out.print("Enter Asset ID: ");
                    int searchId = input.nextInt();

                    searchWatchlist(searchId);
                    break;

                case 4:

                    displayWatchlist();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    static void insertWatchlist(int id) {

        Node newNode = new Node(id);

        if (head == null) {

            head = newNode;

        } else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Asset added to watchlist.");
    }

    static void deleteWatchlist(int id) {

        if (head == null) {

            System.out.println("Watchlist is empty.");
            return;
        }

        if (head.assetId == id) {

            head = head.next;

            System.out.println("Asset deleted.");
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.assetId == id) {

                current.next = current.next.next;

                System.out.println("Asset deleted.");
                return;
            }

            current = current.next;
        }

        System.out.println("Asset not found.");
    }

    static void searchWatchlist(int id) {

        Node current = head;

        while (current != null) {

            if (current.assetId == id) {

                System.out.println("Asset found in watchlist.");
                return;
            }

            current = current.next;
        }

        System.out.println("Asset not found.");
    }

    static void displayWatchlist() {

        if (head == null) {

            System.out.println("Watchlist is empty.");
            return;
        }

        Node current = head;

        System.out.println("\n========== WATCHLIST ==========");

        while (current != null) {

            System.out.print(current.assetId + " -> ");

            current = current.next;
        }

        System.out.println("NULL");
    }

    // 5. RECURSION - PORTFOLIO
 

    static int[] portfolioIds = {101, 103, 105};
    static int[] quantity = {5, 2, 10};
    static double[] portfolioPrices = {
        220.50, 65000.00, 430.25
    };

    static void portfolioMenu() {

        System.out.println("\n========== PORTFOLIO ==========");

        displayPortfolio(0);

        double total = calculatePortfolioValue(0);

        System.out.println("\nTotal Portfolio Value: " + total);
    }

    // Recursive display

    static void displayPortfolio(int index) {

        // Base Case

        if (index == portfolioIds.length) {
            return;
        }

        System.out.println(
                "Asset ID: " + portfolioIds[index]
                + " | Quantity: " + quantity[index]
                + " | Price: " + portfolioPrices[index]
        );

        // Recursive Case

        displayPortfolio(index + 1);
    }

    // Recursive calculation

    static double calculatePortfolioValue(int index) {

        // Base Case

        if (index == portfolioIds.length) {
            return 0;
        }

        // Recursive Case

        return quantity[index] * portfolioPrices[index]
                + calculatePortfolioValue(index + 1);
    }

    // 6. STACK - TRANSACTIONS


    static void stackMenu() {

        int choice;

        do {

            System.out.println("\n---------- TRANSACTIONS ----------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Back");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter transaction: ");
                    String transaction = input.nextLine();

                    push(transaction);
                    break;

                case 2:

                    pop();
                    break;

                case 3:

                    peek();
                    break;

                case 4:

                    displayStack();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    // Push

    static void push(String transaction) {

        if (top == stack.length - 1) {

            System.out.println("Stack Overflow.");
            return;
        }

        top++;

        stack[top] = transaction;

        System.out.println("Transaction added.");
    }

    // Pop

    static void pop() {

        if (top == -1) {

            System.out.println("Stack Underflow.");
            return;
        }

        System.out.println("Removed: " + stack[top]);

        top--;
    }

    // Peek

    static void peek() {

        if (top == -1) {

            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Top Transaction: " + stack[top]);
    }

    // Display

    static void displayStack() {

        if (top == -1) {

            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("\n========== RECENT TRANSACTIONS ==========");

        for (int i = top; i >= 0; i--) {

            System.out.println(stack[i]);
        }
    }

    // 7. QUEUE - TRADING ORDERS
 

    static void queueMenu() {

        int choice;

        do {

            System.out.println("\n---------- TRADING ORDERS ----------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Back");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter trading order: ");
                    String order = input.nextLine();

                    enqueue(order);
                    break;

                case 2:

                    dequeue();
                    break;

                case 3:

                    queuePeek();
                    break;

                case 4:

                    displayQueue();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    // Enqueue

    static void enqueue(String order) {

        if (rear == queue.length - 1) {

            System.out.println("Queue Overflow.");
            return;
        }

        rear++;

        queue[rear] = order;

        System.out.println("Order added.");
    }

    // Dequeue

    static void dequeue() {

        if (front > rear) {

            System.out.println("Queue Underflow.");
            return;
        }

        System.out.println(
                "Processed Order: " + queue[front]
        );

        front++;
    }

    // Peek

    static void queuePeek() {

        if (front > rear) {

            System.out.println("Queue is empty.");
            return;
        }

        System.out.println(
                "First Order: " + queue[front]
        );
    }

    // Display

    static void displayQueue() {

        if (front > rear) {

            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("\n========== TRADING ORDERS ==========");

        for (int i = front; i <= rear; i++) {

            System.out.println(queue[i]);
        }
    }
}