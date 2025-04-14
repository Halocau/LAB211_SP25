
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        //1.enter input a positive decimal number
        int number = inputPositive();
        //2.generate random integer in number range input
        int[] array = generateRandom(number);
        //3.use algorithms bubblesort
        algorithmBubbleSort(array);
        //4. display array
        System.out.println("");
        System.out.println("Sorted array");
        displayArray(array);
    }

    //check input value
    public static int inputPositive() {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.println("Enter number of array: ");
                String input = sc.nextLine();
                if (input.isEmpty() || input == null) {
                    System.err.println("Input cannot be empty");
                    continue;
                }
                number = Integer.parseInt(input);
                if (number < 0) {
                    System.err.println("Input cannot < 0");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Input must a positive decimal number");
            }
        }
        return number;
    }

    //Create 1 array random
    //generate array random 
    public static int[] generateRandom(int number) {
        System.out.println("Unsorted array: ");
        int[] array = new int[number];
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(100);
            System.out.print(array[i]);
            if (i < number - 1) {
                System.out.print(", ");
            }
        }
        return array;
    }

    //function check value input a positive a decimal number 
    public static void algorithmBubbleSort(int[] array) {
        int length = array.length;
        boolean swap;
        for (int i = 0; i < length; i++) {
            swap = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //swap 2 element incorrect
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;
                    //display sort
                    System.out.println("");
                    System.out.println("Step " + (i + 1) + ": ");
                    displayArray(array);
                }
            }
            if (!swap) {
                break;
            }
            //arr = [6,5,1,2]
            /*
            i=0: 5 1 2 6
            i=1: 1 2 5 6
            i=2: 1 2 5 6
             */
        }
    }
    //function display array
    public static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
