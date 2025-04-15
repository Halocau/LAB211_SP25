/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Utility {

    private static Scanner sc = new Scanner(System.in);

    public static String getStringInput(String message) {
        //requied user enter input a positive number
        while (true) {
            System.out.println(message);
            String input = sc.nextLine();
            if (input == null || input.isEmpty()) {
                System.err.println("Input cannot allow empty");
                System.out.println("Enter again: ");
                continue;
            }
            return input;
        }
    }

    public static int getIntegerLimit(String message, String error, int min, int max) {
        //requied user enter input a positive number
        while (true) {
            String input = getStringInput(message);
            try {

                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.err.println("Input invalid. Input must be within range [" + min + "->" + max + "]");
                    System.out.println("Enter again: ");
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }

    public static String getStringName(String message, String error, String regex) {
        while (true) {
            String input = getStringInput(message);
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(error);
            }
        }
    }

    public static Date inputDateWithFormat(String message, String error, String regex) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        while (true) {
            String input = getStringInput(message);
            if (input.matches(regex)) {
                //check input date exist?
                if (isDateExist(input)) {
                    try {
                        return dateFormat.parse(input);
                    } catch (ParseException e) {
                        System.out.println("Date invalid");
                    }
                } else {
                    System.err.println("Date not exist !!");
                }
            } else {
                System.out.println(error);
            }
        }
    }

    private static boolean isDateExist(String inputDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(inputDate);
            //check parse success => date exist => return true
            return true;
        } catch (ParseException e) {
            //parse failed => date not exist => return false
            return false;
        }
    }

    public static double getDouble(String message, String error, double min, double max) {
        while (true) {
            String input = getStringInput(message);
            try {
                double number = Double.parseDouble(input);
                if (number < min || number > max) {
                    System.err.println("Input invalid. Input must be within range [" + min + "->" + max + "]");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

}
