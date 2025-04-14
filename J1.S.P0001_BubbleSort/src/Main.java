
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
        Scanner sc = new Scanner(System.in);
        //1. Enter input
        int input = getInput();

        //2. generate random  integer in number range for each array element
        int[] array = generateArrayRandom(input);
        displayArray(array);
        //3. sort
        algorithmBubbleSort(array);
        //4. display
        System.out.println("Sorted array:");
        displayArray(array);
    }

    // function to check the input value
    public static int getInput() {
        System.out.println("Enter number array: ");
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                String s = sc.nextLine();
                if (s == null || s.isEmpty()) {
                    System.err.println("Please input field not allow blank!!!");
                    continue;
                }
                number = Integer.parseInt(s);
                if (number < 0) {
                    System.err.println("Input invalid, input a positive demical number");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please enter an interger number");
            }

        }
        return number;
    }

    //function generate random  integer in number range for each array element
    public static int[] generateArrayRandom(int input) {
        System.out.print("Unsorted array: ");
        int[] array = new int[input];
        Random rd = new Random();
        for (int i = 0; i < input; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }

    //function display array
    public static void displayArray(int[] array) {
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
    }

    private static void algorithmBubbleSort(int[] array) {
        int lengh = array.length;
        boolean swapped;
        for (int i = 0; i < lengh - 1; i++) {
            swapped = false;
            for (int j = 0; j < lengh - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;

                    //display the array after step of sort
                    System.out.println("Step " + (i + 1) + ":");
                    displayArray(array);
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
