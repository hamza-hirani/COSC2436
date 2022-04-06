/*
Hamza Hirani
COSC 2436
Program 3
*/

import java.util.Scanner;
import java.util.Random;

public class sorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create 10,000 random numbers from 0 to 100,000: ");
        Random rand = new Random();
        int upperBound = 100001;
        int[] numbers = new int[100000];

        for (int i = 0; i < 100000; ++i) {
            int newNum = rand.nextInt(upperBound);
            numbers[i] = newNum;
        }
        
        System.out.println("What is the method you want to sort (Selection, Insertion, Shell, Quit)?");
        String method = scanner.next();
        while (method != "Quit") {
            if (method == "Selection") {
                long startTime = System.nanoTime();
                selection(numbers, 10000);
                long stopTime = System.nanoTime();
                System.out.println("The time performance of selection sort is " + (stopTime - startTime));
                System.out.println("What is the method you want to sort (Selection, Insertion, Shell, Quit)?");
                method = scanner.nextLine();
            } else if (method == "Insertion") {
                long startTime = System.nanoTime();
                insertion(numbers);
                long stopTime = System.nanoTime();
                System.out.println("The time performance of insertion sort is " + (stopTime - startTime));
                System.out.println("What is the method you want to sort (Selection, Insertion, Shell, Quit)?");
                method = scanner.nextLine();
            } else if (method == "Shell") {
                long startTime = System.nanoTime();
                shell(numbers);
                long stopTime = System.nanoTime();
                System.out.println("The time performance of Shell sort is " + (stopTime - startTime));
                System.out.println("What is the method you want to sort (Selection, Insertion, Shell, Quit)?");
                method = scanner.nextLine();
            } else if (method == "Quit") {
                System.out.println("Goodbye.");
            }
        }
        scanner.close();
    }

    // selection sort algorithm
    public static void selection(int[] numbers, int amount) {

        for (int i = 0; i < amount - 1; ++i) {
            int index = 1;
            for (int j = i + 1; j < amount; j++) {
                if (numbers[j] < numbers[index]) {
                    min_idx = j;
                }
            int temp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = temp;
            }
        }
    }
    
    // insertion sort algorithm
    public static void insertion(int[] numbers) {
        int amount = numbers.length;
        for (int i = 1; i < amount; ++i) {
            int current = numbers[i];
            int j = 0;

            while (j >= 0 && numbers[j] > current) {
                numbers[j + 1] = numbers[j];
                --j;
            }
            numbers[j + 1] = current;
        }
    }

    // shell sort algorithm
    public static void shell(int[] numbers) {
        int amount = numbers.length;
        int halved = amount / 2;

        for (int space = halved; space > 0; space = space / 2) {
            for (int i = space; i < amount; ++i) {
                int temp = numbers[i];
                for (int j = i; j >= space && numbers[j - space] > temp; j -= space) {
                    numbers[j] = numbers[j - space];
                }
            }
        }
    }
}